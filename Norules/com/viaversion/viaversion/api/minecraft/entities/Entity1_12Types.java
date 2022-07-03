package com.viaversion.viaversion.api.minecraft.entities;

import com.viaversion.viaversion.api.*;
import java.util.*;

public class Entity1_12Types
{
    public static EntityType getTypeFromId(final int llllllllllllllllllllIllIlIlIIIII, final boolean llllllllllllllllllllIllIlIlIIIlI) {
        Optional<EntityType> llllllllllllllllllllIllIlIlIIIIl = null;
        if (llllllllllllllllllllIllIlIlIIIlI) {
            final Optional<EntityType> llllllllllllllllllllIllIlIlIIlII = ObjectType.getPCEntity(llllllllllllllllllllIllIlIlIIIII);
        }
        else {
            llllllllllllllllllllIllIlIlIIIIl = EntityType.findById(llllllllllllllllllllIllIlIlIIIII);
        }
        if (!llllllllllllllllllllIllIlIlIIIIl.isPresent()) {
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Could not find 1.12 type id ").append(llllllllllllllllllllIllIlIlIIIII).append(" isObject=").append(llllllllllllllllllllIllIlIlIIIlI)));
            return EntityType.ENTITY;
        }
        return llllllllllllllllllllIllIlIlIIIIl.get();
    }
    
    public enum ObjectType implements com.viaversion.viaversion.api.minecraft.entities.ObjectType
    {
        POTION(73, EntityType.SPLASH_POTION), 
        ITEM(2, EntityType.DROPPED_ITEM), 
        MINECART(10, EntityType.MINECART_RIDEABLE), 
        ENDER_CRYSTAL(51, EntityType.ENDER_CRYSTAL), 
        SPECTRAL_ARROW(91, EntityType.SPECTRAL_ARROW);
        
        private final /* synthetic */ int id;
        
        EGG(62, EntityType.EGG), 
        SNOWBALL(61, EntityType.SNOWBALL), 
        EVOCATION_FANGS(79, EntityType.EVOCATION_FANGS), 
        LIAMA_SPIT(68, EntityType.LIAMA_SPIT), 
        TNT_PRIMED(50, EntityType.PRIMED_TNT);
        
        private final /* synthetic */ EntityType type;
        private static final /* synthetic */ Map<Integer, ObjectType> TYPES;
        
        SHULKER_BULLET(67, EntityType.SHULKER_BULLET), 
        FALLING_BLOCK(70, EntityType.FALLING_BLOCK), 
        FIREWORK(76, EntityType.FIREWORK), 
        BOAT(1, EntityType.BOAT), 
        DRAGON_FIREBALL(93, EntityType.DRAGON_FIREBALL), 
        ENDER_SIGNAL(72, EntityType.ENDER_SIGNAL), 
        TIPPED_ARROW(60, EntityType.ARROW), 
        ITEM_FRAME(71, EntityType.ITEM_FRAME), 
        SMALL_FIREBALL(64, EntityType.SMALL_FIREBALL), 
        WITHER_SKULL(66, EntityType.WITHER_SKULL), 
        FISHIHNG_HOOK(90, EntityType.FISHING_HOOK), 
        FIREBALL(63, EntityType.FIREBALL), 
        ARMOR_STAND(78, EntityType.ARMOR_STAND), 
        THROWN_EXP_BOTTLE(75, EntityType.THROWN_EXP_BOTTLE), 
        LEASH(77, EntityType.LEASH_HITCH), 
        ENDER_PEARL(65, EntityType.ENDER_PEARL), 
        AREA_EFFECT_CLOUD(3, EntityType.AREA_EFFECT_CLOUD);
        
        @Override
        public int getId() {
            return this.id;
        }
        
        static {
            TYPES = new HashMap<Integer, ObjectType>();
            final int lllllllllllllIIllIlIllIIIllIIIIl = (Object)values();
            final byte lllllllllllllIIllIlIllIIIllIIIII = (byte)lllllllllllllIIllIlIllIIIllIIIIl.length;
            for (char lllllllllllllIIllIlIllIIIlIlllll = '\0'; lllllllllllllIIllIlIllIIIlIlllll < lllllllllllllIIllIlIllIIIllIIIII; ++lllllllllllllIIllIlIllIIIlIlllll) {
                final ObjectType lllllllllllllIIllIlIllIIIllIIIlI = lllllllllllllIIllIlIllIIIllIIIIl[lllllllllllllIIllIlIllIIIlIlllll];
                ObjectType.TYPES.put(lllllllllllllIIllIlIllIIIllIIIlI.id, lllllllllllllIIllIlIllIIIllIIIlI);
            }
        }
        
        private ObjectType(final int lllllllllllllIIllIlIllIIIlllllll, final EntityType lllllllllllllIIllIlIllIIIllllllI) {
            this.id = lllllllllllllIIllIlIllIIIlllllll;
            this.type = lllllllllllllIIllIlIllIIIllllllI;
        }
        
        @Override
        public EntityType getType() {
            return this.type;
        }
        
        public static Optional<ObjectType> findById(final int lllllllllllllIIllIlIllIIIlllIIII) {
            if (lllllllllllllIIllIlIllIIIlllIIII == -1) {
                return Optional.empty();
            }
            return Optional.ofNullable(ObjectType.TYPES.get(lllllllllllllIIllIlIllIIIlllIIII));
        }
        
        public static Optional<EntityType> getPCEntity(final int lllllllllllllIIllIlIllIIIllIllIl) {
            final Optional<ObjectType> lllllllllllllIIllIlIllIIIllIllII = findById(lllllllllllllIIllIlIllIIIllIllIl);
            if (!lllllllllllllIIllIlIllIIIllIllII.isPresent()) {
                return Optional.empty();
            }
            return Optional.of(lllllllllllllIIllIlIllIIIllIllII.get().type);
        }
    }
    
    public enum EntityType implements com.viaversion.viaversion.api.minecraft.entities.EntityType
    {
        ENTITY_INSENTIENT(-1, EntityType.ENTITY_LIVING), 
        BOAT(41, EntityType.ENTITY), 
        SPECTRAL_ARROW(24, EntityType.ARROW), 
        WITHER_SKELETON(5, EntityType.ABSTRACT_SKELETON), 
        PLAYER(-1, EntityType.ENTITY_HUMAN), 
        WOLF(95, EntityType.ENTITY_TAMEABLE_ANIMAL), 
        EVOCATION_FANGS(33, EntityType.ENTITY), 
        EXPERIENCE_ORB(2, EntityType.ENTITY), 
        SHULKER_BULLET(25, EntityType.ENTITY), 
        FALLING_BLOCK(21, EntityType.ENTITY);
        
        private final /* synthetic */ int id;
        
        IRON_GOLEM(99, EntityType.ENTITY_INSENTIENT), 
        SPLASH_POTION(-1, EntityType.ENTITY), 
        CHICKEN(93, EntityType.ENTITY_AGEABLE), 
        MINECART_FURNACE(44, EntityType.MINECART_ABSTRACT), 
        LEASH_HITCH(8, EntityType.ENTITY), 
        HORSE(100, EntityType.ABSTRACT_HORSE);
        
        private static final /* synthetic */ Map<Integer, EntityType> TYPES;
        
        CAVE_SPIDER(59, EntityType.SPIDER), 
        LIAMA(103, EntityType.CHESTED_HORSE), 
        MINECART_ABSTRACT(-1, EntityType.ENTITY), 
        SHEEP(91, EntityType.ENTITY_AGEABLE), 
        DRAGON_FIREBALL(26, EntityType.FIREBALL), 
        LIGHTNING(-1, EntityType.ENTITY), 
        DROPPED_ITEM(1, EntityType.ENTITY), 
        ENDER_CRYSTAL(200, EntityType.ENTITY), 
        GHAST(56, EntityType.ENTITY_INSENTIENT), 
        SHULKER(69, EntityType.IRON_GOLEM), 
        ABSTRACT_HORSE(-1, EntityType.ENTITY_AGEABLE), 
        ENTITY_TAMEABLE_ANIMAL(-1, EntityType.ENTITY_AGEABLE), 
        WITHER(64, EntityType.ENTITY_INSENTIENT), 
        PARROT(105, EntityType.ENTITY_TAMEABLE_ANIMAL), 
        ENDER_DRAGON(63, EntityType.ENTITY_INSENTIENT), 
        MINECART_TNT(45, EntityType.MINECART_ABSTRACT), 
        OCELOT(98, EntityType.ENTITY_TAMEABLE_ANIMAL), 
        SPIDER(52, EntityType.ENTITY_INSENTIENT), 
        ELDER_GUARDIAN(4, EntityType.GUARDIAN), 
        PAINTING(9, EntityType.ENTITY), 
        FIREWORK(22, EntityType.ENTITY), 
        DONKEY(31, EntityType.CHESTED_HORSE), 
        COW(92, EntityType.ENTITY_AGEABLE), 
        VEX(35, EntityType.ENTITY_INSENTIENT), 
        VINDICATION_ILLAGER(36, EntityType.ENTITY_ILLAGER_ABSTRACT), 
        ARROW(10, EntityType.ENTITY), 
        EGG(-1, EntityType.ENTITY), 
        ENDER_SIGNAL(15, EntityType.ENTITY), 
        ZOMBIE_VILLAGER(27, EntityType.ZOMBIE), 
        BLAZE(61, EntityType.ENTITY_INSENTIENT), 
        PIG(90, EntityType.ENTITY_AGEABLE), 
        FIREBALL(12, EntityType.ENTITY), 
        VILLAGER(120, EntityType.ENTITY_AGEABLE), 
        PIG_ZOMBIE(57, EntityType.ZOMBIE), 
        MINECART_HOPPER(46, EntityType.MINECART_ABSTRACT), 
        SKELETON_HORSE(28, EntityType.ABSTRACT_HORSE), 
        SLIME(55, EntityType.ENTITY_INSENTIENT), 
        MULE(32, EntityType.CHESTED_HORSE), 
        AREA_EFFECT_CLOUD(-1, EntityType.ENTITY), 
        SKELETON(51, EntityType.ABSTRACT_SKELETON), 
        MAGMA_CUBE(62, EntityType.SLIME), 
        MINECART_MOB_SPAWNER(47, EntityType.MINECART_ABSTRACT), 
        ILLUSION_ILLAGER(37, EntityType.EVOCATION_ILLAGER), 
        SMALL_FIREBALL(13, EntityType.ENTITY), 
        WITHER_SKULL(19, EntityType.ENTITY), 
        COMPLEX_PART(-1, EntityType.ENTITY), 
        THROWN_EXP_BOTTLE(17, EntityType.ENTITY), 
        MINECART_CHEST(43, EntityType.MINECART_ABSTRACT), 
        POLAR_BEAR(102, EntityType.ENTITY_AGEABLE), 
        RABBIT(101, EntityType.ENTITY_AGEABLE), 
        CREEPER(50, EntityType.ENTITY_INSENTIENT), 
        BAT(65, EntityType.ENTITY_INSENTIENT), 
        ENTITY_LIVING(-1, EntityType.ENTITY), 
        ENDERMITE(67, EntityType.ENTITY_INSENTIENT), 
        SNOWMAN(97, EntityType.IRON_GOLEM), 
        LIAMA_SPIT(-1, EntityType.ENTITY);
        
        private final /* synthetic */ EntityType parent;
        
        ENTITY_AGEABLE(-1, EntityType.ENTITY_INSENTIENT), 
        WEATHER(-1, EntityType.ENTITY), 
        ENTITY_HUMAN(-1, EntityType.ENTITY_LIVING), 
        STRAY(6, EntityType.ABSTRACT_SKELETON), 
        WITCH(66, EntityType.ENTITY_INSENTIENT), 
        PRIMED_TNT(20, EntityType.ENTITY), 
        LINGERING_POTION(-1, EntityType.SPLASH_POTION), 
        GIANT(53, EntityType.ENTITY_INSENTIENT), 
        EVOCATION_ILLAGER(34, EntityType.ENTITY_ILLAGER_ABSTRACT), 
        ABSTRACT_SKELETON(-1, EntityType.ENTITY_INSENTIENT), 
        ZOMBIE_HORSE(29, EntityType.ABSTRACT_HORSE), 
        SILVERFISH(60, EntityType.ENTITY_INSENTIENT), 
        SQUID(94, EntityType.ENTITY_INSENTIENT), 
        ARMOR_STAND(30, EntityType.ENTITY_LIVING), 
        MINECART_RIDEABLE(42, EntityType.MINECART_ABSTRACT), 
        ENTITY(-1), 
        ENDER_PEARL(14, EntityType.ENTITY), 
        MINECART_COMMAND(40, EntityType.MINECART_ABSTRACT), 
        ENDERMAN(58, EntityType.ENTITY_INSENTIENT), 
        GUARDIAN(68, EntityType.ENTITY_INSENTIENT), 
        FISHING_HOOK(-1, EntityType.ENTITY), 
        HUSK(23, EntityType.ZOMBIE), 
        SNOWBALL(11, EntityType.ENTITY), 
        CHESTED_HORSE(-1, EntityType.ABSTRACT_HORSE), 
        ZOMBIE(54, EntityType.ENTITY_INSENTIENT), 
        ITEM_FRAME(18, EntityType.ENTITY), 
        MUSHROOM_COW(96, EntityType.COW), 
        ENTITY_ILLAGER_ABSTRACT(-1, EntityType.ENTITY_INSENTIENT);
        
        private EntityType(final int lllllllllllllllIllllIIlIIlllIlIl, final EntityType lllllllllllllllIllllIIlIIlllIlII) {
            this.id = lllllllllllllllIllllIIlIIlllIlIl;
            this.parent = lllllllllllllllIllllIIlIIlllIlII;
        }
        
        private EntityType(final int lllllllllllllllIllllIIlIlIIIIIIl) {
            this.id = lllllllllllllllIllllIIlIlIIIIIIl;
            this.parent = null;
        }
        
        public static Optional<EntityType> findById(final int lllllllllllllllIllllIIlIIllIllII) {
            if (lllllllllllllllIllllIIlIIllIllII == -1) {
                return Optional.empty();
            }
            return Optional.ofNullable(EntityType.TYPES.get(lllllllllllllllIllllIIlIIllIllII));
        }
        
        static {
            TYPES = new HashMap<Integer, EntityType>();
            final boolean lllllllllllllllIllllIIlIIllIIIlI = (Object)values();
            for (long lllllllllllllllIllllIIlIIllIIIIl = lllllllllllllllIllllIIlIIllIIIlI.length, lllllllllllllllIllllIIlIIllIIIII = 0; lllllllllllllllIllllIIlIIllIIIII < lllllllllllllllIllllIIlIIllIIIIl; ++lllllllllllllllIllllIIlIIllIIIII) {
                final EntityType lllllllllllllllIllllIIlIIllIIIll = lllllllllllllllIllllIIlIIllIIIlI[lllllllllllllllIllllIIlIIllIIIII];
                EntityType.TYPES.put(lllllllllllllllIllllIIlIIllIIIll.id, lllllllllllllllIllllIIlIIllIIIll);
            }
        }
        
        @Override
        public EntityType getParent() {
            return this.parent;
        }
        
        @Override
        public int getId() {
            return this.id;
        }
    }
}
