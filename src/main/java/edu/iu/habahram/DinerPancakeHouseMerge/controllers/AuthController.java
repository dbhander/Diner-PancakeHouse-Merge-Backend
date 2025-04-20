package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    private static final String CUSTOMER_FILE = "src/main/resources/data/customers.txt";

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestParam String email,
                                         @RequestParam String username,
                                         @RequestParam String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_FILE, true))) {
            writer.write(email + "," + username + "," + password + "\n");
            return ResponseEntity.ok("Signup successful!");
        } catch (IOException e) {
            e.printStackTrace(); // log it
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to sign up.");
        }
    }



}
