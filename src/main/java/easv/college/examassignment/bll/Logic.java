package easv.college.examassignment.bll;

import easv.college.examassignment.dal.CatMovieDAO;
import easv.college.examassignment.be.*;

import java.io.IOException;
import java.util.List;

public class Logic
{
    private final CatMovieDAO dao;

    public Logic() throws IOException
    {
        dao = new CatMovieDAO();
    }

    public List<Movie> getAllMovies() throws Exception
    {
        return null;
    }

    public void createMovie(Movie movie) throws Exception
    {

    }

    public void updateMovie(Movie movie) throws Exception
    {

    }

    public void deleteMovie(Movie movie) throws Exception
    {

    }

    public List<Category> getAllCategories() throws Exception
    {
        return null;
    }

    public void createCategory(Category category) throws Exception
    {

    }

    public void updateCategory(Category category) throws Exception
    {

    }

    public void deleteCategory(Category category) throws Exception
    {

    }

    public List<Movie> filterMovies(String query) throws Exception
    {
        return null;
    }

    public List<Category> filterCategory(Category category) throws Exception
    {
        return null;
    }

    public void addCategoryToMovie(Category category) throws Exception
    {

    }
}
