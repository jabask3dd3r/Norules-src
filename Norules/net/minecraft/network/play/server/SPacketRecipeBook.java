package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.item.crafting.*;
import java.io.*;
import net.minecraft.network.*;
import com.google.common.collect.*;

public class SPacketRecipeBook implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ List<IRecipe> field_193647_c;
    private /* synthetic */ boolean field_192599_d;
    private /* synthetic */ boolean field_192598_c;
    private /* synthetic */ State field_193646_a;
    private /* synthetic */ List<IRecipe> field_192596_a;
    
    public List<IRecipe> func_192595_a() {
        return this.field_192596_a;
    }
    
    public State func_194151_e() {
        return this.field_193646_a;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIllllllIIIIlIIlIlllI) {
        llllllllllllIllllllIIIIlIIlIlllI.func_191980_a(this);
    }
    
    public boolean func_192594_d() {
        return this.field_192599_d;
    }
    
    public boolean func_192593_c() {
        return this.field_192598_c;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIllllllIIIIlIIIllIIl) throws IOException {
        llllllllllllIllllllIIIIlIIIllIIl.writeEnumValue(this.field_193646_a);
        llllllllllllIllllllIIIIlIIIllIIl.writeBoolean(this.field_192598_c);
        llllllllllllIllllllIIIIlIIIllIIl.writeBoolean(this.field_192599_d);
        llllllllllllIllllllIIIIlIIIllIIl.writeVarIntToBuffer(this.field_192596_a.size());
        for (final IRecipe llllllllllllIllllllIIIIlIIIllIII : this.field_192596_a) {
            llllllllllllIllllllIIIIlIIIllIIl.writeVarIntToBuffer(CraftingManager.func_193375_a(llllllllllllIllllllIIIIlIIIllIII));
        }
        if (this.field_193646_a == State.INIT) {
            llllllllllllIllllllIIIIlIIIllIIl.writeVarIntToBuffer(this.field_193647_c.size());
            for (final IRecipe llllllllllllIllllllIIIIlIIIlIlll : this.field_193647_c) {
                llllllllllllIllllllIIIIlIIIllIIl.writeVarIntToBuffer(CraftingManager.func_193375_a(llllllllllllIllllllIIIIlIIIlIlll));
            }
        }
    }
    
    public SPacketRecipeBook() {
    }
    
    public List<IRecipe> func_193644_b() {
        return this.field_193647_c;
    }
    
    public SPacketRecipeBook(final State llllllllllllIllllllIIIIlIIllIllI, final List<IRecipe> llllllllllllIllllllIIIIlIIlllIll, final List<IRecipe> llllllllllllIllllllIIIIlIIllIlII, final boolean llllllllllllIllllllIIIIlIIlllIIl, final boolean llllllllllllIllllllIIIIlIIlllIII) {
        this.field_193646_a = llllllllllllIllllllIIIIlIIllIllI;
        this.field_192596_a = llllllllllllIllllllIIIIlIIlllIll;
        this.field_193647_c = llllllllllllIllllllIIIIlIIllIlII;
        this.field_192598_c = llllllllllllIllllllIIIIlIIlllIIl;
        this.field_192599_d = llllllllllllIllllllIIIIlIIlllIII;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIllllllIIIIlIIlIIIIl) throws IOException {
        this.field_193646_a = llllllllllllIllllllIIIIlIIlIIIIl.readEnumValue(State.class);
        this.field_192598_c = llllllllllllIllllllIIIIlIIlIIIIl.readBoolean();
        this.field_192599_d = llllllllllllIllllllIIIIlIIlIIIIl.readBoolean();
        int llllllllllllIllllllIIIIlIIlIIlIl = llllllllllllIllllllIIIIlIIlIIIIl.readVarIntFromBuffer();
        this.field_192596_a = (List<IRecipe>)Lists.newArrayList();
        for (int llllllllllllIllllllIIIIlIIlIIlII = 0; llllllllllllIllllllIIIIlIIlIIlII < llllllllllllIllllllIIIIlIIlIIlIl; ++llllllllllllIllllllIIIIlIIlIIlII) {
            this.field_192596_a.add(CraftingManager.func_193374_a(llllllllllllIllllllIIIIlIIlIIIIl.readVarIntFromBuffer()));
        }
        if (this.field_193646_a == State.INIT) {
            llllllllllllIllllllIIIIlIIlIIlIl = llllllllllllIllllllIIIIlIIlIIIIl.readVarIntFromBuffer();
            this.field_193647_c = (List<IRecipe>)Lists.newArrayList();
            for (int llllllllllllIllllllIIIIlIIlIIIll = 0; llllllllllllIllllllIIIIlIIlIIIll < llllllllllllIllllllIIIIlIIlIIlIl; ++llllllllllllIllllllIIIIlIIlIIIll) {
                this.field_193647_c.add(CraftingManager.func_193374_a(llllllllllllIllllllIIIIlIIlIIIIl.readVarIntFromBuffer()));
            }
        }
    }
    
    public enum State
    {
        REMOVE("REMOVE", 2), 
        ADD("ADD", 1), 
        INIT("INIT", 0);
        
        private State(final String lllllllllllllIIIIllIIlIlllllIIII, final int lllllllllllllIIIIllIIlIllllIllll) {
        }
    }
}
