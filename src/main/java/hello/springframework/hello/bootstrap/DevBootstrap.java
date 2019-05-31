package hello.springframework.hello.bootstrap;

import hello.springframework.hello.model.Author;
import hello.springframework.hello.model.Book;
import hello.springframework.hello.model.Publisher;
import hello.springframework.hello.repositories.AuthorRepository;
import hello.springframework.hello.repositories.BookRepository;
import hello.springframework.hello.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){
        Publisher harper_collins = new Publisher("Harper Collins","oxford-UK");
        Publisher wrox = new Publisher("Wrox", "cambbridge-manchester");

        publisherRepository.save(harper_collins);
        publisherRepository.save(wrox);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper_collins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "JohnSon");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

}
