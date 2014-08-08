package com.shangpin.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.shangpin.entity.User;

@Controller
public class TrainingController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String NAMESPACE = "hello";
    
    @ResponseBody
    @RequestMapping("/training")
    @ReadThroughSingleCache(namespace = NAMESPACE, expiration = 3600)
    public User index(@ParameterValueKeyProvider String id) {
        log.info("===============================================================");
//        Map<String, String> test = new HashMap<String, String>();
//        test.put("hello", "world");
        User user = new User();
        user.setId("123456");
        user.setName("Hello");
        return user;
    }
    
    public Map<String, String> trainingMap() {
    	Map<String, String> params = new HashMap<String, String>();
    	return params;
    }

}
