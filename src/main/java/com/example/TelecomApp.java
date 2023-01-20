package com.example;

import com.example.model.Client;
import com.example.repository.*;
import com.example.service.ClientManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class TelecomApp implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private SignatureRepository signatureRepository;
    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;
    @Autowired
    private WarrantyRepository warrantyRepository;
    @Autowired
    ClientManagementService clientManagementService;

    public static void main(String[] args) {
        SpringApplication.run(com.example.TelecomApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client client = Client.builder()
                .clientId(123)
                .firstName("abc")
                .lastName("def")
                .build();
    }

}