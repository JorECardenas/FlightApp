import { useEffect } from "react";
import { NavLink, Link, useRouteLoaderData } from "react-router-dom"
import TripOption from "./TripOption";
import { FlightDetails } from "../../Models/FlightModels/FlightDetails";
import { Button } from "@mui/material";




export default function ResultsComponent() {


    const data = useRouteLoaderData("results") as FlightDetails[];

    useEffect(() => {
        console.log(data)
    }, [data])

    return (
        <div className="container">

            <NavLink to={"/"}><Button>Return to search</Button></NavLink>


            <div className="flex flex-col gap-3 p-4">

                {data.map((item: FlightDetails, key: number) => (
                    <Link to={{pathname: "/results/details"}} state={item} key={key}>
                        <TripOption data={item} key={key} />
                    </Link>
                ))}
            </div>
        </div>


    )

}