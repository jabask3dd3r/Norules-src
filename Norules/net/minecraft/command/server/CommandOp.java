package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.command.*;
import com.mojang.authlib.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public class CommandOp extends CommandBase
{
    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
    
    @Override
    public String getCommandName() {
        return "op";
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIIIlllIlIlIlIIlllI, final ICommandSender llllllllllllllIIIlllIlIlIlIIllIl, final String[] llllllllllllllIIIlllIlIlIlIlIIIl) throws CommandException {
        if (llllllllllllllIIIlllIlIlIlIlIIIl.length != 1 || llllllllllllllIIIlllIlIlIlIlIIIl[0].length() <= 0) {
            throw new WrongUsageException("commands.op.usage", new Object[0]);
        }
        final GameProfile llllllllllllllIIIlllIlIlIlIlIIII = llllllllllllllIIIlllIlIlIlIIlllI.getPlayerProfileCache().getGameProfileForUsername(llllllllllllllIIIlllIlIlIlIlIIIl[0]);
        if (llllllllllllllIIIlllIlIlIlIlIIII == null) {
            throw new CommandException("commands.op.failed", new Object[] { llllllllllllllIIIlllIlIlIlIlIIIl[0] });
        }
        llllllllllllllIIIlllIlIlIlIIlllI.getPlayerList().addOp(llllllllllllllIIIlllIlIlIlIlIIII);
        CommandBase.notifyCommandListener(llllllllllllllIIIlllIlIlIlIIllIl, this, "commands.op.success", llllllllllllllIIIlllIlIlIlIlIIIl[0]);
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIIIlllIlIlIIlllIlI, final ICommandSender llllllllllllllIIIlllIlIlIlIIIIII, final String[] llllllllllllllIIIlllIlIlIIlllIIl, @Nullable final BlockPos llllllllllllllIIIlllIlIlIIlllllI) {
        if (llllllllllllllIIIlllIlIlIIlllIIl.length == 1) {
            final String llllllllllllllIIIlllIlIlIIllllIl = llllllllllllllIIIlllIlIlIIlllIIl[llllllllllllllIIIlllIlIlIIlllIIl.length - 1];
            final List<String> llllllllllllllIIIlllIlIlIIllllII = (List<String>)Lists.newArrayList();
            final String llllllllllllllIIIlllIlIlIIllIIll;
            final double llllllllllllllIIIlllIlIlIIllIlII = ((GameProfile[])(Object)(llllllllllllllIIIlllIlIlIIllIIll = (String)(Object)llllllllllllllIIIlllIlIlIIlllIlI.getGameProfiles())).length;
            for (long llllllllllllllIIIlllIlIlIIllIlIl = 0; llllllllllllllIIIlllIlIlIIllIlIl < llllllllllllllIIIlllIlIlIIllIlII; ++llllllllllllllIIIlllIlIlIIllIlIl) {
                final GameProfile llllllllllllllIIIlllIlIlIIlllIll = llllllllllllllIIIlllIlIlIIllIIll[llllllllllllllIIIlllIlIlIIllIlIl];
                if (!llllllllllllllIIIlllIlIlIIlllIlI.getPlayerList().canSendCommands(llllllllllllllIIIlllIlIlIIlllIll) && CommandBase.doesStringStartWith(llllllllllllllIIIlllIlIlIIllllIl, llllllllllllllIIIlllIlIlIIlllIll.getName())) {
                    llllllllllllllIIIlllIlIlIIllllII.add(llllllllllllllIIIlllIlIlIIlllIll.getName());
                }
            }
            return llllllllllllllIIIlllIlIlIIllllII;
        }
        return Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIIIlllIlIlIlIllIlI) {
        return "commands.op.usage";
    }
}
