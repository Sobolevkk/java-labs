package org.example.exception;

public class InvalidMagazineDataException extends Exception {
    private final String fieldName;
    private final Object invalidValue;

    public InvalidMagazineDataException(String message, String fieldName, Object invalidValue) {
        super(message);
        this.fieldName = fieldName;
        this.invalidValue = invalidValue;
    }

    public String getFieldName() { return fieldName; }
    public Object getInvalidValue() { return invalidValue; }

    @Override
    public String toString() {
        return "InvalidMagazineDataException{field='" + fieldName +
                "', value=" + invalidValue + ", message='" + getMessage() + "'}";
    }
}