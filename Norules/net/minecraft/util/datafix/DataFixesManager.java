package net.minecraft.util.datafix;

import net.minecraft.world.storage.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.item.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.datafix.fixes.*;
import net.minecraft.nbt.*;

public class DataFixesManager
{
    public static NBTTagCompound processItemStack(final IDataFixer llllllllllllllllIllIlIIIIIlIllIl, final NBTTagCompound llllllllllllllllIllIlIIIIIllIIII, final int llllllllllllllllIllIlIIIIIlIlIll, final String llllllllllllllllIllIlIIIIIlIlllI) {
        if (llllllllllllllllIllIlIIIIIllIIII.hasKey(llllllllllllllllIllIlIIIIIlIlllI, 10)) {
            llllllllllllllllIllIlIIIIIllIIII.setTag(llllllllllllllllIllIlIIIIIlIlllI, llllllllllllllllIllIlIIIIIlIllIl.process(FixTypes.ITEM_INSTANCE, llllllllllllllllIllIlIIIIIllIIII.getCompoundTag(llllllllllllllllIllIlIIIIIlIlllI), llllllllllllllllIllIlIIIIIlIlIll));
        }
        return llllllllllllllllIllIlIIIIIllIIII;
    }
    
    public static DataFixer createFixer() {
        final DataFixer llllllllllllllllIllIlIIIIIllIlll = new DataFixer(1343);
        WorldInfo.registerFixes(llllllllllllllllIllIlIIIIIllIlll);
        EntityPlayerMP.func_191522_a(llllllllllllllllIllIlIIIIIllIlll);
        EntityPlayer.registerFixesPlayer(llllllllllllllllIllIlIIIIIllIlll);
        AnvilChunkLoader.registerFixes(llllllllllllllllIllIlIIIIIllIlll);
        ItemStack.registerFixes(llllllllllllllllIllIlIIIIIllIlll);
        Template.func_191158_a(llllllllllllllllIllIlIIIIIllIlll);
        Entity.func_190533_a(llllllllllllllllIllIlIIIIIllIlll);
        EntityArmorStand.registerFixesArmorStand(llllllllllllllllIllIlIIIIIllIlll);
        EntityArrow.registerFixesArrow(llllllllllllllllIllIlIIIIIllIlll);
        EntityBat.registerFixesBat(llllllllllllllllIllIlIIIIIllIlll);
        EntityBlaze.registerFixesBlaze(llllllllllllllllIllIlIIIIIllIlll);
        EntityCaveSpider.registerFixesCaveSpider(llllllllllllllllIllIlIIIIIllIlll);
        EntityChicken.registerFixesChicken(llllllllllllllllIllIlIIIIIllIlll);
        EntityCow.registerFixesCow(llllllllllllllllIllIlIIIIIllIlll);
        EntityCreeper.registerFixesCreeper(llllllllllllllllIllIlIIIIIllIlll);
        EntityDonkey.func_190699_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityDragonFireball.registerFixesDragonFireball(llllllllllllllllIllIlIIIIIllIlll);
        EntityElderGuardian.func_190768_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityDragon.registerFixesDragon(llllllllllllllllIllIlIIIIIllIlll);
        EntityEnderman.registerFixesEnderman(llllllllllllllllIllIlIIIIIllIlll);
        EntityEndermite.registerFixesEndermite(llllllllllllllllIllIlIIIIIllIlll);
        EntityEvoker.func_190759_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityFallingBlock.registerFixesFallingBlock(llllllllllllllllIllIlIIIIIllIlll);
        EntityFireworkRocket.registerFixesFireworkRocket(llllllllllllllllIllIlIIIIIllIlll);
        EntityGhast.registerFixesGhast(llllllllllllllllIllIlIIIIIllIlll);
        EntityGiantZombie.registerFixesGiantZombie(llllllllllllllllIllIlIIIIIllIlll);
        EntityGuardian.registerFixesGuardian(llllllllllllllllIllIlIIIIIllIlll);
        EntityHorse.registerFixesHorse(llllllllllllllllIllIlIIIIIllIlll);
        EntityHusk.func_190740_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityItem.registerFixesItem(llllllllllllllllIllIlIIIIIllIlll);
        EntityItemFrame.registerFixesItemFrame(llllllllllllllllIllIlIIIIIllIlll);
        EntityLargeFireball.registerFixesLargeFireball(llllllllllllllllIllIlIIIIIllIlll);
        EntityMagmaCube.registerFixesMagmaCube(llllllllllllllllIllIlIIIIIllIlll);
        EntityMinecartChest.registerFixesMinecartChest(llllllllllllllllIllIlIIIIIllIlll);
        EntityMinecartCommandBlock.registerFixesMinecartCommand(llllllllllllllllIllIlIIIIIllIlll);
        EntityMinecartFurnace.registerFixesMinecartFurnace(llllllllllllllllIllIlIIIIIllIlll);
        EntityMinecartHopper.registerFixesMinecartHopper(llllllllllllllllIllIlIIIIIllIlll);
        EntityMinecartEmpty.registerFixesMinecartEmpty(llllllllllllllllIllIlIIIIIllIlll);
        EntityMinecartMobSpawner.registerFixesMinecartMobSpawner(llllllllllllllllIllIlIIIIIllIlll);
        EntityMinecartTNT.registerFixesMinecartTNT(llllllllllllllllIllIlIIIIIllIlll);
        EntityMule.func_190700_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityMooshroom.registerFixesMooshroom(llllllllllllllllIllIlIIIIIllIlll);
        EntityOcelot.registerFixesOcelot(llllllllllllllllIllIlIIIIIllIlll);
        EntityPig.registerFixesPig(llllllllllllllllIllIlIIIIIllIlll);
        EntityPigZombie.registerFixesPigZombie(llllllllllllllllIllIlIIIIIllIlll);
        EntityRabbit.registerFixesRabbit(llllllllllllllllIllIlIIIIIllIlll);
        EntitySheep.registerFixesSheep(llllllllllllllllIllIlIIIIIllIlll);
        EntityShulker.registerFixesShulker(llllllllllllllllIllIlIIIIIllIlll);
        EntitySilverfish.registerFixesSilverfish(llllllllllllllllIllIlIIIIIllIlll);
        EntitySkeleton.registerFixesSkeleton(llllllllllllllllIllIlIIIIIllIlll);
        EntitySkeletonHorse.func_190692_b(llllllllllllllllIllIlIIIIIllIlll);
        EntitySlime.registerFixesSlime(llllllllllllllllIllIlIIIIIllIlll);
        EntitySmallFireball.registerFixesSmallFireball(llllllllllllllllIllIlIIIIIllIlll);
        EntitySnowman.registerFixesSnowman(llllllllllllllllIllIlIIIIIllIlll);
        EntitySnowball.registerFixesSnowball(llllllllllllllllIllIlIIIIIllIlll);
        EntitySpectralArrow.registerFixesSpectralArrow(llllllllllllllllIllIlIIIIIllIlll);
        EntitySpider.registerFixesSpider(llllllllllllllllIllIlIIIIIllIlll);
        EntitySquid.registerFixesSquid(llllllllllllllllIllIlIIIIIllIlll);
        EntityStray.func_190728_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityEgg.registerFixesEgg(llllllllllllllllIllIlIIIIIllIlll);
        EntityEnderPearl.registerFixesEnderPearl(llllllllllllllllIllIlIIIIIllIlll);
        EntityExpBottle.registerFixesExpBottle(llllllllllllllllIllIlIIIIIllIlll);
        EntityPotion.registerFixesPotion(llllllllllllllllIllIlIIIIIllIlll);
        EntityTippedArrow.registerFixesTippedArrow(llllllllllllllllIllIlIIIIIllIlll);
        EntityVex.func_190663_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityVillager.registerFixesVillager(llllllllllllllllIllIlIIIIIllIlll);
        EntityIronGolem.registerFixesIronGolem(llllllllllllllllIllIlIIIIIllIlll);
        EntityVindicator.func_190641_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityWitch.registerFixesWitch(llllllllllllllllIllIlIIIIIllIlll);
        EntityWither.registerFixesWither(llllllllllllllllIllIlIIIIIllIlll);
        EntityWitherSkeleton.func_190729_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityWitherSkull.registerFixesWitherSkull(llllllllllllllllIllIlIIIIIllIlll);
        EntityWolf.registerFixesWolf(llllllllllllllllIllIlIIIIIllIlll);
        EntityZombie.registerFixesZombie(llllllllllllllllIllIlIIIIIllIlll);
        EntityZombieHorse.func_190693_b(llllllllllllllllIllIlIIIIIllIlll);
        EntityZombieVillager.func_190737_b(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityPiston.registerFixesPiston(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityFlowerPot.registerFixesFlowerPot(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityFurnace.registerFixesFurnace(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityChest.registerFixesChest(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityDispenser.registerFixes(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityDropper.registerFixesDropper(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityBrewingStand.registerFixesBrewingStand(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityHopper.registerFixesHopper(llllllllllllllllIllIlIIIIIllIlll);
        BlockJukebox.registerFixesJukebox(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityMobSpawner.registerFixesMobSpawner(llllllllllllllllIllIlIIIIIllIlll);
        TileEntityShulkerBox.func_190593_a(llllllllllllllllIllIlIIIIIllIlll);
        registerFixes(llllllllllllllllIllIlIIIIIllIlll);
        return llllllllllllllllIllIlIIIIIllIlll;
    }
    
    private static void registerFixes(final DataFixer llllllllllllllllIllIlIIIIIlllIlI) {
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new EntityArmorAndHeld());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.BLOCK_ENTITY, new SignStrictJSON());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new ItemIntIDToString());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new PotionItems());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new SpawnEggNames());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new MinecartEntityTypes());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.BLOCK_ENTITY, new SpawnerEntityTypes());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new StringToUUID());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new EntityHealth());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new HorseSaddle());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new PaintingDirection());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new RedundantChanceTags());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new RidingToPassengers());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new ArmorStandSilent());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new BookPagesStrictJSON());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new CookedFishIDTypo());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new ZombieProfToType());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.OPTIONS, new ForceVBOOn());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new ElderGuardianSplit());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new SkeletonSplit());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new ZombieSplit());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new HorseSplit());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.BLOCK_ENTITY, new TileEntityId());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new EntityId());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new BannerItemColor());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new PotionWater());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ENTITY, new ShulkerBoxEntityColor());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new ShulkerBoxItemColor());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.BLOCK_ENTITY, new ShulkerBoxTileColor());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.OPTIONS, new OptionsLowerCaseLanguage());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new TotemItemRename());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.CHUNK, new AddBedTileEntity());
        llllllllllllllllIllIlIIIIIlllIlI.registerFix(FixTypes.ITEM_INSTANCE, new BedItemColor());
    }
    
    public static NBTTagCompound processInventory(final IDataFixer llllllllllllllllIllIlIIIIIlIIIll, final NBTTagCompound llllllllllllllllIllIlIIIIIIlllII, final int llllllllllllllllIllIlIIIIIlIIIIl, final String llllllllllllllllIllIlIIIIIlIIIII) {
        if (llllllllllllllllIllIlIIIIIIlllII.hasKey(llllllllllllllllIllIlIIIIIlIIIII, 9)) {
            final NBTTagList llllllllllllllllIllIlIIIIIIlllll = llllllllllllllllIllIlIIIIIIlllII.getTagList(llllllllllllllllIllIlIIIIIlIIIII, 10);
            for (int llllllllllllllllIllIlIIIIIIllllI = 0; llllllllllllllllIllIlIIIIIIllllI < llllllllllllllllIllIlIIIIIIlllll.tagCount(); ++llllllllllllllllIllIlIIIIIIllllI) {
                llllllllllllllllIllIlIIIIIIlllll.set(llllllllllllllllIllIlIIIIIIllllI, llllllllllllllllIllIlIIIIIlIIIll.process(FixTypes.ITEM_INSTANCE, llllllllllllllllIllIlIIIIIIlllll.getCompoundTagAt(llllllllllllllllIllIlIIIIIIllllI), llllllllllllllllIllIlIIIIIlIIIIl));
            }
        }
        return llllllllllllllllIllIlIIIIIIlllII;
    }
}
