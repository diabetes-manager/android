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

import java.util.ArrayList;

public class ProfilePage extends AppCompatActivity {
    Context context;
    TextView infoTextView;
    GraphView glucoseGraph;
    User mockUser;
    Button targetHighDisplay,targetLowDisplay,averageDisplay;

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
        glucoseGraph.getViewport().setMaxY(mockUser.getTargetGlucoseHigh()+30);
        glucoseGraph.getViewport().setMinY(40);
        glucoseGraph.getViewport().setScalable(true);
        glucoseGraph.getViewport().setXAxisBoundsManual(true);
        glucoseGraph.getViewport().setMinX(0);
        glucoseGraph.getViewport().setMaxX(24);

        glucoseGraph.getGridLabelRenderer().setHighlightZeroLines(true);
        glucoseGraph.getGridLabelRenderer().setVerticalAxisTitle("Glucose Level");
        glucoseGraph.getGridLabelRenderer().setHorizontalAxisTitle("Time");
        targetHighDisplay.setText("Target High: "+mockUser.getTargetGlucoseHigh());
        targetLowDisplay.setText("Target Low:  "+mockUser.getTargetGlucoseLow());



        LineGraphSeries targetGlucoseLow = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0,mockUser.getGlucoseLow()),
                new DataPoint(24,mockUser.getGlucoseLow()),

        });
        targetGlucoseLow.setTitle("Glucose Level");
        targetGlucoseLow.setColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));
//        targetGlucose.setBackgroundColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));
        glucoseGraph.addSeries(targetGlucoseLow);

        LineGraphSeries targetGlucoseHigh = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0,mockUser.getTargetGlucoseHigh()),
                new DataPoint(24,mockUser.getTargetGlucoseHigh()),

        });
        targetGlucoseHigh.setColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));

//        targetGlucose.setBackgroundColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));
        glucoseGraph.addSeries(targetGlucoseHigh);



        LineGraphSeries targetSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 110),
                new DataPoint(1, 103),
                new DataPoint(2, 101),
                new DataPoint(3, 89)

        });
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
