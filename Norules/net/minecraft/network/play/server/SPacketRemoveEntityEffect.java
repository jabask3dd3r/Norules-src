package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.potion.*;
import javax.annotation.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class SPacketRemoveEntityEffect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ Potion effectId;
    
    public SPacketRemoveEntityEffect() {
    }
    
    @Nullable
    public Potion getPotion() {
        return this.effectId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIlIllIIlIIlllllII) throws IOException {
        this.entityId = lllllllllllllIlIlIllIIlIIlllllII.readVarIntFromBuffer();
        this.effectId = Potion.getPotionById(lllllllllllllIlIlIllIIlIIlllllII.readUnsignedByte());
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIlIllIIlIIlllIlII) throws IOException {
        lllllllllllllIlIlIllIIlIIlllIlII.writeVarIntToBuffer(this.entityId);
        lllllllllllllIlIlIllIIlIIlllIlII.writeByte(Potion.getIdFromPotion(this.effectId));
    }
    
    @Nullable
    public Entity getEntity(final World lllllllllllllIlIlIllIIlIIllIlIII) {
        return lllllllllllllIlIlIllIIlIIllIlIII.getEntityByID(this.entityId);
    }
    
    public SPacketRemoveEntityEffect(final int lllllllllllllIlIlIllIIlIlIIIIlII, final Potion lllllllllllllIlIlIllIIlIlIIIIIII) {
        this.entityId = lllllllllllllIlIlIllIIlIlIIIIlII;
        this.effectId = lllllllllllllIlIlIllIIlIlIIIIIII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIlIllIIlIIllIlllI) {
        lllllllllllllIlIlIllIIlIIllIlllI.handleRemoveEntityEffect(this);
    }
}
