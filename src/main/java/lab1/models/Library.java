package lab1.models;

import lab1.builders.AudioBookBuilder;
import lab1.builders.BookInformationBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private String address;
    private Librarian librarian;
    private List<Book> books;
    private List<AudioBook> bookInReading;

    public Library(String address, Librarian librarian) {
        this.address = address;
        this.librarian = librarian;
        books = new ArrayList<Book>();
        bookInReading = new ArrayList<AudioBook>();
    }

    public String getAddress() {
        return address;
    }

    public List<AudioBook> getBookInReading() {
        return bookInReading;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        // some validation...

        this.books.add(book);
    }

    public String getBookInformation(Book book) {
        BookInformationBuilder builder = new BookInformationBuilder();

        librarian.getBookByScheme(builder, book);

        return builder.getResult().getInfo();
    }

    public AudioBook startReading(Book book, Person reader) {
        if (this.bookInReading.stream().anyMatch(audioBook -> audioBook.getReader() == reader)) {
            throw new RuntimeException("This reader have active book"); // str could be const string
        }

        AudioBookBuilder builder = new AudioBookBuilder();

        librarian.getBookByScheme(builder, book);

        AudioBook aBook = builder.getResult();

        aBook.setReader(reader);
        this.bookInReading.add(aBook);

        return aBook;
    }

    @Override
    public String toString() {
        return "Library{" +
                "address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        return Objects.equals(address, library.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
