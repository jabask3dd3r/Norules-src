package optifine;

import java.util.*;
import org.lwjgl.opengl.*;

public class DisplayModeComparator implements Comparator
{
    @Override
    public int compare(final Object lllllllllllllIlIlIIIIllllIIIIIII, final Object lllllllllllllIlIlIIIIlllIlllllIl) {
        final DisplayMode lllllllllllllIlIlIIIIlllIllllIlI = (DisplayMode)lllllllllllllIlIlIIIIllllIIIIIII;
        final DisplayMode lllllllllllllIlIlIIIIlllIlllIlll = (DisplayMode)lllllllllllllIlIlIIIIlllIlllllIl;
        if (lllllllllllllIlIlIIIIlllIllllIlI.getWidth() != lllllllllllllIlIlIIIIlllIlllIlll.getWidth()) {
            return lllllllllllllIlIlIIIIlllIllllIlI.getWidth() - lllllllllllllIlIlIIIIlllIlllIlll.getWidth();
        }
        if (lllllllllllllIlIlIIIIlllIllllIlI.getHeight() != lllllllllllllIlIlIIIIlllIlllIlll.getHeight()) {
            return lllllllllllllIlIlIIIIlllIllllIlI.getHeight() - lllllllllllllIlIlIIIIlllIlllIlll.getHeight();
        }
        if (lllllllllllllIlIlIIIIlllIllllIlI.getBitsPerPixel() != lllllllllllllIlIlIIIIlllIlllIlll.getBitsPerPixel()) {
            return lllllllllllllIlIlIIIIlllIllllIlI.getBitsPerPixel() - lllllllllllllIlIlIIIIlllIlllIlll.getBitsPerPixel();
        }
        return (lllllllllllllIlIlIIIIlllIllllIlI.getFrequency() != lllllllllllllIlIlIIIIlllIlllIlll.getFrequency()) ? (lllllllllllllIlIlIIIIlllIllllIlI.getFrequency() - lllllllllllllIlIlIIIIlllIlllIlll.getFrequency()) : 0;
    }
}
