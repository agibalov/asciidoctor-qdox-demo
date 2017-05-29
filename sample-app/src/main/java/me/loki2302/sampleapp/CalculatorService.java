package me.loki2302.sampleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements "add" and "subtract" operations
 */
@Service
public class CalculatorService {
    @Autowired
    private AdderService adderService;

    @Autowired
    private SubtractorService subtractorService;

    /**
     * Adds 2 numbers
     * @param a number A
     * @param b number B
     * @return sum of A and B
     */
    public int addNumbers(int a, int b) {
        return adderService.add(a, b);
    }

    /**
     * Subtracts 2 numbers
     * @param a number A
     * @param b number B
     * @return difference of A and B
     */
    public int subtractNumbers(int a, int b) {
        return subtractorService.subtract(a, b);
    }
}
