package net.minecraft.command;

public class SyntaxErrorException extends CommandException
{
    public SyntaxErrorException(final String lllllllllllllllIIllIlllllllIlIlI, final Object... lllllllllllllllIIllIlllllllIlIIl) {
        super(lllllllllllllllIIllIlllllllIlIlI, lllllllllllllllIIllIlllllllIlIIl);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public SyntaxErrorException() {
        this("commands.generic.snytax", new Object[0]);
    }
}
