import { Typography, Container } from '@mui/material';

const HomePage = () => {
    return (
        <Container>
            <Typography variant="h3" gutterBottom>Welcome to Accommodation Rental</Typography>
            <Typography variant="body1">Find and rent accommodations from hosts around the world.</Typography>
        </Container>
    );
};

export default HomePage;