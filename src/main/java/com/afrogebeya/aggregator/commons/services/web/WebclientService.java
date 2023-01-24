package com.afrogebeya.aggregator.commons.services.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WebclientService {


    Mono get(String endpoint, Map<String, String> headers, Class responseClass) throws SSLException {
        WebClient webClient;
        webClient = createWebClient();
        return   webClient
                .get()
                .uri(endpoint)
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(getAcceptedMediaTypes());
                    if (null != headers)
                        headers.keySet().forEach(key -> httpHeaders.add(key, headers.get(key)));
                })
                .exchangeToMono(clientResponse -> {
                    log.info("clientResponse.rawStatusCode() ::::::::::: {}", clientResponse.statusCode().value());
                    if(clientResponse.statusCode().value()== 465){
                        return Mono.just(responseClass);
                    } else if (clientResponse.statusCode().isError()) {
                        log.error("HttpStatusCode = {}", clientResponse.statusCode());
                        log.error("HttpHeaders = {}", clientResponse.headers().asHttpHeaders());
                        return clientResponse.createException()
                                .flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(responseClass);
                });
    }

    Mono delete(String endpoint, Map<String, String> headers, Class responseClass) throws SSLException {
        WebClient webClient;
        webClient = createWebClient();
        return   webClient
                .delete()
                .uri(endpoint)
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(getAcceptedMediaTypes());
                    if (null != headers)
                        headers.keySet().forEach(key -> httpHeaders.add(key, headers.get(key)));
                })
                .exchangeToMono(clientResponse -> {
                    log.info("clientResponse.rawStatusCode() ::::::::::: {}", clientResponse.statusCode().value());
                    if(clientResponse.statusCode().value()== 465){
                        return Mono.just(responseClass);
                    } else if (clientResponse.statusCode().isError()) {
                        log.error("HttpStatusCode = {}", clientResponse.statusCode());
                        log.error("HttpHeaders = {}", clientResponse.headers().asHttpHeaders());
                        return clientResponse.createException()
                                .flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(responseClass);
                });
    }

    Mono put(String endpoint, String body, Map<String, String> headers, Class responseClass) throws SSLException {
        WebClient webClient;
        webClient = createWebClient();
        return   webClient
                .put()
                .uri(endpoint)
                .body(Mono.just(body), String.class)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(getAcceptedMediaTypes());
                    if (null != headers)
                        headers.keySet().forEach(key -> httpHeaders.add(key, headers.get(key)));
                })
                .exchangeToMono(clientResponse -> {
                    log.info("clientResponse.rawStatusCode() ::::::::::: {}", clientResponse.statusCode().value());
                    if(clientResponse.statusCode().value()== 465){
                        return Mono.just(responseClass);
                    } else if (clientResponse.statusCode().isError()) {
                        log.error("HttpStatusCode = {}", clientResponse.statusCode());
                        log.error("HttpHeaders = {}", clientResponse.headers().asHttpHeaders());
                        return clientResponse.createException()
                                .flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(responseClass);
                });
    }

    public Mono post(String endpoint, String body, Map<String, String> headers, Class< ?> responseClass) throws SSLException {
        WebClient webClient;
        webClient = createWebClient();
        log.info("new post requested");
        return   webClient
                .post()
                .uri(endpoint)
                .body(Mono.just(body), String.class)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(getAcceptedMediaTypes());
                    if (null != headers)
                        headers.keySet().forEach(key -> httpHeaders.add(key, headers.get(key)));
                })
                .exchangeToMono(clientResponse -> {
                    log.info("clientResponse.rawStatusCode() ::::::::::: {}", clientResponse.statusCode().value());
                    return clientResponse.bodyToMono(responseClass);
                })
                .doOnError(error->log.error("error in ids reqiest "+error.getClass().toString()));
    }
    Mono postPPMS(String endpoint, String pathVariable,String reqParam, Map<String, String> headers, Class responseClass) throws SSLException {
        WebClient webClient;
        webClient = createWebClient();
        return   webClient
                .post()
                .uri(endpoint)
                //.body(Mono.just(body), String.class)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .headers(httpHeaders -> {
                    httpHeaders.setAccept(getAcceptedMediaTypes());
                    if (null != headers)
                        headers.keySet().forEach(key -> httpHeaders.add(key, headers.get(key)));
                })
                .exchangeToMono(clientResponse -> {
                    log.info("clientResponse.rawStatusCode() ::::::::::: {}", clientResponse.statusCode().value());
                    if(clientResponse.statusCode().value() == 465){
                        return Mono.just(responseClass);
                    } else if (clientResponse.statusCode().isError()) {
                        log.error("HttpStatusCode = {}", clientResponse.statusCode());
                        log.error("HttpHeaders = {}", clientResponse.headers().asHttpHeaders());
                        return clientResponse.createException()
                                .flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(responseClass);
                });
    }
    private WebClient createWebClient() throws SSLException {

        HttpClient httpClient = HttpClient.create();
        return WebClient
                .builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(1024 * 1024 * 10))
                .build();
    }

    private List<MediaType> getAcceptedMediaTypes() {
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(MediaType.TEXT_PLAIN);
        return mediaTypes;
    }
}
