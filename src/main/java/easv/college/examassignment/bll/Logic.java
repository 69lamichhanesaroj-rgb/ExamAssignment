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

    public List<Movie> getAllMovies() throws Exception
    {
        return dao.getMovieDAO().getAllMovies();
    }

    public void createMovie(Movie movie) throws Exception
    {
        dao.getMovieDAO().createMovie(movie);
    }

    public void updateMovie(Movie movie) throws Exception
    {
        dao.getMovieDAO().UpdateMovie(movie);
    }

    public void deleteMovie(Movie movie) throws Exception
    {
        dao.getMovieDAO().DeleteMovie();
    }

    public List<Category> getAllCategories() throws Exception
    {
        return dao.getCategoryDAO().getCategories();
    }

    public void createCategory(Category category) throws Exception
    {
        dao.getCategoryDAO().addCategory(category);
    }

    public void updateCategory(Category category) throws Exception
    {
        dao.getCategoryDAO().UpdateCategory(category);
    }

    public void deleteCategory(Category category) throws Exception
    {
        dao.getCategoryDAO().DeleteCategory();
    }

    public List<MovieWithCategories> filterMovies(String query) throws Exception
    {
        return null;
    }

    public List<Category> filterCategory(Category category) throws Exception
    {
        return null;
    }

    public void addCategoryToMovie(Category category) throws Exception
    {
        dao.getCatMovieDAO().addCatMovie();
    }
}
