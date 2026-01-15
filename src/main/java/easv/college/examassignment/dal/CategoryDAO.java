package easv.college.examassignment.dal;

import easv.college.examassignment.be.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    ConnectionManager conMan = new ConnectionManager();

    public List<Category> getCategories() {
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

    public void addCategory(Category category) {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Category (name) VALUES (?)");
            stmt.setString(1, category.getName());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("Error adding category: " + e.getMessage());
        }
    }

    public boolean deleteCategory(Category category) {
        try (Connection con = conMan.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE Category WHERE id = ?");
            stmt.setInt(1, category.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting category: " + e.getMessage());
            return false;
        }
    }
}
