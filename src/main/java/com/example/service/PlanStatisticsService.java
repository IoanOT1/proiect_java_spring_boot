package com.example.service;

import com.example.model.SubscriptionPlan;
import com.example.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanStatisticsService {
    @Autowired
    ContractRepository contractRepository;

    public List<SubscriptionPlan> getNMostPopularSubscriptionPlan(Integer n){
        return contractRepository.getNMostCommonSubscriptionPlans(n);
    }
}
