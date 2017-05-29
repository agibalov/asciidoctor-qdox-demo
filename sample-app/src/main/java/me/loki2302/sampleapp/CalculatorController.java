package me.loki2302.sampleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Calculator REST API facade
 */
@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    /**
     * Handler for "add numbers" request
     * @param a number A
     * @param b number B
     * @return sum of A and B
     */
    @GetMapping("/sum/{a}/{b}")
    public CalculatorResponseDto addNumbers(
            @PathVariable int a,
            @PathVariable int b) {

        CalculatorResponseDto response = new CalculatorResponseDto();
        response.value = calculatorService.addNumbers(a, b);
        return response;
    }
}
