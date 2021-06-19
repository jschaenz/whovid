package vsgruppeE.dataHandler.model;

import java.util.ArrayList;

public class chartModel {
    public ArrayList<Integer> values;
    public ArrayList<String> labels;

    public chartModel(ArrayList<Integer> values, ArrayList<String> labels){
        this.values = values;
        this.labels = labels;
    }

}
