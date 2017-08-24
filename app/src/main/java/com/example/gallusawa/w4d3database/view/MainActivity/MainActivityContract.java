package com.example.gallusawa.w4d3database.view.MainActivity;

import android.graphics.Movie;

import com.example.gallusawa.w4d3database.BasePresenter;
import com.example.gallusawa.w4d3database.BaseView;

import java.util.List;

/**
 * Created by gallusawa on 8/23/17.
 */

public class MainActivityContract {

    interface View extends BaseView {
        void onDataSaved(boolean isSaved);

        void updateTextView();

        void updateMovieList(List<Movie> movieList);
    }

    interface Presenter extends BasePresenter<View> {

        void getMovies();

        void init();

        void pushMovieToDb(Movie movie);


    }
}
