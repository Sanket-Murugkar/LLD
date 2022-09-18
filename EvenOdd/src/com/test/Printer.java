package com.test;

public class Printer implements Runnable {


    private int currentValue;
    private int maxValue;
    private State state;
    private PrinterType currentPrinterType;
    private PrinterType nextPrinterType;

    public Printer(int currentValue, int maxValue, State state, PrinterType currentPrinterType, PrinterType nextPrinterType) {
        this.currentValue = currentValue;
        this.maxValue = maxValue;
        this.state = state;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
    }

    @Override
    public void run() {

        while (currentValue <= maxValue) {
            synchronized (state) {
                while (this.currentPrinterType != state.getPrinterType()) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("current Thread.." + state.getPrinterType() + "..." + currentValue);
                currentValue = currentValue + 2;
                state.setPrinterType(nextPrinterType);
                state.notifyAll();
            }
        }
    }
}