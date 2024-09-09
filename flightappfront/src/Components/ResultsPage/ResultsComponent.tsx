import { useEffect } from "react";
import { NavLink, useActionData, Link } from "react-router-dom"
import TripOption from "./TripOption";
import { FlightDetails } from "../../Models/FlightModels/FlightDetails";




export default function ResultsComponent() {


    const data = useActionData() as FlightDetails[];

    useEffect(() => {
        console.log(data)
    }, [data])

    return (
        <div className="container">

            <NavLink to={"/"}>Return to search</NavLink>


            <div className="flex flex-col gap-3 p-4">

                {data.map((item: FlightDetails, key: number) => (
                    <Link to={"/details"} state={item} key={key}>
                        <TripOption data={item} key={key} />
                    </Link>
                ))}
            </div>
        </div>


    )

}