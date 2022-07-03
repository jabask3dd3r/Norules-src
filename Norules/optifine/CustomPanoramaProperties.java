package optifine;

import net.minecraft.util.*;
import java.util.*;

public class CustomPanoramaProperties
{
    private /* synthetic */ int overlay2Bottom;
    private /* synthetic */ String path;
    private /* synthetic */ int blur3;
    private /* synthetic */ ResourceLocation[] panoramaLocations;
    private /* synthetic */ int weight;
    private /* synthetic */ int blur2;
    private /* synthetic */ int blur1;
    private /* synthetic */ int overlay1Top;
    private /* synthetic */ int overlay1Bottom;
    private /* synthetic */ int overlay2Top;
    
    public CustomPanoramaProperties(final String lllllllllllllIlIIlIlllIllIIIlIll, final Properties lllllllllllllIlIIlIlllIllIIIllll) {
        this.weight = 1;
        this.blur1 = 64;
        this.blur2 = 3;
        this.blur3 = 3;
        this.overlay1Top = -2130706433;
        this.overlay1Bottom = 16777215;
        this.overlay2Top = 0;
        this.overlay2Bottom = Integer.MIN_VALUE;
        final ConnectedParser lllllllllllllIlIIlIlllIllIIIlllI = new ConnectedParser("CustomPanorama");
        this.path = lllllllllllllIlIIlIlllIllIIIlIll;
        this.panoramaLocations = new ResourceLocation[6];
        for (int lllllllllllllIlIIlIlllIllIIIllIl = 0; lllllllllllllIlIIlIlllIllIIIllIl < this.panoramaLocations.length; ++lllllllllllllIlIIlIlllIllIIIllIl) {
            this.panoramaLocations[lllllllllllllIlIIlIlllIllIIIllIl] = new ResourceLocation(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIlIlllIllIIIlIll)).append("/panorama_").append(lllllllllllllIlIIlIlllIllIIIllIl).append(".png")));
        }
        this.weight = lllllllllllllIlIIlIlllIllIIIlllI.parseInt(lllllllllllllIlIIlIlllIllIIIllll.getProperty("weight"), 1);
        this.blur1 = lllllllllllllIlIIlIlllIllIIIlllI.parseInt(lllllllllllllIlIIlIlllIllIIIllll.getProperty("blur1"), 64);
        this.blur2 = lllllllllllllIlIIlIlllIllIIIlllI.parseInt(lllllllllllllIlIIlIlllIllIIIllll.getProperty("blur2"), 3);
        this.blur3 = lllllllllllllIlIIlIlllIllIIIlllI.parseInt(lllllllllllllIlIIlIlllIllIIIllll.getProperty("blur3"), 3);
        this.overlay1Top = ConnectedParser.parseColor4(lllllllllllllIlIIlIlllIllIIIllll.getProperty("overlay1.top"), -2130706433);
        this.overlay1Bottom = ConnectedParser.parseColor4(lllllllllllllIlIIlIlllIllIIIllll.getProperty("overlay1.bottom"), 16777215);
        this.overlay2Top = ConnectedParser.parseColor4(lllllllllllllIlIIlIlllIllIIIllll.getProperty("overlay2.top"), 0);
        this.overlay2Bottom = ConnectedParser.parseColor4(lllllllllllllIlIIlIlllIllIIIllll.getProperty("overlay2.bottom"), Integer.MIN_VALUE);
    }
    
    public int getOverlay1Top() {
        return this.overlay1Top;
    }
    
    public int getOverlay1Bottom() {
        return this.overlay1Bottom;
    }
    
    public int getBlur3() {
        return this.blur3;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public int getBlur1() {
        return this.blur1;
    }
    
    public ResourceLocation[] getPanoramaLocations() {
        return this.panoramaLocations;
    }
    
    public int getOverlay2Top() {
        return this.overlay2Top;
    }
    
    public int getOverlay2Bottom() {
        return this.overlay2Bottom;
    }
    
    public int getBlur2() {
        return this.blur2;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.path).append(", weight: ").append(this.weight).append(", blur: ").append(this.blur1).append(" ").append(this.blur2).append(" ").append(this.blur3).append(", overlay: ").append(this.overlay1Top).append(" ").append(this.overlay1Bottom).append(" ").append(this.overlay2Top).append(" ").append(this.overlay2Bottom));
    }
}
