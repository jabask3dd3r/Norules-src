package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.item.crafting.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketPlaceRecipe implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ IRecipe field_194321_b;
    private /* synthetic */ boolean field_194322_c;
    private /* synthetic */ int field_194320_a;
    
    public boolean func_194319_c() {
        return this.field_194322_c;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIIIIlllllIIlIIIIIIl) {
        lllllllllllllIIIIlllllIIlIIIIIIl.func_194308_a(this);
    }
    
    public CPacketPlaceRecipe() {
    }
    
    public int func_194318_a() {
        return this.field_194320_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIIlllllIIlIIIllIl) throws IOException {
        this.field_194320_a = lllllllllllllIIIIlllllIIlIIIllIl.readByte();
        this.field_194321_b = CraftingManager.func_193374_a(lllllllllllllIIIIlllllIIlIIIllIl.readVarIntFromBuffer());
        this.field_194322_c = lllllllllllllIIIIlllllIIlIIIllIl.readBoolean();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIIlllllIIlIIIIlIl) throws IOException {
        lllllllllllllIIIIlllllIIlIIIIlIl.writeByte(this.field_194320_a);
        lllllllllllllIIIIlllllIIlIIIIlIl.writeVarIntToBuffer(CraftingManager.func_193375_a(this.field_194321_b));
        lllllllllllllIIIIlllllIIlIIIIlIl.writeBoolean(this.field_194322_c);
    }
    
    public IRecipe func_194317_b() {
        return this.field_194321_b;
    }
    
    public CPacketPlaceRecipe(final int lllllllllllllIIIIlllllIIlIIlIlll, final IRecipe lllllllllllllIIIIlllllIIlIIlIIlI, final boolean lllllllllllllIIIIlllllIIlIIlIlIl) {
        this.field_194320_a = lllllllllllllIIIIlllllIIlIIlIlll;
        this.field_194321_b = lllllllllllllIIIIlllllIIlIIlIIlI;
        this.field_194322_c = lllllllllllllIIIIlllllIIlIIlIlIl;
    }
}
