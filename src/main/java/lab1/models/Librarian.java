package lab1.models;

import lab1.builders.IBookBuilder;
import lab1.types.BookGenreType;

public class Librarian {
    public void getBookWithFirstGenre(IBookBuilder builder) {
        builder.setGenre(BookGenreType.genre1);
        builder.setTitle("How Vadim to passed exams...");
        builder.setAuthor(new Person("Best", "Woman", "st. Happy Mans"));
        builder.setShortDescription("very very short desc");
        builder.setPageCount(5);
    }

    public void getBookWithSecondGenre(IBookBuilder builder) {
        builder.setGenre(BookGenreType.genre2);
        builder.setTitle("How Vadim to passed exams... The second part.");
        builder.setAuthor(new Person("Best", "Man", "st. Happy Woman"));
        builder.setShortDescription("very very long desc");
        builder.setPageCount(20);
    }

    public void getBookByScheme(IBookBuilder builder, Book book) {
        builder.setGenre(book.getGenre());
        builder.setTitle(book.getTitle());
        builder.setAuthor(book.getAuthor());
        builder.setShortDescription(book.getDescription());
        builder.setPageCount(book.getPages());
    }
}
