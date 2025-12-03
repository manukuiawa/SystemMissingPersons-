package model;
public enum StatusRegister {
    ANDAMENTO("andamento"),
    PENDENTE("pendente"),
    ENCERRADO("encerrado");

    private final String dbValue;

    StatusRegister(String dbValue) {
        this.dbValue = dbValue;
    }

    public String toDatabaseValue() {
        return dbValue;
    }

    public static StatusRegister fromString(String value) {
        if (value == null) return null;
        for (StatusRegister s : values()) {
            if (s.dbValue.equalsIgnoreCase(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + value);
    }
}
