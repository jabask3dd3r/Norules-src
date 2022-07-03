package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.text.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketChat implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ ChatType type;
    private /* synthetic */ ITextComponent chatComponent;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIIlIIIIIllIlllI) throws IOException {
        this.chatComponent = llllllllllllllIlIIIlIIIIIllIlllI.readTextComponent();
        this.type = ChatType.func_192582_a(llllllllllllllIlIIIlIIIIIllIlllI.readByte());
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIIlIIIIIllIlIlI) throws IOException {
        llllllllllllllIlIIIlIIIIIllIlIlI.writeTextComponent(this.chatComponent);
        llllllllllllllIlIIIlIIIIIllIlIlI.writeByte(this.type.func_192583_a());
    }
    
    public SPacketChat(final ITextComponent llllllllllllllIlIIIlIIIIIllllIlI, final ChatType llllllllllllllIlIIIlIIIIIlllIlII) {
        this.chatComponent = llllllllllllllIlIIIlIIIIIllllIlI;
        this.type = llllllllllllllIlIIIlIIIIIlllIlII;
    }
    
    public SPacketChat(final ITextComponent llllllllllllllIlIIIlIIIIlIIIIIll) {
        this(llllllllllllllIlIIIlIIIIlIIIIIll, ChatType.SYSTEM);
    }
    
    public ChatType func_192590_c() {
        return this.type;
    }
    
    public boolean isSystem() {
        return this.type == ChatType.SYSTEM || this.type == ChatType.GAME_INFO;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIIIlIIIIIllIIlII) {
        llllllllllllllIlIIIlIIIIIllIIlII.handleChat(this);
    }
    
    public SPacketChat() {
    }
    
    public ITextComponent getChatComponent() {
        return this.chatComponent;
    }
}
