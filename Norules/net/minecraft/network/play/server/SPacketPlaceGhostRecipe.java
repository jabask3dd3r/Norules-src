package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import net.minecraft.item.crafting.*;
import java.io.*;

public class SPacketPlaceGhostRecipe implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int field_194314_a;
    private /* synthetic */ IRecipe field_194315_b;
    
    public SPacketPlaceGhostRecipe(final int lllllllllllllIlIIIIIIIIllIlllllI, final IRecipe lllllllllllllIlIIIIIIIIllIllllIl) {
        this.field_194314_a = lllllllllllllIlIIIIIIIIllIlllllI;
        this.field_194315_b = lllllllllllllIlIIIIIIIIllIllllIl;
    }
    
    public SPacketPlaceGhostRecipe() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIIIIIIIllIlIIlII) {
        lllllllllllllIlIIIIIIIIllIlIIlII.func_194307_a(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIIIIIIIllIlIlIlI) throws IOException {
        lllllllllllllIlIIIIIIIIllIlIlIlI.writeByte(this.field_194314_a);
        lllllllllllllIlIIIIIIIIllIlIlIlI.writeVarIntToBuffer(CraftingManager.func_193375_a(this.field_194315_b));
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIIIIIIIllIlIlllI) throws IOException {
        this.field_194314_a = lllllllllllllIlIIIIIIIIllIlIlllI.readByte();
        this.field_194315_b = CraftingManager.func_193374_a(lllllllllllllIlIIIIIIIIllIlIlllI.readVarIntFromBuffer());
    }
    
    public IRecipe func_194311_a() {
        return this.field_194315_b;
    }
    
    public int func_194313_b() {
        return this.field_194314_a;
    }
}
