package com.example.worldclock;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;
import android.view.View;

import java.util.Calendar;
import java.util.TimeZone;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make a alert dialog to explain how the app works
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Tutorial");
        alertDialog.setMessage("Tap a city to hide it. Tap again to unhide it.\n\n" +
                "You can also toggle between 12 and 24 hour time using the switch at the top " +
                "labelled \"24 Hour Time\".");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        alertDialog.show();


        //get the strings for the cities from the resources
        String[] cities = getResources().getStringArray(R.array.cities);

        //init all the layouts
        ConstraintLayout sydney = findViewById(R.id.clock1);
        final ConstraintLayout auckland = findViewById(R.id.clock2);
        final ConstraintLayout bruges = findViewById(R.id.clock3);
        final ConstraintLayout paris = findViewById(R.id.clock4);
        ConstraintLayout ny = findViewById(R.id.clock5);

        //set all the texts that show the city names
        final TextView text1 = sydney.findViewById(R.id.text1);
        text1.setText(cities[0]);
        final TextView text2 = auckland.findViewById(R.id.text1);
        text2.setText(cities[1]);
        final TextView text3 = bruges.findViewById(R.id.text1);
        text3.setText(cities[2]);
        final TextView text4 = paris.findViewById(R.id.text1);
        text4.setText(cities[3]);
        final TextView text5 = ny.findViewById(R.id.text1);
        text5.setText(cities[4]);

        //init the hidden texts (these will be shown when the cities are hidden)
        final TextView hidden1 = sydney.findViewById(R.id.hidden);
        hidden1.setText(cities[0]);
        final TextView hidden2 = auckland.findViewById(R.id.hidden);
        hidden2.setText(cities[1]);
        final TextView hidden3 = bruges.findViewById(R.id.hidden);
        hidden3.setText(cities[2]);
        final TextView hidden4 = paris.findViewById(R.id.hidden);
        hidden4.setText(cities[3]);
        final TextView hidden5 = ny.findViewById(R.id.hidden);
        hidden5.setText(cities[4]);

        //init all the clocks and set their timezones
        final TextClock sydneyClock = sydney.findViewById(R.id.simpleTextClock);
        sydneyClock.setTimeZone("Australia/Sydney");
        final TextClock aucklandClock = auckland.findViewById(R.id.simpleTextClock);
        aucklandClock.setTimeZone("Pacific/Auckland");
        final TextClock brugesClock = bruges.findViewById(R.id.simpleTextClock);
        brugesClock.setTimeZone("Europe/Paris");
        final TextClock parisClock = paris.findViewById(R.id.simpleTextClock);
        parisClock.setTimeZone("Europe/Paris");
        final TextClock nyClock = ny.findViewById(R.id.simpleTextClock);
        nyClock.setTimeZone("America/New York");

        //force all the clocks to a 12 hour format
        //this means even in a region which uses 24hr time by default (like europe)
        //clocks will be forced to display 12 hour time
        sydneyClock.setFormat24Hour("h:mm a");
        aucklandClock.setFormat24Hour("h:mm a");
        brugesClock.setFormat24Hour("h:mm a");
        parisClock.setFormat24Hour("h:mm a");
        nyClock.setFormat24Hour("h:mm a");

        //get and set all the image views
        final ImageView image1 = sydney.findViewById(R.id.imageView);
        image1.setImageResource(R.drawable.sydney);
        final ImageView image2 = auckland.findViewById(R.id.imageView);
        image2.setImageResource(R.drawable.auckland);
        final ImageView image3 = bruges.findViewById(R.id.imageView);
        image3.setImageResource(R.drawable.bruges);
        final ImageView image4 = paris.findViewById(R.id.imageView);
        image4.setImageResource(R.drawable.paris);
        final ImageView image5 = ny.findViewById(R.id.imageView);
        image5.setImageResource(R.drawable.newyork);

        //this will hide the city when the layout is clicked
        sydney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hidden1.getVisibility() == View.GONE) {
                    image1.setVisibility(View.GONE);
                    sydneyClock.setVisibility(View.GONE);
                    text1.setVisibility(View.GONE);
                    hidden1.setVisibility(View.VISIBLE);
                }else {
                    image1.setVisibility(View.VISIBLE);
                    sydneyClock.setVisibility(View.VISIBLE);
                    text1.setVisibility(View.VISIBLE);
                    hidden1.setVisibility(View.GONE);
                }
            }
        });
        auckland.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hidden2.getVisibility() == View.GONE) {
                    image2.setVisibility(View.GONE);
                    aucklandClock.setVisibility(View.GONE);
                    text2.setVisibility(View.GONE);
                    hidden2.setVisibility(View.VISIBLE);
                }else {
                    image2.setVisibility(View.VISIBLE);
                    aucklandClock.setVisibility(View.VISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    hidden2.setVisibility(View.GONE);
                }
            }
        });
        bruges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hidden3.getVisibility() == View.GONE) {
                    image3.setVisibility(View.GONE);
                    brugesClock.setVisibility(View.GONE);
                    text3.setVisibility(View.GONE);
                    hidden3.setVisibility(View.VISIBLE);
                }else {
                    image3.setVisibility(View.VISIBLE);
                    brugesClock.setVisibility(View.VISIBLE);
                    text3.setVisibility(View.VISIBLE);
                    hidden3.setVisibility(View.GONE);
                }
            }
        });
        paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hidden4.getVisibility() == View.GONE) {
                    image4.setVisibility(View.GONE);
                    parisClock.setVisibility(View.GONE);
                    text4.setVisibility(View.GONE);
                    hidden4.setVisibility(View.VISIBLE);
                }else {
                    image4.setVisibility(View.VISIBLE);
                    parisClock.setVisibility(View.VISIBLE);
                    text4.setVisibility(View.VISIBLE);
                    hidden4.setVisibility(View.GONE);
                }
            }
        });
        ny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hidden5.getVisibility() == View.GONE) {
                    image5.setVisibility(View.GONE);
                    nyClock.setVisibility(View.GONE);
                    text5.setVisibility(View.GONE);
                    hidden5.setVisibility(View.VISIBLE);
                }else {
                    image5.setVisibility(View.VISIBLE);
                    nyClock.setVisibility(View.VISIBLE);
                    text5.setVisibility(View.VISIBLE);
                    hidden5.setVisibility(View.GONE);
                }
            }
        });


        //get the switch and attach it to a listener
        Switch formatswitch = findViewById(R.id.switchTime);
        formatswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //when they flick the toggle change the clocks format
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // When the 24hr time toggle is enabled
                    //force the clock into 24 hour time format
                    sydneyClock.setFormat12Hour("HH:mm");
                    sydneyClock.setFormat24Hour("HH:mm");
                    aucklandClock.setFormat12Hour("HH:mm");
                    aucklandClock.setFormat24Hour("HH:mm");
                    brugesClock.setFormat12Hour("HH:mm");
                    brugesClock.setFormat24Hour("HH:mm");
                    parisClock.setFormat12Hour("HH:mm");
                    parisClock.setFormat24Hour("HH:mm");
                    nyClock.setFormat12Hour("HH:mm");
                    nyClock.setFormat24Hour("HH:mm");

                } else {
                    // The toggle is disabled, switch back to 12 hour format
                    sydneyClock.setFormat12Hour("h:mm a");
                    sydneyClock.setFormat24Hour("h:mm a");
                    aucklandClock.setFormat12Hour("h:mm a");
                    aucklandClock.setFormat24Hour("h:mm a");
                    brugesClock.setFormat12Hour("h:mm a");
                    brugesClock.setFormat24Hour("h:mm a");
                    parisClock.setFormat12Hour("h:mm a");
                    parisClock.setFormat24Hour("h:mm a");
                    nyClock.setFormat12Hour("h:mm a");
                    nyClock.setFormat24Hour("h:mm a");
                }
            }
        });

    }


}
