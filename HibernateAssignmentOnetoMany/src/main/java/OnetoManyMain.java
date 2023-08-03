import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class OnetoManyMain {
    public static void main(String[] args) {
        Book book = new Book();
        Book book1 = new Book();
        Author author = new Author();

        book.setBookName("Diary of Wimpy Kid Dog Days");
        book.setBookId("S001");
        book.setCategory("Funny");

        book1.setBookName("Diary of Wimpy Kid Double Down");
        book1.setBookId("S002");
        book1.setCategory("Funny");


        author.setName("Jeff Kenny");
        author.setId("A001");
        author.setAddress("Australia");


        List<Book>bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        book.setAuthor(author);
        book1.setAuthor(author);


        author.setBookList(bookList);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        session.persist(book1);
        session.persist(author);
        transaction.commit();
        session.close();
    }
}
