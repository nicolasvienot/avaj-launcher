package com.avaj.simulator;

import java.io.PrintWriter;
import java.io.*;

public class Tower {
    private Flyable _observers[];

    public static void register() {
        System.out.println("Je suis la!!!");
    }

    public static void unregister() {
        System.out.println("Je suis plus la...");
    }

    protected void conditionsChanged() {
        System.out.println("Conditions changed!!!");
    }
}