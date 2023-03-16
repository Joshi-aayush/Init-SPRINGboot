package projectsetup.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectsetup.demo.dto.BookPojo;
import projectsetup.demo.entity.Book;
import projectsetup.demo.repo.BookRepo;
import projectsetup.demo.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;
    @Override
    public List<BookPojo> getAllBooks() {
        List<BookPojo> responses = new ArrayList<>();
        List<Book> books = bookRepo.findAll();
        for(Book book:books ) {
            BookPojo bookPojo = new BookPojo(book);
            responses.add(bookPojo);
        }
        return responses;
    }

    @Override
    public void saveBook(BookPojo bookPojo) {
        Book bookType = new Book();
        bookType.setName(bookPojo.getName());
        bookType.setPrice(bookPojo.getPrice());
        bookType.setAuthor(bookPojo.getAuthor());
        bookRepo.save(bookType);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepo.deleteById(id);
    }

    @Override
    public BookPojo getById(Integer id) {
        Book book = bookRepo.findById(id).get();
        BookPojo bookPojo = new BookPojo(book);
        return bookPojo;
    }

    @Override
    public void updateBook(Integer id, BookPojo bookPojo) {
        Book bookType = bookRepo.getById(id);
        bookType.setName(bookPojo.getName());
        bookType.setPrice(bookPojo.getPrice());
        bookType.setAuthor(bookPojo.getAuthor());
        bookRepo.save(bookType);
    }
}
