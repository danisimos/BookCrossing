package com.orioninc.models;

public class Reader extends Thread{
    private final Integer id;
    private final BookShelf bookShelf;

    public Reader(Integer id, BookShelf bookShelf) {
        this.id = id;
        this.bookShelf = bookShelf;
    }

    @Override
    public void run() {
        try {
            if(Math.random() < 0.5) {
                takeBook();
            } else putBook();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeBook() throws InterruptedException {
        System.out.println(System.currentTimeMillis() +": Reader" + id + " want to take book (BookShelf has " + bookShelf.getCurrentCount() + " books)");
        System.out.println(System.currentTimeMillis() +": Reader" + id + " took book (BookShelf has " + bookShelf.takeBook() + " books)");

        Thread.sleep(8000);
        putBook();
    }

    private void putBook() throws InterruptedException {
        System.out.println(System.currentTimeMillis() +": Reader" + id + " want to put book (BookShelf has " + bookShelf.getCurrentCount() + " books)");
        System.out.println(System.currentTimeMillis() +": Reader" + id + " put book (BookShelf has " + bookShelf.putBook() + " books)");

        Thread.sleep(8000);
        takeBook();
    }
}
