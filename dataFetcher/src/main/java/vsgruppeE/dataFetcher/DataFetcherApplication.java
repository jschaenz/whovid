package vsgruppeE.dataFetcher;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import vsgruppeE.dataFetcher.service.DataBaseReaderService;

@SpringBootApplication
@EnableMongoRepositories
public class DataFetcherApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataFetcherApplication.class, args);	
		
	}

}
