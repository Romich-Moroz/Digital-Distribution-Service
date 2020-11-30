package beans;

import java.io.Serializable;

public class Developer implements Serializable {
    private int id;
    private String developer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Developer(int id, String developer) {
        this.id = id;
        this.developer = developer;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + ((developer == null) ? 0 : developer.hashCode());
        hash = prime * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Developer) {
            Developer inst = (Developer)obj;
            return inst.id == id && inst.developer.equals(developer);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Developer [id =" + id + ", developer = " + developer + "]";
    }

}
