package com.eweb.demo.controller;

import com.eweb.demo.dto.Checkout.ChargeRequest;
import com.eweb.demo.service.ChargeProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ChargeController {

    @Autowired
    private ChargeProcessService chargeProcessService;

//    @PostMapping("/charge")
//    public ModelAndView charge(ChargeRequest chargeRequest, Model model){
//        chargeProcessService.chargeProcesses(model, chargeRequest);
//    }
//
}
