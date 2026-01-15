package easv.college.examassignment.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import easv.college.examassignment.be.CatMovie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatMovieDAO {
    ConnectionManager conMan = new ConnectionManager();

    public String getCatMovies(int movieId) {
        try (Connection con = conMan.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM dbo.CatMovie WHERE MovieId = ?");
            stmt.setInt(1, movieId);
            ResultSet rs = stmt.executeQuery();
            List<Integer> categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(rs.getInt("CategoryId"));
            }
            String catNames = "";
            for (int i = 0; i < categories.size(); i++) {
                String cat = getMoviesByCategory(categories.get(i));
                if (i == 0)
                    catNames = cat;
                else
                    catNames = catNames + ", " + cat;
            }
            return catNames;
        } catch (SQLException e) {
            System.err.println("Error retrieving categories names for movie: " + e.getMessage());
            return "";
        }
    }

    public String getMoviesByCategory(int categoryId) {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT name FROM dbo.Category WHERE id = ?");
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("name");
        } catch (SQLException e) {
            System.err.println("Error retrieving categories names for movie: " + e.getMessage());
            return "";
        }
    }

    public void addCatMovie(int categoryId, int movieId) {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO CatMovie (categoryId, movieId) VALUES (?, ?)");
            stmt.setInt(1, categoryId);
            stmt.setInt(2, movieId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding categories to movie: " + e.getMessage());
        }
    }

    public void deleteCatMovie(int movieId) {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM dbo.CatMovie WHERE movieId = ?");
            stmt.setInt(1, movieId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting categories form movie: " + e.getMessage());
        }
    }
}