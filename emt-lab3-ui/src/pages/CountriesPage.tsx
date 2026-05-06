import { useCountries } from '../hooks/useCountries';
import { Card, CardContent, Typography, CircularProgress, Box } from '@mui/material';
import { Link } from 'react-router-dom';

const CountriesPage = () => {
    const { data, loading, error } = useCountries();

    if (loading) return <CircularProgress />;
    if (error) return <Typography color="error">{error}</Typography>;

    return (
        <Box sx={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: 2 }}>
            {data.map(country => (
                <Card key={country.id}>
                    <CardContent>
                        <Typography variant="h5" component={Link} to={`/countries/${country.id}`}>
                            {country.name}
                        </Typography>
                        <Typography>Continent: {country.continent}</Typography>
                    </CardContent>
                </Card>
            ))}
        </Box>
    );
};

export default CountriesPage;