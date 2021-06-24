package vsgruppeE.dataHandler.controller;


import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import vsgruppeE.dataHandler.model.chartModel;
import vsgruppeE.dataHandler.model.statisticsModel;
import vsgruppeE.dataHandler.service.dataHandlerService;

@Controller
public class dataController {
    
    @Autowired
    dataHandlerService handler;


    @GetMapping("/data/all") 
    public ResponseEntity<JSONArray> getAllData() throws Exception{
        return new ResponseEntity<>(handler.allData(),HttpStatus.OK);
    }
    @GetMapping("/data/single") 
    public ResponseEntity<statisticsModel> getData() throws Exception{
        return new ResponseEntity<>(handler.data(),HttpStatus.OK);
    }
    @GetMapping("/data/chart") 
    public ResponseEntity<chartModel> getChart() throws Exception{
        return new ResponseEntity<>(handler.chartData(),HttpStatus.OK);
    }
}
