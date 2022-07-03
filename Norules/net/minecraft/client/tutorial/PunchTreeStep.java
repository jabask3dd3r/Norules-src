package net.minecraft.client.tutorial;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.toasts.*;
import net.minecraft.client.entity.*;

public class PunchTreeStep implements ITutorialStep
{
    private static final /* synthetic */ Set<Block> field_193274_a;
    private static final /* synthetic */ ITextComponent field_193275_b;
    private /* synthetic */ int field_193280_g;
    private static final /* synthetic */ ITextComponent field_193276_c;
    private /* synthetic */ int field_193279_f;
    private /* synthetic */ TutorialToast field_193278_e;
    private final /* synthetic */ Tutorial field_193277_d;
    
    @Override
    public void func_193248_b() {
        if (this.field_193278_e != null) {
            this.field_193278_e.func_193670_a();
            this.field_193278_e = null;
        }
    }
    
    @Override
    public void func_193250_a(final WorldClient lllllllllllllIllIIIIIlIIIllIIIll, final BlockPos lllllllllllllIllIIIIIlIIIllIIIlI, final IBlockState lllllllllllllIllIIIIIlIIIllIIIIl, final float lllllllllllllIllIIIIIlIIIlIlllII) {
        final boolean lllllllllllllIllIIIIIlIIIlIlllll = PunchTreeStep.field_193274_a.contains(lllllllllllllIllIIIIIlIIIllIIIIl.getBlock());
        if (lllllllllllllIllIIIIIlIIIlIlllll && lllllllllllllIllIIIIIlIIIlIlllII > 0.0f) {
            if (this.field_193278_e != null) {
                this.field_193278_e.func_193669_a(lllllllllllllIllIIIIIlIIIlIlllII);
            }
            if (lllllllllllllIllIIIIIlIIIlIlllII >= 1.0f) {
                this.field_193277_d.func_193292_a(TutorialSteps.OPEN_INVENTORY);
            }
        }
        else if (this.field_193278_e != null) {
            this.field_193278_e.func_193669_a(0.0f);
        }
        else if (lllllllllllllIllIIIIIlIIIlIlllll) {
            ++this.field_193280_g;
        }
    }
    
    public PunchTreeStep(final Tutorial lllllllllllllIllIIIIIlIIIllllIIl) {
        this.field_193277_d = lllllllllllllIllIIIIIlIIIllllIIl;
    }
    
    static {
        field_193274_a = Sets.newHashSet((Object[])new Block[] { Blocks.LOG, Blocks.LOG2 });
        field_193275_b = new TextComponentTranslation("tutorial.punch_tree.title", new Object[0]);
        field_193276_c = new TextComponentTranslation("tutorial.punch_tree.description", new Object[] { Tutorial.func_193291_a("attack") });
    }
    
    @Override
    public void func_193252_a(final ItemStack lllllllllllllIllIIIIIlIIIlIlIlIl) {
        for (final Block lllllllllllllIllIIIIIlIIIlIlIlII : PunchTreeStep.field_193274_a) {
            if (lllllllllllllIllIIIIIlIIIlIlIlIl.getItem() == Item.getItemFromBlock(lllllllllllllIllIIIIIlIIIlIlIlII)) {
                this.field_193277_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
            }
        }
    }
    
    @Override
    public void func_193245_a() {
        ++this.field_193279_f;
        if (this.field_193277_d.func_194072_f() != GameType.SURVIVAL) {
            this.field_193277_d.func_193292_a(TutorialSteps.NONE);
        }
        else {
            if (this.field_193279_f == 1) {
                final EntityPlayerSP lllllllllllllIllIIIIIlIIIlllIIIl = this.field_193277_d.func_193295_e().player;
                if (lllllllllllllIllIIIIIlIIIlllIIIl != null) {
                    for (final Block lllllllllllllIllIIIIIlIIIlllIIII : PunchTreeStep.field_193274_a) {
                        if (lllllllllllllIllIIIIIlIIIlllIIIl.inventory.hasItemStack(new ItemStack(lllllllllllllIllIIIIIlIIIlllIIII))) {
                            this.field_193277_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
                            return;
                        }
                    }
                    if (FindTreeStep.func_194070_a(lllllllllllllIllIIIIIlIIIlllIIIl)) {
                        this.field_193277_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
                        return;
                    }
                }
            }
            if ((this.field_193279_f >= 600 || this.field_193280_g > 3) && this.field_193278_e == null) {
                this.field_193278_e = new TutorialToast(TutorialToast.Icons.TREE, PunchTreeStep.field_193275_b, PunchTreeStep.field_193276_c, true);
                this.field_193277_d.func_193295_e().func_193033_an().func_192988_a(this.field_193278_e);
            }
        }
    }
}
