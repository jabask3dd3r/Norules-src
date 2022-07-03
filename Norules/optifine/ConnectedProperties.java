package optifine;

import net.minecraft.world.biome.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.client.*;
import java.util.*;

public class ConnectedProperties
{
    public /* synthetic */ Biome[] biomes;
    public /* synthetic */ int[] metadatas;
    public /* synthetic */ MatchBlock[] matchBlocks;
    public /* synthetic */ int faces;
    public /* synthetic */ int renderPass;
    public /* synthetic */ TextureAtlasSprite[] connectTileIcons;
    public /* synthetic */ String[] tiles;
    public /* synthetic */ int height;
    public /* synthetic */ int[] ctmTileIndexes;
    public /* synthetic */ BlockRenderLayer layer;
    public /* synthetic */ TextureAtlasSprite[] matchTileIcons;
    public /* synthetic */ int tintIndex;
    public /* synthetic */ String name;
    public /* synthetic */ int[] weights;
    public /* synthetic */ int width;
    public /* synthetic */ int maxHeight;
    public /* synthetic */ TextureAtlasSprite[] tileIcons;
    public /* synthetic */ String[] connectTiles;
    public /* synthetic */ MatchBlock[] connectBlocks;
    public /* synthetic */ int method;
    public /* synthetic */ int[] sumWeights;
    public /* synthetic */ int symmetry;
    public /* synthetic */ boolean innerSeams;
    public /* synthetic */ String basePath;
    public /* synthetic */ String[] matchTiles;
    public /* synthetic */ int connect;
    public /* synthetic */ int minHeight;
    public /* synthetic */ IBlockState tintBlockState;
    public /* synthetic */ int sumAllWeights;
    
    public ConnectedProperties(final Properties llllllllllllllIIIlIIlIIllllIlIII, final String llllllllllllllIIIlIIlIIllllIlIll) {
        this.name = null;
        this.basePath = null;
        this.matchBlocks = null;
        this.metadatas = null;
        this.matchTiles = null;
        this.method = 0;
        this.tiles = null;
        this.connect = 0;
        this.faces = 63;
        this.biomes = null;
        this.minHeight = 0;
        this.maxHeight = 1024;
        this.renderPass = 0;
        this.innerSeams = false;
        this.ctmTileIndexes = null;
        this.width = 0;
        this.height = 0;
        this.weights = null;
        this.symmetry = 1;
        this.sumWeights = null;
        this.sumAllWeights = 1;
        this.matchTileIcons = null;
        this.tileIcons = null;
        this.connectBlocks = null;
        this.connectTiles = null;
        this.connectTileIcons = null;
        this.tintIndex = -1;
        this.tintBlockState = Blocks.AIR.getDefaultState();
        this.layer = null;
        final ConnectedParser llllllllllllllIIIlIIlIIllllIlIlI = new ConnectedParser("ConnectedTextures");
        this.name = llllllllllllllIIIlIIlIIllllIlIlI.parseName(llllllllllllllIIIlIIlIIllllIlIll);
        this.basePath = llllllllllllllIIIlIIlIIllllIlIlI.parseBasePath(llllllllllllllIIIlIIlIIllllIlIll);
        this.matchBlocks = llllllllllllllIIIlIIlIIllllIlIlI.parseMatchBlocks(llllllllllllllIIIlIIlIIllllIlIII.getProperty("matchBlocks"));
        this.metadatas = llllllllllllllIIIlIIlIIllllIlIlI.parseIntList(llllllllllllllIIIlIIlIIllllIlIII.getProperty("metadata"));
        this.matchTiles = this.parseMatchTiles(llllllllllllllIIIlIIlIIllllIlIII.getProperty("matchTiles"));
        this.method = parseMethod(llllllllllllllIIIlIIlIIllllIlIII.getProperty("method"));
        this.tiles = this.parseTileNames(llllllllllllllIIIlIIlIIllllIlIII.getProperty("tiles"));
        this.connect = parseConnect(llllllllllllllIIIlIIlIIllllIlIII.getProperty("connect"));
        this.faces = parseFaces(llllllllllllllIIIlIIlIIllllIlIII.getProperty("faces"));
        this.biomes = llllllllllllllIIIlIIlIIllllIlIlI.parseBiomes(llllllllllllllIIIlIIlIIllllIlIII.getProperty("biomes"));
        this.minHeight = llllllllllllllIIIlIIlIIllllIlIlI.parseInt(llllllllllllllIIIlIIlIIllllIlIII.getProperty("minHeight"), -1);
        this.maxHeight = llllllllllllllIIIlIIlIIllllIlIlI.parseInt(llllllllllllllIIIlIIlIIllllIlIII.getProperty("maxHeight"), 1024);
        this.renderPass = llllllllllllllIIIlIIlIIllllIlIlI.parseInt(llllllllllllllIIIlIIlIIllllIlIII.getProperty("renderPass"));
        this.innerSeams = ConnectedParser.parseBoolean(llllllllllllllIIIlIIlIIllllIlIII.getProperty("innerSeams"));
        this.ctmTileIndexes = this.parseCtmTileIndexes(llllllllllllllIIIlIIlIIllllIlIII);
        this.width = llllllllllllllIIIlIIlIIllllIlIlI.parseInt(llllllllllllllIIIlIIlIIllllIlIII.getProperty("width"));
        this.height = llllllllllllllIIIlIIlIIllllIlIlI.parseInt(llllllllllllllIIIlIIlIIllllIlIII.getProperty("height"));
        this.weights = llllllllllllllIIIlIIlIIllllIlIlI.parseIntList(llllllllllllllIIIlIIlIIllllIlIII.getProperty("weights"));
        this.symmetry = parseSymmetry(llllllllllllllIIIlIIlIIllllIlIII.getProperty("symmetry"));
        this.connectBlocks = llllllllllllllIIIlIIlIIllllIlIlI.parseMatchBlocks(llllllllllllllIIIlIIlIIllllIlIII.getProperty("connectBlocks"));
        this.connectTiles = this.parseMatchTiles(llllllllllllllIIIlIIlIIllllIlIII.getProperty("connectTiles"));
        this.tintIndex = llllllllllllllIIIlIIlIIllllIlIlI.parseInt(llllllllllllllIIIlIIlIIllllIlIII.getProperty("tintIndex"));
        this.tintBlockState = llllllllllllllIIIlIIlIIllllIlIlI.parseBlockState(llllllllllllllIIIlIIlIIllllIlIII.getProperty("tintBlock"), Blocks.AIR.getDefaultState());
        this.layer = llllllllllllllIIIlIIlIIllllIlIlI.parseBlockRenderLayer(llllllllllllllIIIlIIlIIllllIlIII.getProperty("layer"), BlockRenderLayer.CUTOUT_MIPPED);
    }
    
    private static TextureAtlasSprite[] registerIcons(final String[] llllllllllllllIIIlIIlIIIlIllIIII, final TextureMap llllllllllllllIIIlIIlIIIlIlIllll) {
        if (llllllllllllllIIIlIIlIIIlIllIIII == null) {
            return null;
        }
        final List llllllllllllllIIIlIIlIIIlIlllllI = new ArrayList();
        for (int llllllllllllllIIIlIIlIIIlIllllIl = 0; llllllllllllllIIIlIIlIIIlIllllIl < llllllllllllllIIIlIIlIIIlIllIIII.length; ++llllllllllllllIIIlIIlIIIlIllllIl) {
            final String llllllllllllllIIIlIIlIIIlIllllII = llllllllllllllIIIlIIlIIIlIllIIII[llllllllllllllIIIlIIlIIIlIllllIl];
            final ResourceLocation llllllllllllllIIIlIIlIIIlIlllIll = new ResourceLocation(llllllllllllllIIIlIIlIIIlIllllII);
            final String llllllllllllllIIIlIIlIIIlIlllIlI = llllllllllllllIIIlIIlIIIlIlllIll.getResourceDomain();
            String llllllllllllllIIIlIIlIIIlIlllIIl = llllllllllllllIIIlIIlIIIlIlllIll.getResourcePath();
            if (!llllllllllllllIIIlIIlIIIlIlllIIl.contains("/")) {
                llllllllllllllIIIlIIlIIIlIlllIIl = String.valueOf(new StringBuilder("textures/blocks/").append(llllllllllllllIIIlIIlIIIlIlllIIl));
            }
            final String llllllllllllllIIIlIIlIIIlIlllIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIIlIIIlIlllIIl)).append(".png"));
            final ResourceLocation llllllllllllllIIIlIIlIIIlIllIlll = new ResourceLocation(llllllllllllllIIIlIIlIIIlIlllIlI, llllllllllllllIIIlIIlIIIlIlllIII);
            final boolean llllllllllllllIIIlIIlIIIlIllIllI = Config.hasResource(llllllllllllllIIIlIIlIIIlIllIlll);
            if (!llllllllllllllIIIlIIlIIIlIllIllI) {
                Config.warn(String.valueOf(new StringBuilder("File not found: ").append(llllllllllllllIIIlIIlIIIlIlllIII)));
            }
            final String llllllllllllllIIIlIIlIIIlIllIlIl = "textures/";
            String llllllllllllllIIIlIIlIIIlIllIlII = llllllllllllllIIIlIIlIIIlIlllIIl;
            if (llllllllllllllIIIlIIlIIIlIlllIIl.startsWith(llllllllllllllIIIlIIlIIIlIllIlIl)) {
                llllllllllllllIIIlIIlIIIlIllIlII = llllllllllllllIIIlIIlIIIlIlllIIl.substring(llllllllllllllIIIlIIlIIIlIllIlIl.length());
            }
            final ResourceLocation llllllllllllllIIIlIIlIIIlIllIIll = new ResourceLocation(llllllllllllllIIIlIIlIIIlIlllIlI, llllllllllllllIIIlIIlIIIlIllIlII);
            final TextureAtlasSprite llllllllllllllIIIlIIlIIIlIllIIlI = llllllllllllllIIIlIIlIIIlIlIllll.registerSprite(llllllllllllllIIIlIIlIIIlIllIIll);
            llllllllllllllIIIlIIlIIIlIlllllI.add(llllllllllllllIIIlIIlIIIlIllIIlI);
        }
        final TextureAtlasSprite[] llllllllllllllIIIlIIlIIIlIllIIIl = llllllllllllllIIIlIIlIIIlIlllllI.toArray(new TextureAtlasSprite[llllllllllllllIIIlIIlIIIlIlllllI.size()]);
        return llllllllllllllIIIlIIlIIIlIllIIIl;
    }
    
    private boolean isValidVertical(final String llllllllllllllIIIlIIlIIlIIIIlIII) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("No tiles defined for vertical: ").append(llllllllllllllIIIlIIlIIlIIIIlIII)));
            return false;
        }
        if (this.tiles.length != 4) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 4: ").append(llllllllllllllIIIlIIlIIlIIIIlIII)));
            return false;
        }
        return true;
    }
    
    private static int parseMethod(final String llllllllllllllIIIlIIlIIlIlIllIII) {
        if (llllllllllllllIIIlIIlIIlIlIllIII == null) {
            return 1;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("ctm") || llllllllllllllIIIlIIlIIlIlIllIII.equals("glass")) {
            return 1;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("ctm_compact")) {
            return 10;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("horizontal") || llllllllllllllIIIlIIlIIlIlIllIII.equals("bookshelf")) {
            return 2;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("vertical")) {
            return 6;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("top")) {
            return 3;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("random")) {
            return 4;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("repeat")) {
            return 5;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("fixed")) {
            return 7;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("horizontal+vertical") || llllllllllllllIIIlIIlIIlIlIllIII.equals("h+v")) {
            return 8;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("vertical+horizontal") || llllllllllllllIIIlIIlIIlIlIllIII.equals("v+h")) {
            return 9;
        }
        if (llllllllllllllIIIlIIlIIlIlIllIII.equals("overlay")) {
            return 11;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown method: ").append(llllllllllllllIIIlIIlIIlIlIllIII)));
        return 0;
    }
    
    public boolean matchesBlockId(final int llllllllllllllIIIlIIlIIIlIIllllI) {
        return Matches.blockId(llllllllllllllIIIlIIlIIIlIIllllI, this.matchBlocks);
    }
    
    private int detectConnect() {
        if (this.matchBlocks != null) {
            return 1;
        }
        return (this.matchTiles != null) ? 2 : 128;
    }
    
    private static String parseName(final String llllllllllllllIIIlIIlIIllIllIIII) {
        String llllllllllllllIIIlIIlIIllIlIllll = llllllllllllllIIIlIIlIIllIllIIII;
        final int llllllllllllllIIIlIIlIIllIlIlllI = llllllllllllllIIIlIIlIIllIllIIII.lastIndexOf(47);
        if (llllllllllllllIIIlIIlIIllIlIlllI >= 0) {
            llllllllllllllIIIlIIlIIllIlIllll = llllllllllllllIIIlIIlIIllIllIIII.substring(llllllllllllllIIIlIIlIIllIlIlllI + 1);
        }
        final int llllllllllllllIIIlIIlIIllIlIllIl = llllllllllllllIIIlIIlIIllIlIllll.lastIndexOf(46);
        if (llllllllllllllIIIlIIlIIllIlIllIl >= 0) {
            llllllllllllllIIIlIIlIIllIlIllll = llllllllllllllIIIlIIlIIllIlIllll.substring(0, llllllllllllllIIIlIIlIIllIlIllIl);
        }
        return llllllllllllllIIIlIIlIIllIlIllll;
    }
    
    private String[] detectMatchTiles() {
        final TextureAtlasSprite llllllllllllllIIIlIIlIIlIIlIllll = getIcon(this.name);
        return (String[])((llllllllllllllIIIlIIlIIlIIlIllll == null) ? null : new String[] { this.name });
    }
    
    public static IProperty getProperty(final String llllllllllllllIIIlIIlIIlIlIllllI, final Collection llllllllllllllIIIlIIlIIlIlIlllIl) {
        for (final Object llllllllllllllIIIlIIlIIlIlIlllll : llllllllllllllIIIlIIlIIlIlIlllIl) {
            if (llllllllllllllIIIlIIlIIlIlIllllI.equals(((IProperty)llllllllllllllIIIlIIlIIlIlIlllll).getName())) {
                return (IProperty)llllllllllllllIIIlIIlIIlIlIlllll;
            }
        }
        return null;
    }
    
    private MatchBlock[] detectMatchBlocks() {
        final int[] llllllllllllllIIIlIIlIIlIlIIlIIl = this.detectMatchBlockIds();
        if (llllllllllllllIIIlIIlIIlIlIIlIIl == null) {
            return null;
        }
        final MatchBlock[] llllllllllllllIIIlIIlIIlIlIIlIII = new MatchBlock[llllllllllllllIIIlIIlIIlIlIIlIIl.length];
        for (int llllllllllllllIIIlIIlIIlIlIIIlll = 0; llllllllllllllIIIlIIlIIlIlIIIlll < llllllllllllllIIIlIIlIIlIlIIlIII.length; ++llllllllllllllIIIlIIlIIlIlIIIlll) {
            llllllllllllllIIIlIIlIIlIlIIlIII[llllllllllllllIIIlIIlIIlIlIIIlll] = new MatchBlock(llllllllllllllIIIlIIlIIlIlIIlIIl[llllllllllllllIIIlIIlIIlIlIIIlll]);
        }
        return llllllllllllllIIIlIIlIIlIlIIlIII;
    }
    
    public int getMetadataMax() {
        int llllllllllllllIIIlIIlIIIIllllllI = -1;
        llllllllllllllIIIlIIlIIIIllllllI = this.getMax(this.metadatas, llllllllllllllIIIlIIlIIIIllllllI);
        if (this.matchBlocks != null) {
            for (int llllllllllllllIIIlIIlIIIIlllllIl = 0; llllllllllllllIIIlIIlIIIIlllllIl < this.matchBlocks.length; ++llllllllllllllIIIlIIlIIIIlllllIl) {
                final MatchBlock llllllllllllllIIIlIIlIIIIlllllII = this.matchBlocks[llllllllllllllIIIlIIlIIIIlllllIl];
                llllllllllllllIIIlIIlIIIIllllllI = this.getMax(llllllllllllllIIIlIIlIIIIlllllII.getMetadatas(), llllllllllllllIIIlIIlIIIIllllllI);
            }
        }
        return llllllllllllllIIIlIIlIIIIllllllI;
    }
    
    private boolean isValidOverlay(final String llllllllllllllIIIlIIlIIlIIIlIlII) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("0-16");
        }
        if (this.tiles.length < 17) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be at least 17: ").append(llllllllllllllIIIlIIlIIlIIIlIlII)));
            return false;
        }
        if (this.layer != null && this.layer != BlockRenderLayer.SOLID) {
            return true;
        }
        Config.warn(String.valueOf(new StringBuilder("Invalid overlay layer: ").append(this.layer)));
        return false;
    }
    
    private static TextureAtlasSprite getIcon(final String llllllllllllllIIIlIIlIIlIIlIlIIl) {
        final TextureMap llllllllllllllIIIlIIlIIlIIlIlIII = Minecraft.getMinecraft().getTextureMapBlocks();
        TextureAtlasSprite llllllllllllllIIIlIIlIIlIIlIIlll = llllllllllllllIIIlIIlIIlIIlIlIII.getSpriteSafe(llllllllllllllIIIlIIlIIlIIlIlIIl);
        if (llllllllllllllIIIlIIlIIlIIlIIlll != null) {
            return llllllllllllllIIIlIIlIIlIIlIIlll;
        }
        llllllllllllllIIIlIIlIIlIIlIIlll = llllllllllllllIIIlIIlIIlIIlIlIII.getSpriteSafe(String.valueOf(new StringBuilder("blocks/").append(llllllllllllllIIIlIIlIIlIIlIlIIl)));
        return llllllllllllllIIIlIIlIIlIIlIIlll;
    }
    
    private boolean isValidRandom(final String llllllllllllllIIIlIIlIIIlllIlIll) {
        if (this.tiles != null && this.tiles.length > 0) {
            if (this.weights != null) {
                if (this.weights.length > this.tiles.length) {
                    Config.warn(String.valueOf(new StringBuilder("More weights defined than tiles, trimming weights: ").append(llllllllllllllIIIlIIlIIIlllIlIll)));
                    final int[] llllllllllllllIIIlIIlIIIllllIIlI = new int[this.tiles.length];
                    System.arraycopy(this.weights, 0, llllllllllllllIIIlIIlIIIllllIIlI, 0, llllllllllllllIIIlIIlIIIllllIIlI.length);
                    this.weights = llllllllllllllIIIlIIlIIIllllIIlI;
                }
                if (this.weights.length < this.tiles.length) {
                    Config.warn(String.valueOf(new StringBuilder("Less weights defined than tiles, expanding weights: ").append(llllllllllllllIIIlIIlIIIlllIlIll)));
                    final int[] llllllllllllllIIIlIIlIIIllllIIIl = new int[this.tiles.length];
                    System.arraycopy(this.weights, 0, llllllllllllllIIIlIIlIIIllllIIIl, 0, this.weights.length);
                    final int llllllllllllllIIIlIIlIIIllllIIII = MathUtils.getAverage(this.weights);
                    for (int llllllllllllllIIIlIIlIIIlllIllll = this.weights.length; llllllllllllllIIIlIIlIIIlllIllll < llllllllllllllIIIlIIlIIIllllIIIl.length; ++llllllllllllllIIIlIIlIIIlllIllll) {
                        llllllllllllllIIIlIIlIIIllllIIIl[llllllllllllllIIIlIIlIIIlllIllll] = llllllllllllllIIIlIIlIIIllllIIII;
                    }
                    this.weights = llllllllllllllIIIlIIlIIIllllIIIl;
                }
                this.sumWeights = new int[this.weights.length];
                int llllllllllllllIIIlIIlIIIlllIlllI = 0;
                for (int llllllllllllllIIIlIIlIIIlllIllIl = 0; llllllllllllllIIIlIIlIIIlllIllIl < this.weights.length; ++llllllllllllllIIIlIIlIIIlllIllIl) {
                    llllllllllllllIIIlIIlIIIlllIlllI += this.weights[llllllllllllllIIIlIIlIIIlllIllIl];
                    this.sumWeights[llllllllllllllIIIlIIlIIIlllIllIl] = llllllllllllllIIIlIIlIIIlllIlllI;
                }
                this.sumAllWeights = llllllllllllllIIIlIIlIIIlllIlllI;
                if (this.sumAllWeights <= 0) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid sum of all weights: ").append(llllllllllllllIIIlIIlIIIlllIlllI)));
                    this.sumAllWeights = 1;
                }
            }
            return true;
        }
        Config.warn(String.valueOf(new StringBuilder("Tiles not defined: ").append(llllllllllllllIIIlIIlIIIlllIlIll)));
        return false;
    }
    
    private boolean isValidTop(final String llllllllllllllIIIlIIlIIIllIllIII) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("66");
        }
        if (this.tiles.length != 1) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 1: ").append(llllllllllllllIIIlIIlIIIllIllIII)));
            return false;
        }
        return true;
    }
    
    private boolean isValidHorizontal(final String llllllllllllllIIIlIIlIIlIIIIlllI) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("12-15");
        }
        if (this.tiles.length != 4) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 4: ").append(llllllllllllllIIIlIIlIIlIIIIlllI)));
            return false;
        }
        return true;
    }
    
    public boolean matchesBlock(final int llllllllllllllIIIlIIlIIIlIIlIlII, final int llllllllllllllIIIlIIlIIIlIIlIllI) {
        return Matches.block(llllllllllllllIIIlIIlIIIlIIlIlII, llllllllllllllIIIlIIlIIIlIIlIllI, this.matchBlocks) && Matches.metadata(llllllllllllllIIIlIIlIIIlIIlIllI, this.metadatas);
    }
    
    private boolean isValidFixed(final String llllllllllllllIIIlIIlIIIllIlllII) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("Tiles not defined: ").append(llllllllllllllIIIlIIlIIIllIlllII)));
            return false;
        }
        if (this.tiles.length != 1) {
            Config.warn("Number of tiles should be 1 for method: fixed.");
            return false;
        }
        return true;
    }
    
    private boolean isValidCtmCompact(final String llllllllllllllIIIlIIlIIlIIIllIII) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("0-4");
        }
        if (this.tiles.length < 5) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be at least 5: ").append(llllllllllllllIIIlIIlIIlIIIllIII)));
            return false;
        }
        return true;
    }
    
    private String[] parseMatchTiles(final String llllllllllllllIIIlIIlIIllIlllIII) {
        if (llllllllllllllIIIlIIlIIllIlllIII == null) {
            return null;
        }
        final String[] llllllllllllllIIIlIIlIIllIllllII = Config.tokenize(llllllllllllllIIIlIIlIIllIlllIII, " ");
        for (int llllllllllllllIIIlIIlIIllIlllIll = 0; llllllllllllllIIIlIIlIIllIlllIll < llllllllllllllIIIlIIlIIllIllllII.length; ++llllllllllllllIIIlIIlIIllIlllIll) {
            String llllllllllllllIIIlIIlIIllIlllIlI = llllllllllllllIIIlIIlIIllIllllII[llllllllllllllIIIlIIlIIllIlllIll];
            if (llllllllllllllIIIlIIlIIllIlllIlI.endsWith(".png")) {
                llllllllllllllIIIlIIlIIllIlllIlI = llllllllllllllIIIlIIlIIllIlllIlI.substring(0, llllllllllllllIIIlIIlIIllIlllIlI.length() - 4);
            }
            llllllllllllllIIIlIIlIIllIlllIlI = TextureUtils.fixResourcePath(llllllllllllllIIIlIIlIIllIlllIlI, this.basePath);
            llllllllllllllIIIlIIlIIllIllllII[llllllllllllllIIIlIIlIIllIlllIll] = llllllllllllllIIIlIIlIIllIlllIlI;
        }
        return llllllllllllllIIIlIIlIIllIllllII;
    }
    
    private static int parseFace(String llllllllllllllIIIlIIlIIlIllIlIIl) {
        llllllllllllllIIIlIIlIIlIllIlIIl = llllllllllllllIIIlIIlIIlIllIlIIl.toLowerCase();
        if (llllllllllllllIIIlIIlIIlIllIlIIl.equals("bottom") || llllllllllllllIIIlIIlIIlIllIlIIl.equals("down")) {
            return 1;
        }
        if (llllllllllllllIIIlIIlIIlIllIlIIl.equals("top") || llllllllllllllIIIlIIlIIlIllIlIIl.equals("up")) {
            return 2;
        }
        if (llllllllllllllIIIlIIlIIlIllIlIIl.equals("north")) {
            return 4;
        }
        if (llllllllllllllIIIlIIlIIlIllIlIIl.equals("south")) {
            return 8;
        }
        if (llllllllllllllIIIlIIlIIlIllIlIIl.equals("east")) {
            return 32;
        }
        if (llllllllllllllIIIlIIlIIlIllIlIIl.equals("west")) {
            return 16;
        }
        if (llllllllllllllIIIlIIlIIlIllIlIIl.equals("sides")) {
            return 60;
        }
        if (llllllllllllllIIIlIIlIIlIllIlIIl.equals("all")) {
            return 63;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown face: ").append(llllllllllllllIIIlIIlIIlIllIlIIl)));
        return 128;
    }
    
    private boolean isValidHorizontalVertical(final String llllllllllllllIIIlIIlIIlIIIIIIII) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("No tiles defined for horizontal+vertical: ").append(llllllllllllllIIIlIIlIIlIIIIIIII)));
            return false;
        }
        if (this.tiles.length != 7) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 7: ").append(llllllllllllllIIIlIIlIIlIIIIIIII)));
            return false;
        }
        return true;
    }
    
    public void updateIcons(final TextureMap llllllllllllllIIIlIIlIIIllIlIIlI) {
        if (this.matchTiles != null) {
            this.matchTileIcons = registerIcons(this.matchTiles, llllllllllllllIIIlIIlIIIllIlIIlI);
        }
        if (this.connectTiles != null) {
            this.connectTileIcons = registerIcons(this.connectTiles, llllllllllllllIIIlIIlIIIllIlIIlI);
        }
        if (this.tiles != null) {
            this.tileIcons = registerIcons(this.tiles, llllllllllllllIIIlIIlIIIllIlIIlI);
        }
    }
    
    private boolean isValidRepeat(final String llllllllllllllIIIlIIlIIIlllIIlII) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("Tiles not defined: ").append(llllllllllllllIIIlIIlIIIlllIIlII)));
            return false;
        }
        if (this.width <= 0 || this.width > 16) {
            Config.warn(String.valueOf(new StringBuilder("Invalid width: ").append(llllllllllllllIIIlIIlIIIlllIIlII)));
            return false;
        }
        if (this.height <= 0 || this.height > 16) {
            Config.warn(String.valueOf(new StringBuilder("Invalid height: ").append(llllllllllllllIIIlIIlIIIlllIIlII)));
            return false;
        }
        if (this.tiles.length != this.width * this.height) {
            Config.warn(String.valueOf(new StringBuilder("Number of tiles does not equal width x height: ").append(llllllllllllllIIIlIIlIIIlllIIlII)));
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("CTM name: ").append(this.name).append(", basePath: ").append(this.basePath).append(", matchBlocks: ").append(Config.arrayToString(this.matchBlocks)).append(", matchTiles: ").append(Config.arrayToString(this.matchTiles)));
    }
    
    private boolean isValidVerticalHorizontal(final String llllllllllllllIIIlIIlIIIllllllII) {
        if (this.tiles == null) {
            Config.warn(String.valueOf(new StringBuilder("No tiles defined for vertical+horizontal: ").append(llllllllllllllIIIlIIlIIIllllllII)));
            return false;
        }
        if (this.tiles.length != 7) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be exactly 7: ").append(llllllllllllllIIIlIIlIIIllllllII)));
            return false;
        }
        return true;
    }
    
    private int[] detectMatchBlockIds() {
        if (!this.name.startsWith("block")) {
            return null;
        }
        int llllllllllllllIIIlIIlIIlIIlllIll;
        int llllllllllllllIIIlIIlIIlIIllllII;
        for (llllllllllllllIIIlIIlIIlIIllllII = (llllllllllllllIIIlIIlIIlIIlllIll = "block".length()); llllllllllllllIIIlIIlIIlIIlllIll < this.name.length(); ++llllllllllllllIIIlIIlIIlIIlllIll) {
            final char llllllllllllllIIIlIIlIIlIIlllIlI = this.name.charAt(llllllllllllllIIIlIIlIIlIIlllIll);
            if (llllllllllllllIIIlIIlIIlIIlllIlI < '0') {
                break;
            }
            if (llllllllllllllIIIlIIlIIlIIlllIlI > '9') {
                break;
            }
        }
        if (llllllllllllllIIIlIIlIIlIIlllIll == llllllllllllllIIIlIIlIIlIIllllII) {
            return null;
        }
        final String llllllllllllllIIIlIIlIIlIIlllIIl = this.name.substring(llllllllllllllIIIlIIlIIlIIllllII, llllllllllllllIIIlIIlIIlIIlllIll);
        final int llllllllllllllIIIlIIlIIlIIlllIII = Config.parseInt(llllllllllllllIIIlIIlIIlIIlllIIl, -1);
        return (int[])((llllllllllllllIIIlIIlIIlIIlllIII < 0) ? null : new int[] { llllllllllllllIIIlIIlIIlIIlllIII });
    }
    
    private static int parseFaces(final String llllllllllllllIIIlIIlIIlIlllIIIl) {
        if (llllllllllllllIIIlIIlIIlIlllIIIl == null) {
            return 63;
        }
        final String[] llllllllllllllIIIlIIlIIlIlllIllI = Config.tokenize(llllllllllllllIIIlIIlIIlIlllIIIl, " ,");
        int llllllllllllllIIIlIIlIIlIlllIlIl = 0;
        for (int llllllllllllllIIIlIIlIIlIlllIlII = 0; llllllllllllllIIIlIIlIIlIlllIlII < llllllllllllllIIIlIIlIIlIlllIllI.length; ++llllllllllllllIIIlIIlIIlIlllIlII) {
            final String llllllllllllllIIIlIIlIIlIlllIIll = llllllllllllllIIIlIIlIIlIlllIllI[llllllllllllllIIIlIIlIIlIlllIlII];
            final int llllllllllllllIIIlIIlIIlIlllIIlI = parseFace(llllllllllllllIIIlIIlIIlIlllIIll);
            llllllllllllllIIIlIIlIIlIlllIlIl |= llllllllllllllIIIlIIlIIlIlllIIlI;
        }
        return llllllllllllllIIIlIIlIIlIlllIlIl;
    }
    
    public boolean matchesIcon(final TextureAtlasSprite llllllllllllllIIIlIIlIIIlIIIllIl) {
        return Matches.sprite(llllllllllllllIIIlIIlIIIlIIIllIl, this.matchTileIcons);
    }
    
    private boolean isValidCtm(final String llllllllllllllIIIlIIlIIlIIlIIIII) {
        if (this.tiles == null) {
            this.tiles = this.parseTileNames("0-11 16-27 32-43 48-58");
        }
        if (this.tiles.length < 47) {
            Config.warn(String.valueOf(new StringBuilder("Invalid tiles, must be at least 47: ").append(llllllllllllllIIIlIIlIIlIIlIIIII)));
            return false;
        }
        return true;
    }
    
    public boolean matchesBiome(final Biome llllllllllllllIIIlIIlIIIlIIIIllI) {
        return Matches.biome(llllllllllllllIIIlIIlIIIlIIIIllI, this.biomes);
    }
    
    private int[] parseCtmTileIndexes(final Properties llllllllllllllIIIlIIlIIlllIIllIl) {
        if (this.tiles == null) {
            return null;
        }
        final Map<Integer, Integer> llllllllllllllIIIlIIlIIlllIllIII = new HashMap<Integer, Integer>();
        for (final Object llllllllllllllIIIlIIlIIlllIlIlll : ((Hashtable<Object, V>)llllllllllllllIIIlIIlIIlllIIllIl).keySet()) {
            if (llllllllllllllIIIlIIlIIlllIlIlll instanceof String) {
                final String llllllllllllllIIIlIIlIIlllIlIllI = (String)llllllllllllllIIIlIIlIIlllIlIlll;
                final String llllllllllllllIIIlIIlIIlllIlIlIl = "ctm.";
                if (!llllllllllllllIIIlIIlIIlllIlIllI.startsWith(llllllllllllllIIIlIIlIIlllIlIlIl)) {
                    continue;
                }
                final String llllllllllllllIIIlIIlIIlllIlIlII = llllllllllllllIIIlIIlIIlllIlIllI.substring(llllllllllllllIIIlIIlIIlllIlIlIl.length());
                final String llllllllllllllIIIlIIlIIlllIlIIll = llllllllllllllIIIlIIlIIlllIIllIl.getProperty(llllllllllllllIIIlIIlIIlllIlIllI);
                if (llllllllllllllIIIlIIlIIlllIlIIll == null) {
                    continue;
                }
                final int llllllllllllllIIIlIIlIIlllIlIIlI = Config.parseInt(llllllllllllllIIIlIIlIIlllIlIlII, -1);
                if (llllllllllllllIIIlIIlIIlllIlIIlI >= 0 && llllllllllllllIIIlIIlIIlllIlIIlI <= 46) {
                    final int llllllllllllllIIIlIIlIIlllIlIIIl = Config.parseInt(llllllllllllllIIIlIIlIIlllIlIIll, -1);
                    if (llllllllllllllIIIlIIlIIlllIlIIIl >= 0 && llllllllllllllIIIlIIlIIlllIlIIIl < this.tiles.length) {
                        llllllllllllllIIIlIIlIIlllIllIII.put(llllllllllllllIIIlIIlIIlllIlIIlI, llllllllllllllIIIlIIlIIlllIlIIIl);
                    }
                    else {
                        Config.warn(String.valueOf(new StringBuilder("Invalid CTM tile index: ").append(llllllllllllllIIIlIIlIIlllIlIIll)));
                    }
                }
                else {
                    Config.warn(String.valueOf(new StringBuilder("Invalid CTM index: ").append(llllllllllllllIIIlIIlIIlllIlIlII)));
                }
            }
        }
        if (llllllllllllllIIIlIIlIIlllIllIII.isEmpty()) {
            return null;
        }
        final int[] llllllllllllllIIIlIIlIIlllIlIIII = new int[47];
        for (int llllllllllllllIIIlIIlIIlllIIllll = 0; llllllllllllllIIIlIIlIIlllIIllll < llllllllllllllIIIlIIlIIlllIlIIII.length; ++llllllllllllllIIIlIIlIIlllIIllll) {
            llllllllllllllIIIlIIlIIlllIlIIII[llllllllllllllIIIlIIlIIlllIIllll] = -1;
            if (llllllllllllllIIIlIIlIIlllIllIII.containsKey(llllllllllllllIIIlIIlIIlllIIllll)) {
                llllllllllllllIIIlIIlIIlllIlIIII[llllllllllllllIIIlIIlIIlllIIllll] = llllllllllllllIIIlIIlIIlllIllIII.get(llllllllllllllIIIlIIlIIlllIIllll);
            }
        }
        return llllllllllllllIIIlIIlIIlllIlIIII;
    }
    
    private static int parseConnect(final String llllllllllllllIIIlIIlIIlIllIIllI) {
        if (llllllllllllllIIIlIIlIIlIllIIllI == null) {
            return 0;
        }
        if (llllllllllllllIIIlIIlIIlIllIIllI.equals("block")) {
            return 1;
        }
        if (llllllllllllllIIIlIIlIIlIllIIllI.equals("tile")) {
            return 2;
        }
        if (llllllllllllllIIIlIIlIIlIllIIllI.equals("material")) {
            return 3;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown connect: ").append(llllllllllllllIIIlIIlIIlIllIIllI)));
        return 128;
    }
    
    public boolean isValid(final String llllllllllllllIIIlIIlIIlIlIlIIlI) {
        if (this.name == null || this.name.length() <= 0) {
            Config.warn(String.valueOf(new StringBuilder("No name found: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
            return false;
        }
        if (this.basePath == null) {
            Config.warn(String.valueOf(new StringBuilder("No base path found: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
            return false;
        }
        if (this.matchBlocks == null) {
            this.matchBlocks = this.detectMatchBlocks();
        }
        if (this.matchTiles == null && this.matchBlocks == null) {
            this.matchTiles = this.detectMatchTiles();
        }
        if (this.matchBlocks == null && this.matchTiles == null) {
            Config.warn(String.valueOf(new StringBuilder("No matchBlocks or matchTiles specified: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
            return false;
        }
        if (this.method == 0) {
            Config.warn(String.valueOf(new StringBuilder("No method: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
            return false;
        }
        if (this.tiles == null || this.tiles.length <= 0) {
            Config.warn(String.valueOf(new StringBuilder("No tiles specified: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
            return false;
        }
        if (this.connect == 0) {
            this.connect = this.detectConnect();
        }
        if (this.connect == 128) {
            Config.warn(String.valueOf(new StringBuilder("Invalid connect in: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
            return false;
        }
        if (this.renderPass > 0) {
            Config.warn(String.valueOf(new StringBuilder("Render pass not supported: ").append(this.renderPass)));
            return false;
        }
        if ((this.faces & 0x80) != 0x0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid faces in: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
            return false;
        }
        if ((this.symmetry & 0x80) != 0x0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid symmetry in: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
            return false;
        }
        switch (this.method) {
            case 1: {
                return this.isValidCtm(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 2: {
                return this.isValidHorizontal(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 3: {
                return this.isValidTop(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 4: {
                return this.isValidRandom(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 5: {
                return this.isValidRepeat(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 6: {
                return this.isValidVertical(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 7: {
                return this.isValidFixed(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 8: {
                return this.isValidHorizontalVertical(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 9: {
                return this.isValidVerticalHorizontal(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 10: {
                return this.isValidCtmCompact(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            case 11: {
                return this.isValidOverlay(llllllllllllllIIIlIIlIIlIlIlIIlI);
            }
            default: {
                Config.warn(String.valueOf(new StringBuilder("Unknown method: ").append(llllllllllllllIIIlIIlIIlIlIlIIlI)));
                return false;
            }
        }
    }
    
    private static int parseSymmetry(final String llllllllllllllIIIlIIlIIlIllllllI) {
        if (llllllllllllllIIIlIIlIIlIllllllI == null) {
            return 1;
        }
        if (llllllllllllllIIIlIIlIIlIllllllI.equals("opposite")) {
            return 2;
        }
        if (llllllllllllllIIIlIIlIIlIllllllI.equals("all")) {
            return 6;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown symmetry: ").append(llllllllllllllIIIlIIlIIlIllllllI)));
        return 1;
    }
    
    private String[] parseTileNames(final String llllllllllllllIIIlIIlIIllIIIlIIl) {
        if (llllllllllllllIIIlIIlIIllIIIlIIl == null) {
            return null;
        }
        final List llllllllllllllIIIlIIlIIllIIlIllI = new ArrayList();
        final String[] llllllllllllllIIIlIIlIIllIIlIlIl = Config.tokenize(llllllllllllllIIIlIIlIIllIIIlIIl, " ,");
        for (int llllllllllllllIIIlIIlIIllIIlIlII = 0; llllllllllllllIIIlIIlIIllIIlIlII < llllllllllllllIIIlIIlIIllIIlIlIl.length; ++llllllllllllllIIIlIIlIIllIIlIlII) {
            final String llllllllllllllIIIlIIlIIllIIlIIll = llllllllllllllIIIlIIlIIllIIlIlIl[llllllllllllllIIIlIIlIIllIIlIlII];
            if (llllllllllllllIIIlIIlIIllIIlIIll.contains("-")) {
                final String[] llllllllllllllIIIlIIlIIllIIlIIlI = Config.tokenize(llllllllllllllIIIlIIlIIllIIlIIll, "-");
                if (llllllllllllllIIIlIIlIIllIIlIIlI.length == 2) {
                    final int llllllllllllllIIIlIIlIIllIIlIIIl = Config.parseInt(llllllllllllllIIIlIIlIIllIIlIIlI[0], -1);
                    final int llllllllllllllIIIlIIlIIllIIlIIII = Config.parseInt(llllllllllllllIIIlIIlIIllIIlIIlI[1], -1);
                    if (llllllllllllllIIIlIIlIIllIIlIIIl >= 0 && llllllllllllllIIIlIIlIIllIIlIIII >= 0) {
                        if (llllllllllllllIIIlIIlIIllIIlIIIl > llllllllllllllIIIlIIlIIllIIlIIII) {
                            Config.warn(String.valueOf(new StringBuilder("Invalid interval: ").append(llllllllllllllIIIlIIlIIllIIlIIll).append(", when parsing: ").append(llllllllllllllIIIlIIlIIllIIIlIIl)));
                            continue;
                        }
                        for (int llllllllllllllIIIlIIlIIllIIIllll = llllllllllllllIIIlIIlIIllIIlIIIl; llllllllllllllIIIlIIlIIllIIIllll <= llllllllllllllIIIlIIlIIllIIlIIII; ++llllllllllllllIIIlIIlIIllIIIllll) {
                            llllllllllllllIIIlIIlIIllIIlIllI.add(String.valueOf(llllllllllllllIIIlIIlIIllIIIllll));
                        }
                        continue;
                    }
                }
            }
            llllllllllllllIIIlIIlIIllIIlIllI.add(llllllllllllllIIIlIIlIIllIIlIIll);
        }
        final String[] llllllllllllllIIIlIIlIIllIIIlllI = llllllllllllllIIIlIIlIIllIIlIllI.toArray(new String[llllllllllllllIIIlIIlIIllIIlIllI.size()]);
        for (int llllllllllllllIIIlIIlIIllIIIllIl = 0; llllllllllllllIIIlIIlIIllIIIllIl < llllllllllllllIIIlIIlIIllIIIlllI.length; ++llllllllllllllIIIlIIlIIllIIIllIl) {
            String llllllllllllllIIIlIIlIIllIIIllII = llllllllllllllIIIlIIlIIllIIIlllI[llllllllllllllIIIlIIlIIllIIIllIl];
            llllllllllllllIIIlIIlIIllIIIllII = TextureUtils.fixResourcePath(llllllllllllllIIIlIIlIIllIIIllII, this.basePath);
            if (!llllllllllllllIIIlIIlIIllIIIllII.startsWith(this.basePath) && !llllllllllllllIIIlIIlIIllIIIllII.startsWith("textures/") && !llllllllllllllIIIlIIlIIllIIIllII.startsWith("mcpatcher/")) {
                llllllllllllllIIIlIIlIIllIIIllII = String.valueOf(new StringBuilder(String.valueOf(this.basePath)).append("/").append(llllllllllllllIIIlIIlIIllIIIllII));
            }
            if (llllllllllllllIIIlIIlIIllIIIllII.endsWith(".png")) {
                llllllllllllllIIIlIIlIIllIIIllII = llllllllllllllIIIlIIlIIllIIIllII.substring(0, llllllllllllllIIIlIIlIIllIIIllII.length() - 4);
            }
            final String llllllllllllllIIIlIIlIIllIIIlIll = "textures/blocks/";
            if (llllllllllllllIIIlIIlIIllIIIllII.startsWith(llllllllllllllIIIlIIlIIllIIIlIll)) {
                llllllllllllllIIIlIIlIIllIIIllII = llllllllllllllIIIlIIlIIllIIIllII.substring(llllllllllllllIIIlIIlIIllIIIlIll.length());
            }
            if (llllllllllllllIIIlIIlIIllIIIllII.startsWith("/")) {
                llllllllllllllIIIlIIlIIllIIIllII = llllllllllllllIIIlIIlIIllIIIllII.substring(1);
            }
            llllllllllllllIIIlIIlIIllIIIlllI[llllllllllllllIIIlIIlIIllIIIllIl] = llllllllllllllIIIlIIlIIllIIIllII;
        }
        return llllllllllllllIIIlIIlIIllIIIlllI;
    }
    
    private static String parseBasePath(final String llllllllllllllIIIlIIlIIllIlIIllI) {
        final int llllllllllllllIIIlIIlIIllIlIIlIl = llllllllllllllIIIlIIlIIllIlIIllI.lastIndexOf(47);
        return (llllllllllllllIIIlIIlIIllIlIIlIl < 0) ? "" : llllllllllllllIIIlIIlIIllIlIIllI.substring(0, llllllllllllllIIIlIIlIIllIlIIlIl);
    }
    
    static {
        FACE_SIDES = 60;
        CONNECT_NONE = 0;
        METHOD_VERTICAL_HORIZONTAL = 9;
        SYMMETRY_OPPOSITE = 2;
        CONNECT_TILE = 2;
        METHOD_RANDOM = 4;
        METHOD_VERTICAL = 6;
        FACE_UNKNOWN = 128;
        FACE_TOP = 2;
        METHOD_TOP = 3;
        METHOD_HORIZONTAL = 2;
        METHOD_NONE = 0;
        FACE_SOUTH = 8;
        FACE_EAST = 32;
        FACE_BOTTOM = 1;
        METHOD_FIXED = 7;
        FACE_WEST = 16;
        METHOD_REPEAT = 5;
        SYMMETRY_NONE = 1;
        FACE_ALL = 63;
        SYMMETRY_UNKNOWN = 128;
        METHOD_OVERLAY = 11;
        CONNECT_BLOCK = 1;
        METHOD_CTM_COMPACT = 10;
        CONNECT_MATERIAL = 3;
        SYMMETRY_ALL = 6;
        METHOD_CTM = 1;
        CONNECT_UNKNOWN = 128;
        METHOD_HORIZONTAL_VERTICAL = 8;
        FACE_NORTH = 4;
    }
    
    private int getMax(final int[] llllllllllllllIIIlIIlIIIIlllIIlI, int llllllllllllllIIIlIIlIIIIllIllIl) {
        if (llllllllllllllIIIlIIlIIIIlllIIlI == null) {
            return llllllllllllllIIIlIIlIIIIllIllIl;
        }
        for (int llllllllllllllIIIlIIlIIIIlllIIII = 0; llllllllllllllIIIlIIlIIIIlllIIII < llllllllllllllIIIlIIlIIIIlllIIlI.length; ++llllllllllllllIIIlIIlIIIIlllIIII) {
            final int llllllllllllllIIIlIIlIIIIllIllll = llllllllllllllIIIlIIlIIIIlllIIlI[llllllllllllllIIIlIIlIIIIlllIIII];
            if (llllllllllllllIIIlIIlIIIIllIllll > llllllllllllllIIIlIIlIIIIllIllIl) {
                llllllllllllllIIIlIIlIIIIllIllIl = llllllllllllllIIIlIIlIIIIllIllll;
            }
        }
        return llllllllllllllIIIlIIlIIIIllIllIl;
    }
}
