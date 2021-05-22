package com.example.covid19tracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder> {

    ArrayList<covidIndia> covidIndiaArrayList=new ArrayList<>();

    public recyclerViewAdapter(ArrayList<covidIndia> covidIndiaArrayList) {
        this.covidIndiaArrayList = covidIndiaArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.recycler_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.stateName.setText(covidIndiaArrayList.get(position).getStateName());
        holder.totalCases.setText(covidIndiaArrayList.get(position).getTotalCases());
        holder.activeCases.setText(covidIndiaArrayList.get(position).getActiveCases());
        holder.recovered.setText(covidIndiaArrayList.get(position).getRecovered());
        holder.totalDeaths.setText(covidIndiaArrayList.get(position).getTotalDeaths());
    }

    @Override
    public int getItemCount() {
        return covidIndiaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView totalCases,activeCases,recovered,totalDeaths,stateName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            stateName = itemView.findViewById(R.id.state_TV);
            totalCases = itemView.findViewById(R.id.total_casesTV);
            activeCases = itemView.findViewById(R.id.active_casesTV);
            recovered = itemView.findViewById(R.id.recoveredTV);
            totalDeaths = itemView.findViewById(R.id.total_deathTV);

        }
    }
}
