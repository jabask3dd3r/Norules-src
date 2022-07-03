package net.minecraft.client.tutorial;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.client.entity.*;
import net.minecraft.stats.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.toasts.*;

public class FindTreeStep implements ITutorialStep
{
    private /* synthetic */ TutorialToast field_193272_e;
    private final /* synthetic */ Tutorial field_193271_d;
    private /* synthetic */ int field_193273_f;
    private static final /* synthetic */ ITextComponent field_193270_c;
    private static final /* synthetic */ ITextComponent field_193269_b;
    private static final /* synthetic */ Set<Block> field_193268_a;
    
    public static boolean func_194070_a(final EntityPlayerSP lllllllllllllllllllIIIlIIlIIlIlI) {
        for (final Block lllllllllllllllllllIIIlIIlIIllII : FindTreeStep.field_193268_a) {
            final StatBase lllllllllllllllllllIIIlIIlIIlIll = StatList.getBlockStats(lllllllllllllllllllIIIlIIlIIllII);
            if (lllllllllllllllllllIIIlIIlIIlIll != null && lllllllllllllllllllIIIlIIlIIlIlI.getStatFileWriter().readStat(lllllllllllllllllllIIIlIIlIIlIll) > 0) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void func_193248_b() {
        if (this.field_193272_e != null) {
            this.field_193272_e.func_193670_a();
            this.field_193272_e = null;
        }
    }
    
    @Override
    public void func_193246_a(final WorldClient lllllllllllllllllllIIIlIIllIIIll, final RayTraceResult lllllllllllllllllllIIIlIIllIIIlI) {
        if (lllllllllllllllllllIIIlIIllIIIlI.typeOfHit == RayTraceResult.Type.BLOCK && lllllllllllllllllllIIIlIIllIIIlI.getBlockPos() != null) {
            final IBlockState lllllllllllllllllllIIIlIIllIIIIl = lllllllllllllllllllIIIlIIllIIIll.getBlockState(lllllllllllllllllllIIIlIIllIIIlI.getBlockPos());
            if (FindTreeStep.field_193268_a.contains(lllllllllllllllllllIIIlIIllIIIIl.getBlock())) {
                this.field_193271_d.func_193292_a(TutorialSteps.PUNCH_TREE);
            }
        }
    }
    
    @Override
    public void func_193252_a(final ItemStack lllllllllllllllllllIIIlIIlIlIlII) {
        for (final Block lllllllllllllllllllIIIlIIlIlIllI : FindTreeStep.field_193268_a) {
            if (lllllllllllllllllllIIIlIIlIlIlII.getItem() == Item.getItemFromBlock(lllllllllllllllllllIIIlIIlIlIllI)) {
                this.field_193271_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
            }
        }
    }
    
    static {
        field_193268_a = Sets.newHashSet((Object[])new Block[] { Blocks.LOG, Blocks.LOG2, Blocks.LEAVES, Blocks.LEAVES2 });
        field_193269_b = new TextComponentTranslation("tutorial.find_tree.title", new Object[0]);
        field_193270_c = new TextComponentTranslation("tutorial.find_tree.description", new Object[0]);
    }
    
    public FindTreeStep(final Tutorial lllllllllllllllllllIIIlIIllllIIl) {
        this.field_193271_d = lllllllllllllllllllIIIlIIllllIIl;
    }
    
    @Override
    public void func_193245_a() {
        ++this.field_193273_f;
        if (this.field_193271_d.func_194072_f() != GameType.SURVIVAL) {
            this.field_193271_d.func_193292_a(TutorialSteps.NONE);
        }
        else {
            if (this.field_193273_f == 1) {
                final EntityPlayerSP lllllllllllllllllllIIIlIIlllIIIl = this.field_193271_d.func_193295_e().player;
                if (lllllllllllllllllllIIIlIIlllIIIl != null) {
                    for (final Block lllllllllllllllllllIIIlIIlllIIII : FindTreeStep.field_193268_a) {
                        if (lllllllllllllllllllIIIlIIlllIIIl.inventory.hasItemStack(new ItemStack(lllllllllllllllllllIIIlIIlllIIII))) {
                            this.field_193271_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
                            return;
                        }
                    }
                    if (func_194070_a(lllllllllllllllllllIIIlIIlllIIIl)) {
                        this.field_193271_d.func_193292_a(TutorialSteps.CRAFT_PLANKS);
                        return;
                    }
                }
            }
            if (this.field_193273_f >= 6000 && this.field_193272_e == null) {
                this.field_193272_e = new TutorialToast(TutorialToast.Icons.TREE, FindTreeStep.field_193269_b, FindTreeStep.field_193270_c, false);
                this.field_193271_d.func_193295_e().func_193033_an().func_192988_a(this.field_193272_e);
            }
        }
    }
}
