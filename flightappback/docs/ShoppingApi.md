# ShoppingApi

All URIs are relative to *https://test.api.amadeus.com/v2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getFlightOffers**](ShoppingApi.md#getFlightOffers) | **GET** /shopping/flight-offers | Return list of Flight Offers based on searching criteria.
[**searchFlightOffers**](ShoppingApi.md#searchFlightOffers) | **POST** /shopping/flight-offers | Return list of Flight Offers based on posted searching criteria.

<a name="getFlightOffers"></a>
# **getFlightOffers**
> Success getFlightOffers(originLocationCode, destinationLocationCode, departureDate, adults, returnDate, children, infants, travelClass, includedAirlineCodes, excludedAirlineCodes, nonStop, currencyCode, maxPrice, max)

Return list of Flight Offers based on searching criteria.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShoppingApi;


ShoppingApi apiInstance = new ShoppingApi();
String originLocationCode = "originLocationCode_example"; // String | city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) from which the traveler will depart, e.g. BOS for Boston
String destinationLocationCode = "destinationLocationCode_example"; // String | city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) to which the traveler is going, e.g. PAR for Paris
LocalDate departureDate = new LocalDate(); // LocalDate | the date on which the traveler will depart from the origin to go to the destination. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2017-12-25
Integer adults = 1; // Integer | the number of adult travelers (age 12 or older on date of departure).
LocalDate returnDate = new LocalDate(); // LocalDate | the date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, only one-way itineraries are found. If this parameter is specified, only round-trip itineraries are found. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2018-02-28
Integer children = 56; // Integer | the number of child travelers (older than age 2 and younger than age 12 on date of departure) who will each have their own separate seat. If specified, this number should be greater than or equal to 0
Integer infants = 56; // Integer | the number of infant travelers (whose age is less or equal to 2 on date of departure). Infants travel on the lap of an adult traveler, and thus the number of infants must not exceed the number of adults. If specified, this number should be greater than or equal to 0
String travelClass = "travelClass_example"; // String | most of the flight time should be spent in a cabin of this quality or higher. The accepted travel class is economy, premium economy, business or first class. If no travel class is specified, the search considers any travel class
String includedAirlineCodes = "includedAirlineCodes_example"; // String | This option ensures that the system will only consider these airlines. This can not be cumulated with parameter excludedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X 
String excludedAirlineCodes = "excludedAirlineCodes_example"; // String | This option ensures that the system will ignore these airlines. This can not be cumulated with parameter includedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X 
Boolean nonStop = false; // Boolean | if set to true, the search will find only flights going from the origin to the destination with no stop in between
String currencyCode = "currencyCode_example"; // String | the preferred currency for the flight offers. Currency is specified in the [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) format, e.g. EUR for Euro
Integer maxPrice = 56; // Integer | maximum price per traveler. By default, no limit is applied. If specified, the value should be a positive number with no decimals
Integer max = 250; // Integer | maximum number of flight offers to return. If specified, the value should be greater than or equal to 1
try {
    Success result = apiInstance.getFlightOffers(originLocationCode, destinationLocationCode, departureDate, adults, returnDate, children, infants, travelClass, includedAirlineCodes, excludedAirlineCodes, nonStop, currencyCode, maxPrice, max);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShoppingApi#getFlightOffers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **originLocationCode** | **String**| city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) from which the traveler will depart, e.g. BOS for Boston |
 **destinationLocationCode** | **String**| city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) to which the traveler is going, e.g. PAR for Paris |
 **departureDate** | **LocalDate**| the date on which the traveler will depart from the origin to go to the destination. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2017-12-25 |
 **adults** | **Integer**| the number of adult travelers (age 12 or older on date of departure). | [default to 1] [enum: ]
 **returnDate** | **LocalDate**| the date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, only one-way itineraries are found. If this parameter is specified, only round-trip itineraries are found. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2018-02-28 | [optional]
 **children** | **Integer**| the number of child travelers (older than age 2 and younger than age 12 on date of departure) who will each have their own separate seat. If specified, this number should be greater than or equal to 0 | [optional] [enum: ]
 **infants** | **Integer**| the number of infant travelers (whose age is less or equal to 2 on date of departure). Infants travel on the lap of an adult traveler, and thus the number of infants must not exceed the number of adults. If specified, this number should be greater than or equal to 0 | [optional] [enum: ]
 **travelClass** | **String**| most of the flight time should be spent in a cabin of this quality or higher. The accepted travel class is economy, premium economy, business or first class. If no travel class is specified, the search considers any travel class | [optional] [enum: ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST]
 **includedAirlineCodes** | **String**| This option ensures that the system will only consider these airlines. This can not be cumulated with parameter excludedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  | [optional]
 **excludedAirlineCodes** | **String**| This option ensures that the system will ignore these airlines. This can not be cumulated with parameter includedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  | [optional]
 **nonStop** | **Boolean**| if set to true, the search will find only flights going from the origin to the destination with no stop in between | [optional] [default to false]
 **currencyCode** | **String**| the preferred currency for the flight offers. Currency is specified in the [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) format, e.g. EUR for Euro | [optional]
 **maxPrice** | **Integer**| maximum price per traveler. By default, no limit is applied. If specified, the value should be a positive number with no decimals | [optional] [enum: ]
 **max** | **Integer**| maximum number of flight offers to return. If specified, the value should be greater than or equal to 1 | [optional] [default to 250] [enum: ]

### Return type

[**Success**](Success.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/vnd.amadeus+json

<a name="searchFlightOffers"></a>
# **searchFlightOffers**
> Success1 searchFlightOffers(body, xHTTPMethodOverride)

Return list of Flight Offers based on posted searching criteria.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShoppingApi;


ShoppingApi apiInstance = new ShoppingApi();
GetFlightOffersQuery body = new GetFlightOffersQuery(); // GetFlightOffersQuery | list of criteria to retrieve a list of flight offers
String xHTTPMethodOverride = "GET"; // String | the HTTP method to apply
try {
    Success1 result = apiInstance.searchFlightOffers(body, xHTTPMethodOverride);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShoppingApi#searchFlightOffers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**GetFlightOffersQuery**](GetFlightOffersQuery.md)| list of criteria to retrieve a list of flight offers |
 **xHTTPMethodOverride** | **String**| the HTTP method to apply | [default to GET]

### Return type

[**Success1**](Success1.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/vnd.amadeus+json
 - **Accept**: application/vnd.amadeus+json

