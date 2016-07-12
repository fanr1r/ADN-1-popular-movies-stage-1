package com.example.android.popularmovies;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailActivityFragment extends Fragment {

    private Movie mMovie;

    public MovieDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        if (intent != null && intent.hasExtra(getString(R.string.intent_extra_movie))) {
            mMovie = intent.getParcelableExtra(getString(R.string.intent_extra_movie));
        }

        TextView titleTextView = (TextView) rootView.findViewById(R.id.title);
        titleTextView.setText(mMovie.title);

        ImageView thumbnailImageView = (ImageView) rootView.findViewById(R.id.thumbnail);
        final String FORECAST_BASE_URL = "http://image.tmdb.org/t/p/";
        String imageSize = "w185";
        String url = FORECAST_BASE_URL + imageSize + "/" + mMovie.posterPath;
        Picasso.with(getContext()).load(url).into(thumbnailImageView);

        TextView synopsisTextView = (TextView) rootView.findViewById(R.id.synopsis);
        synopsisTextView.setText(mMovie.plotSynopsis);

        RatingBar ratingBar = (RatingBar) rootView.findViewById(R.id.ratingBar);
        ratingBar.setRating((Float.valueOf(String.valueOf(mMovie.userRating))));

        TextView rateTextView = (TextView) rootView.findViewById(R.id.rateValue);
        rateTextView.setText("(" + mMovie.userRating + ")");

        TextView releaseDateTextView = (TextView) rootView.findViewById(R.id.releaseDate);
        releaseDateTextView.setText(mMovie.releaseDate);

        return rootView;
    }
}
