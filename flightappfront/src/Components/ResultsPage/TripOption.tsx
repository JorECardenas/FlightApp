import { FlightDetails } from "../../Models/FlightModels/FlightDetails"
import SegmentInfoComponent from "./SegmentInfoComponent"

interface IProps {
    data: FlightDetails
}

export default function TripOption({data}:IProps ){

    return (
        <div className="w-full border border-black rounded p-5 flex flex-row gap-5">
            <div>
                {data.segments.map((seg, key) => (
                    <SegmentInfoComponent segment={seg} key={key} />
                ))}


            </div>

            <div>

                <p>${data.priceInfo.totalPrice} total</p>

                <p>${data.priceInfo.pricePerTraveler} per traveler</p>

            </div>

        </div>
    )

}