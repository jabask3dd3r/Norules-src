package net.minecraft.client.tutorial;

import net.minecraft.item.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public interface ITutorialStep
{
    default void func_193247_a(final MovementInput lllllllllllllllIlIlllllllIlIIIlI) {
    }
    
    default void func_193252_a(final ItemStack lllllllllllllllIlIlllllllIIlIlIl) {
    }
    
    default void func_193250_a(final WorldClient lllllllllllllllIlIlllllllIIllIll, final BlockPos lllllllllllllllIlIlllllllIIllIlI, final IBlockState lllllllllllllllIlIlllllllIIllIIl, final float lllllllllllllllIlIlllllllIIllIII) {
    }
    
    default void func_193245_a() {
    }
    
    default void func_193249_a(final MouseHelper lllllllllllllllIlIlllllllIlIIIII) {
    }
    
    default void func_193246_a(final WorldClient lllllllllllllllIlIlllllllIIllllI, final RayTraceResult lllllllllllllllIlIlllllllIIlllIl) {
    }
    
    default void func_193248_b() {
    }
    
    default void func_193251_c() {
    }
}
