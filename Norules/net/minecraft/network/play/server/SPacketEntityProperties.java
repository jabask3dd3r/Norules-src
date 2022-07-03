package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import com.google.common.collect.*;
import net.minecraft.network.*;
import net.minecraft.entity.ai.attributes.*;
import java.util.*;
import java.io.*;

public class SPacketEntityProperties implements Packet<INetHandlerPlayClient>
{
    private final /* synthetic */ List<Snapshot> snapshots;
    private /* synthetic */ int entityId;
    
    public SPacketEntityProperties(final int lllllllllllllIlllIllIIIlIllIIIII, final Collection<IAttributeInstance> lllllllllllllIlllIllIIIlIlIlllll) {
        this.snapshots = (List<Snapshot>)Lists.newArrayList();
        this.entityId = lllllllllllllIlllIllIIIlIllIIIII;
        for (final IAttributeInstance lllllllllllllIlllIllIIIlIlIllllI : lllllllllllllIlllIllIIIlIlIlllll) {
            this.snapshots.add(new Snapshot(lllllllllllllIlllIllIIIlIlIllllI.getAttribute().getAttributeUnlocalizedName(), lllllllllllllIlllIllIIIlIlIllllI.getBaseValue(), lllllllllllllIlllIllIIIlIlIllllI.getModifiers()));
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlllIllIIIlIIlIIlII) {
        lllllllllllllIlllIllIIIlIIlIIlII.handleEntityProperties(this);
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlllIllIIIlIlIIIIII) throws IOException {
        this.entityId = lllllllllllllIlllIllIIIlIlIIIIII.readVarIntFromBuffer();
        for (int lllllllllllllIlllIllIIIlIlIIlIIl = lllllllllllllIlllIllIIIlIlIIIIII.readInt(), lllllllllllllIlllIllIIIlIlIIlIII = 0; lllllllllllllIlllIllIIIlIlIIlIII < lllllllllllllIlllIllIIIlIlIIlIIl; ++lllllllllllllIlllIllIIIlIlIIlIII) {
            final String lllllllllllllIlllIllIIIlIlIIIlll = lllllllllllllIlllIllIIIlIlIIIIII.readStringFromBuffer(64);
            final double lllllllllllllIlllIllIIIlIlIIIllI = lllllllllllllIlllIllIIIlIlIIIIII.readDouble();
            final List<AttributeModifier> lllllllllllllIlllIllIIIlIlIIIlIl = (List<AttributeModifier>)Lists.newArrayList();
            for (int lllllllllllllIlllIllIIIlIlIIIlII = lllllllllllllIlllIllIIIlIlIIIIII.readVarIntFromBuffer(), lllllllllllllIlllIllIIIlIlIIIIll = 0; lllllllllllllIlllIllIIIlIlIIIIll < lllllllllllllIlllIllIIIlIlIIIlII; ++lllllllllllllIlllIllIIIlIlIIIIll) {
                final UUID lllllllllllllIlllIllIIIlIlIIIIlI = lllllllllllllIlllIllIIIlIlIIIIII.readUuid();
                lllllllllllllIlllIllIIIlIlIIIlIl.add(new AttributeModifier(lllllllllllllIlllIllIIIlIlIIIIlI, "Unknown synced attribute modifier", lllllllllllllIlllIllIIIlIlIIIIII.readDouble(), lllllllllllllIlllIllIIIlIlIIIIII.readByte()));
            }
            this.snapshots.add(new Snapshot(lllllllllllllIlllIllIIIlIlIIIlll, lllllllllllllIlllIllIIIlIlIIIllI, lllllllllllllIlllIllIIIlIlIIIlIl));
        }
    }
    
    public SPacketEntityProperties() {
        this.snapshots = (List<Snapshot>)Lists.newArrayList();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlllIllIIIlIIllIIII) throws IOException {
        lllllllllllllIlllIllIIIlIIllIIII.writeVarIntToBuffer(this.entityId);
        lllllllllllllIlllIllIIIlIIllIIII.writeInt(this.snapshots.size());
        for (final Snapshot lllllllllllllIlllIllIIIlIIlIllll : this.snapshots) {
            lllllllllllllIlllIllIIIlIIllIIII.writeString(lllllllllllllIlllIllIIIlIIlIllll.getName());
            lllllllllllllIlllIllIIIlIIllIIII.writeDouble(lllllllllllllIlllIllIIIlIIlIllll.getBaseValue());
            lllllllllllllIlllIllIIIlIIllIIII.writeVarIntToBuffer(lllllllllllllIlllIllIIIlIIlIllll.getModifiers().size());
            for (final AttributeModifier lllllllllllllIlllIllIIIlIIlIlllI : lllllllllllllIlllIllIIIlIIlIllll.getModifiers()) {
                lllllllllllllIlllIllIIIlIIllIIII.writeUuid(lllllllllllllIlllIllIIIlIIlIlllI.getID());
                lllllllllllllIlllIllIIIlIIllIIII.writeDouble(lllllllllllllIlllIllIIIlIIlIlllI.getAmount());
                lllllllllllllIlllIllIIIlIIllIIII.writeByte(lllllllllllllIlllIllIIIlIIlIlllI.getOperation());
            }
        }
    }
    
    public List<Snapshot> getSnapshots() {
        return this.snapshots;
    }
    
    public class Snapshot
    {
        private final /* synthetic */ double baseValue;
        private final /* synthetic */ Collection<AttributeModifier> modifiers;
        private final /* synthetic */ String name;
        
        public String getName() {
            return this.name;
        }
        
        public Snapshot(final String lllllllllllllllIlIlIllIIlIIlIIlI, final double lllllllllllllllIlIlIllIIlIIlIllI, final Collection<AttributeModifier> lllllllllllllllIlIlIllIIlIIlIIII) {
            this.name = lllllllllllllllIlIlIllIIlIIlIIlI;
            this.baseValue = lllllllllllllllIlIlIllIIlIIlIllI;
            this.modifiers = lllllllllllllllIlIlIllIIlIIlIIII;
        }
        
        public Collection<AttributeModifier> getModifiers() {
            return this.modifiers;
        }
        
        public double getBaseValue() {
            return this.baseValue;
        }
    }
}
