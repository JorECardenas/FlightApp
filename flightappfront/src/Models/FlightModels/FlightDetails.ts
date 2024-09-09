
export interface FlightDetails {
    id: string;
    segments: SegmentInfo[];
    priceInfo: PriceInfo;
}

export interface SegmentInfo {
    depDate: Date;
    arrDate: Date;

    depAirport: string;
    arrAirport: string;

    carrier: string;

    flights: FlightInfo[];

    stops: FlightStop[];

    time: string;
}

export interface FlightInfo {
    id: string;
    carrier: string;
    depDate: Date;
    arrDate: Date;
    depAirport: string;
    arrAirport: string;
    duration: string;
}

export interface TravelerFare {
    flightId: string;
    cabin: string;
    seatClass: string;
    ammenities: Ammenity[];
}

export interface Ammenity {
    name: string;
    chargeable: boolean;
}

export interface FlightStop {
    airport: string;
    time: string;
}


export interface PriceInfo {
    basePrice: number | null;
    totalPrice: number | null;
    fees: Fee[];
    pricePerTraveler: number | null;
    fares: TravelerFare[];

}

export interface Fee {
    name: string;
    amount: number | null;
}