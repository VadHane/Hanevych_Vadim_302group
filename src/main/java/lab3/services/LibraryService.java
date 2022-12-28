package lab3.services;

import lab1.models.AudioBook;
import lab1.models.Book;
import lab1.models.Library;
import lab3.comparators.AudioBookComparator;
import lab3.comparators.BookComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryService {
    private Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    public List<Book> sortBooksByTitle() {
        List<Book> sortedBooks = new ArrayList<Book>(library.getBooks());

        sortedBooks.sort(new BookComparator());

        return sortedBooks;
    }

    public List<Book> sortBooksByTitleStream() {
        return library.getBooks().stream().sorted(new BookComparator()).collect(Collectors.toList());
    }

    public List<AudioBook> sortAudioBook() {
        List<AudioBook> sortedAudioBook = new ArrayList<>(library.getBookInReading());

        sortedAudioBook.sort(new AudioBookComparator());

        return sortedAudioBook;
    }

    public List<AudioBook> sortAudioBookStream() {
        return library.getBookInReading().stream().sorted(new AudioBookComparator()).collect(Collectors.toList());
    }

    public Optional<Book> firstOrDefaultBookByAuthorSurname(String surname) {
        for (Book book: library.getBooks()) {
            if (book.getAuthor().getSurname().compareTo(surname) == 0) {
                return Optional.of(book);
            }
        }

        return null;
    }

    public Optional<Book> firstOrDefaultBookByAuthorSurnameStream(String surname) {
        return library.getBooks().stream().filter(book -> book.getAuthor().getSurname().compareTo(surname) == 0).findFirst();
    }
}
