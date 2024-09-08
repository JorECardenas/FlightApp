# Location

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | id of the ressource |  [optional]
**self** | [**Links**](Links.md) |  |  [optional]
**type** | **String** | the resource name |  [optional]
**subType** | [**SubTypeEnum**](#SubTypeEnum) | location sub type |  [optional]
**name** | **String** | short name of the location |  [optional]
**detailedName** | **String** | detailed name of the location. For a city location it contains city name and country code. For an airport location it contains city name; country code and airport full name |  [optional]
**timeZoneOffset** | **String** | timezone offset of the location at the date of the API call (including daylight saving time) |  [optional]
**iataCode** | **String** | IATA code of the location. ([IATA table codes](http://www.iata.org/publications/Pages/code-search.aspx) here) |  [optional]
**geoCode** | [**GeoCode**](GeoCode.md) |  |  [optional]
**address** | [**Address**](Address.md) |  |  [optional]
**distance** | [**Distance**](Distance.md) |  |  [optional]
**analytics** | [**Analytics**](Analytics.md) |  |  [optional]
**relevance** | **Double** | score value calculated based on distance and analytics |  [optional]
**category** | [**CategoryEnum**](#CategoryEnum) | category of the location |  [optional]
**tags** | **List&lt;String&gt;** | list of tags related to the location |  [optional]
**rank** | **String** | the rank is the position compared to other locations based on how famous is a place. 1 being the highest. |  [optional]

<a name="SubTypeEnum"></a>
## Enum: SubTypeEnum
Name | Value
---- | -----
AIRPORT | &quot;AIRPORT&quot;
CITY | &quot;CITY&quot;
POINT_OF_INTEREST | &quot;POINT_OF_INTEREST&quot;
DISTRICT | &quot;DISTRICT&quot;

<a name="CategoryEnum"></a>
## Enum: CategoryEnum
Name | Value
---- | -----
SIGHTS | &quot;SIGHTS&quot;
BEACH_PARK | &quot;BEACH_PARK&quot;
HISTORICAL | &quot;HISTORICAL&quot;
NIGHTLIFE | &quot;NIGHTLIFE&quot;
RESTAURANT | &quot;RESTAURANT&quot;
SHOPPING | &quot;SHOPPING&quot;
