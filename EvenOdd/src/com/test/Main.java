package com.test;


public class Main {

    public static void main(String[] args) {

        State state = new State(PrinterType.ODD);
        Printer oddPrinter = new Printer(1,50,state,PrinterType.ODD,PrinterType.EVEN);
        Printer evenPrinter = new Printer(2,50,state,PrinterType.EVEN,PrinterType.ODD);
        Thread thread = new Thread(oddPrinter);
        Thread thread1 = new Thread(evenPrinter);
        thread.start();
        thread1.start();
    }
}
