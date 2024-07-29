package com.example.productservicettsevening.controller.Webhooks;

import com.stripe.model.Event;
import com.stripe.net.Webhook;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook/stripe")
public class StripeWebhookController {

    @PostMapping("/")
    public void handleWebhookRequest(@RequestBody Event webhookEvent){
        return;

    }
}
