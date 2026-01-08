package easv.college.examassignment.dal;

import easv.college.examassignment.be.Movie;
import easv.college.examassignment.be.MovieWithCategories;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    private ConnectionManager connectionManager;

    public MovieDAO() {
        this.connectionManager = connectionManager;
    }

    /**
     * Used to create a new movie in the database
     */
    public int createMovie(Movie movie) throws SQLException {
        String sql = "INSERT INTO Movie (name, userRating, imdbRating, fileLink, lastView) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, movie.getName());
            stmt.setFloat(2, movie.getUserRating() != null ? movie.getUserRating() : 0);
            stmt.setFloat(3, movie.getImdbRating() != null ? movie.getImdbRating() : 0);
            stmt.setString(4, movie.getFileLink());
            stmt.setDate(5, movie.getLastView() != null ? Date.valueOf(movie.getLastView()) : null);

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()) {
                    int id = rs.getInt(1);
                    movie.setId(id);
                    return id;
                }
            }
        }
        return -1;
    }

    /**
     * Get a movie by its id
     * @param id
     * @return
     * @throws SQLException
     */
    public Movie getMovieById(int id) throws SQLException {
        String sql = "SELECT * FROM Movie WHERE id = ?";

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return getMovieFromResultSet(rs);
                }
            }
        }
        return null;
    }

    /**
     * Lets the user update a movie
     */
    public void UpdateMovie(Movie movie) throws SQLException {
        String sql = "UPDATE Movie SET name = ?, userRating = ?, imdbRating = ?, fileLink = ?, lastView = ? WHERE id = ?";

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, movie.getName());
            stmt.setFloat(2, movie.getUserRating() != null ? movie.getUserRating() : 0);
            stmt.setFloat(3, movie.getImdbRating() != null ? movie.getImdbRating() : 0);
            stmt.setString(4, movie.getFileLink());
            stmt.setDate(5, movie.getLastView() != null ? Date.valueOf(movie.getLastView()) : null);
            stmt.setInt(6, movie.getId());

            stmt.executeUpdate();
        }
    }

    /**
     * Allows you to delete a movie by its ID
     */
    public void DeleteMovie(int id) throws SQLException {
        String sql = "DELETE FROM Movie WHERE id = ?";

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    /**
     * Gets all the movies
     * @return
     * @throws SQLException
     */
    public List<Movie> getAllMovies() throws SQLException {
        String sql = "SELECT * FROM Movie ORDER BY NAME";
        List<Movie> movies = new ArrayList<>();

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while (rs.next()) {
                movies.add(getMovieFromResultSet(rs));
            }
        }
        return movies;
    }

    public List<MovieWithCategories> searchMovies(String titleFilter, List<Integer> categoryIds,
                                                  Float minImdbRating, String sortBy) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT m.*, GROUP_CONCAT(c.name, ', ') as categories ");
        sql.append("FROM Movie m ");
        sql.append("LEFT JOIN CatMovie cm ON m.id = cm.movieId ");
        sql.append("LEFT JOIN Category c ON cm.categoryId = c.cId ");
        sql.append("WHERE 1=1 ");

        //Build the WHERE clause
        if (titleFilter != null && !titleFilter.trim().isEmpty()){
            sql.append("AND m.name LIKE ? ");
        }

        if (categoryIds != null && !categoryIds.isEmpty()) {
            sql.append("AND cm.categoryId IN (");
            for (int i = 0; i < categoryIds.size(); i++) {
                sql.append("?");
                if (i < categoryIds.size() - 1) sql.append(",");
            }
            sql.append(") ");
        }

        if (minImdbRating != null) {
            sql.append("AND m.imdbRating >= ? ");
        }

        sql.append("AND m.imdbRating <= ? ");

        //We add an ORDER BY clause
        if (sortBy != null) {
            switch (sortBy.toLowerCase()) {
                case "title":
                    sql.append("ORDER BY m.name ");
                    break;
                case "userRating":
                    sql.append("ORDER BY m.userRating DESC ");
                    break;
                case "imdbRating":
                    sql.append("ORDER BY m.imdbRating DESC ");
                    break;
                case "category":
                    sql.append("ORDER BY categories ");
                    break;
                default:
                    sql.append("ORDER BY m.name ");
            }
        } else {
            sql.append("ORDER BY m.name ");
        }

        List<MovieWithCategories> results = new ArrayList<>();

        try (Connection connection = connectionManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql.toString())) {

            int paramIndex = 1;

            //We set some parameters
            if (titleFilter != null && !titleFilter.trim().isEmpty()){
                stmt.setString(paramIndex++, "%" + titleFilter + "%");
            }

            if (categoryIds != null && !categoryIds.isEmpty()) {
                for (Integer categoryId : categoryIds) {
                    stmt.setInt(paramIndex++, categoryId);
                }
            }

            if (minImdbRating != null) {
                stmt.setFloat(paramIndex++, minImdbRating);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Movie movie = getMovieFromResultSet(rs);
                    String categories = rs.getString("categories");
                    if (categories == null)  categories = "No categories?";

                    results.add(new MovieWithCategories(movie, categories));
                }
            }
        }
        return results;
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
        LocalDate lastView = rs.getDate("lastView").toLocalDate();

        return new Movie(id, name, userRating, imdbRating, lastView, fileLink);
    }
}
