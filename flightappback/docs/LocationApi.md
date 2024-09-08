# LocationApi

All URIs are relative to *https://test.api.amadeus.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAirportCity**](LocationApi.md#getAirportCity) | **GET** /reference-data/locations/{locationId} | Returns a specific airports or cities based on its id.
[**getAirportCitySearch**](LocationApi.md#getAirportCitySearch) | **GET** /reference-data/locations | Returns a list of airports and cities matching a given keyword.

<a name="getAirportCity"></a>
# **getAirportCity**
> Success1 getAirportCity(locationId)

Returns a specific airports or cities based on its id.

### Example
```java
// Import classes:
//import io.swagger.ApiException;
//import io.swagger.city.LocationApi;


LocationApi apiInstance = new LocationApi();
String locationId = "locationId_example"; // String | identifier of the location
try {
    Success1 result = apiInstance.getAirportCity(locationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationApi#getAirportCity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **locationId** | **String**| identifier of the location |

### Return type

[**Success1**](Success1.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/vnd.amadeus+json

<a name="getAirportCitySearch"></a>
# **getAirportCitySearch**
> Success getAirportCitySearch(subType, keyword, countryCode, pageLimit, pageOffset, sort, view)

Returns a list of airports and cities matching a given keyword.

### Example
```java
// Import classes:
//import io.swagger.ApiException;
//import io.swagger.city.LocationApi;


LocationApi apiInstance = new LocationApi();
List<String> subType = Arrays.asList("subType_example"); // List<String> | sub type of the location (AIRPORT and/or CITY)
String keyword = "keyword_example"; // String | keyword that should represent the start of a word in a city or airport name or code.   Supported charaters are: A-Za-z0-9./:-'()\"
String countryCode = "countryCode_example"; // String | Country code of the location using [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code format (e.g. US).
Integer pageLimit = 10; // Integer | maximum items in one page
Integer pageOffset = 0; // Integer | start index of the requested page
String sort = "analytics.travelers.score"; // String | defines on which attribute the sorting will be done: * analytics.travelers.score - sort by the number of travelers by airport or city, the airports and cities with the highest traffic are on top of the results 
String view = "FULL"; // String | select the level of information of the reply: * LIGHT - Gives only the IATACode, name, detailedName, cityName and countryName * FULL - Adds on top of the LIGHT information the timeZoneOffset, geocode, detailed address and travelers.score default option is FULL 
try {
    Success result = apiInstance.getAirportCitySearch(subType, keyword, countryCode, pageLimit, pageOffset, sort, view);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationApi#getAirportCitySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subType** | [**List&lt;String&gt;**](String.md)| sub type of the location (AIRPORT and/or CITY) | [enum: AIRPORT, CITY]
 **keyword** | **String**| keyword that should represent the start of a word in a city or airport name or code.   Supported charaters are: A-Za-z0-9./:-&#x27;()\&quot; |
 **countryCode** | **String**| Country code of the location using [ISO 3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) code format (e.g. US). | [optional]
 **pageLimit** | **Integer**| maximum items in one page | [optional] [default to 10]
 **pageOffset** | **Integer**| start index of the requested page | [optional] [default to 0]
 **sort** | **String**| defines on which attribute the sorting will be done: * analytics.travelers.score - sort by the number of travelers by airport or city, the airports and cities with the highest traffic are on top of the results  | [optional] [default to analytics.travelers.score] [enum: analytics.travelers.score]
 **view** | **String**| select the level of information of the reply: * LIGHT - Gives only the IATACode, name, detailedName, cityName and countryName * FULL - Adds on top of the LIGHT information the timeZoneOffset, geocode, detailed address and travelers.score default option is FULL  | [optional] [default to FULL] [enum: LIGHT, FULL]

### Return type

[**Success**](Success.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/vnd.amadeus+json

