package net.minecraft.util.datafix.walkers;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public abstract class Filtered implements IDataWalker
{
    private final /* synthetic */ ResourceLocation key;
    
    public Filtered(final Class<?> lllllllllllllllIlIIIIIIlIlIlIlII) {
        if (Entity.class.isAssignableFrom(lllllllllllllllIlIIIIIIlIlIlIlII)) {
            this.key = EntityList.func_191306_a((Class<? extends Entity>)lllllllllllllllIlIIIIIIlIlIlIlII);
        }
        else if (TileEntity.class.isAssignableFrom(lllllllllllllllIlIIIIIIlIlIlIlII)) {
            this.key = TileEntity.func_190559_a((Class<? extends TileEntity>)lllllllllllllllIlIIIIIIlIlIlIlII);
        }
        else {
            this.key = null;
        }
    }
    
    @Override
    public NBTTagCompound process(final IDataFixer lllllllllllllllIlIIIIIIlIlIIlIII, NBTTagCompound lllllllllllllllIlIIIIIIlIlIIIlll, final int lllllllllllllllIlIIIIIIlIlIIlIlI) {
        if (new ResourceLocation(lllllllllllllllIlIIIIIIlIlIIIlll.getString("id")).equals(this.key)) {
            lllllllllllllllIlIIIIIIlIlIIIlll = this.filteredProcess(lllllllllllllllIlIIIIIIlIlIIlIII, lllllllllllllllIlIIIIIIlIlIIIlll, lllllllllllllllIlIIIIIIlIlIIlIlI);
        }
        return lllllllllllllllIlIIIIIIlIlIIIlll;
    }
    
    abstract NBTTagCompound filteredProcess(final IDataFixer p0, final NBTTagCompound p1, final int p2);
}
