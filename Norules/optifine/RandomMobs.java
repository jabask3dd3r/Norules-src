package optifine;

import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import java.util.*;
import java.io.*;

public class RandomMobs
{
    private static final /* synthetic */ String[] DEPENDANT_SUFFIXES;
    private static /* synthetic */ RenderGlobal renderGlobal;
    private static /* synthetic */ Map locationProperties;
    private static /* synthetic */ boolean working;
    private static /* synthetic */ boolean initialized;
    private static /* synthetic */ Random random;
    
    public static void entityLoaded(final Entity lllllllllllllllIlIlIIlIIIIlllIIl, final World lllllllllllllllIlIlIIlIIIIlllIII) {
        if (lllllllllllllllIlIlIIlIIIIlllIIl instanceof EntityLiving && lllllllllllllllIlIlIIlIIIIlllIII != null) {
            final EntityLiving lllllllllllllllIlIlIIlIIIIllllIl = (EntityLiving)lllllllllllllllIlIlIIlIIIIlllIIl;
            lllllllllllllllIlIlIIlIIIIllllIl.spawnPosition = lllllllllllllllIlIlIIlIIIIllllIl.getPosition();
            lllllllllllllllIlIlIIlIIIIllllIl.spawnBiome = lllllllllllllllIlIlIIlIIIIlllIII.getBiome(lllllllllllllllIlIlIIlIIIIllllIl.spawnPosition);
            final UUID lllllllllllllllIlIlIIlIIIIllllII = lllllllllllllllIlIlIIlIIIIllllIl.getUniqueID();
            final long lllllllllllllllIlIlIIlIIIIlllIll = lllllllllllllllIlIlIIlIIIIllllII.getLeastSignificantBits();
            final int lllllllllllllllIlIlIIlIIIIlllIlI = (int)(lllllllllllllllIlIlIIlIIIIlllIll & 0x7FFFFFFFL);
            lllllllllllllllIlIlIIlIIIIllllIl.randomMobsId = lllllllllllllllIlIlIIlIIIIlllIlI;
        }
    }
    
    public static void resetTextures() {
        RandomMobs.locationProperties.clear();
        if (Config.isRandomMobs()) {
            initialize();
        }
    }
    
    private static void initialize() {
        RandomMobs.renderGlobal = Config.getRenderGlobal();
        if (RandomMobs.renderGlobal != null) {
            RandomMobs.initialized = true;
            final List lllllllllllllllIlIlIIIlIllllIIIl = new ArrayList();
            lllllllllllllllIlIlIIIlIllllIIIl.add("bat");
            lllllllllllllllIlIlIIIlIllllIIIl.add("blaze");
            lllllllllllllllIlIlIIIlIllllIIIl.add("cat/black");
            lllllllllllllllIlIlIIIlIllllIIIl.add("cat/ocelot");
            lllllllllllllllIlIlIIIlIllllIIIl.add("cat/red");
            lllllllllllllllIlIlIIIlIllllIIIl.add("cat/siamese");
            lllllllllllllllIlIlIIIlIllllIIIl.add("chicken");
            lllllllllllllllIlIlIIIlIllllIIIl.add("cow/cow");
            lllllllllllllllIlIlIIIlIllllIIIl.add("cow/mooshroom");
            lllllllllllllllIlIlIIIlIllllIIIl.add("creeper/creeper");
            lllllllllllllllIlIlIIIlIllllIIIl.add("enderman/enderman");
            lllllllllllllllIlIlIIIlIllllIIIl.add("enderman/enderman_eyes");
            lllllllllllllllIlIlIIIlIllllIIIl.add("ghast/ghast");
            lllllllllllllllIlIlIIIlIllllIIIl.add("ghast/ghast_shooting");
            lllllllllllllllIlIlIIIlIllllIIIl.add("iron_golem");
            lllllllllllllllIlIlIIIlIllllIIIl.add("pig/pig");
            lllllllllllllllIlIlIIIlIllllIIIl.add("sheep/sheep");
            lllllllllllllllIlIlIIIlIllllIIIl.add("sheep/sheep_fur");
            lllllllllllllllIlIlIIIlIllllIIIl.add("silverfish");
            lllllllllllllllIlIlIIIlIllllIIIl.add("skeleton/skeleton");
            lllllllllllllllIlIlIIIlIllllIIIl.add("skeleton/wither_skeleton");
            lllllllllllllllIlIlIIIlIllllIIIl.add("slime/slime");
            lllllllllllllllIlIlIIIlIllllIIIl.add("slime/magmacube");
            lllllllllllllllIlIlIIIlIllllIIIl.add("snowman");
            lllllllllllllllIlIlIIIlIllllIIIl.add("spider/cave_spider");
            lllllllllllllllIlIlIIIlIllllIIIl.add("spider/spider");
            lllllllllllllllIlIlIIIlIllllIIIl.add("spider_eyes");
            lllllllllllllllIlIlIIIlIllllIIIl.add("squid");
            lllllllllllllllIlIlIIIlIllllIIIl.add("villager/villager");
            lllllllllllllllIlIlIIIlIllllIIIl.add("villager/butcher");
            lllllllllllllllIlIlIIIlIllllIIIl.add("villager/farmer");
            lllllllllllllllIlIlIIIlIllllIIIl.add("villager/librarian");
            lllllllllllllllIlIlIIIlIllllIIIl.add("villager/priest");
            lllllllllllllllIlIlIIIlIllllIIIl.add("villager/smith");
            lllllllllllllllIlIlIIIlIllllIIIl.add("wither/wither");
            lllllllllllllllIlIlIIIlIllllIIIl.add("wither/wither_armor");
            lllllllllllllllIlIlIIIlIllllIIIl.add("wither/wither_invulnerable");
            lllllllllllllllIlIlIIIlIllllIIIl.add("wolf/wolf");
            lllllllllllllllIlIlIIIlIllllIIIl.add("wolf/wolf_angry");
            lllllllllllllllIlIlIIIlIllllIIIl.add("wolf/wolf_collar");
            lllllllllllllllIlIlIIIlIllllIIIl.add("wolf/wolf_tame");
            lllllllllllllllIlIlIIIlIllllIIIl.add("zombie_pigman");
            lllllllllllllllIlIlIIIlIllllIIIl.add("zombie/zombie");
            lllllllllllllllIlIlIIIlIllllIIIl.add("zombie/zombie_villager");
            for (int lllllllllllllllIlIlIIIlIllllIIII = 0; lllllllllllllllIlIlIIIlIllllIIII < lllllllllllllllIlIlIIIlIllllIIIl.size(); ++lllllllllllllllIlIlIIIlIllllIIII) {
                final String lllllllllllllllIlIlIIIlIlllIllll = lllllllllllllllIlIlIIIlIllllIIIl.get(lllllllllllllllIlIlIIIlIllllIIII);
                final String lllllllllllllllIlIlIIIlIlllIlllI = String.valueOf(new StringBuilder("textures/entity/").append(lllllllllllllllIlIlIIIlIlllIllll).append(".png"));
                final ResourceLocation lllllllllllllllIlIlIIIlIlllIllIl = new ResourceLocation(lllllllllllllllIlIlIIIlIlllIlllI);
                if (!Config.hasResource(lllllllllllllllIlIlIIIlIlllIllIl)) {
                    Config.warn(String.valueOf(new StringBuilder("Not found: ").append(lllllllllllllllIlIlIIIlIlllIllIl)));
                }
                getProperties(lllllllllllllllIlIlIIIlIlllIllIl);
            }
        }
    }
    
    private static String getParentPath(final String lllllllllllllllIlIlIIIllIIIlIlIl) {
        for (int lllllllllllllllIlIlIIIllIIIllIlI = 0; lllllllllllllllIlIlIIIllIIIllIlI < RandomMobs.DEPENDANT_SUFFIXES.length; ++lllllllllllllllIlIlIIIllIIIllIlI) {
            final String lllllllllllllllIlIlIIIllIIIllIIl = RandomMobs.DEPENDANT_SUFFIXES[lllllllllllllllIlIlIIIllIIIllIlI];
            if (lllllllllllllllIlIlIIIllIIIlIlIl.endsWith(lllllllllllllllIlIlIIIllIIIllIIl)) {
                final String lllllllllllllllIlIlIIIllIIIlIlll = lllllllllllllllIlIlIIIllIIIlIlIl.substring(0, lllllllllllllllIlIlIIIllIIIlIlIl.length() - lllllllllllllllIlIlIIIllIIIllIIl.length());
                return lllllllllllllllIlIlIIIllIIIlIlll;
            }
        }
        return null;
    }
    
    public static ResourceLocation getLocationIndexed(final ResourceLocation lllllllllllllllIlIlIIIllIIllIIIl, final int lllllllllllllllIlIlIIIllIIlllIll) {
        if (lllllllllllllllIlIlIIIllIIllIIIl == null) {
            return null;
        }
        final String lllllllllllllllIlIlIIIllIIlllIlI = lllllllllllllllIlIlIIIllIIllIIIl.getResourcePath();
        final int lllllllllllllllIlIlIIIllIIlllIIl = lllllllllllllllIlIlIIIllIIlllIlI.lastIndexOf(46);
        if (lllllllllllllllIlIlIIIllIIlllIIl < 0) {
            return null;
        }
        final String lllllllllllllllIlIlIIIllIIlllIII = lllllllllllllllIlIlIIIllIIlllIlI.substring(0, lllllllllllllllIlIlIIIllIIlllIIl);
        final String lllllllllllllllIlIlIIIllIIllIllI = lllllllllllllllIlIlIIIllIIlllIlI.substring(lllllllllllllllIlIlIIIllIIlllIIl);
        final String lllllllllllllllIlIlIIIllIIllIlII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIlIIIllIIlllIII)).append(lllllllllllllllIlIlIIIllIIlllIll).append(lllllllllllllllIlIlIIIllIIllIllI));
        final ResourceLocation lllllllllllllllIlIlIIIllIIllIIll = new ResourceLocation(lllllllllllllllIlIlIIIllIIllIIIl.getResourceDomain(), lllllllllllllllIlIlIIIllIIllIlII);
        return lllllllllllllllIlIlIIIllIIllIIll;
    }
    
    static {
        PREFIX_MCPATCHER_MOB = "mcpatcher/mob/";
        PREFIX_TEXTURES_ENTITY = "textures/entity/";
        SUFFIX_PROPERTIES = ".properties";
        SUFFIX_PNG = ".png";
        RandomMobs.locationProperties = new HashMap();
        RandomMobs.renderGlobal = null;
        RandomMobs.initialized = false;
        RandomMobs.random = new Random();
        RandomMobs.working = false;
        DEPENDANT_SUFFIXES = new String[] { "_armor", "_eyes", "_exploding", "_shooting", "_fur", "_eyes", "_invulnerable", "_angry", "_tame", "_collar" };
    }
    
    public static ResourceLocation getTextureLocation(final ResourceLocation lllllllllllllllIlIlIIlIIIIIllIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ifeq            8
        //     6: aload_0         /* lllllllllllllllIlIlIIlIIIIIIIllI */
        //     7: areturn        
        //     8: iconst_1       
        //     9: putstatic       optifine/RandomMobs.working:Z
        //    12: getstatic       optifine/RandomMobs.initialized:Z
        //    15: ifne            21
        //    18: invokestatic    optifine/RandomMobs.initialize:()V
        //    21: getstatic       optifine/RandomMobs.renderGlobal:Lnet/minecraft/client/renderer/RenderGlobal;
        //    24: ifnull          133
        //    27: getstatic       optifine/RandomMobs.renderGlobal:Lnet/minecraft/client/renderer/RenderGlobal;
        //    30: getfield        net/minecraft/client/renderer/RenderGlobal.renderedEntity:Lnet/minecraft/entity/Entity;
        //    33: astore_2        /* lllllllllllllllIlIlIIlIIIIIlIlII */
        //    34: aload_2         /* lllllllllllllllIlIlIIlIIIIIlIlII */
        //    35: instanceof      Lnet/minecraft/entity/EntityLiving;
        //    38: ifne            53
        //    41: aload_0         /* lllllllllllllllIlIlIIlIIIIIIIllI */
        //    42: astore_3        /* lllllllllllllllIlIlIIlIIIIIIIIIl */
        //    43: aload_3         /* lllllllllllllllIlIlIIlIIIIIlIIlI */
        //    44: astore          lllllllllllllllIlIlIIIllllllIlll
        //    46: iconst_0       
        //    47: putstatic       optifine/RandomMobs.working:Z
        //    50: aload           lllllllllllllllIlIlIIIllllllIlll
        //    52: areturn        
        //    53: aload_2         /* lllllllllllllllIlIlIIlIIIIIlIlII */
        //    54: checkcast       Lnet/minecraft/entity/EntityLiving;
        //    57: astore_3        /* lllllllllllllllIlIlIIlIIIIIIIIIl */
        //    58: aload_0         /* lllllllllllllllIlIlIIlIIIIIIIllI */
        //    59: invokevirtual   net/minecraft/util/ResourceLocation.getResourcePath:()Ljava/lang/String;
        //    62: astore          lllllllllllllllIlIlIIlIIIIIIlllI
        //    64: aload           lllllllllllllllIlIlIIlIIIIIIlllI
        //    66: ldc             "textures/entity/"
        //    68: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    71: ifne            88
        //    74: aload_0         /* lllllllllllllllIlIlIIlIIIIIIIllI */
        //    75: astore          lllllllllllllllIlIlIIlIIIIIIllII
        //    77: aload           lllllllllllllllIlIlIIlIIIIIIllII
        //    79: astore          lllllllllllllllIlIlIIIllllllIlll
        //    81: iconst_0       
        //    82: putstatic       optifine/RandomMobs.working:Z
        //    85: aload           lllllllllllllllIlIlIIIllllllIlll
        //    87: areturn        
        //    88: aload_0         /* lllllllllllllllIlIlIIlIIIIIIIllI */
        //    89: invokestatic    optifine/RandomMobs.getProperties:(Lnet/minecraft/util/ResourceLocation;)Loptifine/RandomMobsProperties;
        //    92: astore          lllllllllllllllIlIlIIlIIIIIIlIlI
        //    94: aload           lllllllllllllllIlIlIIlIIIIIIlIlI
        //    96: ifnonnull       113
        //    99: aload_0         /* lllllllllllllllIlIlIIlIIIIIIIllI */
        //   100: astore          lllllllllllllllIlIlIIlIIIIIIlIII
        //   102: aload           lllllllllllllllIlIlIIlIIIIIIlIII
        //   104: astore          lllllllllllllllIlIlIIIllllllIlll
        //   106: iconst_0       
        //   107: putstatic       optifine/RandomMobs.working:Z
        //   110: aload           lllllllllllllllIlIlIIIllllllIlll
        //   112: areturn        
        //   113: aload           lllllllllllllllIlIlIIlIIIIIIlIlI
        //   115: aload_0         /* lllllllllllllllIlIlIIlIIIIIIIllI */
        //   116: aload_3         /* lllllllllllllllIlIlIIlIIIIIlIIII */
        //   117: invokevirtual   optifine/RandomMobsProperties.getTextureLocation:(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/entity/EntityLiving;)Lnet/minecraft/util/ResourceLocation;
        //   120: astore          lllllllllllllllIlIlIIlIIIIIIIlll
        //   122: aload           lllllllllllllllIlIlIIlIIIIIIIlll
        //   124: astore          lllllllllllllllIlIlIIIllllllIlll
        //   126: iconst_0       
        //   127: putstatic       optifine/RandomMobs.working:Z
        //   130: aload           lllllllllllllllIlIlIIIllllllIlll
        //   132: areturn        
        //   133: aload_0         /* lllllllllllllllIlIlIIlIIIIIIIllI */
        //   134: astore_1        /* lllllllllllllllIlIlIIlIIIIIIIlIl */
        //   135: goto            147
        //   138: astore          lllllllllllllllIlIlIIIlllllllIIl
        //   140: iconst_0       
        //   141: putstatic       optifine/RandomMobs.working:Z
        //   144: aload           lllllllllllllllIlIlIIIlllllllIIl
        //   146: athrow         
        //   147: iconst_0       
        //   148: putstatic       optifine/RandomMobs.working:Z
        //   151: aload_1         /* lllllllllllllllIlIlIIlIIIIIlIllI */
        //   152: areturn        
        //    StackMapTable: 00 08 08 0C FD 00 1F 00 07 01 94 FD 00 22 07 00 18 07 00 CF FC 00 18 07 01 7A FF 00 13 00 01 07 00 E2 00 00 44 07 01 96 FC 00 08 07 00 E2
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  8      46     138    147    Any
        //  53     81     138    147    Any
        //  88     106    138    147    Any
        //  113    126    138    147    Any
        //  133    138    138    147    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static RandomMobsProperties parseProperties(final ResourceLocation lllllllllllllllIlIlIIIlllIlllIII, final ResourceLocation lllllllllllllllIlIlIIIlllIlIIllI) {
        try {
            final String lllllllllllllllIlIlIIIlllIllIlIl = lllllllllllllllIlIlIIIlllIlllIII.getResourcePath();
            Config.dbg(String.valueOf(new StringBuilder("RandomMobs: ").append(lllllllllllllllIlIlIIIlllIlIIllI.getResourcePath()).append(", variants: ").append(lllllllllllllllIlIlIIIlllIllIlIl)));
            final InputStream lllllllllllllllIlIlIIIlllIllIIll = Config.getResourceStream(lllllllllllllllIlIlIIIlllIlllIII);
            if (lllllllllllllllIlIlIIIlllIllIIll == null) {
                Config.warn(String.valueOf(new StringBuilder("RandomMobs properties not found: ").append(lllllllllllllllIlIlIIIlllIllIlIl)));
                return null;
            }
            final Properties lllllllllllllllIlIlIIIlllIllIIIl = new Properties();
            lllllllllllllllIlIlIIIlllIllIIIl.load(lllllllllllllllIlIlIIIlllIllIIll);
            lllllllllllllllIlIlIIIlllIllIIll.close();
            final RandomMobsProperties lllllllllllllllIlIlIIIlllIlIllll = new RandomMobsProperties(lllllllllllllllIlIlIIIlllIllIIIl, lllllllllllllllIlIlIIIlllIllIlIl, lllllllllllllllIlIlIIIlllIlIIllI);
            return lllllllllllllllIlIlIIIlllIlIllll.isValid(lllllllllllllllIlIlIIIlllIllIlIl) ? lllllllllllllllIlIlIIIlllIlIllll : null;
        }
        catch (FileNotFoundException lllllllllllllllIlIlIIIlllIlIllII) {
            Config.warn(String.valueOf(new StringBuilder("RandomMobs file not found: ").append(lllllllllllllllIlIlIIIlllIlIIllI.getResourcePath())));
            return null;
        }
        catch (IOException lllllllllllllllIlIlIIIlllIlIlIlI) {
            lllllllllllllllIlIlIIIlllIlIlIlI.printStackTrace();
            return null;
        }
    }
    
    private static ResourceLocation[] getTextureVariants(final ResourceLocation lllllllllllllllIlIlIIIllIIIIIIll) {
        final List lllllllllllllllIlIlIIIllIIIIIIlI = new ArrayList();
        lllllllllllllllIlIlIIIllIIIIIIlI.add(lllllllllllllllIlIlIIIllIIIIIIll);
        final ResourceLocation lllllllllllllllIlIlIIIllIIIIIIIl = getMcpatcherLocation(lllllllllllllllIlIlIIIllIIIIIIll);
        if (lllllllllllllllIlIlIIIllIIIIIIIl == null) {
            return null;
        }
        for (int lllllllllllllllIlIlIIIllIIIIIIII = 1; lllllllllllllllIlIlIIIllIIIIIIII < lllllllllllllllIlIlIIIllIIIIIIlI.size() + 10; ++lllllllllllllllIlIlIIIllIIIIIIII) {
            final int lllllllllllllllIlIlIIIlIllllllll = lllllllllllllllIlIlIIIllIIIIIIII + 1;
            final ResourceLocation lllllllllllllllIlIlIIIlIlllllllI = getLocationIndexed(lllllllllllllllIlIlIIIllIIIIIIIl, lllllllllllllllIlIlIIIlIllllllll);
            if (Config.hasResource(lllllllllllllllIlIlIIIlIlllllllI)) {
                lllllllllllllllIlIlIIIllIIIIIIlI.add(lllllllllllllllIlIlIIIlIlllllllI);
            }
        }
        if (lllllllllllllllIlIlIIIllIIIIIIlI.size() <= 1) {
            return null;
        }
        final ResourceLocation[] lllllllllllllllIlIlIIIlIllllllIl = lllllllllllllllIlIlIIIllIIIIIIlI.toArray(new ResourceLocation[lllllllllllllllIlIlIIIllIIIIIIlI.size()]);
        Config.dbg(String.valueOf(new StringBuilder("RandomMobs: ").append(lllllllllllllllIlIlIIIllIIIIIIll.getResourcePath()).append(", variants: ").append(lllllllllllllllIlIlIIIlIllllllIl.length)));
        return lllllllllllllllIlIlIIIlIllllllIl;
    }
    
    private static RandomMobsProperties makeProperties(final ResourceLocation lllllllllllllllIlIlIIIllllIlIIII) {
        final String lllllllllllllllIlIlIIIllllIlIlII = lllllllllllllllIlIlIIIllllIlIIII.getResourcePath();
        final ResourceLocation lllllllllllllllIlIlIIIllllIlIIll = getPropertyLocation(lllllllllllllllIlIlIIIllllIlIIII);
        if (lllllllllllllllIlIlIIIllllIlIIll != null) {
            final RandomMobsProperties lllllllllllllllIlIlIIIllllIlIIlI = parseProperties(lllllllllllllllIlIlIIIllllIlIIll, lllllllllllllllIlIlIIIllllIlIIII);
            if (lllllllllllllllIlIlIIIllllIlIIlI != null) {
                return lllllllllllllllIlIlIIIllllIlIIlI;
            }
        }
        final ResourceLocation[] lllllllllllllllIlIlIIIllllIlIIIl = getTextureVariants(lllllllllllllllIlIlIIIllllIlIIII);
        return new RandomMobsProperties(lllllllllllllllIlIlIIIllllIlIlII, lllllllllllllllIlIlIIIllllIlIIIl);
    }
    
    private static ResourceLocation getPropertyLocation(final ResourceLocation lllllllllllllllIlIlIIIlllIIIIlII) {
        final ResourceLocation lllllllllllllllIlIlIIIlllIIIIIll = getMcpatcherLocation(lllllllllllllllIlIlIIIlllIIIIlII);
        if (lllllllllllllllIlIlIIIlllIIIIIll == null) {
            return null;
        }
        final String lllllllllllllllIlIlIIIlllIIIIIlI = lllllllllllllllIlIlIIIlllIIIIIll.getResourceDomain();
        String lllllllllllllllIlIlIIIlllIIIIIII;
        final String lllllllllllllllIlIlIIIlllIIIIIIl = lllllllllllllllIlIlIIIlllIIIIIII = lllllllllllllllIlIlIIIlllIIIIIll.getResourcePath();
        if (lllllllllllllllIlIlIIIlllIIIIIIl.endsWith(".png")) {
            lllllllllllllllIlIlIIIlllIIIIIII = lllllllllllllllIlIlIIIlllIIIIIIl.substring(0, lllllllllllllllIlIlIIIlllIIIIIIl.length() - ".png".length());
        }
        final String lllllllllllllllIlIlIIIllIlllllll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIlIIIlllIIIIIII)).append(".properties"));
        final ResourceLocation lllllllllllllllIlIlIIIllIllllllI = new ResourceLocation(lllllllllllllllIlIlIIIlllIIIIIlI, lllllllllllllllIlIlIIIllIlllllll);
        if (Config.hasResource(lllllllllllllllIlIlIIIllIllllllI)) {
            return lllllllllllllllIlIlIIIllIllllllI;
        }
        final String lllllllllllllllIlIlIIIllIlllllIl = getParentPath(lllllllllllllllIlIlIIIlllIIIIIII);
        if (lllllllllllllllIlIlIIIllIlllllIl == null) {
            return null;
        }
        final ResourceLocation lllllllllllllllIlIlIIIllIlllllII = new ResourceLocation(lllllllllllllllIlIlIIIlllIIIIIlI, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIlIIIllIlllllIl)).append(".properties")));
        return Config.hasResource(lllllllllllllllIlIlIIIllIlllllII) ? lllllllllllllllIlIlIIIllIlllllII : null;
    }
    
    public static ResourceLocation getMcpatcherLocation(final ResourceLocation lllllllllllllllIlIlIIIllIlIllIII) {
        final String lllllllllllllllIlIlIIIllIllIlIlI = lllllllllllllllIlIlIIIllIlIllIII.getResourcePath();
        if (!lllllllllllllllIlIlIIIllIllIlIlI.startsWith("textures/entity/")) {
            return null;
        }
        final String lllllllllllllllIlIlIIIllIlIllIIl = String.valueOf(new StringBuilder("mcpatcher/mob/").append(lllllllllllllllIlIlIIIllIllIlIlI.substring("textures/entity/".length())));
        return new ResourceLocation(lllllllllllllllIlIlIIIllIlIllIII.getResourceDomain(), lllllllllllllllIlIlIIIllIlIllIIl);
    }
    
    public static void worldChanged(final World lllllllllllllllIlIlIIlIIIIlIllll, final World lllllllllllllllIlIlIIlIIIIlIlIlI) {
        if (lllllllllllllllIlIlIIlIIIIlIlIlI != null) {
            final List lllllllllllllllIlIlIIlIIIIlIllIl = lllllllllllllllIlIlIIlIIIIlIlIlI.getLoadedEntityList();
            for (int lllllllllllllllIlIlIIlIIIIlIllII = 0; lllllllllllllllIlIlIIlIIIIlIllII < lllllllllllllllIlIlIIlIIIIlIllIl.size(); ++lllllllllllllllIlIlIIlIIIIlIllII) {
                final Entity lllllllllllllllIlIlIIlIIIIlIlIll = lllllllllllllllIlIlIIlIIIIlIllIl.get(lllllllllllllllIlIlIIlIIIIlIllII);
                entityLoaded(lllllllllllllllIlIlIIlIIIIlIlIll, lllllllllllllllIlIlIIlIIIIlIlIlI);
            }
        }
    }
    
    private static RandomMobsProperties getProperties(final ResourceLocation lllllllllllllllIlIlIIIlllllIIlll) {
        final String lllllllllllllllIlIlIIIlllllIlIIl = lllllllllllllllIlIlIIIlllllIIlll.getResourcePath();
        RandomMobsProperties lllllllllllllllIlIlIIIlllllIlIII = RandomMobs.locationProperties.get(lllllllllllllllIlIlIIIlllllIlIIl);
        if (lllllllllllllllIlIlIIIlllllIlIII == null) {
            lllllllllllllllIlIlIIIlllllIlIII = makeProperties(lllllllllllllllIlIlIIIlllllIIlll);
            RandomMobs.locationProperties.put(lllllllllllllllIlIlIIIlllllIlIIl, lllllllllllllllIlIlIIIlllllIlIII);
        }
        return lllllllllllllllIlIlIIIlllllIlIII;
    }
}
