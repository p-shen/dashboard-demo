package com.vaadin.demo.dashboard.data.db;

import com.vaadin.demo.dashboard.data.HibernateManager;
import com.vaadin.demo.dashboard.data.db.models.MoviesEntity;
import com.vaadin.demo.dashboard.domain.Movie;
import org.hibernate.Session;

import java.util.Collection;
import java.util.List;

/**
 * Created by Peter - 2016-07-28
 *
 * 2016-07-28:
 *  DAO to access movies in the database
 *  Unprocessed data is stored into MoviesEntity class
 *  Processed data is stored into Movie class, which is used for several UI views in dashboard
 */
public class MoviesDAO {

    private static final Session session = HibernateManager.getSession();

    /**
     * Get the unprocessed movie entity data imported from the json text
     * @return List<MovieEntity>
     */
    public static List<MoviesEntity> getMoviesEntity() {
        List<MoviesEntity> ret = session.createQuery("from MoviesEntity").list();
        session.close();
        return ret;
    }

    /**
     * Get the processed movie data used for UI views
     * @return Collection<Movie>
     */
    public static Collection<Movie> getMovies() {
        Collection<Movie> ret = session.createQuery("from Movie").list();
        session.close();
        return ret;
    }


}