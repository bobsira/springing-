package hello.springframework.hello.repositories;

import hello.springframework.hello.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher , Long> {
}
