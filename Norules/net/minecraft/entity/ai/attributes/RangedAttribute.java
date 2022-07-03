package net.minecraft.entity.ai.attributes;

import net.minecraft.util.math.*;
import javax.annotation.*;

public class RangedAttribute extends BaseAttribute
{
    private /* synthetic */ String description;
    private final /* synthetic */ double maximumValue;
    private final /* synthetic */ double minimumValue;
    
    @Override
    public double clampValue(double lIllIllIIllIlIl) {
        lIllIllIIllIlIl = MathHelper.clamp(lIllIllIIllIlIl, this.minimumValue, this.maximumValue);
        return lIllIllIIllIlIl;
    }
    
    public RangedAttribute setDescription(final String lIllIllIIlllllI) {
        this.description = lIllIllIIlllllI;
        return this;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public RangedAttribute(@Nullable final IAttribute lIllIllIlIIlIII, final String lIllIllIlIIIlll, final double lIllIllIlIIIllI, final double lIllIllIlIIlIll, final double lIllIllIlIIIlII) {
        super(lIllIllIlIIlIII, lIllIllIlIIIlll, lIllIllIlIIIllI);
        this.minimumValue = lIllIllIlIIlIll;
        this.maximumValue = lIllIllIlIIIlII;
        if (lIllIllIlIIlIll > lIllIllIlIIIlII) {
            throw new IllegalArgumentException("Minimum value cannot be bigger than maximum value!");
        }
        if (lIllIllIlIIIllI < lIllIllIlIIlIll) {
            throw new IllegalArgumentException("Default value cannot be lower than minimum value!");
        }
        if (lIllIllIlIIIllI > lIllIllIlIIIlII) {
            throw new IllegalArgumentException("Default value cannot be bigger than maximum value!");
        }
    }
}
