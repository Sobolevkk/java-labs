package org.example.exception;

public class MagazineNotFoundException extends Exception {
    private final String title;

    public MagazineNotFoundException(String message, String title) {
        super(message);
        this.title = title;
    }

    public String getTitle() { return title; }
}