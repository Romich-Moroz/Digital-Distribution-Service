package beans;

import java.io.Serializable;

public class Genre implements Serializable {
    private int id;
    private String genre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + ((genre == null) ? 0 : genre.hashCode());
        hash = prime * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Genre) {
            Genre inst = (Genre)obj;
            return inst.id == id && inst.genre.equals(genre);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Developer [id =" + id + ", genre = " + genre + "]";
    }
}
