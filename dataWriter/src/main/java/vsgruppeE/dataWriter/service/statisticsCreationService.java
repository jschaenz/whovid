package vsgruppeE.dataWriter.service;

import java.io.IOException;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class statisticsCreationService {

    @Autowired
    dataGetterService dataGetter;

    public Document getDeutschland() throws JSONException, IOException, InterruptedException {
        JSONObject allData = dataGetter.getData();
        JSONArray data = new JSONArray(allData.optString("data"));

        Document doc =  new Document();
        data.forEach(x -> {
            JSONObject curr = (JSONObject) x;
            if (curr.optString("placeName").contains("Germany")) {

                doc.append("allCases",curr.optInt("allCases"))
                    .append("allCriticals",curr.optInt("allCriticals"))
                    .append("allDeaths", curr.optInt("allDeaths"))
                    .append("allRecoveries", curr.optInt("allRecoveries"))
                    .append("newCases",curr.optInt("newCases"))
                    .append("newCriticals",curr.optInt("newCriticals"))
                    .append("newDeaths",curr.optInt("newDeaths"))
                    .append("newRecoveries",curr.optInt("newRecoveries"))
                    .append("placeName",curr.optString("placeName"))
                    .append("population",curr.optInt("population"))
                    .append("tests",curr.optInt("tests"))
                    .append("timestamp",curr.optString("date"));
            }
        });
        return doc;
    }
}