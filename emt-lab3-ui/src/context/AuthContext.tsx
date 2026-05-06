import { createContext, useState, useContext } from 'react';
import type { ReactNode } from 'react';
import { login as apiLogin, register as apiRegister } from '../api/authApi';

interface AuthContextType {
    token: string | null;
    login: (username: string, password: string) => Promise<void>;
    register: (username: string, password: string) => Promise<void>;
    logout: () => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider = ({ children }: { children: ReactNode }) => {
    const [token, setToken] = useState<string | null>(localStorage.getItem('jwt'));

    const login = async (username: string, password: string) => {
        const response = await apiLogin(username, password);
        const newToken = response.data.token;
        localStorage.setItem('jwt', newToken);
        setToken(newToken);
    };

    const register = async (username: string, password: string) => {
        await apiRegister(username, password);
    };

    const logout = () => {
        localStorage.removeItem('jwt');
        setToken(null);
    };

    return (
        <AuthContext.Provider value={{ token, login, register, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error('useAuth must be used within an AuthProvider');
    }
    return context;
};