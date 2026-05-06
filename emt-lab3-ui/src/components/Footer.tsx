import { Box, Typography } from '@mui/material';

const Footer = () => {
    return (
        <Box component="footer" sx={{ py: 3, textAlign: 'center', mt: 'auto', bgcolor: 'background.paper' }}>
            <Typography variant="body2" color="text.secondary">
                © {new Date().getFullYear()} EMT Lab3 - All rights reserved.
            </Typography>
        </Box>
    );
};

export default Footer;