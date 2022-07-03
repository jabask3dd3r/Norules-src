package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import net.minecraft.advancements.*;
import net.minecraft.network.*;
import java.io.*;
import java.util.*;
import com.google.common.collect.*;

public class SPacketAdvancementInfo implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Set<ResourceLocation> field_192607_c;
    private /* synthetic */ boolean field_192605_a;
    private /* synthetic */ Map<ResourceLocation, AdvancementProgress> field_192608_d;
    private /* synthetic */ Map<ResourceLocation, Advancement.Builder> field_192606_b;
    
    public Map<ResourceLocation, AdvancementProgress> func_192604_c() {
        return this.field_192608_d;
    }
    
    public Map<ResourceLocation, Advancement.Builder> func_192603_a() {
        return this.field_192606_b;
    }
    
    public boolean func_192602_d() {
        return this.field_192605_a;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIlIIlIlIlllIIllll) throws IOException {
        llllllllllllllIIlIIlIlIlllIIllll.writeBoolean(this.field_192605_a);
        llllllllllllllIIlIIlIlIlllIIllll.writeVarIntToBuffer(this.field_192606_b.size());
        for (final Map.Entry<ResourceLocation, Advancement.Builder> llllllllllllllIIlIIlIlIlllIIlllI : this.field_192606_b.entrySet()) {
            final ResourceLocation llllllllllllllIIlIIlIlIlllIIllIl = llllllllllllllIIlIIlIlIlllIIlllI.getKey();
            final Advancement.Builder llllllllllllllIIlIIlIlIlllIIllII = llllllllllllllIIlIIlIlIlllIIlllI.getValue();
            llllllllllllllIIlIIlIlIlllIIllll.func_192572_a(llllllllllllllIIlIIlIlIlllIIllIl);
            llllllllllllllIIlIIlIlIlllIIllII.func_192057_a(llllllllllllllIIlIIlIlIlllIIllll);
        }
        llllllllllllllIIlIIlIlIlllIIllll.writeVarIntToBuffer(this.field_192607_c.size());
        for (final ResourceLocation llllllllllllllIIlIIlIlIlllIIlIll : this.field_192607_c) {
            llllllllllllllIIlIIlIlIlllIIllll.func_192572_a(llllllllllllllIIlIIlIlIlllIIlIll);
        }
        llllllllllllllIIlIIlIlIlllIIllll.writeVarIntToBuffer(this.field_192608_d.size());
        for (final Map.Entry<ResourceLocation, AdvancementProgress> llllllllllllllIIlIIlIlIlllIIlIlI : this.field_192608_d.entrySet()) {
            llllllllllllllIIlIIlIlIlllIIllll.func_192572_a(llllllllllllllIIlIIlIlIlllIIlIlI.getKey());
            llllllllllllllIIlIIlIlIlllIIlIlI.getValue().func_192104_a(llllllllllllllIIlIIlIlIlllIIllll);
        }
    }
    
    public SPacketAdvancementInfo(final boolean llllllllllllllIIlIIlIlIllllllIII, final Collection<Advancement> llllllllllllllIIlIIlIlIlllllIlll, final Set<ResourceLocation> llllllllllllllIIlIIlIlIlllllllII, final Map<ResourceLocation, AdvancementProgress> llllllllllllllIIlIIlIlIlllllIlIl) {
        this.field_192605_a = llllllllllllllIIlIIlIlIllllllIII;
        this.field_192606_b = (Map<ResourceLocation, Advancement.Builder>)Maps.newHashMap();
        for (final Advancement llllllllllllllIIlIIlIlIllllllIlI : llllllllllllllIIlIIlIlIlllllIlll) {
            this.field_192606_b.put(llllllllllllllIIlIIlIlIllllllIlI.func_192067_g(), llllllllllllllIIlIIlIlIllllllIlI.func_192075_a());
        }
        this.field_192607_c = llllllllllllllIIlIIlIlIlllllllII;
        this.field_192608_d = (Map<ResourceLocation, AdvancementProgress>)Maps.newHashMap((Map)llllllllllllllIIlIIlIlIlllllIlIl);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIlIIlIlIllllIllIl) {
        llllllllllllllIIlIIlIlIllllIllIl.func_191981_a(this);
    }
    
    public Set<ResourceLocation> func_192600_b() {
        return this.field_192607_c;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIlIIlIlIllllIIlIl) throws IOException {
        this.field_192605_a = llllllllllllllIIlIIlIlIllllIIlIl.readBoolean();
        this.field_192606_b = (Map<ResourceLocation, Advancement.Builder>)Maps.newHashMap();
        this.field_192607_c = (Set<ResourceLocation>)Sets.newLinkedHashSet();
        this.field_192608_d = (Map<ResourceLocation, AdvancementProgress>)Maps.newHashMap();
        for (int llllllllllllllIIlIIlIlIllllIIlII = llllllllllllllIIlIIlIlIllllIIlIl.readVarIntFromBuffer(), llllllllllllllIIlIIlIlIllllIIIll = 0; llllllllllllllIIlIIlIlIllllIIIll < llllllllllllllIIlIIlIlIllllIIlII; ++llllllllllllllIIlIIlIlIllllIIIll) {
            final ResourceLocation llllllllllllllIIlIIlIlIllllIIIlI = llllllllllllllIIlIIlIlIllllIIlIl.func_192575_l();
            final Advancement.Builder llllllllllllllIIlIIlIlIllllIIIIl = Advancement.Builder.func_192060_b(llllllllllllllIIlIIlIlIllllIIlIl);
            this.field_192606_b.put(llllllllllllllIIlIIlIlIllllIIIlI, llllllllllllllIIlIIlIlIllllIIIIl);
        }
        for (int llllllllllllllIIlIIlIlIllllIIlII = llllllllllllllIIlIIlIlIllllIIlIl.readVarIntFromBuffer(), llllllllllllllIIlIIlIlIllllIIIII = 0; llllllllllllllIIlIIlIlIllllIIIII < llllllllllllllIIlIIlIlIllllIIlII; ++llllllllllllllIIlIIlIlIllllIIIII) {
            final ResourceLocation llllllllllllllIIlIIlIlIlllIlllll = llllllllllllllIIlIIlIlIllllIIlIl.func_192575_l();
            this.field_192607_c.add(llllllllllllllIIlIIlIlIlllIlllll);
        }
        for (int llllllllllllllIIlIIlIlIllllIIlII = llllllllllllllIIlIIlIlIllllIIlIl.readVarIntFromBuffer(), llllllllllllllIIlIIlIlIlllIllllI = 0; llllllllllllllIIlIIlIlIlllIllllI < llllllllllllllIIlIIlIlIllllIIlII; ++llllllllllllllIIlIIlIlIlllIllllI) {
            final ResourceLocation llllllllllllllIIlIIlIlIlllIlllIl = llllllllllllllIIlIIlIlIllllIIlIl.func_192575_l();
            this.field_192608_d.put(llllllllllllllIIlIIlIlIlllIlllIl, AdvancementProgress.func_192100_b(llllllllllllllIIlIIlIlIllllIIlIl));
        }
    }
    
    public SPacketAdvancementInfo() {
    }
}
