package net.minecraft.command.server;

import net.minecraft.server.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.*;
import com.google.gson.*;
import net.minecraft.entity.player.*;
import net.minecraft.command.*;

public class CommandMessageRaw extends CommandBase
{
    @Override
    public boolean isUsernameIndex(final String[] lllllllllllllllllllIlllIllIlIIII, final int lllllllllllllllllllIlllIllIIllll) {
        return lllllllllllllllllllIlllIllIIllll == 0;
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer lllllllllllllllllllIlllIllIllIII, final ICommandSender lllllllllllllllllllIlllIllIlIlll, final String[] lllllllllllllllllllIlllIllIlIllI, @Nullable final BlockPos lllllllllllllllllllIlllIllIlIlIl) {
        return (lllllllllllllllllllIlllIllIlIllI.length == 1) ? CommandBase.getListOfStringsMatchingLastWord(lllllllllllllllllllIlllIllIlIllI, lllllllllllllllllllIlllIllIllIII.getAllUsernames()) : Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender lllllllllllllllllllIlllIllllIIII) {
        return "commands.tellraw.usage";
    }
    
    @Override
    public String getCommandName() {
        return "tellraw";
    }
    
    @Override
    public void execute(final MinecraftServer lllllllllllllllllllIlllIlllIlIII, final ICommandSender lllllllllllllllllllIlllIlllIIlll, final String[] lllllllllllllllllllIlllIllIlllll) throws CommandException {
        if (lllllllllllllllllllIlllIllIlllll.length < 2) {
            throw new WrongUsageException("commands.tellraw.usage", new Object[0]);
        }
        final EntityPlayer lllllllllllllllllllIlllIlllIIlIl = CommandBase.getPlayer(lllllllllllllllllllIlllIlllIlIII, lllllllllllllllllllIlllIlllIIlll, lllllllllllllllllllIlllIllIlllll[0]);
        final String lllllllllllllllllllIlllIlllIIlII = CommandBase.buildString(lllllllllllllllllllIlllIllIlllll, 1);
        try {
            final ITextComponent lllllllllllllllllllIlllIlllIIIll = ITextComponent.Serializer.jsonToComponent(lllllllllllllllllllIlllIlllIIlII);
            lllllllllllllllllllIlllIlllIIlIl.addChatMessage(TextComponentUtils.processComponent(lllllllllllllllllllIlllIlllIIlll, lllllllllllllllllllIlllIlllIIIll, lllllllllllllllllllIlllIlllIIlIl));
        }
        catch (JsonParseException lllllllllllllllllllIlllIlllIIIlI) {
            throw CommandBase.toSyntaxException(lllllllllllllllllllIlllIlllIIIlI);
        }
    }
}
