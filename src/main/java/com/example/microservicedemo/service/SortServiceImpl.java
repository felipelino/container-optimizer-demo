package com.example.microservicedemo.service;

import com.example.microservicedemo.model.IntList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Comparator;
import java.util.Random;

@Service
public class SortServiceImpl implements SortService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortServiceImpl.class);
    private Random random = new Random();

    @Async
    @Override
    public ListenableFuture<IntList> sort(IntList intListInput) throws InterruptedException {

        LOGGER.info("InputList: "+intListInput.getList());
        int sleepMs =random.nextInt(100)+1;
        LOGGER.info("Sleeping for "+sleepMs + " ms");
        Thread.sleep(sleepMs);
        intListInput.getList().sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        LOGGER.info("OutputList: "+intListInput.getList());
        return new AsyncResult<>(intListInput);
    }
}
