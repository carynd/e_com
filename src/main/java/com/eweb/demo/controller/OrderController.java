package com.eweb.demo.controller;


import com.eweb.demo.service.AuthenticationTokenService;
import com.eweb.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private AuthenticationTokenService authenticationTokenService;

    @Autowired
    private OrderService orderService;

//    @PostMapping("/create-checkout-session")
//    public ResponseEntity<StripeResponse> checkoutList(@RequestBody CheckoutRequest checkoutRequest)
//            throws StripeException {
//        String sessionId = orderService.createSession1(checkoutRequest);
//        return new ResponseEntity<>(new StripeResponse(sessionId), HttpStatus.OK);
//
//    }

    @Value("${STRIPE_SECRET_KEY}")
    private String stripePublicKey;

    @GetMapping("/checkout")
    public ModelAndView checkout(@RequestParam(required=true) String systemUserId, @RequestParam(required = true) Integer amount){

        ModelAndView model=new ModelAndView();
        model.addObject("amount",amount*100);
        model.addObject("stripePublicKey", stripePublicKey);
        model.addObject("currency","USD");
        model.addObject("systemUserId",systemUserId);
        model.setViewName("checkout");
        return model;
    }


}