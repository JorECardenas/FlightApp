import { useLocation, useNavigate } from "react-router-dom"
import { FlightDetails, TravelerFare } from "../../Models/FlightModels/FlightDetails";
import PriceInfoComponent from "./PriceInfoComponent";
import FlightInfoComponent from "./FlightInfoComponent";
import TripOption from "../ResultsPage/TripOption";

interface ILocation {
    state: FlightDetails;
}

export default function DetailsComponent() {

    const { state }: ILocation = useLocation();

    const navigate = useNavigate()


    return (
        <div className="p-3 w-full flex flex-col bg-cyan">

            <button className="rounded h-10 w-fit bg-blue text-white p-2 mb-3"
                onClick={() => navigate(-1)}
            >
                Return to results
            </button>

            <TripOption data={state} />

            <div className="flex flex-row p-3">



                <div className="flex flex-col w-3/4 pr-3">

                    {state.segments.map((seg, key) => (
                        <div key={key}>
                            <h2 className="text-lg mb-2 font-bold">Segment {key + 1}</h2>

                            <div className="flex flex-col gap-2">
                                {seg.flights.map((flight, key) => (
                                    <FlightInfoComponent
                                        flight={flight}
                                        fare={state.priceInfo.fares.filter(x => x.flightId === flight.id).pop() as TravelerFare}
                                    />
                                ))}
                            </div>
                        </div>
                    ))}
                </div>

                <PriceInfoComponent prices={state.priceInfo} />

            </div>
        </div>
    )





}