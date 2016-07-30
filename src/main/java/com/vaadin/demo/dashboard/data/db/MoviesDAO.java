package com.vaadin.demo.dashboard.data.db;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vaadin.demo.dashboard.data.HibernateManager;
import com.vaadin.demo.dashboard.data.db.models.MovieListEntity;
import com.vaadin.demo.dashboard.data.db.models.MoviesEntity;
import com.vaadin.demo.dashboard.domain.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.ExceptionConverter;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

public class MoviesDAO {

    private final static Session session = HibernateManager.getSession();

    public static void main(String[] args) {

//        loadMoviesDataIntoDB();

        List<MoviesEntity> moviesList = getMoviesEntity();
        Collection<Movie> moviesProcessedList = getMovies();
        System.out.println(moviesList.get(0).getTitle());

        HibernateManager.close();

    }

    public static void loadMoviesDataIntoDB() {

        //if the data is already loaded into the database
        if (null != getMovies() && getMovies().size() > 0) {
            return;
        }

        final Session session = HibernateManager.getSession();

        try {
            File currentDir = new File("").getAbsoluteFile();
            FileReader jsonData = new FileReader(currentDir + "/src/main/resources//movies-fallback.txt");
            MovieListEntity movieList = new Gson().fromJson(jsonData, MovieListEntity.class);

            if (null != movieList && null != movieList.getMovies() && movieList.getMovies().size() > 0) {
                Transaction trx = session.beginTransaction();

                movieList.getMovies().stream().forEach(movie -> {

                    //processing movies to be used in the dashboard
                    Movie movieProcessed = new Movie();

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

    private static List<MoviesEntity> getMoviesEntity() {
        return session.createQuery("from MoviesEntity").list();
    }

    public static Collection<Movie> getMovies() {
        return session.createQuery("from Movie").list();
    }


}