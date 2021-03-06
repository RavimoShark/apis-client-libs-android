/*
 * Ravimoshark Client API
 * This is an API to interact with Ravimoshark client database. # Introduction This API allow to create, modify and delete addresses and clients. # User Authentication This API does not contain any kind of user validation but It request to have a valid authentication user to interact with it. For more information about user Authentication, please refer to [Ravimoshark User Authentication](https://ravimoshark.com/back/apis/auth/latest). 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@ravimoshark.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.ravimoshark.apis.client.calls;

import com.ravimoshark.apis.client.ApiCallback;
import com.ravimoshark.apis.client.ApiClient;
import com.ravimoshark.apis.client.ApiException;
import com.ravimoshark.apis.client.ApiResponse;
import com.ravimoshark.apis.client.Configuration;
import com.ravimoshark.apis.client.Pair;
import com.ravimoshark.apis.client.ProgressRequestBody;
import com.ravimoshark.apis.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.ravimoshark.apis.client.model.Addresses;
import com.ravimoshark.apis.client.model.CustomError;
import com.ravimoshark.apis.client.model.Deleted;
import com.ravimoshark.apis.client.model.IdInteger;
import com.ravimoshark.apis.client.model.InlineResponse200;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressesApi {
    private ApiClient apiClient;

    public AddressesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AddressesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addAddress
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addAddressCall(Addresses body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/addresses";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addAddressValidateBeforeCall(Addresses body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling addAddress(Async)");
        }
        
        com.squareup.okhttp.Call call = addAddressCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Add one address.
     * Add one address.
     * @param body  (required)
     * @return Addresses
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Addresses addAddress(Addresses body) throws ApiException {
        ApiResponse<Addresses> resp = addAddressWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Add one address.
     * Add one address.
     * @param body  (required)
     * @return ApiResponse&lt;Addresses&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Addresses> addAddressWithHttpInfo(Addresses body) throws ApiException {
        com.squareup.okhttp.Call call = addAddressValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<Addresses>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Add one address. (asynchronously)
     * Add one address.
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addAddressAsync(Addresses body, final ApiCallback<Addresses> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addAddressValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Addresses>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteAddress
     * @param id id to delete or search (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteAddressCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/addresses/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteAddressValidateBeforeCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteAddress(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteAddressCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete one address.
     * Delete one address.
     * @param id id to delete or search (required)
     * @return IdInteger
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IdInteger deleteAddress(Long id) throws ApiException {
        ApiResponse<IdInteger> resp = deleteAddressWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Delete one address.
     * Delete one address.
     * @param id id to delete or search (required)
     * @return ApiResponse&lt;IdInteger&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IdInteger> deleteAddressWithHttpInfo(Long id) throws ApiException {
        com.squareup.okhttp.Call call = deleteAddressValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<IdInteger>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete one address. (asynchronously)
     * Delete one address.
     * @param id id to delete or search (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteAddressAsync(Long id, final ApiCallback<IdInteger> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteAddressValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IdInteger>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for editAddress
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call editAddressCall(Addresses body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/addresses";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call editAddressValidateBeforeCall(Addresses body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling editAddress(Async)");
        }
        
        com.squareup.okhttp.Call call = editAddressCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Edit one address.
     * Edit one address.
     * @param body  (required)
     * @return Addresses
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Addresses editAddress(Addresses body) throws ApiException {
        ApiResponse<Addresses> resp = editAddressWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Edit one address.
     * Edit one address.
     * @param body  (required)
     * @return ApiResponse&lt;Addresses&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Addresses> editAddressWithHttpInfo(Addresses body) throws ApiException {
        com.squareup.okhttp.Call call = editAddressValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<Addresses>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Edit one address. (asynchronously)
     * Edit one address.
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call editAddressAsync(Addresses body, final ApiCallback<Addresses> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = editAddressValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Addresses>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAddressById
     * @param id id to delete or search (required)
     * @param deleted Get all, deleted, not deleted data. Default not deleted. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAddressByIdCall(Long id, Deleted deleted, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/addresses/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (deleted != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("deleted", deleted));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAddressByIdValidateBeforeCall(Long id, Deleted deleted, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getAddressById(Async)");
        }
        
        com.squareup.okhttp.Call call = getAddressByIdCall(id, deleted, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get one address.
     * Get one address.
     * @param id id to delete or search (required)
     * @param deleted Get all, deleted, not deleted data. Default not deleted. (optional)
     * @return Addresses
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Addresses getAddressById(Long id, Deleted deleted) throws ApiException {
        ApiResponse<Addresses> resp = getAddressByIdWithHttpInfo(id, deleted);
        return resp.getData();
    }

    /**
     * Get one address.
     * Get one address.
     * @param id id to delete or search (required)
     * @param deleted Get all, deleted, not deleted data. Default not deleted. (optional)
     * @return ApiResponse&lt;Addresses&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Addresses> getAddressByIdWithHttpInfo(Long id, Deleted deleted) throws ApiException {
        com.squareup.okhttp.Call call = getAddressByIdValidateBeforeCall(id, deleted, null, null);
        Type localVarReturnType = new TypeToken<Addresses>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get one address. (asynchronously)
     * Get one address.
     * @param id id to delete or search (required)
     * @param deleted Get all, deleted, not deleted data. Default not deleted. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAddressByIdAsync(Long id, Deleted deleted, final ApiCallback<Addresses> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getAddressByIdValidateBeforeCall(id, deleted, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Addresses>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getAddresses
     * @param skip number of item to skip (optional)
     * @param limit max records to return (optional)
     * @param orderBy order by property. (optional)
     * @param filterBy filter data. (optional)
     * @param deleted Get all, deleted, not deleted data. Default not deleted. (optional)
     * @param metadata If metadata is needed (for pagination controls) (optional)
     * @param refClient Data from a desired client (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAddressesCall(Integer skip, Integer limit, String orderBy, String filterBy, Deleted deleted, Boolean metadata, String refClient, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/addresses";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("skip", skip));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (orderBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("orderBy", orderBy));
        if (filterBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filterBy", filterBy));
        if (deleted != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("deleted", deleted));
        if (metadata != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("metadata", metadata));
        if (refClient != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("refClient", refClient));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAddressesValidateBeforeCall(Integer skip, Integer limit, String orderBy, String filterBy, Deleted deleted, Boolean metadata, String refClient, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = getAddressesCall(skip, limit, orderBy, filterBy, deleted, metadata, refClient, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get all addresses.
     * Get all addresses.
     * @param skip number of item to skip (optional)
     * @param limit max records to return (optional)
     * @param orderBy order by property. (optional)
     * @param filterBy filter data. (optional)
     * @param deleted Get all, deleted, not deleted data. Default not deleted. (optional)
     * @param metadata If metadata is needed (for pagination controls) (optional)
     * @param refClient Data from a desired client (optional)
     * @return InlineResponse200
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse200 getAddresses(Integer skip, Integer limit, String orderBy, String filterBy, Deleted deleted, Boolean metadata, String refClient) throws ApiException {
        ApiResponse<InlineResponse200> resp = getAddressesWithHttpInfo(skip, limit, orderBy, filterBy, deleted, metadata, refClient);
        return resp.getData();
    }

    /**
     * Get all addresses.
     * Get all addresses.
     * @param skip number of item to skip (optional)
     * @param limit max records to return (optional)
     * @param orderBy order by property. (optional)
     * @param filterBy filter data. (optional)
     * @param deleted Get all, deleted, not deleted data. Default not deleted. (optional)
     * @param metadata If metadata is needed (for pagination controls) (optional)
     * @param refClient Data from a desired client (optional)
     * @return ApiResponse&lt;InlineResponse200&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse200> getAddressesWithHttpInfo(Integer skip, Integer limit, String orderBy, String filterBy, Deleted deleted, Boolean metadata, String refClient) throws ApiException {
        com.squareup.okhttp.Call call = getAddressesValidateBeforeCall(skip, limit, orderBy, filterBy, deleted, metadata, refClient, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all addresses. (asynchronously)
     * Get all addresses.
     * @param skip number of item to skip (optional)
     * @param limit max records to return (optional)
     * @param orderBy order by property. (optional)
     * @param filterBy filter data. (optional)
     * @param deleted Get all, deleted, not deleted data. Default not deleted. (optional)
     * @param metadata If metadata is needed (for pagination controls) (optional)
     * @param refClient Data from a desired client (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAddressesAsync(Integer skip, Integer limit, String orderBy, String filterBy, Deleted deleted, Boolean metadata, String refClient, final ApiCallback<InlineResponse200> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getAddressesValidateBeforeCall(skip, limit, orderBy, filterBy, deleted, metadata, refClient, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
