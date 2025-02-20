package com.example;

import java.lang.Thread;
import java.util.Random;


public class utils {

    private Random random;

    public utils(){
        this.random = new Random();
    }
    
    public void sleepQuietly(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Re-interrupt the current thread
        }
    }

    public String random_num_generator(long min, long max){
        return String.valueOf(min + (long) (random.nextDouble() * (max - min + 1)));
    }
}
