package com.olson.controller;

import com.olson.service.MeaningOfLifeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MeaningOfLifeController {

    @Autowired
    MeaningOfLifeService meaningOfLifeService;

    @RequestMapping(value = {"/basicExample"})
    public String renderBasicVIew() {
        return "basicExample";
    }

    @RequestMapping(value = {"/whatIsTheMeaningOfLife"})
    @ResponseBody
    public String whatIsTheMeaningOfLife() {
        String meaningOfLife = meaningOfLifeService.whatIsTheMeaningOfLife();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("answer", meaningOfLife);
        return jsonObject.toString();
    }
}
