import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class OnetoOneMain {
    public static void main(String[] args) {
        Book book = new Book();
        Author author = new Author();

        book.setBookId("B001");
        book.setBookName("Wimpy Kid");
        book.setCategory("Funny");


        author.setName("Jeff Kenny");
        author.setId("A001");
        author.setAddress("Australia");
        author.setBook(book);


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        session.persist(author);
        transaction.commit();
        session.close();


    }
}
