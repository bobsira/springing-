package hello.springframework.hello.repositories;

import hello.springframework.hello.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
