package net.minecraft.tileentity;

import net.minecraft.item.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public enum BannerPattern
{
    DIAGONAL_LEFT("DIAGONAL_LEFT", 20, "diagonal_left", "ld", "## ", "#  ", "   "), 
    TRIANGLE_BOTTOM("TRIANGLE_BOTTOM", 16, "triangle_bottom", "bt", "   ", " # ", "# #"), 
    HALF_HORIZONTAL("HALF_HORIZONTAL", 27, "half_horizontal", "hh", "###", "###", "   "), 
    TRIANGLES_BOTTOM("TRIANGLES_BOTTOM", 18, "triangles_bottom", "bts", "   ", "# #", " # "), 
    MOJANG("MOJANG", 38, "mojang", "moj", new ItemStack(Items.GOLDEN_APPLE, 1, 1)), 
    TRIANGLE_TOP("TRIANGLE_TOP", 17, "triangle_top", "tt", "# #", " # ", "   ");
    
    private final /* synthetic */ String field_191015_O;
    
    STRIPE_BOTTOM("STRIPE_BOTTOM", 5, "stripe_bottom", "bs", "   ", "   ", "###"), 
    CIRCLE_MIDDLE("CIRCLE_MIDDLE", 24, "circle", "mc", "   ", " # ", "   ");
    
    private final /* synthetic */ String[] field_191016_P;
    
    BRICKS("BRICKS", 35, "bricks", "bri", new ItemStack(Blocks.BRICK_BLOCK)), 
    GRADIENT("GRADIENT", 33, "gradient", "gra", "# #", " # ", " # "), 
    SKULL("SKULL", 36, "skull", "sku", new ItemStack(Items.SKULL, 1, 1)), 
    STRAIGHT_CROSS("STRAIGHT_CROSS", 15, "straight_cross", "sc", " # ", "###", " # "), 
    DIAGONAL_LEFT_MIRROR("DIAGONAL_LEFT_MIRROR", 22, "diagonal_up_left", "lud", "   ", "#  ", "## "), 
    SQUARE_TOP_LEFT("SQUARE_TOP_LEFT", 3, "square_top_left", "tl", "#  ", "   ", "   "), 
    STRIPE_LEFT("STRIPE_LEFT", 7, "stripe_left", "ls", "#  ", "#  ", "#  "), 
    CROSS("CROSS", 14, "cross", "cr", "# #", " # ", "# #"), 
    HALF_VERTICAL_MIRROR("HALF_VERTICAL_MIRROR", 28, "half_vertical_right", "vhr", " ##", " ##", " ##"), 
    STRIPE_SMALL("STRIPE_SMALL", 13, "small_stripes", "ss", "# #", "# #", "   "), 
    HALF_HORIZONTAL_MIRROR("HALF_HORIZONTAL_MIRROR", 29, "half_horizontal_bottom", "hhb", "   ", "###", "###"), 
    SQUARE_TOP_RIGHT("SQUARE_TOP_RIGHT", 4, "square_top_right", "tr", "  #", "   ", "   "), 
    RHOMBUS_MIDDLE("RHOMBUS_MIDDLE", 25, "rhombus", "mr", " # ", "# #", " # "), 
    STRIPE_DOWNRIGHT("STRIPE_DOWNRIGHT", 11, "stripe_downright", "drs", "#  ", " # ", "  #"), 
    TRIANGLES_TOP("TRIANGLES_TOP", 19, "triangles_top", "tts", " # ", "# #", "   "), 
    GRADIENT_UP("GRADIENT_UP", 34, "gradient_up", "gru", " # ", " # ", "# #"), 
    CURLY_BORDER("CURLY_BORDER", 31, "curly_border", "cbo", new ItemStack(Blocks.VINE)), 
    DIAGONAL_RIGHT("DIAGONAL_RIGHT", 21, "diagonal_up_right", "rd", "   ", "  #", " ##"), 
    STRIPE_MIDDLE("STRIPE_MIDDLE", 10, "stripe_middle", "ms", "   ", "###", "   "), 
    STRIPE_TOP("STRIPE_TOP", 6, "stripe_top", "ts", "###", "   ", "   "), 
    CREEPER("CREEPER", 32, "creeper", "cre", new ItemStack(Items.SKULL, 1, 4)), 
    FLOWER("FLOWER", 37, "flower", "flo", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.OXEYE_DAISY.getMeta())), 
    HALF_VERTICAL("HALF_VERTICAL", 26, "half_vertical", "vh", "## ", "## ", "## "), 
    SQUARE_BOTTOM_LEFT("SQUARE_BOTTOM_LEFT", 1, "square_bottom_left", "bl", "   ", "   ", "#  "), 
    STRIPE_RIGHT("STRIPE_RIGHT", 8, "stripe_right", "rs", "  #", "  #", "  #"), 
    DIAGONAL_RIGHT_MIRROR("DIAGONAL_RIGHT_MIRROR", 23, "diagonal_right", "rud", " ##", "  #", "   "), 
    STRIPE_DOWNLEFT("STRIPE_DOWNLEFT", 12, "stripe_downleft", "dls", "  #", " # ", "#  "), 
    BASE("BASE", 0, "base", "b"), 
    STRIPE_CENTER("STRIPE_CENTER", 9, "stripe_center", "cs", " # ", " # ", " # ");
    
    private /* synthetic */ ItemStack field_191017_Q;
    
    BORDER("BORDER", 30, "border", "bo", "###", "# #", "###");
    
    private final /* synthetic */ String field_191014_N;
    
    SQUARE_BOTTOM_RIGHT("SQUARE_BOTTOM_RIGHT", 2, "square_bottom_right", "br", "   ", "   ", "  #");
    
    public ItemStack func_190998_f() {
        return this.field_191017_Q;
    }
    
    private BannerPattern(final String llllllllllllllIllIlllllllIllIlIl, final int llllllllllllllIllIlllllllIllIlII, final String llllllllllllllIllIlllllllIlllIIl, final String llllllllllllllIllIlllllllIllIIlI, final ItemStack llllllllllllllIllIlllllllIllIlll) {
        this(llllllllllllllIllIlllllllIllIlIl, llllllllllllllIllIlllllllIllIlII, llllllllllllllIllIlllllllIlllIIl, llllllllllllllIllIlllllllIllIIlI);
        this.field_191017_Q = llllllllllllllIllIlllllllIllIlll;
    }
    
    @Nullable
    public static BannerPattern func_190994_a(final String llllllllllllllIllIlllllllIIIIIIl) {
        final boolean llllllllllllllIllIllllllIlllllIl;
        final short llllllllllllllIllIllllllIllllllI = (short)((BannerPattern[])(Object)(llllllllllllllIllIllllllIlllllIl = (boolean)(Object)values())).length;
        for (String llllllllllllllIllIllllllIlllllll = (String)0; llllllllllllllIllIllllllIlllllll < llllllllllllllIllIllllllIllllllI; ++llllllllllllllIllIllllllIlllllll) {
            final BannerPattern llllllllllllllIllIlllllllIIIIIlI = llllllllllllllIllIllllllIlllllIl[llllllllllllllIllIllllllIlllllll];
            if (llllllllllllllIllIlllllllIIIIIlI.field_191015_O.equals(llllllllllllllIllIlllllllIIIIIIl)) {
                return llllllllllllllIllIlllllllIIIIIlI;
            }
        }
        return null;
    }
    
    public boolean func_190999_e() {
        return !this.field_191017_Q.func_190926_b();
    }
    
    private BannerPattern(final String llllllllllllllIllIllllllllIIIlII, final int llllllllllllllIllIllllllllIIIIll, final String llllllllllllllIllIllllllllIIIIlI, final String llllllllllllllIllIllllllllIIIIIl) {
        this.field_191016_P = new String[3];
        this.field_191017_Q = ItemStack.field_190927_a;
        this.field_191014_N = llllllllllllllIllIllllllllIIIIlI;
        this.field_191015_O = llllllllllllllIllIllllllllIIIIIl;
    }
    
    public String func_190993_b() {
        return this.field_191015_O;
    }
    
    public String[] func_190996_c() {
        return this.field_191016_P;
    }
    
    public String func_190997_a() {
        return this.field_191014_N;
    }
    
    private BannerPattern(final String llllllllllllllIllIlllllllIlIIIIl, final int llllllllllllllIllIlllllllIlIIIII, final String llllllllllllllIllIlllllllIlIIlll, final String llllllllllllllIllIlllllllIIllllI, final String llllllllllllllIllIlllllllIlIIlIl, final String llllllllllllllIllIlllllllIlIIlII, final String llllllllllllllIllIlllllllIlIIIll) {
        this(llllllllllllllIllIlllllllIlIIIIl, llllllllllllllIllIlllllllIlIIIII, llllllllllllllIllIlllllllIlIIlll, llllllllllllllIllIlllllllIIllllI);
        this.field_191016_P[0] = llllllllllllllIllIlllllllIlIIlIl;
        this.field_191016_P[1] = llllllllllllllIllIlllllllIlIIlII;
        this.field_191016_P[2] = llllllllllllllIllIlllllllIlIIIll;
    }
    
    public boolean func_191000_d() {
        return !this.field_191017_Q.func_190926_b() || this.field_191016_P[0] != null;
    }
}
