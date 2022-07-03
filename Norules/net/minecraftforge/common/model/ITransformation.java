package net.minecraftforge.common.model;

import net.minecraft.util.*;
import javax.vecmath.*;

public interface ITransformation
{
    int rotate(final EnumFacing p0, final int p1);
    
    Matrix4f getMatrix();
    
    EnumFacing rotate(final EnumFacing p0);
}
