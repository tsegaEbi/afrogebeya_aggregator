package com.afrogebeya.aggregator.commons.services.apis.ids;

import com.afrogebeya.posts.commons.services.apis.ids.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Mono;

import javax.net.ssl.SSLException;
import java.util.concurrent.ExecutionException;

public interface IdsService {
    Mono<User> validateToken(String token) throws JsonProcessingException, SSLException, ExecutionException, InterruptedException;
}
