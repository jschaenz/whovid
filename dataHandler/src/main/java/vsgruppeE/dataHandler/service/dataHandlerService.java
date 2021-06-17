package vsgruppeE.dataHandler.service;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vsgruppeE.dataHandler.model.statisticsModel;
import vsgruppeE.dataHandler.repository.dataRepository;

@Service
public class dataHandlerService {

    @Autowired
    public dataRepository repo;

    public statisticsModel data() {
        return new statisticsModel(new JSONObject (repo.getData()));
    }

    public ArrayList<statisticsModel> allData() {

        ArrayList<statisticsModel> multipleStats = new ArrayList<>();
        repo.getAllData().forEach(x->{
            statisticsModel tmp = new statisticsModel(new JSONObject(x));
            multipleStats.add(tmp);
        });
        return multipleStats;
    }
}
