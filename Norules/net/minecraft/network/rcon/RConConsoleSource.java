package net.minecraft.network.rcon;

import net.minecraft.command.*;
import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

public class RConConsoleSource implements ICommandSender
{
    private final /* synthetic */ MinecraftServer server;
    private final /* synthetic */ StringBuffer buffer;
    
    @Override
    public boolean sendCommandFeedback() {
        return true;
    }
    
    @Override
    public MinecraftServer getServer() {
        return this.server;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllllIIllllIlllIIIlllIII, final String lllllllllllllIIllllIlllIIIllIlll) {
        return true;
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllllIIllllIlllIIIllllII) {
        this.buffer.append(lllllllllllllIIllllIlllIIIllllII.getUnformattedText());
    }
    
    @Override
    public String getName() {
        return "Rcon";
    }
    
    public RConConsoleSource(final MinecraftServer lllllllllllllIIllllIlllIIlIIIIIl) {
        this.buffer = new StringBuffer();
        this.server = lllllllllllllIIllllIlllIIlIIIIIl;
    }
    
    @Override
    public World getEntityWorld() {
        return this.server.getEntityWorld();
    }
}
