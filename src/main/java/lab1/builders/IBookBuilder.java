package lab1.builders;

import lab1.models.Person;
import lab1.types.BookGenreType;

public interface IBookBuilder {
    void setGenre(BookGenreType genre);
    void setTitle(String title);
    void setShortDescription(String desc);
    void setAuthor(Person author);
    void setPageCount(int pages);
}