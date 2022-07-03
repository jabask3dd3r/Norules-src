package optifine;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.*;
import net.minecraft.client.network.*;
import net.minecraft.util.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class PlayerControllerOF extends PlayerControllerMP
{
    private /* synthetic */ Entity lastClickEntity;
    private /* synthetic */ boolean acting;
    private /* synthetic */ BlockPos lastClickBlockPos;
    
    @Override
    public EnumActionResult interactWithEntity(final EntityPlayer lllllllllllllllIlIlIllIIIIlIIlII, final Entity lllllllllllllllIlIlIllIIIIlIIIlI, final RayTraceResult lllllllllllllllIlIlIllIIIIIllIIl, final EnumHand lllllllllllllllIlIlIllIIIIlIIIII) {
        this.lastClickEntity = lllllllllllllllIlIlIllIIIIlIIIlI;
        return super.interactWithEntity(lllllllllllllllIlIlIllIIIIlIIlII, lllllllllllllllIlIlIllIIIIlIIIlI, lllllllllllllllIlIlIllIIIIIllIIl, lllllllllllllllIlIlIllIIIIlIIIII);
    }
    
    public PlayerControllerOF(final Minecraft lllllllllllllllIlIlIllIIIlllllll, final NetHandlerPlayClient lllllllllllllllIlIlIllIIIllllllI) {
        super(lllllllllllllllIlIlIllIIIlllllll, lllllllllllllllIlIlIllIIIllllllI);
        this.acting = false;
        this.lastClickBlockPos = null;
        this.lastClickEntity = null;
    }
    
    @Override
    public boolean onPlayerDamageBlock(final BlockPos lllllllllllllllIlIlIllIIIllIllII, final EnumFacing lllllllllllllllIlIlIllIIIllIlIll) {
        this.acting = true;
        this.lastClickBlockPos = lllllllllllllllIlIlIllIIIllIllII;
        final boolean lllllllllllllllIlIlIllIIIllIlIlI = super.onPlayerDamageBlock(lllllllllllllllIlIlIllIIIllIllII, lllllllllllllllIlIlIllIIIllIlIll);
        this.acting = false;
        return lllllllllllllllIlIlIllIIIllIlIlI;
    }
    
    public Entity getLastClickEntity() {
        return this.lastClickEntity;
    }
    
    @Override
    public EnumActionResult processRightClickBlock(final EntityPlayerSP lllllllllllllllIlIlIllIIIlIIllIl, final WorldClient lllllllllllllllIlIlIllIIIlIIIlII, final BlockPos lllllllllllllllIlIlIllIIIlIIIIll, final EnumFacing lllllllllllllllIlIlIllIIIlIIIIlI, final Vec3d lllllllllllllllIlIlIllIIIlIIlIIl, final EnumHand lllllllllllllllIlIlIllIIIlIIIIII) {
        this.acting = true;
        this.lastClickBlockPos = lllllllllllllllIlIlIllIIIlIIIIll;
        final EnumActionResult lllllllllllllllIlIlIllIIIlIIIlll = super.processRightClickBlock(lllllllllllllllIlIlIllIIIlIIllIl, lllllllllllllllIlIlIllIIIlIIIlII, lllllllllllllllIlIlIllIIIlIIIIll, lllllllllllllllIlIlIllIIIlIIIIlI, lllllllllllllllIlIlIllIIIlIIlIIl, lllllllllllllllIlIlIllIIIlIIIIII);
        this.acting = false;
        return lllllllllllllllIlIlIllIIIlIIIlll;
    }
    
    @Override
    public boolean clickBlock(final BlockPos lllllllllllllllIlIlIllIIIlllIlII, final EnumFacing lllllllllllllllIlIlIllIIIlllIIll) {
        this.acting = true;
        this.lastClickBlockPos = lllllllllllllllIlIlIllIIIlllIlII;
        final boolean lllllllllllllllIlIlIllIIIlllIllI = super.clickBlock(lllllllllllllllIlIlIllIIIlllIlII, lllllllllllllllIlIlIllIIIlllIIll);
        this.acting = false;
        return lllllllllllllllIlIlIllIIIlllIllI;
    }
    
    @Override
    public EnumActionResult interactWithEntity(final EntityPlayer lllllllllllllllIlIlIllIIIIlllIIl, final Entity lllllllllllllllIlIlIllIIIIlllIII, final EnumHand lllllllllllllllIlIlIllIIIIllIIll) {
        this.lastClickEntity = lllllllllllllllIlIlIllIIIIlllIII;
        return super.interactWithEntity(lllllllllllllllIlIlIllIIIIlllIIl, lllllllllllllllIlIlIllIIIIlllIII, lllllllllllllllIlIlIllIIIIllIIll);
    }
    
    public boolean isActing() {
        return this.acting;
    }
    
    @Override
    public EnumActionResult processRightClick(final EntityPlayer lllllllllllllllIlIlIllIIIlIllIlI, final World lllllllllllllllIlIlIllIIIlIllIIl, final EnumHand lllllllllllllllIlIlIllIIIlIllIII) {
        this.acting = true;
        final EnumActionResult lllllllllllllllIlIlIllIIIlIlllII = super.processRightClick(lllllllllllllllIlIlIllIIIlIllIlI, lllllllllllllllIlIlIllIIIlIllIIl, lllllllllllllllIlIlIllIIIlIllIII);
        this.acting = false;
        return lllllllllllllllIlIlIllIIIlIlllII;
    }
    
    public BlockPos getLastClickBlockPos() {
        return this.lastClickBlockPos;
    }
}
