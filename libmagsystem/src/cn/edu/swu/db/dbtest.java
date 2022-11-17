package cn.edu.swu.db;

import cn.edu.swu.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class dbtest {
    public static void main(String[] args) throws SQLException {
        DBEngine engine = DBEngine.getInstance();
        String sql = "SELECT `id`, `name`, `author`, `price`, `describe` from book";
        List<Book> books = engine.query(sql, new RecordVisitor<Book>() {
            @Override
            public Book visit(ResultSet rs) throws SQLException {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
                book.setDescribe(rs.getString("describe"));
                return book;
            }
        });

        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
