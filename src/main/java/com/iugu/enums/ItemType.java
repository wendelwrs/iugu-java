package com.iugu.enums;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum ItemType {

    CREDIT_CARD("credit_card");

    private String value;

    ItemType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ItemType forValue(String value) {
        return ItemType.valueOf(value.toUpperCase());
    }

}
