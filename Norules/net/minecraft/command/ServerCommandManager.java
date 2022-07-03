package net.minecraft.command;

import net.minecraft.server.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.rcon.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.text.*;
import net.minecraft.command.server.*;

public class ServerCommandManager extends CommandHandler implements ICommandListener
{
    private final /* synthetic */ MinecraftServer server;
    
    @Override
    public void notifyListener(final ICommandSender lIIIIlIlllIIlII, final ICommand lIIIIlIllllIIII, final int lIIIIlIlllIIIlI, final String lIIIIlIlllIIIIl, final Object... lIIIIlIlllIIIII) {
        boolean lIIIIlIlllIllII = true;
        final MinecraftServer lIIIIlIlllIlIll = this.server;
        if (!lIIIIlIlllIIlII.sendCommandFeedback()) {
            lIIIIlIlllIllII = false;
        }
        final ITextComponent lIIIIlIlllIlIlI = new TextComponentTranslation("chat.type.admin", new Object[] { lIIIIlIlllIIlII.getName(), new TextComponentTranslation(lIIIIlIlllIIIIl, lIIIIlIlllIIIII) });
        lIIIIlIlllIlIlI.getStyle().setColor(TextFormatting.GRAY);
        lIIIIlIlllIlIlI.getStyle().setItalic(true);
        if (lIIIIlIlllIllII) {
            for (final EntityPlayer lIIIIlIlllIlIIl : lIIIIlIlllIlIll.getPlayerList().getPlayerList()) {
                if (lIIIIlIlllIlIIl != lIIIIlIlllIIlII && lIIIIlIlllIlIll.getPlayerList().canSendCommands(lIIIIlIlllIlIIl.getGameProfile()) && lIIIIlIllllIIII.checkPermission(this.server, lIIIIlIlllIIlII)) {
                    final boolean lIIIIlIlllIlIII = lIIIIlIlllIIlII instanceof MinecraftServer && this.server.shouldBroadcastConsoleToOps();
                    final boolean lIIIIlIlllIIlll = lIIIIlIlllIIlII instanceof RConConsoleSource && this.server.shouldBroadcastRconToOps();
                    if (!lIIIIlIlllIlIII && !lIIIIlIlllIIlll && (lIIIIlIlllIIlII instanceof RConConsoleSource || lIIIIlIlllIIlII instanceof MinecraftServer)) {
                        continue;
                    }
                    lIIIIlIlllIlIIl.addChatMessage(lIIIIlIlllIlIlI);
                }
            }
        }
        if (lIIIIlIlllIIlII != lIIIIlIlllIlIll && lIIIIlIlllIlIll.worldServers[0].getGameRules().getBoolean("logAdminCommands")) {
            lIIIIlIlllIlIll.addChatMessage(lIIIIlIlllIlIlI);
        }
        boolean lIIIIlIlllIIllI = lIIIIlIlllIlIll.worldServers[0].getGameRules().getBoolean("sendCommandFeedback");
        if (lIIIIlIlllIIlII instanceof CommandBlockBaseLogic) {
            lIIIIlIlllIIllI = ((CommandBlockBaseLogic)lIIIIlIlllIIlII).shouldTrackOutput();
        }
        if (((lIIIIlIlllIIIlI & 0x1) != 0x1 && lIIIIlIlllIIllI) || lIIIIlIlllIIlII instanceof MinecraftServer) {
            lIIIIlIlllIIlII.addChatMessage(new TextComponentTranslation(lIIIIlIlllIIIIl, lIIIIlIlllIIIII));
        }
    }
    
    @Override
    protected MinecraftServer getServer() {
        return this.server;
    }
    
    public ServerCommandManager(final MinecraftServer lIIIIllIIIIIIII) {
        this.server = lIIIIllIIIIIIII;
        this.registerCommand(new CommandTime());
        this.registerCommand(new CommandGameMode());
        this.registerCommand(new CommandDifficulty());
        this.registerCommand(new CommandDefaultGameMode());
        this.registerCommand(new CommandKill());
        this.registerCommand(new CommandToggleDownfall());
        this.registerCommand(new CommandWeather());
        this.registerCommand(new CommandXP());
        this.registerCommand(new CommandTP());
        this.registerCommand(new CommandTeleport());
        this.registerCommand(new CommandGive());
        this.registerCommand(new CommandReplaceItem());
        this.registerCommand(new CommandStats());
        this.registerCommand(new CommandEffect());
        this.registerCommand(new CommandEnchant());
        this.registerCommand(new CommandParticle());
        this.registerCommand(new CommandEmote());
        this.registerCommand(new CommandShowSeed());
        this.registerCommand(new CommandHelp());
        this.registerCommand(new CommandDebug());
        this.registerCommand(new CommandMessage());
        this.registerCommand(new CommandBroadcast());
        this.registerCommand(new CommandSetSpawnpoint());
        this.registerCommand(new CommandSetDefaultSpawnpoint());
        this.registerCommand(new CommandGameRule());
        this.registerCommand(new CommandClearInventory());
        this.registerCommand(new CommandTestFor());
        this.registerCommand(new CommandSpreadPlayers());
        this.registerCommand(new CommandPlaySound());
        this.registerCommand(new CommandScoreboard());
        this.registerCommand(new CommandExecuteAt());
        this.registerCommand(new CommandTrigger());
        this.registerCommand(new AdvancementCommand());
        this.registerCommand(new RecipeCommand());
        this.registerCommand(new CommandSummon());
        this.registerCommand(new CommandSetBlock());
        this.registerCommand(new CommandFill());
        this.registerCommand(new CommandClone());
        this.registerCommand(new CommandCompare());
        this.registerCommand(new CommandBlockData());
        this.registerCommand(new CommandTestForBlock());
        this.registerCommand(new CommandMessageRaw());
        this.registerCommand(new CommandWorldBorder());
        this.registerCommand(new CommandTitle());
        this.registerCommand(new CommandEntityData());
        this.registerCommand(new CommandStopSound());
        this.registerCommand(new CommandLocate());
        this.registerCommand(new CommandReload());
        this.registerCommand(new CommandFunction());
        if (lIIIIllIIIIIIII.isDedicatedServer()) {
            this.registerCommand(new CommandOp());
            this.registerCommand(new CommandDeOp());
            this.registerCommand(new CommandStop());
            this.registerCommand(new CommandSaveAll());
            this.registerCommand(new CommandSaveOff());
            this.registerCommand(new CommandSaveOn());
            this.registerCommand(new CommandBanIp());
            this.registerCommand(new CommandPardonIp());
            this.registerCommand(new CommandBanPlayer());
            this.registerCommand(new CommandListBans());
            this.registerCommand(new CommandPardonPlayer());
            this.registerCommand(new CommandServerKick());
            this.registerCommand(new CommandListPlayers());
            this.registerCommand(new CommandWhitelist());
            this.registerCommand(new CommandSetPlayerTimeout());
        }
        else {
            this.registerCommand(new CommandPublishLocalServer());
        }
        CommandBase.setCommandListener(this);
    }
}
