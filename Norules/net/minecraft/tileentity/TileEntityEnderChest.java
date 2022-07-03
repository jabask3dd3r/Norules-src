package net.minecraft.tileentity;

import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class TileEntityEnderChest extends TileEntity implements ITickable
{
    public /* synthetic */ float lidAngle;
    private /* synthetic */ int ticksSinceSync;
    public /* synthetic */ int numPlayersUsing;
    public /* synthetic */ float prevLidAngle;
    
    @Override
    public void invalidate() {
        this.updateContainingBlockInfo();
        super.invalidate();
    }
    
    public boolean canBeUsed(final EntityPlayer lllllllllllllllIIIIlIIIIlllIIIll) {
        return this.world.getTileEntity(this.pos) == this && lllllllllllllllIIIIlIIIIlllIIIll.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void update() {
        if (++this.ticksSinceSync % 20 * 4 == 0) {
            this.world.addBlockEvent(this.pos, Blocks.ENDER_CHEST, 1, this.numPlayersUsing);
        }
        this.prevLidAngle = this.lidAngle;
        final int lllllllllllllllIIIIlIIIlIIlllIII = this.pos.getX();
        final int lllllllllllllllIIIIlIIIlIIllIllI = this.pos.getY();
        final int lllllllllllllllIIIIlIIIlIIllIlII = this.pos.getZ();
        final float lllllllllllllllIIIIlIIIlIIllIIlI = 0.1f;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0f) {
            final double lllllllllllllllIIIIlIIIlIIllIIII = lllllllllllllllIIIIlIIIlIIlllIII + 0.5;
            final double lllllllllllllllIIIIlIIIlIIlIlllI = lllllllllllllllIIIIlIIIlIIllIlII + 0.5;
            this.world.playSound(null, lllllllllllllllIIIIlIIIlIIllIIII, lllllllllllllllIIIIlIIIlIIllIllI + 0.5, lllllllllllllllIIIIlIIIlIIlIlllI, SoundEvents.BLOCK_ENDERCHEST_OPEN, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
        }
        if ((this.numPlayersUsing == 0 && this.lidAngle > 0.0f) || (this.numPlayersUsing > 0 && this.lidAngle < 1.0f)) {
            final float lllllllllllllllIIIIlIIIlIIlIllII = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1f;
            }
            else {
                this.lidAngle -= 0.1f;
            }
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            final float lllllllllllllllIIIIlIIIlIIlIlIlI = 0.5f;
            if (this.lidAngle < 0.5f && lllllllllllllllIIIIlIIIlIIlIllII >= 0.5f) {
                final double lllllllllllllllIIIIlIIIlIIlIlIII = lllllllllllllllIIIIlIIIlIIlllIII + 0.5;
                final double lllllllllllllllIIIIlIIIlIIlIIllI = lllllllllllllllIIIIlIIIlIIllIlII + 0.5;
                this.world.playSound(null, lllllllllllllllIIIIlIIIlIIlIlIII, lllllllllllllllIIIIlIIIlIIllIllI + 0.5, lllllllllllllllIIIIlIIIlIIlIIllI, SoundEvents.BLOCK_ENDERCHEST_CLOSE, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }
    
    public void openChest() {
        ++this.numPlayersUsing;
        this.world.addBlockEvent(this.pos, Blocks.ENDER_CHEST, 1, this.numPlayersUsing);
    }
    
    @Override
    public boolean receiveClientEvent(final int lllllllllllllllIIIIlIIIlIIIIllII, final int lllllllllllllllIIIIlIIIlIIIIlllI) {
        if (lllllllllllllllIIIIlIIIlIIIIllII == 1) {
            this.numPlayersUsing = lllllllllllllllIIIIlIIIlIIIIlllI;
            return true;
        }
        return super.receiveClientEvent(lllllllllllllllIIIIlIIIlIIIIllII, lllllllllllllllIIIIlIIIlIIIIlllI);
    }
    
    public void closeChest() {
        --this.numPlayersUsing;
        this.world.addBlockEvent(this.pos, Blocks.ENDER_CHEST, 1, this.numPlayersUsing);
    }
}
