package Constants;


import Utils.ApplicationProperties;

public enum TITLE {
    JIR_BOARD("JIR board - Agile Board - JIRA");

    private final String title;

    TITLE(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
