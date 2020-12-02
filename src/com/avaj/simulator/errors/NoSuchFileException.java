package com.avaj.simulator.errors;

public class NoSuchFileException extends CustomParameterizedException {
    public NoSuchFileException() {
        super(ExceptionMessageConstants.FILE_MISSING, ErrorConstants.ERR_NO_SUCH_FILE);
    }

    public NoSuchFileException(String message) {
        super(message + " " + ExceptionMessageConstants.FILE_MISSING, ErrorConstants.ERR_NO_SUCH_FILE);
    }
}
