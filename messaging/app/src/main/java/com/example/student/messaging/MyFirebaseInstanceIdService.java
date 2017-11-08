package com.example.student.messaging;

import android.nfc.Tag;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by student on 30/10/2017.
 */

public class MyFirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("IMERIR", "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationTosServer(refreshedToken);
    }
}
