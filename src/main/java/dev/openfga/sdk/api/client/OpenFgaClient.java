/*
 * OpenFGA
 * A high performance and flexible authorization/permission engine built for developers and inspired by Google Zanzibar.
 *
 * The version of the OpenAPI document: 0.1
 * Contact: community@openfga.dev
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package dev.openfga.sdk.api.client;

import static dev.openfga.sdk.util.StringUtil.isNullOrWhitespace;

import dev.openfga.sdk.api.*;
import dev.openfga.sdk.api.configuration.*;
import dev.openfga.sdk.api.model.*;
import dev.openfga.sdk.errors.*;
import java.util.concurrent.CompletableFuture;

public class OpenFgaClient {
    private ApiClient apiClient;
    private ClientConfiguration configuration;
    private OpenFgaApi api;

    private static final String CLIENT_BULK_REQUEST_ID_HEADER = "X-OpenFGA-Client-Bulk-Request-Id";
    private static final String CLIENT_METHOD_HEADER = "X-OpenFGA-Client-Method";
    private static final int DEFAULT_MAX_METHOD_PARALLEL_REQS = 10;

    public OpenFgaClient(ApiClient apiClient, ClientConfiguration configuration) throws FgaInvalidParameterException {
        this.apiClient = apiClient;
        this.configuration = configuration;
        this.api = new OpenFgaApi(apiClient, configuration);
    }

    /* ***********
     * Utilities *
     *************/

    public void setStoreId(String storeId) {
        configuration.storeId(storeId);
    }

    public void setAuthorizationModelId(String authorizationModelId) {
        configuration.authorizationModelId(authorizationModelId);
    }

    public void setConfiguration(ClientConfiguration configuration) throws FgaInvalidParameterException {
        this.configuration = configuration;
        this.api = new OpenFgaApi(apiClient, configuration);
    }

    /* ********
     * Stores *
     **********/

    /**
     * ListStores - Get a paginated list of stores.
     */
    public CompletableFuture<ListStoresResponse> listStores() throws FgaInvalidParameterException {
        configuration.assertValid();
        return call(() -> api.listStores(null, null));
    }

    public CompletableFuture<ListStoresResponse> listStores(ListStoresOptions options)
            throws FgaInvalidParameterException {
        configuration.assertValid();
        return call(() -> api.listStores(options.getPageSize(), options.getContinuationToken()));
    }

    /**
     * CreateStore - Initialize a store
     */
    public CompletableFuture<CreateStoreResponse> createStore(CreateStoreRequest request)
            throws FgaInvalidParameterException {
        configuration.assertValid();
        return call(() -> api.createStore(request));
    }

    /**
     * GetStore - Get information about the current store.
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<GetStoreResponse> getStore() throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() -> api.getStore(storeId));
    }

    /**
     * DeleteStore - Delete a store
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<Void> deleteStore() throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() -> api.deleteStore(storeId));
    }

    /* **********************
     * Authorization Models *
     ************************/

    /**
     * ReadAuthorizationModels - Read all authorization models
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<ReadAuthorizationModelsResponse> readAuthorizationModels(
            ReadAuthorizationModelsOptions options) throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() -> api.readAuthorizationModels(storeId, options.getPageSize(), options.getContinuationToken()));
    }

    /**
     * WriteAuthorizationModel - Create a new version of the authorization model
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<WriteAuthorizationModelResponse> writeAuthorizationModel(
            WriteAuthorizationModelRequest request) throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() -> api.writeAuthorizationModel(storeId, request));
    }

    /**
     * ReadAuthorizationModel - Read the current authorization model
     *
     * @throws FgaInvalidParameterException When either the Store ID or Authorization Model ID are null, empty, or whitespace
     */
    public CompletableFuture<ReadAuthorizationModelResponse> readAuthorizationModel()
            throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        String authorizationModelId = configuration.getAuthorizationModelIdChecked();
        return call(() -> api.readAuthorizationModel(storeId, authorizationModelId));
    }

    /**
     * ReadAuthorizationModel - Read the current authorization model
     *
     * @throws FgaInvalidParameterException When either the Store ID or Authorization Model ID are null, empty, or whitespace
     */
    public CompletableFuture<ReadAuthorizationModelResponse> readAuthorizationModel(
            ReadAuthorizationModelOptions options) throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        String authorizationModelId = options.getAuthorizationModelIdChecked();
        return call(() -> api.readAuthorizationModel(storeId, authorizationModelId));
    }

    /**
     * ReadLatestAuthorizationModel - Read the latest authorization model for the current store
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<ReadAuthorizationModelResponse> readLatestAuthorizationModel()
            throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() -> api.readAuthorizationModels(storeId, 1, null))
                .thenApply(response -> new ReadAuthorizationModelResponse()
                        .authorizationModel(response.getAuthorizationModels().get(0)));
    }

    /* *********************
     * Relationship Tuples *
     ***********************/

    /**
     * Read Changes - Read the list of historical relationship tuple writes and deletes
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<ReadChangesResponse> readChanges(ReadChangesOptions options)
            throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() ->
                api.readChanges(storeId, options.getType(), options.getPageSize(), options.getContinuationToken()));
    }

    /**
     * Read - Read tuples previously written to the store (does not evaluate)
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<ReadResponse> read(ClientReadRequest request) throws FgaInvalidParameterException {
        return read(request, null);
    }

    /**
     * Read - Read tuples previously written to the store (does not evaluate)
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<ReadResponse> read(ClientReadRequest request, ClientReadOptions options)
            throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();

        ReadRequest body = new ReadRequest();
        TupleKey tupleKey = new TupleKey();

        if (request != null) {
            tupleKey.user(request.getUser()).relation(request.getRelation())._object(request.getObject());
        }

        if (options != null) {
            body.pageSize(options.getPageSize()).continuationToken(options.getContinuationToken());
        }

        body.tupleKey(tupleKey);

        return call(() -> api.read(storeId, body));
    }

    /**
     * Write - Create or delete relationship tuples
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<Object> write(ClientWriteRequest request) throws FgaInvalidParameterException {
        return write(request, null);
    }

    /**
     * Write - Create or delete relationship tuples
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<Object> write(ClientWriteRequest request, ClientWriteOptions options)
            throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();

        WriteRequest body = new WriteRequest();

        if (request != null) {
            if (request.getWrites() != null) {
                body.writes(new TupleKeys().tupleKeys(request.getWrites()));
            }
            if (request.getDeletes() != null) {
                body.deletes(new TupleKeys().tupleKeys(request.getDeletes()));
            }
        }

        if (options != null && !isNullOrWhitespace(options.getAuthorizationModelId())) {
            body.authorizationModelId(options.getAuthorizationModelId());
        } else {
            String authorizationModelId = configuration.getAuthorizationModelId();
            body.authorizationModelId(authorizationModelId);
        }

        return call(() -> api.write(storeId, body));
    }

    /**
     * WriteTuples - Utility method to write tuples, wraps Write
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<Object> writeTuples(TupleKeys tupleKeys) throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();

        var request = new WriteRequest().writes(tupleKeys);
        String authorizationModelId = configuration.getAuthorizationModelId();
        if (!isNullOrWhitespace(authorizationModelId)) {
            request.authorizationModelId(authorizationModelId);
        }

        return call(() -> api.write(storeId, request));
    }

    /**
     * DeleteTuples - Utility method to delete tuples, wraps Write
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<Object> deleteTuples(TupleKeys tupleKeys) throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();

        var request = new WriteRequest().deletes(tupleKeys);
        String authorizationModelId = configuration.getAuthorizationModelId();
        if (!isNullOrWhitespace(authorizationModelId)) {
            request.authorizationModelId(authorizationModelId);
        }

        return call(() -> api.write(storeId, request));
    }

    /* **********************
     * Relationship Queries *
     ***********************/

    /**
     * Check - Check if a user has a particular relation with an object (evaluates)
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<CheckResponse> check(CheckRequest request) throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() -> api.check(storeId, request));
    }

    /**
     * BatchCheck - Run a set of checks (evaluates)
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    // TODO

    /**
     * Expand - Expands the relationships in userset tree format (evaluates)
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<ExpandResponse> expand(ExpandRequest request) throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() -> api.expand(storeId, request));
    }

    /**
     * ListObjects - List the objects of a particular type that the user has a certain relation to (evaluates)
     *
     * @throws FgaInvalidParameterException When the Store ID is null, empty, or whitespace
     */
    public CompletableFuture<ListObjectsResponse> listObjects(ListObjectsRequest request)
            throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        return call(() -> api.listObjects(storeId, request));
    }

    /*
     * ListRelations - List all the relations a user has with an object (evaluates)
     */
    // TODO

    /* ************
     * Assertions *
     **************/

    /**
     * ReadAssertions - Read assertions for a particular authorization model
     *
     * @throws FgaInvalidParameterException When either the Store ID or Authorization Model ID is null, empty, or whitespace
     */
    public CompletableFuture<ReadAssertionsResponse> readAssertions() throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        String authorizationModelId = configuration.getAuthorizationModelIdChecked();
        return call(() -> api.readAssertions(storeId, authorizationModelId));
    }

    /**
     * WriteAssertions - Updates assertions for a particular authorization model
     *
     * @throws FgaInvalidParameterException When either the Store ID or Authorization Model ID is null, empty, or whitespace
     */
    public CompletableFuture<Void> writeAssertions(WriteAssertionsRequest request) throws FgaInvalidParameterException {
        configuration.assertValid();
        String storeId = configuration.getStoreIdChecked();
        String authorizationModelId = configuration.getAuthorizationModelIdChecked();
        return call(() -> api.writeAssertions(storeId, authorizationModelId, request));
    }

    /**
     * A {@link FunctionalInterface} for calling a low-level API from {@link OpenFgaApi}. It wraps exceptions
     * encountered with {@link CompletableFuture#failedFuture(Throwable)}
     *
     * @param <R> The type of API response
     */
    @FunctionalInterface
    private interface CheckedInvocation<R> {
        CompletableFuture<R> call() throws FgaInvalidParameterException, ApiException;
    }

    private <T> CompletableFuture<T> call(CheckedInvocation<T> action) {
        try {
            return action.call();
        } catch (FgaInvalidParameterException | ApiException exception) {
            return CompletableFuture.failedFuture(exception);
        }
    }
}
