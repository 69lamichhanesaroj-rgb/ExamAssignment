package easv.college.examassignment.dal;


import easv.college.examassignment.be.Movie;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    ConnectionManager conMan = new ConnectionManager();
    CatMovieDAO catMovieDAO = new CatMovieDAO();

    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection con = conMan.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.Movie");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Float rating = rs.getFloat("rating");
                String filelink = rs.getString("filelink");
                Date lastview = rs.getDate("lastview");
                Float userrating = rs.getFloat("userrating");
                movies.add(new Movie (id, name, rating, userrating, lastview, filelink, catMovieDAO.getCatMovies(id)));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving movies: " + e.getMessage());
        }
        return movies;
    }

    public void addMovie(String name, Float rating, String fileLink, Date lastView, Float userRating) {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Movie (name, rating, fileLink, lastView, userrating) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setFloat(2, rating);
            stmt.setString(3, fileLink);
            stmt.setDate(4, lastView);
            stmt.setFloat(5, userRating);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error adding movie: " + e.getMessage());
        }
    }

    public void deleteMovie(Movie movie) {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE Movie WHERE id = ?");
            stmt.setInt(1, movie.getId());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error deleting movie: " + e.getMessage());
        }
    }

    public void updateMovie(Movie movie) {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE Movie SET name = ?, rating = ?, userRating = ?, lastView = ?, fileLink = ? WHERE id = ?");

            stmt.setString(1, movie.getName());
            stmt.setFloat(2, movie.getImdbRating());
            stmt.setString(3, movie.getFileLink());
            stmt.setDate(4, movie.getLastView());
            stmt.setFloat(5, movie.getUserRating());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error updating movie: " + e.getMessage());
        }
    }
}
