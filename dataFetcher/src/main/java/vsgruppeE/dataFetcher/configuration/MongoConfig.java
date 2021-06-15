package vsgruppeE.dataFetcher.configuration;

import java.net.UnknownHostException;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    public MongoDatabase getDB() throws UnknownHostException {

        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://vs21:vs21@verteiltesysteme21.we92s.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

        MongoDatabase db = mongoClient.getDatabase("coronaData");
        return db;
    }
}
