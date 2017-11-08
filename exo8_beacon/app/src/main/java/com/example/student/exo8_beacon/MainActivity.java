package com.example.student.exo8_beacon;

import android.app.Activity;
import android.nfc.Tag;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;


public class MainActivity extends AppCompatActivity implements BeaconConsumer {
    private static final String TAG = "IMERIR";
    private BeaconManager beaconManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beaconManager = BeaconManager.getInstanceForApplication(this.getApplicationContext());
        beaconManager.getBeaconParsers().add(new BeaconParser()
                .setBeaconLayout(BeaconParser.EDDYSTONE_UID_LAYOUT));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        /*// Set the two identifiers below to null to detect any beacon regardless of identifiers
        Identifier myBeaconNamespaceId = Identifier.parse("0x2f234454f4911ba9ffa6"); //Identifier.parse("0x2f234454f4911ba9ffa6"); //623C4C5634E74E559257BDE28C1CC51B
        Identifier myBeaconInstanceId = Identifier.parse("0x000000000001");
        Region region = new Region("myMonitoringUniqueId", myBeaconNamespaceId, myBeaconInstanceId, null);
        beaconManager.addMonitorNotifier();
        try {
            beaconManager.startMonitoringBeaconsInRegion(region);
        } catch (RemoteException e) {
            e.printStackTrace();
        }*/

       try {
            beaconManager.startMonitoringBeaconsInRegion(new Region("myMonitoringUniqueId", null, null, null));
        } catch (RemoteException e) {
            Log.e(TAG, e.getMessage());
        }


        Log.i(TAG, "Beacon Service Connected");

        beaconManager.addMonitorNotifier(new MonitorNotifier() {
            @Override
            public void didEnterRegion(Region region) {
                Log.i(TAG, "I just saw an beacon for the first time!");
            }

            @Override
            public void didExitRegion(Region region) {
                Log.i(TAG, "I no longer see an beacon");
            }

            @Override
            public void didDetermineStateForRegion(int state, Region region) {
                Log.i(TAG, "I have just switched from seeing/not seeing beacons: "+state);
            }
        });


    }
}

