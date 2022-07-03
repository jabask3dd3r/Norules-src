package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class FlatLayerInfo
{
    private /* synthetic */ IBlockState layerMaterial;
    private final /* synthetic */ int version;
    private /* synthetic */ int layerCount;
    private /* synthetic */ int layerMinimumY;
    
    public FlatLayerInfo(final int lllllllllllllllIllIlllllIIllIlll, final int lllllllllllllllIllIlllllIIllIllI, final Block lllllllllllllllIllIlllllIIllIlIl) {
        this.layerCount = 1;
        this.version = lllllllllllllllIllIlllllIIllIlll;
        this.layerCount = lllllllllllllllIllIlllllIIllIllI;
        this.layerMaterial = lllllllllllllllIllIlllllIIllIlIl.getDefaultState();
    }
    
    @Override
    public String toString() {
        String lllllllllllllllIllIlllllIIIIlIll = null;
        if (this.version >= 3) {
            final ResourceLocation lllllllllllllllIllIlllllIIIIlIlI = Block.REGISTRY.getNameForObject(this.getLayerMaterialBlock());
            String lllllllllllllllIllIlllllIIIIllII = (lllllllllllllllIllIlllllIIIIlIlI == null) ? "null" : lllllllllllllllIllIlllllIIIIlIlI.toString();
            if (this.layerCount > 1) {
                lllllllllllllllIllIlllllIIIIllII = String.valueOf(new StringBuilder(String.valueOf(this.layerCount)).append("*").append(lllllllllllllllIllIlllllIIIIllII));
            }
        }
        else {
            lllllllllllllllIllIlllllIIIIlIll = Integer.toString(Block.getIdFromBlock(this.getLayerMaterialBlock()));
            if (this.layerCount > 1) {
                lllllllllllllllIllIlllllIIIIlIll = String.valueOf(new StringBuilder(String.valueOf(this.layerCount)).append("x").append(lllllllllllllllIllIlllllIIIIlIll));
            }
        }
        final int lllllllllllllllIllIlllllIIIIlIIl = this.getFillBlockMeta();
        if (lllllllllllllllIllIlllllIIIIlIIl > 0) {
            lllllllllllllllIllIlllllIIIIlIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIllIlllllIIIIlIll)).append(":").append(lllllllllllllllIllIlllllIIIIlIIl));
        }
        return lllllllllllllllIllIlllllIIIIlIll;
    }
    
    private int getFillBlockMeta() {
        return this.layerMaterial.getBlock().getMetaFromState(this.layerMaterial);
    }
    
    public int getMinY() {
        return this.layerMinimumY;
    }
    
    public FlatLayerInfo(final int lllllllllllllllIllIlllllIIlIlIIl, final int lllllllllllllllIllIlllllIIlIllIl, final Block lllllllllllllllIllIlllllIIlIIlll, final int lllllllllllllllIllIlllllIIlIlIll) {
        this(lllllllllllllllIllIlllllIIlIlIIl, lllllllllllllllIllIlllllIIlIllIl, lllllllllllllllIllIlllllIIlIIlll);
        this.layerMaterial = lllllllllllllllIllIlllllIIlIIlll.getStateFromMeta(lllllllllllllllIllIlllllIIlIlIll);
    }
    
    public void setMinY(final int lllllllllllllllIllIlllllIIIlIIll) {
        this.layerMinimumY = lllllllllllllllIllIlllllIIIlIIll;
    }
    
    public FlatLayerInfo(final int lllllllllllllllIllIlllllIlIIIIlI, final Block lllllllllllllllIllIlllllIlIIIlII) {
        this(3, lllllllllllllllIllIlllllIlIIIIlI, lllllllllllllllIllIlllllIlIIIlII);
    }
    
    public int getLayerCount() {
        return this.layerCount;
    }
    
    public IBlockState getLayerMaterial() {
        return this.layerMaterial;
    }
    
    private Block getLayerMaterialBlock() {
        return this.layerMaterial.getBlock();
    }
}
