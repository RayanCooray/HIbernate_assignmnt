package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Author {
    @Id
    private String Id;
    private String Name;
    private String Address;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Author(List<Book> bookList) {
        this.bookList = bookList;
    }

    @OneToMany(mappedBy = "author")
    private List<Book>bookList;

    public Author() {

    }

    public Author(String id, String name, String address, Book book) {
        Id = id;
        Name = name;
        Address = address;

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
