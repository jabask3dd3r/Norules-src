package net.minecraft.world;

public enum EnumDifficulty
{
    NORMAL("NORMAL", 2, 2, "options.difficulty.normal");
    
    private final /* synthetic */ int difficultyId;
    private static final /* synthetic */ EnumDifficulty[] ID_MAPPING;
    private final /* synthetic */ String difficultyResourceKey;
    
    PEACEFUL("PEACEFUL", 0, 0, "options.difficulty.peaceful"), 
    HARD("HARD", 3, 3, "options.difficulty.hard"), 
    EASY("EASY", 1, 1, "options.difficulty.easy");
    
    static {
        ID_MAPPING = new EnumDifficulty[values().length];
        final Exception llllllllllllllIIlllIIlllIIIIIlll;
        final double llllllllllllllIIlllIIlllIIIIlIII = ((EnumDifficulty[])(Object)(llllllllllllllIIlllIIlllIIIIIlll = (Exception)(Object)values())).length;
        for (byte llllllllllllllIIlllIIlllIIIIlIIl = 0; llllllllllllllIIlllIIlllIIIIlIIl < llllllllllllllIIlllIIlllIIIIlIII; ++llllllllllllllIIlllIIlllIIIIlIIl) {
            final EnumDifficulty llllllllllllllIIlllIIlllIIIIlIll = llllllllllllllIIlllIIlllIIIIIlll[llllllllllllllIIlllIIlllIIIIlIIl];
            EnumDifficulty.ID_MAPPING[llllllllllllllIIlllIIlllIIIIlIll.difficultyId] = llllllllllllllIIlllIIlllIIIIlIll;
        }
    }
    
    public static EnumDifficulty getDifficultyEnum(final int llllllllllllllIIlllIIllIllllIlIl) {
        return EnumDifficulty.ID_MAPPING[llllllllllllllIIlllIIllIllllIlIl % EnumDifficulty.ID_MAPPING.length];
    }
    
    private EnumDifficulty(final String llllllllllllllIIlllIIllIllllllIl, final int llllllllllllllIIlllIIllIllllllII, final int llllllllllllllIIlllIIlllIIIIIIII, final String llllllllllllllIIlllIIllIllllllll) {
        this.difficultyId = llllllllllllllIIlllIIlllIIIIIIII;
        this.difficultyResourceKey = llllllllllllllIIlllIIllIllllllll;
    }
    
    public int getDifficultyId() {
        return this.difficultyId;
    }
    
    public String getDifficultyResourceKey() {
        return this.difficultyResourceKey;
    }
}
