package net.minecraft.world;

public class WorldType
{
    private final /* synthetic */ int worldTypeId;
    private /* synthetic */ boolean hasNotificationData;
    private final /* synthetic */ String worldType;
    public static final /* synthetic */ WorldType DEFAULT;
    public static final /* synthetic */ WorldType DEFAULT_1_1;
    private final /* synthetic */ int generatorVersion;
    private /* synthetic */ boolean canBeCreated;
    private /* synthetic */ boolean isWorldTypeVersioned;
    public static final /* synthetic */ WorldType[] WORLD_TYPES;
    
    public static WorldType parseWorldType(final String lllllllllllllIllIIllIIIlIIllIIIl) {
        final boolean lllllllllllllIllIIllIIIlIIlIllIl;
        final boolean lllllllllllllIllIIllIIIlIIlIlllI = ((WorldType[])(Object)(lllllllllllllIllIIllIIIlIIlIllIl = (boolean)(Object)WorldType.WORLD_TYPES)).length != 0;
        for (final WorldType lllllllllllllIllIIllIIIlIIllIIlI : lllllllllllllIllIIllIIIlIIlIllIl) {
            if (lllllllllllllIllIIllIIIlIIllIIlI != null && lllllllllllllIllIIllIIIlIIllIIlI.worldType.equalsIgnoreCase(lllllllllllllIllIIllIIIlIIllIIIl)) {
                return lllllllllllllIllIIllIIIlIIllIIlI;
            }
        }
        return null;
    }
    
    public boolean getCanBeCreated() {
        return this.canBeCreated;
    }
    
    public boolean showWorldInfoNotice() {
        return this.hasNotificationData;
    }
    
    private WorldType setCanBeCreated(final boolean lllllllllllllIllIIllIIIlIlIIIIlI) {
        this.canBeCreated = lllllllllllllIllIIllIIIlIlIIIIlI;
        return this;
    }
    
    private WorldType setVersioned() {
        this.isWorldTypeVersioned = true;
        return this;
    }
    
    public String getTranslatedInfo() {
        return String.valueOf(new StringBuilder(String.valueOf(this.getTranslateName())).append(".info"));
    }
    
    public WorldType getWorldTypeForGeneratorVersion(final int lllllllllllllIllIIllIIIlIlIIlIII) {
        return (this == WorldType.DEFAULT && lllllllllllllIllIIllIIIlIlIIlIII == 0) ? WorldType.DEFAULT_1_1 : this;
    }
    
    public int getWorldTypeID() {
        return this.worldTypeId;
    }
    
    public boolean isVersioned() {
        return this.isWorldTypeVersioned;
    }
    
    private WorldType(final int lllllllllllllIllIIllIIIlIllIlIlI, final String lllllllllllllIllIIllIIIlIllIIllI) {
        this(lllllllllllllIllIIllIIIlIllIlIlI, lllllllllllllIllIIllIIIlIllIIllI, 0);
    }
    
    public String getWorldTypeName() {
        return this.worldType;
    }
    
    public int getGeneratorVersion() {
        return this.generatorVersion;
    }
    
    private WorldType setNotificationData() {
        this.hasNotificationData = true;
        return this;
    }
    
    public String getTranslateName() {
        return String.valueOf(new StringBuilder("generator.").append(this.worldType));
    }
    
    private WorldType(final int lllllllllllllIllIIllIIIlIlIlllII, final String lllllllllllllIllIIllIIIlIlIlllll, final int lllllllllllllIllIIllIIIlIlIllllI) {
        this.worldType = lllllllllllllIllIIllIIIlIlIlllll;
        this.generatorVersion = lllllllllllllIllIIllIIIlIlIllllI;
        this.canBeCreated = true;
        this.worldTypeId = lllllllllllllIllIIllIIIlIlIlllII;
        WorldType.WORLD_TYPES[lllllllllllllIllIIllIIIlIlIlllII] = this;
    }
    
    static {
        WORLD_TYPES = new WorldType[16];
        DEFAULT = new WorldType(0, "default", 1).setVersioned();
        FLAT = new WorldType(1, "flat");
        LARGE_BIOMES = new WorldType(2, "largeBiomes");
        AMPLIFIED = new WorldType(3, "amplified").setNotificationData();
        CUSTOMIZED = new WorldType(4, "customized");
        DEBUG_WORLD = new WorldType(5, "debug_all_block_states");
        DEFAULT_1_1 = new WorldType(8, "default_1_1", 0).setCanBeCreated(false);
    }
}
