public class Show {
    private String auth;
    private String name;
    private String description;
    private int periodType;


    public Show() {
        this.auth = "";
        this.name = "";
        this.description = "";
        this.periodType = 0;
    }

    public Show(String auth, String name, String description, int periodType) {
        this.auth = auth;
        this.name = name;
        this.description = description;
        this.periodType = periodType;
    }


    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPeriodType() {
        return periodType;
    }

    public void setPeriodType(int periodType) {
        this.periodType = periodType;
    }


    public String getPeriodTypeDescription() {
        switch (periodType) {
            case 1: return "ежедневно";
            case 2: return "еженедельно";
            case 3: return "ежемесячно";
            default: return "не определена";
        }
    }


    @Override
    public String toString() {
        return String.format(
                "╔════════════════════════════════════════╗%n" +
                        "║             ИНФОРМАЦИЯ О ПЕРЕДАЧЕ     ║%n" +
                        "╠════════════════════════════════════════╣%n" +
                        "║ Название: %-28s ║%n" +
                        "║ Ведущий:  %-28s ║%n" +
                        "║ Периодич.:%-28s ║%n" +
                        "╠════════════════════════════════════════╣%n" +
                        "║ ОПИСАНИЕ:                             ║%n" +
                        "║ %-38s ║%n" +
                        "╚════════════════════════════════════════╝",
                name,
                auth,
                getPeriodTypeDescription(),
                description
        );
    }
}