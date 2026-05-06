import { Dialog, DialogTitle, DialogContent, DialogActions, Button, Typography } from '@mui/material';
import type {Accommodation} from '../types';

interface Props {
    open: boolean;
    accommodation: Accommodation | null;
    onClose: () => void;
}

const AccommodationDetailModal = ({ open, accommodation, onClose }: Props) => {
    if (!accommodation) return null;

    return (
        <Dialog open={open} onClose={onClose} maxWidth="sm" fullWidth>
            <DialogTitle>{accommodation.name}</DialogTitle>
            <DialogContent dividers>
                <Typography variant="body1"><strong>Category:</strong> {accommodation.category}</Typography>
                <Typography variant="body1"><strong>Condition:</strong> {accommodation.condition}</Typography>
                <Typography variant="body1"><strong>Rooms:</strong> {accommodation.numRooms}</Typography>
                <Typography variant="body1"><strong>Rented:</strong> {accommodation.rented ? 'Yes' : 'No'}</Typography>
                <Typography variant="body1"><strong>Host:</strong> {accommodation.host.name} {accommodation.host.surname}</Typography>
                <Typography variant="body1"><strong>Country:</strong> {accommodation.host.country.name}</Typography>
                {accommodation.rentedBy && (
                    <Typography variant="body1"><strong>Rented by:</strong> {accommodation.rentedBy.username}</Typography>
                )}
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose} color="primary">Close</Button>
            </DialogActions>
        </Dialog>
    );
};

export default AccommodationDetailModal;