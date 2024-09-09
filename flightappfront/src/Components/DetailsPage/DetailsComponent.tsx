import { NavLink, useLocation, useNavigate } from "react-router-dom"
import { FlightDetails, TravelerFare } from "../../Models/FlightModels/FlightDetails";
import PriceInfoComponent from "./PriceInfoComponent";
import FlightInfoComponent from "./FlightInfoComponent";
import { Button } from "@mui/material";

interface ILocation {
    state: FlightDetails;
}

export default function DetailsComponent(){

    const { state }:ILocation = useLocation();

    const navigate = useNavigate()


    return (
        <div className="flex flex-row p-3">

            <Button onClick={() => navigate(-1)}>Return to results</Button>

            <div className="p-3 flex flex-col">

                {state.segments.map((seg, key) => (
                    <div key={key}>
                        <h2>Segment {key + 1}</h2>

                        {seg.flights.map((flight, key) => (
                            <FlightInfoComponent 
                                flight={flight}
                                fare={state.priceInfo.fares.filter(x => x.flightId === flight.id).pop() as TravelerFare}
                            />
                        ))}


                    </div>
                ))}



            </div>


            <PriceInfoComponent prices={state.priceInfo}/>


        </div>
    )





}