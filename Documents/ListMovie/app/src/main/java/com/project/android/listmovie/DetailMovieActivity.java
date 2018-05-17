package com.project.android.listmovie;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.android.listmovie.retrofitService.SearchService;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String MOVIE_DETAIL = "movie_detail";
    public static final String IMAGE_URL = "image_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        final SearchService.Detail detail = getIntent().getParcelableExtra(MOVIE_DETAIL);
        final String imageUrl =  getIntent().getStringExtra(IMAGE_URL);
        Glide.with(this).load(imageUrl).into( (ImageView) findViewById(R.id.main_backdrop));

        // set title for the appbar
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapsing);
        collapsingToolbarLayout.setTitle(detail.Title);

        ((TextView) findViewById(R.id.txtView_title_detail_movie)).setText(detail.Title);
        ((TextView) findViewById(R.id.txtView_rating_detail_movie)).setText(detail.Rated);
        ((TextView) findViewById(R.id.txtView_genre_detail_movie)).setText(detail.Genre);
        ((TextView) findViewById(R.id.txtView_year_detail_movie)).setText(detail.Year);
        ((TextView) findViewById(R.id.txtView_description_detail_movie)).setText(detail.Plot);
        ((TextView) findViewById(R.id.txtView_runtime_detail_movie)).setText(detail.Runtime);

    }

}
