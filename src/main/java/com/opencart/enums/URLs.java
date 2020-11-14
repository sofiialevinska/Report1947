package com.opencart.enums;

public enum URLs {
    BASE_URL("https://localhost/opencart/upload/index.php");

//    BASE_URL("http://localhost:8888/opencart/index.php");
//    ADMIN_BASE_URL("http://localhost:8888/opencart/admin");

    private final String value;

    URLs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}