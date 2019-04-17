package com.example.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.sql.Date;
import java.util.ArrayList;

public class ProfilePage extends AppCompatActivity {
    Context context;
    TextView infoTextView;
    GraphView glucoseGraph;
    User mockUser;
    Button targetHighDisplay,targetLowDisplay,averageDisplay;
    public static final int TARGET_HIGH = 140;
    public static final int TARGET_LOW = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        context = this;
        Intent receiveUser = getIntent();
        mockUser = (User) receiveUser.getSerializableExtra("user");



        averageDisplay = findViewById(R.id.profile_info_average);
        targetLowDisplay = findViewById(R.id.profile_info_target_low);
        targetHighDisplay = findViewById(R.id.profile_info_target_high);
        infoTextView = findViewById(R.id.profile_info_navigation);
        infoTextView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        glucoseGraph = findViewById(R.id.glucose_graph);

        glucoseGraph.getViewport().setYAxisBoundsManual(true);
        glucoseGraph.getViewport().setMaxY(175);
        glucoseGraph.getViewport().setMinY(TARGET_LOW);
        glucoseGraph.getViewport().setScalable(true);
        glucoseGraph.getViewport().setXAxisBoundsManual(true);
        glucoseGraph.getViewport().setMinX(0);
        glucoseGraph.getViewport().setMaxX(30);
        glucoseGraph.getGridLabelRenderer().setHighlightZeroLines(true);
        glucoseGraph.getGridLabelRenderer().setVerticalAxisTitle("Glucose Level");
        glucoseGraph.getGridLabelRenderer().setHorizontalAxisTitle("History (Days)");
        targetHighDisplay.setText("Target High: " + TARGET_HIGH);
        targetLowDisplay.setText("Target Low:  "+TARGET_LOW);



        PointsGraphSeries targetGlucoseLow = new PointsGraphSeries<>();
        targetGlucoseLow.setSize(5);
        for(int i = 0;i  < mockUser.bloodSugarArray.size();i++){
            DataPoint newDataPoint = new DataPoint((i),mockUser.bloodSugarArray.get(i));
            targetGlucoseLow.appendData(newDataPoint,true,mockUser.bloodSugarArray.size());

        }



//        Date date = Date.valueOf("2019-02-01T04:48:48Z");
        targetGlucoseLow.setTitle("Glucose Level" );
        glucoseGraph.addSeries(targetGlucoseLow);

        LineGraphSeries targetGlucoseHigh = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0,140),
                new DataPoint(145,140),

        });
        targetGlucoseHigh.setColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));

        glucoseGraph.addSeries(targetGlucoseHigh);



        LineGraphSeries targetSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 80),
                new DataPoint(145, 80),


        });
        targetSeries.setColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));
        glucoseGraph.addSeries(targetSeries);
        infoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userInformation = new Intent(context, UserInformationPage.class);
                //todo: put users info into intent to autofill
                userInformation.putExtra("user",mockUser);
                startActivity(userInformation);
            }
        });
    }



}
