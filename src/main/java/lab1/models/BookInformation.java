package lab1.models;

import lab1.types.BookGenreType;

public class BookInformation {
    private BookGenreType genre;
    private String title;
    private Person author;
    private String description;
    private int pages;

    public BookInformation(BookGenreType genre,
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

    public String  getInfo() {
        String info = "";
        info += "Title: " + title + "\n";
        info += "Genre: " + genre.name() + "\n";
        info += "Short description: " + description + "\n";
        info += "Author: " + author.getName() + " " + author.getSurname() + "\n";
        info += "Pages: " + pages + "\n";

        return info;
    }
}
