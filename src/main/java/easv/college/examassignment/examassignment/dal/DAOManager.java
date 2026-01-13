package easv.college.examassignment.examassignment.dal;

public class DAOManager
{
    private final MovieDAO movieDAO;
    private final CategoryDAO categoryDAO;
    private final CatMovieDAO catMovieDAO;

    public DAOManager()
    {
        movieDAO = new MovieDAO();
        categoryDAO = new CategoryDAO();
        catMovieDAO = new CatMovieDAO();
    }

    public MovieDAO getMovieDAO()
    {
        return movieDAO;
    }

    public CategoryDAO getCategoryDAO()
    {
        return categoryDAO;
    }

    public CatMovieDAO getCatMovieDAO()
    {
        return catMovieDAO;
    }
}
