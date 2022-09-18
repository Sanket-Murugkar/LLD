package com.test;

public class State {

    private PrinterType printerType;

    public State(PrinterType printerType) {
        this.printerType = printerType;
    }

    public PrinterType getPrinterType() {
        return printerType;
    }

    public void setPrinterType(PrinterType printerType) {
        this.printerType = printerType;
    }
}
