package optifine;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.item.*;

public class DynamicLights
{
    private static final /* synthetic */ DataParameter<ItemStack> PARAMETER_ITEM_STACK;
    private static /* synthetic */ long timeUpdateMs;
    private static /* synthetic */ Map<Integer, DynamicLight> mapDynamicLights;
    
    public static int getLightLevel(final ItemStack lIIlIIlllllIlIl) {
        if (lIIlIIlllllIlIl == null) {
            return 0;
        }
        final Item lIIlIIlllllIlII = lIIlIIlllllIlIl.getItem();
        if (lIIlIIlllllIlII instanceof ItemBlock) {
            final ItemBlock lIIlIIlllllIIll = (ItemBlock)lIIlIIlllllIlII;
            final Block lIIlIIlllllIIlI = lIIlIIlllllIIll.getBlock();
            if (lIIlIIlllllIIlI != null) {
                return lIIlIIlllllIIlI.getLightValue(lIIlIIlllllIIlI.getDefaultState());
            }
        }
        if (lIIlIIlllllIlII == Items.LAVA_BUCKET) {
            return Blocks.LAVA.getLightValue(Blocks.LAVA.getDefaultState());
        }
        if (lIIlIIlllllIlII == Items.BLAZE_ROD || lIIlIIlllllIlII == Items.BLAZE_POWDER) {
            return 10;
        }
        if (lIIlIIlllllIlII == Items.GLOWSTONE_DUST) {
            return 8;
        }
        if (lIIlIIlllllIlII == Items.PRISMARINE_CRYSTALS) {
            return 8;
        }
        if (lIIlIIlllllIlII == Items.MAGMA_CREAM) {
            return 8;
        }
        return (lIIlIIlllllIlII == Items.NETHER_STAR) ? (Blocks.BEACON.getLightValue(Blocks.BEACON.getDefaultState()) / 2) : 0;
    }
    
    public static void entityRemoved(final Entity lIIlIlIIllIllIl, final RenderGlobal lIIlIlIIllIllll) {
        synchronized (DynamicLights.mapDynamicLights) {
            final DynamicLight lIIlIlIIllIlllI = DynamicLights.mapDynamicLights.remove(IntegerCache.getInteger(lIIlIlIIllIllIl.getEntityId()));
            if (lIIlIlIIllIlllI != null) {
                lIIlIlIIllIlllI.updateLitChunks(lIIlIlIIllIllll);
            }
        }
        // monitorexit(DynamicLights.mapDynamicLights)
    }
    
    public static void update(final RenderGlobal lIIlIlIIllIIIIl) {
        final long lIIlIlIIllIIIll = System.currentTimeMillis();
        if (lIIlIlIIllIIIll >= DynamicLights.timeUpdateMs + 50L) {
            DynamicLights.timeUpdateMs = lIIlIlIIllIIIll;
            synchronized (DynamicLights.mapDynamicLights) {
                updateMapDynamicLights(lIIlIlIIllIIIIl);
                if (DynamicLights.mapDynamicLights.size() > 0) {
                    for (final DynamicLight lIIlIlIIllIIIlI : DynamicLights.mapDynamicLights.values()) {
                        lIIlIlIIllIIIlI.update(lIIlIlIIllIIIIl);
                    }
                }
            }
            // monitorexit(DynamicLights.mapDynamicLights)
        }
    }
    
    public static void removeLights(final RenderGlobal lIIlIIlllIIIlll) {
        synchronized (DynamicLights.mapDynamicLights) {
            final Collection<DynamicLight> lIIlIIlllIIIllI = DynamicLights.mapDynamicLights.values();
            final Iterator lIIlIIlllIIIlIl = lIIlIIlllIIIllI.iterator();
            while (lIIlIIlllIIIlIl.hasNext()) {
                final DynamicLight lIIlIIlllIIIlII = lIIlIIlllIIIlIl.next();
                lIIlIIlllIIIlIl.remove();
                lIIlIIlllIIIlII.updateLitChunks(lIIlIIlllIIIlll);
            }
        }
        // monitorexit(DynamicLights.mapDynamicLights)
    }
    
    public static int getCombinedLight(final double lIIlIlIIIlIllII, int lIIlIlIIIlIlIll) {
        if (lIIlIlIIIlIllII > 0.0) {
            final int lIIlIlIIIlIlllI = (int)(lIIlIlIIIlIllII * 16.0);
            final int lIIlIlIIIlIllIl = (int)(lIIlIlIIIlIlIll & 0xFF);
            if (lIIlIlIIIlIlllI > lIIlIlIIIlIllIl) {
                lIIlIlIIIlIlIll &= 0xFFFFFF00;
                lIIlIlIIIlIlIll |= lIIlIlIIIlIlllI;
            }
        }
        return (int)lIIlIlIIIlIlIll;
    }
    
    public static void clear() {
        synchronized (DynamicLights.mapDynamicLights) {
            DynamicLights.mapDynamicLights.clear();
        }
        // monitorexit(DynamicLights.mapDynamicLights)
    }
    
    static {
        LIGHT_LEVEL_BLAZE = 10;
        LIGHT_LEVEL_GLOWSTONE_DUST = 8;
        LIGHT_LEVEL_FIRE = 15;
        LIGHT_LEVEL_MAX = 15;
        LIGHT_LEVEL_MAGMA_CUBE_CORE = 13;
        LIGHT_LEVEL_MAGMA_CUBE = 8;
        LIGHT_LEVEL_PRISMARINE_CRYSTALS = 8;
        DynamicLights.mapDynamicLights = new HashMap<Integer, DynamicLight>();
        DynamicLights.timeUpdateMs = 0L;
        PARAMETER_ITEM_STACK = new DataParameter<ItemStack>(6, DataSerializers.OPTIONAL_ITEM_STACK);
    }
    
    public static int getCount() {
        synchronized (DynamicLights.mapDynamicLights) {
            // monitorexit(DynamicLights.mapDynamicLights)
            return DynamicLights.mapDynamicLights.size();
        }
    }
    
    public static double getLightLevel(final BlockPos lIIlIlIIIIIlIIl) {
        double lIIlIlIIIIlIlll = 0.0;
        synchronized (DynamicLights.mapDynamicLights) {
            for (final DynamicLight lIIlIlIIIIlIllI : DynamicLights.mapDynamicLights.values()) {
                int lIIlIlIIIIlIlIl = lIIlIlIIIIlIllI.getLastLightLevel();
                if (lIIlIlIIIIlIlIl > 0) {
                    final double lIIlIlIIIIlIlII = lIIlIlIIIIlIllI.getLastPosX();
                    final double lIIlIlIIIIlIIll = lIIlIlIIIIlIllI.getLastPosY();
                    final double lIIlIlIIIIlIIlI = lIIlIlIIIIlIllI.getLastPosZ();
                    final double lIIlIlIIIIlIIIl = lIIlIlIIIIIlIIl.getX() - lIIlIlIIIIlIlII;
                    final double lIIlIlIIIIlIIII = lIIlIlIIIIIlIIl.getY() - lIIlIlIIIIlIIll;
                    final double lIIlIlIIIIIllll = lIIlIlIIIIIlIIl.getZ() - lIIlIlIIIIlIIlI;
                    double lIIlIlIIIIIlllI = lIIlIlIIIIlIIIl * lIIlIlIIIIlIIIl + lIIlIlIIIIlIIII * lIIlIlIIIIlIIII + lIIlIlIIIIIllll * lIIlIlIIIIIllll;
                    if (lIIlIlIIIIlIllI.isUnderwater() && !Config.isClearWater()) {
                        lIIlIlIIIIlIlIl = Config.limit(lIIlIlIIIIlIlIl - 2, 0, 15);
                        lIIlIlIIIIIlllI *= 2.0;
                    }
                    if (lIIlIlIIIIIlllI > 56.25) {
                        continue;
                    }
                    final double lIIlIlIIIIIllIl = Math.sqrt(lIIlIlIIIIIlllI);
                    final double lIIlIlIIIIIllII = 1.0 - lIIlIlIIIIIllIl / 7.5;
                    final double lIIlIlIIIIIlIll = lIIlIlIIIIIllII * lIIlIlIIIIlIlIl;
                    if (lIIlIlIIIIIlIll <= lIIlIlIIIIlIlll) {
                        continue;
                    }
                    lIIlIlIIIIlIlll = lIIlIlIIIIIlIll;
                }
            }
        }
        // monitorexit(DynamicLights.mapDynamicLights)
        final double lIIlIlIIIIIlIlI = Config.limit(lIIlIlIIIIlIlll, 0.0, 15.0);
        return lIIlIlIIIIIlIlI;
    }
    
    private static void updateMapDynamicLights(final RenderGlobal lIIlIlIIlIlIlIl) {
        final World lIIlIlIIlIlIlII = lIIlIlIIlIlIlIl.getWorld();
        if (lIIlIlIIlIlIlII != null) {
            for (final Entity lIIlIlIIlIlIIll : lIIlIlIIlIlIlII.getLoadedEntityList()) {
                final int lIIlIlIIlIlIIlI = getLightLevel(lIIlIlIIlIlIIll);
                if (lIIlIlIIlIlIIlI > 0) {
                    final Integer lIIlIlIIlIlIIIl = IntegerCache.getInteger(lIIlIlIIlIlIIll.getEntityId());
                    DynamicLight lIIlIlIIlIlIIII = DynamicLights.mapDynamicLights.get(lIIlIlIIlIlIIIl);
                    if (lIIlIlIIlIlIIII != null) {
                        continue;
                    }
                    lIIlIlIIlIlIIII = new DynamicLight(lIIlIlIIlIlIIll);
                    DynamicLights.mapDynamicLights.put(lIIlIlIIlIlIIIl, lIIlIlIIlIlIIII);
                }
                else {
                    final Integer lIIlIlIIlIIllll = IntegerCache.getInteger(lIIlIlIIlIlIIll.getEntityId());
                    final DynamicLight lIIlIlIIlIIlllI = DynamicLights.mapDynamicLights.remove(lIIlIlIIlIIllll);
                    if (lIIlIlIIlIIlllI == null) {
                        continue;
                    }
                    lIIlIlIIlIIlllI.updateLitChunks(lIIlIlIIlIlIlIl);
                }
            }
        }
    }
    
    public static int getCombinedLight(final BlockPos lIIlIlIIlIIIIII, int lIIlIlIIIllllll) {
        final double lIIlIlIIlIIIIIl = getLightLevel(lIIlIlIIlIIIIII);
        lIIlIlIIIllllll = (byte)getCombinedLight(lIIlIlIIlIIIIIl, lIIlIlIIIllllll);
        return lIIlIlIIIllllll;
    }
    
    public static int getLightLevel(final Entity lIIlIIllllIIlII) {
        if (lIIlIIllllIIlII == Config.getMinecraft().getRenderViewEntity() && !Config.isDynamicHandLight()) {
            return 0;
        }
        if (lIIlIIllllIIlII instanceof EntityPlayer) {
            final EntityPlayer lIIlIIllllIIIll = (EntityPlayer)lIIlIIllllIIlII;
            if (lIIlIIllllIIIll.isSpectator()) {
                return 0;
            }
        }
        if (lIIlIIllllIIlII.isBurning()) {
            return 15;
        }
        if (lIIlIIllllIIlII instanceof EntityFireball) {
            return 15;
        }
        if (lIIlIIllllIIlII instanceof EntityTNTPrimed) {
            return 15;
        }
        if (lIIlIIllllIIlII instanceof EntityBlaze) {
            final EntityBlaze lIIlIIllllIIIlI = (EntityBlaze)lIIlIIllllIIlII;
            return lIIlIIllllIIIlI.isCharged() ? 15 : 10;
        }
        if (lIIlIIllllIIlII instanceof EntityMagmaCube) {
            final EntityMagmaCube lIIlIIllllIIIIl = (EntityMagmaCube)lIIlIIllllIIlII;
            return (lIIlIIllllIIIIl.squishFactor > 0.6) ? 13 : 8;
        }
        if (lIIlIIllllIIlII instanceof EntityCreeper) {
            final EntityCreeper lIIlIIllllIIIII = (EntityCreeper)lIIlIIllllIIlII;
            if (lIIlIIllllIIIII.getCreeperFlashIntensity(0.0f) > 0.001) {
                return 15;
            }
        }
        if (lIIlIIllllIIlII instanceof EntityLivingBase) {
            final EntityLivingBase lIIlIIlllIlllll = (EntityLivingBase)lIIlIIllllIIlII;
            final ItemStack lIIlIIlllIllllI = lIIlIIlllIlllll.getHeldItemMainhand();
            final int lIIlIIlllIlllIl = getLightLevel(lIIlIIlllIllllI);
            final ItemStack lIIlIIlllIlllII = lIIlIIlllIlllll.getHeldItemOffhand();
            final int lIIlIIlllIllIll = getLightLevel(lIIlIIlllIlllII);
            final ItemStack lIIlIIlllIllIlI = lIIlIIlllIlllll.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
            final int lIIlIIlllIllIIl = getLightLevel(lIIlIIlllIllIlI);
            final int lIIlIIlllIllIII = Math.max(lIIlIIlllIlllIl, lIIlIIlllIllIll);
            return Math.max(lIIlIIlllIllIII, lIIlIIlllIllIIl);
        }
        if (lIIlIIllllIIlII instanceof EntityItem) {
            final EntityItem lIIlIIlllIlIlll = (EntityItem)lIIlIIllllIIlII;
            final ItemStack lIIlIIlllIlIllI = getItemStack(lIIlIIlllIlIlll);
            return getLightLevel(lIIlIIlllIlIllI);
        }
        return 0;
    }
    
    public static int getCombinedLight(final Entity lIIlIlIIIlllIlI, int lIIlIlIIIllIllI) {
        final double lIIlIlIIIlllIII = getLightLevel(lIIlIlIIIlllIlI);
        lIIlIlIIIllIllI = getCombinedLight(lIIlIlIIIlllIII, lIIlIlIIIllIllI);
        return lIIlIlIIIllIllI;
    }
    
    public static void entityAdded(final Entity lIIlIlIIlllIllI, final RenderGlobal lIIlIlIIlllIlIl) {
    }
    
    public static ItemStack getItemStack(final EntityItem lIIlIIllIllIllI) {
        final ItemStack lIIlIIllIllIlll = lIIlIIllIllIllI.getDataManager().get(DynamicLights.PARAMETER_ITEM_STACK);
        return lIIlIIllIllIlll;
    }
}
