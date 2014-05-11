package com.worldpay.sdk;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import com.worldpay.sdk.exception.WorldpayException;
import com.worldpay.sdk.json.JsonParser;
import com.worldpay.sdk.model.ApiError;

/**
 * Class to handle HTTP connection details and JSON conversion.
 */
class Http {

    /**
     * Connection timeout in milliseconds.
     */
    private static final int CONNECTION_TIMEOUT = 10000;

    /**
     * Socket timeout in milliseconds.
     */
    private static final int SOCKET_TIMEOUT = 10000;

    private static final String APPLICATION_JSON = "application/json";

    private static final String USER_AGENT_VALUE = "java-http/" + WorldpayGateway.VERSION;

    enum RequestMethod {
        DELETE, GET, POST, PUT;
    }

    private String baseUri;

    private String serviceKey;

    Http(String baseUri, String serviceKey) {
        this.baseUri = baseUri;
        this.serviceKey = serviceKey;
    }

    /**
     * Create a new resource using POST and return the parsed response.
     *
     * @param resourcePath the location of the resource e.g. /order/123
     * @param request the Object which needs to be serialized and sent as POST payload, may be null
     * @param responseType the type of the return value
     * @return the converted object
     */
    <T> T post(String resourcePath, Object request, final Class<T> responseType) {
        Request postRequest = createRequest(RequestMethod.POST, resourcePath);

        if (request != null) {
            postRequest.bodyString(toJson(request), ContentType.APPLICATION_JSON);
        }

        return execute(postRequest, responseType);
    }

    /**
     * Updates an existing resource using PUT and return the parsed response.
     *
     * @param resourcePath the location of the resource e.g. /order/123
     * @param request the Object which needs to be serialised and sent as payload, may be null
     * @param responseType the type of the return value
     * @return the converted object
     */
    <T> T put(String resourcePath, Object request, final Class<T> responseType) {
        Request putRequest = createRequest(RequestMethod.PUT, resourcePath);

        if (request != null) {
            putRequest.bodyString(toJson(request), ContentType.APPLICATION_JSON);
        }

        return execute(putRequest, responseType);
    }

    /**
     * Return the representation obtained by GET.
     *
     * @param resourcePath the location of the resource e.g. /order/123
     * @param responseType the type of the return value
     * @return the converted object
     */
    <T> T get(String resourcePath, final Class<T> responseType) {
        Request getRequest = createRequest(RequestMethod.GET, resourcePath);
        return execute(getRequest, responseType);
    }

    private String toJson(Object request) {
        try {
            return JsonParser.toJson(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T execute(Request request, final Class<T> responseType) {
        try {
            return request.execute().handleResponse(withHandler(responseType));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Request createRequest(RequestMethod method, String uri) {
        Request request = null;
        String fullUri = baseUri + uri;

        switch (method) {
            case GET:
                request = Request.Get(fullUri);
                break;
            case POST:
                request = Request.Post(fullUri);
                break;
            case PUT:
                request = Request.Put(fullUri);
                break;
            case DELETE:
                request = Request.Delete(fullUri);
                break;
            }

        return request.addHeader(HttpHeaders.ACCEPT, APPLICATION_JSON)
                        .addHeader(HttpHeaders.AUTHORIZATION, serviceKey)
                        .addHeader(HttpHeaders.USER_AGENT, USER_AGENT_VALUE)
                        .connectTimeout(CONNECTION_TIMEOUT)
                        .socketTimeout(SOCKET_TIMEOUT);
    }

    private <T> ResponseHandler<T> withHandler(final Class<T> responseType) {
        return new ResponseHandler<T>() {

            public T handleResponse(HttpResponse response) throws IOException {
                HttpEntity entity = response.getEntity();
                StatusLine statusLine = response.getStatusLine();

                if (statusLine.getStatusCode() >= 300) {
                    ApiError error = JsonParser.toObject(entity.getContent(), ApiError.class);
                    throw new WorldpayException(error);
                }

                return JsonParser.toObject(entity.getContent(), responseType);
            }
        };
    }

}
