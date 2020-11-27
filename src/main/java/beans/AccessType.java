package beans;

import java.io.Serializable;

public class AccessType implements Serializable {
    private int id;
    private String accessType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    @Override
    public int hashCode() {
        final int prime = 79;
        int hash = 1;
        hash = prime * hash + ((accessType == null) ? 0 : accessType.hashCode());
        hash = prime * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AccessType) {
            AccessType inst = (AccessType)obj;
            return inst.id == id && inst.accessType.equals(accessType);
        }
        return false;
    }

    @Override
    public String toString() {
        return "AccessType [id =" + id + ", accessType = " + accessType + "]";
    }

}
