import { AppBar, Toolbar, Typography, Button, Box } from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';

const Header = () => {
    const navigate = useNavigate();
    const token = localStorage.getItem('jwt');
    const isLoggedIn = !!token;

    const handleLogout = () => {
        localStorage.removeItem('jwt');
        navigate('/login');
    };

    return (
        <AppBar position="static">
            <Toolbar>
                <Typography variant="h6" component={Link} to="/" sx={{ flexGrow: 1, textDecoration: 'none', color: 'white' }}>
                    EMT Lab3
                </Typography>
                <Box>
                    <Button color="inherit" component={Link} to="/accommodations">Accommodations</Button>
                    <Button color="inherit" component={Link} to="/hosts">Hosts</Button>
                    <Button color="inherit" component={Link} to="/countries">Countries</Button>
                    {isLoggedIn ? (
                        <Button color="inherit" onClick={handleLogout}>Logout</Button>
                    ) : (
                        <Button color="inherit" component={Link} to="/login">Login</Button>
                    )}
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default Header;