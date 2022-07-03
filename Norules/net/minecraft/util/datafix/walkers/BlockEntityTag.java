package net.minecraft.util.datafix.walkers;

import java.util.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;

public class BlockEntityTag implements IDataWalker
{
    private static final /* synthetic */ Map<String, String> ITEM_ID_TO_BLOCK_ENTITY_ID;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ Map<String, String> field_190892_b;
    
    static {
        LOGGER = LogManager.getLogger();
        field_190892_b = Maps.newHashMap();
        ITEM_ID_TO_BLOCK_ENTITY_ID = Maps.newHashMap();
        Map<String, String> lllllllllllllIlIlIlIIllIIIllllIl = BlockEntityTag.field_190892_b;
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:furnace", "Furnace");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:lit_furnace", "Furnace");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:chest", "Chest");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:trapped_chest", "Chest");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:ender_chest", "EnderChest");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:jukebox", "RecordPlayer");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:dispenser", "Trap");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:dropper", "Dropper");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:sign", "Sign");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:mob_spawner", "MobSpawner");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:noteblock", "Music");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:brewing_stand", "Cauldron");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:enhanting_table", "EnchantTable");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:command_block", "CommandBlock");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:beacon", "Beacon");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:skull", "Skull");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:daylight_detector", "DLDetector");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:hopper", "Hopper");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:banner", "Banner");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:flower_pot", "FlowerPot");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:repeating_command_block", "CommandBlock");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:chain_command_block", "CommandBlock");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:standing_sign", "Sign");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:wall_sign", "Sign");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:piston_head", "Piston");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:daylight_detector_inverted", "DLDetector");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:unpowered_comparator", "Comparator");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:powered_comparator", "Comparator");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:wall_banner", "Banner");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:standing_banner", "Banner");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:structure_block", "Structure");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:end_portal", "Airportal");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:end_gateway", "EndGateway");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:shield", "Shield");
        lllllllllllllIlIlIlIIllIIIllllIl = BlockEntityTag.ITEM_ID_TO_BLOCK_ENTITY_ID;
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:furnace", "minecraft:furnace");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:lit_furnace", "minecraft:furnace");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:chest", "minecraft:chest");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:trapped_chest", "minecraft:chest");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:ender_chest", "minecraft:enderchest");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:jukebox", "minecraft:jukebox");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:dispenser", "minecraft:dispenser");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:dropper", "minecraft:dropper");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:sign", "minecraft:sign");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:mob_spawner", "minecraft:mob_spawner");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:noteblock", "minecraft:noteblock");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:brewing_stand", "minecraft:brewing_stand");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:enhanting_table", "minecraft:enchanting_table");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:command_block", "minecraft:command_block");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:beacon", "minecraft:beacon");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:skull", "minecraft:skull");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:daylight_detector", "minecraft:daylight_detector");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:hopper", "minecraft:hopper");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:banner", "minecraft:banner");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:flower_pot", "minecraft:flower_pot");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:repeating_command_block", "minecraft:command_block");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:chain_command_block", "minecraft:command_block");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:white_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:orange_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:magenta_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:light_blue_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:yellow_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:lime_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:pink_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:gray_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:silver_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:cyan_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:purple_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:blue_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:brown_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:green_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:red_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:black_shulker_box", "minecraft:shulker_box");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:bed", "minecraft:bed");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:standing_sign", "minecraft:sign");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:wall_sign", "minecraft:sign");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:piston_head", "minecraft:piston");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:daylight_detector_inverted", "minecraft:daylight_detector");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:unpowered_comparator", "minecraft:comparator");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:powered_comparator", "minecraft:comparator");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:wall_banner", "minecraft:banner");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:standing_banner", "minecraft:banner");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:structure_block", "minecraft:structure_block");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:end_portal", "minecraft:end_portal");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:end_gateway", "minecraft:end_gateway");
        lllllllllllllIlIlIlIIllIIIllllIl.put("minecraft:shield", "minecraft:shield");
    }
    
    @Nullable
    private static String getBlockEntityID(final int lllllllllllllIlIlIlIIllIIIllIlII, final String lllllllllllllIlIlIlIIllIIIllIlIl) {
        return (lllllllllllllIlIlIlIIllIIIllIlII < 515) ? BlockEntityTag.field_190892_b.get(new ResourceLocation(lllllllllllllIlIlIlIIllIIIllIlIl).toString()) : BlockEntityTag.ITEM_ID_TO_BLOCK_ENTITY_ID.get(new ResourceLocation(lllllllllllllIlIlIlIIllIIIllIlIl).toString());
    }
    
    @Override
    public NBTTagCompound process(final IDataFixer lllllllllllllIlIlIlIIllIIIlIlIIl, final NBTTagCompound lllllllllllllIlIlIlIIllIIIIlllll, final int lllllllllllllIlIlIlIIllIIIlIIlll) {
        if (!lllllllllllllIlIlIlIIllIIIIlllll.hasKey("tag", 10)) {
            return lllllllllllllIlIlIlIIllIIIIlllll;
        }
        final NBTTagCompound lllllllllllllIlIlIlIIllIIIlIIllI = lllllllllllllIlIlIlIIllIIIIlllll.getCompoundTag("tag");
        if (lllllllllllllIlIlIlIIllIIIlIIllI.hasKey("BlockEntityTag", 10)) {
            final NBTTagCompound lllllllllllllIlIlIlIIllIIIlIIlIl = lllllllllllllIlIlIlIIllIIIlIIllI.getCompoundTag("BlockEntityTag");
            final String lllllllllllllIlIlIlIIllIIIlIIlII = lllllllllllllIlIlIlIIllIIIIlllll.getString("id");
            final String lllllllllllllIlIlIlIIllIIIlIIIll = getBlockEntityID(lllllllllllllIlIlIlIIllIIIlIIlll, lllllllllllllIlIlIlIIllIIIlIIlII);
            boolean lllllllllllllIlIlIlIIllIIIlIIIIl = false;
            if (lllllllllllllIlIlIlIIllIIIlIIIll == null) {
                BlockEntityTag.LOGGER.warn("Unable to resolve BlockEntity for ItemInstance: {}", (Object)lllllllllllllIlIlIlIIllIIIlIIlII);
                final boolean lllllllllllllIlIlIlIIllIIIlIIIlI = false;
            }
            else {
                lllllllllllllIlIlIlIIllIIIlIIIIl = !lllllllllllllIlIlIlIIllIIIlIIlIl.hasKey("id");
                lllllllllllllIlIlIlIIllIIIlIIlIl.setString("id", lllllllllllllIlIlIlIIllIIIlIIIll);
            }
            lllllllllllllIlIlIlIIllIIIlIlIIl.process(FixTypes.BLOCK_ENTITY, lllllllllllllIlIlIlIIllIIIlIIlIl, lllllllllllllIlIlIlIIllIIIlIIlll);
            if (lllllllllllllIlIlIlIIllIIIlIIIIl) {
                lllllllllllllIlIlIlIIllIIIlIIlIl.removeTag("id");
            }
        }
        return lllllllllllllIlIlIlIIllIIIIlllll;
    }
}
