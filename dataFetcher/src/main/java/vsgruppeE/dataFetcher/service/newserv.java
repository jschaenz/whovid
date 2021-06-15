package vsgruppeE.dataFetcher.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class newserv {
    
    @Autowired
    DataBaseReaderService reader;

    @PostConstruct
    public void go() throws Exception{
        System.out.println(reader.getData().toString());

        System.out.println("!!!!!!!!!" + reader.getAllData().get(0));
    }
}
