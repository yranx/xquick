package com.ranx.chowder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Locale;

/**
 * @author ranx
 * @create 2018-08-09 14:06
 **/
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/hello")
    public String hello(Model model){
        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("message", messageSource.getMessage("message", null, locale));
        return "/chinaEng";
    }

    @RequestMapping("/fileOper")
    public String fileOper(){
        return "/updownload";
    }

    @RequestMapping("/excel")
    public String excelUse() {
        return "exceluse";
    }
}
