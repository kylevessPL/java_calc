package pl.piasta.kck.calc.utils;

import java.util.Arrays;
import java.util.HashMap;

public enum Operation {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SHOW_RESULT("=");

    private static final HashMap<String, Operation> MAP = new HashMap<>();

    private final String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Operation getByName(String name) {
        return MAP.get(name);
    }

    static {
        Arrays.stream(Operation.values()).forEach(field -> MAP.put(field.getValue(), field));
    }

}
