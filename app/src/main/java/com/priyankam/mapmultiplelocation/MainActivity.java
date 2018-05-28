package com.priyankam.mapmultiplelocation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.map_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String site1="12.951845,77.699577";
                String site2="12.9698,77.7499";
                String site3="13.0358,77.5970";
                String site4="13.1986,77.7066";
                String split="%7C";

                String smap=site1.concat(split).concat(site2).concat(split).concat(site3).concat(split).concat(site4);

                Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin="+site1+"&destination="+site4 +
                        "&travelmode=driving" +
                        "&waypoints="+smap);

                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent.setPackage("com.google.android.apps.maps");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

        });
    }

}
