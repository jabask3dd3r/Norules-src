package net.minecraft.util.datafix.walkers;

import org.apache.logging.log4j.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;

public class EntityTag implements IDataWalker
{
    private static final /* synthetic */ Logger LOGGER;
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public NBTTagCompound process(final IDataFixer lllllllllllllllllllIlllIIllllIll, final NBTTagCompound lllllllllllllllllllIlllIIllllIlI, final int lllllllllllllllllllIlllIlIIIIIll) {
        final NBTTagCompound lllllllllllllllllllIlllIlIIIIIlI = lllllllllllllllllllIlllIIllllIlI.getCompoundTag("tag");
        if (lllllllllllllllllllIlllIlIIIIIlI.hasKey("EntityTag", 10)) {
            final NBTTagCompound lllllllllllllllllllIlllIlIIIIIIl = lllllllllllllllllllIlllIlIIIIIlI.getCompoundTag("EntityTag");
            final String lllllllllllllllllllIlllIlIIIIIII = lllllllllllllllllllIlllIIllllIlI.getString("id");
            String lllllllllllllllllllIlllIIllllllI = null;
            if ("minecraft:armor_stand".equals(lllllllllllllllllllIlllIlIIIIIII)) {
                final String lllllllllllllllllllIlllIIlllllll = (lllllllllllllllllllIlllIlIIIIIll < 515) ? "ArmorStand" : "minecraft:armor_stand";
            }
            else {
                if (!"minecraft:spawn_egg".equals(lllllllllllllllllllIlllIlIIIIIII)) {
                    return lllllllllllllllllllIlllIIllllIlI;
                }
                lllllllllllllllllllIlllIIllllllI = lllllllllllllllllllIlllIlIIIIIIl.getString("id");
            }
            boolean lllllllllllllllllllIlllIIlllllII = false;
            if (lllllllllllllllllllIlllIIllllllI == null) {
                EntityTag.LOGGER.warn("Unable to resolve Entity for ItemInstance: {}", (Object)lllllllllllllllllllIlllIlIIIIIII);
                final boolean lllllllllllllllllllIlllIIlllllIl = false;
            }
            else {
                lllllllllllllllllllIlllIIlllllII = !lllllllllllllllllllIlllIlIIIIIIl.hasKey("id", 8);
                lllllllllllllllllllIlllIlIIIIIIl.setString("id", lllllllllllllllllllIlllIIllllllI);
            }
            lllllllllllllllllllIlllIIllllIll.process(FixTypes.ENTITY, lllllllllllllllllllIlllIlIIIIIIl, lllllllllllllllllllIlllIlIIIIIll);
            if (lllllllllllllllllllIlllIIlllllII) {
                lllllllllllllllllllIlllIlIIIIIIl.removeTag("id");
            }
        }
        return lllllllllllllllllllIlllIIllllIlI;
    }
}
