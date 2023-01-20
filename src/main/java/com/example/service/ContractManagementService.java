package com.example.service;

import com.example.model.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContractManagementService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private SignatureRepository signatureRepository;

    public Signature sign(Signature signature) {
        return signatureRepository.save(signature);
    }

    public Contract create( Integer clientId,
                            Integer subscriptionId,
                            List<Integer> devicesId,
                            Integer signatureId,
                            Contract contract) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Contract save error, client id invalid"));
        SubscriptionPlan subscriptionPlan = subscriptionPlanRepository.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Subscription save error, subscription plan id invalid"));
        Signature signature = signatureRepository.findById(signatureId)
                .orElseThrow(() -> new RuntimeException("Subscription save error, signature id invalid"));
        List<Device> devices = deviceRepository.findAllById(devicesId);
        contract.setDevices(devices);
        contract.setSignature(signature);
        contract.setClient(client);
        contract.setSubscriptionPlan(subscriptionPlan);
        return contractRepository.save(contract);
    }
}
