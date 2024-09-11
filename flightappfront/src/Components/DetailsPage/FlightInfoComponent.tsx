import { FlightInfo, TravelerFare } from "../../Models/FlightModels/FlightDetails";
import dayjs from "dayjs";

interface IProps {
    flight: FlightInfo;
    fare: TravelerFare;
}


export default function FlightInfoComponent({ flight, fare }: IProps) {

    return (
        <div className="border-2 border-black rounded-md p-3 w-full flex flex-row gap-2 bg-white">

            <div className="p-3 w-3/4 flex flex-col justify-between">

                <div className="mb-2">
                    <p className="font-bold">{dayjs(flight.depDate).format("DD/MM/YYYY HH:mm")} - {dayjs(flight.arrDate).format("DD/MM/YYYY HH:mm")}</p>

                    <p>{flight.depAirport} - {flight.arrAirport}</p>
                </div>

                <div>


                    <p>{flight.carrier}</p>

                    <p>{flight.operatedBy !== null ? "Operated by: " + flight.operatedBy : ""}</p>

                    <p>Flight number: {flight.flightNumber}</p>


                </div>

            </div>

            <div className="border-l-2 border-black p-3 flex flex-col gap-2">
                <p className="text-lg font-bold mb-2">Fare details</p>

                <p><b>Cabin:</b> {fare.cabin}</p>

                {
                    fare.ammenities.length > 0 ? (
                        <>
                            <h5 className="text-md font-bold">Amenities:</h5>
                            {fare.ammenities.map((am, key) => (
                                <div key={key}>
                                    <p> - {am.name} {am.chargeable ? "(chargeable)" : "(not chargeable)"}</p>

                                </div>
                            ))}
                        </>
                    ) : <></>
                }


            </div>


        </div>
    )



}