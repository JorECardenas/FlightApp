import dayjs from "dayjs";
import duration from "dayjs/plugin/duration"
import relativeTime from "dayjs/plugin/relativeTime"
import { SegmentInfo } from "../../Models/FlightModels/FlightDetails";


interface IProps {
    segment: SegmentInfo;
}

export default function SegmentInfoComponent({ segment }: IProps) {

    dayjs.extend(duration);
    dayjs.extend(relativeTime)

    const getTimeString = (date: string): string => {

        const formated = dayjs.duration(date)

        const h = Math.floor(formated.asHours())

        const m = Math.floor(formated.minutes())

        return (h > 0 ? h + " hours" : "") + " " + (m > 0 ? m + " min" : "")


    }


    return (

        <div className="container flex flex-row gap-5 p-3">

            <div className="w-1/2 flex flex-col justify-between">
                <div>

                    <p className="font-bold">{dayjs(segment.depDate).format("DD/MM/YYYY HH:mm")} - {dayjs(segment.arrDate).format("DD/MM/YYYY HH:mm")}</p>

                    <p>{segment.depAirport + " - " + segment.arrAirport} </p>
                </div>

                <p className="mt-5">{segment.carrier}</p>

            </div>

            <div className="w-1/2">

                <p className="font-bold mb-2">{getTimeString(segment.time) + (segment.stops.length > 0 ? " ( " + segment.stops.length + " stops)" : "")}</p>

                {segment.stops.map((stop, key) => (
                    <p key={key}>{getTimeString(stop.time)} in {stop.airport}</p>
                ))}



            </div>



        </div>

    )

}