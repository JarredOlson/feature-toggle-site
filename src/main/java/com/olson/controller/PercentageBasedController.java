package com.olson.controller;

import com.olson.service.PercentageBasedService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PercentageBasedController {

    @Autowired
    PercentageBasedService percentageBasedService;

    @RequestMapping(value = {"/percentageBased"})
    public String renderBasicVIew() {
        return "percentageBased";
    }

    @RequestMapping(value = {"/amILucky"})
    @ResponseBody
    public String whatIsTheMeaningOfLife() {
        String meaningOfLife = percentageBasedService.amILucky();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("answer", meaningOfLife);
        return jsonObject.toString();
    }
}
