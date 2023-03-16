package projectsetup.demo.dto;
import projectsetup.demo.entity.Book;

public class BookPojo {
    private Integer id;
    private String name;
    private Double price;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookPojo(Book book){
        this.id = book.getId();
        this.name = book.getName();
        this.price = book.getPrice();
        this.author =book.getAuthor();
    }

    public BookPojo(){

    }

}
