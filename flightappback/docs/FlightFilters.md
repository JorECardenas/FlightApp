# FlightFilters

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**busSegmentAllowed** | **Boolean** | This flag enable/disable filtering of bus segment |  [optional]
**cabinRestrictions** | [**List&lt;CabinRestriction&gt;**](CabinRestriction.md) | Restriction towards cabins. |  [optional]
**carrierRestrictions** | [**CarrierRestrictions**](CarrierRestrictions.md) |  |  [optional]
**connectionRestriction** | [**ConnectionRestriction**](ConnectionRestriction.md) |  |  [optional]
**crossBorderAllowed** | **Boolean** | Allows to search a location outside the borders when a radius around a location is specified. Default is false. |  [optional]
**maxFlightTime** | [**BigDecimal**](BigDecimal.md) | This option allows to modify the value for the Elapsed Flying Time (EFT) masterPricer option |  [optional]
**moreOvernightsAllowed** | **Boolean** | This flag enables/disables the possibility to have more overnight flights in Low Fare Search |  [optional]
**railSegmentAllowed** | **Boolean** | This flag enable/disable filtering of rail segment (TGV AIR, RAIL ...) |  [optional]
**returnToDepartureAirport** | **Boolean** | This option force to retrieve flight-offer with a departure and a return in the same airport |  [optional]
