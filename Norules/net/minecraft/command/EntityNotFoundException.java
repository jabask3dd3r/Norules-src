package net.minecraft.command;

public class EntityNotFoundException extends CommandException
{
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public EntityNotFoundException(final String llllllllllllllIIlIIIIIlllIIllIIl, final Object... llllllllllllllIIlIIIIIlllIIllIll) {
        super(llllllllllllllIIlIIIIIlllIIllIIl, llllllllllllllIIlIIIIIlllIIllIll);
    }
    
    public EntityNotFoundException(final String llllllllllllllIIlIIIIIlllIlIIIll) {
        this("commands.generic.entity.notFound", new Object[] { llllllllllllllIIlIIIIIlllIlIIIll });
    }
}
