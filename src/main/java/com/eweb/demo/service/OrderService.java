package com.eweb.demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class OrderService {


    @Value("${BASE_URL}")
    public String baseURL;

    @Value("${STRIPE_SECRET_KEY}")
    public String apiKey;

//    public String createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {
//
//        // sucess and failure urls
//
//        String successURL = "https://example.com/success";
//
//        String failureURL = baseURL + "payment/failed";
//
//        Stripe.apiKey = apiKey;
//
//        List<SessionCreateParams.LineItem> sessionItemList = new ArrayList<>();
//
//
//        for (CheckoutItemDto checkoutItemDto: checkoutItemDtoList) {
//            sessionItemList.add(createSessionLineItem(checkoutItemDto));
//        }
//
//        SessionCreateParams params = SessionCreateParams.builder()
//                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
//                .setMode(SessionCreateParams.Mode.PAYMENT)
//                .addAllLineItem(sessionItemList)
//                .setSuccessUrl(successURL)
//                .setCancelUrl(failureURL)
//                .build();
//
//        Session session = Session.create(params);
//        return session.getId();
//    }
//
//    public SessionCreateParams.LineItem createSessionLineItem(CheckoutItemDto checkoutItemDto) {
//
//        return SessionCreateParams.LineItem.builder()
//                .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
//                        .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
//                                .setName(checkoutItemDto.getProductName())
//                                .build())
//                        .setCurrency("usd")
//                        .setUnitAmount((long)(checkoutItemDto.getPrice()*100))
//                        .build())
//                .setQuantity(Long.parseLong(String.valueOf(checkoutItemDto.getQuantity())))
//                .build();
//    }
//
//    public SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto) {
//        return SessionCreateParams.LineItem.PriceData.builder()
//                .setCurrency("usd")
//                .setUnitAmount((long)(checkoutItemDto.getPrice()*100))
//                .setProductData(
//                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
//                                .setName(checkoutItemDto.getProductName())
//                                .build()
//                ).build();
//    }
//
//    public String createSession1(CheckoutRequest checkoutRequest) throws StripeException {
//        Stripe.apiKey = apiKey;
//
//        List<SessionCreateParams.LineItem> lineItems = checkoutRequest.getLineItems().stream()
//                .map(item -> new SessionCreateParams.LineItem.Builder()
//                        .setPriceData(new SessionCreateParams.LineItem.PriceData.Builder()
//                                .setCurrency(item.getCurrency())
//                                .setProductData(new SessionCreateParams.LineItem.PriceData.ProductData.Builder()
//                                        .setName(item.getName())
//                                        .build())
//                                .setUnitAmount(item.getPrice())
//                                .build())
//                        .setQuantity(item.getQuantity())
//                        .build())
//                .collect(Collectors.toList());
//
//        SessionCreateParams params = new SessionCreateParams.Builder()
//                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
//                .setMode(SessionCreateParams.Mode.PAYMENT)
//                .setSuccessUrl(checkoutRequest.getSuccessUrl())
//                .setCancelUrl(checkoutRequest.getCancelUrl())
//                .addAllLineItem(lineItems)
//                .build();
//
//        Session session = Session.create(params);
//        return session.getId();
//
//    }
}