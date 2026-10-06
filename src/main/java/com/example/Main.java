package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try (Socket s = new Socket("10.22.10.25", 3000)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            do {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Inserisci una stringa:");
                    String testo = scanner.nextLine();

                    out.println(testo);
                }
                String ris = in.readLine();
                System.out.println(ris);

            } while (true);
        }

    }
}