# SearchCriteria

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addOneWayOffers** | **Boolean** | This option allows activate the one-way combinable feature |  [optional]
**additionalInformation** | [**AdditionalInformation**](AdditionalInformation.md) |  |  [optional]
**allowAlternativeFareOptions** | **Boolean** | This option allows to default to a standard fareOption if no offers are found for the selected fareOption. |  [optional]
**excludeAllotments** | **Boolean** | This option allows to exclude the isAllotment flag associated to a booking class in the search response when it exist. |  [optional]
**flightFilters** | [**FlightFilters**](FlightFilters.md) |  |  [optional]
**maxFlightOffers** | [**BigDecimal**](BigDecimal.md) | Maximum number of flight offers returned (Max 250) |  [optional]
**maxPrice** | **Integer** | maximum price per traveler. By default, no limit is applied. If specified, the value should be a positive number with no decimals |  [optional]
**oneFlightOfferPerDay** | **Boolean** | Requests the system to find at least one flight-offer per day, if possible, when a range of dates is specified. Default is false. |  [optional]
**pricingOptions** | [**ExtendedPricingOptions**](ExtendedPricingOptions.md) |  |  [optional]
