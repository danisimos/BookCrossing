package com.orioninc.app;

import com.orioninc.models.BookShelf;
import com.orioninc.models.Reader;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(1);

        for(int i = 1; i < 3; i++) {
            Reader reader = new Reader(i, bookShelf);
            reader.start();
        }
    }
}
