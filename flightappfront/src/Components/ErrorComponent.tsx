import { Button } from "@mui/material";
import { ErrorResponse, Link, NavLink, useRouteError } from "react-router-dom";

export default function ErrorComponent(){

    const error = useRouteError() as ErrorResponse;

    console.log(error)



    return (
        <div className="w-full h-full p-5 bg-cyan text-black flex flex-col items-center">
            <h2 className="text-5xl font-bold mt-5 mb-5">Sorry, something went wrong</h2>

            <p className="text-2xl mb-5">Plase try again with different parameters</p>

            <NavLink to={"/"}>
                <button className="rounded h-10 bg-blue text-white p-2 h-12 mb-5 text-2xl text-center">
                    Return to search
                </button>
            </NavLink>



        </div>
    )



}