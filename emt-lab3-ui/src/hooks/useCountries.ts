import { useEffect, useState } from 'react';
import { getAllCountries } from '../api/countryApi';
import type {Country} from '../types';

export const useCountries = () => {
    const [data, setData] = useState<Country[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        getAllCountries()
            .then(res => setData(res.data))
            .catch(err => setError(err.message))
            .finally(() => setLoading(false));
    }, []);

    return { data, loading, error };
};