package beans;

import java.io.Serializable;

public class Game implements Serializable {
    private int id;
    private int idDeveloper;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDeveloper() {
        return idDeveloper;
    }

    public void setIdDeveloper(int idDeveloper) {
        this.idDeveloper = idDeveloper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;
        hash = prime * hash + ((name == null) ? 0 : name.hashCode());
        hash = prime * hash + id;
        hash = prime * hash + idDeveloper;
        hash = prime * hash + (int)price;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            Game inst = (Game)obj;
            return inst.id == id && inst.idDeveloper == idDeveloper && inst.name.equals(name) && inst.price == price;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Game [id =" + id + ", idDeveloper = " + idDeveloper + ", name = " + name + ", price = " + price + "]";
    }

}
