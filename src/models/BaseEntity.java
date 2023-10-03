package models;

public abstract class BaseEntity {
    private static long number=0;
    private long id;

    public BaseEntity() {
        this.id = ++number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
