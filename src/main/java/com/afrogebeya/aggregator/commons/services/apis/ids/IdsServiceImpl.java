package com.afrogebeya.aggregator.commons.services.apis.ids;

import com.afrogebeya.posts.commons.configs.apis.ApisConfig;
import com.afrogebeya.posts.commons.configs.apis.ClientConfig;
import com.afrogebeya.posts.commons.services.apis.ids.models.IdsValidateRequestViewModel;
import com.afrogebeya.posts.commons.services.apis.ids.models.IdsValidateResponseViewModel;
import com.afrogebeya.posts.commons.services.apis.ids.models.User;
import com.afrogebeya.posts.commons.services.web.WebclientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.net.ssl.SSLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

@Service
@Slf4j
public class IdsServiceImpl implements IdsService{
    @Autowired
    ApisConfig apiConfig;

    @Autowired
    WebclientService webService;

    @Autowired
    ClientConfig clientConfig;

    ObjectMapper mapper  =new ObjectMapper();

    @Override
    public Mono<User>  validateToken(String token) throws JsonProcessingException, SSLException, ExecutionException, InterruptedException {
        String url=apiConfig.getIdsUrl();
        String endpoint=url+"/identity/validate";
        log.info("Ids end point==={}"+endpoint);
        int clientId=clientConfig.getId();
        String clientUsername=clientConfig.getUsername();
        String clientPassword=clientConfig.getPassword();

        Map<String,String> header= new HashMap<>();
        header.put("selam","sdfsfhjskdhs");

        IdsValidateRequestViewModel request= new IdsValidateRequestViewModel();
        request.setToken(token);
        request.setClientId(clientConfig.getId());
        request.setClientSecret(clientConfig.getSecret());

        String body = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
        log.info("Request body=={}"+body);
        Function<IdsValidateResponseViewModel,User> fun=(userView)->{
            if(null==userView){
                log.error("Ids validation returns null");
                return null;
            }
            try {
                log.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userView));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            User user= new User();
            user.setEmail(userView.getUsername());
            user.setUserId(userView.getUserId());
            user.setStatus(userView.getStatus());
            user.setRoles(userView.getRoles());
            return user;
        };

       return   webService.post(endpoint, body, header, IdsValidateResponseViewModel.class).map(fun);


    }
}
