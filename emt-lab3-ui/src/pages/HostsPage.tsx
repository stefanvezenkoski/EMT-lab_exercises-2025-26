import { useHosts } from '../hooks/useHosts';
import { Card, CardContent, Typography, CircularProgress, Box } from '@mui/material';
import { Link } from 'react-router-dom';

const HostsPage = () => {
    const { data, loading, error } = useHosts();

    if (loading) return <CircularProgress />;
    if (error) return <Typography color="error">{error}</Typography>;

    return (
        <Box sx={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))', gap: 2 }}>
            {data.map(host => (
                <Card key={host.id}>
                    <CardContent>
                        <Typography variant="h5" component={Link} to={`/hosts/${host.id}`}>
                            {host.name} {host.surname}
                        </Typography>
                        <Typography>Country: {host.country.name}</Typography>
                    </CardContent>
                </Card>
            ))}
        </Box>
    );
};

export default HostsPage;