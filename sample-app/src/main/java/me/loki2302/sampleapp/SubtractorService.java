package me.loki2302.sampleapp;

import org.springframework.stereotype.Service;

/**
 * Provides subtraction functionality
 */
@Service
public class SubtractorService {
    /**
     * Subtracts 2 numbers
     * @param a number A
     * @param b number B
     * @return difference of A and B
     */
    public int subtract(int a, int b) {
        return a - b;
    }
}
