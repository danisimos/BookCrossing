package com.orioninc.models;

import lombok.Getter;

import java.util.*;

@Getter
public class BookShelf {
    private final int capacity;
    private List<Book> books;

    public BookShelf(int capacity) {
        this.capacity = capacity;
        books = Collections.synchronizedList(new ArrayList<>());

        for (int i = 1; i <= capacity; i++) {
            books.add(Book.builder().title("Book№" + i).author("Author№" + i).build());
        }
    }

    public Book takeBook() throws InterruptedException {
        while (books.size() == 0) {
            wait();
        }
        notify();

        Book book = books.get(new Random().nextInt(books.size()));
        books.remove(book);

        return book;
    }

    public void putBook(Book book) throws InterruptedException {
        while (books.size() == capacity) {
            wait();
        }
        notify();

        books.add(book);
    }
}
