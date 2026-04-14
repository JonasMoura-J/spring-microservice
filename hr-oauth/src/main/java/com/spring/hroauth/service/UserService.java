package com.spring.hroauth.service;

import com.spring.hroauth.entities.User;
import com.spring.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserFeignClient feignClient;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserFeignClient feignClient){
        this.feignClient = feignClient;
    }

    public User findByEmail(String email){
        User user = feignClient.findByEmail(email).getBody();

        if (user == null){
            logger.info("Email not found " + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found " + email);
        return user;
    }
}
