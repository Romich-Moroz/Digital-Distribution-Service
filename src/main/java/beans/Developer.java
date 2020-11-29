package beans;

import java.io.Serializable;

public class Developer implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Developer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + ((name == null) ? 0 : name.hashCode());
        hash = prime * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Developer) {
            Developer inst = (Developer)obj;
            return inst.id == id && inst.name.equals(name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Developer [id =" + id + ", name = " + name + "]";
    }

}
