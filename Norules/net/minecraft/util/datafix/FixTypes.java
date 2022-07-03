package net.minecraft.util.datafix;

public enum FixTypes implements IFixType
{
    OPTIONS("OPTIONS", 6), 
    ITEM_INSTANCE("ITEM_INSTANCE", 5), 
    CHUNK("CHUNK", 2), 
    LEVEL("LEVEL", 0), 
    STRUCTURE("STRUCTURE", 7), 
    BLOCK_ENTITY("BLOCK_ENTITY", 3), 
    ENTITY("ENTITY", 4), 
    PLAYER("PLAYER", 1);
    
    private FixTypes(final String lIIllllllllIIII, final int lIIlllllllIllll) {
    }
}
