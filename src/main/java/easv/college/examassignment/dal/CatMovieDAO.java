package easv.college.examassignment.dal;

import easv.college.examassignment.be.CatMovie;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatMovieDAO {
    ConnectionManager conMan;
    public CatMovieDAO() throws IOException {
        conMan = new ConnectionManager();
    }

    public List<CatMovie> getCatMovies() throws SQLException {
        List<CatMovie> catMovie = new ArrayList<>();
        try (Connection con = conMan.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.CatMovie");
            while (rs.next()) {
                int categoryId = rs.getInt("categoryId");
                int movieId = rs.getInt("movieId");
                catMovie.add(new CatMovie(categoryId, movieId));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving CatMovie: " + e.getMessage());
        }
        return catMovie;
    }

    public void addCatMovie(CatMovie catMovie) throws SQLException {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO CatMovie (categoryId, movieId) VALUES (?, ?)");
            stmt.setInt(1, catMovie.getCategoryId());
            stmt.setInt(2, catMovie.getMovieId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding CatMovie: " + e.getMessage());
        }
    }

}
