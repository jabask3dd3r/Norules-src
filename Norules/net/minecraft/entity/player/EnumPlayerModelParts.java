package net.minecraft.entity.player;

import net.minecraft.util.text.*;

public enum EnumPlayerModelParts
{
    JACKET("JACKET", 1, 1, "jacket"), 
    HAT("HAT", 6, 6, "hat"), 
    RIGHT_SLEEVE("RIGHT_SLEEVE", 3, 3, "right_sleeve");
    
    private final /* synthetic */ String partName;
    
    LEFT_SLEEVE("LEFT_SLEEVE", 2, 2, "left_sleeve"), 
    CAPE("CAPE", 0, 0, "cape"), 
    RIGHT_PANTS_LEG("RIGHT_PANTS_LEG", 5, 5, "right_pants_leg");
    
    private final /* synthetic */ ITextComponent name;
    private final /* synthetic */ int partId;
    
    LEFT_PANTS_LEG("LEFT_PANTS_LEG", 4, 4, "left_pants_leg");
    
    private final /* synthetic */ int partMask;
    
    public int getPartMask() {
        return this.partMask;
    }
    
    public String getPartName() {
        return this.partName;
    }
    
    public int getPartId() {
        return this.partId;
    }
    
    private EnumPlayerModelParts(final String llIIIllIIIIIllI, final int llIIIllIIIIIlIl, final int llIIIllIIIIlIIl, final String llIIIllIIIIlIII) {
        this.partId = llIIIllIIIIlIIl;
        this.partMask = 1 << llIIIllIIIIlIIl;
        this.partName = llIIIllIIIIlIII;
        this.name = new TextComponentTranslation(String.valueOf(new StringBuilder("options.modelPart.").append(llIIIllIIIIlIII)), new Object[0]);
    }
    
    public ITextComponent getName() {
        return this.name;
    }
}
