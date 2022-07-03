package com.viaversion.viaversion.api.minecraft;

public class VillagerData
{
    private final /* synthetic */ int profession;
    private final /* synthetic */ int type;
    private final /* synthetic */ int level;
    
    public VillagerData(final int llllllllllllllIIIIlIIIIlllIIIlll, final int llllllllllllllIIIIlIIIIlllIIIIlI, final int llllllllllllllIIIIlIIIIlllIIIIIl) {
        this.type = llllllllllllllIIIIlIIIIlllIIIlll;
        this.profession = llllllllllllllIIIIlIIIIlllIIIIlI;
        this.level = llllllllllllllIIIIlIIIIlllIIIIIl;
    }
    
    public int getType() {
        return this.type;
    }
    
    public int getProfession() {
        return this.profession;
    }
    
    public int getLevel() {
        return this.level;
    }
}
