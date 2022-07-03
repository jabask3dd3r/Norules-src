package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;

public class CookedFishIDTypo implements IFixableData
{
    private static final /* synthetic */ ResourceLocation WRONG;
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llllllllllllIllllllllIllIIllIlII) {
        if (llllllllllllIllllllllIllIIllIlII.hasKey("id", 8) && CookedFishIDTypo.WRONG.equals(new ResourceLocation(llllllllllllIllllllllIllIIllIlII.getString("id")))) {
            llllllllllllIllllllllIllIIllIlII.setString("id", "minecraft:cooked_fish");
        }
        return llllllllllllIllllllllIllIIllIlII;
    }
    
    @Override
    public int getFixVersion() {
        return 502;
    }
    
    static {
        WRONG = new ResourceLocation("cooked_fished");
    }
}
