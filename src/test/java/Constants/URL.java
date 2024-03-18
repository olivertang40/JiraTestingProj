package Constants;


import Utils.ApplicationProperties;

public enum URL {
    Home(""),
    UserAdmin("/secure/admin/user/UserBrowser.jspa"),
    Backlog("/secure/RapidBoard.jspa");

    private final String url;

    URL(String path) {
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
}
