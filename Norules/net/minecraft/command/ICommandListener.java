package net.minecraft.command;

public interface ICommandListener
{
    void notifyListener(final ICommandSender p0, final ICommand p1, final int p2, final String p3, final Object... p4);
}
