package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import javax.annotation.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.advancements.*;

public class CPacketSeenAdvancements implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ Action field_194166_a;
    private /* synthetic */ ResourceLocation field_194167_b;
    
    public CPacketSeenAdvancements(final Action lllllllllllllIlIIlIIIIlIlIIlIlIl, @Nullable final ResourceLocation lllllllllllllIlIIlIIIIlIlIIlIlll) {
        this.field_194166_a = lllllllllllllIlIIlIIIIlIlIIlIlIl;
        this.field_194167_b = lllllllllllllIlIIlIIIIlIlIIlIlll;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIlIIIIlIlIIIIlIl) throws IOException {
        lllllllllllllIlIIlIIIIlIlIIIIlIl.writeEnumValue(this.field_194166_a);
        if (this.field_194166_a == Action.OPENED_TAB) {
            lllllllllllllIlIIlIIIIlIlIIIIlIl.func_192572_a(this.field_194167_b);
        }
    }
    
    public static CPacketSeenAdvancements func_194164_a() {
        return new CPacketSeenAdvancements(Action.CLOSED_SCREEN, null);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIlIIIIlIlIIIlIll) throws IOException {
        this.field_194166_a = lllllllllllllIlIIlIIIIlIlIIIlIll.readEnumValue(Action.class);
        if (this.field_194166_a == Action.OPENED_TAB) {
            this.field_194167_b = lllllllllllllIlIIlIIIIlIlIIIlIll.func_192575_l();
        }
    }
    
    public Action func_194162_b() {
        return this.field_194166_a;
    }
    
    public ResourceLocation func_194165_c() {
        return this.field_194167_b;
    }
    
    public static CPacketSeenAdvancements func_194163_a(final Advancement lllllllllllllIlIIlIIIIlIlIIlIIIl) {
        return new CPacketSeenAdvancements(Action.OPENED_TAB, lllllllllllllIlIIlIIIIlIlIIlIIIl.func_192067_g());
    }
    
    public CPacketSeenAdvancements() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIlIIlIIIIlIIlllllll) {
        lllllllllllllIlIIlIIIIlIIlllllll.func_194027_a(this);
    }
    
    public enum Action
    {
        CLOSED_SCREEN("CLOSED_SCREEN", 1), 
        OPENED_TAB("OPENED_TAB", 0);
        
        private Action(final String lllllllllllllIlIIIlllllllIIIllII, final int lllllllllllllIlIIIlllllllIIIlIll) {
        }
    }
}
