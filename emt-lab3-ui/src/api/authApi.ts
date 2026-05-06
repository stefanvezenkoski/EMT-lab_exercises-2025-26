import axiosInstance from './axiosInstance';

export const login = (username: string, password: string) =>
    axiosInstance.post<{ token: string }>('/auth/login', { username, password });

export const register = (username: string, password: string) =>
    axiosInstance.post('/auth/register', { username, password });