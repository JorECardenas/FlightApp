import { PriceInfo } from "../../Models/FlightModels/FlightDetails";

interface IProps {
    prices: PriceInfo
}

export default function PriceInfoComponent({prices}:IProps){

    const getMoneyString = (price: number) => {
        function currencyFormat(num:number) {
            return num.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
        }

        return "$" + currencyFormat(price) + " " + prices.currency;
    }

    return (
        <div className="p-4 flex flex-col border-2 rounded-md border-black gap-3 w-1/4 bg-white">
            <div>

                <h4 className="text-xl font-bold mb-2">Price Breakdown</h4>

                <p className="text-lg"><b>Base Price:</b> {getMoneyString(prices.basePrice)}</p>

                <p className="text-lg font-bold">Fees:</p>

                {prices.fees.map((fee, key) => (
                    <div className="p-2 border-l-2 border-black mb-2">
                        <p>Name: {fee.name}</p>
                        <p>Amount: {getMoneyString(fee.amount)}</p>
                    </div>
                ))}

                <p className="text-lg"><b>Total:</b> {getMoneyString(prices.totalPrice)}</p>

                </div>
                <div>
                    <h4 className="text-lg font-bold">Price per traveler</h4>

                    <div className="p-2 border-l-2 border-black mb-2">

                    <p><b>Base price:</b> {getMoneyString(prices.pricePerTraveler.basePrice)}</p>
                    <p><b>Fare type:</b> {prices.pricePerTraveler.fareOption}</p>
                    <p><b>Total price:</b> {getMoneyString(prices.pricePerTraveler.totalPrice)}</p>

                    </div>
                </div>


            </div>
    )


}