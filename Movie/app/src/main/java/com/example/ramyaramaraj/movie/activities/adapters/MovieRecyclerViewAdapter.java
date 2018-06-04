package com.example.ramyaramaraj.movie.activities.adapters;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ramyaramaraj.movie.R;
import com.example.ramyaramaraj.movie.activities.MovieDetailActivity;
import com.example.ramyaramaraj.movie.activities.models.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.io.Serializable;
import java.util.List;
public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Movie> movies;
    public  MovieRecyclerViewAdapter(Context context,List<Movie> movies) {
     this.context=context;
     this.movies=movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie=movies.get(position);
        holder.Rtitle.setText(movie.getTitle());
        holder.Roverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath()).resize(300,300).into(holder.Rimage);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public Context getContext() {
        return context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.Rimage)
        ImageView Rimage;
        @BindView(R.id.Rtitle)
        TextView Rtitle;
        @BindView(R.id.Roverview)
        TextView Roverview;
        @BindView(R.id.cvmovie)
        CardView cvmovie;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Movie movie=movies.get(getAdapterPosition());
            Intent intent=new Intent(getContext(), MovieDetailActivity.class);
            intent.putExtra("MOVIE", movie);
            getContext().startActivity(intent);
        }
    }
}
