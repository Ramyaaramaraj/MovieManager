package com.example.ramyaramaraj.movie.activities.fragments;



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

/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {

    @BindView(R.id.recyclerviewmovie)
    RecyclerView recyclerviewmovie;
    public List<Movie> movies;

    public NowPlayingFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_now_playing, container, false);
        ButterKnife.bind(this, view);
        initializeData();
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());

        recyclerviewmovie.setHasFixedSize(true);
        recyclerviewmovie.setLayoutManager(llm);

        MovieRecyclerViewAdapter adapter =  new MovieRecyclerViewAdapter(getContext(),movies);
        recyclerviewmovie.setAdapter(adapter);


        return view;
    }

    private void initializeData() {
        movies = new ArrayList<>();
        movies.add(new Movie("277834", "Moana", "In Ancient Polynesia, when a terrible curse incurred by Maui reaches an impetuous Chieftain's daughter's island, she answers the Ocean's call to seek out the demigod to set things right.", 6.5f, 854, "https://i.ytimg.com/vi/_h5qmAiTnV8/movieposter.jpg", "https://i.ytimg.com/vi/_h5qmAiTnV8/movieposter.jpg"));
        movies.add(new Movie("121856", "Passengers", "A spacecraft traveling to a distant colony planet and transporting thousands of people has a malfunction in its sleep chambers. As a result, two passengers are awakened 90 years early.", 6.2f,  745, "https://is3-ssl.mzstatic.com/image/thumb/Video122/v4/66/27/d7/6627d799-46d5-c29e-e17f-7848bd3d635e/source/227x227bb.jpg", "https://is3-ssl.mzstatic.com/image/thumb/Video122/v4/66/27/d7/6627d799-46d5-c29e-e17f-7848bd3d635e/source/227x227bb.jpg"));
        movies.add(new Movie("330459", "Assassin's Creed", "Lynch discovers he is a descendant of the secret Assassins society through unlocked genetic memories that allow him to relive the adventures of his ancestor, Aguilar, in 15th Century Spain. After gaining incredible knowledge and skills he’s poised to take on the oppressive Knights Templar in the present day.", 5.3f, 691, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQxnzDr6M3MjTBdeyMzMkoNEht7z8GxwnmLmlEb9gCL0iudea8", "/5EW4TR3fWEqpKsWysNcBMtz9Sgp.jpg"));
        movies.add(new Movie("283366", "Rogue One: A Star Wars Story", "A rogue band of resistance fighters unite for a mission to steal the Death Star plans and bring a new hope to the galaxy.", 7.2f, 1802, "https://images-na.ssl-images-amazon.com/images/I/61cPoerQkNL._SX342_.jpg", "/tZjVVIYXACV4IIIhXeIM59ytqwS.jpg"));
        movies.add(new Movie("313369", "La La Land", "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.", 8, 396, "https://i.pinimg.com/originals/8c/9f/46/8c9f46675ed52b33748ff325885405ae.jpg", "/nadTlnTE6DdgmYsN4iWc2a2wiaI.jpg"));

    }
    }

