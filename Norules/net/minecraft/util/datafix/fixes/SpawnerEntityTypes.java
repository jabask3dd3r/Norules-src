package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class SpawnerEntityTypes implements IFixableData
{
    @Override
    public int getFixVersion() {
        return 107;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllllllIIIlIlIlIIIIIlll) {
        if (!"MobSpawner".equals(llllllllllllllllIIIlIlIlIIIIIlll.getString("id"))) {
            return llllllllllllllllIIIlIlIlIIIIIlll;
        }
        if (llllllllllllllllIIIlIlIlIIIIIlll.hasKey("EntityId", 8)) {
            final String llllllllllllllllIIIlIlIlIIIIIllI = llllllllllllllllIIIlIlIlIIIIIlll.getString("EntityId");
            final NBTTagCompound llllllllllllllllIIIlIlIlIIIIIlIl = llllllllllllllllIIIlIlIlIIIIIlll.getCompoundTag("SpawnData");
            llllllllllllllllIIIlIlIlIIIIIlIl.setString("id", llllllllllllllllIIIlIlIlIIIIIllI.isEmpty() ? "Pig" : llllllllllllllllIIIlIlIlIIIIIllI);
            llllllllllllllllIIIlIlIlIIIIIlll.setTag("SpawnData", llllllllllllllllIIIlIlIlIIIIIlIl);
            llllllllllllllllIIIlIlIlIIIIIlll.removeTag("EntityId");
        }
        if (llllllllllllllllIIIlIlIlIIIIIlll.hasKey("SpawnPotentials", 9)) {
            final NBTTagList llllllllllllllllIIIlIlIlIIIIIlII = llllllllllllllllIIIlIlIlIIIIIlll.getTagList("SpawnPotentials", 10);
            for (int llllllllllllllllIIIlIlIlIIIIIIll = 0; llllllllllllllllIIIlIlIlIIIIIIll < llllllllllllllllIIIlIlIlIIIIIlII.tagCount(); ++llllllllllllllllIIIlIlIlIIIIIIll) {
                final NBTTagCompound llllllllllllllllIIIlIlIlIIIIIIlI = llllllllllllllllIIIlIlIlIIIIIlII.getCompoundTagAt(llllllllllllllllIIIlIlIlIIIIIIll);
                if (llllllllllllllllIIIlIlIlIIIIIIlI.hasKey("Type", 8)) {
                    final NBTTagCompound llllllllllllllllIIIlIlIlIIIIIIIl = llllllllllllllllIIIlIlIlIIIIIIlI.getCompoundTag("Properties");
                    llllllllllllllllIIIlIlIlIIIIIIIl.setString("id", llllllllllllllllIIIlIlIlIIIIIIlI.getString("Type"));
                    llllllllllllllllIIIlIlIlIIIIIIlI.setTag("Entity", llllllllllllllllIIIlIlIlIIIIIIIl);
                    llllllllllllllllIIIlIlIlIIIIIIlI.removeTag("Type");
                    llllllllllllllllIIIlIlIlIIIIIIlI.removeTag("Properties");
                }
            }
        }
        return llllllllllllllllIIIlIlIlIIIIIlll;
    }
}
