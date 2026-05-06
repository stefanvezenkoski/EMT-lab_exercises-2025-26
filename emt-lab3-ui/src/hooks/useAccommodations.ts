import { useEffect, useState } from 'react';
import { getAllAccommodations } from '../api/accommodationApi';
import type {Accommodation} from '../types';

export const useAccommodations = () => {
    const [data, setData] = useState<Accommodation[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        getAllAccommodations()
            .then(res => setData(res.data))
            .catch(err => setError(err.message))
            .finally(() => setLoading(false));
    }, []);

    return { data, loading, error };
};