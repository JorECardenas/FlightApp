# FareDetailsBySegment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalServices** | [**AdditionalServicesRequest**](AdditionalServicesRequest.md) |  |  [optional]
**allotmentDetails** | [**AllotmentDetails**](AllotmentDetails.md) |  |  [optional]
**brandedFare** | **String** | The name of the Fare Family corresponding to the fares. Only for the GDS provider and if the airline has fare families filled |  [optional]
**cabin** | [**TravelClass**](TravelClass.md) |  |  [optional]
**propertyClass** | **String** | The code of the booking class, a.k.a. class of service or Reservations/Booking Designator (RBD) |  [optional]
**fareBasis** | **String** | Fare basis specifying the rules of a fare. Usually, though not always, is composed of the booking class code followed by a set of letters and digits representing other characteristics of the ticket, such as refundability, minimum stay requirements, discounts or special promotional elements. |  [optional]
**includedCheckedBags** | [**BaggageAllowance**](BaggageAllowance.md) |  |  [optional]
**isAllotment** | **Boolean** | True if the corresponding booking class is in an allotment |  [optional]
**segmentId** | **String** | Id of the segment | 
**sliceDiceIndicator** | [**SliceDiceIndicator**](SliceDiceIndicator.md) |  |  [optional]
