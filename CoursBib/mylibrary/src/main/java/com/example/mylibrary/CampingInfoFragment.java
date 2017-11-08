package com.example.mylibrary;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CampingInfoFragment extends Fragment {


    public CampingInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //                             identifie avec un numéro la vue   Vue parent   false car c'est le fragmentManager qui s'occupe de le metttre directement dans la vue
        View rootview = inflater.inflate(R.layout.fragment_camping_info, container, false);

        CampingInfo info = CampingInfo.sharedInstance;

        TextView name = (TextView) rootview.findViewById(R.id.name);

        name.setText(info.getName());

        TextView address = (TextView) rootview.findViewById(R.id.address);
        address.setText(info.getAdress());

        TextView tel = (TextView) rootview.findViewById(R.id.telephone);
        tel.setText(info.getTelephoneNumber());

        TextView website = (TextView) rootview.findViewById(R.id.website);
        website.setText(info.getWebSite());

        final Button goToWebsite = (Button) rootview.findViewById(R.id.buttonGoToWebsite);
        goToWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCampingWebsite();
            }
        });

        return rootview;
    }


    void goToCampingWebsite(){

        String urlString = CampingInfo.sharedInstance.getWebSite();
        Uri websiteUri = Uri.parse(urlString);

        Intent intent = new Intent(Intent.ACTION_VIEW, websiteUri);
        startActivity(intent);
    }

}
