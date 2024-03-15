package constants;


import utils.ApplicationProperties;

public enum URL {
    Home(""),
    UserAdmin("/admin/user/UserBrowser.jspa");

    private final String url;

    URL(String path){
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
}
