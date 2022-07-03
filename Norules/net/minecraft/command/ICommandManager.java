package net.minecraft.command;

import net.minecraft.util.math.*;
import java.util.*;

public interface ICommandManager
{
    Map<String, ICommand> getCommands();
    
    List<String> getTabCompletionOptions(final ICommandSender p0, final String p1, final BlockPos p2);
    
    int executeCommand(final ICommandSender p0, final String p1);
    
    List<ICommand> getPossibleCommands(final ICommandSender p0);
}
