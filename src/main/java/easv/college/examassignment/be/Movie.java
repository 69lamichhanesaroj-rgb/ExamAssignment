package easv.college.examassignment.be;

import java.sql.Date;

public class Movie {
    private Integer id;
    private String name;
    private Float imdbRating;
    private Float userRating;
    private Date lastView;
    private String fileLink;

    public Movie(Integer id, String name, Float imdbRating, Float userRating, Date lastView, String fileLink) {
        this.id = id;
        this.name = name;
        this.imdbRating = imdbRating;
        this.userRating = userRating;
        this.lastView = lastView;
        this.fileLink = fileLink;
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
    public Float getUserRating() {return userRating;}
    public void setUserRating(Float userRating) {this.userRating = userRating;}
    public Date getLastView() {
        return lastView;
    }
    public void setLastView(Date lastView) {this.lastView = lastView;}
    public String getFileLink() {return fileLink;}
    public void setFileLink(String fileLink) {this.fileLink = fileLink;}

    /* This part might be usable once we start working on the filter stuff, ofc depending on how we do it
    @Override
    public boolean filterEquals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Movie movie)) return false;
        return Objects.equals(id, movie.id);
    }
     */

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userRating=" + userRating +
                ", imdbRating=" + imdbRating +
                ", lastView=" + lastView +
                '}';
    }
}
