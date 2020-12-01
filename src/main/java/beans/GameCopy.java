package beans;

import java.io.Serializable;

public class GameCopy implements Serializable {
    private int id;
    private int idGame;
    private String key;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) { this.idGame = idGame; }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public GameCopy(int id, int idGame, String key) {
        this.id = id;
        this.idGame = idGame;
        this.key = key;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;
        hash = prime * hash + ((key == null) ? 0 : key.hashCode());
        hash = prime * hash + id;
        hash = prime * hash + idGame;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GameCopy) {
            GameCopy inst = (GameCopy)obj;
            return inst.id == id && inst.idGame == idGame && inst.key.equals(key);
        }
        return false;
    }

    @Override
    public String toString() {
        return "GameCopy [id =" + id + ", idGame = " + idGame + ", key = " + key + "]";
    }
}
