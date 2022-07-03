package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;

public class MinecartEntityTypes implements IFixableData
{
    private static final /* synthetic */ List<String> MINECART_TYPE_LIST;
    
    @Override
    public int getFixVersion() {
        return 106;
    }
    
    static {
        MINECART_TYPE_LIST = Lists.newArrayList((Object[])new String[] { "MinecartRideable", "MinecartChest", "MinecartFurnace", "MinecartTNT", "MinecartSpawner", "MinecartHopper", "MinecartCommandBlock" });
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lIIlIllIlIIIll) {
        if ("Minecart".equals(lIIlIllIlIIIll.getString("id"))) {
            String lIIlIllIlIIlIl = "MinecartRideable";
            final int lIIlIllIlIIlII = lIIlIllIlIIIll.getInteger("Type");
            if (lIIlIllIlIIlII > 0 && lIIlIllIlIIlII < MinecartEntityTypes.MINECART_TYPE_LIST.size()) {
                lIIlIllIlIIlIl = MinecartEntityTypes.MINECART_TYPE_LIST.get(lIIlIllIlIIlII);
            }
            lIIlIllIlIIIll.setString("id", lIIlIllIlIIlIl);
            lIIlIllIlIIIll.removeTag("Type");
        }
        return lIIlIllIlIIIll;
    }
}
