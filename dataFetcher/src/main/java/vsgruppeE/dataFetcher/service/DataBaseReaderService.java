package vsgruppeE.dataFetcher.service;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import vsgruppeE.dataFetcher.configuration.MongoConfig;
import static com.mongodb.client.model.Filters.*;

public class DataBaseReaderService {
    @Autowired
    MongoConfig config;


    public Document getData() throws Exception {

        try {
            MongoDatabase db = config.getDB();
            MongoCollection coll = db.getCollection("coronaData");
            return (Document)coll.find().first();
            
        } catch (MongoSocketOpenException E) {
            System.out.println("Socket couldnt be opened");
            return null;
        }
    }

    public Document getAllData() throws Exception {
        try {
            MongoDatabase db = config.getDB();
            MongoCollection coll = db.getCollection("coronaData");
            return (Document)(coll.find());
        } catch (MongoSocketOpenException E) {
            System.out.println("Socket couldnt be opened");
            return null;
        }
    }
}
