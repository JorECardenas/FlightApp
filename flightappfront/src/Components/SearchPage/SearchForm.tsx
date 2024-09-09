import { DatePicker, LocalizationProvider } from "@mui/x-date-pickers";
import dayjs, { Dayjs } from "dayjs";
import { Form } from "react-router-dom";
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { useState } from "react";
import { Autocomplete, Button, Checkbox, InputLabel, TextField } from "@mui/material";
import data from "../../Models/Data/airlineData.json"


export default function SearchForm() {

    const currencyOptions = ["USD", "MXN", "EUR"]

    const [depDate, setDepDate] = useState<Dayjs>(dayjs())

    const [arrDate, setArrDate] = useState<Dayjs>(dayjs().add(1, 'day'))



    return (
        <LocalizationProvider dateAdapter={AdapterDayjs}>
            <Form method="get" action="/results" className="container flex flex-col gap-2 p-3">

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
                    minDate={depDate.add(1, 'day')}
                    value={arrDate}
                    onChange={(newVal) => newVal && setArrDate(newVal)}
                    disablePast
                />

                <TextField
                    label="Number of adults"
                    name="numAdults"
                    type="number"
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



                <Button type="submit">Search</Button>



            </Form>
        </LocalizationProvider>
    )



}