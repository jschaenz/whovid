package vsgruppeE.dataWriter.service;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import vsgruppeE.dataWriter.configuration.MongoConfig;

@Service
public class DataBaseWriterService {
    @Autowired
    MongoConfig config;

    @Autowired
    statisticsCreationService statistics;

    @Scheduled(fixedDelay = 14400000)
    public void writeData() throws Exception {
        try{
            MongoDatabase db = config.getDB();
            MongoCollection coll = db.getCollection("coronaData");

            coll.insertOne(statistics.getDeutschland());

            Document x = (Document) coll.find().first();

            System.out.println(x.toJson());
        }
        catch(MongoSocketOpenException E){
            System.out.println("Socket couldnt be opened");
        }   
    }
}
