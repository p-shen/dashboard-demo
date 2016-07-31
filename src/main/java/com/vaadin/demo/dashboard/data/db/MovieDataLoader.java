package com.vaadin.demo.dashboard.data.db;

import com.google.gson.Gson;
import com.vaadin.demo.dashboard.data.HibernateManager;
import com.vaadin.demo.dashboard.data.db.models.MovieListEntity;
import com.vaadin.demo.dashboard.domain.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Peter on 2016-07-30.
 *
 * 2016-07-30:
 *  Loader used to load the movie data from the JSON file movies-fallback.txt into the database
 *  At the same time, the movies are processed into the object used by the old UI code
 */
public class MovieDataLoader {
    public static void loadMoviesDataIntoDB() {

        MoviesDAO movieDAO = new MoviesDAO();

        //if the data is already loaded into the database then do not reload
        if (null != movieDAO.getMovies() && movieDAO.getMovies().size() > 0) {
            return;
        }

        final Session session = HibernateManager.getSession();

        try {
            //retrieve the JSON file
            File currentDir = new File("").getAbsoluteFile();
            FileReader jsonData = new FileReader(currentDir + "/src/main/resources//movies-fallback.txt");

            //Convert from JSON into MovieListEntity POJO
            MovieListEntity movieList = new Gson().fromJson(jsonData, MovieListEntity.class);

            if (null != movieList && null != movieList.getMovies() && movieList.getMovies().size() > 0) {
                Transaction trx = session.beginTransaction();

                movieList.getMovies().stream().forEach(movie -> {

                    //processing movies to be used in the dashboard
                    Movie movieProcessed = new Movie();

                    //manually copying the data from MovieEntity ("unprocessed data") into Movie ("processed data")
                    //so that it can be used in the UI views without changing the old code
                    movieProcessed.setMovieEntity(movie);

                    movieProcessed.setId(movie.getId());
                    movieProcessed.setTitle(movie.getTitle());

                    try {
                        movieProcessed.setDuration(movie.getRuntime());
                    } catch (Exception e){
                        //no catch handling
                    }

                    movieProcessed.setSynopsis(movie.getSynopsis());
                    movieProcessed.setThumbUrl(movie.getPosters().getProfile().replace("_tmb", "_320"));
                    movieProcessed.setPosterUrl(movie.getPosters().getDetailed().replace("_tmb", "_640"));

                    try {
                        String datestr = movie.getRelease_dates().getTheater();
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        movieProcessed.setReleaseDate(df.parse(datestr));
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                    try {
                        movieProcessed.setScore(movie.getRatings().getCritics_score());
                    } catch (Exception e){
                        //no catch handling
                    }

                    session.save(movie);
                    session.save(movieProcessed);
                });

                session.flush();
                trx.commit();
                session.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
