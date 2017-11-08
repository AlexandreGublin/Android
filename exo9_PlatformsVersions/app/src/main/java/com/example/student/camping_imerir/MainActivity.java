package com.example.student.camping_imerir;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.student.camping_imerir.fragment.FragmentAccountBottomNavigation;
import com.example.student.camping_imerir.fragment.FragmentCalendarBottomNavigation;
import com.example.student.camping_imerir.fragment.FragmentCatalogBottomNavigation;
import com.example.student.camping_imerir.fragment.FragmentHomeBottomNavigation;
import com.example.student.camping_imerir.fragment.FragmentSettingsBottomNavigation;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent intent = new Intent(this, QRCodeActivity.class);
        startActivity(intent);*/

        //Get our BottomNavaigationView
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        getFragmentManager().beginTransaction().replace(R.id.frame_bottom_navigation, new FragmentHomeBottomNavigation()).commit();

        // When we click on one of the BottomNavigationView's item
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.action_home:
                                getFragmentManager().beginTransaction().replace(R.id.frame_bottom_navigation, new FragmentHomeBottomNavigation()).commit();
                                break;

                            case R.id.action_account:
                                getFragmentManager().beginTransaction().replace(R.id.frame_bottom_navigation, new FragmentAccountBottomNavigation()).commit();
                                break;

                            case R.id.action_catalog:
                                getFragmentManager().beginTransaction().replace(R.id.frame_bottom_navigation, new FragmentCatalogBottomNavigation()).commit();
                                break;

                            case R.id.action_calendar:
                                getFragmentManager().beginTransaction().replace(R.id.frame_bottom_navigation, new FragmentCalendarBottomNavigation()).commit();
                                break;

                            case R.id.action_settings:
                                getFragmentManager().beginTransaction().replace(R.id.frame_bottom_navigation, new FragmentSettingsBottomNavigation()).commit();
                                break;

                            default :
                                getFragmentManager().beginTransaction().replace(R.id.frame_bottom_navigation, new FragmentHomeBottomNavigation()).commit();
                        }

                        return true;
                    }

                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_navigation_main, menu);
        return true;
    }

}
