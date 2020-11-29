package beans;

import java.io.Serializable;

public class AccessType implements Serializable {
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AccessType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 79;
        int hash = 1;
        hash = prime * hash + ((type == null) ? 0 : type.hashCode());
        hash = prime * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AccessType) {
            AccessType inst = (AccessType)obj;
            return inst.id == id && inst.type.equals(type);
        }
        return false;
    }

    @Override
    public String toString() {
        return "AccessType [id =" + id + ", type = " + type + "]";
    }

}
