package easv.college.examassignment.dal;

import easv.college.examassignment.be.Category;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    ConnectionManager conMan;
    public CategoryDAO() throws IOException {
        conMan = new ConnectionManager();
    }

    public List<Category> getCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        try (Connection con = conMan.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.Category");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categories.add(new Category(id, name));
            }
        }
        catch (SQLException e) {
            System.err.println("Error retrieving categories: " + e.getMessage());
        }
        return categories;
    }

    public void addCategory(String category) throws SQLException {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Category (name) VALUES (?)");
            stmt.setString(1, category);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error adding category: " + e.getMessage());
        }
    }
}
