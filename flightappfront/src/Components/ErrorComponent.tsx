import { Button } from "@mui/material";
import { ErrorResponse, Link, useRouteError } from "react-router-dom";

export default function ErrorComponent(){

    const error = useRouteError() as ErrorResponse;

    console.log(error)



    return (
        <div>
            <h2>Sorry, something went wrong</h2>

            <p>{JSON.stringify(error.data)}</p>



            <Link to={"/"}>
                <Button>Return to search</Button>
            </Link>



        </div>
    )



}