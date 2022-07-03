package net.minecraft.inventory;

public enum EntityEquipmentSlot
{
    FEET("FEET", 2, Type.ARMOR, 0, 1, "feet");
    
    private final /* synthetic */ int slotIndex;
    
    LEGS("LEGS", 3, Type.ARMOR, 1, 2, "legs"), 
    HEAD("HEAD", 5, Type.ARMOR, 3, 4, "head");
    
    private final /* synthetic */ int index;
    
    CHEST("CHEST", 4, Type.ARMOR, 2, 3, "chest"), 
    OFFHAND("OFFHAND", 1, Type.HAND, 1, 5, "offhand");
    
    private final /* synthetic */ Type slotType;
    private final /* synthetic */ String name;
    
    MAINHAND("MAINHAND", 0, Type.HAND, 0, 0, "mainhand");
    
    public int getIndex() {
        return this.index;
    }
    
    public int getSlotIndex() {
        return this.slotIndex;
    }
    
    public Type getSlotType() {
        return this.slotType;
    }
    
    public static EntityEquipmentSlot fromString(final String lllllllllllllIllllllIIIlllIIIIIl) {
        final float lllllllllllllIllllllIIIllIllllIl;
        final float lllllllllllllIllllllIIIllIlllllI = ((EntityEquipmentSlot[])(Object)(lllllllllllllIllllllIIIllIllllIl = (float)(Object)values())).length;
        for (double lllllllllllllIllllllIIIllIllllll = 0; lllllllllllllIllllllIIIllIllllll < lllllllllllllIllllllIIIllIlllllI; ++lllllllllllllIllllllIIIllIllllll) {
            final EntityEquipmentSlot lllllllllllllIllllllIIIlllIIIIlI = lllllllllllllIllllllIIIllIllllIl[lllllllllllllIllllllIIIllIllllll];
            if (lllllllllllllIllllllIIIlllIIIIlI.getName().equals(lllllllllllllIllllllIIIlllIIIIIl)) {
                return lllllllllllllIllllllIIIlllIIIIlI;
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid slot '").append(lllllllllllllIllllllIIIlllIIIIIl).append("'")));
    }
    
    private EntityEquipmentSlot(final String lllllllllllllIllllllIIIlllIllIlI, final int lllllllllllllIllllllIIIlllIllIIl, final Type lllllllllllllIllllllIIIlllIllIII, final int lllllllllllllIllllllIIIlllIllllI, final int lllllllllllllIllllllIIIlllIlIllI, final String lllllllllllllIllllllIIIlllIlllII) {
        this.slotType = lllllllllllllIllllllIIIlllIllIII;
        this.index = lllllllllllllIllllllIIIlllIllllI;
        this.slotIndex = lllllllllllllIllllllIIIlllIlIllI;
        this.name = lllllllllllllIllllllIIIlllIlllII;
    }
    
    public String getName() {
        return this.name;
    }
    
    public enum Type
    {
        HAND("HAND", 0), 
        ARMOR("ARMOR", 1);
        
        private Type(final String lllllllllllllIllIllIlIllIIIIllll, final int lllllllllllllIllIllIlIllIIIIlllI) {
        }
    }
}
