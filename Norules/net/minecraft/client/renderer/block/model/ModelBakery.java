package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.*;
import net.minecraftforge.registries.*;
import net.minecraft.item.*;
import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.block.statemap.*;
import net.minecraftforge.common.model.*;
import optifine.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.multipart.*;
import java.nio.charset.*;
import org.apache.commons.io.*;
import java.io.*;

public class ModelBakery
{
    private static final /* synthetic */ String MISSING_MODEL_MESH;
    private final /* synthetic */ Map<ModelResourceLocation, VariantList> variants;
    private final /* synthetic */ Map<ResourceLocation, ModelBlock> models;
    private final /* synthetic */ Map<ModelBlockDefinition, Collection<ModelResourceLocation>> multipartVariantMap;
    private final /* synthetic */ BlockModelShapes blockModelShapes;
    private final /* synthetic */ RegistrySimple<ModelResourceLocation, IBakedModel> bakedRegistry;
    private final /* synthetic */ ItemModelGenerator itemModelGenerator;
    private static final /* synthetic */ Joiner JOINER;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ ModelBlock MODEL_ENTITY;
    private static final /* synthetic */ String EMPTY_MODEL_RAW;
    private static final /* synthetic */ ModelBlock MODEL_GENERATED;
    private final /* synthetic */ TextureMap textureMap;
    protected static final /* synthetic */ ModelResourceLocation MODEL_MISSING;
    private final /* synthetic */ Map<String, ResourceLocation> itemLocations;
    private final /* synthetic */ IResourceManager resourceManager;
    private static /* synthetic */ Map<IRegistryDelegate<Item>, Set<String>> customVariantNames;
    private final /* synthetic */ FaceBakery faceBakery;
    private final /* synthetic */ Map<ResourceLocation, TextureAtlasSprite> sprites;
    private final /* synthetic */ Map<Item, List<String>> variantNames;
    private static final /* synthetic */ Map<String, String> BUILT_IN_MODELS;
    private final /* synthetic */ Map<ResourceLocation, ModelBlockDefinition> blockDefinitions;
    private static final /* synthetic */ Set<ResourceLocation> LOCATIONS_BUILTIN_TEXTURES;
    
    private ModelBlockDefinition loadMultipartMBD(final ResourceLocation lllllllllllllIIlIlIllIlIIIIlIIII, final ResourceLocation lllllllllllllIIlIlIllIlIIIIlIlIl) {
        final List<ModelBlockDefinition> lllllllllllllIIlIlIllIlIIIIlIlII = (List<ModelBlockDefinition>)Lists.newArrayList();
        try {
            for (final IResource lllllllllllllIIlIlIllIlIIIIlIIll : this.resourceManager.getAllResources(lllllllllllllIIlIlIllIlIIIIlIlIl)) {
                lllllllllllllIIlIlIllIlIIIIlIlII.add(this.loadModelBlockDefinition(lllllllllllllIIlIlIllIlIIIIlIIII, lllllllllllllIIlIlIllIlIIIIlIIll));
            }
        }
        catch (IOException lllllllllllllIIlIlIllIlIIIIlIIlI) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Encountered an exception when loading model definition of model ").append(lllllllllllllIIlIlIllIlIIIIlIlIl)), lllllllllllllIIlIlIllIlIIIIlIIlI);
        }
        return new ModelBlockDefinition(lllllllllllllIIlIlIllIlIIIIlIlII);
    }
    
    public void loadItemModel(final String lllllllllllllIIlIlIllIIlIlllIlIl, final ResourceLocation lllllllllllllIIlIlIllIIlIlllIlII, final ResourceLocation lllllllllllllIIlIlIllIIlIlllIIll) {
        this.itemLocations.put(lllllllllllllIIlIlIllIIlIlllIlIl, lllllllllllllIIlIlIllIIlIlllIlII);
        if (this.models.get(lllllllllllllIIlIlIllIIlIlllIlII) == null) {
            try {
                final ModelBlock lllllllllllllIIlIlIllIIlIllllIII = this.loadModel(lllllllllllllIIlIlIllIIlIlllIlII);
                this.models.put(lllllllllllllIIlIlIllIIlIlllIlII, lllllllllllllIIlIlIllIIlIllllIII);
            }
            catch (Exception lllllllllllllIIlIlIllIIlIlllIlll) {
                ModelBakery.LOGGER.warn("Unable to load item model: '{}' for item: '{}'", (Object)lllllllllllllIIlIlIllIIlIlllIlII, (Object)lllllllllllllIIlIlIllIIlIlllIIll);
                ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIlIllIIlIlllIlll.getClass().getName())).append(": ").append(lllllllllllllIIlIlIllIIlIlllIlll.getMessage())));
            }
        }
    }
    
    private void bakeItemModels() {
        for (final Map.Entry<String, ResourceLocation> lllllllllllllIIlIlIllIIlIIIlIllI : this.itemLocations.entrySet()) {
            final ResourceLocation lllllllllllllIIlIlIllIIlIIIlIlIl = lllllllllllllIIlIlIllIIlIIIlIllI.getValue();
            ModelResourceLocation lllllllllllllIIlIlIllIIlIIIlIlII = new ModelResourceLocation(lllllllllllllIIlIlIllIIlIIIlIllI.getKey(), "inventory");
            if (Reflector.ForgeHooksClient.exists()) {
                lllllllllllllIIlIlIllIIlIIIlIlII = (ModelResourceLocation)Reflector.call(Reflector.ModelLoader_getInventoryVariant, lllllllllllllIIlIlIllIIlIIIlIllI.getKey());
            }
            final ModelBlock lllllllllllllIIlIlIllIIlIIIlIIll = this.models.get(lllllllllllllIIlIlIllIIlIIIlIlIl);
            if (lllllllllllllIIlIlIllIIlIIIlIIll != null && lllllllllllllIIlIlIllIIlIIIlIIll.isResolved()) {
                if (lllllllllllllIIlIlIllIIlIIIlIIll.getElements().isEmpty()) {
                    ModelBakery.LOGGER.warn("Missing elements for: {}", (Object)lllllllllllllIIlIlIllIIlIIIlIlIl);
                }
                else if (this.isCustomRenderer(lllllllllllllIIlIlIllIIlIIIlIIll)) {
                    this.bakedRegistry.putObject(lllllllllllllIIlIlIllIIlIIIlIlII, new BuiltInModel(lllllllllllllIIlIlIllIIlIIIlIIll.getAllTransforms(), lllllllllllllIIlIlIllIIlIIIlIIll.createOverrides()));
                }
                else {
                    final IBakedModel lllllllllllllIIlIlIllIIlIIIlIIlI = this.bakeModel(lllllllllllllIIlIlIllIIlIIIlIIll, ModelRotation.X0_Y0, false);
                    if (lllllllllllllIIlIlIllIIlIIIlIIlI == null) {
                        continue;
                    }
                    this.bakedRegistry.putObject(lllllllllllllIIlIlIllIIlIIIlIlII, lllllllllllllIIlIlIllIIlIIIlIIlI);
                }
            }
            else {
                ModelBakery.LOGGER.warn("Missing model for: {}", (Object)lllllllllllllIIlIlIllIIlIIIlIlIl);
            }
        }
    }
    
    static {
        LOCATIONS_BUILTIN_TEXTURES = Sets.newHashSet((Object[])new ResourceLocation[] { new ResourceLocation("blocks/water_flow"), new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/lava_flow"), new ResourceLocation("blocks/lava_still"), new ResourceLocation("blocks/water_overlay"), new ResourceLocation("blocks/destroy_stage_0"), new ResourceLocation("blocks/destroy_stage_1"), new ResourceLocation("blocks/destroy_stage_2"), new ResourceLocation("blocks/destroy_stage_3"), new ResourceLocation("blocks/destroy_stage_4"), new ResourceLocation("blocks/destroy_stage_5"), new ResourceLocation("blocks/destroy_stage_6"), new ResourceLocation("blocks/destroy_stage_7"), new ResourceLocation("blocks/destroy_stage_8"), new ResourceLocation("blocks/destroy_stage_9"), new ResourceLocation("items/empty_armor_slot_helmet"), new ResourceLocation("items/empty_armor_slot_chestplate"), new ResourceLocation("items/empty_armor_slot_leggings"), new ResourceLocation("items/empty_armor_slot_boots"), new ResourceLocation("items/empty_armor_slot_shield"), new ResourceLocation("blocks/shulker_top_white"), new ResourceLocation("blocks/shulker_top_orange"), new ResourceLocation("blocks/shulker_top_magenta"), new ResourceLocation("blocks/shulker_top_light_blue"), new ResourceLocation("blocks/shulker_top_yellow"), new ResourceLocation("blocks/shulker_top_lime"), new ResourceLocation("blocks/shulker_top_pink"), new ResourceLocation("blocks/shulker_top_gray"), new ResourceLocation("blocks/shulker_top_silver"), new ResourceLocation("blocks/shulker_top_cyan"), new ResourceLocation("blocks/shulker_top_purple"), new ResourceLocation("blocks/shulker_top_blue"), new ResourceLocation("blocks/shulker_top_brown"), new ResourceLocation("blocks/shulker_top_green"), new ResourceLocation("blocks/shulker_top_red"), new ResourceLocation("blocks/shulker_top_black") });
        LOGGER = LogManager.getLogger();
        MODEL_MISSING = new ModelResourceLocation("builtin/missing", "missing");
        MISSING_MODEL_MESH = "{    'textures': {       'particle': 'missingno',       'missingno': 'missingno'    },    'elements': [         {  'from': [ 0, 0, 0 ],            'to': [ 16, 16, 16 ],            'faces': {                'down':  { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'down',  'texture': '#missingno' },                'up':    { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'up',    'texture': '#missingno' },                'north': { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'north', 'texture': '#missingno' },                'south': { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'south', 'texture': '#missingno' },                'west':  { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'west',  'texture': '#missingno' },                'east':  { 'uv': [ 0, 0, 16, 16 ], 'cullface': 'east',  'texture': '#missingno' }            }        }    ]}".replaceAll("'", "\"");
        BUILT_IN_MODELS = Maps.newHashMap();
        JOINER = Joiner.on(" -> ");
        EMPTY_MODEL_RAW = "{    'elements': [        {   'from': [0, 0, 0],            'to': [16, 16, 16],            'faces': {                'down': {'uv': [0, 0, 16, 16], 'texture': '' }            }        }    ]}".replaceAll("'", "\"");
        MODEL_GENERATED = ModelBlock.deserialize(ModelBakery.EMPTY_MODEL_RAW);
        MODEL_ENTITY = ModelBlock.deserialize(ModelBakery.EMPTY_MODEL_RAW);
        ModelBakery.customVariantNames = (Map<IRegistryDelegate<Item>, Set<String>>)Maps.newHashMap();
        ModelBakery.BUILT_IN_MODELS.put("missing", ModelBakery.MISSING_MODEL_MESH);
        ModelBakery.MODEL_GENERATED.name = "generation marker";
        ModelBakery.MODEL_ENTITY.name = "block entity marker";
    }
    
    private void registerVariantNames() {
        this.variantNames.clear();
        this.variantNames.put(Item.getItemFromBlock(Blocks.STONE), Lists.newArrayList((Object[])new String[] { "stone", "granite", "granite_smooth", "diorite", "diorite_smooth", "andesite", "andesite_smooth" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.DIRT), Lists.newArrayList((Object[])new String[] { "dirt", "coarse_dirt", "podzol" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.PLANKS), Lists.newArrayList((Object[])new String[] { "oak_planks", "spruce_planks", "birch_planks", "jungle_planks", "acacia_planks", "dark_oak_planks" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.SAPLING), Lists.newArrayList((Object[])new String[] { "oak_sapling", "spruce_sapling", "birch_sapling", "jungle_sapling", "acacia_sapling", "dark_oak_sapling" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.SAND), Lists.newArrayList((Object[])new String[] { "sand", "red_sand" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.LOG), Lists.newArrayList((Object[])new String[] { "oak_log", "spruce_log", "birch_log", "jungle_log" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.LEAVES), Lists.newArrayList((Object[])new String[] { "oak_leaves", "spruce_leaves", "birch_leaves", "jungle_leaves" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.SPONGE), Lists.newArrayList((Object[])new String[] { "sponge", "sponge_wet" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.SANDSTONE), Lists.newArrayList((Object[])new String[] { "sandstone", "chiseled_sandstone", "smooth_sandstone" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.RED_SANDSTONE), Lists.newArrayList((Object[])new String[] { "red_sandstone", "chiseled_red_sandstone", "smooth_red_sandstone" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.TALLGRASS), Lists.newArrayList((Object[])new String[] { "dead_bush", "tall_grass", "fern" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.DEADBUSH), Lists.newArrayList((Object[])new String[] { "dead_bush" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.WOOL), Lists.newArrayList((Object[])new String[] { "black_wool", "red_wool", "green_wool", "brown_wool", "blue_wool", "purple_wool", "cyan_wool", "silver_wool", "gray_wool", "pink_wool", "lime_wool", "yellow_wool", "light_blue_wool", "magenta_wool", "orange_wool", "white_wool" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), Lists.newArrayList((Object[])new String[] { "dandelion" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.RED_FLOWER), Lists.newArrayList((Object[])new String[] { "poppy", "blue_orchid", "allium", "houstonia", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STONE_SLAB), Lists.newArrayList((Object[])new String[] { "stone_slab", "sandstone_slab", "cobblestone_slab", "brick_slab", "stone_brick_slab", "nether_brick_slab", "quartz_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STONE_SLAB2), Lists.newArrayList((Object[])new String[] { "red_sandstone_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STAINED_GLASS), Lists.newArrayList((Object[])new String[] { "black_stained_glass", "red_stained_glass", "green_stained_glass", "brown_stained_glass", "blue_stained_glass", "purple_stained_glass", "cyan_stained_glass", "silver_stained_glass", "gray_stained_glass", "pink_stained_glass", "lime_stained_glass", "yellow_stained_glass", "light_blue_stained_glass", "magenta_stained_glass", "orange_stained_glass", "white_stained_glass" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.MONSTER_EGG), Lists.newArrayList((Object[])new String[] { "stone_monster_egg", "cobblestone_monster_egg", "stone_brick_monster_egg", "mossy_brick_monster_egg", "cracked_brick_monster_egg", "chiseled_brick_monster_egg" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STONEBRICK), Lists.newArrayList((Object[])new String[] { "stonebrick", "mossy_stonebrick", "cracked_stonebrick", "chiseled_stonebrick" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.WOODEN_SLAB), Lists.newArrayList((Object[])new String[] { "oak_slab", "spruce_slab", "birch_slab", "jungle_slab", "acacia_slab", "dark_oak_slab" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.COBBLESTONE_WALL), Lists.newArrayList((Object[])new String[] { "cobblestone_wall", "mossy_cobblestone_wall" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.ANVIL), Lists.newArrayList((Object[])new String[] { "anvil_intact", "anvil_slightly_damaged", "anvil_very_damaged" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK), Lists.newArrayList((Object[])new String[] { "quartz_block", "chiseled_quartz_block", "quartz_column" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STAINED_HARDENED_CLAY), Lists.newArrayList((Object[])new String[] { "black_stained_hardened_clay", "red_stained_hardened_clay", "green_stained_hardened_clay", "brown_stained_hardened_clay", "blue_stained_hardened_clay", "purple_stained_hardened_clay", "cyan_stained_hardened_clay", "silver_stained_hardened_clay", "gray_stained_hardened_clay", "pink_stained_hardened_clay", "lime_stained_hardened_clay", "yellow_stained_hardened_clay", "light_blue_stained_hardened_clay", "magenta_stained_hardened_clay", "orange_stained_hardened_clay", "white_stained_hardened_clay" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.STAINED_GLASS_PANE), Lists.newArrayList((Object[])new String[] { "black_stained_glass_pane", "red_stained_glass_pane", "green_stained_glass_pane", "brown_stained_glass_pane", "blue_stained_glass_pane", "purple_stained_glass_pane", "cyan_stained_glass_pane", "silver_stained_glass_pane", "gray_stained_glass_pane", "pink_stained_glass_pane", "lime_stained_glass_pane", "yellow_stained_glass_pane", "light_blue_stained_glass_pane", "magenta_stained_glass_pane", "orange_stained_glass_pane", "white_stained_glass_pane" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.LEAVES2), Lists.newArrayList((Object[])new String[] { "acacia_leaves", "dark_oak_leaves" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.LOG2), Lists.newArrayList((Object[])new String[] { "acacia_log", "dark_oak_log" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.PRISMARINE), Lists.newArrayList((Object[])new String[] { "prismarine", "prismarine_bricks", "dark_prismarine" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.CARPET), Lists.newArrayList((Object[])new String[] { "black_carpet", "red_carpet", "green_carpet", "brown_carpet", "blue_carpet", "purple_carpet", "cyan_carpet", "silver_carpet", "gray_carpet", "pink_carpet", "lime_carpet", "yellow_carpet", "light_blue_carpet", "magenta_carpet", "orange_carpet", "white_carpet" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), Lists.newArrayList((Object[])new String[] { "sunflower", "syringa", "double_grass", "double_fern", "double_rose", "paeonia" }));
        this.variantNames.put(Items.COAL, Lists.newArrayList((Object[])new String[] { "coal", "charcoal" }));
        this.variantNames.put(Items.FISH, Lists.newArrayList((Object[])new String[] { "cod", "salmon", "clownfish", "pufferfish" }));
        this.variantNames.put(Items.COOKED_FISH, Lists.newArrayList((Object[])new String[] { "cooked_cod", "cooked_salmon" }));
        this.variantNames.put(Items.DYE, Lists.newArrayList((Object[])new String[] { "dye_black", "dye_red", "dye_green", "dye_brown", "dye_blue", "dye_purple", "dye_cyan", "dye_silver", "dye_gray", "dye_pink", "dye_lime", "dye_yellow", "dye_light_blue", "dye_magenta", "dye_orange", "dye_white" }));
        this.variantNames.put(Items.POTIONITEM, Lists.newArrayList((Object[])new String[] { "bottle_drinkable" }));
        this.variantNames.put(Items.SKULL, Lists.newArrayList((Object[])new String[] { "skull_skeleton", "skull_wither", "skull_zombie", "skull_char", "skull_creeper", "skull_dragon" }));
        this.variantNames.put(Items.SPLASH_POTION, Lists.newArrayList((Object[])new String[] { "bottle_splash" }));
        this.variantNames.put(Items.LINGERING_POTION, Lists.newArrayList((Object[])new String[] { "bottle_lingering" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.field_192443_dR), Lists.newArrayList((Object[])new String[] { "black_concrete", "red_concrete", "green_concrete", "brown_concrete", "blue_concrete", "purple_concrete", "cyan_concrete", "silver_concrete", "gray_concrete", "pink_concrete", "lime_concrete", "yellow_concrete", "light_blue_concrete", "magenta_concrete", "orange_concrete", "white_concrete" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.field_192444_dS), Lists.newArrayList((Object[])new String[] { "black_concrete_powder", "red_concrete_powder", "green_concrete_powder", "brown_concrete_powder", "blue_concrete_powder", "purple_concrete_powder", "cyan_concrete_powder", "silver_concrete_powder", "gray_concrete_powder", "pink_concrete_powder", "lime_concrete_powder", "yellow_concrete_powder", "light_blue_concrete_powder", "magenta_concrete_powder", "orange_concrete_powder", "white_concrete_powder" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.AIR), Collections.emptyList());
        this.variantNames.put(Item.getItemFromBlock(Blocks.OAK_FENCE_GATE), Lists.newArrayList((Object[])new String[] { "oak_fence_gate" }));
        this.variantNames.put(Item.getItemFromBlock(Blocks.OAK_FENCE), Lists.newArrayList((Object[])new String[] { "oak_fence" }));
        this.variantNames.put(Items.OAK_DOOR, Lists.newArrayList((Object[])new String[] { "oak_door" }));
        this.variantNames.put(Items.BOAT, Lists.newArrayList((Object[])new String[] { "oak_boat" }));
        this.variantNames.put(Items.field_190929_cY, Lists.newArrayList((Object[])new String[] { "totem" }));
        for (final Map.Entry<IRegistryDelegate<Item>, Set<String>> lllllllllllllIIlIlIllIIlIllIllIl : ModelBakery.customVariantNames.entrySet()) {
            this.variantNames.put(lllllllllllllIIlIlIllIIlIllIllIl.getKey().get(), Lists.newArrayList((Iterator)lllllllllllllIIlIlIllIIlIllIllIl.getValue().iterator()));
        }
    }
    
    private ModelBlock loadModel(final ResourceLocation lllllllllllllIIlIlIllIIllIlllIll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* lllllllllllllIIlIlIllIIllIlIllII */
        //     2: aconst_null    
        //     3: astore_3        /* lllllllllllllIIlIlIllIIllIlIlIll */
        //     4: aload_1         /* lllllllllllllIIlIlIllIIllIlIllIl */
        //     5: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //     8: astore          lllllllllllllIIlIlIllIIllIllIllI
        //    10: ldc_w           "builtin/generated"
        //    13: aload           lllllllllllllIIlIlIllIIllIllIllI
        //    15: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    18: ifeq            41
        //    21: getstatic       net/minecraft/client/renderer/block/model/ModelBakery.MODEL_GENERATED:Lnet/minecraft/client/renderer/block/model/ModelBlock;
        //    24: astore          lllllllllllllIIlIlIllIIllIllIlIl
        //    26: aload           lllllllllllllIIlIlIllIIllIllIlIl
        //    28: astore          lllllllllllllIIlIlIllIIllIlIIlII
        //    30: aload_2         /* lllllllllllllIIlIlIllIIllIlllIlI */
        //    31: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //    34: aload_3         /* lllllllllllllIIlIlIllIIllIlllIIl */
        //    35: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    38: aload           lllllllllllllIIlIlIllIIllIlIIlII
        //    40: areturn        
        //    41: ldc_w           "builtin/entity"
        //    44: aload           lllllllllllllIIlIlIllIIllIllIllI
        //    46: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    49: ifne            205
        //    52: aload           lllllllllllllIIlIlIllIIllIllIllI
        //    54: ldc_w           "builtin/"
        //    57: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    60: ifeq            121
        //    63: aload           lllllllllllllIIlIlIllIIllIllIllI
        //    65: ldc_w           "builtin/"
        //    68: invokevirtual   java/lang/String.length:()I
        //    71: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //    74: astore          lllllllllllllIIlIlIllIIllIllIlII
        //    76: getstatic       net/minecraft/client/renderer/block/model/ModelBakery.BUILT_IN_MODELS:Ljava/util/Map;
        //    79: aload           lllllllllllllIIlIlIllIIllIllIlII
        //    81: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    86: checkcast       Ljava/lang/String;
        //    89: astore          lllllllllllllIIlIlIllIIllIllIIll
        //    91: aload           lllllllllllllIIlIlIllIIllIllIIll
        //    93: ifnonnull       108
        //    96: new             Ljava/io/FileNotFoundException;
        //    99: dup            
        //   100: aload_1         /* lllllllllllllIIlIlIllIIllIlIllIl */
        //   101: invokevirtual   net/minecraft/util/ResourceLocation.toString:()Ljava/lang/String;
        //   104: invokespecial   java/io/FileNotFoundException.<init>:(Ljava/lang/String;)V
        //   107: athrow         
        //   108: new             Ljava/io/StringReader;
        //   111: dup            
        //   112: aload           lllllllllllllIIlIlIllIIllIllIIll
        //   114: invokespecial   java/io/StringReader.<init>:(Ljava/lang/String;)V
        //   117: astore_2        /* lllllllllllllIIlIlIllIIllIlllIlI */
        //   118: goto            155
        //   121: aload_0         /* lllllllllllllIIlIlIllIIllIlIlllI */
        //   122: aload_1         /* lllllllllllllIIlIlIllIIllIlIllIl */
        //   123: invokespecial   net/minecraft/client/renderer/block/model/ModelBakery.getModelLocation:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/util/ResourceLocation;
        //   126: astore_1        /* lllllllllllllIIlIlIllIIllIlIllIl */
        //   127: aload_0         /* lllllllllllllIIlIlIllIIllIlIlllI */
        //   128: getfield        net/minecraft/client/renderer/block/model/ModelBakery.resourceManager:Lnet/minecraft/client/resources/IResourceManager;
        //   131: aload_1         /* lllllllllllllIIlIlIllIIllIlIllIl */
        //   132: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //   137: astore_3        /* lllllllllllllIIlIlIllIIllIlllIIl */
        //   138: new             Ljava/io/InputStreamReader;
        //   141: dup            
        //   142: aload_3         /* lllllllllllllIIlIlIllIIllIlllIIl */
        //   143: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //   148: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //   151: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   154: astore_2        /* lllllllllllllIIlIlIllIIllIlllIlI */
        //   155: aload_2         /* lllllllllllllIIlIlIllIIllIlllIlI */
        //   156: invokestatic    net/minecraft/client/renderer/block/model/ModelBlock.deserialize:(Ljava/io/Reader;)Lnet/minecraft/client/renderer/block/model/ModelBlock;
        //   159: astore          lllllllllllllIIlIlIllIIllIllIIlI
        //   161: aload           lllllllllllllIIlIlIllIIllIllIIlI
        //   163: aload_1         /* lllllllllllllIIlIlIllIIllIlIllIl */
        //   164: invokevirtual   net/minecraft/util/ResourceLocation.toString:()Ljava/lang/String;
        //   167: putfield        net/minecraft/client/renderer/block/model/ModelBlock.name:Ljava/lang/String;
        //   170: aload_1         /* lllllllllllllIIlIlIllIIllIlIllIl */
        //   171: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //   174: invokestatic    optifine/TextureUtils.getBasePath:(Ljava/lang/String;)Ljava/lang/String;
        //   177: astore          lllllllllllllIIlIlIllIIllIllIIIl
        //   179: aload           lllllllllllllIIlIlIllIIllIllIIlI
        //   181: aload           lllllllllllllIIlIlIllIIllIllIIIl
        //   183: invokestatic    net/minecraft/client/renderer/block/model/ModelBakery.fixModelLocations:(Lnet/minecraft/client/renderer/block/model/ModelBlock;Ljava/lang/String;)V
        //   186: aload           lllllllllllllIIlIlIllIIllIllIIlI
        //   188: astore          lllllllllllllIIlIlIllIIllIllIIII
        //   190: aload           lllllllllllllIIlIlIllIIllIllIIII
        //   192: astore          lllllllllllllIIlIlIllIIllIlIIlII
        //   194: aload_2         /* lllllllllllllIIlIlIllIIllIlllIlI */
        //   195: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   198: aload_3         /* lllllllllllllIIlIlIllIIllIlllIIl */
        //   199: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   202: aload           lllllllllllllIIlIlIllIIllIlIIlII
        //   204: areturn        
        //   205: getstatic       net/minecraft/client/renderer/block/model/ModelBakery.MODEL_ENTITY:Lnet/minecraft/client/renderer/block/model/ModelBlock;
        //   208: astore          lllllllllllllIIlIlIllIIllIlIllll
        //   210: aload           lllllllllllllIIlIlIllIIllIlIllll
        //   212: astore          lllllllllllllIIlIlIllIIllIlllIII
        //   214: goto            230
        //   217: astore          lllllllllllllIIlIlIllIIllIlIIlIl
        //   219: aload_2         /* lllllllllllllIIlIlIllIIllIlllIlI */
        //   220: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   223: aload_3         /* lllllllllllllIIlIlIllIIllIlllIIl */
        //   224: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   227: aload           lllllllllllllIIlIlIllIIllIlIIlIl
        //   229: athrow         
        //   230: aload_2         /* lllllllllllllIIlIlIllIIllIlllIlI */
        //   231: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Reader;)V
        //   234: aload_3         /* lllllllllllllIIlIlIllIIllIlllIIl */
        //   235: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   238: aload           lllllllllllllIIlIlIllIIllIllIlll
        //   240: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  4      30     217    230    Any
        //  41     194    217    230    Any
        //  205    217    217    230    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private ModelBlockDefinition getModelBlockDefinition(final ResourceLocation lllllllllllllIIlIlIllIlIIIlIIlII) {
        final ResourceLocation lllllllllllllIIlIlIllIlIIIlIIIll = this.getBlockstateLocation(lllllllllllllIIlIlIllIlIIIlIIlII);
        ModelBlockDefinition lllllllllllllIIlIlIllIlIIIlIIIlI = this.blockDefinitions.get(lllllllllllllIIlIlIllIlIIIlIIIll);
        if (lllllllllllllIIlIlIllIlIIIlIIIlI == null) {
            lllllllllllllIIlIlIllIlIIIlIIIlI = this.loadMultipartMBD(lllllllllllllIIlIlIllIlIIIlIIlII, lllllllllllllIIlIlIllIlIIIlIIIll);
            this.blockDefinitions.put(lllllllllllllIIlIlIllIlIIIlIIIll, lllllllllllllIIlIlIllIlIIIlIIIlI);
        }
        return lllllllllllllIIlIlIllIlIIIlIIIlI;
    }
    
    private void addModelParentLocation(final Deque<ResourceLocation> lllllllllllllIIlIlIllIIIIlIllIII, final Set<ResourceLocation> lllllllllllllIIlIlIllIIIIlIllIll, final ModelBlock lllllllllllllIIlIlIllIIIIlIllIlI) {
        final ResourceLocation lllllllllllllIIlIlIllIIIIlIllIIl = lllllllllllllIIlIlIllIIIIlIllIlI.getParentLocation();
        if (lllllllllllllIIlIlIllIIIIlIllIIl != null && !lllllllllllllIIlIlIllIIIIlIllIll.contains(lllllllllllllIIlIlIllIIIIlIllIIl)) {
            lllllllllllllIIlIlIllIIIIlIllIII.add(lllllllllllllIIlIlIllIIIIlIllIIl);
        }
    }
    
    private List<String> getVariantNames(final Item lllllllllllllIIlIlIllIIlIllIIlIl) {
        List<String> lllllllllllllIIlIlIllIIlIllIIlII = this.variantNames.get(lllllllllllllIIlIlIllIIlIllIIlIl);
        if (lllllllllllllIIlIlIllIIlIllIIlII == null) {
            lllllllllllllIIlIlIllIIlIllIIlII = Collections.singletonList(Item.REGISTRY.getNameForObject(lllllllllllllIIlIlIllIIlIllIIlIl).toString());
        }
        return lllllllllllllIIlIlIllIIlIllIIlII;
    }
    
    public static void fixModelLocations(final ModelBlock lllllllllllllIIlIlIlIlllllIlIIIl, final String lllllllllllllIIlIlIlIlllllIIlIlI) {
        final ResourceLocation lllllllllllllIIlIlIlIlllllIIllll = fixModelLocation(lllllllllllllIIlIlIlIlllllIlIIIl.parentLocation, lllllllllllllIIlIlIlIlllllIIlIlI);
        if (lllllllllllllIIlIlIlIlllllIIllll != lllllllllllllIIlIlIlIlllllIlIIIl.parentLocation) {
            lllllllllllllIIlIlIlIlllllIlIIIl.parentLocation = lllllllllllllIIlIlIlIlllllIIllll;
        }
        if (lllllllllllllIIlIlIlIlllllIlIIIl.textures != null) {
            for (final Map.Entry<String, String> lllllllllllllIIlIlIlIlllllIIlllI : lllllllllllllIIlIlIlIlllllIlIIIl.textures.entrySet()) {
                final String lllllllllllllIIlIlIlIlllllIIllIl = lllllllllllllIIlIlIlIlllllIIlllI.getValue();
                final String lllllllllllllIIlIlIlIlllllIIllII = fixResourcePath(lllllllllllllIIlIlIlIlllllIIllIl, lllllllllllllIIlIlIlIlllllIIlIlI);
                if (lllllllllllllIIlIlIlIlllllIIllII != lllllllllllllIIlIlIlIlllllIIllIl) {
                    lllllllllllllIIlIlIlIlllllIIlllI.setValue(lllllllllllllIIlIlIlIlllllIIllII);
                }
            }
        }
    }
    
    private List<ResourceLocation> getParentPath(final ResourceLocation lllllllllllllIIlIlIllIIIIlIIlIll) {
        final List<ResourceLocation> lllllllllllllIIlIlIllIIIIlIIlllI = (List<ResourceLocation>)Lists.newArrayList((Object[])new ResourceLocation[] { lllllllllllllIIlIlIllIIIIlIIlIll });
        ResourceLocation lllllllllllllIIlIlIllIIIIlIIllIl = lllllllllllllIIlIlIllIIIIlIIlIll;
        while ((lllllllllllllIIlIlIllIIIIlIIllIl = this.getParentLocation(lllllllllllllIIlIlIllIIIIlIIllIl)) != null) {
            lllllllllllllIIlIlIllIIIIlIIlllI.add(0, lllllllllllllIIlIlIllIIIIlIIllIl);
        }
        return lllllllllllllIIlIlIllIIIIlIIlllI;
    }
    
    public static void registerItemVariants(final Item lllllllllllllIIlIlIlIllllIlIIIlI, final ResourceLocation... lllllllllllllIIlIlIlIllllIlIIIIl) {
        final IRegistryDelegate lllllllllllllIIlIlIlIllllIlIIIII = (IRegistryDelegate)Reflector.getFieldValue(lllllllllllllIIlIlIlIllllIlIIIlI, Reflector.ForgeItem_delegate);
        if (!ModelBakery.customVariantNames.containsKey(lllllllllllllIIlIlIlIllllIlIIIII)) {
            ModelBakery.customVariantNames.put(lllllllllllllIIlIlIlIllllIlIIIII, Sets.newHashSet());
        }
        final long lllllllllllllIIlIlIlIllllIIllIII = (Object)lllllllllllllIIlIlIlIllllIlIIIIl;
        final String lllllllllllllIIlIlIlIllllIIllIIl = (String)lllllllllllllIIlIlIlIllllIlIIIIl.length;
        for (long lllllllllllllIIlIlIlIllllIIllIlI = 0; lllllllllllllIIlIlIlIllllIIllIlI < lllllllllllllIIlIlIlIllllIIllIIl; ++lllllllllllllIIlIlIlIllllIIllIlI) {
            final ResourceLocation lllllllllllllIIlIlIlIllllIIlllll = lllllllllllllIIlIlIlIllllIIllIII[lllllllllllllIIlIlIlIllllIIllIlI];
            ModelBakery.customVariantNames.get(lllllllllllllIIlIlIlIllllIlIIIII).add(lllllllllllllIIlIlIlIllllIIlllll.toString());
        }
    }
    
    private void registerVariant(final ModelBlockDefinition lllllllllllllIIlIlIllIlIIIllIIII, final ModelResourceLocation lllllllllllllIIlIlIllIlIIIlIllll) {
        try {
            this.variants.put(lllllllllllllIIlIlIllIlIIIlIllll, lllllllllllllIIlIlIllIlIIIllIIII.getVariant(lllllllllllllIIlIlIllIlIIIlIllll.getVariant()));
        }
        catch (RuntimeException lllllllllllllIIlIlIllIlIIIlIlllI) {
            if (!lllllllllllllIIlIlIllIlIIIllIIII.hasMultipartData()) {
                ModelBakery.LOGGER.warn("Unable to load variant: {} from {}", (Object)lllllllllllllIIlIlIllIlIIIlIllll.getVariant(), (Object)lllllllllllllIIlIlIllIlIIIlIllll);
            }
        }
    }
    
    public static ResourceLocation fixModelLocation(ResourceLocation lllllllllllllIIlIlIlIllllIllllII, final String lllllllllllllIIlIlIlIllllIlllIll) {
        if (lllllllllllllIIlIlIlIllllIllllII == null || lllllllllllllIIlIlIlIllllIlllIll == null) {
            return (ResourceLocation)lllllllllllllIIlIlIlIllllIllllII;
        }
        if (!((ResourceLocation)lllllllllllllIIlIlIlIllllIllllII).getResourceDomain().equals("minecraft")) {
            return (ResourceLocation)lllllllllllllIIlIlIlIllllIllllII;
        }
        final String lllllllllllllIIlIlIlIllllIlllllI = ((ResourceLocation)lllllllllllllIIlIlIlIllllIllllII).getResourcePath();
        final String lllllllllllllIIlIlIlIllllIllllIl = fixResourcePath(lllllllllllllIIlIlIlIllllIlllllI, lllllllllllllIIlIlIlIllllIlllIll);
        if (lllllllllllllIIlIlIlIllllIllllIl != lllllllllllllIIlIlIlIllllIlllllI) {
            lllllllllllllIIlIlIlIllllIllllII = new ResourceLocation(((ResourceLocation)lllllllllllllIIlIlIlIllllIllllII).getResourceDomain(), lllllllllllllIIlIlIlIllllIllllIl);
        }
        return (ResourceLocation)lllllllllllllIIlIlIlIllllIllllII;
    }
    
    private boolean hasItemModel(@Nullable final ModelBlock lllllllllllllIIlIlIlIlllllllllll) {
        return lllllllllllllIIlIlIlIlllllllllll != null && lllllllllllllIIlIlIlIlllllllllll.getRootModel() == ModelBakery.MODEL_GENERATED;
    }
    
    private Set<ResourceLocation> getTextureLocations(final ModelBlock lllllllllllllIIlIlIllIIIIIlIllIl) {
        final Set<ResourceLocation> lllllllllllllIIlIlIllIIIIIllIIIl = (Set<ResourceLocation>)Sets.newHashSet();
        for (final BlockPart lllllllllllllIIlIlIllIIIIIllIIII : lllllllllllllIIlIlIllIIIIIlIllIl.getElements()) {
            for (final BlockPartFace lllllllllllllIIlIlIllIIIIIlIllll : lllllllllllllIIlIlIllIIIIIllIIII.mapFaces.values()) {
                final ResourceLocation lllllllllllllIIlIlIllIIIIIlIlllI = new ResourceLocation(lllllllllllllIIlIlIllIIIIIlIllIl.resolveTextureName(lllllllllllllIIlIlIllIIIIIlIllll.texture));
                lllllllllllllIIlIlIllIIIIIllIIIl.add(lllllllllllllIIlIlIllIIIIIlIlllI);
            }
        }
        lllllllllllllIIlIlIllIIIIIllIIIl.add(new ResourceLocation(lllllllllllllIIlIlIllIIIIIlIllIl.resolveTextureName("particle")));
        return lllllllllllllIIlIlIllIIIIIllIIIl;
    }
    
    private void loadVariantItemModels() {
        this.variants.put(ModelBakery.MODEL_MISSING, new VariantList(Lists.newArrayList((Object[])new Variant[] { new Variant(new ResourceLocation(ModelBakery.MODEL_MISSING.getResourcePath()), ModelRotation.X0_Y0, false, 1) })));
        this.func_191401_d();
        this.loadVariantModels();
        this.loadMultipartVariantModels();
        this.loadItemModels();
        CustomItems.update();
        CustomItems.loadModels(this);
    }
    
    private ResourceLocation getBlockstateLocation(final ResourceLocation lllllllllllllIIlIlIllIIlllllIlII) {
        return new ResourceLocation(lllllllllllllIIlIlIllIIlllllIlII.getResourceDomain(), String.valueOf(new StringBuilder("blockstates/").append(lllllllllllllIIlIlIllIIlllllIlII.getResourcePath()).append(".json")));
    }
    
    @Nullable
    public IBakedModel bakeModel(final ModelBlock lllllllllllllIIlIlIllIIIllIllllI, final ModelRotation lllllllllllllIIlIlIllIIIllIlllIl, final boolean lllllllllllllIIlIlIllIIIllIlIIlI) {
        final TextureAtlasSprite lllllllllllllIIlIlIllIIIllIllIll = this.sprites.get(new ResourceLocation(lllllllllllllIIlIlIllIIIllIllllI.resolveTextureName("particle")));
        final SimpleBakedModel.Builder lllllllllllllIIlIlIllIIIllIllIlI = new SimpleBakedModel.Builder(lllllllllllllIIlIlIllIIIllIllllI, lllllllllllllIIlIlIllIIIllIllllI.createOverrides()).setTexture(lllllllllllllIIlIlIllIIIllIllIll);
        if (lllllllllllllIIlIlIllIIIllIllllI.getElements().isEmpty()) {
            return null;
        }
        for (final BlockPart lllllllllllllIIlIlIllIIIllIllIIl : lllllllllllllIIlIlIllIIIllIllllI.getElements()) {
            for (final EnumFacing lllllllllllllIIlIlIllIIIllIllIII : lllllllllllllIIlIlIllIIIllIllIIl.mapFaces.keySet()) {
                final BlockPartFace lllllllllllllIIlIlIllIIIllIlIlll = lllllllllllllIIlIlIllIIIllIllIIl.mapFaces.get(lllllllllllllIIlIlIllIIIllIllIII);
                final TextureAtlasSprite lllllllllllllIIlIlIllIIIllIlIllI = this.sprites.get(new ResourceLocation(lllllllllllllIIlIlIllIIIllIllllI.resolveTextureName(lllllllllllllIIlIlIllIIIllIlIlll.texture)));
                if (lllllllllllllIIlIlIllIIIllIlIlll.cullFace == null) {
                    lllllllllllllIIlIlIllIIIllIllIlI.addGeneralQuad(this.makeBakedQuad(lllllllllllllIIlIlIllIIIllIllIIl, lllllllllllllIIlIlIllIIIllIlIlll, lllllllllllllIIlIlIllIIIllIlIllI, lllllllllllllIIlIlIllIIIllIllIII, lllllllllllllIIlIlIllIIIllIlllIl, lllllllllllllIIlIlIllIIIllIlIIlI));
                }
                else {
                    lllllllllllllIIlIlIllIIIllIllIlI.addFaceQuad(lllllllllllllIIlIlIllIIIllIlllIl.rotateFace(lllllllllllllIIlIlIllIIIllIlIlll.cullFace), this.makeBakedQuad(lllllllllllllIIlIlIllIIIllIllIIl, lllllllllllllIIlIlIllIIIllIlIlll, lllllllllllllIIlIlIllIIIllIlIllI, lllllllllllllIIlIlIllIIIllIllIII, lllllllllllllIIlIlIllIIIllIlllIl, lllllllllllllIIlIlIllIIIllIlIIlI));
                }
            }
        }
        return lllllllllllllIIlIlIllIIIllIllIlI.makeBakedModel();
    }
    
    public IRegistry<ModelResourceLocation, IBakedModel> setupModelRegistry() {
        this.loadBlocks();
        this.loadVariantItemModels();
        this.loadModelsCheck();
        this.loadSprites();
        this.makeItemModels();
        this.bakeBlockModels();
        this.bakeItemModels();
        return this.bakedRegistry;
    }
    
    private ResourceLocation getModelLocation(ResourceLocation lllllllllllllIIlIlIllIIllIIllllI) {
        final String lllllllllllllIIlIlIllIIllIIlllll = lllllllllllllIIlIlIllIIllIIllllI.getResourcePath();
        if (!lllllllllllllIIlIlIllIIllIIlllll.startsWith("mcpatcher") && !lllllllllllllIIlIlIllIIllIIlllll.startsWith("optifine")) {
            return new ResourceLocation(lllllllllllllIIlIlIllIIllIIllllI.getResourceDomain(), String.valueOf(new StringBuilder("models/").append(lllllllllllllIIlIlIllIIllIIllllI.getResourcePath()).append(".json")));
        }
        if (!lllllllllllllIIlIlIllIIllIIlllll.endsWith(".json")) {
            lllllllllllllIIlIlIllIIllIIllllI = new ResourceLocation(lllllllllllllIIlIlIllIIllIIllllI.getResourceDomain(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIlIllIIllIIlllll)).append(".json")));
        }
        return lllllllllllllIIlIlIllIIllIIllllI;
    }
    
    public ModelBlock getModelBlock(final ResourceLocation lllllllllllllIIlIlIlIlllllIllIlI) {
        final ModelBlock lllllllllllllIIlIlIlIlllllIlllII = this.models.get(lllllllllllllIIlIlIlIlllllIllIlI);
        return lllllllllllllIIlIlIlIlllllIlllII;
    }
    
    private Set<ResourceLocation> getItemsTextureLocations() {
        final Set<ResourceLocation> lllllllllllllIIlIlIllIIIIIIlIIlI = (Set<ResourceLocation>)Sets.newHashSet();
        for (final ResourceLocation lllllllllllllIIlIlIllIIIIIIlIIIl : this.itemLocations.values()) {
            final ModelBlock lllllllllllllIIlIlIllIIIIIIlIIII = this.models.get(lllllllllllllIIlIlIllIIIIIIlIIIl);
            if (lllllllllllllIIlIlIllIIIIIIlIIII != null) {
                lllllllllllllIIlIlIllIIIIIIlIIlI.add(new ResourceLocation(lllllllllllllIIlIlIllIIIIIIlIIII.resolveTextureName("particle")));
                if (this.hasItemModel(lllllllllllllIIlIlIllIIIIIIlIIII)) {
                    for (final String lllllllllllllIIlIlIllIIIIIIIllll : ItemModelGenerator.LAYERS) {
                        lllllllllllllIIlIlIllIIIIIIlIIlI.add(new ResourceLocation(lllllllllllllIIlIlIllIIIIIIlIIII.resolveTextureName(lllllllllllllIIlIlIllIIIIIIIllll)));
                    }
                }
                else {
                    if (this.isCustomRenderer(lllllllllllllIIlIlIllIIIIIIlIIII)) {
                        continue;
                    }
                    for (final BlockPart lllllllllllllIIlIlIllIIIIIIIlllI : lllllllllllllIIlIlIllIIIIIIlIIII.getElements()) {
                        for (final BlockPartFace lllllllllllllIIlIlIllIIIIIIIllIl : lllllllllllllIIlIlIllIIIIIIIlllI.mapFaces.values()) {
                            final ResourceLocation lllllllllllllIIlIlIllIIIIIIIllII = new ResourceLocation(lllllllllllllIIlIlIllIIIIIIlIIII.resolveTextureName(lllllllllllllIIlIlIllIIIIIIIllIl.texture));
                            lllllllllllllIIlIlIllIIIIIIlIIlI.add(lllllllllllllIIlIlIllIIIIIIIllII);
                        }
                    }
                }
            }
        }
        return lllllllllllllIIlIlIllIIIIIIlIIlI;
    }
    
    private void loadSprites() {
        final Set<ResourceLocation> lllllllllllllIIlIlIllIIIIIlIIIlI = this.getVariantsTextureLocations();
        lllllllllllllIIlIlIllIIIIIlIIIlI.addAll(this.getItemsTextureLocations());
        lllllllllllllIIlIlIllIIIIIlIIIlI.remove(TextureMap.LOCATION_MISSING_TEXTURE);
        final ITextureMapPopulator lllllllllllllIIlIlIllIIIIIlIIIIl = new ITextureMapPopulator() {
            @Override
            public void registerSprites(final TextureMap lllllllllllllllIIIlIlIlllIllIIIl) {
                for (final ResourceLocation lllllllllllllllIIIlIlIlllIllIlII : lllllllllllllIIlIlIllIIIIIlIIIlI) {
                    final TextureAtlasSprite lllllllllllllllIIIlIlIlllIllIIll = lllllllllllllllIIIlIlIlllIllIIIl.registerSprite(lllllllllllllllIIIlIlIlllIllIlII);
                    ModelBakery.this.sprites.put(lllllllllllllllIIIlIlIlllIllIlII, lllllllllllllllIIIlIlIlllIllIIll);
                }
            }
        };
        this.textureMap.loadSprites(this.resourceManager, lllllllllllllIIlIlIllIIIIIlIIIIl);
        this.sprites.put(new ResourceLocation("missingno"), this.textureMap.getMissingSprite());
    }
    
    private void makeItemModels() {
        for (final ResourceLocation lllllllllllllIIlIlIlIlllllllIIII : this.itemLocations.values()) {
            final ModelBlock lllllllllllllIIlIlIlIllllllIllll = this.models.get(lllllllllllllIIlIlIlIlllllllIIII);
            if (this.hasItemModel(lllllllllllllIIlIlIlIllllllIllll)) {
                final ModelBlock lllllllllllllIIlIlIlIllllllIlllI = this.makeItemModel(lllllllllllllIIlIlIlIllllllIllll);
                if (lllllllllllllIIlIlIlIllllllIlllI != null) {
                    lllllllllllllIIlIlIlIllllllIlllI.name = lllllllllllllIIlIlIlIlllllllIIII.toString();
                }
                this.models.put(lllllllllllllIIlIlIlIlllllllIIII, lllllllllllllIIlIlIlIllllllIlllI);
            }
            else {
                if (!this.isCustomRenderer(lllllllllllllIIlIlIlIllllllIllll)) {
                    continue;
                }
                this.models.put(lllllllllllllIIlIlIlIlllllllIIII, lllllllllllllIIlIlIlIllllllIllll);
            }
        }
        for (final TextureAtlasSprite lllllllllllllIIlIlIlIllllllIllIl : this.sprites.values()) {
            if (!lllllllllllllIIlIlIlIllllllIllIl.hasAnimationMetadata()) {
                lllllllllllllIIlIlIlIllllllIllIl.clearFramesTextureData();
            }
        }
    }
    
    private void loadModels() {
        final Deque<ResourceLocation> lllllllllllllIIlIlIllIIIIllIllII = (Deque<ResourceLocation>)Queues.newArrayDeque();
        final Set<ResourceLocation> lllllllllllllIIlIlIllIIIIllIlIll = (Set<ResourceLocation>)Sets.newHashSet();
        for (final ResourceLocation lllllllllllllIIlIlIllIIIIllIlIlI : this.models.keySet()) {
            lllllllllllllIIlIlIllIIIIllIlIll.add(lllllllllllllIIlIlIllIIIIllIlIlI);
            this.addModelParentLocation(lllllllllllllIIlIlIllIIIIllIllII, lllllllllllllIIlIlIllIIIIllIlIll, this.models.get(lllllllllllllIIlIlIllIIIIllIlIlI));
        }
        while (!lllllllllllllIIlIlIllIIIIllIllII.isEmpty()) {
            final ResourceLocation lllllllllllllIIlIlIllIIIIllIlIIl = lllllllllllllIIlIlIllIIIIllIllII.pop();
            try {
                if (this.models.get(lllllllllllllIIlIlIllIIIIllIlIIl) != null) {
                    continue;
                }
                final ModelBlock lllllllllllllIIlIlIllIIIIllIlIII = this.loadModel(lllllllllllllIIlIlIllIIIIllIlIIl);
                this.models.put(lllllllllllllIIlIlIllIIIIllIlIIl, lllllllllllllIIlIlIllIIIIllIlIII);
                this.addModelParentLocation(lllllllllllllIIlIlIllIIIIllIllII, lllllllllllllIIlIlIllIIIIllIlIll, lllllllllllllIIlIlIllIIIIllIlIII);
            }
            catch (Exception lllllllllllllIIlIlIllIIIIllIIlll) {
                ModelBakery.LOGGER.warn("In parent chain: {}; unable to load model: '{}'", (Object)ModelBakery.JOINER.join((Iterable)this.getParentPath(lllllllllllllIIlIlIllIIIIllIlIIl)), (Object)lllllllllllllIIlIlIllIIIIllIlIIl);
            }
            lllllllllllllIIlIlIllIIIIllIlIll.add(lllllllllllllIIlIlIllIIIIllIlIIl);
        }
    }
    
    private void loadBlocks() {
        final BlockStateMapper lllllllllllllIIlIlIllIlIIllIlIll = this.blockModelShapes.getBlockStateMapper();
        for (final Block lllllllllllllIIlIlIllIlIIllIlIlI : Block.REGISTRY) {
            for (final ResourceLocation lllllllllllllIIlIlIllIlIIllIlIIl : lllllllllllllIIlIlIllIlIIllIlIll.getBlockstateLocations(lllllllllllllIIlIlIllIlIIllIlIlI)) {
                try {
                    this.loadBlock(lllllllllllllIIlIlIllIlIIllIlIll, lllllllllllllIIlIlIllIlIIllIlIlI, lllllllllllllIIlIlIllIlIIllIlIIl);
                }
                catch (Exception lllllllllllllIIlIlIllIlIIllIlIII) {
                    ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Unable to load definition ").append(lllllllllllllIIlIlIllIlIIllIlIIl)), (Throwable)lllllllllllllIIlIlIllIlIIllIlIII);
                }
            }
        }
    }
    
    private BakedQuad makeBakedQuad(final BlockPart lllllllllllllIIlIlIllIIIlIIlllII, final BlockPartFace lllllllllllllIIlIlIllIIIlIIllIll, final TextureAtlasSprite lllllllllllllIIlIlIllIIIlIIllIlI, final EnumFacing lllllllllllllIIlIlIllIIIlIIlIIlI, final ModelRotation lllllllllllllIIlIlIllIIIlIIlIIIl, final boolean lllllllllllllIIlIlIllIIIlIIlIIII) {
        return Reflector.ForgeHooksClient.exists() ? this.makeBakedQuad(lllllllllllllIIlIlIllIIIlIIlllII, lllllllllllllIIlIlIllIIIlIIllIll, lllllllllllllIIlIlIllIIIlIIllIlI, lllllllllllllIIlIlIllIIIlIIlIIlI, lllllllllllllIIlIlIllIIIlIIlIIIl, lllllllllllllIIlIlIllIIIlIIlIIII) : this.faceBakery.makeBakedQuad(lllllllllllllIIlIlIllIIIlIIlllII.positionFrom, lllllllllllllIIlIlIllIIIlIIlllII.positionTo, lllllllllllllIIlIlIllIIIlIIllIll, lllllllllllllIIlIlIllIIIlIIllIlI, lllllllllllllIIlIlIllIIIlIIlIIlI, lllllllllllllIIlIlIllIIIlIIlIIIl, lllllllllllllIIlIlIllIIIlIIlllII.partRotation, lllllllllllllIIlIlIllIIIlIIlIIII, lllllllllllllIIlIlIllIIIlIIlllII.shade);
    }
    
    private void loadVariantList(final ModelResourceLocation lllllllllllllIIlIlIllIIlllIIllIl, final VariantList lllllllllllllIIlIlIllIIlllIlIIlI) {
        for (final Variant lllllllllllllIIlIlIllIIlllIlIIIl : lllllllllllllIIlIlIllIIlllIlIIlI.getVariantList()) {
            final ResourceLocation lllllllllllllIIlIlIllIIlllIlIIII = lllllllllllllIIlIlIllIIlllIlIIIl.getModelLocation();
            if (this.models.get(lllllllllllllIIlIlIllIIlllIlIIII) == null) {
                try {
                    this.models.put(lllllllllllllIIlIlIllIIlllIlIIII, this.loadModel(lllllllllllllIIlIlIllIIlllIlIIII));
                }
                catch (Exception lllllllllllllIIlIlIllIIlllIIllll) {
                    ModelBakery.LOGGER.warn("Unable to load block model: '{}' for variant: '{}': {} ", (Object)lllllllllllllIIlIlIllIIlllIlIIII, (Object)lllllllllllllIIlIlIllIIlllIIllIl, (Object)lllllllllllllIIlIlIllIIlllIIllll);
                }
            }
        }
    }
    
    protected IBakedModel bakeModel(final ModelBlock lllllllllllllIIlIlIllIIIlIlllIll, final ITransformation lllllllllllllIIlIlIllIIIlIlIllll, final boolean lllllllllllllIIlIlIllIIIlIlllIIl) {
        final TextureAtlasSprite lllllllllllllIIlIlIllIIIlIlllIII = this.sprites.get(new ResourceLocation(lllllllllllllIIlIlIllIIIlIlllIll.resolveTextureName("particle")));
        final SimpleBakedModel.Builder lllllllllllllIIlIlIllIIIlIllIlll = new SimpleBakedModel.Builder(lllllllllllllIIlIlIllIIIlIlllIll, lllllllllllllIIlIlIllIIIlIlllIll.createOverrides()).setTexture(lllllllllllllIIlIlIllIIIlIlllIII);
        if (lllllllllllllIIlIlIllIIIlIlllIll.getElements().isEmpty()) {
            return null;
        }
        for (final BlockPart lllllllllllllIIlIlIllIIIlIllIllI : lllllllllllllIIlIlIllIIIlIlllIll.getElements()) {
            for (final EnumFacing lllllllllllllIIlIlIllIIIlIllIlIl : lllllllllllllIIlIlIllIIIlIllIllI.mapFaces.keySet()) {
                final BlockPartFace lllllllllllllIIlIlIllIIIlIllIlII = lllllllllllllIIlIlIllIIIlIllIllI.mapFaces.get(lllllllllllllIIlIlIllIIIlIllIlIl);
                final TextureAtlasSprite lllllllllllllIIlIlIllIIIlIllIIll = this.sprites.get(new ResourceLocation(lllllllllllllIIlIlIllIIIlIlllIll.resolveTextureName(lllllllllllllIIlIlIllIIIlIllIlII.texture)));
                boolean lllllllllllllIIlIlIllIIIlIllIIlI = true;
                if (Reflector.ForgeHooksClient.exists()) {
                    lllllllllllllIIlIlIllIIIlIllIIlI = TRSRTransformation.isInteger(lllllllllllllIIlIlIllIIIlIlIllll.getMatrix());
                }
                if (lllllllllllllIIlIlIllIIIlIllIlII.cullFace != null && lllllllllllllIIlIlIllIIIlIllIIlI) {
                    lllllllllllllIIlIlIllIIIlIllIlll.addFaceQuad(lllllllllllllIIlIlIllIIIlIlIllll.rotate(lllllllllllllIIlIlIllIIIlIllIlII.cullFace), this.makeBakedQuad(lllllllllllllIIlIlIllIIIlIllIllI, lllllllllllllIIlIlIllIIIlIllIlII, lllllllllllllIIlIlIllIIIlIllIIll, lllllllllllllIIlIlIllIIIlIllIlIl, lllllllllllllIIlIlIllIIIlIlIllll, lllllllllllllIIlIlIllIIIlIlllIIl));
                }
                else {
                    lllllllllllllIIlIlIllIIIlIllIlll.addGeneralQuad(this.makeBakedQuad(lllllllllllllIIlIlIllIIIlIllIllI, lllllllllllllIIlIlIllIIIlIllIlII, lllllllllllllIIlIlIllIIIlIllIIll, lllllllllllllIIlIlIllIIIlIllIlIl, lllllllllllllIIlIlIllIIIlIlIllll, lllllllllllllIIlIlIllIIIlIlllIIl));
                }
            }
        }
        return lllllllllllllIIlIlIllIIIlIllIlll.makeBakedModel();
    }
    
    private static String fixResourcePath(String lllllllllllllIIlIlIlIllllIllIlII, final String lllllllllllllIIlIlIlIllllIllIIll) {
        lllllllllllllIIlIlIlIllllIllIlII = TextureUtils.fixResourcePath(lllllllllllllIIlIlIlIllllIllIlII, lllllllllllllIIlIlIlIllllIllIIll);
        lllllllllllllIIlIlIlIllllIllIlII = StrUtils.removeSuffix(lllllllllllllIIlIlIlIllllIllIlII, ".json");
        lllllllllllllIIlIlIlIllllIllIlII = StrUtils.removeSuffix(lllllllllllllIIlIlIlIllllIllIlII, ".png");
        return lllllllllllllIIlIlIlIllllIllIlII;
    }
    
    private Set<ResourceLocation> getVariantsTextureLocations() {
        final Set<ResourceLocation> lllllllllllllIIlIlIllIIIllllllll = (Set<ResourceLocation>)Sets.newHashSet();
        final List<ModelResourceLocation> lllllllllllllIIlIlIllIIIlllllllI = (List<ModelResourceLocation>)Lists.newArrayList((Iterable)this.variants.keySet());
        Collections.sort(lllllllllllllIIlIlIllIIIlllllllI, new Comparator<ModelResourceLocation>() {
            @Override
            public int compare(final ModelResourceLocation lllllllllllllIllllllIllllIIlIlII, final ModelResourceLocation lllllllllllllIllllllIllllIIlIIll) {
                return lllllllllllllIllllllIllllIIlIlII.toString().compareTo(lllllllllllllIllllllIllllIIlIIll.toString());
            }
        });
        for (final ModelResourceLocation lllllllllllllIIlIlIllIIIllllllIl : lllllllllllllIIlIlIllIIIlllllllI) {
            final VariantList lllllllllllllIIlIlIllIIIllllllII = this.variants.get(lllllllllllllIIlIlIllIIIllllllIl);
            for (final Variant lllllllllllllIIlIlIllIIIlllllIll : lllllllllllllIIlIlIllIIIllllllII.getVariantList()) {
                final ModelBlock lllllllllllllIIlIlIllIIIlllllIlI = this.models.get(lllllllllllllIIlIlIllIIIlllllIll.getModelLocation());
                if (lllllllllllllIIlIlIllIIIlllllIlI == null) {
                    ModelBakery.LOGGER.warn("Missing model for: {}", (Object)lllllllllllllIIlIlIllIIIllllllIl);
                }
                else {
                    lllllllllllllIIlIlIllIIIllllllll.addAll(this.getTextureLocations(lllllllllllllIIlIlIllIIIlllllIlI));
                }
            }
        }
        for (final ModelBlockDefinition lllllllllllllIIlIlIllIIIlllllIIl : this.multipartVariantMap.keySet()) {
            for (final VariantList lllllllllllllIIlIlIllIIIlllllIII : lllllllllllllIIlIlIllIIIlllllIIl.getMultipartData().getVariants()) {
                for (final Variant lllllllllllllIIlIlIllIIIllllIlll : lllllllllllllIIlIlIllIIIlllllIII.getVariantList()) {
                    final ModelBlock lllllllllllllIIlIlIllIIIllllIllI = this.models.get(lllllllllllllIIlIlIllIIIllllIlll.getModelLocation());
                    if (lllllllllllllIIlIlIllIIIllllIllI == null) {
                        ModelBakery.LOGGER.warn("Missing model for: {}", (Object)Block.REGISTRY.getNameForObject(lllllllllllllIIlIlIllIIIlllllIIl.getMultipartData().getStateContainer().getBlock()));
                    }
                    else {
                        lllllllllllllIIlIlIllIIIllllllll.addAll(this.getTextureLocations(lllllllllllllIIlIlIllIIIllllIllI));
                    }
                }
            }
        }
        lllllllllllllIIlIlIllIIIllllllll.addAll(ModelBakery.LOCATIONS_BUILTIN_TEXTURES);
        return lllllllllllllIIlIlIllIIIllllllll;
    }
    
    protected void loadBlock(final BlockStateMapper lllllllllllllIIlIlIllIlIIlIlIlIl, final Block lllllllllllllIIlIlIllIlIIlIlIlII, final ResourceLocation lllllllllllllIIlIlIllIlIIlIIlIII) {
        final ModelBlockDefinition lllllllllllllIIlIlIllIlIIlIlIIlI = this.getModelBlockDefinition(lllllllllllllIIlIlIllIlIIlIIlIII);
        final Map<IBlockState, ModelResourceLocation> lllllllllllllIIlIlIllIlIIlIlIIIl = lllllllllllllIIlIlIllIlIIlIlIlIl.getVariants(lllllllllllllIIlIlIllIlIIlIlIlII);
        if (lllllllllllllIIlIlIllIlIIlIlIIlI.hasMultipartData()) {
            final Collection<ModelResourceLocation> lllllllllllllIIlIlIllIlIIlIlIIII = (Collection<ModelResourceLocation>)Sets.newHashSet((Iterable)lllllllllllllIIlIlIllIlIIlIlIIIl.values());
            lllllllllllllIIlIlIllIlIIlIlIIlI.getMultipartData().setStateContainer(lllllllllllllIIlIlIllIlIIlIlIlII.getBlockState());
            Collection<ModelResourceLocation> lllllllllllllIIlIlIllIlIIlIIllll = this.multipartVariantMap.get(lllllllllllllIIlIlIllIlIIlIlIIlI);
            if (lllllllllllllIIlIlIllIlIIlIIllll == null) {
                lllllllllllllIIlIlIllIlIIlIIllll = (Collection<ModelResourceLocation>)Lists.newArrayList();
            }
            lllllllllllllIIlIlIllIlIIlIIllll.addAll(Lists.newArrayList(Iterables.filter((Iterable)lllllllllllllIIlIlIllIlIIlIlIIII, (Predicate)new Predicate<ModelResourceLocation>() {
                public boolean apply(@Nullable final ModelResourceLocation lllllllllllllllIIlIIlIlllIIIlIll) {
                    return lllllllllllllIIlIlIllIlIIlIIlIII.equals(lllllllllllllllIIlIIlIlllIIIlIll);
                }
            })));
            this.registerMultipartVariant(lllllllllllllIIlIlIllIlIIlIlIIlI, lllllllllllllIIlIlIllIlIIlIIllll);
        }
        for (final Map.Entry<IBlockState, ModelResourceLocation> lllllllllllllIIlIlIllIlIIlIIlllI : lllllllllllllIIlIlIllIlIIlIlIIIl.entrySet()) {
            final ModelResourceLocation lllllllllllllIIlIlIllIlIIlIIllIl = lllllllllllllIIlIlIllIlIIlIIlllI.getValue();
            if (lllllllllllllIIlIlIllIlIIlIIlIII.equals(lllllllllllllIIlIlIllIlIIlIIllIl)) {
                try {
                    if (Reflector.ForgeItem_delegate.exists()) {
                        this.registerVariant(lllllllllllllIIlIlIllIlIIlIlIIlI, lllllllllllllIIlIlIllIlIIlIIllIl);
                    }
                    else {
                        this.variants.put(lllllllllllllIIlIlIllIlIIlIIllIl, lllllllllllllIIlIlIllIlIIlIlIIlI.getVariant(lllllllllllllIIlIlIllIlIIlIIllIl.getVariant()));
                    }
                }
                catch (RuntimeException lllllllllllllIIlIlIllIlIIlIIllII) {
                    if (lllllllllllllIIlIlIllIlIIlIlIIlI.hasMultipartData()) {
                        continue;
                    }
                    ModelBakery.LOGGER.warn(String.valueOf(new StringBuilder("Unable to load variant: ").append(lllllllllllllIIlIlIllIlIIlIIllIl.getVariant()).append(" from ").append(lllllllllllllIIlIlIllIlIIlIIllIl)), (Throwable)lllllllllllllIIlIlIllIlIIlIIllII);
                }
            }
        }
    }
    
    private boolean isCustomRenderer(@Nullable final ModelBlock lllllllllllllIIlIlIlIllllllllIII) {
        if (lllllllllllllIIlIlIlIllllllllIII == null) {
            return false;
        }
        final ModelBlock lllllllllllllIIlIlIlIllllllllIIl = lllllllllllllIIlIlIlIllllllllIII.getRootModel();
        return lllllllllllllIIlIlIlIllllllllIIl == ModelBakery.MODEL_ENTITY;
    }
    
    private void loadModelsCheck() {
        this.loadModels();
        for (final ModelBlock lllllllllllllIIlIlIllIIIIlllIllI : this.models.values()) {
            lllllllllllllIIlIlIllIIIIlllIllI.getParentFromMap(this.models);
        }
        ModelBlock.checkModelHierarchy(this.models);
    }
    
    public ModelBakery(final IResourceManager lllllllllllllIIlIlIllIlIIlllllIl, final TextureMap lllllllllllllIIlIlIllIlIIllllIII, final BlockModelShapes lllllllllllllIIlIlIllIlIIllllIll) {
        this.sprites = (Map<ResourceLocation, TextureAtlasSprite>)Maps.newHashMap();
        this.models = (Map<ResourceLocation, ModelBlock>)Maps.newLinkedHashMap();
        this.variants = (Map<ModelResourceLocation, VariantList>)Maps.newLinkedHashMap();
        this.multipartVariantMap = (Map<ModelBlockDefinition, Collection<ModelResourceLocation>>)Maps.newLinkedHashMap();
        this.faceBakery = new FaceBakery();
        this.itemModelGenerator = new ItemModelGenerator();
        this.bakedRegistry = new RegistrySimple<ModelResourceLocation, IBakedModel>();
        this.itemLocations = (Map<String, ResourceLocation>)Maps.newLinkedHashMap();
        this.blockDefinitions = (Map<ResourceLocation, ModelBlockDefinition>)Maps.newHashMap();
        this.variantNames = (Map<Item, List<String>>)Maps.newIdentityHashMap();
        this.resourceManager = lllllllllllllIIlIlIllIlIIlllllIl;
        this.textureMap = lllllllllllllIIlIlIllIlIIllllIII;
        this.blockModelShapes = lllllllllllllIIlIlIllIlIIllllIll;
    }
    
    private void loadMultipartVariantModels() {
        for (final Map.Entry<ModelBlockDefinition, Collection<ModelResourceLocation>> lllllllllllllIIlIlIllIIllllIIlII : this.multipartVariantMap.entrySet()) {
            final ModelResourceLocation lllllllllllllIIlIlIllIIllllIIIll = lllllllllllllIIlIlIllIIllllIIlII.getValue().iterator().next();
            for (final VariantList lllllllllllllIIlIlIllIIllllIIIlI : lllllllllllllIIlIlIllIIllllIIlII.getKey().getMultipartVariants()) {
                this.loadVariantList(lllllllllllllIIlIlIllIIllllIIIll, lllllllllllllIIlIlIllIIllllIIIlI);
            }
        }
    }
    
    protected BakedQuad makeBakedQuad(final BlockPart lllllllllllllIIlIlIllIIIlIIIIlll, final BlockPartFace lllllllllllllIIlIlIllIIIIlllllll, final TextureAtlasSprite lllllllllllllIIlIlIllIIIIllllllI, final EnumFacing lllllllllllllIIlIlIllIIIIlllllIl, final ITransformation lllllllllllllIIlIlIllIIIIlllllII, final boolean lllllllllllllIIlIlIllIIIlIIIIIlI) {
        return this.faceBakery.makeBakedQuad(lllllllllllllIIlIlIllIIIlIIIIlll.positionFrom, lllllllllllllIIlIlIllIIIlIIIIlll.positionTo, lllllllllllllIIlIlIllIIIIlllllll, lllllllllllllIIlIlIllIIIIllllllI, lllllllllllllIIlIlIllIIIIlllllIl, lllllllllllllIIlIlIllIIIIlllllII, lllllllllllllIIlIlIllIIIlIIIIlll.partRotation, lllllllllllllIIlIlIllIIIlIIIIIlI, lllllllllllllIIlIlIllIIIlIIIIlll.shade);
    }
    
    private void loadVariantModels() {
        for (final Map.Entry<ModelResourceLocation, VariantList> lllllllllllllIIlIlIllIIllllIllll : this.variants.entrySet()) {
            this.loadVariantList(lllllllllllllIIlIlIllIIllllIllll.getKey(), lllllllllllllIIlIlIllIIllllIllll.getValue());
        }
    }
    
    private void bakeBlockModels() {
        for (final ModelResourceLocation lllllllllllllIIlIlIllIIlIlIIlllI : this.variants.keySet()) {
            final IBakedModel lllllllllllllIIlIlIllIIlIlIIllIl = this.createRandomModelForVariantList(this.variants.get(lllllllllllllIIlIlIllIIlIlIIlllI), lllllllllllllIIlIlIllIIlIlIIlllI.toString());
            if (lllllllllllllIIlIlIllIIlIlIIllIl != null) {
                this.bakedRegistry.putObject(lllllllllllllIIlIlIllIIlIlIIlllI, lllllllllllllIIlIlIllIIlIlIIllIl);
            }
        }
        for (final Map.Entry<ModelBlockDefinition, Collection<ModelResourceLocation>> lllllllllllllIIlIlIllIIlIlIIllII : this.multipartVariantMap.entrySet()) {
            final ModelBlockDefinition lllllllllllllIIlIlIllIIlIlIIlIll = lllllllllllllIIlIlIllIIlIlIIllII.getKey();
            final Multipart lllllllllllllIIlIlIllIIlIlIIlIlI = lllllllllllllIIlIlIllIIlIlIIlIll.getMultipartData();
            final String lllllllllllllIIlIlIllIIlIlIIlIIl = Block.REGISTRY.getNameForObject(lllllllllllllIIlIlIllIIlIlIIlIlI.getStateContainer().getBlock()).toString();
            final MultipartBakedModel.Builder lllllllllllllIIlIlIllIIlIlIIlIII = new MultipartBakedModel.Builder();
            for (final Selector lllllllllllllIIlIlIllIIlIlIIIlll : lllllllllllllIIlIlIllIIlIlIIlIlI.getSelectors()) {
                final IBakedModel lllllllllllllIIlIlIllIIlIlIIIllI = this.createRandomModelForVariantList(lllllllllllllIIlIlIllIIlIlIIIlll.getVariantList(), String.valueOf(new StringBuilder("selector of ").append(lllllllllllllIIlIlIllIIlIlIIlIIl)));
                if (lllllllllllllIIlIlIllIIlIlIIIllI != null) {
                    lllllllllllllIIlIlIllIIlIlIIlIII.putModel(lllllllllllllIIlIlIllIIlIlIIIlll.getPredicate(lllllllllllllIIlIlIllIIlIlIIlIlI.getStateContainer()), lllllllllllllIIlIlIllIIlIlIIIllI);
                }
            }
            final IBakedModel lllllllllllllIIlIlIllIIlIlIIIlIl = lllllllllllllIIlIlIllIIlIlIIlIII.makeMultipartModel();
            for (final ModelResourceLocation lllllllllllllIIlIlIllIIlIlIIIlII : lllllllllllllIIlIlIllIIlIlIIllII.getValue()) {
                if (!lllllllllllllIIlIlIllIIlIlIIlIll.hasVariant(lllllllllllllIIlIlIllIIlIlIIIlII.getVariant())) {
                    this.bakedRegistry.putObject(lllllllllllllIIlIlIllIIlIlIIIlII, lllllllllllllIIlIlIllIIlIlIIIlIl);
                }
            }
        }
    }
    
    private void func_191401_d() {
        final ResourceLocation lllllllllllllIIlIlIllIlIIIlllIlI = new ResourceLocation("item_frame");
        final ModelBlockDefinition lllllllllllllIIlIlIllIlIIIlllIIl = this.getModelBlockDefinition(lllllllllllllIIlIlIllIlIIIlllIlI);
        this.registerVariant(lllllllllllllIIlIlIllIlIIIlllIIl, new ModelResourceLocation(lllllllllllllIIlIlIllIlIIIlllIlI, "normal"));
        this.registerVariant(lllllllllllllIIlIlIllIlIIIlllIIl, new ModelResourceLocation(lllllllllllllIIlIlIllIlIIIlllIlI, "map"));
    }
    
    private ModelBlockDefinition loadModelBlockDefinition(final ResourceLocation lllllllllllllIIlIlIllIIlllllllIl, final IResource lllllllllllllIIlIlIllIIlllllllII) {
        InputStream lllllllllllllIIlIlIllIlIIIIIIIlI = null;
        try {
            lllllllllllllIIlIlIllIlIIIIIIIlI = lllllllllllllIIlIlIllIIlllllllII.getInputStream();
            if (Reflector.ForgeModelBlockDefinition_parseFromReader2.exists()) {
                final ModelBlockDefinition lllllllllllllIIlIlIllIlIIIIIIIIl = (ModelBlockDefinition)Reflector.call(Reflector.ForgeModelBlockDefinition_parseFromReader2, new InputStreamReader(lllllllllllllIIlIlIllIlIIIIIIIlI, StandardCharsets.UTF_8), lllllllllllllIIlIlIllIIlllllllIl);
            }
            else {
                final ModelBlockDefinition lllllllllllllIIlIlIllIlIIIIIIIII = ModelBlockDefinition.parseFromReader(new InputStreamReader(lllllllllllllIIlIlIllIlIIIIIIIlI, StandardCharsets.UTF_8));
            }
        }
        catch (Exception lllllllllllllIIlIlIllIIllllllllI) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Encountered an exception when loading model definition of '").append(lllllllllllllIIlIlIllIIlllllllIl).append("' from: '").append(lllllllllllllIIlIlIllIIlllllllII.getResourceLocation()).append("' in resourcepack: '").append(lllllllllllllIIlIlIllIIlllllllII.getResourcePackName()).append("'")), lllllllllllllIIlIlIllIIllllllllI);
        }
        finally {
            IOUtils.closeQuietly(lllllllllllllIIlIlIllIlIIIIIIIlI);
        }
        IOUtils.closeQuietly(lllllllllllllIIlIlIllIlIIIIIIIlI);
        final ModelBlockDefinition lllllllllllllIIlIlIllIIlllllllll;
        return lllllllllllllIIlIlIllIIlllllllll;
    }
    
    private ResourceLocation getItemLocation(final String lllllllllllllIIlIlIllIIlIlIllIll) {
        ResourceLocation lllllllllllllIIlIlIllIIlIlIlllII = new ResourceLocation(lllllllllllllIIlIlIllIIlIlIllIll);
        if (Reflector.ForgeHooksClient.exists()) {
            lllllllllllllIIlIlIllIIlIlIlllII = new ResourceLocation(lllllllllllllIIlIlIllIIlIlIllIll.replaceAll("#.*", ""));
        }
        return new ResourceLocation(lllllllllllllIIlIlIllIIlIlIlllII.getResourceDomain(), String.valueOf(new StringBuilder("item/").append(lllllllllllllIIlIlIllIIlIlIlllII.getResourcePath())));
    }
    
    private ModelBlock makeItemModel(final ModelBlock lllllllllllllIIlIlIlIllllllIIlII) {
        return this.itemModelGenerator.makeItemModel(this.textureMap, lllllllllllllIIlIlIlIllllllIIlII);
    }
    
    protected void registerMultipartVariant(final ModelBlockDefinition lllllllllllllIIlIlIlIllllIlIlIll, final Collection<ModelResourceLocation> lllllllllllllIIlIlIlIllllIlIlIlI) {
        this.multipartVariantMap.put(lllllllllllllIIlIlIlIllllIlIlIll, lllllllllllllIIlIlIlIllllIlIlIlI);
    }
    
    @Nullable
    private IBakedModel createRandomModelForVariantList(final VariantList lllllllllllllIIlIlIllIIlIIlIIllI, final String lllllllllllllIIlIlIllIIlIIlIIlIl) {
        if (lllllllllllllIIlIlIllIIlIIlIIllI.getVariantList().isEmpty()) {
            return null;
        }
        final WeightedBakedModel.Builder lllllllllllllIIlIlIllIIlIIlIllIl = new WeightedBakedModel.Builder();
        int lllllllllllllIIlIlIllIIlIIlIllII = 0;
        for (final Variant lllllllllllllIIlIlIllIIlIIlIlIll : lllllllllllllIIlIlIllIIlIIlIIllI.getVariantList()) {
            final ModelBlock lllllllllllllIIlIlIllIIlIIlIlIlI = this.models.get(lllllllllllllIIlIlIllIIlIIlIlIll.getModelLocation());
            if (lllllllllllllIIlIlIllIIlIIlIlIlI != null && lllllllllllllIIlIlIllIIlIIlIlIlI.isResolved()) {
                if (lllllllllllllIIlIlIllIIlIIlIlIlI.getElements().isEmpty()) {
                    ModelBakery.LOGGER.warn("Missing elements for: {}", (Object)lllllllllllllIIlIlIllIIlIIlIIlIl);
                }
                else {
                    final IBakedModel lllllllllllllIIlIlIllIIlIIlIlIIl = this.bakeModel(lllllllllllllIIlIlIllIIlIIlIlIlI, lllllllllllllIIlIlIllIIlIIlIlIll.getRotation(), lllllllllllllIIlIlIllIIlIIlIlIll.isUvLock());
                    if (lllllllllllllIIlIlIllIIlIIlIlIIl == null) {
                        continue;
                    }
                    ++lllllllllllllIIlIlIllIIlIIlIllII;
                    lllllllllllllIIlIlIllIIlIIlIllIl.add(lllllllllllllIIlIlIllIIlIIlIlIIl, lllllllllllllIIlIlIllIIlIIlIlIll.getWeight());
                }
            }
            else {
                ModelBakery.LOGGER.warn("Missing model for: {}", (Object)lllllllllllllIIlIlIllIIlIIlIIlIl);
            }
        }
        IBakedModel lllllllllllllIIlIlIllIIlIIlIlIII = null;
        if (lllllllllllllIIlIlIllIIlIIlIllII == 0) {
            ModelBakery.LOGGER.warn("No weighted models for: {}", (Object)lllllllllllllIIlIlIllIIlIIlIIlIl);
        }
        else if (lllllllllllllIIlIlIllIIlIIlIllII == 1) {
            lllllllllllllIIlIlIllIIlIIlIlIII = lllllllllllllIIlIlIllIIlIIlIllIl.first();
        }
        else {
            lllllllllllllIIlIlIllIIlIIlIlIII = lllllllllllllIIlIlIllIIlIIlIllIl.build();
        }
        return lllllllllllllIIlIlIllIIlIIlIlIII;
    }
    
    @Nullable
    private ResourceLocation getParentLocation(final ResourceLocation lllllllllllllIIlIlIllIIIIlIIIIlI) {
        for (final Map.Entry<ResourceLocation, ModelBlock> lllllllllllllIIlIlIllIIIIlIIIIIl : this.models.entrySet()) {
            final ModelBlock lllllllllllllIIlIlIllIIIIlIIIIII = lllllllllllllIIlIlIllIIIIlIIIIIl.getValue();
            if (lllllllllllllIIlIlIllIIIIlIIIIII != null && lllllllllllllIIlIlIllIIIIlIIIIlI.equals(lllllllllllllIIlIlIllIIIIlIIIIII.getParentLocation())) {
                return lllllllllllllIIlIlIllIIIIlIIIIIl.getKey();
            }
        }
        return null;
    }
    
    private void loadItemModels() {
        this.registerVariantNames();
        for (final Item lllllllllllllIIlIlIllIIllIIlIIIl : Item.REGISTRY) {
            for (final String lllllllllllllIIlIlIllIIllIIlIIII : this.getVariantNames(lllllllllllllIIlIlIllIIllIIlIIIl)) {
                final ResourceLocation lllllllllllllIIlIlIllIIllIIIllll = this.getItemLocation(lllllllllllllIIlIlIllIIllIIlIIII);
                final ResourceLocation lllllllllllllIIlIlIllIIllIIIlllI = Item.REGISTRY.getNameForObject(lllllllllllllIIlIlIllIIllIIlIIIl);
                this.loadItemModel(lllllllllllllIIlIlIllIIllIIlIIII, lllllllllllllIIlIlIllIIllIIIllll, lllllllllllllIIlIlIllIIllIIIlllI);
                if (lllllllllllllIIlIlIllIIllIIlIIIl.hasCustomProperties()) {
                    final ModelBlock lllllllllllllIIlIlIllIIllIIIllIl = this.models.get(lllllllllllllIIlIlIllIIllIIIllll);
                    if (lllllllllllllIIlIlIllIIllIIIllIl == null) {
                        continue;
                    }
                    for (final ResourceLocation lllllllllllllIIlIlIllIIllIIIllII : lllllllllllllIIlIlIllIIllIIIllIl.getOverrideLocations()) {
                        this.loadItemModel(lllllllllllllIIlIlIllIIllIIIllII.toString(), lllllllllllllIIlIlIllIIllIIIllII, lllllllllllllIIlIlIllIIllIIIlllI);
                    }
                }
            }
        }
    }
}
