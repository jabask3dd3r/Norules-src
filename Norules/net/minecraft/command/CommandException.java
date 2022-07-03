package net.minecraft.command;

public class CommandException extends Exception
{
    private final /* synthetic */ Object[] errorObjects;
    
    public CommandException(final String lllllllllllllIllIIlIlIlIIIlllIII, final Object... lllllllllllllIllIIlIlIlIIIlllIlI) {
        super(lllllllllllllIllIIlIlIlIIIlllIII);
        this.errorObjects = lllllllllllllIllIIlIlIlIIIlllIlI;
    }
    
    public Object[] getErrorObjects() {
        return this.errorObjects;
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
