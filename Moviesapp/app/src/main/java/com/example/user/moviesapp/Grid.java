package com.example.user.moviesapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Grid extends Fragment {
    ArrayList<Movie> movie_data = new ArrayList<>();
    List<Movie> movies;
    GridView moviesView;
    TextView text;
    MovieGridAdapter adapter;
    DatabaseHandler db;
    Intent j;
   @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.activity_grid,container,false);
        db = new DatabaseHandler(getContext());
        moviesView = (GridView)v.findViewById(R.id.moviesView);


        movies = db.getAllMovies();
        for (Movie mv : movies) {

                movie_data.add(mv);

        }


            adapter = new MovieGridAdapter(getContext(), R.layout.grid_element, movie_data);
            moviesView.setAdapter(adapter);


        j = new Intent(getContext(), Detailed.class);

        moviesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                j.putExtra("imdbID", movie_data.get(i).getImdbId());
                startActivity(j);
            }
        });

        return v;
    }




}
