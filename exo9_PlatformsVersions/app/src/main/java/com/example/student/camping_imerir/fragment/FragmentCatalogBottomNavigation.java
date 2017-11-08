package com.example.student.camping_imerir.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.camping_imerir.R;

/**
 * Created by student on 24/10/2017.
 */

public class FragmentCatalogBottomNavigation extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Select the ViewFragment by the onItemClick
        View rootview = inflater.inflate(R.layout.fragment_catalog_bottom_navigation, container, false);

        TabLayout tabLayout = (TabLayout) rootview.findViewById(R.id.tab_layout_catalog);

        getFragmentManager().beginTransaction().replace(R.id.frame_catalog, new FragmentListCatalog()).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getFragmentManager().beginTransaction().replace(R.id.frame_catalog, new FragmentListCatalog()).commit();
                        break;

                    case 1:
                        getFragmentManager().beginTransaction().replace(R.id.frame_catalog, new FragmentMapCatalog()).commit();
                        break;

                    default :
                        getFragmentManager().beginTransaction().replace(R.id.frame_catalog, new FragmentListCatalog()).commit();
                        break;

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        if(getActivity() == null){
            getFragmentManager().beginTransaction().replace(R.id.frame_catalog, new FragmentListCatalog()).commit();
        }


        return rootview;
    }
}
