package lab1.models;

import lab1.types.BookGenreType;

public class Book {
    private BookGenreType genre;
    private String title;
    private Person author;
    private String description;
    private int pages;

    public Book(BookGenreType genre,
                     String title,
                     Person author,
                     String description,
                     int pages) {
        this.genre = genre;
        this.title = title;
        this.author = author;
        this.description = description;
        this.pages = pages;
    }

    public BookGenreType getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getPages() {
        return pages;
    }
}
