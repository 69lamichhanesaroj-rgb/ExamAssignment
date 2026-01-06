package easv.college.examassignment.be;

public class Movie {
    private Integer id;
    private String name;
    private Float rating;
    private Integer lastView;
    private String fileLink;

    public Movie(Integer id, String name, Float rating, Integer lastView, String fileLink) {
        this.id = id;
        this.name = name;
        this.rating = rating;
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
    public Float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }
    public Integer getLastView() {
        return lastView;
    }
    public void setLastView(Integer lastView) {
        this.lastView = lastView;
    }
    public String getFileLink() {
        return fileLink;
    }
    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    /* This part might be usable once we start working on the filter stuff
    @Override
    public boolean filterEquals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Movie movie)) return false;
        return Objects.equals(id, movie.id);
    }

    @Override
    public String toString() {
        return (insert whatever we need)
    }
     */
}
