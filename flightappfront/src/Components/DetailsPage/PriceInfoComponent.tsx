import { PriceInfo } from "../../Models/FlightModels/FlightDetails";

interface IProps {
    prices: PriceInfo
}

export default function PriceInfoComponent({prices}:IProps){

    return (
        <div className="p-3 flex flex-col border border-black gap-2">
                <h4>Price Breakdown</h4>

                <p>Base Price: {prices.basePrice}</p>

                <p>Fees:</p>

                {prices.fees.map((fee, key) => (
                    <div>
                        <p>Name: {fee.name}</p>
                        <p>Amount: {fee.amount}</p>
                    </div>
                ))}

                <p>Total: {prices.totalPrice}</p>

            </div>
    )


}