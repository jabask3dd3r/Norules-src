package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.util.*;

public enum Entity1_15Types implements EntityType
{
    ELDER_GUARDIAN(17, (EntityType)Entity1_15Types.GUARDIAN), 
    ITEM(35, (EntityType)Entity1_15Types.ENTITY), 
    ABSTRACT_FLYING(-1, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    ABSTRACT_EVO_ILLU_ILLAGER(-1, (EntityType)Entity1_15Types.ABSTRACT_ILLAGER_BASE), 
    VINDICATOR(87, (EntityType)Entity1_15Types.ABSTRACT_ILLAGER_BASE), 
    FALLING_BLOCK(26, (EntityType)Entity1_15Types.ENTITY), 
    LIVINGENTITY(-1, (EntityType)Entity1_15Types.ENTITY), 
    SQUID(74, (EntityType)Entity1_15Types.ABSTRACT_WATERMOB), 
    CAVE_SPIDER(8, (EntityType)Entity1_15Types.SPIDER), 
    MULE(49, (EntityType)Entity1_15Types.CHESTED_HORSE), 
    EXPERIENCE_ORB(24, (EntityType)Entity1_15Types.ENTITY), 
    SKELETON(66, (EntityType)Entity1_15Types.ABSTRACT_SKELETON), 
    SPAWNER_MINECART(47, (EntityType)Entity1_15Types.MINECART_ABSTRACT), 
    VEX(84, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    LLAMA(39, (EntityType)Entity1_15Types.CHESTED_HORSE), 
    CHEST_MINECART(43, (EntityType)Entity1_15Types.CHESTED_MINECART_ABSTRACT);
    
    private final /* synthetic */ EntityType parent;
    
    CHESTED_MINECART_ABSTRACT(-1, (EntityType)Entity1_15Types.MINECART_ABSTRACT), 
    DONKEY(13, (EntityType)Entity1_15Types.CHESTED_HORSE), 
    GUARDIAN(31, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    ABSTRACT_SKELETON(-1, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    DROWNED(16, (EntityType)Entity1_15Types.ZOMBIE), 
    PROJECTILE_ABSTRACT(-1, (EntityType)Entity1_15Types.ENTITY), 
    ABSTRACT_CREATURE(-1, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    CHICKEN(9, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    HOPPER_MINECART(46, (EntityType)Entity1_15Types.CHESTED_MINECART_ABSTRACT), 
    FIREBALL(37, (EntityType)Entity1_15Types.ABSTRACT_FIREBALL), 
    FURNACE_MINECART(45, (EntityType)Entity1_15Types.MINECART_ABSTRACT), 
    BLAZE(5, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    POTION(82, (EntityType)Entity1_15Types.PROJECTILE_ABSTRACT), 
    SNOW_GOLEM(70, (EntityType)Entity1_15Types.ABSTRACT_GOLEM), 
    PIG(55, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    ARROW(2, (EntityType)Entity1_15Types.ABSTRACT_ARROW), 
    EYE_OF_ENDER(25, (EntityType)Entity1_15Types.ENTITY), 
    FOX(28, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    SLIME(68, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    ABSTRACT_AMBIENT(-1, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    ABSTRACT_GOLEM(-1, (EntityType)Entity1_15Types.ABSTRACT_CREATURE), 
    HORSE(32, (EntityType)Entity1_15Types.ABSTRACT_HORSE), 
    TNT(59, (EntityType)Entity1_15Types.ENTITY), 
    ZOMBIE(95, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    PUFFERFISH(56, (EntityType)Entity1_15Types.ABSTRACT_FISHES), 
    ABSTRACT_HANGING(-1, (EntityType)Entity1_15Types.ENTITY), 
    FIREWORK_ROCKET(27, (EntityType)Entity1_15Types.ENTITY), 
    HUSK(33, (EntityType)Entity1_15Types.ZOMBIE), 
    CHESTED_HORSE(-1, (EntityType)Entity1_15Types.ABSTRACT_HORSE), 
    ILLUSIONER(34, (EntityType)Entity1_15Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    COD(10, (EntityType)Entity1_15Types.ABSTRACT_FISHES), 
    TROPICAL_FISH(77, (EntityType)Entity1_15Types.ABSTRACT_FISHES), 
    WITHER_SKELETON(92, (EntityType)Entity1_15Types.ABSTRACT_SKELETON), 
    ABSTRACT_TAMEABLE_ANIMAL(-1, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    EXPERIENCE_BOTTLE(81, (EntityType)Entity1_15Types.PROJECTILE_ABSTRACT), 
    MINECART_ABSTRACT(-1, (EntityType)Entity1_15Types.ENTITY), 
    ABSTRACT_INSENTIENT(-1, (EntityType)Entity1_15Types.LIVINGENTITY), 
    OCELOT(51, (EntityType)Entity1_15Types.ABSTRACT_TAMEABLE_ANIMAL), 
    IRON_GOLEM(86, (EntityType)Entity1_15Types.ABSTRACT_GOLEM), 
    ABSTRACT_ARROW(-1, (EntityType)Entity1_15Types.ENTITY), 
    FISHING_BOBBER(102, (EntityType)Entity1_15Types.ENTITY), 
    EGG(79, (EntityType)Entity1_15Types.PROJECTILE_ABSTRACT), 
    ARMOR_STAND(1, (EntityType)Entity1_15Types.LIVINGENTITY), 
    ENDER_PEARL(80, (EntityType)Entity1_15Types.PROJECTILE_ABSTRACT), 
    LIGHTNING_BOLT(100, (EntityType)Entity1_15Types.ABSTRACT_LIGHTNING), 
    SMALL_FIREBALL(69, (EntityType)Entity1_15Types.ABSTRACT_FIREBALL), 
    MOOSHROOM(50, (EntityType)Entity1_15Types.COW), 
    SNOWBALL(71, (EntityType)Entity1_15Types.PROJECTILE_ABSTRACT), 
    BAT(3, (EntityType)Entity1_15Types.ABSTRACT_AMBIENT), 
    SPIDER(73, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    PAINTING(52, (EntityType)Entity1_15Types.ABSTRACT_HANGING), 
    SILVERFISH(65, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    WOLF(94, (EntityType)Entity1_15Types.ABSTRACT_TAMEABLE_ANIMAL), 
    RAVAGER(99, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    GHAST(29, (EntityType)Entity1_15Types.ABSTRACT_FLYING), 
    SHEEP(62, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    PARROT(54, (EntityType)Entity1_15Types.ABSTRACT_PARROT), 
    EVOKER_FANGS(22, (EntityType)Entity1_15Types.ENTITY), 
    ABSTRACT_LIGHTNING(-1, (EntityType)Entity1_15Types.ENTITY), 
    DRAGON_FIREBALL(15, (EntityType)Entity1_15Types.ABSTRACT_FIREBALL), 
    SHULKER_BULLET(64, (EntityType)Entity1_15Types.ENTITY), 
    TURTLE(78, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    PILLAGER(88, (EntityType)Entity1_15Types.ABSTRACT_ILLAGER_BASE), 
    ITEM_FRAME(36, (EntityType)Entity1_15Types.ABSTRACT_HANGING), 
    SKELETON_HORSE(67, (EntityType)Entity1_15Types.ABSTRACT_HORSE);
    
    private final /* synthetic */ int id;
    
    TRIDENT(83, (EntityType)Entity1_15Types.ABSTRACT_ARROW), 
    WITHER(91, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    PLAYER(101, (EntityType)Entity1_15Types.LIVINGENTITY), 
    ENTITY(-1), 
    ABSTRACT_FIREBALL(-1, (EntityType)Entity1_15Types.ENTITY), 
    MINECART(42, (EntityType)Entity1_15Types.MINECART_ABSTRACT), 
    PHANTOM(98, (EntityType)Entity1_15Types.ABSTRACT_FLYING), 
    ABSTRACT_PARROT(-1, (EntityType)Entity1_15Types.ABSTRACT_TAMEABLE_ANIMAL), 
    MAGMA_CUBE(41, (EntityType)Entity1_15Types.SLIME), 
    ABSTRACT_WATERMOB(-1, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    ABSTRACT_MONSTER(-1, (EntityType)Entity1_15Types.ABSTRACT_CREATURE), 
    ABSTRACT_ANIMAL(-1, (EntityType)Entity1_15Types.ABSTRACT_AGEABLE), 
    CREEPER(12, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    SALMON(61, (EntityType)Entity1_15Types.ABSTRACT_FISHES);
    
    private static final /* synthetic */ EntityType[] TYPES;
    
    COW(11, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    ZOMBIE_HORSE(96, (EntityType)Entity1_15Types.ABSTRACT_HORSE), 
    ABSTRACT_ILLAGER_BASE(-1, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    LEASH_KNOT(38, (EntityType)Entity1_15Types.ABSTRACT_HANGING), 
    RABBIT(60, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    BEE(4, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    SPECTRAL_ARROW(72, (EntityType)Entity1_15Types.ABSTRACT_ARROW), 
    COMMAND_BLOCK_MINECART(44, (EntityType)Entity1_15Types.MINECART_ABSTRACT), 
    LLAMA_SPIT(40, (EntityType)Entity1_15Types.ENTITY), 
    WANDERING_TRADER(89, (EntityType)Entity1_15Types.ABSTRACT_AGEABLE), 
    POLAR_BEAR(58, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    SHULKER(63, (EntityType)Entity1_15Types.ABSTRACT_GOLEM), 
    WITHER_SKULL(93, (EntityType)Entity1_15Types.ABSTRACT_FIREBALL), 
    ENDERMAN(20, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    ABSTRACT_FISHES(-1, (EntityType)Entity1_15Types.ABSTRACT_CREATURE), 
    ENDER_DRAGON(19, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    VILLAGER(85, (EntityType)Entity1_15Types.ABSTRACT_AGEABLE), 
    AREA_EFFECT_CLOUD(0, (EntityType)Entity1_15Types.ENTITY), 
    ZOMBIE_VILLAGER(97, (EntityType)Entity1_15Types.ZOMBIE), 
    GIANT(30, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    DOLPHIN(14, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    WITCH(90, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    EVOKER(23, (EntityType)Entity1_15Types.ABSTRACT_EVO_ILLU_ILLAGER), 
    ABSTRACT_HORSE(-1, (EntityType)Entity1_15Types.ABSTRACT_ANIMAL), 
    TNT_MINECART(48, (EntityType)Entity1_15Types.MINECART_ABSTRACT), 
    CAT(7, (EntityType)Entity1_15Types.ABSTRACT_TAMEABLE_ANIMAL), 
    BOAT(6, (EntityType)Entity1_15Types.ENTITY), 
    END_CRYSTAL(18, (EntityType)Entity1_15Types.ENTITY), 
    STRAY(75, (EntityType)Entity1_15Types.ABSTRACT_SKELETON), 
    PANDA(53, (EntityType)Entity1_15Types.ABSTRACT_INSENTIENT), 
    TRADER_LLAMA(76, (EntityType)Entity1_15Types.CHESTED_HORSE), 
    ZOMBIE_PIGMAN(57, (EntityType)Entity1_15Types.ZOMBIE), 
    ENDERMITE(21, (EntityType)Entity1_15Types.ABSTRACT_MONSTER), 
    ABSTRACT_AGEABLE(-1, (EntityType)Entity1_15Types.ABSTRACT_CREATURE);
    
    public static EntityType getTypeFromId(final int lllllllllllllIlIIIlIlIlllIllIIIl) {
        return EntityTypeUtil.getTypeFromId(Entity1_15Types.TYPES, lllllllllllllIlIIIlIlIlllIllIIIl, Entity1_15Types.ENTITY);
    }
    
    static {
        TYPES = EntityTypeUtil.toOrderedArray(values());
    }
    
    private Entity1_15Types(final int lllllllllllllIlIIIlIlIllllIIIllI) {
        this.id = lllllllllllllIlIIIlIlIllllIIIllI;
        this.parent = null;
    }
    
    @Override
    public EntityType getParent() {
        return this.parent;
    }
    
    private Entity1_15Types(final int lllllllllllllIlIIIlIlIlllIlllIlI, final EntityType lllllllllllllIlIIIlIlIlllIlllllI) {
        this.id = lllllllllllllIlIIIlIlIlllIlllIlI;
        this.parent = lllllllllllllIlIIIlIlIlllIlllllI;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
}
