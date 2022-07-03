package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.util.*;

public enum Entity1_16_2Types implements EntityType
{
    PILLAGER(62, (EntityType)Entity1_16_2Types.ABSTRACT_ILLAGER_BASE), 
    ILLUSIONER(35, (EntityType)Entity1_16_2Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    PANDA(56, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT), 
    GHAST(29, (EntityType)Entity1_16_2Types.ABSTRACT_FLYING), 
    RAVAGER(67, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    ENDERMAN(20, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    TNT_MINECART(51, (EntityType)Entity1_16_2Types.MINECART_ABSTRACT), 
    ABSTRACT_ILLAGER_BASE(-1, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    CHESTED_HORSE(-1, (EntityType)Entity1_16_2Types.ABSTRACT_HORSE), 
    WITCH(96, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    ENDERMITE(21, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    ENTITY(-1), 
    EVOKER(22, (EntityType)Entity1_16_2Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    CAT(7, (EntityType)Entity1_16_2Types.ABSTRACT_TAMEABLE_ANIMAL), 
    TROPICAL_FISH(90, (EntityType)Entity1_16_2Types.ABSTRACT_FISHES), 
    DOLPHIN(13, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT), 
    SNOW_GOLEM(77, (EntityType)Entity1_16_2Types.ABSTRACT_GOLEM), 
    HUSK(34, (EntityType)Entity1_16_2Types.ZOMBIE), 
    SPIDER(80, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    PHANTOM(58, (EntityType)Entity1_16_2Types.ABSTRACT_FLYING), 
    WITHER(97, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    ABSTRACT_PIGLIN(-1, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    ARROW(2, (EntityType)Entity1_16_2Types.ABSTRACT_ARROW), 
    BEE(4, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT), 
    POLAR_BEAR(63, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    EYE_OF_ENDER(25, (EntityType)Entity1_16_2Types.ENTITY), 
    ABSTRACT_FLYING(-1, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT), 
    WANDERING_TRADER(95, (EntityType)Entity1_16_2Types.ABSTRACT_AGEABLE), 
    PARROT(57, (EntityType)Entity1_16_2Types.ABSTRACT_PARROT), 
    EXPERIENCE_BOTTLE(86, (EntityType)Entity1_16_2Types.PROJECTILE_ABSTRACT), 
    MAGMA_CUBE(44, (EntityType)Entity1_16_2Types.SLIME), 
    MINECART_ABSTRACT(-1, (EntityType)Entity1_16_2Types.ENTITY), 
    ABSTRACT_ANIMAL(-1, (EntityType)Entity1_16_2Types.ABSTRACT_AGEABLE), 
    GUARDIAN(31, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    ABSTRACT_GOLEM(-1, (EntityType)Entity1_16_2Types.ABSTRACT_CREATURE), 
    FOX(28, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    CHEST_MINECART(46, (EntityType)Entity1_16_2Types.CHESTED_MINECART_ABSTRACT), 
    PROJECTILE_ABSTRACT(-1, (EntityType)Entity1_16_2Types.ENTITY), 
    SQUID(81, (EntityType)Entity1_16_2Types.ABSTRACT_WATERMOB), 
    PIGLIN_BRUTE(61, (EntityType)Entity1_16_2Types.ABSTRACT_PIGLIN), 
    LLAMA(42, (EntityType)Entity1_16_2Types.CHESTED_HORSE), 
    SHEEP(69, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    CHICKEN(9, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    EXPERIENCE_ORB(24, (EntityType)Entity1_16_2Types.ENTITY);
    
    private final /* synthetic */ int id;
    
    POTION(87, (EntityType)Entity1_16_2Types.PROJECTILE_ABSTRACT), 
    EVOKER_FANGS(23, (EntityType)Entity1_16_2Types.ENTITY), 
    DONKEY(14, (EntityType)Entity1_16_2Types.CHESTED_HORSE), 
    ABSTRACT_WATERMOB(-1, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT);
    
    private static final /* synthetic */ EntityType[] TYPES;
    
    ABSTRACT_EVO_ILLU_ILLAGER(-1, (EntityType)Entity1_16_2Types.ABSTRACT_ILLAGER_BASE), 
    ABSTRACT_INSENTIENT(-1, (EntityType)Entity1_16_2Types.LIVINGENTITY), 
    SALMON(68, (EntityType)Entity1_16_2Types.ABSTRACT_FISHES), 
    MOOSHROOM(53, (EntityType)Entity1_16_2Types.COW), 
    ABSTRACT_HANGING(-1, (EntityType)Entity1_16_2Types.ENTITY), 
    TURTLE(91, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    ITEM(37, (EntityType)Entity1_16_2Types.ENTITY), 
    VILLAGER(93, (EntityType)Entity1_16_2Types.ABSTRACT_AGEABLE), 
    OCELOT(54, (EntityType)Entity1_16_2Types.ABSTRACT_TAMEABLE_ANIMAL), 
    COW(11, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    SPECTRAL_ARROW(79, (EntityType)Entity1_16_2Types.ABSTRACT_ARROW), 
    HOGLIN(32, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    CREEPER(12, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    LEASH_KNOT(40, (EntityType)Entity1_16_2Types.ABSTRACT_HANGING), 
    STRIDER(83, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    CAVE_SPIDER(8, (EntityType)Entity1_16_2Types.SPIDER), 
    END_CRYSTAL(18, (EntityType)Entity1_16_2Types.ENTITY), 
    ABSTRACT_PARROT(-1, (EntityType)Entity1_16_2Types.ABSTRACT_TAMEABLE_ANIMAL), 
    SKELETON(73, (EntityType)Entity1_16_2Types.ABSTRACT_SKELETON), 
    SNOWBALL(78, (EntityType)Entity1_16_2Types.PROJECTILE_ABSTRACT), 
    ELDER_GUARDIAN(17, (EntityType)Entity1_16_2Types.GUARDIAN), 
    WITHER_SKULL(99, (EntityType)Entity1_16_2Types.ABSTRACT_FIREBALL), 
    ABSTRACT_SKELETON(-1, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    FURNACE_MINECART(48, (EntityType)Entity1_16_2Types.MINECART_ABSTRACT);
    
    private final /* synthetic */ EntityType parent;
    
    ABSTRACT_MONSTER(-1, (EntityType)Entity1_16_2Types.ABSTRACT_CREATURE), 
    GIANT(30, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    ABSTRACT_HORSE(-1, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    PIG(59, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    HOPPER_MINECART(49, (EntityType)Entity1_16_2Types.CHESTED_MINECART_ABSTRACT), 
    HORSE(33, (EntityType)Entity1_16_2Types.ABSTRACT_HORSE), 
    ZOMBIE(102, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    SKELETON_HORSE(74, (EntityType)Entity1_16_2Types.ABSTRACT_HORSE), 
    FIREWORK_ROCKET(27, (EntityType)Entity1_16_2Types.ENTITY), 
    PLAYER(106, (EntityType)Entity1_16_2Types.LIVINGENTITY), 
    PAINTING(55, (EntityType)Entity1_16_2Types.ABSTRACT_HANGING), 
    ZOMBIFIED_PIGLIN(105, (EntityType)Entity1_16_2Types.ZOMBIE), 
    SILVERFISH(72, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    TNT(64, (EntityType)Entity1_16_2Types.ENTITY), 
    ABSTRACT_CREATURE(-1, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT), 
    LIGHTNING_BOLT(41, (EntityType)Entity1_16_2Types.ABSTRACT_LIGHTNING), 
    COMMAND_BLOCK_MINECART(47, (EntityType)Entity1_16_2Types.MINECART_ABSTRACT), 
    PUFFERFISH(65, (EntityType)Entity1_16_2Types.ABSTRACT_FISHES), 
    PIGLIN(60, (EntityType)Entity1_16_2Types.ABSTRACT_PIGLIN), 
    LLAMA_SPIT(43, (EntityType)Entity1_16_2Types.ENTITY), 
    WOLF(100, (EntityType)Entity1_16_2Types.ABSTRACT_TAMEABLE_ANIMAL), 
    ZOMBIE_VILLAGER(104, (EntityType)Entity1_16_2Types.ZOMBIE), 
    DRAGON_FIREBALL(15, (EntityType)Entity1_16_2Types.ABSTRACT_FIREBALL), 
    TRIDENT(88, (EntityType)Entity1_16_2Types.ABSTRACT_ARROW), 
    MULE(52, (EntityType)Entity1_16_2Types.CHESTED_HORSE), 
    DROWNED(16, (EntityType)Entity1_16_2Types.ZOMBIE), 
    ARMOR_STAND(1, (EntityType)Entity1_16_2Types.LIVINGENTITY), 
    FALLING_BLOCK(26, (EntityType)Entity1_16_2Types.ENTITY), 
    ENDER_PEARL(85, (EntityType)Entity1_16_2Types.PROJECTILE_ABSTRACT), 
    BLAZE(5, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    SPAWNER_MINECART(50, (EntityType)Entity1_16_2Types.MINECART_ABSTRACT), 
    ITEM_FRAME(38, (EntityType)Entity1_16_2Types.ABSTRACT_HANGING), 
    ABSTRACT_AGEABLE(-1, (EntityType)Entity1_16_2Types.ABSTRACT_CREATURE), 
    SHULKER(70, (EntityType)Entity1_16_2Types.ABSTRACT_GOLEM), 
    BAT(3, (EntityType)Entity1_16_2Types.ABSTRACT_AMBIENT), 
    SHULKER_BULLET(71, (EntityType)Entity1_16_2Types.ENTITY), 
    ENDER_DRAGON(19, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT), 
    RABBIT(66, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    FIREBALL(39, (EntityType)Entity1_16_2Types.ABSTRACT_FIREBALL), 
    AREA_EFFECT_CLOUD(0, (EntityType)Entity1_16_2Types.ENTITY), 
    VEX(92, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    ZOGLIN(101, (EntityType)Entity1_16_2Types.ABSTRACT_MONSTER), 
    COD(10, (EntityType)Entity1_16_2Types.ABSTRACT_FISHES), 
    EGG(84, (EntityType)Entity1_16_2Types.PROJECTILE_ABSTRACT), 
    IRON_GOLEM(36, (EntityType)Entity1_16_2Types.ABSTRACT_GOLEM), 
    SMALL_FIREBALL(76, (EntityType)Entity1_16_2Types.ABSTRACT_FIREBALL), 
    MINECART(45, (EntityType)Entity1_16_2Types.MINECART_ABSTRACT), 
    ABSTRACT_ARROW(-1, (EntityType)Entity1_16_2Types.ENTITY), 
    LIVINGENTITY(-1, (EntityType)Entity1_16_2Types.ENTITY), 
    STRAY(82, (EntityType)Entity1_16_2Types.ABSTRACT_SKELETON), 
    ABSTRACT_AMBIENT(-1, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT), 
    WITHER_SKELETON(98, (EntityType)Entity1_16_2Types.ABSTRACT_SKELETON), 
    BOAT(6, (EntityType)Entity1_16_2Types.ENTITY), 
    ABSTRACT_TAMEABLE_ANIMAL(-1, (EntityType)Entity1_16_2Types.ABSTRACT_ANIMAL), 
    SLIME(75, (EntityType)Entity1_16_2Types.ABSTRACT_INSENTIENT), 
    ABSTRACT_FISHES(-1, (EntityType)Entity1_16_2Types.ABSTRACT_CREATURE), 
    ABSTRACT_FIREBALL(-1, (EntityType)Entity1_16_2Types.ENTITY), 
    ABSTRACT_LIGHTNING(-1, (EntityType)Entity1_16_2Types.ENTITY), 
    CHESTED_MINECART_ABSTRACT(-1, (EntityType)Entity1_16_2Types.MINECART_ABSTRACT), 
    FISHING_BOBBER(107, (EntityType)Entity1_16_2Types.ENTITY), 
    TRADER_LLAMA(89, (EntityType)Entity1_16_2Types.CHESTED_HORSE), 
    VINDICATOR(94, (EntityType)Entity1_16_2Types.ABSTRACT_ILLAGER_BASE), 
    ZOMBIE_HORSE(103, (EntityType)Entity1_16_2Types.ABSTRACT_HORSE);
    
    public static EntityType getTypeFromId(final int lllllllllllllIlIIlIIlIIlIlllllII) {
        return EntityTypeUtil.getTypeFromId(Entity1_16_2Types.TYPES, lllllllllllllIlIIlIIlIIlIlllllII, Entity1_16_2Types.ENTITY);
    }
    
    private Entity1_16_2Types(final int lllllllllllllIlIIlIIlIIllIIIlIll, final EntityType lllllllllllllIlIIlIIlIIllIIIIlIl) {
        this.id = lllllllllllllIlIIlIIlIIllIIIlIll;
        this.parent = lllllllllllllIlIIlIIlIIllIIIIlIl;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    static {
        TYPES = EntityTypeUtil.toOrderedArray(values());
    }
    
    private Entity1_16_2Types(final int lllllllllllllIlIIlIIlIIllIIlIllI) {
        this.id = lllllllllllllIlIIlIIlIIllIIlIllI;
        this.parent = null;
    }
    
    @Override
    public EntityType getParent() {
        return this.parent;
    }
}
