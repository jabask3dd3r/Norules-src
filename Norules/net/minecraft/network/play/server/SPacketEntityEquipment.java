package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketEntityEquipment implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityID;
    private /* synthetic */ EntityEquipmentSlot equipmentSlot;
    private /* synthetic */ ItemStack itemStack;
    
    public ItemStack getItemStack() {
        return this.itemStack;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIllllIlllIIlIIII) {
        lllllllllllllllIIllllIlllIIlIIII.handleEntityEquipment(this);
    }
    
    public int getEntityID() {
        return this.entityID;
    }
    
    public SPacketEntityEquipment(final int lllllllllllllllIIllllIlllIlIIllI, final EntityEquipmentSlot lllllllllllllllIIllllIlllIlIIlIl, final ItemStack lllllllllllllllIIllllIlllIlIIIII) {
        this.itemStack = ItemStack.field_190927_a;
        this.entityID = lllllllllllllllIIllllIlllIlIIllI;
        this.equipmentSlot = lllllllllllllllIIllllIlllIlIIlIl;
        this.itemStack = lllllllllllllllIIllllIlllIlIIIII.copy();
    }
    
    public EntityEquipmentSlot getEquipmentSlot() {
        return this.equipmentSlot;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIllllIlllIIllIlI) throws IOException {
        this.entityID = lllllllllllllllIIllllIlllIIllIlI.readVarIntFromBuffer();
        this.equipmentSlot = lllllllllllllllIIllllIlllIIllIlI.readEnumValue(EntityEquipmentSlot.class);
        this.itemStack = lllllllllllllllIIllllIlllIIllIlI.readItemStackFromBuffer();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIllllIlllIIlIlII) throws IOException {
        lllllllllllllllIIllllIlllIIlIlII.writeVarIntToBuffer(this.entityID);
        lllllllllllllllIIllllIlllIIlIlII.writeEnumValue(this.equipmentSlot);
        lllllllllllllllIIllllIlllIIlIlII.writeItemStackToBuffer(this.itemStack);
    }
    
    public SPacketEntityEquipment() {
        this.itemStack = ItemStack.field_190927_a;
    }
}
