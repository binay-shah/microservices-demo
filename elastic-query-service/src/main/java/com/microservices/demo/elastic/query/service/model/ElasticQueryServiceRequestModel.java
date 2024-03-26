package com.microservices.demo.elastic.query.service.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElasticQueryServiceRequestModel {
    private String id;
    @NotEmpty
    private String text;
}
