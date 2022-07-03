package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.item.crafting.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketRecipeInfo implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ IRecipe field_193649_d;
    private /* synthetic */ boolean field_192631_e;
    private /* synthetic */ Purpose field_194157_a;
    private /* synthetic */ boolean field_192632_f;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllIIIIIIIlIlllIIl) throws IOException {
        llllllllllllllIllIIIIIIIlIlllIIl.writeEnumValue(this.field_194157_a);
        if (this.field_194157_a == Purpose.SHOWN) {
            llllllllllllllIllIIIIIIIlIlllIIl.writeInt(CraftingManager.func_193375_a(this.field_193649_d));
        }
        else if (this.field_194157_a == Purpose.SETTINGS) {
            llllllllllllllIllIIIIIIIlIlllIIl.writeBoolean(this.field_192631_e);
            llllllllllllllIllIIIIIIIlIlllIIl.writeBoolean(this.field_192632_f);
        }
    }
    
    public boolean func_192625_d() {
        return this.field_192632_f;
    }
    
    public CPacketRecipeInfo(final IRecipe llllllllllllllIllIIIIIIIllIIlllI) {
        this.field_194157_a = Purpose.SHOWN;
        this.field_193649_d = llllllllllllllIllIIIIIIIllIIlllI;
    }
    
    public Purpose func_194156_a() {
        return this.field_194157_a;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIllIIIIIIIlIllIIll) {
        llllllllllllllIllIIIIIIIlIllIIll.func_191984_a(this);
    }
    
    public boolean func_192624_c() {
        return this.field_192631_e;
    }
    
    public CPacketRecipeInfo(final boolean llllllllllllllIllIIIIIIIllIIIllI, final boolean llllllllllllllIllIIIIIIIllIIlIII) {
        this.field_194157_a = Purpose.SETTINGS;
        this.field_192631_e = llllllllllllllIllIIIIIIIllIIIllI;
        this.field_192632_f = llllllllllllllIllIIIIIIIllIIlIII;
    }
    
    public IRecipe func_193648_b() {
        return this.field_193649_d;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllIIIIIIIlIllllll) throws IOException {
        this.field_194157_a = llllllllllllllIllIIIIIIIlIllllll.readEnumValue(Purpose.class);
        if (this.field_194157_a == Purpose.SHOWN) {
            this.field_193649_d = CraftingManager.func_193374_a(llllllllllllllIllIIIIIIIlIllllll.readInt());
        }
        else if (this.field_194157_a == Purpose.SETTINGS) {
            this.field_192631_e = llllllllllllllIllIIIIIIIlIllllll.readBoolean();
            this.field_192632_f = llllllllllllllIllIIIIIIIlIllllll.readBoolean();
        }
    }
    
    public CPacketRecipeInfo() {
    }
    
    public enum Purpose
    {
        SHOWN("SHOWN", 0), 
        SETTINGS("SETTINGS", 1);
        
        private Purpose(final String lllllllllllllIIllIIllIlIllllIllI, final int lllllllllllllIIllIIllIlIllllIlIl) {
        }
    }
}
