# FlightSegment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**aircraft** | [**AircraftEquipment**](AircraftEquipment.md) |  |  [optional]
**arrival** | [**FlightEndPoint**](FlightEndPoint.md) |  |  [optional]
**carrierCode** | **String** | providing the airline / carrier code |  [optional]
**departure** | [**FlightEndPoint**](FlightEndPoint.md) |  |  [optional]
**duration** | **String** | stop duration in [ISO8601](https://en.wikipedia.org/wiki/ISO_8601) PnYnMnDTnHnMnS format, e.g. PT2H10M |  [optional]
**number** | **String** | the flight number as assigned by the carrier |  [optional]
**operating** | [**OperatingFlight**](OperatingFlight.md) |  |  [optional]
**stops** | [**List&lt;FlightStop&gt;**](FlightStop.md) | information regarding the different stops composing the flight segment. E.g. technical stop, change of gauge... |  [optional]
