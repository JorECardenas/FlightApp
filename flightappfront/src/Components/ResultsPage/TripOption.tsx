import { FlightDetails } from "../../Models/FlightModels/FlightDetails"
import SegmentInfoComponent from "./SegmentInfoComponent"

interface IProps {
    data: FlightDetails
}

export default function TripOption({data}:IProps ){

    const getMoneyString = (price: number) => {
        function currencyFormat(num:number) {
            return num.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
        }

        return "$" + currencyFormat(price) + " " + data.priceInfo.currency;
    }

    return (
        <div className="border-2 border-black rounded flex flex-row gap-5 bg-white h-fit">
            <div className="w-3/4 border-r border-dashed border-black">
                {data.segments.map((seg, key) => (
                    <SegmentInfoComponent segment={seg} key={key} />
                ))}


            </div>

            <div className="p-2">

                <p className="mb-5">{getMoneyString(data.priceInfo.totalPrice)} <br/> <b>Total</b></p>

                <p>{getMoneyString(data.priceInfo.pricePerTraveler.totalPrice)} <br/> <b>per traveler</b></p>

            </div>

        </div>
    )

}