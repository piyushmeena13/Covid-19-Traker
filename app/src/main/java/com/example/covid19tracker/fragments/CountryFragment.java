package com.example.covid19tracker.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.covid19tracker.R;
import com.example.covid19tracker.covidIndia;
import com.example.covid19tracker.recyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<covidIndia> covidIndiaArrayList=new ArrayList<>();
    ProgressBar progressBar;


    public CountryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView =view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar=view.findViewById(R.id.progressBar2);

        fetchdata();

    }

    private void fetchdata() {
        String url="https://api.covid19india.org/data.json";

        final StringRequest request =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject =new JSONObject(response.toString());
                    JSONArray jsonArray =jsonObject.getJSONArray("statewise");
                    for(int i=1;i<jsonArray.length();i++)
                    {
                        JSONObject data= jsonArray.getJSONObject(i);
                        covidIndiaArrayList.add(new covidIndia(data.getString("state"),
                                data.getString("confirmed"),data.getString("active"),
                                data.getString("recovered"),data.getString("deaths")));
                    }
                    
                    progressBar.setVisibility(View.INVISIBLE);
                    // uppar work nhi kr rha h jese hi arraylist me data ayega wese hi call krdo
                    recyclerView.setAdapter(new recyclerViewAdapter(covidIndiaArrayList));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}
