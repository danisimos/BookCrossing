package com.orioninc.models;

import java.util.Objects;

public class BookShelf {
    private Integer capacity;
    private Integer currentCount;

    public BookShelf(Integer capacity) {
        this.capacity = capacity;
        this.currentCount = capacity;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public synchronized Integer takeBook() throws InterruptedException {

        while(currentCount == 0) wait();

        notify();
        currentCount--;

        return currentCount;
    }

    public synchronized Integer putBook() throws InterruptedException {
        while(Objects.equals(currentCount, capacity)) wait();

        notify();
        currentCount++;

        return currentCount;
    }
}
