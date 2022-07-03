package net.minecraft.command;

public class PlayerNotFoundException extends CommandException
{
    public PlayerNotFoundException(final String llIIllIlIlIll, final Object... llIIllIlIlIlI) {
        super(llIIllIlIlIll, llIIllIlIlIlI);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public PlayerNotFoundException(final String llIIllIllIIll) {
        super(llIIllIllIIll, new Object[0]);
    }
}
