package easv.college.examassignment.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import easv.college.examassignment.be.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    ConnectionManager conMan = new ConnectionManager();

    public List<Movie> getMovies() throws SQLException {
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
                movies.add(new Movie (id, name, rating, userrating, lastview, filelink));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving movies: " + e.getMessage());
        }
        return movies;
    }

    public void AddMovie(Movie movie) throws SQLException {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Movie (name, rating, fileLink, lastView, userrating) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, movie.getName());
            stmt.setFloat(2, movie.getImdbRating());
            stmt.setString(3, movie.getFileLink());
            stmt.setDate(4, movie.getLastView());
            stmt.setFloat(5, movie.getUserRating());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error adding movie: " + e.getMessage());
        }
    }

    public void DeleteMovie(Movie movie) throws SQLException {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE Movie WHERE id = ?");
            stmt.setInt(1, movie.getId());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error deleting movie: " + e.getMessage());
        }
    }

    public void UpdateMovie(Movie movie) {
        try (Connection con = conMan.getConnection()) {
            //ToDo : Implement update movie
        }
        catch (SQLException e) {
            System.err.println("Error updating movie: " + e.getMessage());
        }
    }
}
