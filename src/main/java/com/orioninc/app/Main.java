package com.orioninc.app;

import com.orioninc.models.Book;
import com.orioninc.models.BookShelf;
import com.orioninc.models.Reader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BookShelf bookShelf = new BookShelf(2);

        List<Book> reader1Books = new ArrayList<>();
        reader1Books.add(Book.builder().author("Dostoevsky").title("Idiot").build());
        reader1Books.add(Book.builder().author("London").title("Martin Eden").build());

        List<Book> reader2Books = new ArrayList<>();
        reader1Books.add(Book.builder().author("Tolkien").title("The Hobbit").build());

        Reader reader1 = new Reader(1, bookShelf, reader1Books);
        Reader reader2 = new Reader(2, bookShelf, reader2Books);
        Reader reader3 = new Reader(3, bookShelf, new ArrayList<>());

        reader1.start();
        reader2.start();
        reader3.start();
    }
}
