package com.walmartlabs.electrode.reactnative.sample.api;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeHolder;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeRequest;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeRequestHandler;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeResponseListener;
import com.walmartlabs.electrode.reactnative.bridge.helpers.RequestHandler;
import com.walmartlabs.electrode.reactnative.bridge.helpers.RequestHandlerEx;
import com.walmartlabs.electrode.reactnative.sample.model.Person;
import com.walmartlabs.electrode.reactnative.sample.model.Status;

/***
 * This is a test API generated for testing the bridge. This is first generated using api gen commend and necessary changes are made.
 * <p>
 * This needs to be kept as a reference for generating the api code. This is how a generated API code looks like(format, order, naming conventions etc.)
 * <p>
 * This class provides all the request actions that can be performed on Person.
 */
final class PersonRequests implements PersonApi.Requests {

    PersonRequests() {

    }

    @Override
    public void registerGetPersonRequestHandler(@NonNull final RequestHandler<Person> handler) {
        ElectrodeBridgeHolder.registerRequestHandler(EVENT_GET_PERSON, new ElectrodeBridgeRequestHandler() {
            @Override
            public void onRequest(Bundle bundle, final ElectrodeBridgeResponseListener responseListener) {
                handler.handleRequest(new ElectrodeBridgeResponseListener<Person>() {

                    @Override
                    public void onSuccess(Person obj) {
                        Bundle bundle = obj.toBundle();
                        responseListener.onSuccess(bundle);
                    }

                    @Override
                    public void onFailure(@NonNull String code, @NonNull String message) {
                        responseListener.onFailure(code, message);
                    }
                });
            }
        });
    }

    @Override
    public void registerGetStatusRequestHandler(@NonNull final RequestHandlerEx<Person, Status> handler) {
        ElectrodeBridgeHolder.registerRequestHandler(EVENT_GET_STATUS, new ElectrodeBridgeRequestHandler() {
            @Override
            public void onRequest(Bundle bundle, final ElectrodeBridgeResponseListener responseListener) {

                Person payload = Person.fromBundle(bundle);

                handler.handleRequest(payload, new ElectrodeBridgeResponseListener<Status>() {
                    @Override
                    public void onFailure(@NonNull String code, @NonNull String message) {
                        responseListener.onFailure(code, message);
                    }

                    @Override
                    public void onSuccess(Status obj) {
                        Bundle bundle = obj.toBundle();
                        responseListener.onSuccess(bundle);
                    }
                });
            }
        });
    }

    @Override
    public void getPerson(@NonNull final ElectrodeBridgeResponseListener<Person> response) {
        ElectrodeBridgeRequest req = new ElectrodeBridgeRequest.Builder(EVENT_GET_PERSON)
                .withDispatchMode(ElectrodeBridgeRequest.DispatchMode.JS)
                .build();

        ElectrodeBridgeHolder.sendRequest(req, new ElectrodeBridgeResponseListener<Bundle>() {
            @Override
            public void onSuccess(Bundle bundle) {
                Person payload = Person.fromBundle(bundle);
                response.onSuccess(payload);
            }

            @Override
            public void onFailure(@NonNull String code, @NonNull String message) {
                response.onFailure(code, message);
            }
        });
    }


    @Override
    public void getStatus(@NonNull Person person, @NonNull final ElectrodeBridgeResponseListener<Status> response) {
        Bundle bundle = person.toBundle();
        ElectrodeBridgeRequest req = new ElectrodeBridgeRequest.Builder(EVENT_GET_STATUS)
                .withData(bundle)
                .withDispatchMode(ElectrodeBridgeRequest.DispatchMode.NATIVE)
                .build();

        ElectrodeBridgeHolder.sendRequest(req, new ElectrodeBridgeResponseListener<Bundle>() {

            @Override
            public void onSuccess(Bundle bundle) {
                Status payload = Status.fromBundle(bundle);
                response.onSuccess(payload);
            }

            @Override
            public void onFailure(@NonNull String code, @NonNull String message) {
                response.onFailure(code, message);
            }
        });
    }


    @Override
    public void getUserName(@NonNull final ElectrodeBridgeResponseListener<String> response) {
        ElectrodeBridgeRequest req = new ElectrodeBridgeRequest.Builder(EVENT_GET_USER_NAME)
                .withData(Bundle.EMPTY)
                .withDispatchMode(ElectrodeBridgeRequest.DispatchMode.JS)
                .build();

        ElectrodeBridgeHolder.sendRequest(req, new ElectrodeBridgeResponseListener<Bundle>() {

            @Override
            public void onSuccess(Bundle bundle) {
                response.onSuccess(bundle.getString("userName"));
            }

            @Override
            public void onFailure(@NonNull String code, @NonNull String message) {
                response.onFailure(code, message);
            }

        });
    }
}