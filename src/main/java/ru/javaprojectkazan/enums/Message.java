package ru.javaprojectkazan.enums;

public enum Message {
    MISSING_VIN ("Автомобиль с данным VIN отсутствует"),
    MISSING_PART ("Деталь с указанным номером отсутствует"),
    MISSING_OPERATION ("Операция с указанным кодом отсутствует"),
    INCORRECT_MILEAGE ("Указан некорректный пробег. Пробег автомобиля не должен быть меньше, " +
            "чем указанный на момент предыдущего ремонта")
    ;

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
