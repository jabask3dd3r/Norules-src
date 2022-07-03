package de.gerrygames.viarewind.replacement;

import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;

public interface EntityReplacement
{
    void updateMetadata(final List<Metadata> p0);
    
    void despawn();
    
    void setYawPitch(final float p0, final float p1);
    
    void spawn();
    
    void setLocation(final double p0, final double p1, final double p2);
    
    int getEntityId();
    
    void relMove(final double p0, final double p1, final double p2);
    
    void setHeadYaw(final float p0);
}
