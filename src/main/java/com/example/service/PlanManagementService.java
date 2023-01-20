package com.example.service;

import com.example.model.*;
import com.example.repository.SubscriptionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;

// TODO throw errors for bad input in service

@Service
public class PlanManagementService {
    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlan addSubscriptionPlan(SubscriptionPlan subscriptionPlan, List<String> details) {
        subscriptionPlan.setDetails(details);
        return subscriptionPlanRepository.save(subscriptionPlan);
    }
}
