package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.util.*;

public enum Entity1_14Types implements EntityType
{
    SILVERFISH(64, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    DRAGON_FIREBALL(14, (EntityType)Entity1_14Types.ABSTRACT_FIREBALL), 
    OCELOT(50, (EntityType)Entity1_14Types.ABSTRACT_TAMEABLE_ANIMAL), 
    PHANTOM(97, (EntityType)Entity1_14Types.ABSTRACT_FLYING), 
    CHESTED_MINECART_ABSTRACT(-1, (EntityType)Entity1_14Types.MINECART_ABSTRACT), 
    ABSTRACT_ILLAGER_BASE(-1, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    SKELETON_HORSE(66, (EntityType)Entity1_14Types.ABSTRACT_HORSE), 
    ABSTRACT_TAMEABLE_ANIMAL(-1, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    SPIDER(72, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    RABBIT(59, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    ABSTRACT_LIGHTNING(-1, (EntityType)Entity1_14Types.ENTITY), 
    SHEEP(61, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    MULE(48, (EntityType)Entity1_14Types.CHESTED_HORSE), 
    WITCH(89, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    ENDER_DRAGON(18, (EntityType)Entity1_14Types.ABSTRACT_INSENTIENT), 
    LEASH_KNOT(37, (EntityType)Entity1_14Types.ABSTRACT_HANGING), 
    VILLAGER(84, (EntityType)Entity1_14Types.ABSTRACT_AGEABLE), 
    MINECART_ABSTRACT(-1, (EntityType)Entity1_14Types.ENTITY), 
    CHEST_MINECART(42, (EntityType)Entity1_14Types.CHESTED_MINECART_ABSTRACT), 
    PROJECTILE_ABSTRACT(-1, (EntityType)Entity1_14Types.ENTITY), 
    ABSTRACT_FLYING(-1, (EntityType)Entity1_14Types.ABSTRACT_INSENTIENT), 
    ZOMBIE(94, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    FIREBALL(36, (EntityType)Entity1_14Types.ABSTRACT_FIREBALL), 
    BLAZE(4, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    ABSTRACT_WATERMOB(-1, (EntityType)Entity1_14Types.ABSTRACT_INSENTIENT), 
    FOX(27, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    LLAMA_SPIT(39, (EntityType)Entity1_14Types.ENTITY), 
    IRON_GOLEM(85, (EntityType)Entity1_14Types.ABSTRACT_GOLEM), 
    ENDER_PEARL(79, (EntityType)Entity1_14Types.PROJECTILE_ABSTRACT), 
    ABSTRACT_FIREBALL(-1, (EntityType)Entity1_14Types.ENTITY), 
    ARROW(2, (EntityType)Entity1_14Types.ABSTRACT_ARROW), 
    ARMOR_STAND(1, (EntityType)Entity1_14Types.LIVINGENTITY), 
    ITEM(34, (EntityType)Entity1_14Types.ENTITY), 
    CHESTED_HORSE(-1, (EntityType)Entity1_14Types.ABSTRACT_HORSE), 
    SKELETON(65, (EntityType)Entity1_14Types.ABSTRACT_SKELETON), 
    ABSTRACT_PARROT(-1, (EntityType)Entity1_14Types.ABSTRACT_TAMEABLE_ANIMAL), 
    DOLPHIN(13, (EntityType)Entity1_14Types.ABSTRACT_INSENTIENT), 
    LLAMA(38, (EntityType)Entity1_14Types.CHESTED_HORSE), 
    CHICKEN(8, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    ABSTRACT_EVO_ILLU_ILLAGER(-1, (EntityType)Entity1_14Types.ABSTRACT_ILLAGER_BASE), 
    TRIDENT(82, (EntityType)Entity1_14Types.ABSTRACT_ARROW), 
    HORSE(31, (EntityType)Entity1_14Types.ABSTRACT_HORSE), 
    ABSTRACT_FISHES(-1, (EntityType)Entity1_14Types.ABSTRACT_CREATURE), 
    DROWNED(15, (EntityType)Entity1_14Types.ZOMBIE), 
    EVOKER(22, (EntityType)Entity1_14Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    EGG(78, (EntityType)Entity1_14Types.PROJECTILE_ABSTRACT), 
    ZOMBIE_PIGMAN(56, (EntityType)Entity1_14Types.ZOMBIE), 
    TROPICAL_FISH(76, (EntityType)Entity1_14Types.ABSTRACT_FISHES), 
    ENDERMITE(20, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    CAT(6, (EntityType)Entity1_14Types.ABSTRACT_TAMEABLE_ANIMAL), 
    BOAT(5, (EntityType)Entity1_14Types.ENTITY), 
    PILLAGER(87, (EntityType)Entity1_14Types.ABSTRACT_ILLAGER_BASE), 
    HUSK(32, (EntityType)Entity1_14Types.ZOMBIE), 
    SNOWBALL(70, (EntityType)Entity1_14Types.PROJECTILE_ABSTRACT);
    
    private final /* synthetic */ int id;
    
    RAVAGER(98, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    ABSTRACT_INSENTIENT(-1, (EntityType)Entity1_14Types.LIVINGENTITY), 
    WITHER(90, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    POTION(81, (EntityType)Entity1_14Types.PROJECTILE_ABSTRACT), 
    TNT(58, (EntityType)Entity1_14Types.ENTITY), 
    ELDER_GUARDIAN(16, (EntityType)Entity1_14Types.GUARDIAN), 
    PAINTING(51, (EntityType)Entity1_14Types.ABSTRACT_HANGING), 
    FALLING_BLOCK(25, (EntityType)Entity1_14Types.ENTITY), 
    ABSTRACT_AMBIENT(-1, (EntityType)Entity1_14Types.ABSTRACT_INSENTIENT), 
    AREA_EFFECT_CLOUD(0, (EntityType)Entity1_14Types.ENTITY), 
    POLAR_BEAR(57, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    ITEM_FRAME(35, (EntityType)Entity1_14Types.ABSTRACT_HANGING), 
    VEX(83, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    DONKEY(12, (EntityType)Entity1_14Types.CHESTED_HORSE), 
    BAT(3, (EntityType)Entity1_14Types.ABSTRACT_AMBIENT), 
    COD(9, (EntityType)Entity1_14Types.ABSTRACT_FISHES), 
    HOPPER_MINECART(45, (EntityType)Entity1_14Types.CHESTED_MINECART_ABSTRACT), 
    SHULKER(62, (EntityType)Entity1_14Types.ABSTRACT_GOLEM), 
    MAGMA_CUBE(40, (EntityType)Entity1_14Types.SLIME), 
    COMMAND_BLOCK_MINECART(43, (EntityType)Entity1_14Types.MINECART_ABSTRACT), 
    PANDA(52, (EntityType)Entity1_14Types.ABSTRACT_INSENTIENT), 
    WITHER_SKELETON(91, (EntityType)Entity1_14Types.ABSTRACT_SKELETON), 
    SPAWNER_MINECART(46, (EntityType)Entity1_14Types.MINECART_ABSTRACT), 
    SALMON(60, (EntityType)Entity1_14Types.ABSTRACT_FISHES), 
    EYE_OF_ENDER(24, (EntityType)Entity1_14Types.ENTITY);
    
    private final /* synthetic */ EntityType parent;
    
    SHULKER_BULLET(63, (EntityType)Entity1_14Types.ENTITY), 
    PIG(54, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    END_CRYSTAL(17, (EntityType)Entity1_14Types.ENTITY), 
    FURNACE_MINECART(44, (EntityType)Entity1_14Types.MINECART_ABSTRACT), 
    GUARDIAN(30, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    ZOMBIE_HORSE(95, (EntityType)Entity1_14Types.ABSTRACT_HORSE), 
    TRADER_LLAMA(75, (EntityType)Entity1_14Types.CHESTED_HORSE), 
    ENDERMAN(19, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    ENTITY(-1), 
    TURTLE(77, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    ABSTRACT_CREATURE(-1, (EntityType)Entity1_14Types.ABSTRACT_INSENTIENT), 
    ABSTRACT_SKELETON(-1, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    SLIME(67, (EntityType)Entity1_14Types.ABSTRACT_INSENTIENT), 
    WANDERING_TRADER(88, (EntityType)Entity1_14Types.ABSTRACT_AGEABLE), 
    CREEPER(11, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    ILLUSIONER(33, (EntityType)Entity1_14Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    PUFFERFISH(55, (EntityType)Entity1_14Types.ABSTRACT_FISHES);
    
    private static final /* synthetic */ EntityType[] TYPES;
    
    LIVINGENTITY(-1, (EntityType)Entity1_14Types.ENTITY), 
    SNOW_GOLEM(69, (EntityType)Entity1_14Types.ABSTRACT_GOLEM), 
    ZOMBIE_VILLAGER(96, (EntityType)Entity1_14Types.ZOMBIE), 
    CAVE_SPIDER(7, (EntityType)Entity1_14Types.SPIDER), 
    WITHER_SKULL(92, (EntityType)Entity1_14Types.ABSTRACT_FIREBALL), 
    ABSTRACT_HORSE(-1, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    ABSTRACT_HANGING(-1, (EntityType)Entity1_14Types.ENTITY), 
    LIGHTNING_BOLT(99, (EntityType)Entity1_14Types.ABSTRACT_LIGHTNING), 
    SQUID(73, (EntityType)Entity1_14Types.ABSTRACT_WATERMOB), 
    MOOSHROOM(49, (EntityType)Entity1_14Types.COW), 
    PARROT(53, (EntityType)Entity1_14Types.ABSTRACT_PARROT), 
    STRAY(74, (EntityType)Entity1_14Types.ABSTRACT_SKELETON), 
    TNT_MINECART(47, (EntityType)Entity1_14Types.MINECART_ABSTRACT), 
    PLAYER(100, (EntityType)Entity1_14Types.LIVINGENTITY), 
    WOLF(93, (EntityType)Entity1_14Types.ABSTRACT_TAMEABLE_ANIMAL), 
    COW(10, (EntityType)Entity1_14Types.ABSTRACT_ANIMAL), 
    VINDICATOR(86, (EntityType)Entity1_14Types.ABSTRACT_ILLAGER_BASE), 
    SMALL_FIREBALL(68, (EntityType)Entity1_14Types.ABSTRACT_FIREBALL), 
    ABSTRACT_MONSTER(-1, (EntityType)Entity1_14Types.ABSTRACT_CREATURE), 
    EXPERIENCE_ORB(23, (EntityType)Entity1_14Types.ENTITY), 
    ABSTRACT_ANIMAL(-1, (EntityType)Entity1_14Types.ABSTRACT_AGEABLE), 
    EVOKER_FANGS(21, (EntityType)Entity1_14Types.ENTITY), 
    SPECTRAL_ARROW(71, (EntityType)Entity1_14Types.ABSTRACT_ARROW), 
    FIREWORK_ROCKET(26, (EntityType)Entity1_14Types.ENTITY), 
    FISHING_BOBBER(101, (EntityType)Entity1_14Types.ENTITY), 
    GIANT(29, (EntityType)Entity1_14Types.ABSTRACT_MONSTER), 
    ABSTRACT_GOLEM(-1, (EntityType)Entity1_14Types.ABSTRACT_CREATURE), 
    ABSTRACT_AGEABLE(-1, (EntityType)Entity1_14Types.ABSTRACT_CREATURE), 
    EXPERIENCE_BOTTLE(80, (EntityType)Entity1_14Types.PROJECTILE_ABSTRACT), 
    ABSTRACT_ARROW(-1, (EntityType)Entity1_14Types.ENTITY), 
    GHAST(28, (EntityType)Entity1_14Types.ABSTRACT_FLYING), 
    MINECART(41, (EntityType)Entity1_14Types.MINECART_ABSTRACT);
    
    @Override
    public int getId() {
        return this.id;
    }
    
    private Entity1_14Types(final int llllllllllllllIIlIllIlIIIlllllIl) {
        this.id = llllllllllllllIIlIllIlIIIlllllIl;
        this.parent = null;
    }
    
    private Entity1_14Types(final int llllllllllllllIIlIllIlIIIllIllIl, final EntityType llllllllllllllIIlIllIlIIIllIllII) {
        this.id = llllllllllllllIIlIllIlIIIllIllIl;
        this.parent = llllllllllllllIIlIllIlIIIllIllII;
    }
    
    public static EntityType getTypeFromId(final int llllllllllllllIIlIllIlIIIllIIIll) {
        return EntityTypeUtil.getTypeFromId(Entity1_14Types.TYPES, llllllllllllllIIlIllIlIIIllIIIll, Entity1_14Types.ENTITY);
    }
    
    static {
        TYPES = EntityTypeUtil.toOrderedArray(values());
    }
    
    @Override
    public EntityType getParent() {
        return this.parent;
    }
}
