package easv.college.examassignment.dal;

import easv.college.examassignment.be.Movie;

import java.sql.*;
import java.time.LocalDate;
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

    /**
     * Used to create a new movie in the database
     */
    public void createMovie(Movie movie) throws SQLException {
        String sql = "INSERT INTO Movie (name, userRating, imdbRating, fileLink, lastView) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = conMan.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setString(1, movie.getName());
            stmt.setFloat(2, movie.getUserRating() != null ? movie.getUserRating() : 0);
            stmt.setFloat(3, movie.getImdbRating() != null ? movie.getImdbRating() : 0);
            stmt.setString(4, movie.getFileLink());
            stmt.setDate(5, movie.getLastView() != null ? Date.valueOf(movie.getLastView()) : null);

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error adding movie: " + e.getMessage());
        }
    }

    /**
     * Helper method to get a Movie object from ResultSet
     * @param rs
     * @return
     * @throws SQLException
     */
    private Movie getMovieFromResultSet(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        Float userRating = rs.getFloat("userRating");
        Float imdbRating = rs.getFloat("imdbRating");
        String fileLink = rs.getString("fileLink");
        Date lastView = rs.getDate("lastView");

        return new Movie(id, name, userRating, imdbRating, lastView, fileLink);
    }
}
