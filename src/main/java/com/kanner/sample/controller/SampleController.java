package com.kanner.sample.controller;

import com.kanner.sample.model.User;
import com.kanner.sample.service.TemplateEngineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kanner
 */
@RestController
public class SampleController {

    @Resource
    private TemplateEngineService templateEngineService;

    @GetMapping("/user")
    public ResponseEntity<Object> getTemplateInfo() {
        final Map<String, Object> model = new HashMap<>(1);
        final User user = new User();
        user.setUsername("kanner");
        user.setAge(23);
        user.setAddress("China");
        model.put("user", user);
        final String info = templateEngineService.render("user", model);
        return new ResponseEntity<Object>(info, HttpStatus.OK);
    }

}
