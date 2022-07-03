package net.minecraft.tileentity;

import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;

public class TileEntityDropper extends TileEntityDispenser
{
    public static void registerFixesDropper(final DataFixer lllllllllllllIlIIIlIIlIIlllIllIl) {
        lllllllllllllIlIIIlIIlIIlllIllIl.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityDropper.class, new String[] { "Items" }));
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.dropper";
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:dropper";
    }
}
