package projectsetup.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import projectsetup.demo.dto.BookPojo;
import projectsetup.demo.service.BookService;
import javax.naming.Binding;

@Controller
public class BookController   {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String loadIndexPage(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/add-book")
    public String loadAddBookPage(Model model){
        model.addAttribute("book",new BookPojo());
        return "add-book";
    }

    @PostMapping("/save")
    public  String saveBook(Model model, @ModelAttribute("book")BookPojo bookPojo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "add-book";
        }
        bookService.saveBook(bookPojo);
        return "redirect:/";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public  String loadUpdatePage(@PathVariable Integer id, Model model){
        model.addAttribute("book",bookService.getById(id));
        return "update-book";
    }
    @PostMapping("/update/{id}")
    public  String updateBook(@PathVariable Integer id,@ModelAttribute("book")BookPojo bookPojo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "update-book";
        }
        bookService.updateBook(id,bookPojo);
        return "redirect:/";
    }

    @GetMapping("/403")
    public  String accessDeniedPage(){
        return "403";
    }
}
