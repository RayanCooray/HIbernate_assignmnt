import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ManytoManyMain {
    public static void main(String[] args) {
        Book book = new Book();
        Book book1 = new Book();

        Author author = new Author();
        Author author1 = new Author();

        book.setBookName("Diary of Wimpy Kid Double Down");
        book.setBookId("S001");
        book.setCategory("Funny");

        book1.setBookName("Diary of Wimpy Kid Meltdown");
        book1.setBookId("S002");
        book1.setCategory("Funny");


        author.setName("Jeff Kenny");
        author.setId("A001");
        author.setAddress("Australia");

        author1.setName("Puffin");
        author1.setId("A002");
        author1.setAddress("America");


        List<Book>bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        List<Author>authorList = new ArrayList<>();
        authorList.add(author);
        authorList.add(author1);


        book.setAuthors(authorList);
        author.setBooks(bookList);

        book1.setAuthors(authorList);
        author1.setBooks(bookList);


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        session.persist(book1);
        session.persist(author);
        session.persist(author1);
        transaction.commit();
        session.close();


     }
}
