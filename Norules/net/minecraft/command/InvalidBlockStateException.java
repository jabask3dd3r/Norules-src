package net.minecraft.command;

public class InvalidBlockStateException extends CommandException
{
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public InvalidBlockStateException() {
        this("commands.generic.blockstate.invalid", new Object[0]);
    }
    
    public InvalidBlockStateException(final String lllllllllllllIIIIIllIIIIIlllIllI, final Object... lllllllllllllIIIIIllIIIIIlllIlIl) {
        super(lllllllllllllIIIIIllIIIIIlllIllI, lllllllllllllIIIIIllIIIIIlllIlIl);
    }
}
