# OriginDestination

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**alternativeDestinationsCodes** | **List&lt;String&gt;** | Set of alternative destination location, such as a city or an airport. Currently, only the locations defined in [IATA](http://www.iata.org/publications/Pages/code-search.aspx) are supported. |  [optional]
**alternativeOriginsCodes** | **List&lt;String&gt;** | Set of alternative origin location, such as a city or an airport. Currently, only the locations defined in [IATA](http://www.iata.org/publications/Pages/code-search.aspx) are supported. |  [optional]
**arrivalDateTimeRange** | [**DateTimeRange**](DateTimeRange.md) |  |  [optional]
**departureDateTimeRange** | [**DateTimeRange**](DateTimeRange.md) |  |  [optional]
**destinationLocationCode** | **String** | Destination location, such as a city or an airport. Currently, only the locations defined in [IATA](http://www.iata.org/publications/Pages/code-search.aspx) are supported. |  [optional]
**destinationRadius** | [**BigDecimal**](BigDecimal.md) | Include other possible locations around the point, located less than this distance in kilometers away. Max:300  Can not be combined with \&quot;dateWindow\&quot; or \&quot;timeWindow\&quot;.  |  [optional]
**excludedConnectionPoints** | **List&lt;String&gt;** | List of excluded connections points. Any FlightOffer with these connections points will be present in response. Currently, only the locations defined in IATA are supported. Used only by the AMADEUS provider |  [optional]
**id** | **String** |  |  [optional]
**includedConnectionPoints** | **List&lt;String&gt;** | List of included connections points. When an includedViaPoints option is specified, all FlightOffer returned must at least go via this Connecting Point. Currently, only the locations defined in IATA are supported. Used only by the AMADEUS provider |  [optional]
**originLocationCode** | **String** | Origin location, such as a city or an airport. Currently, only the locations defined in [IATA](http://www.iata.org/publications/Pages/code-search.aspx) are supported. |  [optional]
**originRadius** | [**BigDecimal**](BigDecimal.md) | Include other possible locations around the point, located less than this distance in kilometers away. Max:300  Can not be combined with \&quot;dateWindow\&quot; or \&quot;timeWindow\&quot;.  |  [optional]
