package vsgruppeE.dataHandler.repository;

import java.util.ArrayList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="data",url="http://localhost:8081")
public interface dataRepository {
    
    @GetMapping("/data/all")
    ArrayList<String> getAllData();

    @GetMapping("/data/single")
    String getData();
}