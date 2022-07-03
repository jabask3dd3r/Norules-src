package net.minecraft.client.gui;

import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.network.play.server.*;

public class BossInfoClient extends BossInfo
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
    protected /* synthetic */ long percentSetTime;
    protected /* synthetic */ float rawPercent;
    
    @Override
    public float getPercent() {
        final long llllllllllllllIlIlIIlIIIIIllIlIl = Minecraft.getSystemTime() - this.percentSetTime;
        final float llllllllllllllIlIlIIlIIIIIllIlII = MathHelper.clamp(llllllllllllllIlIlIIlIIIIIllIlIl / 100.0f, 0.0f, 1.0f);
        return this.percent + (this.rawPercent - this.percent) * llllllllllllllIlIlIIlIIIIIllIlII;
    }
    
    public BossInfoClient(final SPacketUpdateBossInfo llllllllllllllIlIlIIlIIIIlIIIIII) {
        super(llllllllllllllIlIlIIlIIIIlIIIIII.getUniqueId(), llllllllllllllIlIlIIlIIIIlIIIIII.getName(), llllllllllllllIlIlIIlIIIIlIIIIII.getColor(), llllllllllllllIlIlIIlIIIIlIIIIII.getOverlay());
        this.rawPercent = llllllllllllllIlIlIIlIIIIlIIIIII.getPercent();
        this.percent = llllllllllllllIlIlIIlIIIIlIIIIII.getPercent();
        this.percentSetTime = Minecraft.getSystemTime();
        this.setDarkenSky(llllllllllllllIlIlIIlIIIIlIIIIII.shouldDarkenSky());
        this.setPlayEndBossMusic(llllllllllllllIlIlIIlIIIIlIIIIII.shouldPlayEndBossMusic());
        this.setCreateFog(llllllllllllllIlIlIIlIIIIlIIIIII.shouldCreateFog());
    }
    
    public void updateFromPacket(final SPacketUpdateBossInfo llllllllllllllIlIlIIlIIIIIlIlIll) {
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation()[llllllllllllllIlIlIIlIIIIIlIlIll.getOperation().ordinal()]) {
            case 4: {
                this.setName(llllllllllllllIlIlIIlIIIIIlIlIll.getName());
                break;
            }
            case 3: {
                this.setPercent(llllllllllllllIlIlIIlIIIIIlIlIll.getPercent());
                break;
            }
            case 5: {
                this.setColor(llllllllllllllIlIlIIlIIIIIlIlIll.getColor());
                this.setOverlay(llllllllllllllIlIlIIlIIIIIlIlIll.getOverlay());
                break;
            }
            case 6: {
                this.setDarkenSky(llllllllllllllIlIlIIlIIIIIlIlIll.shouldDarkenSky());
                this.setPlayEndBossMusic(llllllllllllllIlIlIIlIIIIIlIlIll.shouldPlayEndBossMusic());
                break;
            }
        }
    }
    
    @Override
    public void setPercent(final float llllllllllllllIlIlIIlIIIIIllllII) {
        this.percent = this.getPercent();
        this.rawPercent = llllllllllllllIlIlIIlIIIIIllllII;
        this.percentSetTime = Minecraft.getSystemTime();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation = BossInfoClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation;
        }
        final int llllllllllllllIlIlIIlIIIIIlIlIIl = (Object)new int[SPacketUpdateBossInfo.Operation.values().length];
        try {
            llllllllllllllIlIlIIlIIIIIlIlIIl[SPacketUpdateBossInfo.Operation.ADD.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIlIIlIIIIIlIlIIl[SPacketUpdateBossInfo.Operation.REMOVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIlIIlIIIIIlIlIIl[SPacketUpdateBossInfo.Operation.UPDATE_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlIlIIlIIIIIlIlIIl[SPacketUpdateBossInfo.Operation.UPDATE_PCT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIlIlIIlIIIIIlIlIIl[SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIlIlIIlIIIIIlIlIIl[SPacketUpdateBossInfo.Operation.UPDATE_STYLE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BossInfoClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketUpdateBossInfo$Operation = (int[])(Object)llllllllllllllIlIlIIlIIIIIlIlIIl;
    }
}
