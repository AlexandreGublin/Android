package com.example.student.camping_imerir.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.camping_imerir.R;

/**
 * Created by student on 26/10/2017.
 */

public class FragmentAccountBottomNavigation extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Select the ViewFragment by the onItemClick
        View rootview = inflater.inflate(R.layout.fragment_account_bottom_navigation, container, false);

        return rootview;

    }
}
