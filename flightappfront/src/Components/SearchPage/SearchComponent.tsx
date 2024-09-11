import { useNavigation } from "react-router-dom";
import SearchForm from "./SearchForm";
import { CircularProgress } from "@mui/material";



export default function SearchComponent() {

    const navigation = useNavigation()




    return (

        <div className="w-full flex flex-col gap-5 items-center bg-cyan text-black">


            {
                navigation.state === "loading" ? (
                    <div className="inset-0 z-10 absolute flex flex-row gap-5 justify-center items-center bg-semitrans">
                        <CircularProgress size={100}/>
                        <p className="text-2xl font-bold">Loading...</p>
                    </div>
                ) : <></>
            }



            <h1 className="text-5xl font-bold mt-5 mb-5">Flight search app</h1>

            <SearchForm/>


        </div>



        
    )



}