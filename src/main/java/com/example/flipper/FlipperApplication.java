package com.example.flipper;

import com.example.flipper.machine.FlipperMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlipperApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlipperApplication.class, args);
        FlipperMachine flipperMachine = new FlipperMachine();
//        flipperMachine.setCurrentState(flipperMachine.getEnd());
    
    }
}
