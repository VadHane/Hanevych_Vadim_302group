package lab1.builders;

import lab1.models.BookInformation;
import lab1.models.Person;
import lab1.types.BookGenreType;

public class BookInformationBuilder implements IBookBuilder{
    private BookGenreType genre;
    private String title;
    private Person author;
    private String description;
    private int pages;

    @Override
    public void setGenre(BookGenreType genre) {
        this.genre = genre;
    }

    @Override
    public void setTitle(String title) {
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title should be not empty string!");
        }

        this.title = title;
    }

    @Override
    public void setShortDescription(String desc) {
        if (desc.trim().isEmpty()) {
            throw new IllegalArgumentException("Description should be not empty string.");
        }

        this.description = desc;
    }

    @Override
    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public void setPageCount(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Count of pages should be more then zero.");
        }

        this.pages = pages;
    }

    public BookInformation getResult() {
        return new BookInformation(genre, title, author, description, pages);
    }
}
