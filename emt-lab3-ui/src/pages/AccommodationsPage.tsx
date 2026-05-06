import { useAccommodations } from '../hooks/useAccommodations';
import { Card, CardContent, Typography, CircularProgress, Button, Box, CardActions } from '@mui/material';
import { rentAccommodation } from '../api/accommodationApi';
import { useState } from 'react';
import AccommodationDetailModal from './AccommodationDetailModal';import type {Accommodation} from '../types';

const AccommodationsPage = () => {
    const { data, loading, error } = useAccommodations();
    const [updating, setUpdating] = useState<number | null>(null);
    const [selectedAccommodation, setSelectedAccommodation] = useState<Accommodation | null>(null);
    const [modalOpen, setModalOpen] = useState(false);

    const handleRent = async (id: number) => {
        setUpdating(id);
        try {
            await rentAccommodation(id);
            window.location.reload();
        } catch (err) {
            console.error(err);
        } finally {
            setUpdating(null);
        }
    };

    const handleOpenDetails = (acc: Accommodation) => {
        setSelectedAccommodation(acc);
        setModalOpen(true);
    };

    const handleCloseModal = () => {
        setModalOpen(false);
        setSelectedAccommodation(null);
    };

    if (loading) return <CircularProgress />;
    if (error) return <Typography color="error">{error}</Typography>;

    return (
        <>
            <Box sx={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: 2 }}>
                {data.map(acc => (
                    <Card key={acc.id}>
                        <CardContent>
                            <Typography variant="h5">{acc.name}</Typography>
                            <Typography>Category: {acc.category}</Typography>
                            <Typography>Rooms: {acc.numRooms}</Typography>
                            <Typography>Rented: {acc.rented ? 'Yes' : 'No'}</Typography>
                        </CardContent>
                        <CardActions>
                            <Button size="small" color="primary" onClick={() => handleOpenDetails(acc)}>
                                See Details
                            </Button>
                            {!acc.rented && (
                                <Button
                                    size="small"
                                    color="secondary"
                                    onClick={() => handleRent(acc.id)}
                                    disabled={updating === acc.id}
                                >
                                    Rent
                                </Button>
                            )}
                        </CardActions>
                    </Card>
                ))}
            </Box>
            <AccommodationDetailModal
                open={modalOpen}
                accommodation={selectedAccommodation}
                onClose={handleCloseModal}
            />
        </>
    );
};

export default AccommodationsPage;