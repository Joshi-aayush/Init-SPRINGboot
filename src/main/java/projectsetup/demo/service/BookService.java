package projectsetup.demo.service;
import projectsetup.demo.dto.BookPojo;
import javax.persistence.Id;
import java.util.List;

public interface BookService {
    List<BookPojo> getAllBooks();

    void saveBook(BookPojo bookPojo);

    void deleteBook(Integer id);

   BookPojo getById(Integer id);

   void updateBook(Integer id,BookPojo bookPojo);
}
