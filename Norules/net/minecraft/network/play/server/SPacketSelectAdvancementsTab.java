package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import javax.annotation.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketSelectAdvancementsTab implements Packet<INetHandlerPlayClient>
{
    @Nullable
    private /* synthetic */ ResourceLocation field_194155_a;
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIlIlIllIIIlllIIl) {
        llllllllllllllIlIlIlIllIIIlllIIl.func_194022_a(this);
    }
    
    @Nullable
    public ResourceLocation func_194154_a() {
        return this.field_194155_a;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIlIlIllIIIlIllIl) throws IOException {
        llllllllllllllIlIlIlIllIIIlIllIl.writeBoolean(this.field_194155_a != null);
        if (this.field_194155_a != null) {
            llllllllllllllIlIlIlIllIIIlIllIl.func_192572_a(this.field_194155_a);
        }
    }
    
    public SPacketSelectAdvancementsTab() {
    }
    
    public SPacketSelectAdvancementsTab(@Nullable final ResourceLocation llllllllllllllIlIlIlIllIIIllllll) {
        this.field_194155_a = llllllllllllllIlIlIlIllIIIllllll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIlIlIllIIIllIlIl) throws IOException {
        if (llllllllllllllIlIlIlIllIIIllIlIl.readBoolean()) {
            this.field_194155_a = llllllllllllllIlIlIlIllIIIllIlIl.func_192575_l();
        }
    }
}
