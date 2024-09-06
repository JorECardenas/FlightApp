# GetFlightOffersQuery

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currencyCode** | **String** | The currency code, as defined in [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217), to reflect the currency in which this amount is expressed. |  [optional]
**originDestinations** | [**List&lt;OriginDestination&gt;**](OriginDestination.md) | Origins and Destinations must be properly ordered in time (chronological order in accordance with the timezone of each location) to describe the journey consistently. Dates and times must not be past nor more than 365 days in the future, according to provider settings.Number of Origins and Destinations must not exceed the limit defined in provider settings. | 
**searchCriteria** | [**SearchCriteria**](SearchCriteria.md) |  |  [optional]
**sources** | [**List&lt;FlightOfferSource&gt;**](FlightOfferSource.md) | Allows enable one or more sources. If present in the list, these sources will be called by the system. | 
**travelers** | [**List&lt;Traveler&gt;**](Traveler.md) |  | 
