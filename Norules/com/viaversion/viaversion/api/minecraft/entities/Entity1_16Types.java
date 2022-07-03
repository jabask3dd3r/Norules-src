package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.util.*;

public enum Entity1_16Types implements EntityType
{
    PIG(59, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    ABSTRACT_HORSE(-1, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    SQUID(80, (EntityType)Entity1_16Types.ABSTRACT_WATERMOB), 
    FOX(28, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    ENDERMITE(21, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    ZOGLIN(100, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    HORSE(33, (EntityType)Entity1_16Types.ABSTRACT_HORSE), 
    ARROW(2, (EntityType)Entity1_16Types.ABSTRACT_ARROW), 
    WANDERING_TRADER(94, (EntityType)Entity1_16Types.ABSTRACT_AGEABLE), 
    COD(10, (EntityType)Entity1_16Types.ABSTRACT_FISHES), 
    PHANTOM(58, (EntityType)Entity1_16Types.ABSTRACT_FLYING), 
    ABSTRACT_CREATURE(-1, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT), 
    FIREWORK_ROCKET(27, (EntityType)Entity1_16Types.ENTITY), 
    ABSTRACT_PARROT(-1, (EntityType)Entity1_16Types.ABSTRACT_TAMEABLE_ANIMAL), 
    SNOWBALL(77, (EntityType)Entity1_16Types.PROJECTILE_ABSTRACT), 
    ITEM(37, (EntityType)Entity1_16Types.ENTITY), 
    LIGHTNING_BOLT(41, (EntityType)Entity1_16Types.ABSTRACT_LIGHTNING), 
    TNT(63, (EntityType)Entity1_16Types.ENTITY), 
    CAT(7, (EntityType)Entity1_16Types.ABSTRACT_TAMEABLE_ANIMAL), 
    ZOMBIE_HORSE(102, (EntityType)Entity1_16Types.ABSTRACT_HORSE), 
    END_CRYSTAL(18, (EntityType)Entity1_16Types.ENTITY), 
    ITEM_FRAME(38, (EntityType)Entity1_16Types.ABSTRACT_HANGING), 
    SKELETON_HORSE(73, (EntityType)Entity1_16Types.ABSTRACT_HORSE), 
    AREA_EFFECT_CLOUD(0, (EntityType)Entity1_16Types.ENTITY), 
    LEASH_KNOT(40, (EntityType)Entity1_16Types.ABSTRACT_HANGING), 
    OCELOT(54, (EntityType)Entity1_16Types.ABSTRACT_TAMEABLE_ANIMAL), 
    PANDA(56, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT);
    
    private static final /* synthetic */ EntityType[] TYPES;
    
    CHICKEN(9, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    ARMOR_STAND(1, (EntityType)Entity1_16Types.LIVINGENTITY), 
    FALLING_BLOCK(26, (EntityType)Entity1_16Types.ENTITY), 
    TNT_MINECART(51, (EntityType)Entity1_16Types.MINECART_ABSTRACT), 
    TROPICAL_FISH(89, (EntityType)Entity1_16Types.ABSTRACT_FISHES), 
    ABSTRACT_ARROW(-1, (EntityType)Entity1_16Types.ENTITY), 
    POLAR_BEAR(62, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    EYE_OF_ENDER(25, (EntityType)Entity1_16Types.ENTITY), 
    FIREBALL(39, (EntityType)Entity1_16Types.ABSTRACT_FIREBALL), 
    PUFFERFISH(64, (EntityType)Entity1_16Types.ABSTRACT_FISHES), 
    STRIDER(82, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    SMALL_FIREBALL(75, (EntityType)Entity1_16Types.ABSTRACT_FIREBALL), 
    ZOMBIE_VILLAGER(103, (EntityType)Entity1_16Types.ZOMBIE), 
    GUARDIAN(31, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    WITHER_SKULL(98, (EntityType)Entity1_16Types.ABSTRACT_FIREBALL), 
    ELDER_GUARDIAN(17, (EntityType)Entity1_16Types.GUARDIAN), 
    ZOMBIE(101, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    PIGLIN(60, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    PARROT(57, (EntityType)Entity1_16Types.ABSTRACT_PARROT), 
    DRAGON_FIREBALL(15, (EntityType)Entity1_16Types.ABSTRACT_FIREBALL), 
    WITHER(96, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    PILLAGER(61, (EntityType)Entity1_16Types.ABSTRACT_ILLAGER_BASE), 
    ILLUSIONER(35, (EntityType)Entity1_16Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    WOLF(99, (EntityType)Entity1_16Types.ABSTRACT_TAMEABLE_ANIMAL), 
    ENDER_DRAGON(19, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT), 
    ABSTRACT_GOLEM(-1, (EntityType)Entity1_16Types.ABSTRACT_CREATURE), 
    ABSTRACT_SKELETON(-1, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    ABSTRACT_MONSTER(-1, (EntityType)Entity1_16Types.ABSTRACT_CREATURE), 
    SHEEP(68, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    BAT(3, (EntityType)Entity1_16Types.ABSTRACT_AMBIENT), 
    ABSTRACT_HANGING(-1, (EntityType)Entity1_16Types.ENTITY);
    
    private final /* synthetic */ EntityType parent;
    
    ABSTRACT_ANIMAL(-1, (EntityType)Entity1_16Types.ABSTRACT_AGEABLE), 
    SILVERFISH(71, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    HOPPER_MINECART(49, (EntityType)Entity1_16Types.CHESTED_MINECART_ABSTRACT), 
    ENDERMAN(20, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    BEE(4, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT), 
    SPIDER(79, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    BLAZE(5, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    SHULKER(69, (EntityType)Entity1_16Types.ABSTRACT_GOLEM), 
    BOAT(6, (EntityType)Entity1_16Types.ENTITY), 
    ABSTRACT_LIGHTNING(-1, (EntityType)Entity1_16Types.ENTITY), 
    VEX(91, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    CREEPER(12, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    MULE(52, (EntityType)Entity1_16Types.CHESTED_HORSE), 
    PROJECTILE_ABSTRACT(-1, (EntityType)Entity1_16Types.ENTITY), 
    SPAWNER_MINECART(50, (EntityType)Entity1_16Types.MINECART_ABSTRACT), 
    FISHING_BOBBER(106, (EntityType)Entity1_16Types.ENTITY), 
    EXPERIENCE_BOTTLE(85, (EntityType)Entity1_16Types.PROJECTILE_ABSTRACT), 
    COMMAND_BLOCK_MINECART(47, (EntityType)Entity1_16Types.MINECART_ABSTRACT), 
    HUSK(34, (EntityType)Entity1_16Types.ZOMBIE), 
    ABSTRACT_TAMEABLE_ANIMAL(-1, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    MAGMA_CUBE(44, (EntityType)Entity1_16Types.SLIME), 
    EXPERIENCE_ORB(24, (EntityType)Entity1_16Types.ENTITY), 
    FURNACE_MINECART(48, (EntityType)Entity1_16Types.MINECART_ABSTRACT), 
    MOOSHROOM(53, (EntityType)Entity1_16Types.COW), 
    POTION(86, (EntityType)Entity1_16Types.PROJECTILE_ABSTRACT), 
    EVOKER_FANGS(23, (EntityType)Entity1_16Types.ENTITY), 
    EGG(83, (EntityType)Entity1_16Types.PROJECTILE_ABSTRACT), 
    ABSTRACT_FIREBALL(-1, (EntityType)Entity1_16Types.ENTITY), 
    SLIME(74, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT), 
    CHESTED_MINECART_ABSTRACT(-1, (EntityType)Entity1_16Types.MINECART_ABSTRACT), 
    MINECART_ABSTRACT(-1, (EntityType)Entity1_16Types.ENTITY), 
    ABSTRACT_FLYING(-1, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT), 
    DOLPHIN(13, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT), 
    VILLAGER(92, (EntityType)Entity1_16Types.ABSTRACT_AGEABLE), 
    WITHER_SKELETON(97, (EntityType)Entity1_16Types.ABSTRACT_SKELETON), 
    DONKEY(14, (EntityType)Entity1_16Types.CHESTED_HORSE), 
    HOGLIN(32, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    SALMON(67, (EntityType)Entity1_16Types.ABSTRACT_FISHES), 
    WITCH(95, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    ABSTRACT_EVO_ILLU_ILLAGER(-1, (EntityType)Entity1_16Types.ABSTRACT_ILLAGER_BASE), 
    ABSTRACT_ILLAGER_BASE(-1, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    VINDICATOR(93, (EntityType)Entity1_16Types.ABSTRACT_ILLAGER_BASE), 
    MINECART(45, (EntityType)Entity1_16Types.MINECART_ABSTRACT), 
    GIANT(30, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    ZOMBIFIED_PIGLIN(104, (EntityType)Entity1_16Types.ZOMBIE), 
    SHULKER_BULLET(70, (EntityType)Entity1_16Types.ENTITY), 
    PLAYER(105, (EntityType)Entity1_16Types.LIVINGENTITY), 
    LIVINGENTITY(-1, (EntityType)Entity1_16Types.ENTITY), 
    CHESTED_HORSE(-1, (EntityType)Entity1_16Types.ABSTRACT_HORSE), 
    RAVAGER(66, (EntityType)Entity1_16Types.ABSTRACT_MONSTER), 
    IRON_GOLEM(36, (EntityType)Entity1_16Types.ABSTRACT_GOLEM), 
    TRIDENT(87, (EntityType)Entity1_16Types.ABSTRACT_ARROW), 
    ABSTRACT_INSENTIENT(-1, (EntityType)Entity1_16Types.LIVINGENTITY), 
    TURTLE(90, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    SKELETON(72, (EntityType)Entity1_16Types.ABSTRACT_SKELETON), 
    ABSTRACT_AMBIENT(-1, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT), 
    SNOW_GOLEM(76, (EntityType)Entity1_16Types.ABSTRACT_GOLEM), 
    ENTITY(-1), 
    CAVE_SPIDER(8, (EntityType)Entity1_16Types.SPIDER);
    
    private final /* synthetic */ int id;
    
    EVOKER(22, (EntityType)Entity1_16Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    PAINTING(55, (EntityType)Entity1_16Types.ABSTRACT_HANGING), 
    ABSTRACT_AGEABLE(-1, (EntityType)Entity1_16Types.ABSTRACT_CREATURE), 
    CHEST_MINECART(46, (EntityType)Entity1_16Types.CHESTED_MINECART_ABSTRACT), 
    ENDER_PEARL(84, (EntityType)Entity1_16Types.PROJECTILE_ABSTRACT), 
    LLAMA(42, (EntityType)Entity1_16Types.CHESTED_HORSE), 
    STRAY(81, (EntityType)Entity1_16Types.ABSTRACT_SKELETON), 
    TRADER_LLAMA(88, (EntityType)Entity1_16Types.CHESTED_HORSE), 
    GHAST(29, (EntityType)Entity1_16Types.ABSTRACT_FLYING), 
    SPECTRAL_ARROW(78, (EntityType)Entity1_16Types.ABSTRACT_ARROW), 
    RABBIT(65, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL), 
    DROWNED(16, (EntityType)Entity1_16Types.ZOMBIE), 
    LLAMA_SPIT(43, (EntityType)Entity1_16Types.ENTITY), 
    ABSTRACT_FISHES(-1, (EntityType)Entity1_16Types.ABSTRACT_CREATURE), 
    ABSTRACT_WATERMOB(-1, (EntityType)Entity1_16Types.ABSTRACT_INSENTIENT), 
    COW(11, (EntityType)Entity1_16Types.ABSTRACT_ANIMAL);
    
    @Override
    public EntityType getParent() {
        return this.parent;
    }
    
    private Entity1_16Types(final int lllllllllllllIIIllIlIIIlIIlIIlll, final EntityType lllllllllllllIIIllIlIIIlIIlIIllI) {
        this.id = lllllllllllllIIIllIlIIIlIIlIIlll;
        this.parent = lllllllllllllIIIllIlIIIlIIlIIllI;
    }
    
    static {
        TYPES = EntityTypeUtil.toOrderedArray(values());
    }
    
    private Entity1_16Types(final int lllllllllllllIIIllIlIIIlIIlIlllI) {
        this.id = lllllllllllllIIIllIlIIIlIIlIlllI;
        this.parent = null;
    }
    
    public static EntityType getTypeFromId(final int lllllllllllllIIIllIlIIIlIIIllIIl) {
        return EntityTypeUtil.getTypeFromId(Entity1_16Types.TYPES, lllllllllllllIIIllIlIIIlIIIllIIl, Entity1_16Types.ENTITY);
    }
    
    @Override
    public int getId() {
        return this.id;
    }
}
