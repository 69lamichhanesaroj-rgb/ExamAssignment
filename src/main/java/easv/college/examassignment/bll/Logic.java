package easv.college.examassignment.bll;

import easv.college.examassignment.be.Category;
import easv.college.examassignment.be.Movie;
import easv.college.examassignment.be.*;
import easv.college.examassignment.dal.DAOManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
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

    public void editMovie(Movie movie) {dao.getMovieDAO().updateMovie(movie);
    }
    public void playMovie(Movie movie) {
        try{
            File file = new File(movie.getFileLink());

            if(!file.exists()){
                throw new IOException("File not found");
            }

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }
        } catch (IOException e){
            System.err.println("Error playing movie: " + e.getMessage());
        }
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
}
