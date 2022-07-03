package optifine;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.storage.*;
import net.minecraft.item.*;
import java.io.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;

public class ReflectorForge
{
    public static void FMLClientHandler_trackBrokenTexture(final ResourceLocation lllllllllllllIIlIlllllIIlIlIIlII, final String lllllllllllllIIlIlllllIIlIlIIIII) {
        if (!Reflector.FMLClientHandler_trackBrokenTexture.exists()) {
            final Object lllllllllllllIIlIlllllIIlIlIIIlI = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
            Reflector.call(lllllllllllllIIlIlllllIIlIlIIIlI, Reflector.FMLClientHandler_trackBrokenTexture, lllllllllllllIIlIlllllIIlIlIIlII, lllllllllllllIIlIlllllIIlIlIIIII);
        }
    }
    
    public static boolean renderFirstPersonHand(final RenderGlobal lllllllllllllIIlIlllllIIlIIIlIIl, final float lllllllllllllIIlIlllllIIlIIIlIII, final int lllllllllllllIIlIlllllIIlIIIlIlI) {
        return Reflector.ForgeHooksClient_renderFirstPersonHand.exists() && Reflector.callBoolean(Reflector.ForgeHooksClient_renderFirstPersonHand, lllllllllllllIIlIlllllIIlIIIlIIl, lllllllllllllIIlIlllllIIlIIIlIII, lllllllllllllIIlIlllllIIlIIIlIlI);
    }
    
    public static MapData getMapData(final ItemMap lllllllllllllIIlIlllllIIIlIlllII, final ItemStack lllllllllllllIIlIlllllIIIlIllIll, final World lllllllllllllIIlIlllllIIIlIllIlI) {
        return Reflector.ForgeHooksClient.exists() ? ((ItemMap)lllllllllllllIIlIlllllIIIlIllIll.getItem()).getMapData(lllllllllllllIIlIlllllIIIlIllIll, lllllllllllllIIlIlllllIIIlIllIlI) : lllllllllllllIIlIlllllIIIlIlllII.getMapData(lllllllllllllIIlIlllllIIIlIllIll, lllllllllllllIIlIlllllIIIlIllIlI);
    }
    
    public static boolean armorHasOverlay(final ItemArmor lllllllllllllIIlIlllllIIIllIlllI, final ItemStack lllllllllllllIIlIlllllIIIllIlIlI) {
        if (Reflector.ForgeItemArmor_hasOverlay.exists()) {
            return Reflector.callBoolean(lllllllllllllIIlIlllllIIIllIlllI, Reflector.ForgeItemArmor_hasOverlay, lllllllllllllIIlIlllllIIIllIlIlI);
        }
        final int lllllllllllllIIlIlllllIIIllIllII = lllllllllllllIIlIlllllIIIllIlllI.getColor(lllllllllllllIIlIlllllIIIllIlIlI);
        return lllllllllllllIIlIlllllIIIllIllII != 16777215;
    }
    
    public static InputStream getOptiFineResourceStream(String lllllllllllllIIlIlllllIIIllllllI) {
        if (!Reflector.OptiFineClassTransformer_instance.exists()) {
            return null;
        }
        final Object lllllllllllllIIlIlllllIIlIIIIIIl = Reflector.getFieldValue(Reflector.OptiFineClassTransformer_instance);
        if (lllllllllllllIIlIlllllIIlIIIIIIl == null) {
            return null;
        }
        if (((String)lllllllllllllIIlIlllllIIIllllllI).startsWith("/")) {
            lllllllllllllIIlIlllllIIIllllllI = ((String)lllllllllllllIIlIlllllIIIllllllI).substring(1);
        }
        final byte[] lllllllllllllIIlIlllllIIlIIIIIII = (byte[])Reflector.call(lllllllllllllIIlIlllllIIlIIIIIIl, Reflector.OptiFineClassTransformer_getOptiFineResource, lllllllllllllIIlIlllllIIIllllllI);
        if (lllllllllllllIIlIlllllIIlIIIIIII == null) {
            return null;
        }
        final InputStream lllllllllllllIIlIlllllIIIlllllll = new ByteArrayInputStream(lllllllllllllIIlIlllllIIlIIIIIII);
        return lllllllllllllIIlIlllllIIIlllllll;
    }
    
    public static boolean blockHasTileEntity(final IBlockState lllllllllllllIIlIlllllIIIlllIllI) {
        final Block lllllllllllllIIlIlllllIIIlllIlll = lllllllllllllIIlIlllllIIIlllIllI.getBlock();
        return Reflector.ForgeBlock_hasTileEntity.exists() ? Reflector.callBoolean(lllllllllllllIIlIlllllIIIlllIlll, Reflector.ForgeBlock_hasTileEntity, lllllllllllllIIlIlllllIIIlllIllI) : lllllllllllllIIlIlllllIIIlllIlll.hasTileEntity();
    }
    
    public static void putLaunchBlackboard(final String lllllllllllllIIlIlllllIIlIIlIlIl, final Object lllllllllllllIIlIlllllIIlIIlIIIl) {
        final Map lllllllllllllIIlIlllllIIlIIlIIll = (Map)Reflector.getFieldValue(Reflector.Launch_blackboard);
        if (lllllllllllllIIlIlllllIIlIIlIIll != null) {
            lllllllllllllIIlIlllllIIlIIlIIll.put(lllllllllllllIIlIlllllIIlIIlIlIl, lllllllllllllIIlIlllllIIlIIlIIIl);
        }
    }
    
    public static boolean isItemDamaged(final ItemStack lllllllllllllIIlIlllllIIIlllIIll) {
        return Reflector.ForgeItem_showDurabilityBar.exists() ? Reflector.callBoolean(lllllllllllllIIlIlllllIIIlllIIll.getItem(), Reflector.ForgeItem_showDurabilityBar, lllllllllllllIIlIlllllIIIlllIIll) : lllllllllllllIIlIlllllIIIlllIIll.isItemDamaged();
    }
    
    public static int getLightValue(final IBlockState lllllllllllllIIlIlllllIIIllIIlIl, final IBlockAccess lllllllllllllIIlIlllllIIIllIIIIl, final BlockPos lllllllllllllIIlIlllllIIIllIIIII) {
        return Reflector.ForgeIBlockProperties_getLightValue2.exists() ? Reflector.callInt(lllllllllllllIIlIlllllIIIllIIlIl, Reflector.ForgeIBlockProperties_getLightValue2, lllllllllllllIIlIlllllIIIllIIIIl, lllllllllllllIIlIlllllIIIllIIIII) : lllllllllllllIIlIlllllIIIllIIlIl.getLightValue();
    }
    
    public static void FMLClientHandler_trackMissingTexture(final ResourceLocation lllllllllllllIIlIlllllIIlIIlllII) {
        if (!Reflector.FMLClientHandler_trackMissingTexture.exists()) {
            final Object lllllllllllllIIlIlllllIIlIIllIll = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
            Reflector.call(lllllllllllllIIlIlllllIIlIIllIll, Reflector.FMLClientHandler_trackMissingTexture, lllllllllllllIIlIlllllIIlIIlllII);
        }
    }
}
