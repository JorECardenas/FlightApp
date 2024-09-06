# FlightOffer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**disablePricing** | **Boolean** | BOOK step ONLY - If true, allows to book a PNR without pricing. Only for the source \&quot;GDS\&quot; |  [optional]
**id** | **String** | Id of the flight offer | 
**instantTicketingRequired** | **Boolean** | If true, inform that a ticketing will be required at booking step. |  [optional]
**itineraries** | [**List&lt;Itineraries&gt;**](Itineraries.md) |  |  [optional]
**lastTicketingDate** | **String** | If booked on the same day as the search (with respect to timezone), this flight offer is guaranteed to be thereafter valid for ticketing until this date (included). Unspecified when it does not make sense for this flight offer (e.g. no control over ticketing once booked). YYYY-MM-DD format, e.g. 2019-06-07 |  [optional]
**nonHomogeneous** | **Boolean** | If true, upon completion of the booking, this pricing solution is expected to yield multiple records (a record contains booking information confirmed and stored, typically a Passenger Name Record (PNR), in the provider GDS or system) |  [optional]
**numberOfBookableSeats** | [**BigDecimal**](BigDecimal.md) | Number of seats bookable in a single request. Can not be higher than 9. |  [optional]
**oneWay** | **Boolean** | If true, the flight offer fulfills only one originDestination and has to be combined with other oneWays to complete the whole journey. |  [optional]
**paymentCardRequired** | **Boolean** | If true, a payment card is mandatory to book this flight offer |  [optional]
**price** | [**ExtendedPrice**](ExtendedPrice.md) |  |  [optional]
**pricingOptions** | [**PricingOptions**](PricingOptions.md) |  |  [optional]
**source** | [**FlightOfferSource**](FlightOfferSource.md) |  |  [optional]
**travelerPricings** | [**List&lt;TravelerPricing&gt;**](TravelerPricing.md) | Fare information for each traveler/segment |  [optional]
**type** | **String** | the resource name | 
**validatingAirlineCodes** | **List&lt;String&gt;** | This option ensures that the system will only consider these airlines. |  [optional]
