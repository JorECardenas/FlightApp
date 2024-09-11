import { DatePicker, LocalizationProvider } from "@mui/x-date-pickers";
import { Dayjs } from "dayjs";
import { Form } from "react-router-dom";
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { useState } from "react";
import { Autocomplete, Checkbox, InputLabel, TextField } from "@mui/material";
import data from "../../Models/Data/airlineData.json"


export default function SearchForm() {

    const currencyOptions = ["USD", "MXN", "EUR"]

    const [depDate, setDepDate] = useState<Dayjs | undefined>(undefined)

    const [arrDate, setArrDate] = useState<Dayjs | undefined>(undefined)

    const [numAdults, setNum] = useState<number | undefined>(undefined)


    return (
        <LocalizationProvider dateAdapter={AdapterDayjs}>
            <Form
                method="get"
                action="/results"
                className="rounded  w-1/3 flex flex-col gap-2 p-3 bg-white"
            >

                <Autocomplete
                    disablePortal
                    options={data.codes}
                    renderInput={(params) => (
                        <TextField
                            {...params}
                            label="Departure Airport"
                            name="depAirport"
                            placeholder="Departure Airport"
                            required
                        />
                    )}
                />

                <Autocomplete
                    disablePortal
                    options={data.codes}
                    renderInput={(params) => (
                        <TextField
                            {...params}
                            label="Arrival Airport"
                            id={"arrAir"}
                            name="arrAirport"
                            placeholder="Arrival Airport"
                            required
                        />
                    )}
                />

                <DatePicker
                    label="Departure Date"
                    name="depDate"
                    format="DD-MM-YYYY"
                    value={depDate}
                    onChange={(newVal) => newVal && setDepDate(newVal)}
                    disablePast
                />

                <DatePicker
                    label="ArrivalDate"
                    name="arrDate"
                    format="DD-MM-YYYY"
                    minDate={depDate === undefined ? undefined : depDate.add(1, 'day')}
                    value={arrDate}
                    onChange={(newVal) => newVal && setArrDate(newVal)}
                    disablePast

                />

                <TextField
                    label="Number of adults"
                    name="numAdults"
                    type="number"
                    value={numAdults}
                    onChange={(newVal) => setNum(numAdults)}
                    error={(numAdults !== undefined && numAdults < 0)}
                    required
                />



                <Autocomplete
                    disablePortal
                    options={currencyOptions}
                    renderInput={(params) => (
                        <TextField
                            {...params}
                            label="Currency"
                            name="currency"
                            placeholder="Currency"
                            required
                        />
                    )}
                />

                <div className="flex flex-row w-full items-center justify-center">
                    <InputLabel htmlFor="nonstop">Non-stop</InputLabel>
                    <Checkbox
                        id="nonstop"
                        name="nonStop"
                    />

                </div>



                <button
                    type="submit"
                    className="rounded h-10 bg-blue text-white"
                >
                    Search
                </button>



            </Form>
        </LocalizationProvider>
    )



}