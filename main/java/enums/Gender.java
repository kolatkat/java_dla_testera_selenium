package enums;

public enum Gender {

    Mr("1"),
    Mrs("2");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
