package com.viaversion.viaversion.api.minecraft;

public enum Environment
{
    END(1), 
    NORMAL(0), 
    NETHER(-1);
    
    private final /* synthetic */ int id;
    
    private Environment(final int lllllllllllllIIIlIllllIIIIlIlIlI) {
        this.id = lllllllllllllIIIlIllllIIIIlIlIlI;
    }
    
    public int getId() {
        return this.id;
    }
    
    public static Environment getEnvironmentById(final int lllllllllllllIIIlIllllIIIIlIIIII) {
        switch (lllllllllllllIIIlIllllIIIIlIIIII) {
            default: {
                return Environment.NETHER;
            }
            case 0: {
                return Environment.NORMAL;
            }
            case 1: {
                return Environment.END;
            }
        }
    }
}
