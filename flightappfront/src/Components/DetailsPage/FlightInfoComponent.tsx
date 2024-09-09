import { FlightInfo, TravelerFare } from "../../Models/FlightModels/FlightDetails";
import dayjs from "dayjs";

interface IProps {
    flight: FlightInfo;
    fare: TravelerFare;
}


export default function FlightInfoComponent({ flight, fare }: IProps) {

    return (
        <div className="border border-black p-3 w-full flex flex-row gap-2">

            <div className="p-3">

                <p>{dayjs(flight.depDate).format("DD/MM/YYYY HH:mm")} - {dayjs(flight.arrDate).format("DD/MM/YYYY HH:mm")}</p>


                <p>{flight.depAirport} - {flight.arrAirport}</p>

                <p>{flight.carrier}</p>

            </div>

            <div className="border border-black p-3 flex flex-col ga-2">
                <h4>Fare details</h4>

                <p>Cabin: {fare.cabin}</p>

                <h5>Amenities</h5>
                {fare.ammenities.map((am, key) => (
                    <div key={key}>
                        <p>{am.name}</p>

                        <p>{am.chargeable ? "Is chargeable" : "Not chargeable"}</p>


                    </div>
                ))}




            </div>


        </div>
    )



}