package com.example.android;

//TODO: STEPS 11+ ARE ON MAIN ACTIVITY (OR WHICHEVER ACTIVITY YOU WANT TO HAVE THE LIST)
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.SampleViewHolder> {


    ArrayList<Reading> entryData;



    public ListAdapter(ArrayList<Reading> entryData) {
        this.entryData = entryData;
    }

    @NonNull
    @Override
    //create an instance of our viewholder which is our connection to the layout
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new SampleViewHolder(itemView);
    }

    @Override
    //bind an element from our list of data to the provided viewholder
    public void onBindViewHolder(@NonNull SampleViewHolder sampleViewHolder, int i) {
//TODO: 10:) bind the data from the object to the views.
        Reading data = entryData.get(i);
        sampleViewHolder.entryNumberView.setText(String.valueOf(i));
        sampleViewHolder.entryTimeView.setText(String.valueOf(data.getTime()));
        sampleViewHolder.entryReadingView.setText(String.valueOf(data.getReading()));
        //reiterate all this through the object to place your items (image,names,id, etc.)
        sampleViewHolder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sampleIntent = new Intent(v.getContext(),MainActivity.class);
                //..............
                v.getContext().startActivity(sampleIntent);// can also use startActivityForResult(intent,requestCode)
                //^ to start an intent from an onclick from outside of an activity.

            }
        });
    }

    @Override
    //used by the recyclerview to know when to stop
    public int getItemCount() {
        return this.entryData.size();
    }
    //our connection to the views in the layout
    class SampleViewHolder extends RecyclerView.ViewHolder{

        TextView entryNumberView, entryTimeView,entryReadingView,entryNumberTextView,entryTimeTextView,entryReadingTextView;
        View parentView;
        //bind the datamembers of our viewholder to the items in the layout
        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);
            entryNumberView = itemView.findViewById(R.id.entry_number);
            entryTimeView = itemView.findViewById(R.id.entry_time);
            parentView = itemView.findViewById(R.id.list_parent);
            entryReadingView = itemView.findViewById(R.id.entry_reading);
            entryNumberTextView = itemView.findViewById(R.id.entry_number_view);
            entryTimeTextView = itemView.findViewById(R.id.textView);
            entryReadingTextView = itemView.findViewById(R.id.textView2);
        }
    }
}
