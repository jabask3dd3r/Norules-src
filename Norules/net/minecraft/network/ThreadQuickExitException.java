package net.minecraft.network;

public final class ThreadQuickExitException extends RuntimeException
{
    static {
        INSTANCE = new ThreadQuickExitException();
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }
    
    private ThreadQuickExitException() {
        this.setStackTrace(new StackTraceElement[0]);
    }
}
