package beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Ownership implements Serializable {
    private int idUser;
    private int idGameCopy;
    private LocalDateTime date;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdGameCopy() {
        return idGameCopy;
    }

    public void setIdGameCopy(int idGameCopy) {
        this.idGameCopy = idGameCopy;
    }

    public Ownership(int idUser, int idGameCopy) {
        this.idUser = idUser;
        this.idGameCopy = idGameCopy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + idGameCopy;
        hash = prime * hash + idUser;
        hash = prime * hash + ((date == null) ? 0 : date.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ownership) {
            Ownership inst = (Ownership)obj;
            return inst.idUser == idUser && inst.idGameCopy == idGameCopy && inst.date.equals(date);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ownership [idUser =" + idUser + ", idGameCopy = " + idGameCopy + ", date = "+ date + "]";
    }
}
