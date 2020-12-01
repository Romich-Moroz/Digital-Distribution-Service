package beans;

import java.io.Serializable;

public class Blacklist implements Serializable {
    private int idUser;
    private String reason;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Blacklist(int idUser, String reason) {
        this.idUser = idUser;
        this.reason = reason;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + ((reason == null) ? 0 : reason.hashCode());
        hash = prime * hash + idUser;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Blacklist) {
            Blacklist inst = (Blacklist)obj;
            return inst.idUser == idUser && inst.reason.equals(reason);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Blacklist [idUser =" + idUser + ", reason = " + reason + "]";
    }
}
