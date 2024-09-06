# ExtendedPrice

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalServices** | [**List&lt;AdditionalService&gt;**](AdditionalService.md) |  |  [optional]
**billingCurrency** | **String** | Currency of the payment. It may be different than the requested currency |  [optional]
**grandTotal** | **String** | Total amount paid by the user (including fees and selected additional services). |  [optional]
**margin** | **String** | BOOK step ONLY - The price margin percentage (plus or minus) that the booking can tolerate. When set to 0, then no price magin is tolerated. |  [optional]
**base** | **String** | Amount without taxes |  [optional]
**currency** | **String** |  |  [optional]
**fees** | [**List&lt;Fee&gt;**](Fee.md) | List of applicable fees |  [optional]
**refundableTaxes** | **String** | The amount of taxes which are refundable |  [optional]
**taxes** | [**List&lt;Tax&gt;**](Tax.md) |  |  [optional]
**total** | **String** | Total amount paid by the user |  [optional]
