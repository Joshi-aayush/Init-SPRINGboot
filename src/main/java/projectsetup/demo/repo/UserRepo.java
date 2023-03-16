package projectsetup.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectsetup.demo.entity.Book;
import projectsetup.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(
            nativeQuery = true,
            value = "select * from users where user_name = ?1"
    )
            User getUserByUserName(String username);
}
