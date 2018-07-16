package org.thepoet.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thepoet.elasticsearch.model.Log;
import org.thepoet.elasticsearch.service.LogService;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 19.05.2018
 */
@Controller
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/create-sample-log", method = RequestMethod.GET)
    public ModelAndView createSampleLog() {
        Log log = logService.createLog();
        String logValue = log.toString();
        System.out.println(logValue);
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("result", logValue);
        return modelAndView;
    }
}
