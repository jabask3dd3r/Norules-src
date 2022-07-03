package net.minecraft.command;

public class NumberInvalidException extends CommandException
{
    public NumberInvalidException() {
        this("commands.generic.num.invalid", new Object[0]);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public NumberInvalidException(final String lllllllllllllllIllIlIlIlIIlIllIl, final Object... lllllllllllllllIllIlIlIlIIlIllll) {
        super(lllllllllllllllIllIlIlIlIIlIllIl, lllllllllllllllIllIlIlIlIIlIllll);
    }
}
