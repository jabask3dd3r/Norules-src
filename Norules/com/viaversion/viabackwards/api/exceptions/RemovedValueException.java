package com.viaversion.viabackwards.api.exceptions;

import java.io.*;

public class RemovedValueException extends IOException
{
    static {
        EX = new RemovedValueException() {
            @Override
            public Throwable fillInStackTrace() {
                return this;
            }
        };
    }
}
