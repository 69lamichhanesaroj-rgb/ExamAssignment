package easv.college.examassignment.be;

public class Category {
    private Integer id;
    private String name;

    public Category(Integer id, String name) {
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

    /* This part might be usable once we start working on the filter stuff, ofc depending on how we do it
    @Override
    public boolean filterEquals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Category category)) return false;
        return Objects.equals(id, category.id);
    }
     */


    @Override
    public String toString() {
        return name;
    }

}
