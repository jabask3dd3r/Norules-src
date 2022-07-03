package net.minecraft.client.renderer;

import net.minecraft.client.renderer.texture.*;

public class StitcherException extends RuntimeException
{
    private final /* synthetic */ Stitcher.Holder holder;
    
    public StitcherException(final Stitcher.Holder llllllllllllllIlllIIIIlIllIIIlIl, final String llllllllllllllIlllIIIIlIllIIIIIl) {
        super(llllllllllllllIlllIIIIlIllIIIIIl);
        this.holder = llllllllllllllIlllIIIIlIllIIIlIl;
    }
}
