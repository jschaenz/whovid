package vsgruppeE.dataFetcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class DataFetcherApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataFetcherApplication.class, args);	
		
	}

}
