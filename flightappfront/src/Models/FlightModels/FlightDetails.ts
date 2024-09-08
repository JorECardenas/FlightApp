
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

    // airline: string;
    // flightNumber: string;
    // carrier: string;
    // aircraftType: string;

    fares: TravelerFare[];
    stops: FlightStop[];

    time: string;
}

export interface TravelerFare {
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
    fees: number | null;
    pricePerTraveler: number | null;

}