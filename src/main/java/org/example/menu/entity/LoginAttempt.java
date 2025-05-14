package org.example.menu.entity;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class LoginAttempt {
    private final AtomicInteger attempts = new AtomicInteger(0);
    private LocalDateTime timeOfAttempt = LocalDateTime.now();

    public void increment() {
        attempts.incrementAndGet();
        timeOfAttempt = LocalDateTime.now();
    }
    public LocalDateTime getTimeOfAttempt() {
        return timeOfAttempt;
    }

    public void reset(){
        attempts.set(0);
        timeOfAttempt = LocalDateTime.now();
    }

    public int getAttempts() {
        return attempts.get();
    }

}

