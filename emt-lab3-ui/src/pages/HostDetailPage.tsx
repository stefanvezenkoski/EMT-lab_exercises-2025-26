import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { getHostById } from '../api/hostApi';
import type {Host} from '../types';
import { Typography, Container, CircularProgress, Button } from '@mui/material';
import { Link } from 'react-router-dom';

const HostDetailPage = () => {
    const { id } = useParams();
    const [host, setHost] = useState<Host | null>(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if (id) {
            getHostById(Number(id))
                .then(res => setHost(res.data))
                .catch(console.error)
                .finally(() => setLoading(false));
        }
    }, [id]);

    if (loading) return <CircularProgress />;
    if (!host) return <Typography>Not found</Typography>;

    return (
        <Container>
            <Typography variant="h4">{host.name} {host.surname}</Typography>
            <Typography>Country: {host.country.name}</Typography>
            <Typography>Continent: {host.country.continent}</Typography>
            <Button variant="contained" component={Link} to="/hosts">Back</Button>
        </Container>
    );
};

export default HostDetailPage;