package vsgruppeE.dataHandler.model;

import org.json.JSONObject;

public class statisticsModel {
    private int newCases;
    private int newCriticals;
    private int newDeaths;
    private int newRecoveries;
    private int allCases;
    private int allCriticals;
    private int allDeaths;
    private int allRecoveries;
    private int tests;
    private String placeName;
    private int population;
    private String timestamp;

    public statisticsModel(JSONObject jsonData) {
        this.allCases = jsonData.optInt("allCases");
        this.allCriticals = jsonData.optInt("allCriticals");
        this.allDeaths = jsonData.optInt("allDeaths");
        this.allRecoveries = jsonData.optInt("allRecoveries");
        this.newCases = jsonData.optInt("newCases");
        this.newCriticals = jsonData.optInt("newCriticals");
        this.newDeaths = jsonData.optInt("newDeaths");
        this.newRecoveries = jsonData.optInt("newRecoveries");
        this.placeName = jsonData.optString("placeName");
        this.population = jsonData.optInt("population");
        this.tests = jsonData.optInt("tests");
        this.timestamp = jsonData.optString("timestamp");
    }

    public int getNewCases() {
        return this.newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public int getNewCriticals() {
        return this.newCriticals;
    }

    public void setNewCriticals(int newCriticals) {
        this.newCriticals = newCriticals;
    }

    public int getNewDeaths() {
        return this.newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public int getNewRecoveries() {
        return this.newRecoveries;
    }

    public void setNewRecoveries(int newRecoveries) {
        this.newRecoveries = newRecoveries;
    }

    public int getAllCases() {
        return this.allCases;
    }

    public void setAllCases(int allCases) {
        this.allCases = allCases;
    }

    public int getAllCriticals() {
        return this.allCriticals;
    }

    public void setAllCriticals(int allCriticals) {
        this.allCriticals = allCriticals;
    }

    public int getAllDeaths() {
        return this.allDeaths;
    }

    public void setAllDeaths(int allDeaths) {
        this.allDeaths = allDeaths;
    }

    public int getAllRecoveries() {
        return this.allRecoveries;
    }

    public void setAllRecoveries(int allRecoveries) {
        this.allRecoveries = allRecoveries;
    }

    public int getTests() {
        return this.tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

    public String getTimestamp(){
        return this.timestamp;
    }
}