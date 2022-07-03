package net.minecraft.command;

import java.util.*;
import net.minecraft.server.*;
import net.minecraft.util.math.*;

public interface ICommand extends Comparable<ICommand>
{
    List<String> getCommandAliases();
    
    String getCommandName();
    
    boolean checkPermission(final MinecraftServer p0, final ICommandSender p1);
    
    List<String> getTabCompletionOptions(final MinecraftServer p0, final ICommandSender p1, final String[] p2, final BlockPos p3);
    
    void execute(final MinecraftServer p0, final ICommandSender p1, final String[] p2) throws CommandException;
    
    String getCommandUsage(final ICommandSender p0);
    
    boolean isUsernameIndex(final String[] p0, final int p1);
}
