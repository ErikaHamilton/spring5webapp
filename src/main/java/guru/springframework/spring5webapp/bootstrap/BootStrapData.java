package guru.springframework.spring5webapp.bootstrap;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
//import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRespository;
import guru.springframework.spring5webapp.repositories.BookRepository;
//import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRespository authorRespository;
    private final BookRepository bookRepository;
   // private final PublisherRepository publisherRepository;
    
  
    public BootStrapData(AuthorRespository authorRespository, BookRepository bookRepository) {
        this.authorRespository = authorRespository;
        this.bookRepository = bookRepository;
      
    }


    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("Started in BootStrap.");
        // Publisher publisher = new Publisher();
        // publisher.setPubName("SFG Petersburg");
        // publisher.setCity("St. Petersberg");
        // publisher.setState("FL");
        // publisher.setAddress("add1");
        // publisher.setZip("zip");

        // publisherRepository.save(publisher);
        //  System.out.println("Publisher Count: "+ publisherRepository.count());
    
        
        Author eric = new Author("Eric", "Evans" );
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

       // ddd.setPublisher(publisher);

       // publisher.getBooks().add(ddd);

      
       

        authorRespository.save(eric);
        bookRepository.save(ddd);
       // publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "39281031");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        //noEJB.setPublisher(publisher);
       // publisher.getBooks().add(noEJB);



        authorRespository.save(rod);
        bookRepository.save(noEJB);
        //publisherRepository.save(publisher);

       
        System.out.println("Number of Books: " + bookRepository.count());
       
       // System.out.println("No of Books to Publisher: " + publisher.getBooks().size());


        
    }


    
}
