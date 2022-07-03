package net.minecraft.client.renderer.block.model;

import org.lwjgl.util.vector.*;
import net.minecraft.util.*;

public class BlockPartRotation
{
    public final /* synthetic */ float angle;
    public final /* synthetic */ Vector3f origin;
    public final /* synthetic */ EnumFacing.Axis axis;
    public final /* synthetic */ boolean rescale;
    
    public BlockPartRotation(final Vector3f lIlllIIIllllIlI, final EnumFacing.Axis lIlllIIIllllllI, final float lIlllIIIllllIII, final boolean lIlllIIIlllIlll) {
        this.origin = lIlllIIIllllIlI;
        this.axis = lIlllIIIllllllI;
        this.angle = lIlllIIIllllIII;
        this.rescale = lIlllIIIlllIlll;
    }
}
