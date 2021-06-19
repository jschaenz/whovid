package vsgruppeE.dataHandler.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vsgruppeE.dataHandler.model.chartModel;
import vsgruppeE.dataHandler.model.statisticsModel;
import vsgruppeE.dataHandler.repository.dataRepository;

@Service
public class dataHandlerService {

    @Autowired
    public dataRepository repo;

    public statisticsModel data() {
        return new statisticsModel(new JSONObject (repo.getData()));
    }

    public JSONArray allData() {

        JSONArray multipleStats = new JSONArray();
        repo.getAllData().forEach(x->{
            statisticsModel tmp = new statisticsModel(new JSONObject(x));
            multipleStats.put(tmp);
        });
        return multipleStats;
    }

    public chartModel chartData(){
        JSONArray data = allData();
        ArrayList<Integer> values = new ArrayList();
        ArrayList<String> labels = new ArrayList();
        for(Object ob: data){
                values.add(((statisticsModel)ob).getNewCases());
                labels.add(((statisticsModel)ob).getTimestamp().split("T")[0]);
            }
 
    
        return new chartModel(values,labels);
    }
}
