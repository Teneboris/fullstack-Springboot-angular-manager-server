package com.example.fullstackspringbootangularmanagerserver.enumeration;

public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;

    Status(String status){
        this.status = status;
    }

    private String getStatus() {
        return status;
    }

}
