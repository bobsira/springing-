package hello.springframework.hello.repositories;

import hello.springframework.hello.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long
        > {
}
