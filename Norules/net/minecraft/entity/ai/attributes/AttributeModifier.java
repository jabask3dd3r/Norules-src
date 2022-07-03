package net.minecraft.entity.ai.attributes;

import org.apache.commons.lang3.*;
import io.netty.util.internal.*;
import net.minecraft.util.math.*;
import java.util.*;

public class AttributeModifier
{
    private /* synthetic */ boolean isSaved;
    private final /* synthetic */ int operation;
    private final /* synthetic */ String name;
    private final /* synthetic */ double amount;
    private final /* synthetic */ UUID id;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("AttributeModifier{amount=").append(this.amount).append(", operation=").append(this.operation).append(", name='").append(this.name).append('\'').append(", id=").append(this.id).append(", serialize=").append(this.isSaved).append('}'));
    }
    
    public UUID getID() {
        return this.id;
    }
    
    public AttributeModifier(final UUID llllllllllllllIllllllIIlllIIIlll, final String llllllllllllllIllllllIIlllIIIllI, final double llllllllllllllIllllllIIlllIIIIII, final int llllllllllllllIllllllIIlllIIIlII) {
        this.isSaved = true;
        this.id = llllllllllllllIllllllIIlllIIIlll;
        this.name = llllllllllllllIllllllIIlllIIIllI;
        this.amount = llllllllllllllIllllllIIlllIIIIII;
        this.operation = llllllllllllllIllllllIIlllIIIlII;
        Validate.notEmpty((CharSequence)llllllllllllllIllllllIIlllIIIllI, "Modifier name cannot be empty", new Object[0]);
        Validate.inclusiveBetween(0L, 2L, (long)llllllllllllllIllllllIIlllIIIlII, "Invalid operation");
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllllllIIllIlIIIlI) {
        if (this == llllllllllllllIllllllIIllIlIIIlI) {
            return true;
        }
        if (llllllllllllllIllllllIIllIlIIIlI != null && this.getClass() == llllllllllllllIllllllIIllIlIIIlI.getClass()) {
            final AttributeModifier llllllllllllllIllllllIIllIlIIlII = (AttributeModifier)llllllllllllllIllllllIIllIlIIIlI;
            if (this.id != null) {
                if (!this.id.equals(llllllllllllllIllllllIIllIlIIlII.id)) {
                    return false;
                }
            }
            else if (llllllllllllllIllllllIIllIlIIlII.id != null) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public AttributeModifier setSaved(final boolean llllllllllllllIllllllIIllIlIlIlI) {
        this.isSaved = llllllllllllllIllllllIIllIlIlIlI;
        return this;
    }
    
    public AttributeModifier(final String llllllllllllllIllllllIIlllIlIIlI, final double llllllllllllllIllllllIIlllIllIII, final int llllllllllllllIllllllIIlllIIllll) {
        this(MathHelper.getRandomUUID((Random)ThreadLocalRandom.current()), llllllllllllllIllllllIIlllIlIIlI, llllllllllllllIllllllIIlllIllIII, llllllllllllllIllllllIIlllIIllll);
    }
    
    public boolean isSaved() {
        return this.isSaved;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getOperation() {
        return this.operation;
    }
    
    @Override
    public int hashCode() {
        return (this.id != null) ? this.id.hashCode() : 0;
    }
}
