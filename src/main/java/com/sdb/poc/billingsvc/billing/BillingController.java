package com.sdb.poc.billingsvc.billing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author simar bawa
 */
@RestController
@RequestMapping("billing-svc")
public class BillingController {

    @PostMapping(value="/process-billing-for-order")
    public ProcessBillingResponse processBillingForOrder(@RequestBody ProcessBillingRequest billingRequest){
        var response =  new ProcessBillingResponse();
        response.setOrderStatus(Boolean.FALSE);
        if (billingRequest.getOrderId() == 1) {
            response.setOrderStatus(Boolean.TRUE);
            return response;
        }
        return response;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ProcessBillingRequest {
        private Integer orderId;
        private String orderDetails;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ProcessBillingResponse {
        private Boolean orderStatus;

    }
}
