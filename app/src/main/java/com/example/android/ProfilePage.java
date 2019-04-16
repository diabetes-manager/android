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
        glucoseGraph.getViewport().setMaxY(140);
        glucoseGraph.getViewport().setMinY(40);

        glucoseGraph.getGridLabelRenderer().setVerticalAxisTitle("Glucose Level");
        glucoseGraph.getGridLabelRenderer().setHorizontalAxisTitle("Day #");
        targetHighDisplay.setText("Target High: "+mockUser.getTargetGlucoseHigh());
        targetLowDisplay.setText("Target Low:  "+mockUser.getTargetGlucoseLow());



        BarGraphSeries targetGlucose = new BarGraphSeries(new DataPoint[]{
                new DataPoint(0,mockUser.getGlucoseHigh()),
                new DataPoint(0,mockUser.getGlucoseLow()),
                new DataPoint(1,mockUser.getGlucoseHigh()),
                new DataPoint(1,mockUser.getGlucoseLow()),
                new DataPoint(2,mockUser.getGlucoseHigh()),
                new DataPoint(2,mockUser.getGlucoseLow()),
                new DataPoint(3,mockUser.getGlucoseHigh()),
                new DataPoint(3,mockUser.getGlucoseLow()),

        });
        targetGlucose.setTitle("Glucose Level");
        targetGlucose.setColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));
//        targetGlucose.setBackgroundColor(getResources().getColor(R.color.colorPrimaryAlienArmpit));
        glucoseGraph.addSeries(targetGlucose);



        PointsGraphSeries targetSeries = new PointsGraphSeries(new DataPoint[]{
           new DataPoint(0,mockUser.getTargetGlucoseHigh()),
           new DataPoint(1,mockUser.getTargetGlucoseLow())});
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
