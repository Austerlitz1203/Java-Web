package cn.edu.swu.model;

import cn.edu.swu.db.DBEngine;
import cn.edu.swu.db.RecordVisitor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookRepo {

    private static BookRepo instance = new BookRepo();

    private BookRepo(){
    }

    public static BookRepo getInstance() {
        return instance;
    }

    public void saveBook(Book book) throws SQLException {
        if (book.getId() > 0) {
            this.updateBook(book);
        } else {
            this.insertBook(book);
        }
    }

    private void insertBook(Book book) throws SQLException {
        String template =
                "INSERT INTO `book`(`name`, `author`, `price`, `describe`) " +
                        "VALUES (\"%s\", \"%s\", %s, \"%s\")";
        String sql = String.format(template, book.getName(), book.getAuthor(), book.getPrice(), book.getDescribe());
        DBEngine.getInstance().execute(sql);
    }

    private void updateBook(Book book) throws SQLException {
        String template =
                "UPDATE `book` SET `name`=\"%s\", `author`=\"%s\", `price`=%s, `describe`=\"%s\" " +
                        "WHERE `id`=%s";
        String sql = String.format(template, book.getName(),
                book.getAuthor(), book.getPrice(), book.getDescribe(), book.getId());
        DBEngine.getInstance().execute(sql);
    }

    public void deleteBook(Book book) throws SQLException {
        String template = "DELETE FROM `book` WHERE `id` = %s";
        String sql = String.format(template, book.getId());
        DBEngine.getInstance().execute(sql);
    }

    public void deleteBook(Long id) throws SQLException {
        String template = "DELETE FROM `book` WHERE `id` = %s";
        String sql = String.format(template, id);
        DBEngine.getInstance().execute(sql);
    }

    public List<Book> getAll() throws SQLException {
        String sql = "SELECT `id`, `name`, `author`, `price`, `describe` FROM `book`";
        return DBEngine.getInstance().query(sql, new RecordVisitor<Book>() {
            @Override
            public Book visit(ResultSet rs) throws SQLException {
                return BookRepo.getBookFromResultset(rs);
            }
        });
    }

    public Book getById(String id) throws SQLException {
        String sql = "SELECT * FROM `book` WHERE `id` = %s";
        List<Book> books = DBEngine.getInstance().query(
                String.format(sql, id), new RecordVisitor<Book>() {
                    @Override
                    public Book visit(ResultSet rs) throws SQLException {
                        return BookRepo.getBookFromResultset(rs);
                    }
                });
        return books.size() == 0 ? null : books.get(0);
    }


    private static Book getBookFromResultset(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setName(rs.getString("name"));
        book.setAuthor(rs.getString("author"));
        book.setDescribe(rs.getString("describe"));
        book.setPrice(rs.getFloat("price"));
        return book;
    }

}