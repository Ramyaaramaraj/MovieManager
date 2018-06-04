package com.example.ramyaramaraj.movie.activities.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramyaramaraj.movie.R;
import com.example.ramyaramaraj.movie.activities.adapters.MovieRecyclerViewAdapter;
import com.example.ramyaramaraj.movie.activities.models.Movie;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UpcomingFragment extends Fragment {


    @BindView(R.id.recyclerviewmovie)
    RecyclerView recyclerviewmovie;
    private List<Movie> movies;
    public UpcomingFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        ButterKnife.bind(this, view);
        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        recyclerviewmovie.setHasFixedSize(true);
        recyclerviewmovie.setLayoutManager(llm);
        MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(this.getContext(), movies);
        recyclerviewmovie.setAdapter(adapter);
        return view;
    }
    private void initializeData() {
        movies = new ArrayList<>();
        movies.add(new Movie("277834", "Rings", "Julia (Matilda Lutz) becomes worried about her boyfriend, Holt (Alex Roe) when he explores the dark urban legend of a mysterious videotape said to kill the watcher seven days after viewing. She sacrifices herself to save her boyfriend and in doing so makes a horrifying discovery: there is a \\\"movie within the movie\\\" that no one has ever seen before.", 0f, 0, "https://i.ytimg.com/vi/CtRljLPPOQI/maxresdefault.jpg", "/91WPDonXsxRzi7AcfedKM3p3NFU.jpg"));
        movies.add(new Movie("121856", "The Great Wall", "The story of an elite force making a last stand for humanity on the world’s most iconic structure.", 0f, 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKUKMCnWLYvy6zeXgAlWpD_T_09bjrj9PEXJVlZ-4Z7YrASXa9_g", "/yESCAoZkaxZ2AMiHojl9jYYd9zD.jpg"));
        movies.add(new Movie("330459", "Patriots Day", "An account of Boston Police Commissioner Ed Davis's actions in the events leading up to the 2013 Boston Marathon bombing and the aftermath, which includes the city-wide manhunt to find the terrorists behind it.", 0f, 0, "https://saltypopcorn.com.au/wp-content/uploads/2017/01/Patriots_Day_Onesheet_AU_LR.jpg", "/tiBL4PeaCPKGBz3qO4dJP2KzKop.jpg"));
        movies.add(new Movie("283366", "T2 Trainspotting", "First there was an opportunity......then there was a betrayal. Twenty years have gone by. Much has changed but just as much remains the same. ", 0f, 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwkZiniWFLpGKIRWcJof_JA74FHBBl7U_mXdG30IaJSzVDXYICbg", "/dxJynNxoG6jRttYPoXOGx7OWJvq.jpg"));

    }
}
