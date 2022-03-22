package com.example.flipper;

import com.example.flipper.machine.FlipperMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlipperApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlipperApplication.class, args);

        FlipperMachine flipperMachine = new FlipperMachine();
        System.out.println("Pressing start");
        flipperMachine.pressStart();
        System.out.println("Inserting coin");
        flipperMachine.insertCoin();
        System.out.println("Credits: " + flipperMachine.getCredit());
        System.out.println("Pressing start");
        flipperMachine.pressStart();
        System.out.println("Inserting coin");
        flipperMachine.insertCoin();
        System.out.println("Credits: " + flipperMachine.getCredit());
        System.out.println("Hitting everything once");
        flipperMachine.hitEverythingOnce();
        System.out.println("Credits: " + flipperMachine.getCredit());
        System.out.println("Score: " + flipperMachine.getScoreboard().getScore());

    }
}
