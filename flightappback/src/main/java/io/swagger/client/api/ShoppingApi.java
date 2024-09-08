/*
 * Flight Offers Search
 *  Before using this API, we recommend you read our **[Authorization Guide](https://developers.amadeus.com/self-service/apis-docs/guides/authorization)** for more information on how to generate an access token.   Please also be aware that our test environment is based on a subset of the production, if you are not returning any results try with big cities/airports like LON (London) or NYC (New-York).
 *
 * OpenAPI spec version: 2.2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Error400;
import io.swagger.client.model.Error500;
import io.swagger.client.model.GetFlightOffersQuery;
import org.threeten.bp.LocalDate;
import io.swagger.client.model.Success;
import io.swagger.client.model.Success1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingApi {
    private ApiClient apiClient;
    private Map<String, String> headers;

    public ShoppingApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ShoppingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public void setHeadersOverrides(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Build call for getFlightOffers
     * @param originLocationCode city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) from which the traveler will depart, e.g. BOS for Boston (required)
     * @param destinationLocationCode city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) to which the traveler is going, e.g. PAR for Paris (required)
     * @param departureDate the date on which the traveler will depart from the origin to go to the destination. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2017-12-25 (required)
     * @param adults the number of adult travelers (age 12 or older on date of departure). (required)
     * @param returnDate the date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, only one-way itineraries are found. If this parameter is specified, only round-trip itineraries are found. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2018-02-28 (optional)
     * @param children the number of child travelers (older than age 2 and younger than age 12 on date of departure) who will each have their own separate seat. If specified, this number should be greater than or equal to 0 (optional)
     * @param infants the number of infant travelers (whose age is less or equal to 2 on date of departure). Infants travel on the lap of an adult traveler, and thus the number of infants must not exceed the number of adults. If specified, this number should be greater than or equal to 0 (optional)
     * @param travelClass most of the flight time should be spent in a cabin of this quality or higher. The accepted travel class is economy, premium economy, business or first class. If no travel class is specified, the search considers any travel class (optional)
     * @param includedAirlineCodes This option ensures that the system will only consider these airlines. This can not be cumulated with parameter excludedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  (optional)
     * @param excludedAirlineCodes This option ensures that the system will ignore these airlines. This can not be cumulated with parameter includedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  (optional)
     * @param nonStop if set to true, the search will find only flights going from the origin to the destination with no stop in between (optional, default to false)
     * @param currencyCode the preferred currency for the flight offers. Currency is specified in the [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) format, e.g. EUR for Euro (optional)
     * @param maxPrice maximum price per traveler. By default, no limit is applied. If specified, the value should be a positive number with no decimals (optional)
     * @param max maximum number of flight offers to return. If specified, the value should be greater than or equal to 1 (optional, default to 250)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getFlightOffersCall(String originLocationCode, String destinationLocationCode, LocalDate departureDate, Integer adults, LocalDate returnDate, Integer children, Integer infants, String travelClass, String includedAirlineCodes, String excludedAirlineCodes, Boolean nonStop, String currencyCode, Integer maxPrice, Integer max, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/shopping/flight-offers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (originLocationCode != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("originLocationCode", originLocationCode));
        if (destinationLocationCode != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("destinationLocationCode", destinationLocationCode));
        if (departureDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("departureDate", departureDate));
        if (returnDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("returnDate", returnDate));
        if (adults != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("adults", adults));
        if (children != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("children", children));
        if (infants != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("infants", infants));
        if (travelClass != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("travelClass", travelClass));
        if (includedAirlineCodes != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("includedAirlineCodes", includedAirlineCodes));
        if (excludedAirlineCodes != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("excludedAirlineCodes", excludedAirlineCodes));
        if (nonStop != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("nonStop", nonStop));
        if (currencyCode != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("currencyCode", currencyCode));
        if (maxPrice != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("maxPrice", maxPrice));
        if (max != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("max", max));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/vnd.amadeus+json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        if (headers != null) {
            localVarHeaderParams.putAll(headers);
        }
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFlightOffersValidateBeforeCall(String originLocationCode, String destinationLocationCode, LocalDate departureDate, Integer adults, LocalDate returnDate, Integer children, Integer infants, String travelClass, String includedAirlineCodes, String excludedAirlineCodes, Boolean nonStop, String currencyCode, Integer maxPrice, Integer max, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'originLocationCode' is set
        if (originLocationCode == null) {
            throw new ApiException("Missing the required parameter 'originLocationCode' when calling getFlightOffers(Async)");
        }
        // verify the required parameter 'destinationLocationCode' is set
        if (destinationLocationCode == null) {
            throw new ApiException("Missing the required parameter 'destinationLocationCode' when calling getFlightOffers(Async)");
        }
        // verify the required parameter 'departureDate' is set
        if (departureDate == null) {
            throw new ApiException("Missing the required parameter 'departureDate' when calling getFlightOffers(Async)");
        }
        // verify the required parameter 'adults' is set
        if (adults == null) {
            throw new ApiException("Missing the required parameter 'adults' when calling getFlightOffers(Async)");
        }
        
        com.squareup.okhttp.Call call = getFlightOffersCall(originLocationCode, destinationLocationCode, departureDate, adults, returnDate, children, infants, travelClass, includedAirlineCodes, excludedAirlineCodes, nonStop, currencyCode, maxPrice, max, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Return list of Flight Offers based on searching criteria.
     * 
     * @param originLocationCode city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) from which the traveler will depart, e.g. BOS for Boston (required)
     * @param destinationLocationCode city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) to which the traveler is going, e.g. PAR for Paris (required)
     * @param departureDate the date on which the traveler will depart from the origin to go to the destination. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2017-12-25 (required)
     * @param adults the number of adult travelers (age 12 or older on date of departure). (required)
     * @param returnDate the date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, only one-way itineraries are found. If this parameter is specified, only round-trip itineraries are found. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2018-02-28 (optional)
     * @param children the number of child travelers (older than age 2 and younger than age 12 on date of departure) who will each have their own separate seat. If specified, this number should be greater than or equal to 0 (optional)
     * @param infants the number of infant travelers (whose age is less or equal to 2 on date of departure). Infants travel on the lap of an adult traveler, and thus the number of infants must not exceed the number of adults. If specified, this number should be greater than or equal to 0 (optional)
     * @param travelClass most of the flight time should be spent in a cabin of this quality or higher. The accepted travel class is economy, premium economy, business or first class. If no travel class is specified, the search considers any travel class (optional)
     * @param includedAirlineCodes This option ensures that the system will only consider these airlines. This can not be cumulated with parameter excludedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  (optional)
     * @param excludedAirlineCodes This option ensures that the system will ignore these airlines. This can not be cumulated with parameter includedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  (optional)
     * @param nonStop if set to true, the search will find only flights going from the origin to the destination with no stop in between (optional, default to false)
     * @param currencyCode the preferred currency for the flight offers. Currency is specified in the [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) format, e.g. EUR for Euro (optional)
     * @param maxPrice maximum price per traveler. By default, no limit is applied. If specified, the value should be a positive number with no decimals (optional)
     * @param max maximum number of flight offers to return. If specified, the value should be greater than or equal to 1 (optional, default to 250)
     * @return Success
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Success getFlightOffers(String originLocationCode, String destinationLocationCode, LocalDate departureDate, Integer adults, LocalDate returnDate, Integer children, Integer infants, String travelClass, String includedAirlineCodes, String excludedAirlineCodes, Boolean nonStop, String currencyCode, Integer maxPrice, Integer max) throws ApiException {
        ApiResponse<Success> resp = getFlightOffersWithHttpInfo(originLocationCode, destinationLocationCode, departureDate, adults, returnDate, children, infants, travelClass, includedAirlineCodes, excludedAirlineCodes, nonStop, currencyCode, maxPrice, max);
        return resp.getData();
    }

    /**
     * Return list of Flight Offers based on searching criteria.
     * 
     * @param originLocationCode city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) from which the traveler will depart, e.g. BOS for Boston (required)
     * @param destinationLocationCode city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) to which the traveler is going, e.g. PAR for Paris (required)
     * @param departureDate the date on which the traveler will depart from the origin to go to the destination. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2017-12-25 (required)
     * @param adults the number of adult travelers (age 12 or older on date of departure). (required)
     * @param returnDate the date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, only one-way itineraries are found. If this parameter is specified, only round-trip itineraries are found. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2018-02-28 (optional)
     * @param children the number of child travelers (older than age 2 and younger than age 12 on date of departure) who will each have their own separate seat. If specified, this number should be greater than or equal to 0 (optional)
     * @param infants the number of infant travelers (whose age is less or equal to 2 on date of departure). Infants travel on the lap of an adult traveler, and thus the number of infants must not exceed the number of adults. If specified, this number should be greater than or equal to 0 (optional)
     * @param travelClass most of the flight time should be spent in a cabin of this quality or higher. The accepted travel class is economy, premium economy, business or first class. If no travel class is specified, the search considers any travel class (optional)
     * @param includedAirlineCodes This option ensures that the system will only consider these airlines. This can not be cumulated with parameter excludedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  (optional)
     * @param excludedAirlineCodes This option ensures that the system will ignore these airlines. This can not be cumulated with parameter includedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  (optional)
     * @param nonStop if set to true, the search will find only flights going from the origin to the destination with no stop in between (optional, default to false)
     * @param currencyCode the preferred currency for the flight offers. Currency is specified in the [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) format, e.g. EUR for Euro (optional)
     * @param maxPrice maximum price per traveler. By default, no limit is applied. If specified, the value should be a positive number with no decimals (optional)
     * @param max maximum number of flight offers to return. If specified, the value should be greater than or equal to 1 (optional, default to 250)
     * @return ApiResponse&lt;Success&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Success> getFlightOffersWithHttpInfo(String originLocationCode, String destinationLocationCode, LocalDate departureDate, Integer adults, LocalDate returnDate, Integer children, Integer infants, String travelClass, String includedAirlineCodes, String excludedAirlineCodes, Boolean nonStop, String currencyCode, Integer maxPrice, Integer max) throws ApiException {
        com.squareup.okhttp.Call call = getFlightOffersValidateBeforeCall(originLocationCode, destinationLocationCode, departureDate, adults, returnDate, children, infants, travelClass, includedAirlineCodes, excludedAirlineCodes, nonStop, currencyCode, maxPrice, max, null, null);
        Type localVarReturnType = new TypeToken<Success>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Return list of Flight Offers based on searching criteria. (asynchronously)
     * 
     * @param originLocationCode city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) from which the traveler will depart, e.g. BOS for Boston (required)
     * @param destinationLocationCode city/airport [IATA code](http://www.iata.org/publications/Pages/code-search.aspx) to which the traveler is going, e.g. PAR for Paris (required)
     * @param departureDate the date on which the traveler will depart from the origin to go to the destination. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2017-12-25 (required)
     * @param adults the number of adult travelers (age 12 or older on date of departure). (required)
     * @param returnDate the date on which the traveler will depart from the destination to return to the origin. If this parameter is not specified, only one-way itineraries are found. If this parameter is specified, only round-trip itineraries are found. Dates are specified in the [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) YYYY-MM-DD format, e.g. 2018-02-28 (optional)
     * @param children the number of child travelers (older than age 2 and younger than age 12 on date of departure) who will each have their own separate seat. If specified, this number should be greater than or equal to 0 (optional)
     * @param infants the number of infant travelers (whose age is less or equal to 2 on date of departure). Infants travel on the lap of an adult traveler, and thus the number of infants must not exceed the number of adults. If specified, this number should be greater than or equal to 0 (optional)
     * @param travelClass most of the flight time should be spent in a cabin of this quality or higher. The accepted travel class is economy, premium economy, business or first class. If no travel class is specified, the search considers any travel class (optional)
     * @param includedAirlineCodes This option ensures that the system will only consider these airlines. This can not be cumulated with parameter excludedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  (optional)
     * @param excludedAirlineCodes This option ensures that the system will ignore these airlines. This can not be cumulated with parameter includedAirlineCodes.  Airlines are specified as [IATA airline codes](http://www.iata.org/publications/Pages/code-search.aspx) and are comma-separated, e.g. 6X,7X,8X  (optional)
     * @param nonStop if set to true, the search will find only flights going from the origin to the destination with no stop in between (optional, default to false)
     * @param currencyCode the preferred currency for the flight offers. Currency is specified in the [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) format, e.g. EUR for Euro (optional)
     * @param maxPrice maximum price per traveler. By default, no limit is applied. If specified, the value should be a positive number with no decimals (optional)
     * @param max maximum number of flight offers to return. If specified, the value should be greater than or equal to 1 (optional, default to 250)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFlightOffersAsync(String originLocationCode, String destinationLocationCode, LocalDate departureDate, Integer adults, LocalDate returnDate, Integer children, Integer infants, String travelClass, String includedAirlineCodes, String excludedAirlineCodes, Boolean nonStop, String currencyCode, Integer maxPrice, Integer max, final ApiCallback<Success> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFlightOffersValidateBeforeCall(originLocationCode, destinationLocationCode, departureDate, adults, returnDate, children, infants, travelClass, includedAirlineCodes, excludedAirlineCodes, nonStop, currencyCode, maxPrice, max, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Success>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for searchFlightOffers
     * @param body list of criteria to retrieve a list of flight offers (required)
     * @param xHTTPMethodOverride the HTTP method to apply (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call searchFlightOffersCall(GetFlightOffersQuery body, String xHTTPMethodOverride, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/shopping/flight-offers";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xHTTPMethodOverride != null)
        localVarHeaderParams.put("X-HTTP-Method-Override", apiClient.parameterToString(xHTTPMethodOverride));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/vnd.amadeus+json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/vnd.amadeus+json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        if (headers != null) {
            localVarHeaderParams.putAll(headers);
        }
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call searchFlightOffersValidateBeforeCall(GetFlightOffersQuery body, String xHTTPMethodOverride, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling searchFlightOffers(Async)");
        }
        // verify the required parameter 'xHTTPMethodOverride' is set
        if (xHTTPMethodOverride == null) {
            throw new ApiException("Missing the required parameter 'xHTTPMethodOverride' when calling searchFlightOffers(Async)");
        }
        
        com.squareup.okhttp.Call call = searchFlightOffersCall(body, xHTTPMethodOverride, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Return list of Flight Offers based on posted searching criteria.
     * 
     * @param body list of criteria to retrieve a list of flight offers (required)
     * @param xHTTPMethodOverride the HTTP method to apply (required)
     * @return Success1
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Success1 searchFlightOffers(GetFlightOffersQuery body, String xHTTPMethodOverride) throws ApiException {
        ApiResponse<Success1> resp = searchFlightOffersWithHttpInfo(body, xHTTPMethodOverride);
        return resp.getData();
    }

    /**
     * Return list of Flight Offers based on posted searching criteria.
     * 
     * @param body list of criteria to retrieve a list of flight offers (required)
     * @param xHTTPMethodOverride the HTTP method to apply (required)
     * @return ApiResponse&lt;Success1&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Success1> searchFlightOffersWithHttpInfo(GetFlightOffersQuery body, String xHTTPMethodOverride) throws ApiException {
        com.squareup.okhttp.Call call = searchFlightOffersValidateBeforeCall(body, xHTTPMethodOverride, null, null);
        Type localVarReturnType = new TypeToken<Success1>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Return list of Flight Offers based on posted searching criteria. (asynchronously)
     * 
     * @param body list of criteria to retrieve a list of flight offers (required)
     * @param xHTTPMethodOverride the HTTP method to apply (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchFlightOffersAsync(GetFlightOffersQuery body, String xHTTPMethodOverride, final ApiCallback<Success1> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchFlightOffersValidateBeforeCall(body, xHTTPMethodOverride, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Success1>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}