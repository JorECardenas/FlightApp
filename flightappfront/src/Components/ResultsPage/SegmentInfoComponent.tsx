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

    const getTimeString = (date: string): string=> {

        const formated = dayjs.duration(date)

        const h = Math.floor(formated.asHours())

        const m = Math.floor(formated.minutes())

        return (h > 0 ? h + " hours" : "") + " " + (m > 0 ? m + " min" : "")


    }


    return (

        <div className="flex flex-row gap-5 border border-black">

            <div>

                <p>{dayjs(segment.depDate).format("DD/MM/YYYY HH:mm")} - {dayjs(segment.arrDate).format("DD/MM/YYYY HH:mm")}</p>

                <p>{segment.depAirport + " - " + segment.arrAirport} </p>

                <p>{segment.carrier}</p>

            </div>

            <div>

                <p>{getTimeString(segment.time) + (segment.stops.length > 0 ? "( " + segment.stops.length + " stops)" : "")}</p>

                {segment.stops.map((stop, key) => (
                    <p key={key}>{getTimeString(stop.time)} in {stop.airport}</p>
                ))}



            </div>



        </div>

    )

}