package com.microservices.demo.elastic.query.client.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.microservices.demo.elastic.model.index.IndexModel;
@Primary
@Service
public interface ElasticQueryClient<T extends IndexModel> {
    T getIndexModelById(String id);
    List<T> getIndexModelByText(String text);
    List<T> getAllIndexModels();
}
