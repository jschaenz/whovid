package vsgruppeE.dataWriter.service;

import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import vsgruppeE.dataWriter.configuration.MongoConfig;
import static com.mongodb.client.model.Filters.*;

@Service
public class DataBaseWriterService {
    @Autowired
    MongoConfig config;

    @Autowired
    statisticsCreationService statistics;

    @Scheduled(fixedDelay = 14400000)
    public void writeData() throws Exception {
        try {
            MongoDatabase db = config.getDB();
            MongoCollection coll = db.getCollection("coronaData");

            Document newData = statistics.getDeutschland();

            String newTimestamp = (String) newData.get("timestamp");

            //only insert new Data
            if(coll.find(eq("timestamp", newTimestamp)).first() == null){
                coll.insertOne(newData);
            }
        } catch (MongoSocketOpenException E) {
            System.out.println("Socket couldnt be opened");
        }
    }
}
