package beans;

import java.io.Serializable;

public class Game implements Serializable {
    private int id;
    private Genre genre;
    private Developer developer;
    private String name;
    private String description;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Game(int id, Genre genre, Developer developer, String name, String description, float price) {
        this.id = id;
        this.genre = genre;
        this.developer = developer;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;
        hash = prime * hash + ((name == null) ? 0 : name.hashCode());
        hash = prime * hash + id;
        hash = prime * hash + (genre == null ? 0 : genre.hashCode());
        hash = prime * hash + (description == null ? 0 : description.hashCode());
        hash = prime * hash + (developer == null ? 0 : developer.hashCode());
        hash = prime * hash + (int)price;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Game) {
            Game inst = (Game)obj;
            return inst.id == id && inst.developer.equals(developer) && inst.description.equals(description) && inst.name.equals(name) && inst.price == price && inst.genre.equals(genre);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Game [id =" + id + ", genre = " + genre.toString() + ", developer = " + developer.toString() + ", name = " + name + ", price = " + price + "]";
    }

}
