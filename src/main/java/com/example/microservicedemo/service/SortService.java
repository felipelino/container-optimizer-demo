package com.example.microservicedemo.service;

import com.example.microservicedemo.model.IntList;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

public interface SortService {

    @Async
    ListenableFuture<IntList> sort(IntList intListInput) throws InterruptedException ;
}
