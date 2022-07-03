package net.minecraft.command;

import net.minecraft.world.*;
import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.util.text.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.util.*;

public class CommandGameRule extends CommandBase
{
    public static void notifyGameRuleChange(final GameRules llllllllllllllIllllllllIlIlIllIl, final String llllllllllllllIllllllllIlIllIIIl, final MinecraftServer llllllllllllllIllllllllIlIllIIII) {
        if ("reducedDebugInfo".equals(llllllllllllllIllllllllIlIllIIIl)) {
            final byte llllllllllllllIllllllllIlIlIllll = (byte)(llllllllllllllIllllllllIlIlIllIl.getBoolean(llllllllllllllIllllllllIlIllIIIl) ? 22 : 23);
            for (final EntityPlayerMP llllllllllllllIllllllllIlIlIlllI : llllllllllllllIllllllllIlIllIIII.getPlayerList().getPlayerList()) {
                llllllllllllllIllllllllIlIlIlllI.connection.sendPacket(new SPacketEntityStatus(llllllllllllllIllllllllIlIlIlllI, llllllllllllllIllllllllIlIlIllll));
            }
        }
    }
    
    @Override
    public String getCommandName() {
        return "gamerule";
    }
    
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
    
    @Override
    public void execute(final MinecraftServer llllllllllllllIllllllllIllIlIIIl, final ICommandSender llllllllllllllIllllllllIlllIIIII, final String[] llllllllllllllIllllllllIllIIllIl) throws CommandException {
        final GameRules llllllllllllllIllllllllIllIlllII = this.getOverWorldGameRules(llllllllllllllIllllllllIllIlIIIl);
        final String llllllllllllllIllllllllIllIllIlI = (llllllllllllllIllllllllIllIIllIl.length > 0) ? llllllllllllllIllllllllIllIIllIl[0] : "";
        final String llllllllllllllIllllllllIllIlIlll = (llllllllllllllIllllllllIllIIllIl.length > 1) ? CommandBase.buildString(llllllllllllllIllllllllIllIIllIl, 1) : "";
        switch (llllllllllllllIllllllllIllIIllIl.length) {
            case 0: {
                llllllllllllllIllllllllIlllIIIII.addChatMessage(new TextComponentString(CommandBase.joinNiceString(llllllllllllllIllllllllIllIlllII.getRules())));
                break;
            }
            case 1: {
                if (!llllllllllllllIllllllllIllIlllII.hasRule(llllllllllllllIllllllllIllIllIlI)) {
                    throw new CommandException("commands.gamerule.norule", new Object[] { llllllllllllllIllllllllIllIllIlI });
                }
                final String llllllllllllllIllllllllIllIlIlIl = llllllllllllllIllllllllIllIlllII.getString(llllllllllllllIllllllllIllIllIlI);
                llllllllllllllIllllllllIlllIIIII.addChatMessage(new TextComponentString(llllllllllllllIllllllllIllIllIlI).appendText(" = ").appendText(llllllllllllllIllllllllIllIlIlIl));
                llllllllllllllIllllllllIlllIIIII.setCommandStat(CommandResultStats.Type.QUERY_RESULT, llllllllllllllIllllllllIllIlllII.getInt(llllllllllllllIllllllllIllIllIlI));
                break;
            }
            default: {
                if (llllllllllllllIllllllllIllIlllII.areSameType(llllllllllllllIllllllllIllIllIlI, GameRules.ValueType.BOOLEAN_VALUE) && !"true".equals(llllllllllllllIllllllllIllIlIlll) && !"false".equals(llllllllllllllIllllllllIllIlIlll)) {
                    throw new CommandException("commands.generic.boolean.invalid", new Object[] { llllllllllllllIllllllllIllIlIlll });
                }
                llllllllllllllIllllllllIllIlllII.setOrCreateGameRule(llllllllllllllIllllllllIllIllIlI, llllllllllllllIllllllllIllIlIlll);
                notifyGameRuleChange(llllllllllllllIllllllllIllIlllII, llllllllllllllIllllllllIllIllIlI, llllllllllllllIllllllllIllIlIIIl);
                CommandBase.notifyCommandListener(llllllllllllllIllllllllIlllIIIII, this, "commands.gamerule.success", llllllllllllllIllllllllIllIllIlI, llllllllllllllIllllllllIllIlIlll);
                break;
            }
        }
    }
    
    @Override
    public List<String> getTabCompletionOptions(final MinecraftServer llllllllllllllIllllllllIlIIllIIl, final ICommandSender llllllllllllllIllllllllIlIIllIII, final String[] llllllllllllllIllllllllIlIIIlllI, @Nullable final BlockPos llllllllllllllIllllllllIlIIlIlIl) {
        if (llllllllllllllIllllllllIlIIIlllI.length == 1) {
            return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllllllIlIIIlllI, this.getOverWorldGameRules(llllllllllllllIllllllllIlIIllIIl).getRules());
        }
        if (llllllllllllllIllllllllIlIIIlllI.length == 2) {
            final GameRules llllllllllllllIllllllllIlIIlIlII = this.getOverWorldGameRules(llllllllllllllIllllllllIlIIllIIl);
            if (llllllllllllllIllllllllIlIIlIlII.areSameType(llllllllllllllIllllllllIlIIIlllI[0], GameRules.ValueType.BOOLEAN_VALUE)) {
                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllllllIlIIIlllI, "true", "false");
            }
            if (llllllllllllllIllllllllIlIIlIlII.areSameType(llllllllllllllIllllllllIlIIIlllI[0], GameRules.ValueType.FUNCTION)) {
                return CommandBase.getListOfStringsMatchingLastWord(llllllllllllllIllllllllIlIIIlllI, llllllllllllllIllllllllIlIIllIIl.func_193030_aL().func_193066_d().keySet());
            }
        }
        return Collections.emptyList();
    }
    
    @Override
    public String getCommandUsage(final ICommandSender llllllllllllllIlllllllllIIIIllIl) {
        return "commands.gamerule.usage";
    }
    
    private GameRules getOverWorldGameRules(final MinecraftServer llllllllllllllIllllllllIlIIIIIII) {
        return llllllllllllllIllllllllIlIIIIIII.worldServerForDimension(0).getGameRules();
    }
}
