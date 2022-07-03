package me.nrules.module.combat;

import clickui.settings.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import me.nrules.event.events.*;
import me.nrules.event.*;
import net.minecraft.util.math.*;
import java.util.function.*;
import net.minecraft.init.*;
import com.mojang.realmsclient.gui.*;
import me.nrules.*;
import me.nrules.module.*;
import java.util.*;
import com.kisman.nr.cc.util.*;
import net.minecraft.util.*;

public class AutoTrap extends Module
{
    private /* synthetic */ boolean isSneaking;
    private /* synthetic */ Setting antiStep;
    private /* synthetic */ BlockPos startPos;
    private /* synthetic */ Map<BlockPos, Integer> retries;
    private /* synthetic */ Setting rotate;
    private /* synthetic */ int placements;
    public /* synthetic */ EntityPlayer target;
    public static /* synthetic */ AutoTrap instance;
    private /* synthetic */ boolean smartRotate;
    private /* synthetic */ Setting raytrace;
    private /* synthetic */ TimerUtils timer;
    private /* synthetic */ boolean isPlacing;
    private /* synthetic */ Setting disableOnComplete;
    private /* synthetic */ boolean didPlace;
    private /* synthetic */ TimerUtils retryTimer;
    private /* synthetic */ Setting range;
    private /* synthetic */ int oldSlot;
    private /* synthetic */ Setting antiScaffold;
    private /* synthetic */ Setting blocksPerTick;
    private /* synthetic */ Setting placeDelay;
    private /* synthetic */ Setting surroundPlacing;
    
    @Override
    public void onDisable() {
        this.isPlacing = false;
        this.isSneaking = EntityUtil.stopSneaking(this.isSneaking);
    }
    
    private boolean isValidTarget(final Entity lllllllllllllIIlIIIllIIlIIlIIIll) {
        return lllllllllllllIIlIIIllIIlIIlIIIll != null && lllllllllllllIIlIIIllIIlIIlIIIll instanceof EntityLivingBase && !lllllllllllllIIlIIIllIIlIIlIIIll.isDead && ((EntityLivingBase)lllllllllllllIIlIIIllIIlIIlIIIll).getHealth() > 0.0f && lllllllllllllIIlIIIllIIlIIlIIIll.getDistanceToEntity(AutoTrap.mc.player) <= this.range.getValDouble() && lllllllllllllIIlIIIllIIlIIlIIIll instanceof EntityPlayer && lllllllllllllIIlIIIllIIlIIlIIIll != AutoTrap.mc.player;
    }
    
    private void doTrap() {
        if (this.check()) {
            return;
        }
        this.doStaticTrap();
        if (this.didPlace) {
            this.timer.reset();
        }
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIlIIIllIIlIllIIIlI) {
        if (AutoTrap.mc.player == null && AutoTrap.mc.world == null) {
            return;
        }
        this.smartRotate = false;
        this.doTrap();
    }
    
    private void placeList(final List<Vec3d> lllllllllllllIIlIIIllIIlIlIIlIll) {
        lllllllllllllIIlIIIllIIlIlIIlIll.sort((lllllllllllllIIlIIIllIIlIIlIIIII, lllllllllllllIIlIIIllIIlIIIlllll) -> Double.compare(AutoTrap.mc.player.getDistanceSq(lllllllllllllIIlIIIllIIlIIIlllll.xCoord, lllllllllllllIIlIIIllIIlIIIlllll.yCoord, lllllllllllllIIlIIIllIIlIIIlllll.zCoord), AutoTrap.mc.player.getDistanceSq(lllllllllllllIIlIIIllIIlIIlIIIII.xCoord, lllllllllllllIIlIIIllIIlIIlIIIII.yCoord, lllllllllllllIIlIIIllIIlIIlIIIII.zCoord)));
        lllllllllllllIIlIIIllIIlIlIIlIll.sort(Comparator.comparingDouble(lllllllllllllIIlIIIllIIlIIIllIll -> lllllllllllllIIlIIIllIIlIIIllIll.yCoord));
        for (final Vec3d lllllllllllllIIlIIIllIIlIlIIllll : lllllllllllllIIlIIIllIIlIlIIlIll) {
            final BlockPos lllllllllllllIIlIIIllIIlIlIIlllI = new BlockPos(lllllllllllllIIlIIIllIIlIlIIllll);
            final int lllllllllllllIIlIIIllIIlIlIIllIl = BlockUtil.isPositionPlaceable(lllllllllllllIIlIIIllIIlIlIIlllI, this.raytrace.getValBoolean(), true);
            if (lllllllllllllIIlIIIllIIlIlIIllIl == 1 && (this.retries.get(lllllllllllllIIlIIIllIIlIlIIlllI) == null || this.retries.get(lllllllllllllIIlIIIllIIlIlIIlllI) < 4)) {
                this.placeBlock(lllllllllllllIIlIIIllIIlIlIIlllI);
                this.retries.put(lllllllllllllIIlIIIllIIlIlIIlllI, (this.retries.get(lllllllllllllIIlIIIllIIlIlIIlllI) == null) ? 1 : (this.retries.get(lllllllllllllIIlIIIllIIlIlIIlllI) + 1));
                this.retryTimer.reset();
            }
            else {
                if (lllllllllllllIIlIIIllIIlIlIIllIl != 3) {
                    continue;
                }
                this.placeBlock(lllllllllllllIIlIIIllIIlIlIIlllI);
            }
        }
    }
    
    @Override
    public void onEnable() {
        if (AutoTrap.mc.player == null && AutoTrap.mc.world == null) {
            return;
        }
        this.startPos = EntityUtil.getRoundedBlockPos(AutoTrap.mc.player);
        this.oldSlot = AutoTrap.mc.player.inventory.currentItem;
        this.retries.clear();
    }
    
    private EntityLivingBase getNearTarget(final EntityPlayer lllllllllllllIIlIIIllIIlIIlIlIll) {
        return AutoTrap.mc.world.loadedEntityList.stream().filter(lllllllllllllIIlIIIllIIlIIIlIllI -> this.isValidTarget(lllllllllllllIIlIIIllIIlIIIlIllI)).map(lllllllllllllIIlIIIllIIlIIIlIIlI -> lllllllllllllIIlIIIllIIlIIIlIIlI).min(Comparator.comparing((Function<? super EntityLivingBase, ? extends Comparable>)lllllllllllllIIlIIIllIIlIIlIlIll::getDistanceToEntity)).orElse(null);
    }
    
    private boolean check() {
        if (AutoTrap.mc.player == null) {
            return false;
        }
        if (this.startPos == null) {
            return false;
        }
        this.isPlacing = false;
        this.didPlace = false;
        this.placements = 0;
        final int lllllllllllllIIlIIIllIIlIlIIIIlI = InventoryUtil.findBlock(Blocks.OBSIDIAN, 0, 9);
        if (lllllllllllllIIlIIIllIIlIlIIIIlI == -1) {
            this.setToggled(false);
        }
        final int lllllllllllllIIlIIIllIIlIlIIIIIl = InventoryUtil.findBlock(Blocks.OBSIDIAN, 0, 9);
        if (!super.isToggled()) {
            return true;
        }
        if (!this.startPos.equals(EntityUtil.getRoundedBlockPos(AutoTrap.mc.player))) {
            this.setToggled(false);
            return true;
        }
        if (this.retryTimer.passedMillis(2000L)) {
            this.retries.clear();
            this.retryTimer.reset();
        }
        if (lllllllllllllIIlIIIllIIlIlIIIIIl == -1) {
            Main.msg(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("No Obsidian in hotbar, AutoTrap disabling...")));
            this.setToggled(false);
            return true;
        }
        if (AutoTrap.mc.player.inventory.currentItem != this.oldSlot && AutoTrap.mc.player.inventory.currentItem != lllllllllllllIIlIIIllIIlIlIIIIIl) {
            this.oldSlot = AutoTrap.mc.player.inventory.currentItem;
        }
        this.isSneaking = EntityUtil.stopSneaking(this.isSneaking);
        this.target = (EntityPlayer)this.getNearTarget(AutoTrap.mc.player);
        return this.target == null || !this.timer.passedMillis(this.placeDelay.getValInt());
    }
    
    public AutoTrap() {
        super("AutoTrap", 0, Category.COMBAT);
        this.disableOnComplete = new Setting("DisableOnComplete", this, false);
        this.placeDelay = new Setting("Delay", this, 50.0, 0.0, 100.0, true);
        this.rotate = new Setting("Rotate", this, true);
        this.blocksPerTick = new Setting("BlocksPerTick", this, 8.0, 1.0, 30.0, true);
        this.antiScaffold = new Setting("AntiScaffold", this, false);
        this.antiStep = new Setting("AntiStep", this, false);
        this.surroundPlacing = new Setting("SurroundPlacing", this, true);
        this.range = new Setting("Range", this, 4.0, 1.0, 5.0, false);
        this.raytrace = new Setting("RayTrace", this, false);
        this.timer = new TimerUtils();
        this.retries = new HashMap<BlockPos, Integer>();
        this.retryTimer = new TimerUtils();
        this.didPlace = false;
        this.placements = 0;
        this.smartRotate = false;
        this.startPos = null;
        super.setToggled(false);
        AutoTrap.instance = this;
        AutoTrap.sm.Property(this.disableOnComplete);
        AutoTrap.sm.Property(this.placeDelay);
        AutoTrap.sm.Property(this.rotate);
        AutoTrap.sm.Property(this.blocksPerTick);
        AutoTrap.sm.Property(this.antiScaffold);
        AutoTrap.sm.Property(this.antiStep);
        AutoTrap.sm.Property(this.surroundPlacing);
        AutoTrap.sm.Property(this.range);
        AutoTrap.sm.Property(this.raytrace);
    }
    
    private void doStaticTrap() {
        final List<Vec3d> lllllllllllllIIlIIIllIIlIlIllIlI = BlockUtil.targets(this.target.getPositionVector(), this.antiScaffold.getValBoolean(), this.antiStep.getValBoolean(), this.surroundPlacing.getValBoolean(), false, false, this.raytrace.getValBoolean());
        this.placeList(lllllllllllllIIlIIIllIIlIlIllIlI);
    }
    
    private void placeBlock(final BlockPos lllllllllllllIIlIIIllIIlIIllIIlI) {
        if (this.placements < this.blocksPerTick.getValInt() && AutoTrap.mc.player.getDistanceSq(lllllllllllllIIlIIIllIIlIIllIIlI) <= MathUtil.square(5.0)) {
            this.isPlacing = true;
            final int lllllllllllllIIlIIIllIIlIIllIllI = AutoTrap.mc.player.inventory.currentItem;
            final int lllllllllllllIIlIIIllIIlIIllIlIl = InventoryUtil.findBlock(Blocks.OBSIDIAN, 0, 9);
            final int lllllllllllllIIlIIIllIIlIIllIlII = InventoryUtil.findBlock(Blocks.ENDER_CHEST, 0, 9);
            if (lllllllllllllIIlIIIllIIlIIllIlIl == -1 && lllllllllllllIIlIIIllIIlIIllIlII == -1) {
                this.toggle();
            }
            if (this.smartRotate) {
                AutoTrap.mc.player.inventory.currentItem = ((lllllllllllllIIlIIIllIIlIIllIlIl == -1) ? lllllllllllllIIlIIIllIIlIIllIlII : lllllllllllllIIlIIIllIIlIIllIlIl);
                AutoTrap.mc.playerController.updateController();
                this.isSneaking = BlockUtil.placeBlockSmartRotate(lllllllllllllIIlIIIllIIlIIllIIlI, EnumHand.MAIN_HAND, this.rotate.getValBoolean(), true, this.isSneaking);
                AutoTrap.mc.player.inventory.currentItem = lllllllllllllIIlIIIllIIlIIllIllI;
                AutoTrap.mc.playerController.updateController();
            }
            else {
                AutoTrap.mc.player.inventory.currentItem = ((lllllllllllllIIlIIIllIIlIIllIlIl == -1) ? lllllllllllllIIlIIIllIIlIIllIlII : lllllllllllllIIlIIIllIIlIIllIlIl);
                AutoTrap.mc.playerController.updateController();
                this.isSneaking = BlockUtil.placeBlockSmartRotate(lllllllllllllIIlIIIllIIlIIllIIlI, EnumHand.MAIN_HAND, this.rotate.getValBoolean(), this.rotate.getValBoolean(), this.isSneaking);
                AutoTrap.mc.player.inventory.currentItem = lllllllllllllIIlIIIllIIlIIllIllI;
                AutoTrap.mc.playerController.updateController();
            }
            this.didPlace = true;
            ++this.placements;
        }
    }
}
