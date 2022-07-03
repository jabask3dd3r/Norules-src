package net.minecraft.client.tutorial;

import javax.annotation.*;
import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.util.text.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;

public class Tutorial
{
    @Nullable
    private /* synthetic */ ITutorialStep field_193305_b;
    private final /* synthetic */ Minecraft field_193304_a;
    
    public void func_193301_a(final ItemStack lllllllllllllllIIIlIlIlIlllllIIl) {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193252_a(lllllllllllllllIIIlIlIlIlllllIIl);
        }
    }
    
    public void func_193302_c() {
        if (this.field_193305_b != null) {
            this.func_193300_b();
        }
        this.field_193305_b = this.field_193304_a.gameSettings.field_193631_S.func_193309_a(this);
    }
    
    public Tutorial(final Minecraft lllllllllllllllIIIlIlIllIIlIIllI) {
        this.field_193304_a = lllllllllllllllIIIlIlIllIIlIIllI;
    }
    
    public void func_193293_a(final MovementInput lllllllllllllllIIIlIlIllIIIllllI) {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193247_a(lllllllllllllllIIIlIlIllIIIllllI);
        }
    }
    
    public void func_193297_a(@Nullable final WorldClient lllllllllllllllIIIlIlIllIIIlIIII, @Nullable final RayTraceResult lllllllllllllllIIIlIlIllIIIIllll) {
        if (this.field_193305_b != null && lllllllllllllllIIIlIlIllIIIIllll != null && lllllllllllllllIIIlIlIllIIIlIIII != null) {
            this.field_193305_b.func_193246_a(lllllllllllllllIIIlIlIllIIIlIIII, lllllllllllllllIIIlIlIllIIIIllll);
        }
    }
    
    public void func_193296_a() {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193251_c();
        }
    }
    
    public void func_193299_a(final MouseHelper lllllllllllllllIIIlIlIllIIIllIII) {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193249_a(lllllllllllllllIIIlIlIllIIIllIII);
        }
    }
    
    public void func_193300_b() {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193248_b();
            this.field_193305_b = null;
        }
    }
    
    public GameType func_194072_f() {
        return (this.field_193304_a.playerController == null) ? GameType.NOT_SET : this.field_193304_a.playerController.getCurrentGameType();
    }
    
    public static ITextComponent func_193291_a(final String lllllllllllllllIIIlIlIlIllIlllIl) {
        final TextComponentKeybind lllllllllllllllIIIlIlIlIllIllllI = new TextComponentKeybind(String.valueOf(new StringBuilder("key.").append(lllllllllllllllIIIlIlIlIllIlllIl)));
        lllllllllllllllIIIlIlIlIllIllllI.getStyle().setBold(true);
        return lllllllllllllllIIIlIlIlIllIllllI;
    }
    
    public void func_193294_a(final WorldClient lllllllllllllllIIIlIlIllIIIIIIll, final BlockPos lllllllllllllllIIIlIlIllIIIIIIlI, final IBlockState lllllllllllllllIIIlIlIllIIIIIllI, final float lllllllllllllllIIIlIlIllIIIIIlIl) {
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193250_a(lllllllllllllllIIIlIlIllIIIIIIll, lllllllllllllllIIIlIlIllIIIIIIlI, lllllllllllllllIIIlIlIllIIIIIllI, lllllllllllllllIIIlIlIllIIIIIlIl);
        }
    }
    
    public Minecraft func_193295_e() {
        return this.field_193304_a;
    }
    
    public void func_193303_d() {
        if (this.field_193305_b != null) {
            if (this.field_193304_a.world != null) {
                this.field_193305_b.func_193245_a();
            }
            else {
                this.func_193300_b();
            }
        }
        else if (this.field_193304_a.world != null) {
            this.func_193302_c();
        }
    }
    
    public void func_193292_a(final TutorialSteps lllllllllllllllIIIlIlIlIlllIlIII) {
        this.field_193304_a.gameSettings.field_193631_S = lllllllllllllllIIIlIlIlIlllIlIII;
        this.field_193304_a.gameSettings.saveOptions();
        if (this.field_193305_b != null) {
            this.field_193305_b.func_193248_b();
            this.field_193305_b = lllllllllllllllIIIlIlIlIlllIlIII.func_193309_a(this);
        }
    }
}
