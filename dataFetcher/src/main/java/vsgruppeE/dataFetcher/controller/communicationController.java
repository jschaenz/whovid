package vsgruppeE.dataFetcher.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import vsgruppeE.dataFetcher.service.DataBaseReaderService;

@Controller
public class communicationController {
    
    @Autowired
    DataBaseReaderService dbReader;
    
    @GetMapping("/data/single")  
    public ResponseEntity<String> getData() throws Exception{
        return new ResponseEntity<>(dbReader.getData().toJson(),HttpStatus.OK) ;
    }
    
    @GetMapping("/data/all")  
    public ResponseEntity<ArrayList<String>> getAllData() throws Exception{
        ArrayList<String> returnV = new ArrayList<>();

        dbReader.getAllData().forEach(x->{
            returnV.add(x.toJson());
        });
        return new ResponseEntity<>(returnV,HttpStatus.OK);
    }
}
