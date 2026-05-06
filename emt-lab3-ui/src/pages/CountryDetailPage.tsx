import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { getCountryById } from '../api/countryApi';
import type {Country} from '../types';
import { Typography, Container, CircularProgress, Button } from '@mui/material';
import { Link } from 'react-router-dom';

const CountryDetailPage = () => {
    const { id } = useParams();
    const [country, setCountry] = useState<Country | null>(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if (id) {
            getCountryById(Number(id))
                .then(res => setCountry(res.data))
                .catch(console.error)
                .finally(() => setLoading(false));
        }
    }, [id]);

    if (loading) return <CircularProgress />;
    if (!country) return <Typography>Not found</Typography>;

    return (
        <Container>
            <Typography variant="h4">{country.name}</Typography>
            <Typography>Continent: {country.continent}</Typography>
            <Button variant="contained" component={Link} to="/countries">Back</Button>
        </Container>
    );
};

export default CountryDetailPage;