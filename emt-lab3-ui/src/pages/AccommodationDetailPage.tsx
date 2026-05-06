import { useParams, Link } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { getAccommodationById } from '../api/accommodationApi';
import type {Accommodation} from '../types';
import { Typography, Container, CircularProgress, Button } from '@mui/material';

const AccommodationDetailPage = () => {
    const { id } = useParams<{ id: string }>();
    const [accommodation, setAccommodation] = useState<Accommodation | null>(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if (id) {
            getAccommodationById(Number(id))
                .then(res => setAccommodation(res.data))
                .catch(console.error)
                .finally(() => setLoading(false));
        }
    }, [id]);

    if (loading) return <CircularProgress />;
    if (!accommodation) return <Typography>Not found</Typography>;

    return (
        <Container>
            <Typography variant="h4">{accommodation.name}</Typography>
            <Typography>Category: {accommodation.category}</Typography>
            <Typography>Condition: {accommodation.condition}</Typography>
            <Typography>Rooms: {accommodation.numRooms}</Typography>
            <Typography>Rented: {accommodation.rented ? 'Yes' : 'No'}</Typography>
            <Typography>Host: <Link to={`/hosts/${accommodation.host.id}`}>{accommodation.host.name} {accommodation.host.surname}</Link></Typography>
            {accommodation.rentedBy && <Typography>Rented by: {accommodation.rentedBy.username}</Typography>}
            <Button variant="contained" color="primary" component={Link} to="/accommodations">Back</Button>
        </Container>
    );
};

export default AccommodationDetailPage;