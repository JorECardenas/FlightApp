import { DatePicker, LocalizationProvider } from "@mui/x-date-pickers";
import dayjs, { Dayjs } from "dayjs";
import { Form } from "react-router-dom";
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { useState } from "react";
import { Checkbox, FilledInput, TextField } from "@mui/material";


export default function SearchComponent() {

    const [depDate, setDepDate] = useState<Dayjs>(dayjs())

    const [arrDate, setArrDate] = useState<Dayjs>(dayjs().add(1, 'day'))


    return (
        <LocalizationProvider dateAdapter={AdapterDayjs}>
            <Form>

                <TextField
                    name="DepAirport"
                    placeholder="Departure Airport"
                />

                <TextField
                    name="ArrAirport"
                    placeholder="Arrival Airport"
                />

                <DatePicker
                    name="depDate"
                    format="DD-MM-YYYY"
                    value={depDate}
                    onChange={(newVal) => newVal && setDepDate(newVal)}
                    disablePast
                />

                <DatePicker
                    name="arrDate"
                    format="DD-MM-YYYY"
                    minDate={depDate}
                    disablePast
                />

                <FilledInput
                    name="NumAdults"
                    type="number"
                />

                <TextField
                    name="Currency"
                    placeholder="Currency"
                />

                <Checkbox
                    name="NonStop"
                />




            </Form>
        </LocalizationProvider>
    )



}