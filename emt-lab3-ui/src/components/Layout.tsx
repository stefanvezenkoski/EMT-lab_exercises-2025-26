import { Outlet } from 'react-router-dom';
import Header from './Header';
import Footer from './Footer';
import { Container } from '@mui/material';

const Layout = () => {
    return (
        <>
            <Header />
            <Container component="main" sx={{ my: 4, minHeight: '80vh' }}>
                <Outlet />
            </Container>
            <Footer />
        </>
    );
};

export default Layout;