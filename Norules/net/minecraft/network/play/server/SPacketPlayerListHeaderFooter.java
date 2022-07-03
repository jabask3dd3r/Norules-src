package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.text.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketPlayerListHeaderFooter implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ ITextComponent header;
    private /* synthetic */ ITextComponent footer;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIlIIIlIIllllIlIl) {
        lllllllllllllIlIIlIIIlIIllllIlIl.handlePlayerListHeaderFooter(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIlIIIlIlIIIIllII) throws IOException {
        this.header = lllllllllllllIlIIlIIIlIlIIIIllII.readTextComponent();
        this.footer = lllllllllllllIlIIlIIIlIlIIIIllII.readTextComponent();
    }
    
    public ITextComponent getHeader() {
        return this.header;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIlIIIlIlIIIIIIIl) throws IOException {
        lllllllllllllIlIIlIIIlIlIIIIIIIl.writeTextComponent(this.header);
        lllllllllllllIlIIlIIIlIlIIIIIIIl.writeTextComponent(this.footer);
    }
    
    public ITextComponent getFooter() {
        return this.footer;
    }
}
