package net.minecraft.util;

import net.minecraft.client.gui.*;
import org.apache.commons.lang3.*;
import java.util.*;

public class EnchantmentNameParts
{
    private final /* synthetic */ String[] namePartsArray;
    private final /* synthetic */ Random rand;
    private static final /* synthetic */ EnchantmentNameParts INSTANCE;
    
    public static EnchantmentNameParts getInstance() {
        return EnchantmentNameParts.INSTANCE;
    }
    
    public String generateNewRandomName(final FontRenderer lllllllllllllIIlIllIlIIIIlllIlII, final int lllllllllllllIIlIllIlIIIIllIllII) {
        final int lllllllllllllIIlIllIlIIIIlllIIlI = this.rand.nextInt(2) + 3;
        String lllllllllllllIIlIllIlIIIIlllIIIl = "";
        for (int lllllllllllllIIlIllIlIIIIlllIIII = 0; lllllllllllllIIlIllIlIIIIlllIIII < lllllllllllllIIlIllIlIIIIlllIIlI; ++lllllllllllllIIlIllIlIIIIlllIIII) {
            if (lllllllllllllIIlIllIlIIIIlllIIII > 0) {
                lllllllllllllIIlIllIlIIIIlllIIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIllIlIIIIlllIIIl)).append(" "));
            }
            lllllllllllllIIlIllIlIIIIlllIIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIllIlIIIIlllIIIl)).append(this.namePartsArray[this.rand.nextInt(this.namePartsArray.length)]));
        }
        final List<String> lllllllllllllIIlIllIlIIIIllIllll = lllllllllllllIIlIllIlIIIIlllIlII.listFormattedStringToWidth(lllllllllllllIIlIllIlIIIIlllIIIl, lllllllllllllIIlIllIlIIIIllIllII);
        return StringUtils.join((Iterable)((lllllllllllllIIlIllIlIIIIllIllll.size() >= 2) ? lllllllllllllIIlIllIlIIIIllIllll.subList(0, 2) : lllllllllllllIIlIllIlIIIIllIllll), " ");
    }
    
    public void reseedRandomGenerator(final long lllllllllllllIIlIllIlIIIIllIIlIl) {
        this.rand.setSeed(lllllllllllllIIlIllIlIIIIllIIlIl);
    }
    
    static {
        INSTANCE = new EnchantmentNameParts();
    }
    
    public EnchantmentNameParts() {
        this.rand = new Random();
        this.namePartsArray = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale phnglui mglwnafh cthulhu rlyeh wgahnagl fhtagnbaguette".split(" ");
    }
}
