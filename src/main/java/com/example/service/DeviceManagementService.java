package com.example.service;

import com.example.model.Contract;
import com.example.model.Device;
import com.example.repository.ContractRepository;
import com.example.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceManagementService {
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    ContractRepository contractRepository;

    public Contract updateDeviceInContract(Integer contractId, List<Integer> devicesId){
        List<Device> devices = deviceRepository.findAllById(devicesId);
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new RuntimeException("Contract save error, client id invalid"));
        contract.setDevices(devices);
        return contractRepository.save(contract);
    }
}
