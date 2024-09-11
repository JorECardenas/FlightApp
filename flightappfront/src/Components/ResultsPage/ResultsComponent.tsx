import { NavLink, Link, useRouteLoaderData } from "react-router-dom"
import TripOption from "./TripOption";
import { FlightDetails } from "../../Models/FlightModels/FlightDetails";
import { SearchComponentData } from "../../Models/SearchModel";
import React, { useEffect, useState } from "react";
import { Pagination } from "@mui/material";
import dayjs from "dayjs";
import duration from "dayjs/plugin/duration";
import relativeTime from "dayjs/plugin/relativeTime";


export default function ResultsComponent() {

    dayjs.extend(duration);
    dayjs.extend(relativeTime)
    const { data, search } = useRouteLoaderData("results") as { data: FlightDetails[], search: SearchComponentData };


    const [page, setPage] = useState<number>(1)

    const [paginatedData, setPaginatedData] = useState<FlightDetails[]>([])

    const [sortedData, setSortedData] = useState<FlightDetails[]>([])
    const [orderFilter, setOrderFilter] = useState({ priceASC: true, durASC: true, priceFirst: true })


    const handleSort = (data: FlightDetails[]) => {

        const sortPrice = (a: FlightDetails, b: FlightDetails) => {
            return orderFilter.priceASC ? a.priceInfo.totalPrice - b.priceInfo.totalPrice : b.priceInfo.totalPrice - a.priceInfo.totalPrice;
        }

        const sortDate = (a: FlightDetails, b: FlightDetails) => {

            let durA: number = 0;

            a.segments.forEach(e => {
                durA += dayjs.duration(e.time).asMilliseconds()
            });

            let durB: number = 0;

            b.segments.forEach(e => {
                durB += dayjs.duration(e.time).asMilliseconds()
            });

            return orderFilter.durASC ? durA - durB : durB - durA;



        }


        return data.sort((a: FlightDetails, b: FlightDetails): number => {
            let firstOrder = orderFilter.priceFirst ? sortPrice(a, b) : sortDate(a, b);
            let secondOrder = orderFilter.priceFirst ? sortDate(a, b) : sortPrice(a, b);

            return firstOrder !== 0 ? firstOrder : secondOrder;

        });



    }

    useEffect(() => {

        setSortedData(handleSort(data))

        let start = 10 * (page - 1)
        let end = Math.min(sortedData.length, start + 10)

        setPaginatedData(sortedData.slice(10 * (page - 1), (end)))

    }, [page, sortedData, orderFilter, data])


    if (data.length === 0) {

        return (
            <div className="w-ful h-full p-5 flex flex-col bg-cyan text-black items-center gap-3">

                <h1 className="text-5xl font-bold mt-5 mb-5">No flights were found</h1>



                <div className="text-xl bg-white border-2 border-black rounded-md p-3">

                    <p className="text-2xl mb-3 font-bold">No flight were found for this search:</p>


                    <p><b>Departure Airport:</b> {search.DepAirport}</p>
                    <p><b>Arrival Airport:</b> {search.ArrAirport}</p>

                    <p><b>Departure Date:</b> {search.DepDate}</p>

                    {
                        search.ArrDate !== "" ?
                            <p><b>Arrival Date:</b> {search.ArrDate}</p>
                            : <></>
                    }

                </div>
                <NavLink to={"/"}>
                    <button className="rounded h-14 bg-blue text-xl text-white p-3">
                        Return to search
                    </button>
                </NavLink>


            </div>
        )


    }

    return (
        <div className="w-full h-full p-5 bg-cyan text-black">

            <NavLink to={"/"}>
                <button className="rounded h-10 bg-blue text-white p-2">
                    Return to search
                </button>
            </NavLink>


            <div className="flex flex-col gap-3 mt-4">

                <div>
                    You searched for flights from <b>{search.DepAirport}</b> to <b>{search.ArrAirport}</b> for <b>{search.NumAdults} passengers</b>.
                </div>

                <div className="flex flex-col gap-2 p-3 bg-white border-2 border-black rounded-md">

                    <p>
                        Order by price
                        {
                            orderFilter.priceASC ?
                                (
                                    <button
                                        onClick={() => setOrderFilter({ ...orderFilter, priceASC: false })}
                                        className="rounded h-10 bg-blue text-white p-2 ml-2">
                                        ASC
                                    </button>
                                ) :
                                (
                                    <button
                                        onClick={() => setOrderFilter({ ...orderFilter, priceASC: true })}
                                        className="rounded h-10 bg-blue text-white p-2  ml-2">
                                        DESC
                                    </button>
                                )
                        }
                    </p>

                    <p>
                        Order by duration:
                        {
                            orderFilter.durASC ?
                                (
                                    <button
                                        onClick={() => setOrderFilter({ ...orderFilter, durASC: false })}
                                        className="rounded h-10 bg-blue text-white p-2 ml-2">
                                        ASC
                                    </button>
                                ) :
                                (
                                    <button
                                        onClick={() => setOrderFilter({ ...orderFilter, durASC: true })}
                                        className="rounded h-10 bg-blue text-white p-2  ml-2">
                                        DESC
                                    </button>
                                )
                        }
                    </p>

                    <p>
                        Sort by price or duration first:

                        {
                            orderFilter.priceFirst ?
                                (
                                    <button
                                        onClick={() => setOrderFilter({ ...orderFilter, priceFirst: false })}
                                        className="rounded h-10 bg-blue text-white p-2 ml-2">
                                        Price
                                    </button>
                                ) :
                                (
                                    <button
                                        onClick={() => setOrderFilter({ ...orderFilter, priceFirst: true })}
                                        className="rounded h-10 bg-blue text-white p-2  ml-2">
                                        Duration
                                    </button>
                                )
                        }

                    </p>



                </div>



                <Pagination
                    count={Math.ceil(data.length / 10)}
                    page={page}
                    onChange={(e, v) => setPage(v)}
                    size="large"
                    className="self-center"
                />



                {paginatedData.map((item: FlightDetails, key: number) => (
                    <Link to={{ pathname: "/results/details" }} state={item} key={key}>
                        <TripOption data={item} key={key} />
                    </Link>
                ))}
            </div>
        </div>


    )

}