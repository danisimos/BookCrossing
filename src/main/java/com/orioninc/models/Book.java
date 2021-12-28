package com.orioninc.models;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Book {
    private String author;
    private String title;
}
