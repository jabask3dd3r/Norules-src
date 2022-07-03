package net.minecraft.init;

import org.apache.logging.log4j.*;
import net.minecraft.enchantment.*;
import net.minecraft.potion.*;
import net.minecraft.world.biome.*;
import net.minecraft.item.crafting.*;
import net.minecraft.stats.*;
import net.minecraft.advancements.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.*;
import net.minecraft.dispenser.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.item.*;
import com.mojang.authlib.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;
import net.minecraft.server.*;
import java.io.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;

public class Bootstrap
{
    public static final /* synthetic */ PrintStream SYSOUT;
    public static /* synthetic */ boolean field_194219_b;
    private static final /* synthetic */ Logger LOGGER;
    private static /* synthetic */ boolean alreadyRegistered;
    
    static {
        SYSOUT = System.out;
        LOGGER = LogManager.getLogger();
    }
    
    public static boolean isRegistered() {
        return Bootstrap.alreadyRegistered;
    }
    
    public static void register() {
        if (!Bootstrap.alreadyRegistered) {
            Bootstrap.alreadyRegistered = true;
            redirectOutputToLog();
            SoundEvent.registerSounds();
            Block.registerBlocks();
            BlockFire.init();
            Potion.registerPotions();
            Enchantment.registerEnchantments();
            Item.registerItems();
            PotionType.registerPotionTypes();
            PotionHelper.init();
            EntityList.init();
            Biome.registerBiomes();
            registerDispenserBehaviors();
            if (!CraftingManager.func_193377_a()) {
                Bootstrap.field_194219_b = true;
                Bootstrap.LOGGER.error("Errors with built-in recipes!");
            }
            StatList.init();
            if (Bootstrap.LOGGER.isDebugEnabled()) {
                if (new AdvancementManager(null).func_193767_b()) {
                    Bootstrap.field_194219_b = true;
                    Bootstrap.LOGGER.error("Errors with built-in advancements!");
                }
                if (!LootTableList.func_193579_b()) {
                    Bootstrap.field_194219_b = true;
                    Bootstrap.LOGGER.error("Errors with built-in loot tables");
                }
            }
        }
    }
    
    public static void printToSYSOUT(final String lllllllllllllllllIlllIlIlIlIIlll) {
        Bootstrap.SYSOUT.println(lllllllllllllllllIlllIlIlIlIIlll);
    }
    
    static void registerDispenserBehaviors() {
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.ARROW, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World lllllllllllllIlllllllIllIlIlIIll, final IPosition lllllllllllllIlllllllIllIlIIlllI, final ItemStack lllllllllllllIlllllllIllIlIlIIIl) {
                final EntityTippedArrow lllllllllllllIlllllllIllIlIlIIII = new EntityTippedArrow(lllllllllllllIlllllllIllIlIlIIll, lllllllllllllIlllllllIllIlIIlllI.getX(), lllllllllllllIlllllllIllIlIIlllI.getY(), lllllllllllllIlllllllIllIlIIlllI.getZ());
                lllllllllllllIlllllllIllIlIlIIII.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
                return lllllllllllllIlllllllIllIlIlIIII;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.TIPPED_ARROW, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World lllllllllllllIIlllIlllIIlllllIIl, final IPosition lllllllllllllIIlllIlllIIllllllII, final ItemStack lllllllllllllIIlllIlllIIllllIlll) {
                final EntityTippedArrow lllllllllllllIIlllIlllIIlllllIlI = new EntityTippedArrow(lllllllllllllIIlllIlllIIlllllIIl, lllllllllllllIIlllIlllIIllllllII.getX(), lllllllllllllIIlllIlllIIllllllII.getY(), lllllllllllllIIlllIlllIIllllllII.getZ());
                lllllllllllllIIlllIlllIIlllllIlI.setPotionEffect(lllllllllllllIIlllIlllIIllllIlll);
                lllllllllllllIIlllIlllIIlllllIlI.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
                return lllllllllllllIIlllIlllIIlllllIlI;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SPECTRAL_ARROW, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World lllllllllllllIIIIIIIIIllIlIlIIlI, final IPosition lllllllllllllIIIIIIIIIllIlIlIIIl, final ItemStack lllllllllllllIIIIIIIIIllIlIlIIII) {
                final EntityArrow lllllllllllllIIIIIIIIIllIlIIllll = new EntitySpectralArrow(lllllllllllllIIIIIIIIIllIlIlIIlI, lllllllllllllIIIIIIIIIllIlIlIIIl.getX(), lllllllllllllIIIIIIIIIllIlIlIIIl.getY(), lllllllllllllIIIIIIIIIllIlIlIIIl.getZ());
                lllllllllllllIIIIIIIIIllIlIIllll.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
                return lllllllllllllIIIIIIIIIllIlIIllll;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.EGG, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World lllllllllllllIIllllIIIllIllIIlll, final IPosition lllllllllllllIIllllIIIllIllIIIll, final ItemStack lllllllllllllIIllllIIIllIllIIlIl) {
                return new EntityEgg(lllllllllllllIIllllIIIllIllIIlll, lllllllllllllIIllllIIIllIllIIIll.getX(), lllllllllllllIIllllIIIllIllIIIll.getY(), lllllllllllllIIllllIIIllIllIIIll.getZ());
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SNOWBALL, new BehaviorProjectileDispense() {
            @Override
            protected IProjectile getProjectileEntity(final World lllllllllllllIlllllllllIIlIIlIll, final IPosition lllllllllllllIlllllllllIIlIIllIl, final ItemStack lllllllllllllIlllllllllIIlIIllII) {
                return new EntitySnowball(lllllllllllllIlllllllllIIlIIlIll, lllllllllllllIlllllllllIIlIIllIl.getX(), lllllllllllllIlllllllllIIlIIllIl.getY(), lllllllllllllIlllllllllIIlIIllIl.getZ());
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.EXPERIENCE_BOTTLE, new BehaviorProjectileDispense() {
            @Override
            protected float getProjectileVelocity() {
                return super.getProjectileVelocity() * 1.25f;
            }
            
            @Override
            protected IProjectile getProjectileEntity(final World lllllllllllllllIIIlllllIIllIlIlI, final IPosition lllllllllllllllIIIlllllIIllIlIIl, final ItemStack lllllllllllllllIIIlllllIIllIlIII) {
                return new EntityExpBottle(lllllllllllllllIIIlllllIIllIlIlI, lllllllllllllllIIIlllllIIllIlIIl.getX(), lllllllllllllllIIIlllllIIllIlIIl.getY(), lllllllllllllllIIIlllllIIllIlIIl.getZ());
            }
            
            @Override
            protected float getProjectileInaccuracy() {
                return super.getProjectileInaccuracy() * 0.5f;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SPLASH_POTION, new IBehaviorDispenseItem() {
            @Override
            public ItemStack dispense(final IBlockSource lllllllllllllIIIIIlIlllIllllllIl, final ItemStack lllllllllllllIIIIIlIlllIllllllll) {
                return new BehaviorProjectileDispense() {
                    @Override
                    protected float getProjectileVelocity() {
                        return super.getProjectileVelocity() * 1.25f;
                    }
                    
                    @Override
                    protected float getProjectileInaccuracy() {
                        return super.getProjectileInaccuracy() * 0.5f;
                    }
                    
                    @Override
                    protected IProjectile getProjectileEntity(final World llllllllllllllIlIlIIllIlIlllllIl, final IPosition llllllllllllllIlIlIIllIlIllllIII, final ItemStack llllllllllllllIlIlIIllIlIllllIll) {
                        return new EntityPotion(llllllllllllllIlIlIIllIlIlllllIl, llllllllllllllIlIlIIllIlIllllIII.getX(), llllllllllllllIlIlIIllIlIllllIII.getY(), llllllllllllllIlIlIIllIlIllllIII.getZ(), lllllllllllllIIIIIlIlllIllllllll.copy());
                    }
                }.dispense(lllllllllllllIIIIIlIlllIllllllIl, lllllllllllllIIIIIlIlllIllllllll);
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.LINGERING_POTION, new IBehaviorDispenseItem() {
            @Override
            public ItemStack dispense(final IBlockSource lllllllllllllllIIllIllllllIIlllI, final ItemStack lllllllllllllllIIllIllllllIIllIl) {
                return new BehaviorProjectileDispense() {
                    @Override
                    protected IProjectile getProjectileEntity(final World lllllllllllllllIIIIlllIIllIlIlll, final IPosition lllllllllllllllIIIIlllIIllIIllIl, final ItemStack lllllllllllllllIIIIlllIIllIlIIll) {
                        return new EntityPotion(lllllllllllllllIIIIlllIIllIlIlll, lllllllllllllllIIIIlllIIllIIllIl.getX(), lllllllllllllllIIIIlllIIllIIllIl.getY(), lllllllllllllllIIIIlllIIllIIllIl.getZ(), lllllllllllllllIIllIllllllIIllIl.copy());
                    }
                    
                    @Override
                    protected float getProjectileVelocity() {
                        return super.getProjectileVelocity() * 1.25f;
                    }
                    
                    @Override
                    protected float getProjectileInaccuracy() {
                        return super.getProjectileInaccuracy() * 0.5f;
                    }
                }.dispense(lllllllllllllllIIllIllllllIIlllI, lllllllllllllllIIllIllllllIIllIl);
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SPAWN_EGG, new BehaviorDefaultDispenseItem() {
            public ItemStack dispenseStack(final IBlockSource llllllllllllllIIlllllIlIllIlIlll, final ItemStack llllllllllllllIIlllllIlIllIlIllI) {
                final EnumFacing llllllllllllllIIlllllIlIllIlIlIl = llllllllllllllIIlllllIlIllIlIlll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final double llllllllllllllIIlllllIlIllIlIlII = llllllllllllllIIlllllIlIllIlIlll.getX() + llllllllllllllIIlllllIlIllIlIlIl.getFrontOffsetX();
                final double llllllllllllllIIlllllIlIllIlIIll = llllllllllllllIIlllllIlIllIlIlll.getBlockPos().getY() + llllllllllllllIIlllllIlIllIlIlIl.getFrontOffsetY() + 0.2f;
                final double llllllllllllllIIlllllIlIllIlIIlI = llllllllllllllIIlllllIlIllIlIlll.getZ() + llllllllllllllIIlllllIlIllIlIlIl.getFrontOffsetZ();
                final Entity llllllllllllllIIlllllIlIllIlIIIl = ItemMonsterPlacer.spawnCreature(llllllllllllllIIlllllIlIllIlIlll.getWorld(), ItemMonsterPlacer.func_190908_h(llllllllllllllIIlllllIlIllIlIllI), llllllllllllllIIlllllIlIllIlIlII, llllllllllllllIIlllllIlIllIlIIll, llllllllllllllIIlllllIlIllIlIIlI);
                if (llllllllllllllIIlllllIlIllIlIIIl instanceof EntityLivingBase && llllllllllllllIIlllllIlIllIlIllI.hasDisplayName()) {
                    llllllllllllllIIlllllIlIllIlIIIl.setCustomNameTag(llllllllllllllIIlllllIlIllIlIllI.getDisplayName());
                }
                ItemMonsterPlacer.applyItemEntityDataToEntity(llllllllllllllIIlllllIlIllIlIlll.getWorld(), null, llllllllllllllIIlllllIlIllIlIllI, llllllllllllllIIlllllIlIllIlIIIl);
                llllllllllllllIIlllllIlIllIlIllI.func_190918_g(1);
                return llllllllllllllIIlllllIlIllIlIllI;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.FIREWORKS, new BehaviorDefaultDispenseItem() {
            @Override
            protected void playDispenseSound(final IBlockSource lllllllllllllIIlIlIlIlllIIlIlIll) {
                lllllllllllllIIlIlIlIlllIIlIlIll.getWorld().playEvent(1004, lllllllllllllIIlIlIlIlllIIlIlIll.getBlockPos(), 0);
            }
            
            public ItemStack dispenseStack(final IBlockSource lllllllllllllIIlIlIlIlllIIllIlIl, final ItemStack lllllllllllllIIlIlIlIlllIIllIlII) {
                final EnumFacing lllllllllllllIIlIlIlIlllIIlllIlI = lllllllllllllIIlIlIlIlllIIllIlIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final double lllllllllllllIIlIlIlIlllIIlllIIl = lllllllllllllIIlIlIlIlllIIllIlIl.getX() + lllllllllllllIIlIlIlIlllIIlllIlI.getFrontOffsetX();
                final double lllllllllllllIIlIlIlIlllIIlllIII = lllllllllllllIIlIlIlIlllIIllIlIl.getBlockPos().getY() + 0.2f;
                final double lllllllllllllIIlIlIlIlllIIllIlll = lllllllllllllIIlIlIlIlllIIllIlIl.getZ() + lllllllllllllIIlIlIlIlllIIlllIlI.getFrontOffsetZ();
                final EntityFireworkRocket lllllllllllllIIlIlIlIlllIIllIllI = new EntityFireworkRocket(lllllllllllllIIlIlIlIlllIIllIlIl.getWorld(), lllllllllllllIIlIlIlIlllIIlllIIl, lllllllllllllIIlIlIlIlllIIlllIII, lllllllllllllIIlIlIlIlllIIllIlll, lllllllllllllIIlIlIlIlllIIllIlII);
                lllllllllllllIIlIlIlIlllIIllIlIl.getWorld().spawnEntityInWorld(lllllllllllllIIlIlIlIlllIIllIllI);
                lllllllllllllIIlIlIlIlllIIllIlII.func_190918_g(1);
                return lllllllllllllIIlIlIlIlllIIllIlII;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.FIRE_CHARGE, new BehaviorDefaultDispenseItem() {
            public ItemStack dispenseStack(final IBlockSource llllllllllllllIIlIIIIIIIllIIllII, final ItemStack llllllllllllllIIlIIIIIIIllIllIlI) {
                final EnumFacing llllllllllllllIIlIIIIIIIllIllIIl = llllllllllllllIIlIIIIIIIllIIllII.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final IPosition llllllllllllllIIlIIIIIIIllIllIII = BlockDispenser.getDispensePosition(llllllllllllllIIlIIIIIIIllIIllII);
                final double llllllllllllllIIlIIIIIIIllIlIlll = llllllllllllllIIlIIIIIIIllIllIII.getX() + llllllllllllllIIlIIIIIIIllIllIIl.getFrontOffsetX() * 0.3f;
                final double llllllllllllllIIlIIIIIIIllIlIllI = llllllllllllllIIlIIIIIIIllIllIII.getY() + llllllllllllllIIlIIIIIIIllIllIIl.getFrontOffsetY() * 0.3f;
                final double llllllllllllllIIlIIIIIIIllIlIlIl = llllllllllllllIIlIIIIIIIllIllIII.getZ() + llllllllllllllIIlIIIIIIIllIllIIl.getFrontOffsetZ() * 0.3f;
                final World llllllllllllllIIlIIIIIIIllIlIlII = llllllllllllllIIlIIIIIIIllIIllII.getWorld();
                final Random llllllllllllllIIlIIIIIIIllIlIIlI = llllllllllllllIIlIIIIIIIllIlIlII.rand;
                final double llllllllllllllIIlIIIIIIIllIlIIIl = llllllllllllllIIlIIIIIIIllIlIIlI.nextGaussian() * 0.05 + llllllllllllllIIlIIIIIIIllIllIIl.getFrontOffsetX();
                final double llllllllllllllIIlIIIIIIIllIIllll = llllllllllllllIIlIIIIIIIllIlIIlI.nextGaussian() * 0.05 + llllllllllllllIIlIIIIIIIllIllIIl.getFrontOffsetY();
                final double llllllllllllllIIlIIIIIIIllIIlllI = llllllllllllllIIlIIIIIIIllIlIIlI.nextGaussian() * 0.05 + llllllllllllllIIlIIIIIIIllIllIIl.getFrontOffsetZ();
                llllllllllllllIIlIIIIIIIllIlIlII.spawnEntityInWorld(new EntitySmallFireball(llllllllllllllIIlIIIIIIIllIlIlII, llllllllllllllIIlIIIIIIIllIlIlll, llllllllllllllIIlIIIIIIIllIlIllI, llllllllllllllIIlIIIIIIIllIlIlIl, llllllllllllllIIlIIIIIIIllIlIIIl, llllllllllllllIIlIIIIIIIllIIllll, llllllllllllllIIlIIIIIIIllIIlllI));
                llllllllllllllIIlIIIIIIIllIllIlI.func_190918_g(1);
                return llllllllllllllIIlIIIIIIIllIllIlI;
            }
            
            @Override
            protected void playDispenseSound(final IBlockSource llllllllllllllIIlIIIIIIIlIllIllI) {
                llllllllllllllIIlIIIIIIIlIllIllI.getWorld().playEvent(1018, llllllllllllllIIlIIIIIIIlIllIllI.getBlockPos(), 0);
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.BOAT, new BehaviorDispenseBoat(EntityBoat.Type.OAK));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SPRUCE_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.SPRUCE));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.BIRCH_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.BIRCH));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.JUNGLE_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.JUNGLE));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.DARK_OAK_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.DARK_OAK));
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.ACACIA_BOAT, new BehaviorDispenseBoat(EntityBoat.Type.ACACIA));
        final IBehaviorDispenseItem lllllllllllllllllIlllIlIlIlllIII = new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem dispenseBehavior = new BehaviorDefaultDispenseItem();
            
            public ItemStack dispenseStack(final IBlockSource lllllllllllllIlllllIIIlllllIIIlI, final ItemStack lllllllllllllIlllllIIIllllIlIlll) {
                final ItemBucket lllllllllllllIlllllIIIllllIllllI = (ItemBucket)lllllllllllllIlllllIIIllllIlIlll.getItem();
                final BlockPos lllllllllllllIlllllIIIllllIlllIl = lllllllllllllIlllllIIIlllllIIIlI.getBlockPos().offset(lllllllllllllIlllllIIIlllllIIIlI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                return lllllllllllllIlllllIIIllllIllllI.tryPlaceContainedLiquid(null, lllllllllllllIlllllIIIlllllIIIlI.getWorld(), lllllllllllllIlllllIIIllllIlllIl) ? new ItemStack(Items.BUCKET) : this.dispenseBehavior.dispense(lllllllllllllIlllllIIIlllllIIIlI, lllllllllllllIlllllIIIllllIlIlll);
            }
        };
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.LAVA_BUCKET, lllllllllllllllllIlllIlIlIlllIII);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.WATER_BUCKET, lllllllllllllllllIlllIlIlIlllIII);
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.BUCKET, new BehaviorDefaultDispenseItem() {
            private final /* synthetic */ BehaviorDefaultDispenseItem dispenseBehavior = new BehaviorDefaultDispenseItem();
            
            public ItemStack dispenseStack(final IBlockSource lllllllllllllIIIlIIIIIIIIlIIIlll, final ItemStack lllllllllllllIIIlIIIIIIIIIllllII) {
                final World lllllllllllllIIIlIIIIIIIIlIIIlIl = lllllllllllllIIIlIIIIIIIIlIIIlll.getWorld();
                final BlockPos lllllllllllllIIIlIIIIIIIIlIIIlII = lllllllllllllIIIlIIIIIIIIlIIIlll.getBlockPos().offset(lllllllllllllIIIlIIIIIIIIlIIIlll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                final IBlockState lllllllllllllIIIlIIIIIIIIlIIIIll = lllllllllllllIIIlIIIIIIIIlIIIlIl.getBlockState(lllllllllllllIIIlIIIIIIIIlIIIlII);
                final Block lllllllllllllIIIlIIIIIIIIlIIIIlI = lllllllllllllIIIlIIIIIIIIlIIIIll.getBlock();
                final Material lllllllllllllIIIlIIIIIIIIlIIIIIl = lllllllllllllIIIlIIIIIIIIlIIIIll.getMaterial();
                Item lllllllllllllIIIlIIIIIIIIIllllll = null;
                if (Material.WATER.equals(lllllllllllllIIIlIIIIIIIIlIIIIIl) && lllllllllllllIIIlIIIIIIIIlIIIIlI instanceof BlockLiquid && lllllllllllllIIIlIIIIIIIIlIIIIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0) {
                    final Item lllllllllllllIIIlIIIIIIIIlIIIIII = Items.WATER_BUCKET;
                }
                else {
                    if (!Material.LAVA.equals(lllllllllllllIIIlIIIIIIIIlIIIIIl) || !(lllllllllllllIIIlIIIIIIIIlIIIIlI instanceof BlockLiquid) || lllllllllllllIIIlIIIIIIIIlIIIIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL) != 0) {
                        return super.dispenseStack(lllllllllllllIIIlIIIIIIIIlIIIlll, lllllllllllllIIIlIIIIIIIIIllllII);
                    }
                    lllllllllllllIIIlIIIIIIIIIllllll = Items.LAVA_BUCKET;
                }
                lllllllllllllIIIlIIIIIIIIlIIIlIl.setBlockToAir(lllllllllllllIIIlIIIIIIIIlIIIlII);
                lllllllllllllIIIlIIIIIIIIIllllII.func_190918_g(1);
                if (lllllllllllllIIIlIIIIIIIIIllllII.func_190926_b()) {
                    return new ItemStack(lllllllllllllIIIlIIIIIIIIIllllll);
                }
                if (lllllllllllllIIIlIIIIIIIIlIIIlll.getBlockTileEntity().addItemStack(new ItemStack(lllllllllllllIIIlIIIIIIIIIllllll)) < 0) {
                    this.dispenseBehavior.dispense(lllllllllllllIIIlIIIIIIIIlIIIlll, new ItemStack(lllllllllllllIIIlIIIIIIIIIllllll));
                }
                return lllllllllllllIIIlIIIIIIIIIllllII;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.FLINT_AND_STEEL, new BehaviorDispenseOptional() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllllIIlIllIIIllIIlllIlI, final ItemStack lllllllllllllIIlIllIIIllIIlllIIl) {
                final World lllllllllllllIIlIllIIIllIIlllIII = lllllllllllllIIlIllIIIllIIlllIlI.getWorld();
                this.field_190911_b = true;
                final BlockPos lllllllllllllIIlIllIIIllIIllIlll = lllllllllllllIIlIllIIIllIIlllIlI.getBlockPos().offset(lllllllllllllIIlIllIIIllIIlllIlI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                if (lllllllllllllIIlIllIIIllIIlllIII.isAirBlock(lllllllllllllIIlIllIIIllIIllIlll)) {
                    lllllllllllllIIlIllIIIllIIlllIII.setBlockState(lllllllllllllIIlIllIIIllIIllIlll, Blocks.FIRE.getDefaultState());
                    if (lllllllllllllIIlIllIIIllIIlllIIl.attemptDamageItem(1, lllllllllllllIIlIllIIIllIIlllIII.rand, null)) {
                        lllllllllllllIIlIllIIIllIIlllIIl.func_190920_e(0);
                    }
                }
                else if (lllllllllllllIIlIllIIIllIIlllIII.getBlockState(lllllllllllllIIlIllIIIllIIllIlll).getBlock() == Blocks.TNT) {
                    Blocks.TNT.onBlockDestroyedByPlayer(lllllllllllllIIlIllIIIllIIlllIII, lllllllllllllIIlIllIIIllIIllIlll, Blocks.TNT.getDefaultState().withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true));
                    lllllllllllllIIlIllIIIllIIlllIII.setBlockToAir(lllllllllllllIIlIllIIIllIIllIlll);
                }
                else {
                    this.field_190911_b = false;
                }
                return lllllllllllllIIlIllIIIllIIlllIIl;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.DYE, new BehaviorDispenseOptional() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource llllllllllllllIllIlllIIIllIIllIl, final ItemStack llllllllllllllIllIlllIIIllIIllII) {
                this.field_190911_b = true;
                if (EnumDyeColor.WHITE == EnumDyeColor.byDyeDamage(llllllllllllllIllIlllIIIllIIllII.getMetadata())) {
                    final World llllllllllllllIllIlllIIIllIlIIII = llllllllllllllIllIlllIIIllIIllIl.getWorld();
                    final BlockPos llllllllllllllIllIlllIIIllIIllll = llllllllllllllIllIlllIIIllIIllIl.getBlockPos().offset(llllllllllllllIllIlllIIIllIIllIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                    if (ItemDye.applyBonemeal(llllllllllllllIllIlllIIIllIIllII, llllllllllllllIllIlllIIIllIlIIII, llllllllllllllIllIlllIIIllIIllll)) {
                        if (!llllllllllllllIllIlllIIIllIlIIII.isRemote) {
                            llllllllllllllIllIlllIIIllIlIIII.playEvent(2005, llllllllllllllIllIlllIIIllIIllll, 0);
                        }
                    }
                    else {
                        this.field_190911_b = false;
                    }
                    return llllllllllllllIllIlllIIIllIIllII;
                }
                return super.dispenseStack(llllllllllllllIllIlllIIIllIIllIl, llllllllllllllIllIlllIIIllIIllII);
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item.getItemFromBlock(Blocks.TNT), new BehaviorDefaultDispenseItem() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllllllIllIlIlllllllIIIl, final ItemStack lllllllllllllllIllIlIllllllIllll) {
                final World lllllllllllllllIllIlIllllllIlllI = lllllllllllllllIllIlIlllllllIIIl.getWorld();
                final BlockPos lllllllllllllllIllIlIllllllIllII = lllllllllllllllIllIlIlllllllIIIl.getBlockPos().offset(lllllllllllllllIllIlIlllllllIIIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                final EntityTNTPrimed lllllllllllllllIllIlIllllllIlIlI = new EntityTNTPrimed(lllllllllllllllIllIlIllllllIlllI, lllllllllllllllIllIlIllllllIllII.getX() + 0.5, lllllllllllllllIllIlIllllllIllII.getY(), lllllllllllllllIllIlIllllllIllII.getZ() + 0.5, null);
                lllllllllllllllIllIlIllllllIlllI.spawnEntityInWorld(lllllllllllllllIllIlIllllllIlIlI);
                lllllllllllllllIllIlIllllllIlllI.playSound(null, lllllllllllllllIllIlIllllllIlIlI.posX, lllllllllllllllIllIlIllllllIlIlI.posY, lllllllllllllllIllIlIllllllIlIlI.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
                lllllllllllllllIllIlIllllllIllll.func_190918_g(1);
                return lllllllllllllllIllIlIllllllIllll;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Items.SKULL, new BehaviorDispenseOptional() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource llIIIIIIllllIIl, final ItemStack llIIIIIIllIllIl) {
                final World llIIIIIIlllIlll = llIIIIIIllllIIl.getWorld();
                final EnumFacing llIIIIIIlllIllI = llIIIIIIllllIIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
                final BlockPos llIIIIIIlllIlIl = llIIIIIIllllIIl.getBlockPos().offset(llIIIIIIlllIllI);
                final BlockSkull llIIIIIIlllIlII = Blocks.SKULL;
                this.field_190911_b = true;
                if (llIIIIIIlllIlll.isAirBlock(llIIIIIIlllIlIl) && llIIIIIIlllIlII.canDispenserPlace(llIIIIIIlllIlll, llIIIIIIlllIlIl, llIIIIIIllIllIl)) {
                    if (!llIIIIIIlllIlll.isRemote) {
                        llIIIIIIlllIlll.setBlockState(llIIIIIIlllIlIl, llIIIIIIlllIlII.getDefaultState().withProperty((IProperty<Comparable>)BlockSkull.FACING, EnumFacing.UP), 3);
                        final TileEntity llIIIIIIlllIIll = llIIIIIIlllIlll.getTileEntity(llIIIIIIlllIlIl);
                        if (llIIIIIIlllIIll instanceof TileEntitySkull) {
                            if (llIIIIIIllIllIl.getMetadata() == 3) {
                                GameProfile llIIIIIIlllIIlI = null;
                                if (llIIIIIIllIllIl.hasTagCompound()) {
                                    final NBTTagCompound llIIIIIIlllIIIl = llIIIIIIllIllIl.getTagCompound();
                                    if (llIIIIIIlllIIIl.hasKey("SkullOwner", 10)) {
                                        llIIIIIIlllIIlI = NBTUtil.readGameProfileFromNBT(llIIIIIIlllIIIl.getCompoundTag("SkullOwner"));
                                    }
                                    else if (llIIIIIIlllIIIl.hasKey("SkullOwner", 8)) {
                                        final String llIIIIIIlllIIII = llIIIIIIlllIIIl.getString("SkullOwner");
                                        if (!StringUtils.isNullOrEmpty(llIIIIIIlllIIII)) {
                                            llIIIIIIlllIIlI = new GameProfile((UUID)null, llIIIIIIlllIIII);
                                        }
                                    }
                                }
                                ((TileEntitySkull)llIIIIIIlllIIll).setPlayerProfile(llIIIIIIlllIIlI);
                            }
                            else {
                                ((TileEntitySkull)llIIIIIIlllIIll).setType(llIIIIIIllIllIl.getMetadata());
                            }
                            ((TileEntitySkull)llIIIIIIlllIIll).setSkullRotation(llIIIIIIlllIllI.getOpposite().getHorizontalIndex() * 4);
                            Blocks.SKULL.checkWitherSpawn(llIIIIIIlllIlll, llIIIIIIlllIlIl, (TileEntitySkull)llIIIIIIlllIIll);
                        }
                        llIIIIIIllIllIl.func_190918_g(1);
                    }
                }
                else if (ItemArmor.dispenseArmor(llIIIIIIllllIIl, llIIIIIIllIllIl).func_190926_b()) {
                    this.field_190911_b = false;
                }
                return llIIIIIIllIllIl;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item.getItemFromBlock(Blocks.PUMPKIN), new BehaviorDispenseOptional() {
            @Override
            protected ItemStack dispenseStack(final IBlockSource lllllllllllllllIlllllIlIIIIIlIIl, final ItemStack lllllllllllllllIlllllIlIIIIIlIII) {
                final World lllllllllllllllIlllllIlIIIIIIllI = lllllllllllllllIlllllIlIIIIIlIIl.getWorld();
                final BlockPos lllllllllllllllIlllllIlIIIIIIlIl = lllllllllllllllIlllllIlIIIIIlIIl.getBlockPos().offset(lllllllllllllllIlllllIlIIIIIlIIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
                final BlockPumpkin lllllllllllllllIlllllIlIIIIIIIll = (BlockPumpkin)Blocks.PUMPKIN;
                this.field_190911_b = true;
                if (lllllllllllllllIlllllIlIIIIIIllI.isAirBlock(lllllllllllllllIlllllIlIIIIIIlIl) && lllllllllllllllIlllllIlIIIIIIIll.canDispenserPlace(lllllllllllllllIlllllIlIIIIIIllI, lllllllllllllllIlllllIlIIIIIIlIl)) {
                    if (!lllllllllllllllIlllllIlIIIIIIllI.isRemote) {
                        lllllllllllllllIlllllIlIIIIIIllI.setBlockState(lllllllllllllllIlllllIlIIIIIIlIl, lllllllllllllllIlllllIlIIIIIIIll.getDefaultState(), 3);
                    }
                    lllllllllllllllIlllllIlIIIIIlIII.func_190918_g(1);
                }
                else {
                    final ItemStack lllllllllllllllIlllllIlIIIIIIIIl = ItemArmor.dispenseArmor(lllllllllllllllIlllllIlIIIIIlIIl, lllllllllllllllIlllllIlIIIIIlIII);
                    if (lllllllllllllllIlllllIlIIIIIIIIl.func_190926_b()) {
                        this.field_190911_b = false;
                    }
                }
                return lllllllllllllllIlllllIlIIIIIlIII;
            }
        });
        final String lllllllllllllllllIlllIlIlIllIIIl;
        final double lllllllllllllllllIlllIlIlIllIIlI = ((EnumDyeColor[])(Object)(lllllllllllllllllIlllIlIlIllIIIl = (String)(Object)EnumDyeColor.values())).length;
        for (byte lllllllllllllllllIlllIlIlIllIIll = 0; lllllllllllllllllIlllIlIlIllIIll < lllllllllllllllllIlllIlIlIllIIlI; ++lllllllllllllllllIlllIlIlIllIIll) {
            final EnumDyeColor lllllllllllllllllIlllIlIlIllIlll = lllllllllllllllllIlllIlIlIllIIIl[lllllllllllllllllIlllIlIlIllIIll];
            BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item.getItemFromBlock(BlockShulkerBox.func_190952_a(lllllllllllllllllIlllIlIlIllIlll)), new BehaviorDispenseShulkerBox(null));
        }
    }
    
    private static void redirectOutputToLog() {
        if (Bootstrap.LOGGER.isDebugEnabled()) {
            System.setErr(new DebugLoggingPrintStream("STDERR", System.err));
            System.setOut(new DebugLoggingPrintStream("STDOUT", Bootstrap.SYSOUT));
        }
        else {
            System.setErr(new LoggingPrintStream("STDERR", System.err));
            System.setOut(new LoggingPrintStream("STDOUT", Bootstrap.SYSOUT));
        }
    }
    
    public static class BehaviorDispenseBoat extends BehaviorDefaultDispenseItem
    {
        private final /* synthetic */ BehaviorDefaultDispenseItem dispenseBehavior;
        private final /* synthetic */ EntityBoat.Type boatType;
        
        @Override
        protected void playDispenseSound(final IBlockSource lllllllllllllIlIIlIIlllIIIIIIlIl) {
            lllllllllllllIlIIlIIlllIIIIIIlIl.getWorld().playEvent(1000, lllllllllllllIlIIlIIlllIIIIIIlIl.getBlockPos(), 0);
        }
        
        public ItemStack dispenseStack(final IBlockSource lllllllllllllIlIIlIIlllIIIIlIIll, final ItemStack lllllllllllllIlIIlIIlllIIIIlllll) {
            final EnumFacing lllllllllllllIlIIlIIlllIIIIllllI = lllllllllllllIlIIlIIlllIIIIlIIll.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
            final World lllllllllllllIlIIlIIlllIIIIlllIl = lllllllllllllIlIIlIIlllIIIIlIIll.getWorld();
            final double lllllllllllllIlIIlIIlllIIIIlllII = lllllllllllllIlIIlIIlllIIIIlIIll.getX() + lllllllllllllIlIIlIIlllIIIIllllI.getFrontOffsetX() * 1.125f;
            final double lllllllllllllIlIIlIIlllIIIIllIll = lllllllllllllIlIIlIIlllIIIIlIIll.getY() + lllllllllllllIlIIlIIlllIIIIllllI.getFrontOffsetY() * 1.125f;
            final double lllllllllllllIlIIlIIlllIIIIllIlI = lllllllllllllIlIIlIIlllIIIIlIIll.getZ() + lllllllllllllIlIIlIIlllIIIIllllI.getFrontOffsetZ() * 1.125f;
            final BlockPos lllllllllllllIlIIlIIlllIIIIllIIl = lllllllllllllIlIIlIIlllIIIIlIIll.getBlockPos().offset(lllllllllllllIlIIlIIlllIIIIllllI);
            final Material lllllllllllllIlIIlIIlllIIIIllIII = lllllllllllllIlIIlIIlllIIIIlllIl.getBlockState(lllllllllllllIlIIlIIlllIIIIllIIl).getMaterial();
            double lllllllllllllIlIIlIIlllIIIIlIllI = 0.0;
            if (Material.WATER.equals(lllllllllllllIlIIlIIlllIIIIllIII)) {
                final double lllllllllllllIlIIlIIlllIIIIlIlll = 1.0;
            }
            else {
                if (!Material.AIR.equals(lllllllllllllIlIIlIIlllIIIIllIII) || !Material.WATER.equals(lllllllllllllIlIIlIIlllIIIIlllIl.getBlockState(lllllllllllllIlIIlIIlllIIIIllIIl.down()).getMaterial())) {
                    return this.dispenseBehavior.dispense(lllllllllllllIlIIlIIlllIIIIlIIll, lllllllllllllIlIIlIIlllIIIIlllll);
                }
                lllllllllllllIlIIlIIlllIIIIlIllI = 0.0;
            }
            final EntityBoat lllllllllllllIlIIlIIlllIIIIlIlIl = new EntityBoat(lllllllllllllIlIIlIIlllIIIIlllIl, lllllllllllllIlIIlIIlllIIIIlllII, lllllllllllllIlIIlIIlllIIIIllIll + lllllllllllllIlIIlIIlllIIIIlIllI, lllllllllllllIlIIlIIlllIIIIllIlI);
            lllllllllllllIlIIlIIlllIIIIlIlIl.setBoatType(this.boatType);
            lllllllllllllIlIIlIIlllIIIIlIlIl.rotationYaw = lllllllllllllIlIIlIIlllIIIIllllI.getHorizontalAngle();
            lllllllllllllIlIIlIIlllIIIIlllIl.spawnEntityInWorld(lllllllllllllIlIIlIIlllIIIIlIlIl);
            lllllllllllllIlIIlIIlllIIIIlllll.func_190918_g(1);
            return lllllllllllllIlIIlIIlllIIIIlllll;
        }
        
        public BehaviorDispenseBoat(final EntityBoat.Type lllllllllllllIlIIlIIlllIIIllIIII) {
            this.dispenseBehavior = new BehaviorDefaultDispenseItem();
            this.boatType = lllllllllllllIlIIlIIlllIIIllIIII;
        }
    }
    
    public abstract static class BehaviorDispenseOptional extends BehaviorDefaultDispenseItem
    {
        protected /* synthetic */ boolean field_190911_b;
        
        public BehaviorDispenseOptional() {
            this.field_190911_b = true;
        }
        
        @Override
        protected void playDispenseSound(final IBlockSource llllllllllllIlllllllIlIIllIIlllI) {
            llllllllllllIlllllllIlIIllIIlllI.getWorld().playEvent(this.field_190911_b ? 1000 : 1001, llllllllllllIlllllllIlIIllIIlllI.getBlockPos(), 0);
        }
    }
    
    static class BehaviorDispenseShulkerBox extends BehaviorDispenseOptional
    {
        private BehaviorDispenseShulkerBox() {
        }
        
        @Override
        protected ItemStack dispenseStack(final IBlockSource llllllllllllllIllIIIlllIIIIllIIl, final ItemStack llllllllllllllIllIIIlllIIIIIllIl) {
            final Block llllllllllllllIllIIIlllIIIIlIlll = Block.getBlockFromItem(llllllllllllllIllIIIlllIIIIIllIl.getItem());
            final World llllllllllllllIllIIIlllIIIIlIllI = llllllllllllllIllIIIlllIIIIllIIl.getWorld();
            final EnumFacing llllllllllllllIllIIIlllIIIIlIlIl = llllllllllllllIllIIIlllIIIIllIIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
            final BlockPos llllllllllllllIllIIIlllIIIIlIlII = llllllllllllllIllIIIlllIIIIllIIl.getBlockPos().offset(llllllllllllllIllIIIlllIIIIlIlIl);
            this.field_190911_b = llllllllllllllIllIIIlllIIIIlIllI.func_190527_a(llllllllllllllIllIIIlllIIIIlIlll, llllllllllllllIllIIIlllIIIIlIlII, false, EnumFacing.DOWN, null);
            if (this.field_190911_b) {
                final EnumFacing llllllllllllllIllIIIlllIIIIlIIll = llllllllllllllIllIIIlllIIIIlIllI.isAirBlock(llllllllllllllIllIIIlllIIIIlIlII.down()) ? llllllllllllllIllIIIlllIIIIlIlIl : EnumFacing.UP;
                final IBlockState llllllllllllllIllIIIlllIIIIlIIlI = llllllllllllllIllIIIlllIIIIlIlll.getDefaultState().withProperty(BlockShulkerBox.field_190957_a, llllllllllllllIllIIIlllIIIIlIIll);
                llllllllllllllIllIIIlllIIIIlIllI.setBlockState(llllllllllllllIllIIIlllIIIIlIlII, llllllllllllllIllIIIlllIIIIlIIlI);
                final TileEntity llllllllllllllIllIIIlllIIIIlIIIl = llllllllllllllIllIIIlllIIIIlIllI.getTileEntity(llllllllllllllIllIIIlllIIIIlIlII);
                final ItemStack llllllllllllllIllIIIlllIIIIlIIII = llllllllllllllIllIIIlllIIIIIllIl.splitStack(1);
                if (llllllllllllllIllIIIlllIIIIlIIII.hasTagCompound()) {
                    ((TileEntityShulkerBox)llllllllllllllIllIIIlllIIIIlIIIl).func_190586_e(llllllllllllllIllIIIlllIIIIlIIII.getTagCompound().getCompoundTag("BlockEntityTag"));
                }
                if (llllllllllllllIllIIIlllIIIIlIIII.hasDisplayName()) {
                    ((TileEntityShulkerBox)llllllllllllllIllIIIlllIIIIlIIIl).func_190575_a(llllllllllllllIllIIIlllIIIIlIIII.getDisplayName());
                }
                llllllllllllllIllIIIlllIIIIlIllI.updateComparatorOutputLevel(llllllllllllllIllIIIlllIIIIlIlII, llllllllllllllIllIIIlllIIIIlIIlI.getBlock());
            }
            return llllllllllllllIllIIIlllIIIIIllIl;
        }
    }
}
