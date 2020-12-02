package com.avaj.simulator.errors;

public class SimulatorException extends CustomParameterizedException {

    public SimulatorException() {
        super(ExceptionMessageConstants.SIMULATOR, ErrorConstants.ERR_SIMU);
    }

    public SimulatorException(String message) {
        super(message, ErrorConstants.ERR_SIMU);
    }
}
