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
        ArrayList<Integer> allCases = new ArrayList();
        ArrayList<Integer> allDeaths = new ArrayList();
        ArrayList<Integer> allRecoveries = new ArrayList();  
        ArrayList<Integer> Tests = new ArrayList();  
        ArrayList<String> labels = new ArrayList();
        for(Object ob: data){
                allCases.add(((statisticsModel)ob).getAllCases());
                allDeaths.add(((statisticsModel)ob).getAllDeaths());
                allRecoveries.add(((statisticsModel)ob).getAllRecoveries());
                Tests.add(((statisticsModel)ob).getTests());
                labels.add(((statisticsModel)ob).getTimestamp().split("T")[0]);
            }
 

        return new chartModel(allCases,labels,allDeaths,allRecoveries,Tests);
    }
}
