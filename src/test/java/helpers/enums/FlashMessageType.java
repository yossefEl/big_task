package helpers.enums;

public enum FlashMessageType {
    WARNING("warning"),
    SUCCESS("success"),
    INFO("info"),
    DANGER("danger");

    private final String type;

    FlashMessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
