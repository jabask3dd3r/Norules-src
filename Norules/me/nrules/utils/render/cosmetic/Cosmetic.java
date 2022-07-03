package me.nrules.utils.render.cosmetic;

import net.minecraft.util.*;
import me.nrules.module.render.*;
import net.minecraft.entity.player.*;
import me.nrules.utils.render.cosmetic.impl.*;

public class Cosmetic
{
    public static ResourceLocation getWing() {
        final String llllllllllllllIllllIlIIlIlIllIll = Cosmetics.modeType1.getValString();
        if (llllllllllllllIllllIlIIlIlIllIll.equalsIgnoreCase("Night")) {
            return new ResourceLocation("nrules/cosmetic/night.png");
        }
        if (llllllllllllllIllllIlIIlIlIllIll.equalsIgnoreCase("Day")) {
            return new ResourceLocation("nrules/cosmetic/day.png");
        }
        return new ResourceLocation(null);
    }
    
    public static ResourceLocation getCape() {
        final String llllllllllllllIllllIlIIlIllIIIIl = Cosmetics.modeType.getValString();
        if (llllllllllllllIllllIlIIlIllIIIIl.equalsIgnoreCase("Xoma")) {
            return new ResourceLocation("nrules/cosmetic/cape/xoma.png");
        }
        if (llllllllllllllIllllIlIIlIllIIIIl.equalsIgnoreCase("Kitty")) {
            return new ResourceLocation("nrules/cosmetic/cape/kitty.png");
        }
        return new ResourceLocation(null);
    }
    
    public static void renderAccessory(final String[] llllllllllllllIllllIlIIlIllIlllI, final EntityPlayer llllllllllllllIllllIlIIlIllIllIl, final float llllllllllllllIllllIlIIlIllIllII) {
        final byte llllllllllllllIllllIlIIlIllIIlII = (Object)llllllllllllllIllllIlIIlIllIlllI;
        for (String llllllllllllllIllllIlIIlIllIIlIl = (String)llllllllllllllIllllIlIIlIllIlllI.length, llllllllllllllIllllIlIIlIllIIllI = (String)0; llllllllllllllIllllIlIIlIllIIllI < llllllllllllllIllllIlIIlIllIIlIl; ++llllllllllllllIllllIlIIlIllIIllI) {
            final String llllllllllllllIllllIlIIlIllIlIll = llllllllllllllIllllIlIIlIllIIlII[llllllllllllllIllllIlIIlIllIIllI];
            final double llllllllllllllIllllIlIIlIllIIIll;
            switch (((String)(llllllllllllllIllllIlIIlIllIIIll = (double)llllllllllllllIllllIlIIlIllIlIll)).hashCode()) {
                case -645481: {
                    if (!((String)llllllllllllllIllllIlIIlIllIIIll).equals("Dragon_wing")) {
                        break;
                    }
                    DragonWing.render(llllllllllllllIllllIlIIlIllIllIl, llllllllllllllIllllIlIIlIllIllII);
                    break;
                }
            }
        }
    }
}
