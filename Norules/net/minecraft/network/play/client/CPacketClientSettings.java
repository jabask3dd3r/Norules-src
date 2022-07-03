package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketClientSettings implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ String lang;
    private /* synthetic */ EntityPlayer.EnumChatVisibility chatVisibility;
    private /* synthetic */ EnumHandSide mainHand;
    private /* synthetic */ int modelPartFlags;
    private /* synthetic */ int view;
    private /* synthetic */ boolean enableColors;
    
    public CPacketClientSettings(final String lllllllllllllIIIIlllllllIIlIIIlI, final int lllllllllllllIIIIlllllllIIlIIIIl, final EntityPlayer.EnumChatVisibility lllllllllllllIIIIlllllllIIlIIIII, final boolean lllllllllllllIIIIlllllllIIlIIllI, final int lllllllllllllIIIIlllllllIIlIIlIl, final EnumHandSide lllllllllllllIIIIlllllllIIlIIlII) {
        this.lang = lllllllllllllIIIIlllllllIIlIIIlI;
        this.view = lllllllllllllIIIIlllllllIIlIIIIl;
        this.chatVisibility = lllllllllllllIIIIlllllllIIlIIIII;
        this.enableColors = lllllllllllllIIIIlllllllIIlIIllI;
        this.modelPartFlags = lllllllllllllIIIIlllllllIIlIIlIl;
        this.mainHand = lllllllllllllIIIIlllllllIIlIIlII;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIIlllllllIIIlIlll) throws IOException {
        this.lang = lllllllllllllIIIIlllllllIIIlIlll.readStringFromBuffer(16);
        this.view = lllllllllllllIIIIlllllllIIIlIlll.readByte();
        this.chatVisibility = lllllllllllllIIIIlllllllIIIlIlll.readEnumValue(EntityPlayer.EnumChatVisibility.class);
        this.enableColors = lllllllllllllIIIIlllllllIIIlIlll.readBoolean();
        this.modelPartFlags = lllllllllllllIIIIlllllllIIIlIlll.readUnsignedByte();
        this.mainHand = lllllllllllllIIIIlllllllIIIlIlll.readEnumValue(EnumHandSide.class);
    }
    
    public EntityPlayer.EnumChatVisibility getChatVisibility() {
        return this.chatVisibility;
    }
    
    public boolean isColorsEnabled() {
        return this.enableColors;
    }
    
    public EnumHandSide getMainHand() {
        return this.mainHand;
    }
    
    public CPacketClientSettings() {
    }
    
    public int getModelPartFlags() {
        return this.modelPartFlags;
    }
    
    public String getLang() {
        return this.lang;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIIlllllllIIIlIIIl) throws IOException {
        lllllllllllllIIIIlllllllIIIlIIIl.writeString(this.lang);
        lllllllllllllIIIIlllllllIIIlIIIl.writeByte(this.view);
        lllllllllllllIIIIlllllllIIIlIIIl.writeEnumValue(this.chatVisibility);
        lllllllllllllIIIIlllllllIIIlIIIl.writeBoolean(this.enableColors);
        lllllllllllllIIIIlllllllIIIlIIIl.writeByte(this.modelPartFlags);
        lllllllllllllIIIIlllllllIIIlIIIl.writeEnumValue(this.mainHand);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIIIIlllllllIIIIllIl) {
        lllllllllllllIIIIlllllllIIIIllIl.processClientSettings(this);
    }
}
