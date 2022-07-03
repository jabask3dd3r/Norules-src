package net.minecraft.command;

public class CommandNotFoundException extends CommandException
{
    public CommandNotFoundException() {
        this("commands.generic.notFound", new Object[0]);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public CommandNotFoundException(final String llllllllllllIlllllIlIllllIlIIllI, final Object... llllllllllllIlllllIlIllllIlIIlIl) {
        super(llllllllllllIlllllIlIllllIlIIllI, llllllllllllIlllllIlIllllIlIIlIl);
    }
}
