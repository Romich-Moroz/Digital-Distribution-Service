package beans;

import java.io.Serializable;

public class GameCopy implements Serializable {
    private int id;
    private Game game;
    private String key;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) { this.game = game; }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public GameCopy(int id, Game game, String key) {
        this.id = id;
        this.game = game;
        this.key = key;
    }

    @Override
    public int hashCode() {
        final int prime = 23;
        int hash = 1;
        hash = prime * hash + ((key == null) ? 0 : key.hashCode());
        hash = prime * hash + id;
        hash = prime * hash + game.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GameCopy) {
            GameCopy inst = (GameCopy)obj;
            return inst.id == id && inst.game.equals(game) && inst.key.equals(key);
        }
        return false;
    }

    @Override
    public String toString() {
        return "GameCopy [id =" + id + ", game = " + game + ", key = " + key + "]";
    }
}
