package com.example.apigateway.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyanan1
 */
@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public String fallback() {
        return "fallback";
    }
}
