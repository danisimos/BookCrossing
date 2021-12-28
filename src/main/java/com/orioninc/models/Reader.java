package com.orioninc.models;

import java.util.List;
import java.util.Random;

public class Reader extends Thread{
    private final int id;
    private final BookShelf bookShelf;
    private List<Book> readerBooks;

    public Reader(int id, BookShelf bookShelf, List<Book> books) {
        this.id = id;
        this.bookShelf = bookShelf;
        this.readerBooks = books;
    }

    @Override
    public void run() {
        try {
            takeBook();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeBook() throws InterruptedException {
        Book takenBook;

        synchronized (bookShelf) {
            takenBook = bookShelf.takeBook();
            readerBooks.add(takenBook);

            System.out.println(System.currentTimeMillis() +
                    ": Reader" + id + " took:" + takenBook +
                    " (BookShelf has " + bookShelf.getBooks().size() +
                    " books: " + bookShelf.getBooks() + " )");
        }

        readBook(takenBook);
    }

    public void readBook(Book takenBook) throws InterruptedException {
        System.out.println(System.currentTimeMillis() +
                ": Reader" + id + " is reading:" + takenBook);

        Thread.sleep(10000);

        System.out.println(System.currentTimeMillis() +
                ": Reader" + id + " had read:" + takenBook);

        putBook();
    }

    public void putBook() throws InterruptedException {
        synchronized (bookShelf) {
            Book bookToPut = readerBooks.get(new Random().nextInt(readerBooks.size()));
            readerBooks.remove(bookToPut);
            bookShelf.putBook(bookToPut);

            System.out.println(System.currentTimeMillis() +
                    ": Reader" + id + " put:" + bookToPut +
                    " (BookShelf has " + bookShelf.getBooks().size() +
                    " books: " + bookShelf.getBooks() + " )");
        }
    }
}
