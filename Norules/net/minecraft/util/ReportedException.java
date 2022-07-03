package net.minecraft.util;

import net.minecraft.crash.*;

public class ReportedException extends RuntimeException
{
    private final /* synthetic */ CrashReport crashReport;
    
    @Override
    public Throwable getCause() {
        return this.crashReport.getCrashCause();
    }
    
    @Override
    public String getMessage() {
        return this.crashReport.getDescription();
    }
    
    public ReportedException(final CrashReport llllllllllllllllIIIlllllIllIlIll) {
        this.crashReport = llllllllllllllllIIIlllllIllIlIll;
    }
    
    public CrashReport getCrashReport() {
        return this.crashReport;
    }
}
