package projectsetup.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsetup.demo.entity.Book;
import projectsetup.demo.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {

}
