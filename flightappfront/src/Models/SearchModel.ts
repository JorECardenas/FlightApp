import { FlightDetails } from "./FlightModels/FlightDetails"

export interface SearchParameters {
    DepAirport: string,
    ArrAirport: string,
    DepDate: Date,
    ArrDate: Date,
    NumAdults: number,
    Currency: string,
    NonStop: boolean
}

export interface SearchComponentData {
    DepAirport: string,
    ArrAirport: string,
    DepDate: string | null,
    ArrDate: string | null,
    NumAdults: string | null,
}

export interface LoaderData {
    data: FlightDetails[];
    search: SearchComponentData;
}

