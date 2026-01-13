package easv.college.examassignment.bll;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.be.Movie;
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

    public List<Category> filterCategory(Category category) 
    {
        // this should accept search text and rating
        // return the movies
        // public List<MovieWithCategories> filterMovies(String searchText, int rating)
        return null;
    }
    public List<Movie>filterMovies(String searchText, Integer minRating)
    { List<Movie> movies = dao.getMovieDAO().getMovies();
        return movies.stream().filter(movie -> matchesSearchText(movie,searchText)).filter(movie -> matchesRating(movie,minRating)).toList();
    }
    private boolean matchesSearchText (Movie movie, String searchText){
        if(searchText == null || searchText.isBlank()){
            return true;
        }
        return movie.getName().toLowerCase().contains(searchText.toLowerCase());
    }
    private boolean matchesRating (Movie movie, Integer minRating){
        if (minRating == null){
            return true;
        }
        return movie.getImdbRating() >= minRating;
    }
}
