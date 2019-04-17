package com.example.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

public class ProfilePage extends AppCompatActivity {
    Context context;
    TextView infoTextView, logoutTextView;
    GraphView glucoseGraph;
    User mockUser;
    Button targetHighDisplay, targetLowDisplay, averageDisplay;
    public static  int TARGET_HIGH = 140;
    public static  int TARGET_LOW = 90;
    ListAdapter readingListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        context = this;
//receiving updates from the info page
        Intent receiveUserUpdates = getIntent();


//attaching handles
        averageDisplay = findViewById(R.id.profile_info_average);
        targetLowDisplay = findViewById(R.id.profile_info_target_low);
        targetHighDisplay = findViewById(R.id.profile_info_target_high);
        infoTextView = findViewById(R.id.profile_info_navigation);
        infoTextView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        glucoseGraph = findViewById(R.id.glucose_graph);
        logoutTextView = findViewById(R.id.logout_text);
//calling method to fill out the ui
        getUser();
        logoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(context, LoginPage.class);
                startActivity(logoutIntent);
            }
        });
    }

    private void getUser() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//pulled user info from dao from network adapter from url
                 mockUser = UserDao.getNewUser();
//start convert to ui thread to create everything
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//creating parameters of graph
                        glucoseGraph.getViewport().setYAxisBoundsManual(true);
                        glucoseGraph.getViewport().setMaxY(175);
                        glucoseGraph.getViewport().setMinY(50);
                        glucoseGraph.getViewport().setScalable(true);
                        glucoseGraph.getViewport().setXAxisBoundsManual(true);
                        glucoseGraph.getViewport().setMinX(0);
                        glucoseGraph.getViewport().setMaxX(25);
                        glucoseGraph.getGridLabelRenderer().setHighlightZeroLines(true);
                        glucoseGraph.getGridLabelRenderer().setVerticalAxisTitle("Glucose Level");
                        glucoseGraph.getGridLabelRenderer().setHorizontalAxisTitle("History");

//setting the 3 displays with target high,low, and average
                        targetHighDisplay.setText("Target High: " + TARGET_HIGH);
                        targetLowDisplay.setText("Target Low:  " + TARGET_LOW);

//plotting all the readings on the graph
                        PointsGraphSeries readingSeries = new PointsGraphSeries<>();
                        readingSeries.setSize(5);
                    for(int i = 0;i  < mockUser.bloodSugarArray.size();i++){
                        Reading tempReading = mockUser.getBloodSugarArray().get(i);
                        DataPoint newDataPoint = new DataPoint((i),tempReading.reading);
                        readingSeries.appendData(newDataPoint,true,mockUser.bloodSugarArray.size());
                    }
                    readingSeries.setSize(7);
                    readingSeries.setTitle("Glucose Level");
                        glucoseGraph.addSeries(readingSeries);
//drawing line for top threshold and adding to graph
                        LineGraphSeries targetGlucoseHigh = new LineGraphSeries<>(new DataPoint[]{
                                new DataPoint(0, TARGET_HIGH),
                                new DataPoint(mockUser.bloodSugarArray.size(), TARGET_HIGH) });
                        targetGlucoseHigh.setColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));
                        glucoseGraph.addSeries(targetGlucoseHigh);

//drawing line for bottom threshold and adding to graph
                        LineGraphSeries targetGlucoseLow = new LineGraphSeries<>(new DataPoint[]{
                                new DataPoint(0, TARGET_LOW),
                                new DataPoint(145, TARGET_LOW)  });
                        targetGlucoseLow.setColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));
                        glucoseGraph.addSeries(targetGlucoseLow);
//made list adapter and added to recyclerview
                        readingListAdapter = new ListAdapter(mockUser.bloodSugarArray);
                        RecyclerView recyclerView = findViewById(R.id.recycler_view);
                        recyclerView.setAdapter(readingListAdapter);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                        recyclerView.setLayoutManager(layoutManager);
//navigation (top row) buttons
                        infoTextView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent userInformation = new Intent(context, UserInformationPage.class);
//todo: put users info into intent to autofill user information page
//                                userInformation.putExtra("targetHigh", TARGET_HIGH );
//                                userInformation.putExtra("targetLow",TARGET_LOW);
                                userInformation.putExtra("name",mockUser.name);
                                startActivity(userInformation);
                            }
                        });
                    }
                });

            }
        }).start();



    }

}
