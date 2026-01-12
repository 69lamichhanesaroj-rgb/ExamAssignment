package easv.college.examassignment.bll;

import easv.college.examassignment.be.*;
import easv.college.examassignment.dal.DAOManager;

import java.sql.Date;
import java.util.List;

public class Logic
{
    private final DAOManager dao;

    public Logic()
    {
        dao = new DAOManager();
    }

    public List<Movie> getAllMovies() 
    {
        return dao.getMovieDAO().getMovies();
    }

    public void createMovie(String name, Float imdbRating, String fileLink, Date lastView, Float userRating)
    {
        dao.getMovieDAO().addMovie(name, imdbRating, fileLink, lastView, userRating);
    }

    public void updateMovie(Movie movie)
    {
        dao.getMovieDAO().updateMovie(movie);
    }

    public void deleteMovie(Movie movie) 
    {
        dao.getMovieDAO().deleteMovie(movie);
    }

    public void editMovie(Movie movie)
    {
        dao.getMovieDAO().updateMovie(movie);
    }

    public List<Category> getAllCategories() 
    {
        return dao.getCategoryDAO().getCategories();
    }

    public void createCategory(Category category) 
    {
        dao.getCategoryDAO().addCategory(category);
    }

    public void deleteCategory(Category category) 
    {
        dao.getCategoryDAO().deleteCategory(category);
    }

    public List<MovieWithCategories> filterMovies(String query)
    {
        return dao.getCatMovieDAO().searchMovies(query);
    }

    public List<Category> filterCategory(Category category) 
    {
        return null;
    }
}
