package com.example.microservicedemo;

import com.example.microservicedemo.model.IntList;
import com.example.microservicedemo.model.ListIntRequest;
import com.example.microservicedemo.model.SortIntListResponse;
import com.example.microservicedemo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class ApiController {

    private SortService sortService;

    @Autowired
    public ApiController(SortService sortService) {
        this.sortService = sortService;
    }

    @RequestMapping(path="/sort", method = RequestMethod.POST)
    public ResponseEntity<?> sort(@RequestBody  ListIntRequest request) throws InterruptedException, ExecutionException {

        SortIntListResponse response = new SortIntListResponse();
        List<ListenableFuture<IntList>> futureList = new ArrayList<>();
        for ( IntList intList : request.getIntList()) {
            ListenableFuture<IntList> future = this.sortService.sort(intList);
            futureList.add(future);
        }

        response.setIntList(new ArrayList<>());
        for(ListenableFuture<IntList> future : futureList) {
            IntList intList = future.get();
            response.getIntList().add(intList);
        }

        return ResponseEntity.ok(response);
    }

    @RequestMapping(path="/status", method = RequestMethod.GET)
    public ResponseEntity<?> status()  {

        Map<String, String> json = new HashMap<>();
        json.put("isRunning" ,"true");
        return ResponseEntity.ok(json);
    }
}
