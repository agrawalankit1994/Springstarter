package com.example.springwebapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.springwebapp.beans.Author;
import com.example.springwebapp.beans.Book;
import com.example.springwebapp.beans.Publisher;
import com.example.springwebapp.repositories.AuthorRepository;
import com.example.springwebapp.repositories.BookRepository;
import com.example.springwebapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
    private AuthorRepository authorRepository;
	@Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    

  /*  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }*/

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher p=new Publisher();
        p.setAddress("address");
        p.setName("name");
        publisherRepository.save(p);
        Publisher p1=new Publisher();
        p1.setAddress("address1");
        p1.setName("name1");
        publisherRepository.save(p1);
        Book  ddd = new Book("Domain Driven Design", "1234", p);
        ddd.setPublisher(p);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", p1 );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
