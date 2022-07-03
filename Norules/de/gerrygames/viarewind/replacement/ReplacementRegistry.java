package de.gerrygames.viarewind.replacement;

import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class ReplacementRegistry
{
    private final /* synthetic */ Int2ObjectMap<Replacement> blockReplacements;
    private final /* synthetic */ Int2ObjectMap<Replacement> itemReplacements;
    
    public void registerBlock(final int llIlIllIllIIlII, final int llIlIllIllIIlll, final Replacement llIlIllIllIIIlI) {
        this.blockReplacements.put(combine(llIlIllIllIIlII, llIlIllIllIIlll), llIlIllIllIIIlI);
    }
    
    public Item replace(final Item llIlIllIlIIlllI) {
        Replacement llIlIllIlIlIIII = this.itemReplacements.get(combine(llIlIllIlIIlllI.identifier(), llIlIllIlIIlllI.data()));
        if (llIlIllIlIlIIII == null) {
            llIlIllIlIlIIII = this.itemReplacements.get(combine(llIlIllIlIIlllI.identifier(), -1));
        }
        return (llIlIllIlIlIIII == null) ? llIlIllIlIIlllI : llIlIllIlIlIIII.replace(llIlIllIlIIlllI);
    }
    
    public void registerItem(final int llIlIlllIIlIIII, final Replacement llIlIlllIIIllll) {
        this.registerItem(llIlIlllIIlIIII, -1, llIlIlllIIIllll);
    }
    
    public void registerItemBlock(final int llIlIllIlIllIII, final int llIlIllIlIllIll, final Replacement llIlIllIlIllIlI) {
        this.registerItem(llIlIllIlIllIII, llIlIllIlIllIll, llIlIllIlIllIlI);
        this.registerBlock(llIlIllIlIllIII, llIlIllIlIllIll, llIlIllIlIllIlI);
    }
    
    public void registerItem(final int llIlIllIlllIIII, final int llIlIllIllIllll, final Replacement llIlIllIllIlllI) {
        this.itemReplacements.put(combine(llIlIllIlllIIII, llIlIllIllIllll), llIlIllIllIlllI);
    }
    
    public void registerItemBlock(final int llIlIllIllllIll, final Replacement llIlIllIllllIlI) {
        this.registerItemBlock(llIlIllIllllIll, -1, llIlIllIllllIlI);
    }
    
    public ReplacementRegistry() {
        this.itemReplacements = new Int2ObjectOpenHashMap<Replacement>();
        this.blockReplacements = new Int2ObjectOpenHashMap<Replacement>();
    }
    
    public static int combine(final int llIlIllIIllllII, final int llIlIllIIlllIll) {
        return llIlIllIIllllII << 16 | (llIlIllIIlllIll & 0xFFFF);
    }
    
    public void registerBlock(final int llIlIlllIIIIlll, final Replacement llIlIlllIIIIllI) {
        this.registerBlock(llIlIlllIIIIlll, -1, llIlIlllIIIIllI);
    }
    
    public Replacement replace(final int llIlIllIlIIIlll, final int llIlIllIlIIIIlI) {
        Replacement llIlIllIlIIIlIl = this.blockReplacements.get(combine(llIlIllIlIIIlll, llIlIllIlIIIIlI));
        if (llIlIllIlIIIlIl == null) {
            llIlIllIlIIIlIl = this.blockReplacements.get(combine(llIlIllIlIIIlll, -1));
        }
        return llIlIllIlIIIlIl;
    }
}
