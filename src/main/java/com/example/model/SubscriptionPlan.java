package com.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@ApiModel(value = "SubscriptionPlan",
        description = "Subscription plans are used in contracts")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subscriptionPlanId;
    @NotBlank(message = "The name of the subscription plan cannot be null")
    @ApiModelProperty(required = true, value = "The name of the subscription plan", notes = "Cannot be blank")
    private String name;
    @NotEmpty(message = "There must be at least one description of the subscription plan")
    @ElementCollection
    @ApiModelProperty(required = true, value = "The list of details about the subscription plan")
    private List<String> details;
    @ApiModelProperty(required = true, value = "The required amount to be paid (in euros)")
    private BigDecimal pricePerYear;
}