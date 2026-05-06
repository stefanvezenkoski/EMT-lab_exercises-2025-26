// Тип за User (делумен)
export interface User {
    id: number;
    username: string;
    role: string;
}

// Тип за Country
export interface Country {
    id: number;
    name: string;
    continent: string;
}

// Тип за Host
export interface Host {
    id: number;
    name: string;
    surname: string;
    country: Country;
    createdAt?: string;
    updatedAt?: string;
}

// Тип за Accommodation
export interface Accommodation {
    id: number;
    name: string;
    category: string;
    condition: string;
    numRooms: number;
    rented: boolean;
    host: Host;
    rentedBy?: User | null;
    createdAt?: string;
    updatedAt?: string;
}