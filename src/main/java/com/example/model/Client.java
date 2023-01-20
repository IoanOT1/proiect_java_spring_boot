package com.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import javax.swing.*;
import java.io.ObjectInputValidation;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ApiModel(value = "Client", description = "Contains identifying information for a client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @NotBlank(message = "First name cannot be null")
    @ApiModelProperty(required = true, value = "The first name of the client", example = "Andrei")
    private String firstName;
    @NotBlank(message = "Last name cannot be null")
    @ApiModelProperty(required = true, value = "The last name of the client", example = "Vancea")
    private String lastName;

}
