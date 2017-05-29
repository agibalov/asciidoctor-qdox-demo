package me.loki2302.sampleapp;

import org.springframework.stereotype.Service;

/**
 * Provides addition functionality
 */
@Service
public class AdderService {
    /**
     * Adds 2 numbers
     * @param a number A
     * @param b number B
     * @return sum of A and B
     */
    public int add(int a, int b) {
        return a + b;
    }
}
