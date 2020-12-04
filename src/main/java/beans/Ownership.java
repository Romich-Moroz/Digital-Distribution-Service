package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Ownership implements Serializable {
    private int idUser;
    private GameCopy gameCopy;
    private Timestamp date;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public GameCopy getGameCopy() {
        return gameCopy;
    }

    public void setGameCopy(GameCopy idGameCopy) {
        this.gameCopy = idGameCopy;
    }

    public Timestamp getTimestamp() {
        return date;
    }

    public void setTimestamp(Timestamp date) {
        this.date = date;
    }

    public Ownership(int idUser, GameCopy gameCopy) {
        this.idUser = idUser;
        this.gameCopy = gameCopy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + gameCopy.hashCode();
        hash = prime * hash + idUser;
        hash = prime * hash + ((date == null) ? 0 : date.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ownership) {
            Ownership inst = (Ownership)obj;
            return inst.idUser == idUser && inst.gameCopy.equals(gameCopy) && inst.date.equals(date);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ownership [idUser =" + idUser + ", gameCopy = " + gameCopy + ", date = "+ date + "]";
    }
}
