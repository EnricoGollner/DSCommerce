package dev.enricogollner.dscommerce.dto;

public class FieldMesssageDTO {
    private String fieldName;
    private String message;

    public FieldMesssageDTO(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
