package net.minecraft.client.renderer.entity;

import net.minecraft.client.settings.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.gui.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.boss.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.effect.*;
import optifine.*;
import net.optifine.entity.model.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.crash.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.entity.*;

public class RenderManager
{
    public /* synthetic */ Entity renderViewEntity;
    public /* synthetic */ float playerViewX;
    public /* synthetic */ GameSettings options;
    public /* synthetic */ double viewerPosY;
    private /* synthetic */ boolean renderShadow;
    public /* synthetic */ Render renderRender;
    private final /* synthetic */ Map<Class, Render> entityRenderMap;
    public /* synthetic */ float playerViewY;
    public /* synthetic */ Entity pointedEntity;
    public /* synthetic */ double viewerPosX;
    private final /* synthetic */ Map<String, RenderPlayer> skinMap;
    private final /* synthetic */ RenderPlayer playerRenderer;
    public /* synthetic */ double viewerPosZ;
    private /* synthetic */ boolean renderOutlines;
    public static /* synthetic */ double renderPosX;
    public /* synthetic */ Entity renderEntity;
    public /* synthetic */ World worldObj;
    public static /* synthetic */ double renderPosZ;
    public static /* synthetic */ double renderPosY;
    public /* synthetic */ TextureManager renderEngine;
    private /* synthetic */ FontRenderer textRenderer;
    private /* synthetic */ boolean debugBoundingBox;
    
    public Map<Class, Render> getEntityRenderMap() {
        return this.entityRenderMap;
    }
    
    public void setDebugBoundingBox(final boolean lllllllllllllIIIlIlllllIIIlIllll) {
        this.debugBoundingBox = lllllllllllllIIIlIlllllIIIlIllll;
    }
    
    public double getDistanceToCamera(final double lllllllllllllIIIlIllllIlIllIIIll, final double lllllllllllllIIIlIllllIlIlIllIll, final double lllllllllllllIIIlIllllIlIlIllIlI) {
        final double lllllllllllllIIIlIllllIlIllIIIII = lllllllllllllIIIlIllllIlIllIIIll - this.viewerPosX;
        final double lllllllllllllIIIlIllllIlIlIlllll = lllllllllllllIIIlIllllIlIlIllIll - this.viewerPosY;
        final double lllllllllllllIIIlIllllIlIlIllllI = lllllllllllllIIIlIllllIlIlIllIlI - this.viewerPosZ;
        return lllllllllllllIIIlIllllIlIllIIIII * lllllllllllllIIIlIllllIlIllIIIII + lllllllllllllIIIlIllllIlIlIlllll * lllllllllllllIIIlIllllIlIlIlllll + lllllllllllllIIIlIllllIlIlIllllI * lllllllllllllIIIlIllllIlIlIllllI;
    }
    
    public boolean isRenderShadow() {
        return this.renderShadow;
    }
    
    public void cacheActiveRenderInfo(final World lllllllllllllIIIlIlllllIIlIIllIl, final FontRenderer lllllllllllllIIIlIlllllIIlIIllII, final Entity lllllllllllllIIIlIlllllIIlIIlIll, final Entity lllllllllllllIIIlIlllllIIlIlIllI, final GameSettings lllllllllllllIIIlIlllllIIlIlIlIl, final float lllllllllllllIIIlIlllllIIlIlIlII) {
        this.worldObj = lllllllllllllIIIlIlllllIIlIIllIl;
        this.options = lllllllllllllIIIlIlllllIIlIlIlIl;
        this.renderViewEntity = lllllllllllllIIIlIlllllIIlIIlIll;
        this.pointedEntity = lllllllllllllIIIlIlllllIIlIlIllI;
        this.textRenderer = lllllllllllllIIIlIlllllIIlIIllII;
        if (lllllllllllllIIIlIlllllIIlIIlIll instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllIIIlIlllllIIlIIlIll).isPlayerSleeping()) {
            final IBlockState lllllllllllllIIIlIlllllIIlIlIIll = lllllllllllllIIIlIlllllIIlIIllIl.getBlockState(new BlockPos(lllllllllllllIIIlIlllllIIlIIlIll));
            final Block lllllllllllllIIIlIlllllIIlIlIIlI = lllllllllllllIIIlIlllllIIlIlIIll.getBlock();
            if (Reflector.callBoolean(lllllllllllllIIIlIlllllIIlIlIIlI, Reflector.ForgeBlock_isBed, lllllllllllllIIIlIlllllIIlIlIIll, lllllllllllllIIIlIlllllIIlIIllIl, new BlockPos(lllllllllllllIIIlIlllllIIlIIlIll), (EntityLivingBase)lllllllllllllIIIlIlllllIIlIIlIll)) {
                final EnumFacing lllllllllllllIIIlIlllllIIlIlIIIl = (EnumFacing)Reflector.call(lllllllllllllIIIlIlllllIIlIlIIlI, Reflector.ForgeBlock_getBedDirection, lllllllllllllIIIlIlllllIIlIlIIll, lllllllllllllIIIlIlllllIIlIIllIl, new BlockPos(lllllllllllllIIIlIlllllIIlIIlIll));
                final int lllllllllllllIIIlIlllllIIlIlIIII = lllllllllllllIIIlIlllllIIlIlIIIl.getHorizontalIndex();
                this.playerViewY = (float)(lllllllllllllIIIlIlllllIIlIlIIII * 90 + 180);
                this.playerViewX = 0.0f;
            }
            else if (lllllllllllllIIIlIlllllIIlIlIIlI == Blocks.BED) {
                final int lllllllllllllIIIlIlllllIIlIIllll = lllllllllllllIIIlIlllllIIlIlIIll.getValue((IProperty<EnumFacing>)BlockBed.FACING).getHorizontalIndex();
                this.playerViewY = (float)(lllllllllllllIIIlIlllllIIlIIllll * 90 + 180);
                this.playerViewX = 0.0f;
            }
        }
        else {
            this.playerViewY = lllllllllllllIIIlIlllllIIlIIlIll.prevRotationYaw + (lllllllllllllIIIlIlllllIIlIIlIll.rotationYaw - lllllllllllllIIIlIlllllIIlIIlIll.prevRotationYaw) * lllllllllllllIIIlIlllllIIlIlIlII;
            this.playerViewX = lllllllllllllIIIlIlllllIIlIIlIll.prevRotationPitch + (lllllllllllllIIIlIlllllIIlIIlIll.rotationPitch - lllllllllllllIIIlIlllllIIlIIlIll.prevRotationPitch) * lllllllllllllIIIlIlllllIIlIlIlII;
        }
        if (lllllllllllllIIIlIlllllIIlIlIlIl.thirdPersonView == 2) {
            this.playerViewY += 180.0f;
        }
        this.viewerPosX = lllllllllllllIIIlIlllllIIlIIlIll.lastTickPosX + (lllllllllllllIIIlIlllllIIlIIlIll.posX - lllllllllllllIIIlIlllllIIlIIlIll.lastTickPosX) * lllllllllllllIIIlIlllllIIlIlIlII;
        this.viewerPosY = lllllllllllllIIIlIlllllIIlIIlIll.lastTickPosY + (lllllllllllllIIIlIlllllIIlIIlIll.posY - lllllllllllllIIIlIlllllIIlIIlIll.lastTickPosY) * lllllllllllllIIIlIlllllIIlIlIlII;
        this.viewerPosZ = lllllllllllllIIIlIlllllIIlIIlIll.lastTickPosZ + (lllllllllllllIIIlIlllllIIlIIlIll.posZ - lllllllllllllIIIlIlllllIIlIIlIll.lastTickPosZ) * lllllllllllllIIIlIlllllIIlIlIlII;
    }
    
    public boolean isRenderMultipass(final Entity lllllllllllllIIIlIlllllIIIlIlIII) {
        return this.getEntityRenderObject(lllllllllllllIIIlIlllllIIIlIlIII).isMultipass();
    }
    
    public boolean isDebugBoundingBox() {
        return this.debugBoundingBox;
    }
    
    public <T extends Entity> Render<T> getEntityClassRenderObject(final Class<? extends Entity> lllllllllllllIIIlIlllllIIlllIIll) {
        Render<T> lllllllllllllIIIlIlllllIIlllIlIl = this.entityRenderMap.get(lllllllllllllIIIlIlllllIIlllIIll);
        if (lllllllllllllIIIlIlllllIIlllIlIl == null && lllllllllllllIIIlIlllllIIlllIIll != Entity.class) {
            lllllllllllllIIIlIlllllIIlllIlIl = (Render<T>)this.getEntityClassRenderObject((Class<? extends Entity>)lllllllllllllIIIlIlllllIIlllIIll.getSuperclass());
            this.entityRenderMap.put(lllllllllllllIIIlIlllllIIlllIIll, lllllllllllllIIIlIlllllIIlllIlIl);
        }
        return lllllllllllllIIIlIlllllIIlllIlIl;
    }
    
    public Map<String, RenderPlayer> getSkinMap() {
        return Collections.unmodifiableMap((Map<? extends String, ? extends RenderPlayer>)this.skinMap);
    }
    
    public void set(@Nullable final World lllllllllllllIIIlIllllIlIllIllII) {
        this.worldObj = lllllllllllllIIIlIllllIlIllIllII;
        if (lllllllllllllIIIlIllllIlIllIllII == null) {
            this.renderViewEntity = null;
        }
    }
    
    public RenderManager(final TextureManager lllllllllllllIIIlIlllllIlIIIIllI, final RenderItem lllllllllllllIIIlIlllllIlIIIIlIl) {
        this.entityRenderMap = (Map<Class, Render>)Maps.newHashMap();
        this.skinMap = (Map<String, RenderPlayer>)Maps.newHashMap();
        this.renderShadow = true;
        this.renderEntity = null;
        this.renderRender = null;
        this.renderEngine = lllllllllllllIIIlIlllllIlIIIIllI;
        this.entityRenderMap.put(EntityCaveSpider.class, new RenderCaveSpider(this));
        this.entityRenderMap.put(EntitySpider.class, new RenderSpider(this));
        this.entityRenderMap.put(EntityPig.class, new RenderPig(this));
        this.entityRenderMap.put(EntitySheep.class, new RenderSheep(this));
        this.entityRenderMap.put(EntityCow.class, new RenderCow(this));
        this.entityRenderMap.put(EntityMooshroom.class, new RenderMooshroom(this));
        this.entityRenderMap.put(EntityWolf.class, new RenderWolf(this));
        this.entityRenderMap.put(EntityChicken.class, new RenderChicken(this));
        this.entityRenderMap.put(EntityOcelot.class, new RenderOcelot(this));
        this.entityRenderMap.put(EntityRabbit.class, new RenderRabbit(this));
        this.entityRenderMap.put(EntityParrot.class, new RenderParrot(this));
        this.entityRenderMap.put(EntitySilverfish.class, new RenderSilverfish(this));
        this.entityRenderMap.put(EntityEndermite.class, new RenderEndermite(this));
        this.entityRenderMap.put(EntityCreeper.class, new RenderCreeper(this));
        this.entityRenderMap.put(EntityEnderman.class, new RenderEnderman(this));
        this.entityRenderMap.put(EntitySnowman.class, new RenderSnowMan(this));
        this.entityRenderMap.put(EntitySkeleton.class, new RenderSkeleton(this));
        this.entityRenderMap.put(EntityWitherSkeleton.class, new RenderWitherSkeleton(this));
        this.entityRenderMap.put(EntityStray.class, new RenderStray(this));
        this.entityRenderMap.put(EntityWitch.class, new RenderWitch(this));
        this.entityRenderMap.put(EntityBlaze.class, new RenderBlaze(this));
        this.entityRenderMap.put(EntityPigZombie.class, new RenderPigZombie(this));
        this.entityRenderMap.put(EntityZombie.class, new RenderZombie(this));
        this.entityRenderMap.put(EntityZombieVillager.class, new RenderZombieVillager(this));
        this.entityRenderMap.put(EntityHusk.class, new RenderHusk(this));
        this.entityRenderMap.put(EntitySlime.class, new RenderSlime(this));
        this.entityRenderMap.put(EntityMagmaCube.class, new RenderMagmaCube(this));
        this.entityRenderMap.put(EntityGiantZombie.class, new RenderGiantZombie(this, 6.0f));
        this.entityRenderMap.put(EntityGhast.class, new RenderGhast(this));
        this.entityRenderMap.put(EntitySquid.class, new RenderSquid(this));
        this.entityRenderMap.put(EntityVillager.class, new RenderVillager(this));
        this.entityRenderMap.put(EntityIronGolem.class, new RenderIronGolem(this));
        this.entityRenderMap.put(EntityBat.class, new RenderBat(this));
        this.entityRenderMap.put(EntityGuardian.class, new RenderGuardian(this));
        this.entityRenderMap.put(EntityElderGuardian.class, new RenderElderGuardian(this));
        this.entityRenderMap.put(EntityShulker.class, new RenderShulker(this));
        this.entityRenderMap.put(EntityPolarBear.class, new RenderPolarBear(this));
        this.entityRenderMap.put(EntityEvoker.class, new RenderEvoker(this));
        this.entityRenderMap.put(EntityVindicator.class, new RenderVindicator(this));
        this.entityRenderMap.put(EntityVex.class, new RenderVex(this));
        this.entityRenderMap.put(EntityIllusionIllager.class, new RenderIllusionIllager(this));
        this.entityRenderMap.put(EntityDragon.class, new RenderDragon(this));
        this.entityRenderMap.put(EntityEnderCrystal.class, new RenderEnderCrystal(this));
        this.entityRenderMap.put(EntityWither.class, new RenderWither(this));
        this.entityRenderMap.put(Entity.class, new RenderEntity(this));
        this.entityRenderMap.put(EntityPainting.class, new RenderPainting(this));
        this.entityRenderMap.put(EntityItemFrame.class, new RenderItemFrame(this, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityLeashKnot.class, new RenderLeashKnot(this));
        this.entityRenderMap.put(EntityTippedArrow.class, new RenderTippedArrow(this));
        this.entityRenderMap.put(EntitySpectralArrow.class, new RenderSpectralArrow(this));
        this.entityRenderMap.put(EntitySnowball.class, new RenderSnowball(this, Items.SNOWBALL, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityEnderPearl.class, new RenderSnowball(this, Items.ENDER_PEARL, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityEnderEye.class, new RenderSnowball(this, Items.ENDER_EYE, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityEgg.class, new RenderSnowball(this, Items.EGG, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityPotion.class, new RenderPotion(this, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityExpBottle.class, new RenderSnowball(this, Items.EXPERIENCE_BOTTLE, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityFireworkRocket.class, new RenderSnowball(this, Items.FIREWORKS, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityLargeFireball.class, new RenderFireball(this, 2.0f));
        this.entityRenderMap.put(EntitySmallFireball.class, new RenderFireball(this, 0.5f));
        this.entityRenderMap.put(EntityDragonFireball.class, new RenderDragonFireball(this));
        this.entityRenderMap.put(EntityWitherSkull.class, new RenderWitherSkull(this));
        this.entityRenderMap.put(EntityShulkerBullet.class, new RenderShulkerBullet(this));
        this.entityRenderMap.put(EntityItem.class, new RenderEntityItem(this, lllllllllllllIIIlIlllllIlIIIIlIl));
        this.entityRenderMap.put(EntityXPOrb.class, new RenderXPOrb(this));
        this.entityRenderMap.put(EntityTNTPrimed.class, new RenderTNTPrimed(this));
        this.entityRenderMap.put(EntityFallingBlock.class, new RenderFallingBlock(this));
        this.entityRenderMap.put(EntityArmorStand.class, new RenderArmorStand(this));
        this.entityRenderMap.put(EntityEvokerFangs.class, new RenderEvokerFangs(this));
        this.entityRenderMap.put(EntityMinecartTNT.class, new RenderTntMinecart(this));
        this.entityRenderMap.put(EntityMinecartMobSpawner.class, new RenderMinecartMobSpawner(this));
        this.entityRenderMap.put(EntityMinecart.class, new RenderMinecart(this));
        this.entityRenderMap.put(EntityBoat.class, new RenderBoat(this));
        this.entityRenderMap.put(EntityFishHook.class, new RenderFish(this));
        this.entityRenderMap.put(EntityAreaEffectCloud.class, new RenderAreaEffectCloud(this));
        this.entityRenderMap.put(EntityHorse.class, new RenderHorse(this));
        this.entityRenderMap.put(EntitySkeletonHorse.class, new RenderAbstractHorse(this));
        this.entityRenderMap.put(EntityZombieHorse.class, new RenderAbstractHorse(this));
        this.entityRenderMap.put(EntityMule.class, new RenderAbstractHorse(this, 0.92f));
        this.entityRenderMap.put(EntityDonkey.class, new RenderAbstractHorse(this, 0.87f));
        this.entityRenderMap.put(EntityLlama.class, new RenderLlama(this));
        this.entityRenderMap.put(EntityLlamaSpit.class, new RenderLlamaSpit(this));
        this.entityRenderMap.put(EntityLightningBolt.class, new RenderLightningBolt(this));
        this.playerRenderer = new RenderPlayer(this);
        this.skinMap.put("default", this.playerRenderer);
        this.skinMap.put("slim", new RenderPlayer(this, true));
        PlayerItemsLayer.register(this.skinMap);
        if (Reflector.RenderingRegistry_loadEntityRenderers.exists()) {
            Reflector.call(Reflector.RenderingRegistry_loadEntityRenderers, this, this.entityRenderMap);
        }
    }
    
    public void setRenderShadow(final boolean lllllllllllllIIIlIlllllIIIllIlIl) {
        this.renderShadow = lllllllllllllIIIlIlllllIIIllIlIl;
    }
    
    public void doRenderEntity(final Entity lllllllllllllIIIlIllllIlllIlIIIl, final double lllllllllllllIIIlIllllIllllIIIII, final double lllllllllllllIIIlIllllIlllIlllll, final double lllllllllllllIIIlIllllIlllIIlllI, final float lllllllllllllIIIlIllllIlllIIllIl, final float lllllllllllllIIIlIllllIlllIIllII, final boolean lllllllllllllIIIlIllllIlllIllIll) {
        Render<Entity> lllllllllllllIIIlIllllIlllIllIlI = null;
        try {
            lllllllllllllIIIlIllllIlllIllIlI = this.getEntityRenderObject(lllllllllllllIIIlIllllIlllIlIIIl);
            if (lllllllllllllIIIlIllllIlllIllIlI != null && this.renderEngine != null) {
                try {
                    lllllllllllllIIIlIllllIlllIllIlI.setRenderOutlines(this.renderOutlines);
                    if (CustomEntityModels.isActive()) {
                        this.renderEntity = lllllllllllllIIIlIllllIlllIlIIIl;
                        this.renderRender = lllllllllllllIIIlIllllIlllIllIlI;
                    }
                    lllllllllllllIIIlIllllIlllIllIlI.doRender(lllllllllllllIIIlIllllIlllIlIIIl, lllllllllllllIIIlIllllIllllIIIII, lllllllllllllIIIlIllllIlllIlllll, lllllllllllllIIIlIllllIlllIIlllI, lllllllllllllIIIlIllllIlllIIllIl, lllllllllllllIIIlIllllIlllIIllII);
                }
                catch (Throwable lllllllllllllIIIlIllllIlllIllIIl) {
                    throw new ReportedException(CrashReport.makeCrashReport(lllllllllllllIIIlIllllIlllIllIIl, "Rendering entity in world"));
                }
                try {
                    if (!this.renderOutlines) {
                        lllllllllllllIIIlIllllIlllIllIlI.doRenderShadowAndFire(lllllllllllllIIIlIllllIlllIlIIIl, lllllllllllllIIIlIllllIllllIIIII, lllllllllllllIIIlIllllIlllIlllll, lllllllllllllIIIlIllllIlllIIlllI, lllllllllllllIIIlIllllIlllIIllIl, lllllllllllllIIIlIllllIlllIIllII);
                    }
                }
                catch (Throwable lllllllllllllIIIlIllllIlllIllIII) {
                    throw new ReportedException(CrashReport.makeCrashReport(lllllllllllllIIIlIllllIlllIllIII, "Post-rendering entity in world"));
                }
                if (this.debugBoundingBox && !lllllllllllllIIIlIllllIlllIlIIIl.isInvisible() && !lllllllllllllIIIlIllllIlllIllIll && !Minecraft.getMinecraft().isReducedDebug()) {
                    try {
                        this.renderDebugBoundingBox(lllllllllllllIIIlIllllIlllIlIIIl, lllllllllllllIIIlIllllIllllIIIII, lllllllllllllIIIlIllllIlllIlllll, lllllllllllllIIIlIllllIlllIIlllI, lllllllllllllIIIlIllllIlllIIllIl, lllllllllllllIIIlIllllIlllIIllII);
                    }
                    catch (Throwable lllllllllllllIIIlIllllIlllIlIlll) {
                        throw new ReportedException(CrashReport.makeCrashReport(lllllllllllllIIIlIllllIlllIlIlll, "Rendering entity hitbox in world"));
                    }
                }
            }
        }
        catch (Throwable lllllllllllllIIIlIllllIlllIlIllI) {
            final CrashReport lllllllllllllIIIlIllllIlllIlIlIl = CrashReport.makeCrashReport(lllllllllllllIIIlIllllIlllIlIllI, "Rendering entity in world");
            final CrashReportCategory lllllllllllllIIIlIllllIlllIlIlII = lllllllllllllIIIlIllllIlllIlIlIl.makeCategory("Entity being rendered");
            lllllllllllllIIIlIllllIlllIlIIIl.addEntityCrashInfo(lllllllllllllIIIlIllllIlllIlIlII);
            final CrashReportCategory lllllllllllllIIIlIllllIlllIlIIll = lllllllllllllIIIlIllllIlllIlIlIl.makeCategory("Renderer details");
            lllllllllllllIIIlIllllIlllIlIIll.addCrashSection("Assigned renderer", lllllllllllllIIIlIllllIlllIllIlI);
            lllllllllllllIIIlIllllIlllIlIIll.addCrashSection("Location", CrashReportCategory.getCoordinateInfo(lllllllllllllIIIlIllllIllllIIIII, lllllllllllllIIIlIllllIlllIlllll, lllllllllllllIIIlIllllIlllIIlllI));
            lllllllllllllIIIlIllllIlllIlIIll.addCrashSection("Rotation", lllllllllllllIIIlIllllIlllIIllIl);
            lllllllllllllIIIlIllllIlllIlIIll.addCrashSection("Delta", lllllllllllllIIIlIllllIlllIIllII);
            throw new ReportedException(lllllllllllllIIIlIllllIlllIlIlIl);
        }
    }
    
    public boolean shouldRender(final Entity lllllllllllllIIIlIlllllIIIIlllIl, final ICamera lllllllllllllIIIlIlllllIIIIlIlIl, final double lllllllllllllIIIlIlllllIIIIllIll, final double lllllllllllllIIIlIlllllIIIIllIlI, final double lllllllllllllIIIlIlllllIIIIlIIlI) {
        final Render<Entity> lllllllllllllIIIlIlllllIIIIllIII = this.getEntityRenderObject(lllllllllllllIIIlIlllllIIIIlllIl);
        return lllllllllllllIIIlIlllllIIIIllIII != null && lllllllllllllIIIlIlllllIIIIllIII.shouldRender(lllllllllllllIIIlIlllllIIIIlllIl, lllllllllllllIIIlIlllllIIIIlIlIl, lllllllllllllIIIlIlllllIIIIllIll, lllllllllllllIIIlIlllllIIIIllIlI, lllllllllllllIIIlIlllllIIIIlIIlI);
    }
    
    public void setPlayerViewY(final float lllllllllllllIIIlIlllllIIIlllllI) {
        this.playerViewY = lllllllllllllIIIlIlllllIIIlllllI;
    }
    
    private void renderDebugBoundingBox(final Entity lllllllllllllIIIlIllllIllIIlIIll, final double lllllllllllllIIIlIllllIllIIIIIII, final double lllllllllllllIIIlIllllIlIlllllll, final double lllllllllllllIIIlIllllIlIllllllI, final float lllllllllllllIIIlIllllIllIIIllll, final float lllllllllllllIIIlIllllIlIlllllIl) {
        GlStateManager.depthMask(false);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        final float lllllllllllllIIIlIllllIllIIIllIl = lllllllllllllIIIlIllllIllIIlIIll.width / 2.0f;
        final AxisAlignedBB lllllllllllllIIIlIllllIllIIIllII = lllllllllllllIIIlIllllIllIIlIIll.getEntityBoundingBox();
        RenderGlobal.drawBoundingBox(lllllllllllllIIIlIllllIllIIIllII.minX - lllllllllllllIIIlIllllIllIIlIIll.posX + lllllllllllllIIIlIllllIllIIIIIII, lllllllllllllIIIlIllllIllIIIllII.minY - lllllllllllllIIIlIllllIllIIlIIll.posY + lllllllllllllIIIlIllllIlIlllllll, lllllllllllllIIIlIllllIllIIIllII.minZ - lllllllllllllIIIlIllllIllIIlIIll.posZ + lllllllllllllIIIlIllllIlIllllllI, lllllllllllllIIIlIllllIllIIIllII.maxX - lllllllllllllIIIlIllllIllIIlIIll.posX + lllllllllllllIIIlIllllIllIIIIIII, lllllllllllllIIIlIllllIllIIIllII.maxY - lllllllllllllIIIlIllllIllIIlIIll.posY + lllllllllllllIIIlIllllIlIlllllll, lllllllllllllIIIlIllllIllIIIllII.maxZ - lllllllllllllIIIlIllllIllIIlIIll.posZ + lllllllllllllIIIlIllllIlIllllllI, 1.0f, 1.0f, 1.0f, 1.0f);
        final Entity[] lllllllllllllIIIlIllllIllIIIlIll = lllllllllllllIIIlIllllIllIIlIIll.getParts();
        if (lllllllllllllIIIlIllllIllIIIlIll != null) {
            final char lllllllllllllIIIlIllllIlIlllIllI;
            final int length = (lllllllllllllIIIlIllllIlIlllIllI = (char)(Object)lllllllllllllIIIlIllllIllIIIlIll).length;
            for (float lllllllllllllIIIlIllllIlIllllIII = 0; lllllllllllllIIIlIllllIlIllllIII < length; ++lllllllllllllIIIlIllllIlIllllIII) {
                final Entity lllllllllllllIIIlIllllIllIIIlIlI = lllllllllllllIIIlIllllIlIlllIllI[lllllllllllllIIIlIllllIlIllllIII];
                final double lllllllllllllIIIlIllllIllIIIlIIl = (lllllllllllllIIIlIllllIllIIIlIlI.posX - lllllllllllllIIIlIllllIllIIIlIlI.prevPosX) * lllllllllllllIIIlIllllIlIlllllIl;
                final double lllllllllllllIIIlIllllIllIIIlIII = (lllllllllllllIIIlIllllIllIIIlIlI.posY - lllllllllllllIIIlIllllIllIIIlIlI.prevPosY) * lllllllllllllIIIlIllllIlIlllllIl;
                final double lllllllllllllIIIlIllllIllIIIIlll = (lllllllllllllIIIlIllllIllIIIlIlI.posZ - lllllllllllllIIIlIllllIllIIIlIlI.prevPosZ) * lllllllllllllIIIlIllllIlIlllllIl;
                final AxisAlignedBB lllllllllllllIIIlIllllIllIIIIllI = lllllllllllllIIIlIllllIllIIIlIlI.getEntityBoundingBox();
                RenderGlobal.drawBoundingBox(lllllllllllllIIIlIllllIllIIIIllI.minX - RenderManager.renderPosX + lllllllllllllIIIlIllllIllIIIlIIl, lllllllllllllIIIlIllllIllIIIIllI.minY - RenderManager.renderPosY + lllllllllllllIIIlIllllIllIIIlIII, lllllllllllllIIIlIllllIllIIIIllI.minZ - RenderManager.renderPosZ + lllllllllllllIIIlIllllIllIIIIlll, lllllllllllllIIIlIllllIllIIIIllI.maxX - RenderManager.renderPosX + lllllllllllllIIIlIllllIllIIIlIIl, lllllllllllllIIIlIllllIllIIIIllI.maxY - RenderManager.renderPosY + lllllllllllllIIIlIllllIllIIIlIII, lllllllllllllIIIlIllllIllIIIIllI.maxZ - RenderManager.renderPosZ + lllllllllllllIIIlIllllIllIIIIlll, 0.25f, 1.0f, 0.0f, 1.0f);
            }
        }
        if (lllllllllllllIIIlIllllIllIIlIIll instanceof EntityLivingBase) {
            final float lllllllllllllIIIlIllllIllIIIIlIl = 0.01f;
            RenderGlobal.drawBoundingBox(lllllllllllllIIIlIllllIllIIIIIII - lllllllllllllIIIlIllllIllIIIllIl, lllllllllllllIIIlIllllIlIlllllll + lllllllllllllIIIlIllllIllIIlIIll.getEyeHeight() - 0.009999999776482582, lllllllllllllIIIlIllllIlIllllllI - lllllllllllllIIIlIllllIllIIIllIl, lllllllllllllIIIlIllllIllIIIIIII + lllllllllllllIIIlIllllIllIIIllIl, lllllllllllllIIIlIllllIlIlllllll + lllllllllllllIIIlIllllIllIIlIIll.getEyeHeight() + 0.009999999776482582, lllllllllllllIIIlIllllIlIllllllI + lllllllllllllIIIlIllllIllIIIllIl, 1.0f, 0.0f, 0.0f, 1.0f);
        }
        final Tessellator lllllllllllllIIIlIllllIllIIIIlII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIlIllllIllIIIIIll = lllllllllllllIIIlIllllIllIIIIlII.getBuffer();
        final Vec3d lllllllllllllIIIlIllllIllIIIIIlI = lllllllllllllIIIlIllllIllIIlIIll.getLook(lllllllllllllIIIlIllllIlIlllllIl);
        lllllllllllllIIIlIllllIllIIIIIll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllIIIlIllllIllIIIIIll.pos(lllllllllllllIIIlIllllIllIIIIIII, lllllllllllllIIIlIllllIlIlllllll + lllllllllllllIIIlIllllIllIIlIIll.getEyeHeight(), lllllllllllllIIIlIllllIlIllllllI).color(0, 0, 255, 255).endVertex();
        lllllllllllllIIIlIllllIllIIIIIll.pos(lllllllllllllIIIlIllllIllIIIIIII + lllllllllllllIIIlIllllIllIIIIIlI.xCoord * 2.0, lllllllllllllIIIlIllllIlIlllllll + lllllllllllllIIIlIllllIllIIlIIll.getEyeHeight() + lllllllllllllIIIlIllllIllIIIIIlI.yCoord * 2.0, lllllllllllllIIIlIllllIlIllllllI + lllllllllllllIIIlIllllIllIIIIIlI.zCoord * 2.0).color(0, 0, 255, 255).endVertex();
        lllllllllllllIIIlIllllIllIIIIlII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
    }
    
    public FontRenderer getFontRenderer() {
        return this.textRenderer;
    }
    
    public void renderEntityStatic(final Entity lllllllllllllIIIlIllllIllllllIIl, final float lllllllllllllIIIlIllllIllllllIII, final boolean lllllllllllllIIIlIllllIlllllIlll) {
        if (lllllllllllllIIIlIllllIllllllIIl.ticksExisted == 0) {
            lllllllllllllIIIlIllllIllllllIIl.lastTickPosX = lllllllllllllIIIlIllllIllllllIIl.posX;
            lllllllllllllIIIlIllllIllllllIIl.lastTickPosY = lllllllllllllIIIlIllllIllllllIIl.posY;
            lllllllllllllIIIlIllllIllllllIIl.lastTickPosZ = lllllllllllllIIIlIllllIllllllIIl.posZ;
        }
        final double lllllllllllllIIIlIlllllIIIIIIIIl = lllllllllllllIIIlIllllIllllllIIl.lastTickPosX + (lllllllllllllIIIlIllllIllllllIIl.posX - lllllllllllllIIIlIllllIllllllIIl.lastTickPosX) * lllllllllllllIIIlIllllIllllllIII;
        final double lllllllllllllIIIlIlllllIIIIIIIII = lllllllllllllIIIlIllllIllllllIIl.lastTickPosY + (lllllllllllllIIIlIllllIllllllIIl.posY - lllllllllllllIIIlIllllIllllllIIl.lastTickPosY) * lllllllllllllIIIlIllllIllllllIII;
        final double lllllllllllllIIIlIllllIlllllllll = lllllllllllllIIIlIllllIllllllIIl.lastTickPosZ + (lllllllllllllIIIlIllllIllllllIIl.posZ - lllllllllllllIIIlIllllIllllllIIl.lastTickPosZ) * lllllllllllllIIIlIllllIllllllIII;
        final float lllllllllllllIIIlIllllIllllllllI = lllllllllllllIIIlIllllIllllllIIl.prevRotationYaw + (lllllllllllllIIIlIllllIllllllIIl.rotationYaw - lllllllllllllIIIlIllllIllllllIIl.prevRotationYaw) * lllllllllllllIIIlIllllIllllllIII;
        int lllllllllllllIIIlIllllIlllllllIl = lllllllllllllIIIlIllllIllllllIIl.getBrightnessForRender();
        if (lllllllllllllIIIlIllllIllllllIIl.isBurning()) {
            lllllllllllllIIIlIllllIlllllllIl = 15728880;
        }
        final int lllllllllllllIIIlIllllIlllllllII = lllllllllllllIIIlIllllIlllllllIl % 65536;
        final int lllllllllllllIIIlIllllIllllllIll = lllllllllllllIIIlIllllIlllllllIl / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllIIIlIllllIlllllllII, (float)lllllllllllllIIIlIllllIllllllIll);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.doRenderEntity(lllllllllllllIIIlIllllIllllllIIl, lllllllllllllIIIlIlllllIIIIIIIIl - RenderManager.renderPosX, lllllllllllllIIIlIlllllIIIIIIIII - RenderManager.renderPosY, lllllllllllllIIIlIllllIlllllllll - RenderManager.renderPosZ, lllllllllllllIIIlIllllIllllllllI, lllllllllllllIIIlIllllIllllllIII, lllllllllllllIIIlIllllIlllllIlll);
    }
    
    public void setRenderPosition(final double lllllllllllllIIIlIlllllIlIIIIIII, final double lllllllllllllIIIlIlllllIIlllllII, final double lllllllllllllIIIlIlllllIIllllIll) {
        RenderManager.renderPosX = lllllllllllllIIIlIlllllIlIIIIIII;
        RenderManager.renderPosY = lllllllllllllIIIlIlllllIIlllllII;
        RenderManager.renderPosZ = lllllllllllllIIIlIlllllIIllllIll;
    }
    
    public void setRenderOutlines(final boolean lllllllllllllIIIlIllllIlIlIIlllI) {
        this.renderOutlines = lllllllllllllIIIlIllllIlIlIIlllI;
    }
    
    @Nullable
    public <T extends Entity> Render<T> getEntityRenderObject(final Entity lllllllllllllIIIlIlllllIIllIlIII) {
        if (lllllllllllllIIIlIlllllIIllIlIII instanceof AbstractClientPlayer) {
            final String lllllllllllllIIIlIlllllIIllIlIll = ((AbstractClientPlayer)lllllllllllllIIIlIlllllIIllIlIII).getSkinType();
            final RenderPlayer lllllllllllllIIIlIlllllIIllIlIlI = this.skinMap.get(lllllllllllllIIIlIlllllIIllIlIll);
            return (Render<T>)((lllllllllllllIIIlIlllllIIllIlIlI != null) ? lllllllllllllIIIlIlllllIIllIlIlI : this.playerRenderer);
        }
        return this.getEntityClassRenderObject(lllllllllllllIIIlIlllllIIllIlIII.getClass());
    }
    
    public void renderMultipass(final Entity lllllllllllllIIIlIllllIllIlIlllI, final float lllllllllllllIIIlIllllIllIlllIII) {
        if (lllllllllllllIIIlIllllIllIlIlllI.ticksExisted == 0) {
            lllllllllllllIIIlIllllIllIlIlllI.lastTickPosX = lllllllllllllIIIlIllllIllIlIlllI.posX;
            lllllllllllllIIIlIllllIllIlIlllI.lastTickPosY = lllllllllllllIIIlIllllIllIlIlllI.posY;
            lllllllllllllIIIlIllllIllIlIlllI.lastTickPosZ = lllllllllllllIIIlIllllIllIlIlllI.posZ;
        }
        final double lllllllllllllIIIlIllllIllIllIlll = lllllllllllllIIIlIllllIllIlIlllI.lastTickPosX + (lllllllllllllIIIlIllllIllIlIlllI.posX - lllllllllllllIIIlIllllIllIlIlllI.lastTickPosX) * lllllllllllllIIIlIllllIllIlllIII;
        final double lllllllllllllIIIlIllllIllIllIllI = lllllllllllllIIIlIllllIllIlIlllI.lastTickPosY + (lllllllllllllIIIlIllllIllIlIlllI.posY - lllllllllllllIIIlIllllIllIlIlllI.lastTickPosY) * lllllllllllllIIIlIllllIllIlllIII;
        final double lllllllllllllIIIlIllllIllIllIlIl = lllllllllllllIIIlIllllIllIlIlllI.lastTickPosZ + (lllllllllllllIIIlIllllIllIlIlllI.posZ - lllllllllllllIIIlIllllIllIlIlllI.lastTickPosZ) * lllllllllllllIIIlIllllIllIlllIII;
        final float lllllllllllllIIIlIllllIllIllIlII = lllllllllllllIIIlIllllIllIlIlllI.prevRotationYaw + (lllllllllllllIIIlIllllIllIlIlllI.rotationYaw - lllllllllllllIIIlIllllIllIlIlllI.prevRotationYaw) * lllllllllllllIIIlIllllIllIlllIII;
        int lllllllllllllIIIlIllllIllIllIIll = lllllllllllllIIIlIllllIllIlIlllI.getBrightnessForRender();
        if (lllllllllllllIIIlIllllIllIlIlllI.isBurning()) {
            lllllllllllllIIIlIllllIllIllIIll = 15728880;
        }
        final int lllllllllllllIIIlIllllIllIllIIlI = lllllllllllllIIIlIllllIllIllIIll % 65536;
        final int lllllllllllllIIIlIllllIllIllIIIl = lllllllllllllIIIlIllllIllIllIIll / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllIIIlIllllIllIllIIlI, (float)lllllllllllllIIIlIllllIllIllIIIl);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final Render<Entity> lllllllllllllIIIlIllllIllIllIIII = this.getEntityRenderObject(lllllllllllllIIIlIllllIllIlIlllI);
        if (lllllllllllllIIIlIllllIllIllIIII != null && this.renderEngine != null) {
            lllllllllllllIIIlIllllIllIllIIII.renderMultipass(lllllllllllllIIIlIllllIllIlIlllI, lllllllllllllIIIlIllllIllIllIlll - RenderManager.renderPosX, lllllllllllllIIIlIllllIllIllIllI - RenderManager.renderPosY, lllllllllllllIIIlIllllIllIllIlIl - RenderManager.renderPosZ, lllllllllllllIIIlIllllIllIllIlII, lllllllllllllIIIlIllllIllIlllIII);
        }
    }
}
