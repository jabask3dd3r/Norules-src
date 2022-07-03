package com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata;

import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;

public enum MetaIndex
{
    PLAYER_ADDITIONAL_HEARTS(Entity1_10Types.EntityType.ENTITY_HUMAN, 17, MetaType1_8.Float, 10, MetaType1_9.Float), 
    IRON_PLAYERMADE(Entity1_10Types.EntityType.IRON_GOLEM, 16, MetaType1_8.Byte, 11, MetaType1_9.Byte), 
    WITHER_UNKNOWN(Entity1_10Types.EntityType.WITHER, 11, MetaType1_8.NonExistent, (MetaType1_9)null), 
    STAND_HEAD_POS(Entity1_10Types.EntityType.ARMOR_STAND, 11, MetaType1_8.Rotation, MetaType1_9.Vector3F), 
    STAND_RA_POS(Entity1_10Types.EntityType.ARMOR_STAND, 14, MetaType1_8.Rotation, MetaType1_9.Vector3F);
    
    private final /* synthetic */ MetaType1_8 oldType;
    
    LIVINGENTITY_NO_AI(Entity1_10Types.EntityType.ENTITY_LIVING, 15, MetaType1_8.Byte, 10, MetaType1_9.Byte), 
    CREEPER_FUSE(Entity1_10Types.EntityType.CREEPER, 16, MetaType1_8.Byte, 11, MetaType1_9.VarInt), 
    FIREWORK_INFO(Entity1_10Types.EntityType.FIREWORK, 8, MetaType1_8.Slot, 5, MetaType1_9.Slot), 
    BOAT_FORWARDDIR(Entity1_10Types.EntityType.BOAT, 18, MetaType1_8.Int, 6, MetaType1_9.VarInt), 
    MINECART_COMMANDBLOCK_OUTPUT(Entity1_10Types.EntityType.MINECART_ABSTRACT, 24, MetaType1_8.String, 12, MetaType1_9.Chat), 
    ZOMBIE_ISCONVERTING(Entity1_10Types.EntityType.ZOMBIE, 14, MetaType1_8.Byte, 13, MetaType1_9.Boolean);
    
    private static final /* synthetic */ HashMap<Pair<Entity1_10Types.EntityType, Integer>, MetaIndex> metadataRewrites;
    
    BOAT_SINCEHIT(Entity1_10Types.EntityType.BOAT, 17, MetaType1_8.Int, 5, MetaType1_9.VarInt), 
    WOLF_BEGGING(Entity1_10Types.EntityType.WOLF, 19, MetaType1_8.Byte, 15, MetaType1_9.Boolean), 
    GHAST_ISATTACKING(Entity1_10Types.EntityType.GHAST, 16, MetaType1_8.Byte, 11, MetaType1_9.Boolean), 
    LIVINGENTITY_POTION_EFFECT_COLOR(Entity1_10Types.EntityType.ENTITY_LIVING, 7, MetaType1_8.Int, MetaType1_9.VarInt), 
    ENDERDRAGON_PHASE(Entity1_10Types.EntityType.ENDER_DRAGON, 11, MetaType1_8.Byte, MetaType1_9.VarInt);
    
    private final /* synthetic */ int index;
    
    BLAZE_ONFIRE(Entity1_10Types.EntityType.BLAZE, 16, MetaType1_8.Byte, 11, MetaType1_9.Byte), 
    WOLF_COLLAR(Entity1_10Types.EntityType.WOLF, 20, MetaType1_8.Byte, 16, MetaType1_9.VarInt), 
    WITHER_TARGET1(Entity1_10Types.EntityType.WITHER, 17, MetaType1_8.Int, 11, MetaType1_9.VarInt), 
    FURNACECART_ISPOWERED(Entity1_10Types.EntityType.MINECART_ABSTRACT, 16, MetaType1_8.Byte, 11, MetaType1_9.Boolean), 
    GUARDIAN_INFO(Entity1_10Types.EntityType.GUARDIAN, 16, MetaType1_8.Int, 11, MetaType1_9.Byte), 
    PLAYER_HAND(Entity1_10Types.EntityType.ENTITY_HUMAN, -1, MetaType1_8.NonExistent, 5, MetaType1_9.Byte), 
    ENDERMAN_ISSCREAMING(Entity1_10Types.EntityType.ENDERMAN, 18, MetaType1_8.Byte, 12, MetaType1_9.Boolean), 
    STAND_LL_POS(Entity1_10Types.EntityType.ARMOR_STAND, 15, MetaType1_8.Rotation, MetaType1_9.Vector3F), 
    ENDERDRAGON_NAME(Entity1_10Types.EntityType.ENDER_DRAGON, 10, MetaType1_8.String, (MetaType1_9)null), 
    MINECART_SHAKINGDIRECTION(Entity1_10Types.EntityType.MINECART_ABSTRACT, 18, MetaType1_8.Int, 6, MetaType1_9.VarInt), 
    VILLAGER_PROFESSION(Entity1_10Types.EntityType.VILLAGER, 16, MetaType1_8.Int, 12, MetaType1_9.VarInt), 
    MINECART_SHOWBLOCK(Entity1_10Types.EntityType.MINECART_ABSTRACT, 22, MetaType1_8.Byte, 10, MetaType1_9.Boolean), 
    STAND_BODY_POS(Entity1_10Types.EntityType.ARMOR_STAND, 12, MetaType1_8.Rotation, MetaType1_9.Vector3F), 
    WITHER_TARGET3(Entity1_10Types.EntityType.WITHER, 19, MetaType1_8.Int, 13, MetaType1_9.VarInt), 
    ZOMBIE_ISCHILD(Entity1_10Types.EntityType.ZOMBIE, 12, MetaType1_8.Byte, 11, MetaType1_9.Boolean), 
    HORSE_ARMOR(Entity1_10Types.EntityType.HORSE, 22, MetaType1_8.Int, 16, MetaType1_9.VarInt), 
    SHEEP_COLOR(Entity1_10Types.EntityType.SHEEP, 16, MetaType1_8.Byte, 12, MetaType1_9.Byte), 
    HORSE_TYPE(Entity1_10Types.EntityType.HORSE, 19, MetaType1_8.Byte, 13, MetaType1_9.VarInt), 
    ENTITY_STATUS(Entity1_10Types.EntityType.ENTITY, 0, MetaType1_8.Byte, MetaType1_9.Byte), 
    ITEM_ITEM(Entity1_10Types.EntityType.DROPPED_ITEM, 10, MetaType1_8.Slot, 5, MetaType1_9.Slot), 
    WITHER_INVULN_TIME(Entity1_10Types.EntityType.WITHER, 20, MetaType1_8.Int, 14, MetaType1_9.VarInt), 
    SPIDER_CIMBING(Entity1_10Types.EntityType.SPIDER, 16, MetaType1_8.Byte, 11, MetaType1_9.Byte), 
    GUARDIAN_TARGET(Entity1_10Types.EntityType.GUARDIAN, 17, MetaType1_8.Int, 12, MetaType1_9.VarInt), 
    ENTITY_AIR(Entity1_10Types.EntityType.ENTITY, 1, MetaType1_8.Short, MetaType1_9.VarInt), 
    MINECART_COMMANDBLOCK_COMMAND(Entity1_10Types.EntityType.MINECART_ABSTRACT, 23, MetaType1_8.String, 11, MetaType1_9.String), 
    WOLF_HEALTH(Entity1_10Types.EntityType.WOLF, 18, MetaType1_8.Float, 14, MetaType1_9.Float);
    
    private final /* synthetic */ int newIndex;
    
    PLAYER_SKIN_FLAGS(Entity1_10Types.EntityType.ENTITY_HUMAN, 10, MetaType1_8.Byte, 12, MetaType1_9.Byte), 
    BOAT_DMGTAKEN(Entity1_10Types.EntityType.BOAT, 19, MetaType1_8.Float, 7, MetaType1_9.Float), 
    LIVINGENTITY_HEALTH(Entity1_10Types.EntityType.ENTITY_LIVING, 6, MetaType1_8.Float, MetaType1_9.Float), 
    LIVINGENTITY_NUMBER_OF_ARROWS_IN(Entity1_10Types.EntityType.ENTITY_LIVING, 9, MetaType1_8.Byte, MetaType1_9.VarInt), 
    MINECART_BLOCK(Entity1_10Types.EntityType.MINECART_ABSTRACT, 20, MetaType1_8.Int, 8, MetaType1_9.VarInt), 
    OCELOT_TYPE(Entity1_10Types.EntityType.OCELOT, 18, MetaType1_8.Byte, 14, MetaType1_9.VarInt), 
    PLAYER_SCORE(Entity1_10Types.EntityType.ENTITY_HUMAN, 18, MetaType1_8.Int, 11, MetaType1_9.VarInt), 
    PLAYER_HUMAN_BYTE(Entity1_10Types.EntityType.ENTITY_HUMAN, 16, MetaType1_8.Byte, (MetaType1_9)null);
    
    private final /* synthetic */ Entity1_10Types.EntityType clazz;
    
    SKELETON_TYPE(Entity1_10Types.EntityType.SKELETON, 13, MetaType1_8.Byte, 11, MetaType1_9.VarInt), 
    ENDERMAN_BLOCKDATA(Entity1_10Types.EntityType.ENDERMAN, 17, MetaType1_8.Byte, (MetaType1_9)null), 
    WITHER_PROPERTIES(Entity1_10Types.EntityType.WITHER, 10, MetaType1_8.Byte, (MetaType1_9)null), 
    ENDERMAN_BLOCKSTATE(Entity1_10Types.EntityType.ENDERMAN, 16, MetaType1_8.Short, 11, MetaType1_9.BlockID), 
    ITEMFRAME_ITEM(Entity1_10Types.EntityType.ITEM_FRAME, 8, MetaType1_8.Slot, 5, MetaType1_9.Slot), 
    CREEPER_ISPOWERED(Entity1_10Types.EntityType.CREEPER, 17, MetaType1_8.Byte, 12, MetaType1_9.Boolean), 
    ITEMFRAME_ROTATION(Entity1_10Types.EntityType.ITEM_FRAME, 9, MetaType1_8.Byte, 6, MetaType1_9.VarInt), 
    WITHERSKULL_INVULN(Entity1_10Types.EntityType.WITHER_SKULL, 10, MetaType1_8.Byte, 5, MetaType1_9.Boolean), 
    SLIME_SIZE(Entity1_10Types.EntityType.SLIME, 16, MetaType1_8.Byte, 11, MetaType1_9.VarInt), 
    HORSE_SUBTYPE(Entity1_10Types.EntityType.HORSE, 20, MetaType1_8.Int, 14, MetaType1_9.VarInt), 
    SOMETHING_ANTICHEAT_PLUGINS_FOR_SOME_REASON_USE(Entity1_10Types.EntityType.ENTITY_HUMAN, 11, MetaType1_8.Byte, (MetaType1_9)null), 
    TAMING_INFO(Entity1_10Types.EntityType.ENTITY_TAMEABLE_ANIMAL, 16, MetaType1_8.Byte, 12, MetaType1_9.Byte), 
    RABBIT_TYPE(Entity1_10Types.EntityType.RABBIT, 18, MetaType1_8.Byte, 12, MetaType1_9.VarInt), 
    TAMING_OWNER(Entity1_10Types.EntityType.ENTITY_TAMEABLE_ANIMAL, 17, MetaType1_8.String, 13, MetaType1_9.OptUUID), 
    ENDERDRAGON_UNKNOWN(Entity1_10Types.EntityType.ENDER_DRAGON, 5, MetaType1_8.Byte, (MetaType1_9)null), 
    STAND_RL_POS(Entity1_10Types.EntityType.ARMOR_STAND, 16, MetaType1_8.Rotation, MetaType1_9.Vector3F), 
    HORSE_OWNER(Entity1_10Types.EntityType.HORSE, 21, MetaType1_8.String, 15, MetaType1_9.OptUUID), 
    MINECART_BLOCK_Y(Entity1_10Types.EntityType.MINECART_ABSTRACT, 21, MetaType1_8.Int, 9, MetaType1_9.VarInt), 
    ENTITY_NAMETAG(Entity1_10Types.EntityType.ENTITY, 2, MetaType1_8.String, MetaType1_9.String);
    
    private final /* synthetic */ MetaType1_9 newType;
    
    AGEABLE_AGE(Entity1_10Types.EntityType.ENTITY_AGEABLE, 12, MetaType1_8.Byte, 11, MetaType1_9.Boolean), 
    ENDERDRAGON_FLAG(Entity1_10Types.EntityType.ENDER_DRAGON, 15, MetaType1_8.Byte, (MetaType1_9)null), 
    STAND_INFO(Entity1_10Types.EntityType.ARMOR_STAND, 10, MetaType1_8.Byte, MetaType1_9.Byte), 
    WITHER_TARGET2(Entity1_10Types.EntityType.WITHER, 18, MetaType1_8.Int, 12, MetaType1_9.VarInt), 
    MINECART_SHAKINGPOWER(Entity1_10Types.EntityType.MINECART_ABSTRACT, 17, MetaType1_8.Int, 5, MetaType1_9.VarInt), 
    LIVINGENTITY_IS_POTION_AMBIENT(Entity1_10Types.EntityType.ENTITY_LIVING, 8, MetaType1_8.Byte, MetaType1_9.Boolean), 
    STAND_LA_POS(Entity1_10Types.EntityType.ARMOR_STAND, 13, MetaType1_8.Rotation, MetaType1_9.Vector3F), 
    WITCH_AGGRO(Entity1_10Types.EntityType.WITCH, 21, MetaType1_8.Byte, 11, MetaType1_9.Boolean), 
    MINECART_DAMAGETAKEN(Entity1_10Types.EntityType.MINECART_ABSTRACT, 19, MetaType1_8.Float, 7, MetaType1_9.Float), 
    ENTITY_ALWAYS_SHOW_NAMETAG(Entity1_10Types.EntityType.ENTITY, 3, MetaType1_8.Byte, MetaType1_9.Boolean), 
    ZOMBIE_ISVILLAGER(Entity1_10Types.EntityType.ZOMBIE, 13, MetaType1_8.Byte, 12, MetaType1_9.VarInt), 
    CREEPER_ISIGNITED(Entity1_10Types.EntityType.CREEPER, 18, MetaType1_8.Byte, 13, MetaType1_9.Boolean), 
    ARROW_ISCRIT(Entity1_10Types.EntityType.ARROW, 16, MetaType1_8.Byte, 5, MetaType1_9.Byte), 
    BAT_ISHANGING(Entity1_10Types.EntityType.BAT, 16, MetaType1_8.Byte, 11, MetaType1_9.Byte), 
    ENTITY_SILENT(Entity1_10Types.EntityType.ENTITY, 4, MetaType1_8.Byte, MetaType1_9.Boolean), 
    HORSE_INFO(Entity1_10Types.EntityType.HORSE, 16, MetaType1_8.Int, 12, MetaType1_9.Byte), 
    ENDERCRYSTAL_HEALTH(Entity1_10Types.EntityType.ENDER_CRYSTAL, 8, MetaType1_8.Int, (MetaType1_9)null), 
    PIG_SADDLE(Entity1_10Types.EntityType.PIG, 16, MetaType1_8.Byte, 12, MetaType1_9.Boolean);
    
    private MetaIndex(final Entity1_10Types.EntityType llllllllllllllIIIlllIIIllIIllllI, final int llllllllllllllIIIlllIIIllIlIIlIl, final MetaType1_8 llllllllllllllIIIlllIIIllIlIIlII, final int llllllllllllllIIIlllIIIllIlIIIll, final MetaType1_9 llllllllllllllIIIlllIIIllIlIIIlI) {
        this.clazz = llllllllllllllIIIlllIIIllIIllllI;
        this.index = llllllllllllllIIIlllIIIllIlIIlIl;
        this.oldType = llllllllllllllIIIlllIIIllIlIIlII;
        this.newIndex = llllllllllllllIIIlllIIIllIlIIIll;
        this.newType = llllllllllllllIIIlllIIIllIlIIIlI;
    }
    
    private static Optional<MetaIndex> getIndex(final EntityType llllllllllllllIIIlllIIIlIlllIlII, final int llllllllllllllIIIlllIIIlIlllIIlI) {
        final Pair llllllllllllllIIIlllIIIlIlllIlIl = new Pair((X)llllllllllllllIIIlllIIIlIlllIlII, (Y)llllllllllllllIIIlllIIIlIlllIIlI);
        return Optional.ofNullable(MetaIndex.metadataRewrites.get(llllllllllllllIIIlllIIIlIlllIlIl));
    }
    
    public static MetaIndex searchIndex(final EntityType llllllllllllllIIIlllIIIlIlIlIlll, final int llllllllllllllIIIlllIIIlIlIlIlIl) {
        EntityType llllllllllllllIIIlllIIIlIlIllIIl = llllllllllllllIIIlllIIIlIlIlIlll;
        do {
            final Optional<MetaIndex> llllllllllllllIIIlllIIIlIlIlllll = getIndex(llllllllllllllIIIlllIIIlIlIllIIl, llllllllllllllIIIlllIIIlIlIlIlIl);
            if (llllllllllllllIIIlllIIIlIlIlllll.isPresent()) {
                return llllllllllllllIIIlllIIIlIlIlllll.get();
            }
            llllllllllllllIIIlllIIIlIlIllIIl = llllllllllllllIIIlllIIIlIlIllIIl.getParent();
        } while (llllllllllllllIIIlllIIIlIlIllIIl != null);
        return null;
    }
    
    public MetaType1_8 getOldType() {
        return this.oldType;
    }
    
    public MetaType1_9 getNewType() {
        return this.newType;
    }
    
    private MetaIndex(final Entity1_10Types.EntityType llllllllllllllIIIlllIIIllIllllIl, final int llllllllllllllIIIlllIIIlllIIlIII, final MetaType1_8 llllllllllllllIIIlllIIIlllIIIlll, final MetaType1_9 llllllllllllllIIIlllIIIllIlllIlI) {
        this.clazz = llllllllllllllIIIlllIIIllIllllIl;
        this.index = llllllllllllllIIIlllIIIlllIIlIII;
        this.newIndex = llllllllllllllIIIlllIIIlllIIlIII;
        this.oldType = llllllllllllllIIIlllIIIlllIIIlll;
        this.newType = llllllllllllllIIIlllIIIllIlllIlI;
    }
    
    static {
        metadataRewrites = new HashMap<Pair<Entity1_10Types.EntityType, Integer>, MetaIndex>();
        final float llllllllllllllIIIlllIIIIIlIllIIl = (Object)values();
        final short llllllllllllllIIIlllIIIIIlIlIlll = (short)llllllllllllllIIIlllIIIIIlIllIIl.length;
        for (boolean llllllllllllllIIIlllIIIIIlIlIllI = false; (llllllllllllllIIIlllIIIIIlIlIllI ? 1 : 0) < llllllllllllllIIIlllIIIIIlIlIlll; ++llllllllllllllIIIlllIIIIIlIlIllI) {
            final MetaIndex llllllllllllllIIIlllIIIIIlIllIll = llllllllllllllIIIlllIIIIIlIllIIl[llllllllllllllIIIlllIIIIIlIlIllI];
            MetaIndex.metadataRewrites.put(new Pair<Entity1_10Types.EntityType, Integer>(llllllllllllllIIIlllIIIIIlIllIll.clazz, llllllllllllllIIIlllIIIIIlIllIll.index), llllllllllllllIIIlllIIIIIlIllIll);
        }
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public Entity1_10Types.EntityType getClazz() {
        return this.clazz;
    }
    
    public int getNewIndex() {
        return this.newIndex;
    }
}
