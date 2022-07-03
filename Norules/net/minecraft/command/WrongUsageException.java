package net.minecraft.command;

public class WrongUsageException extends SyntaxErrorException
{
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public WrongUsageException(final String llllllllllllllllllIIllllllIlllIl, final Object... llllllllllllllllllIIllllllIlllII) {
        super(llllllllllllllllllIIllllllIlllIl, llllllllllllllllllIIllllllIlllII);
    }
}
