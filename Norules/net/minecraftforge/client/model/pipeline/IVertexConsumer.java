package net.minecraftforge.client.model.pipeline;

import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;

public interface IVertexConsumer
{
    VertexFormat getVertexFormat();
    
    void setQuadOrientation(final EnumFacing p0);
    
    void put(final int p0, final float... p1);
    
    void setQuadColored();
    
    void setQuadTint(final int p0);
}
