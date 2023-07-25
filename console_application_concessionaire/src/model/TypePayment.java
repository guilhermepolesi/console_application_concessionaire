package model;

public enum TypePayment {
    CASH(1),
    PIX(2),
    CREDIT(3),
    DEBIT(4);

    private final int value;

    TypePayment(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Método para converter valor inteiro para o tipo correspondente do enum
    public static TypePayment fromInt(int value) {
        for (TypePayment type : TypePayment.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid TypePayment value: " + value);
    }

}
