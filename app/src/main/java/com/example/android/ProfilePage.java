package com.example.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ProfilePage extends AppCompatActivity {
    Context context;
    TextView infoTextView;
    GraphView glucoseGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        context = this;
        infoTextView = findViewById(R.id.profile_info_navigation);
        infoTextView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        glucoseGraph = findViewById(R.id.glucose_graph);
        LineGraphSeries glucoseSeries = new LineGraphSeries(new DataPoint[]{
                new DataPoint(0,100),
                new DataPoint(1,78),
                new DataPoint(13,110),
                new DataPoint(23,20)
        });
        glucoseGraph.getViewport().setMaxY(150);
        glucoseSeries.setTitle("Glucose Level");
        glucoseSeries.setColor(Color.BLUE);
        glucoseSeries.setDrawDataPoints(true);
        glucoseGraph.getGridLabelRenderer().setVerticalAxisTitle("Glucose Level");
        glucoseGraph.getGridLabelRenderer().setHorizontalAxisTitle("Day #");
        glucoseSeries.setDataPointsRadius(10);
        glucoseGraph.addSeries(glucoseSeries);


        infoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userInformation = new Intent(context, UserInformationPage.class);
                //todo: put users info into intent to autofill
                startActivity(userInformation);
            }
        });
    }
}
