import { useEffect, useState } from 'react';
import { getAllHosts } from '../api/hostApi';
import type {Host} from '../types';

export const useHosts = () => {
    const [data, setData] = useState<Host[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        getAllHosts()
            .then(res => setData(res.data))
            .catch(err => setError(err.message))
            .finally(() => setLoading(false));
    }, []);

    return { data, loading, error };
};