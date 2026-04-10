package com.spring.hrpayroll.services;

import com.spring.hrpayroll.entities.Payment;
import com.spring.hrpayroll.entities.Worker;
import com.spring.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient){
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
