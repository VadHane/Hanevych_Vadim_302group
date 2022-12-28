package lab5.types;

public class ConnectionString {
    private String url;
    private String username;
    private String password;


    public ConnectionString(String url, String username, String password) {
        if (url.trim().isEmpty()) {
            throw new IllegalArgumentException("Url should be not empty string.");
        }

        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
