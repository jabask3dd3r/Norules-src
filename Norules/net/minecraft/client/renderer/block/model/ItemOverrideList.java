package net.minecraft.client.renderer.block.model;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ItemOverrideList
{
    private final /* synthetic */ List<ItemOverride> overrides;
    
    private ItemOverrideList() {
        this.overrides = (List<ItemOverride>)Lists.newArrayList();
    }
    
    static {
        NONE = new ItemOverrideList();
    }
    
    public ItemOverrideList(final List<ItemOverride> lllllllllllllIIlIIIIlllIllIllIIl) {
        this.overrides = (List<ItemOverride>)Lists.newArrayList();
        for (int lllllllllllllIIlIIIIlllIllIllIII = lllllllllllllIIlIIIIlllIllIllIIl.size() - 1; lllllllllllllIIlIIIIlllIllIllIII >= 0; --lllllllllllllIIlIIIIlllIllIllIII) {
            this.overrides.add(lllllllllllllIIlIIIIlllIllIllIIl.get(lllllllllllllIIlIIIIlllIllIllIII));
        }
    }
    
    @Nullable
    public ResourceLocation applyOverride(final ItemStack lllllllllllllIIlIIIIlllIllIIllIl, @Nullable final World lllllllllllllIIlIIIIlllIllIIllII, @Nullable final EntityLivingBase lllllllllllllIIlIIIIlllIllIIlIll) {
        if (!this.overrides.isEmpty()) {
            for (final ItemOverride lllllllllllllIIlIIIIlllIllIIlIlI : this.overrides) {
                if (lllllllllllllIIlIIIIlllIllIIlIlI.matchesItemStack(lllllllllllllIIlIIIIlllIllIIllIl, lllllllllllllIIlIIIIlllIllIIllII, lllllllllllllIIlIIIIlllIllIIlIll)) {
                    return lllllllllllllIIlIIIIlllIllIIlIlI.getLocation();
                }
            }
        }
        return null;
    }
}
