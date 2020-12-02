package beans;

public class OwnedGame {
    private String name;
    private String developer;
    private String key;
    private String date;

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getKey() {
        return key;
    }

    public String getDate() {
        return date;
    }

    public OwnedGame(String name, String developer, String key, String date) {
        this.name = name;
        this.developer=developer;
        this.key = key;
        this.date = date;
    }
}
