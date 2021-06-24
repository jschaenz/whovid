package vsgruppeE.dataHandler.model;

import java.util.ArrayList;

public class chartModel {
    public ArrayList<Integer> allCases;
    public ArrayList<Integer> allDeaths;
    public ArrayList<Integer> allRecoveries;
    public ArrayList<Integer> Tests;
    public ArrayList<String> labels;

    public chartModel(ArrayList<Integer> allCases, ArrayList<String> labels,ArrayList<Integer> allDeaths,ArrayList<Integer> allRecoveries,ArrayList<Integer> Tests){
        this.allCases = allCases;
        this.labels = labels;
        this.allDeaths = allDeaths;
        this.allRecoveries = allRecoveries;
        this.Tests = Tests;
    }

}
