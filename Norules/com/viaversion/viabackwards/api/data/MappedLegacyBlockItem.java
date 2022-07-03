package com.viaversion.viabackwards.api.data;

import com.viaversion.viabackwards.utils.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class MappedLegacyBlockItem
{
    private /* synthetic */ BlockEntityHandler blockEntityHandler;
    private final /* synthetic */ int id;
    private final /* synthetic */ Block block;
    private final /* synthetic */ short data;
    private final /* synthetic */ String name;
    
    public MappedLegacyBlockItem(final int lllllllllllllllllllllIIllIIlllIl, final short lllllllllllllllllllllIIllIIlllII, final String lllllllllllllllllllllIIllIlIIIII, final boolean lllllllllllllllllllllIIllIIllIlI) {
        this.id = lllllllllllllllllllllIIllIIlllIl;
        this.data = lllllllllllllllllllllIIllIIlllII;
        this.name = ((lllllllllllllllllllllIIllIlIIIII != null) ? String.valueOf(new StringBuilder().append("§f").append(lllllllllllllllllllllIIllIlIIIII)) : null);
        this.block = (lllllllllllllllllllllIIllIIllIlI ? new Block(lllllllllllllllllllllIIllIIlllIl, lllllllllllllllllllllIIllIIlllII) : null);
    }
    
    public short getData() {
        return this.data;
    }
    
    public int getId() {
        return this.id;
    }
    
    public boolean hasBlockEntityHandler() {
        return this.blockEntityHandler != null;
    }
    
    public BlockEntityHandler getBlockEntityHandler() {
        return this.blockEntityHandler;
    }
    
    public boolean isBlock() {
        return this.block != null;
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    public void setBlockEntityHandler(final BlockEntityHandler lllllllllllllllllllllIIllIIIIIIl) {
        this.blockEntityHandler = lllllllllllllllllllllIIllIIIIIIl;
    }
    
    public String getName() {
        return this.name;
    }
    
    @FunctionalInterface
    public interface BlockEntityHandler
    {
        CompoundTag handleOrNewCompoundTag(final int p0, final CompoundTag p1);
    }
}
