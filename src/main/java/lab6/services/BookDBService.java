package lab6.services;

import lab1.models.Book;
import lab1.models.Person;
import lab1.types.BookGenreType;
import lab5.database.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDBService {
    private DataBase db;

    public BookDBService(DataBase db) {
        this.db = db;
    }

    public void addBook(Book book) throws Exception {
        try {
            String defaultInsertString = "INSERT INTO Books (genre, title, description, pages, author_id)" +
                    " VALUES (?, ?, ?, ?, ?);";

            PreparedStatement preparedStatement = db.getPreparedStatement(defaultInsertString);

            preparedStatement.setInt(1, book.getGenre().ordinal());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getDescription());
            preparedStatement.setInt(4, book.getPages());
            preparedStatement.setInt(5, book.getAuthor().getIdNumber());

            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Person getPerson(String query) throws Exception {
        return getPerson(db.getData(query));
    }

    public Person getPersonByIdNumber(Integer id) throws Exception {
        PreparedStatement defaultSelectString = db.getPreparedStatement("SELECT * FROM Person AS P WHERE P.id_number LIKE ?;");
        defaultSelectString.setInt(1, id);

        return getPerson(defaultSelectString.toString());
    }

    public Book getBook(String query) throws Exception {
        return getBook(db.getData(query));
    }

    public Book getBookById(Integer id) throws Exception {
        PreparedStatement defaultSelectString = db.getPreparedStatement("SELECT * FROM Books AS B WHERE B.id LIKE ?;");
        defaultSelectString.setInt(1, id);

        return getBook(defaultSelectString.toString());
    }

    private Person getPerson(ResultSet person) throws SQLException {
        return new Person(person.getInt(1), person.getString(2),
                person.getString(3), person.getString(4));
    }

    private Book getBook(ResultSet book) throws Exception {
        return new Book(BookGenreType.values()[book.getInt(2)], book.getString(3),
                getPersonByIdNumber(book.getInt(6)), book.getString(4), book.getInt(5));
    }
}
