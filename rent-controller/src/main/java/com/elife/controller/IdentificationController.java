package com.elife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author llb
 */
@Controller
@RequestMapping("identification")
public class IdentificationController {

    @RequestMapping("show")
    public String showIdentification(){
        return "identification";
    }

}
