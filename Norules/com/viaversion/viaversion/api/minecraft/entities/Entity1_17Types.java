package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.util.*;

public enum Entity1_17Types implements EntityType
{
    PILLAGER(67, (EntityType)Entity1_17Types.ABSTRACT_ILLAGER_BASE), 
    TURTLE(96, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    CHICKEN(10, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    PAINTING(60, (EntityType)Entity1_17Types.ABSTRACT_HANGING), 
    CAT(8, (EntityType)Entity1_17Types.ABSTRACT_TAMEABLE_ANIMAL), 
    ABSTRACT_HANGING(-1, (EntityType)Entity1_17Types.ENTITY), 
    AREA_EFFECT_CLOUD(0, (EntityType)Entity1_17Types.ENTITY), 
    ABSTRACT_MONSTER(-1, (EntityType)Entity1_17Types.ABSTRACT_CREATURE), 
    SHULKER(75, (EntityType)Entity1_17Types.ABSTRACT_GOLEM), 
    ENDERMITE(22, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    HUSK(38, (EntityType)Entity1_17Types.ZOMBIE), 
    WITHER_SKELETON(103, (EntityType)Entity1_17Types.ABSTRACT_SKELETON), 
    ABSTRACT_FLYING(-1, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT), 
    SPECTRAL_ARROW(84, (EntityType)Entity1_17Types.ABSTRACT_ARROW), 
    MINECART_ABSTRACT(-1, (EntityType)Entity1_17Types.ENTITY), 
    VILLAGER(98, (EntityType)Entity1_17Types.ABSTRACT_AGEABLE), 
    ABSTRACT_FIREBALL(-1, (EntityType)Entity1_17Types.ENTITY), 
    ENDER_DRAGON(20, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT), 
    HOPPER_MINECART(54, (EntityType)Entity1_17Types.CHESTED_MINECART_ABSTRACT), 
    FALLING_BLOCK(27, (EntityType)Entity1_17Types.ENTITY), 
    ABSTRACT_ILLAGER_BASE(-1, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    EXPERIENCE_ORB(25, (EntityType)Entity1_17Types.ENTITY), 
    ENDERMAN(21, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    ABSTRACT_INSENTIENT(-1, (EntityType)Entity1_17Types.LIVINGENTITY), 
    ARROW(2, (EntityType)Entity1_17Types.ABSTRACT_ARROW), 
    ARMOR_STAND(1, (EntityType)Entity1_17Types.LIVINGENTITY), 
    SMALL_FIREBALL(81, (EntityType)Entity1_17Types.ABSTRACT_FIREBALL), 
    IRON_GOLEM(40, (EntityType)Entity1_17Types.ABSTRACT_GOLEM), 
    WITCH(101, (EntityType)Entity1_17Types.ABSTRACT_MONSTER);
    
    private static final /* synthetic */ EntityType[] TYPES;
    
    WITHER(102, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    COMMAND_BLOCK_MINECART(52, (EntityType)Entity1_17Types.MINECART_ABSTRACT), 
    END_CRYSTAL(19, (EntityType)Entity1_17Types.ENTITY), 
    STRIDER(88, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    ABSTRACT_ARROW(-1, (EntityType)Entity1_17Types.ENTITY), 
    DROWNED(17, (EntityType)Entity1_17Types.ZOMBIE), 
    TROPICAL_FISH(95, (EntityType)Entity1_17Types.ABSTRACT_FISHES), 
    PIGLIN(65, (EntityType)Entity1_17Types.ABSTRACT_PIGLIN), 
    ZOMBIFIED_PIGLIN(110, (EntityType)Entity1_17Types.ZOMBIE), 
    PIGLIN_BRUTE(66, (EntityType)Entity1_17Types.ABSTRACT_PIGLIN), 
    ENDER_PEARL(90, (EntityType)Entity1_17Types.PROJECTILE_ABSTRACT), 
    POTION(92, (EntityType)Entity1_17Types.PROJECTILE_ABSTRACT), 
    TNT(69, (EntityType)Entity1_17Types.ENTITY), 
    COW(12, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    ITEM_FRAME(42, (EntityType)Entity1_17Types.ABSTRACT_HANGING), 
    EVOKER_FANGS(24, (EntityType)Entity1_17Types.ENTITY), 
    FIREBALL(43, (EntityType)Entity1_17Types.ABSTRACT_FIREBALL), 
    ABSTRACT_ANIMAL(-1, (EntityType)Entity1_17Types.ABSTRACT_AGEABLE), 
    PLAYER(111, (EntityType)Entity1_17Types.LIVINGENTITY), 
    MAGMA_CUBE(48, (EntityType)Entity1_17Types.SLIME), 
    DRAGON_FIREBALL(16, (EntityType)Entity1_17Types.ABSTRACT_FIREBALL), 
    HOGLIN(36, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    ILLUSIONER(39, (EntityType)Entity1_17Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    BOAT(7, (EntityType)Entity1_17Types.ENTITY), 
    CHESTED_HORSE(-1, (EntityType)Entity1_17Types.ABSTRACT_HORSE), 
    SILVERFISH(77, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    PANDA(61, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT), 
    ITEM(41, (EntityType)Entity1_17Types.ENTITY), 
    SLIME(80, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT), 
    FISHING_BOBBER(112, (EntityType)Entity1_17Types.ENTITY), 
    ABSTRACT_TAMEABLE_ANIMAL(-1, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    GOAT(34, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    TRADER_LLAMA(94, (EntityType)Entity1_17Types.CHESTED_HORSE), 
    PROJECTILE_ABSTRACT(-1, (EntityType)Entity1_17Types.ENTITY), 
    ABSTRACT_HORSE(-1, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    SALMON(73, (EntityType)Entity1_17Types.ABSTRACT_FISHES);
    
    private final /* synthetic */ EntityType parent;
    
    HORSE(37, (EntityType)Entity1_17Types.ABSTRACT_HORSE), 
    GLOW_SQUID(33, (EntityType)Entity1_17Types.SQUID), 
    BEE(5, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT);
    
    private final /* synthetic */ int id;
    
    RAVAGER(72, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    EXPERIENCE_BOTTLE(91, (EntityType)Entity1_17Types.PROJECTILE_ABSTRACT), 
    GUARDIAN(35, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    ABSTRACT_LIGHTNING(-1, (EntityType)Entity1_17Types.ENTITY), 
    MARKER(49, (EntityType)Entity1_17Types.ENTITY), 
    SKELETON(78, (EntityType)Entity1_17Types.ABSTRACT_SKELETON), 
    ELDER_GUARDIAN(18, (EntityType)Entity1_17Types.GUARDIAN), 
    ZOMBIE_VILLAGER(109, (EntityType)Entity1_17Types.ZOMBIE), 
    ZOMBIE(107, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    ABSTRACT_EVO_ILLU_ILLAGER(-1, (EntityType)Entity1_17Types.ABSTRACT_ILLAGER_BASE), 
    PIG(64, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    PARROT(62, (EntityType)Entity1_17Types.ABSTRACT_PARROT), 
    WANDERING_TRADER(100, (EntityType)Entity1_17Types.ABSTRACT_AGEABLE), 
    SNOW_GOLEM(82, (EntityType)Entity1_17Types.ABSTRACT_GOLEM), 
    WOLF(105, (EntityType)Entity1_17Types.ABSTRACT_TAMEABLE_ANIMAL), 
    ABSTRACT_CREATURE(-1, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT), 
    POLAR_BEAR(68, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    MULE(57, (EntityType)Entity1_17Types.CHESTED_HORSE), 
    MINECART(50, (EntityType)Entity1_17Types.MINECART_ABSTRACT), 
    SKELETON_HORSE(79, (EntityType)Entity1_17Types.ABSTRACT_HORSE), 
    CAVE_SPIDER(9, (EntityType)Entity1_17Types.SPIDER), 
    ZOMBIE_HORSE(108, (EntityType)Entity1_17Types.ABSTRACT_HORSE), 
    ABSTRACT_GOLEM(-1, (EntityType)Entity1_17Types.ABSTRACT_CREATURE), 
    ABSTRACT_PARROT(-1, (EntityType)Entity1_17Types.ABSTRACT_TAMEABLE_ANIMAL), 
    FIREWORK_ROCKET(28, (EntityType)Entity1_17Types.ENTITY), 
    DONKEY(15, (EntityType)Entity1_17Types.CHESTED_HORSE), 
    FOX(29, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    BAT(4, (EntityType)Entity1_17Types.ABSTRACT_AMBIENT), 
    ABSTRACT_AGEABLE(-1, (EntityType)Entity1_17Types.ABSTRACT_CREATURE), 
    ENTITY(-1), 
    CHEST_MINECART(51, (EntityType)Entity1_17Types.CHESTED_MINECART_ABSTRACT), 
    CREEPER(13, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    SQUID(86, (EntityType)Entity1_17Types.ABSTRACT_WATERMOB), 
    LLAMA_SPIT(47, (EntityType)Entity1_17Types.ENTITY), 
    OCELOT(59, (EntityType)Entity1_17Types.ABSTRACT_TAMEABLE_ANIMAL), 
    GHAST(30, (EntityType)Entity1_17Types.ABSTRACT_FLYING), 
    WITHER_SKULL(104, (EntityType)Entity1_17Types.ABSTRACT_FIREBALL), 
    LIVINGENTITY(-1, (EntityType)Entity1_17Types.ENTITY), 
    SNOWBALL(83, (EntityType)Entity1_17Types.PROJECTILE_ABSTRACT), 
    EVOKER(23, (EntityType)Entity1_17Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    FURNACE_MINECART(53, (EntityType)Entity1_17Types.MINECART_ABSTRACT), 
    MOOSHROOM(58, (EntityType)Entity1_17Types.COW), 
    CHESTED_MINECART_ABSTRACT(-1, (EntityType)Entity1_17Types.MINECART_ABSTRACT), 
    LIGHTNING_BOLT(45, (EntityType)Entity1_17Types.ABSTRACT_LIGHTNING), 
    PUFFERFISH(70, (EntityType)Entity1_17Types.ABSTRACT_FISHES), 
    SHULKER_BULLET(76, (EntityType)Entity1_17Types.ENTITY), 
    ABSTRACT_PIGLIN(-1, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    ZOGLIN(106, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    ABSTRACT_WATERMOB(-1, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT), 
    BLAZE(6, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    VEX(97, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    SPIDER(85, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    EYE_OF_ENDER(26, (EntityType)Entity1_17Types.ENTITY), 
    ABSTRACT_FISHES(-1, (EntityType)Entity1_17Types.ABSTRACT_CREATURE), 
    COD(11, (EntityType)Entity1_17Types.ABSTRACT_FISHES), 
    TRIDENT(93, (EntityType)Entity1_17Types.ABSTRACT_ARROW), 
    SPAWNER_MINECART(55, (EntityType)Entity1_17Types.MINECART_ABSTRACT), 
    LLAMA(46, (EntityType)Entity1_17Types.CHESTED_HORSE), 
    DOLPHIN(14, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT), 
    TNT_MINECART(56, (EntityType)Entity1_17Types.MINECART_ABSTRACT), 
    RABBIT(71, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    SHEEP(74, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    EGG(89, (EntityType)Entity1_17Types.PROJECTILE_ABSTRACT), 
    LEASH_KNOT(44, (EntityType)Entity1_17Types.ABSTRACT_HANGING), 
    PHANTOM(63, (EntityType)Entity1_17Types.ABSTRACT_FLYING), 
    STRAY(87, (EntityType)Entity1_17Types.ABSTRACT_SKELETON), 
    ABSTRACT_AMBIENT(-1, (EntityType)Entity1_17Types.ABSTRACT_INSENTIENT), 
    GLOW_ITEM_FRAME(32, (EntityType)Entity1_17Types.ITEM_FRAME), 
    VINDICATOR(99, (EntityType)Entity1_17Types.ABSTRACT_ILLAGER_BASE), 
    GIANT(31, (EntityType)Entity1_17Types.ABSTRACT_MONSTER), 
    AXOLOTL(3, (EntityType)Entity1_17Types.ABSTRACT_ANIMAL), 
    ABSTRACT_SKELETON(-1, (EntityType)Entity1_17Types.ABSTRACT_MONSTER);
    
    private Entity1_17Types(final int llllllllllllllIlllllIIllIIlIllII) {
        this.id = llllllllllllllIlllllIIllIIlIllII;
        this.parent = null;
    }
    
    @Override
    public EntityType getParent() {
        return this.parent;
    }
    
    private Entity1_17Types(final int llllllllllllllIlllllIIllIIIlllII, final EntityType llllllllllllllIlllllIIllIIIllIll) {
        this.id = llllllllllllllIlllllIIllIIIlllII;
        this.parent = llllllllllllllIlllllIIllIIIllIll;
    }
    
    public static EntityType getTypeFromId(final int llllllllllllllIlllllIIllIIIlIIlI) {
        return EntityTypeUtil.getTypeFromId(Entity1_17Types.TYPES, llllllllllllllIlllllIIllIIIlIIlI, Entity1_17Types.ENTITY);
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    static {
        TYPES = EntityTypeUtil.toOrderedArray(values());
    }
}
