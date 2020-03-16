package com.example.demo.controller;

import com.example.demo.service.QRservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

@Controller
public class TestController {

    @Autowired
    private QRservice service;

    @RequestMapping(value="/makeQR", method= RequestMethod.GET)
    public View getQrCode(){

        //default config
        String url = "http://friday.fun25.co.kr/apps/portfolio/intro";
        int width = 300;
        int height = 300;

        return ViewUtil.getQrView(service.makeQRMatrix("http://www.naver.com", 300, 300), service.makeColorConfig("0xff000000", "0xffffffff"));
    }

}
