package projectsetup.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import projectsetup.demo.entity.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
