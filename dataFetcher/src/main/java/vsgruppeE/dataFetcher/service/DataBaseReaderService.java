package vsgruppeE.dataFetcher.service;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.Document;
import vsgruppeE.dataFetcher.configuration.MongoConfig;

@Service
public class DataBaseReaderService {
    @Autowired
    MongoConfig config;

    public Document getData() throws Exception {

        try {
            MongoDatabase db = config.getDB();
            MongoCollection<Document> coll = db.getCollection("coronaData");
            return coll.find().first();
            
        } catch (MongoSocketOpenException E) {
            System.out.println("Socket couldnt be opened");
            return null;
        }
    }

    public List<Document> getAllData() throws Exception {
        try {
            MongoDatabase db = config.getDB();
            MongoCollection<Document> coll = db.getCollection("coronaData");
            return coll.find().into(new ArrayList<Document>());
        } catch (MongoSocketOpenException E) {
            System.out.println("Socket couldnt be opened");
            return null;
        }
    }
}
