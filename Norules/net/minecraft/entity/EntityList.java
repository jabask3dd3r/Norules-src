package net.minecraft.entity;

import net.minecraft.util.registry.*;
import net.minecraft.util.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.world.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.effect.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.item.*;
import net.minecraft.stats.*;

public class EntityList
{
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, Class<? extends Entity>> field_191308_b;
    private static final /* synthetic */ Logger LOGGER;
    public static final /* synthetic */ Set<ResourceLocation> field_191309_d;
    public static final /* synthetic */ Map<ResourceLocation, EntityEggInfo> ENTITY_EGGS;
    private static final /* synthetic */ List<String> field_191311_g;
    public static final /* synthetic */ ResourceLocation field_191307_a;
    private static final /* synthetic */ ResourceLocation field_191310_e;
    
    public static boolean isStringValidEntityName(final ResourceLocation llllllllllllllllIlIllIllIlIIIIlI) {
        return EntityList.field_191310_e.equals(llllllllllllllllIlIllIllIlIIIIlI) || getEntityNameList().contains(llllllllllllllllIlIllIllIlIIIIlI);
    }
    
    @Nullable
    public static Entity func_191304_a(@Nullable final Class<? extends Entity> llllllllllllllllIlIllIllIllIlIll, final World llllllllllllllllIlIllIllIllIlIlI) {
        if (llllllllllllllllIlIllIllIllIlIll == null) {
            return null;
        }
        try {
            return (Entity)llllllllllllllllIlIllIllIllIlIll.getConstructor(World.class).newInstance(llllllllllllllllIlIllIllIllIlIlI);
        }
        catch (Exception llllllllllllllllIlIllIllIllIlIIl) {
            llllllllllllllllIlIllIllIllIlIIl.printStackTrace();
            return null;
        }
    }
    
    @Nullable
    public static Entity createEntityByIDFromName(final ResourceLocation llllllllllllllllIlIllIllIlIlllIl, final World llllllllllllllllIlIllIllIlIllIlI) {
        return func_191304_a(EntityList.field_191308_b.getObject(llllllllllllllllIlIllIllIlIlllIl), llllllllllllllllIlIllIllIlIllIlI);
    }
    
    @Nullable
    public static Entity createEntityByID(final int llllllllllllllllIlIllIllIllIIIIl, final World llllllllllllllllIlIllIllIllIIIlI) {
        return func_191304_a(getClassFromID(llllllllllllllllIlIllIllIllIIIIl), llllllllllllllllIlIllIllIllIIIlI);
    }
    
    @Nullable
    public static Class<? extends Entity> func_192839_a(final String llllllllllllllllIlIllIllIllIllll) {
        return EntityList.field_191308_b.getObject(new ResourceLocation(llllllllllllllllIlIllIllIllIllll));
    }
    
    @Nullable
    public static ResourceLocation func_191306_a(final Class<? extends Entity> llllllllllllllllIlIllIlllIIlIllI) {
        return EntityList.field_191308_b.getNameForObject(llllllllllllllllIlIllIlllIIlIllI);
    }
    
    public static Set<ResourceLocation> getEntityNameList() {
        return EntityList.field_191309_d;
    }
    
    protected static EntityEggInfo func_191305_a(final String llllllllllllllllIlIllIllIIlIIIIl, final int llllllllllllllllIlIllIllIIlIIlII, final int llllllllllllllllIlIllIllIIIlllll) {
        final ResourceLocation llllllllllllllllIlIllIllIIlIIIlI = new ResourceLocation(llllllllllllllllIlIllIllIIlIIIIl);
        return EntityList.ENTITY_EGGS.put(llllllllllllllllIlIllIllIIlIIIlI, new EntityEggInfo(llllllllllllllllIlIllIllIIlIIIlI, llllllllllllllllIlIllIllIIlIIlII, llllllllllllllllIlIllIllIIIlllll));
    }
    
    private static void func_191303_a(final int llllllllllllllllIlIllIllIIlIlllI, final String llllllllllllllllIlIllIllIIlIllIl, final Class<? extends Entity> llllllllllllllllIlIllIllIIlIllII, final String llllllllllllllllIlIllIllIIllIIIl) {
        try {
            llllllllllllllllIlIllIllIIlIllII.getConstructor(World.class);
        }
        catch (NoSuchMethodException llllllllllllllllIlIllIllIIllIIII) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Invalid class ").append(llllllllllllllllIlIllIllIIlIllII).append(" no constructor taking ").append(World.class.getName())));
        }
        if ((llllllllllllllllIlIllIllIIlIllII.getModifiers() & 0x400) == 0x400) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Invalid abstract class ").append(llllllllllllllllIlIllIllIIlIllII)));
        }
        final ResourceLocation llllllllllllllllIlIllIllIIlIllll = new ResourceLocation(llllllllllllllllIlIllIllIIlIllIl);
        EntityList.field_191308_b.register(llllllllllllllllIlIllIllIIlIlllI, llllllllllllllllIlIllIllIIlIllll, llllllllllllllllIlIllIllIIlIllII);
        EntityList.field_191309_d.add(llllllllllllllllIlIllIllIIlIllll);
        while (EntityList.field_191311_g.size() <= llllllllllllllllIlIllIllIIlIlllI) {
            EntityList.field_191311_g.add(null);
        }
        EntityList.field_191311_g.set(llllllllllllllllIlIllIllIIlIlllI, llllllllllllllllIlIllIllIIllIIIl);
    }
    
    static {
        field_191307_a = new ResourceLocation("lightning_bolt");
        field_191310_e = new ResourceLocation("player");
        LOGGER = LogManager.getLogger();
        field_191308_b = new RegistryNamespaced<ResourceLocation, Class<? extends Entity>>();
        ENTITY_EGGS = Maps.newLinkedHashMap();
        field_191309_d = Sets.newHashSet();
        field_191311_g = Lists.newArrayList();
    }
    
    public static boolean isStringEntityName(final Entity llllllllllllllllIlIllIllIlIIlIlI, final ResourceLocation llllllllllllllllIlIllIllIlIIIllI) {
        final ResourceLocation llllllllllllllllIlIllIllIlIIlIII = func_191306_a(llllllllllllllllIlIllIllIlIIlIlI.getClass());
        if (llllllllllllllllIlIllIllIlIIlIII != null) {
            return llllllllllllllllIlIllIllIlIIlIII.equals(llllllllllllllllIlIllIllIlIIIllI);
        }
        if (llllllllllllllllIlIllIllIlIIlIlI instanceof EntityPlayer) {
            return EntityList.field_191310_e.equals(llllllllllllllllIlIllIllIlIIIllI);
        }
        return llllllllllllllllIlIllIllIlIIlIlI instanceof EntityLightningBolt && EntityList.field_191307_a.equals(llllllllllllllllIlIllIllIlIIIllI);
    }
    
    @Nullable
    public static Entity createEntityFromNBT(final NBTTagCompound llllllllllllllllIlIllIllIlIlIlIl, final World llllllllllllllllIlIllIllIlIlIIII) {
        final ResourceLocation llllllllllllllllIlIllIllIlIlIIll = new ResourceLocation(llllllllllllllllIlIllIllIlIlIlIl.getString("id"));
        final Entity llllllllllllllllIlIllIllIlIlIIlI = createEntityByIDFromName(llllllllllllllllIlIllIllIlIlIIll, llllllllllllllllIlIllIllIlIlIIII);
        if (llllllllllllllllIlIllIllIlIlIIlI == null) {
            EntityList.LOGGER.warn("Skipping Entity with id {}", (Object)llllllllllllllllIlIllIllIlIlIIll);
        }
        else {
            llllllllllllllllIlIllIllIlIlIIlI.readFromNBT(llllllllllllllllIlIllIllIlIlIlIl);
        }
        return llllllllllllllllIlIllIllIlIlIIlI;
    }
    
    @Nullable
    public static Class<? extends Entity> getClassFromID(final int llllllllllllllllIlIllIllIlllIIll) {
        return EntityList.field_191308_b.getObjectById(llllllllllllllllIlIllIllIlllIIll);
    }
    
    @Nullable
    public static String func_191302_a(@Nullable final ResourceLocation llllllllllllllllIlIllIllIllllllI) {
        final int llllllllllllllllIlIllIllIlllllII = EntityList.field_191308_b.getIDForObject(EntityList.field_191308_b.getObject(llllllllllllllllIlIllIllIllllllI));
        return (llllllllllllllllIlIllIllIlllllII == -1) ? null : EntityList.field_191311_g.get(llllllllllllllllIlIllIllIlllllII);
    }
    
    public static String func_192840_b() {
        final StringBuilder llllllllllllllllIlIllIllIIlllllI = new StringBuilder();
        for (final ResourceLocation llllllllllllllllIlIllIllIIllllIl : getEntityNameList()) {
            llllllllllllllllIlIllIllIIlllllI.append(llllllllllllllllIlIllIllIIllllIl).append(", ");
        }
        llllllllllllllllIlIllIllIIlllllI.append(EntityList.field_191310_e);
        return String.valueOf(llllllllllllllllIlIllIllIIlllllI);
    }
    
    public static void init() {
        func_191303_a(1, "item", EntityItem.class, "Item");
        func_191303_a(2, "xp_orb", EntityXPOrb.class, "XPOrb");
        func_191303_a(3, "area_effect_cloud", EntityAreaEffectCloud.class, "AreaEffectCloud");
        func_191303_a(4, "elder_guardian", EntityElderGuardian.class, "ElderGuardian");
        func_191303_a(5, "wither_skeleton", EntityWitherSkeleton.class, "WitherSkeleton");
        func_191303_a(6, "stray", EntityStray.class, "Stray");
        func_191303_a(7, "egg", EntityEgg.class, "ThrownEgg");
        func_191303_a(8, "leash_knot", EntityLeashKnot.class, "LeashKnot");
        func_191303_a(9, "painting", EntityPainting.class, "Painting");
        func_191303_a(10, "arrow", EntityTippedArrow.class, "Arrow");
        func_191303_a(11, "snowball", EntitySnowball.class, "Snowball");
        func_191303_a(12, "fireball", EntityLargeFireball.class, "Fireball");
        func_191303_a(13, "small_fireball", EntitySmallFireball.class, "SmallFireball");
        func_191303_a(14, "ender_pearl", EntityEnderPearl.class, "ThrownEnderpearl");
        func_191303_a(15, "eye_of_ender_signal", EntityEnderEye.class, "EyeOfEnderSignal");
        func_191303_a(16, "potion", EntityPotion.class, "ThrownPotion");
        func_191303_a(17, "xp_bottle", EntityExpBottle.class, "ThrownExpBottle");
        func_191303_a(18, "item_frame", EntityItemFrame.class, "ItemFrame");
        func_191303_a(19, "wither_skull", EntityWitherSkull.class, "WitherSkull");
        func_191303_a(20, "tnt", EntityTNTPrimed.class, "PrimedTnt");
        func_191303_a(21, "falling_block", EntityFallingBlock.class, "FallingSand");
        func_191303_a(22, "fireworks_rocket", EntityFireworkRocket.class, "FireworksRocketEntity");
        func_191303_a(23, "husk", EntityHusk.class, "Husk");
        func_191303_a(24, "spectral_arrow", EntitySpectralArrow.class, "SpectralArrow");
        func_191303_a(25, "shulker_bullet", EntityShulkerBullet.class, "ShulkerBullet");
        func_191303_a(26, "dragon_fireball", EntityDragonFireball.class, "DragonFireball");
        func_191303_a(27, "zombie_villager", EntityZombieVillager.class, "ZombieVillager");
        func_191303_a(28, "skeleton_horse", EntitySkeletonHorse.class, "SkeletonHorse");
        func_191303_a(29, "zombie_horse", EntityZombieHorse.class, "ZombieHorse");
        func_191303_a(30, "armor_stand", EntityArmorStand.class, "ArmorStand");
        func_191303_a(31, "donkey", EntityDonkey.class, "Donkey");
        func_191303_a(32, "mule", EntityMule.class, "Mule");
        func_191303_a(33, "evocation_fangs", EntityEvokerFangs.class, "EvocationFangs");
        func_191303_a(34, "evocation_illager", EntityEvoker.class, "EvocationIllager");
        func_191303_a(35, "vex", EntityVex.class, "Vex");
        func_191303_a(36, "vindication_illager", EntityVindicator.class, "VindicationIllager");
        func_191303_a(37, "illusion_illager", EntityIllusionIllager.class, "IllusionIllager");
        func_191303_a(40, "commandblock_minecart", EntityMinecartCommandBlock.class, EntityMinecart.Type.COMMAND_BLOCK.getName());
        func_191303_a(41, "boat", EntityBoat.class, "Boat");
        func_191303_a(42, "minecart", EntityMinecartEmpty.class, EntityMinecart.Type.RIDEABLE.getName());
        func_191303_a(43, "chest_minecart", EntityMinecartChest.class, EntityMinecart.Type.CHEST.getName());
        func_191303_a(44, "furnace_minecart", EntityMinecartFurnace.class, EntityMinecart.Type.FURNACE.getName());
        func_191303_a(45, "tnt_minecart", EntityMinecartTNT.class, EntityMinecart.Type.TNT.getName());
        func_191303_a(46, "hopper_minecart", EntityMinecartHopper.class, EntityMinecart.Type.HOPPER.getName());
        func_191303_a(47, "spawner_minecart", EntityMinecartMobSpawner.class, EntityMinecart.Type.SPAWNER.getName());
        func_191303_a(50, "creeper", EntityCreeper.class, "Creeper");
        func_191303_a(51, "skeleton", EntitySkeleton.class, "Skeleton");
        func_191303_a(52, "spider", EntitySpider.class, "Spider");
        func_191303_a(53, "giant", EntityGiantZombie.class, "Giant");
        func_191303_a(54, "zombie", EntityZombie.class, "Zombie");
        func_191303_a(55, "slime", EntitySlime.class, "Slime");
        func_191303_a(56, "ghast", EntityGhast.class, "Ghast");
        func_191303_a(57, "zombie_pigman", EntityPigZombie.class, "PigZombie");
        func_191303_a(58, "enderman", EntityEnderman.class, "Enderman");
        func_191303_a(59, "cave_spider", EntityCaveSpider.class, "CaveSpider");
        func_191303_a(60, "silverfish", EntitySilverfish.class, "Silverfish");
        func_191303_a(61, "blaze", EntityBlaze.class, "Blaze");
        func_191303_a(62, "magma_cube", EntityMagmaCube.class, "LavaSlime");
        func_191303_a(63, "ender_dragon", EntityDragon.class, "EnderDragon");
        func_191303_a(64, "wither", EntityWither.class, "WitherBoss");
        func_191303_a(65, "bat", EntityBat.class, "Bat");
        func_191303_a(66, "witch", EntityWitch.class, "Witch");
        func_191303_a(67, "endermite", EntityEndermite.class, "Endermite");
        func_191303_a(68, "guardian", EntityGuardian.class, "Guardian");
        func_191303_a(69, "shulker", EntityShulker.class, "Shulker");
        func_191303_a(90, "pig", EntityPig.class, "Pig");
        func_191303_a(91, "sheep", EntitySheep.class, "Sheep");
        func_191303_a(92, "cow", EntityCow.class, "Cow");
        func_191303_a(93, "chicken", EntityChicken.class, "Chicken");
        func_191303_a(94, "squid", EntitySquid.class, "Squid");
        func_191303_a(95, "wolf", EntityWolf.class, "Wolf");
        func_191303_a(96, "mooshroom", EntityMooshroom.class, "MushroomCow");
        func_191303_a(97, "snowman", EntitySnowman.class, "SnowMan");
        func_191303_a(98, "ocelot", EntityOcelot.class, "Ozelot");
        func_191303_a(99, "villager_golem", EntityIronGolem.class, "VillagerGolem");
        func_191303_a(100, "horse", EntityHorse.class, "Horse");
        func_191303_a(101, "rabbit", EntityRabbit.class, "Rabbit");
        func_191303_a(102, "polar_bear", EntityPolarBear.class, "PolarBear");
        func_191303_a(103, "llama", EntityLlama.class, "Llama");
        func_191303_a(104, "llama_spit", EntityLlamaSpit.class, "LlamaSpit");
        func_191303_a(105, "parrot", EntityParrot.class, "Parrot");
        func_191303_a(120, "villager", EntityVillager.class, "Villager");
        func_191303_a(200, "ender_crystal", EntityEnderCrystal.class, "EnderCrystal");
        func_191305_a("bat", 4996656, 986895);
        func_191305_a("blaze", 16167425, 16775294);
        func_191305_a("cave_spider", 803406, 11013646);
        func_191305_a("chicken", 10592673, 16711680);
        func_191305_a("cow", 4470310, 10592673);
        func_191305_a("creeper", 894731, 0);
        func_191305_a("donkey", 5457209, 8811878);
        func_191305_a("elder_guardian", 13552826, 7632531);
        func_191305_a("enderman", 1447446, 0);
        func_191305_a("endermite", 1447446, 7237230);
        func_191305_a("evocation_illager", 9804699, 1973274);
        func_191305_a("ghast", 16382457, 12369084);
        func_191305_a("guardian", 5931634, 15826224);
        func_191305_a("horse", 12623485, 15656192);
        func_191305_a("husk", 7958625, 15125652);
        func_191305_a("llama", 12623485, 10051392);
        func_191305_a("magma_cube", 3407872, 16579584);
        func_191305_a("mooshroom", 10489616, 12040119);
        func_191305_a("mule", 1769984, 5321501);
        func_191305_a("ocelot", 15720061, 5653556);
        func_191305_a("parrot", 894731, 16711680);
        func_191305_a("pig", 15771042, 14377823);
        func_191305_a("polar_bear", 15921906, 9803152);
        func_191305_a("rabbit", 10051392, 7555121);
        func_191305_a("sheep", 15198183, 16758197);
        func_191305_a("shulker", 9725844, 5060690);
        func_191305_a("silverfish", 7237230, 3158064);
        func_191305_a("skeleton", 12698049, 4802889);
        func_191305_a("skeleton_horse", 6842447, 15066584);
        func_191305_a("slime", 5349438, 8306542);
        func_191305_a("spider", 3419431, 11013646);
        func_191305_a("squid", 2243405, 7375001);
        func_191305_a("stray", 6387319, 14543594);
        func_191305_a("vex", 8032420, 15265265);
        func_191305_a("villager", 5651507, 12422002);
        func_191305_a("vindication_illager", 9804699, 2580065);
        func_191305_a("witch", 3407872, 5349438);
        func_191305_a("wither_skeleton", 1315860, 4672845);
        func_191305_a("wolf", 14144467, 13545366);
        func_191305_a("zombie", 44975, 7969893);
        func_191305_a("zombie_horse", 3232308, 9945732);
        func_191305_a("zombie_pigman", 15373203, 5009705);
        func_191305_a("zombie_villager", 5651507, 7969893);
        EntityList.field_191309_d.add(EntityList.field_191307_a);
    }
    
    @Nullable
    public static String getEntityString(final Entity llllllllllllllllIlIllIlllIIIlIll) {
        final int llllllllllllllllIlIllIlllIIIlIIl = EntityList.field_191308_b.getIDForObject(llllllllllllllllIlIllIlllIIIlIll.getClass());
        return (llllllllllllllllIlIllIlllIIIlIIl == -1) ? null : EntityList.field_191311_g.get(llllllllllllllllIlIllIlllIIIlIIl);
    }
    
    @Nullable
    public static ResourceLocation func_191301_a(final Entity llllllllllllllllIlIllIlllIIllIlI) {
        return func_191306_a(llllllllllllllllIlIllIlllIIllIlI.getClass());
    }
    
    public static class EntityEggInfo
    {
        public final /* synthetic */ int secondaryColor;
        public final /* synthetic */ StatBase killEntityStat;
        public final /* synthetic */ StatBase entityKilledByStat;
        public final /* synthetic */ ResourceLocation spawnedID;
        public final /* synthetic */ int primaryColor;
        
        public EntityEggInfo(final ResourceLocation llllllllllllllIlIIIllIIllllIIlIl, final int llllllllllllllIlIIIllIIllllIIlII, final int llllllllllllllIlIIIllIIlllIlllll) {
            this.spawnedID = llllllllllllllIlIIIllIIllllIIlIl;
            this.primaryColor = llllllllllllllIlIIIllIIllllIIlII;
            this.secondaryColor = llllllllllllllIlIIIllIIlllIlllll;
            this.killEntityStat = StatList.getStatKillEntity(this);
            this.entityKilledByStat = StatList.getStatEntityKilledBy(this);
        }
    }
}
