package easv.college.examassignment.be;

import java.sql.Date;

public class Movie {
    private Integer id;
    private String name;
    private Float imdbRating;
    private Float userRating;
    private Date lastView;
    private String fileLink;
    private String categoryName;

    public Movie(Integer id, String name, Float imdbRating, Float userRating, Date lastView, String fileLink, String categoryName) {
        this.id = id;
        this.name = name;
        this.imdbRating = imdbRating;
        this.userRating = userRating;
        this.lastView = lastView;
        this.fileLink = fileLink;
        this.categoryName = categoryName;
    }

    public Movie(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(Float imdbRating) {
        this.imdbRating = imdbRating;
    }
    public Float getUserRating() {
        return userRating;
    }
    public void setUserRating(Float userRating) {
        this.userRating = userRating;
    }
    public Date getLastView() {
        return lastView;
    }
    public void setLastView(Date lastView) {
        this.lastView = lastView;
    }
    public String getFileLink() {
        return fileLink;
    }
    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
    public String getCategoryName() {
        return categoryName;
    }
}
