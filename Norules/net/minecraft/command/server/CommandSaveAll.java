package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.command.*;

public class CommandSaveAll extends CommandBase
{
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllIllIlIlIIlIIlllll) {
        return "commands.save.usage";
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllIllIlIlIIlIIIIIll, final ICommandSender lllllllllllllllIllIlIlIIlIIIIIlI, final String[] lllllllllllllllIllIlIlIIIlllllll, @Nullable final BlockPos lllllllllllllllIllIlIlIIlIIIIIII) {
        return (lllllllllllllllIllIlIlIIIlllllll.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllIllIlIlIIIlllllll, "flush") : Collections.emptyList();
    }
    
    @Override
    public String getCommandName() {
        return "save-all";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllIllIlIlIIlIIIlIll, final ICommandSender lllllllllllllllIllIlIlIIlIIlIlIl, final String[] lllllllllllllllIllIlIlIIlIIlIlII) throws CommandException {
        lllllllllllllllIllIlIlIIlIIlIlIl.addChatMessage(new TextComponentTranslation("commands.save.start", new Object[0]));
        if (lllllllllllllllIllIlIlIIlIIIlIll.getPlayerList() != null) {
            lllllllllllllllIllIlIlIIlIIIlIll.getPlayerList().saveAllPlayerData();
        }
        try {
            for (int lllllllllllllllIllIlIlIIlIIlIIll = 0; lllllllllllllllIllIlIlIIlIIlIIll < lllllllllllllllIllIlIlIIlIIIlIll.worldServers.length; ++lllllllllllllllIllIlIlIIlIIlIIll) {
                if (lllllllllllllllIllIlIlIIlIIIlIll.worldServers[lllllllllllllllIllIlIlIIlIIlIIll] != null) {
                    final WorldServer lllllllllllllllIllIlIlIIlIIlIIlI = lllllllllllllllIllIlIlIIlIIIlIll.worldServers[lllllllllllllllIllIlIlIIlIIlIIll];
                    final boolean lllllllllllllllIllIlIlIIlIIlIIIl = lllllllllllllllIllIlIlIIlIIlIIlI.disableLevelSaving;
                    lllllllllllllllIllIlIlIIlIIlIIlI.disableLevelSaving = false;
                    lllllllllllllllIllIlIlIIlIIlIIlI.saveAllChunks(true, null);
                    lllllllllllllllIllIlIlIIlIIlIIlI.disableLevelSaving = lllllllllllllllIllIlIlIIlIIlIIIl;
                }
            }
            if (lllllllllllllllIllIlIlIIlIIlIlII.length > 0 && "flush".equals(lllllllllllllllIllIlIlIIlIIlIlII[0])) {
                lllllllllllllllIllIlIlIIlIIlIlIl.addChatMessage(new TextComponentTranslation("commands.save.flushStart", new Object[0]));
                for (int lllllllllllllllIllIlIlIIlIIlIIII = 0; lllllllllllllllIllIlIlIIlIIlIIII < lllllllllllllllIllIlIlIIlIIIlIll.worldServers.length; ++lllllllllllllllIllIlIlIIlIIlIIII) {
                    if (lllllllllllllllIllIlIlIIlIIIlIll.worldServers[lllllllllllllllIllIlIlIIlIIlIIII] != null) {
                        final WorldServer lllllllllllllllIllIlIlIIlIIIllll = lllllllllllllllIllIlIlIIlIIIlIll.worldServers[lllllllllllllllIllIlIlIIlIIlIIII];
                        final boolean lllllllllllllllIllIlIlIIlIIIlllI = lllllllllllllllIllIlIlIIlIIIllll.disableLevelSaving;
                        lllllllllllllllIllIlIlIIlIIIllll.disableLevelSaving = false;
                        lllllllllllllllIllIlIlIIlIIIllll.saveChunkData();
                        lllllllllllllllIllIlIlIIlIIIllll.disableLevelSaving = lllllllllllllllIllIlIlIIlIIIlllI;
                    }
                }
                lllllllllllllllIllIlIlIIlIIlIlIl.addChatMessage(new TextComponentTranslation("commands.save.flushEnd", new Object[0]));
            }
        }
        catch (MinecraftException lllllllllllllllIllIlIlIIlIIIllIl) {
            CommandBase.notifyCommandListener(lllllllllllllllIllIlIlIIlIIlIlIl, this, "commands.save.failed", lllllllllllllllIllIlIlIIlIIIllIl.getMessage());
            return;
        }
        CommandBase.notifyCommandListener(lllllllllllllllIllIlIlIIlIIlIlIl, this, "commands.save.success", new Object[0]);
    }
}
