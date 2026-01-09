package easv.college.examassignment.bll;

import easv.college.examassignment.be.*;
import easv.college.examassignment.dal.DAOManager;

import java.io.IOException;
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

    public void createMovie(Movie movie)
    {
        dao.getMovieDAO().AddMovie(movie);
    }

    public void updateMovie(Movie movie)
    {
        dao.getMovieDAO().UpdateMovie(movie);
    }

    public void deleteMovie(Movie movie) 
    {
        dao.getMovieDAO().DeleteMovie(movie);
    }

    public List<Category> getAllCategories() 
    {
        return dao.getCategoryDAO().getCategories();
    }

    public void createCategory(Category category) 
    {
        dao.getCategoryDAO().addCategory(category);
    }

    public void updateCategory(Category category) 
    {
        dao.getCategoryDAO().UpdateCategory(category);
    }

    public void deleteCategory(Category category) 
    {
        dao.getCategoryDAO().DeleteCategory(category);
    }

    public List<MovieWithCategories> filterMovies(String query) 
    {
        return null;
    }

    public List<Category> filterCategory(Category category) 
    {
        return null;
    }
}
