import axiosInstance from './axiosInstance';
import type {Accommodation} from '../types';

export const getAllAccommodations = () =>
    axiosInstance.get<Accommodation[]>('/accommodations');

export const getAccommodationById = (id: number) =>
    axiosInstance.get<Accommodation>(`/accommodations/${id}`);

export const rentAccommodation = (id: number) =>
    axiosInstance.patch<Accommodation>(`/accommodations/${id}/rent`);

export const getMyAccommodations = () =>
    axiosInstance.get<Accommodation[]>('/accommodations/my-accommodations');

export const createAccommodation = (data: any) =>
    axiosInstance.post<Accommodation>('/accommodations', data);

export const updateAccommodation = (id: number, data: any) =>
    axiosInstance.put<Accommodation>(`/accommodations/${id}`, data);

export const deleteAccommodation = (id: number) =>
    axiosInstance.delete(`/accommodations/${id}`);