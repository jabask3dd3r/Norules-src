package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import de.gerrygames.viarewind.api.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.connection.*;
import de.gerrygames.viarewind.*;

public class Cooldown extends StoredObject implements Tickable
{
    private /* synthetic */ long lastHit;
    private /* synthetic */ boolean lastSend;
    private /* synthetic */ UUID bossUUID;
    private /* synthetic */ double attackSpeed;
    private final /* synthetic */ ViaRewindConfig.CooldownIndicator cooldownIndicator;
    
    private void sendBossBar(final float llllllllllllllIIllIllIlllIlIIIlI) {
        final PacketWrapper llllllllllllllIIllIllIlllIlIIlII = PacketWrapper.create(12, null, this.getUser());
        if (this.bossUUID == null) {
            this.bossUUID = UUID.randomUUID();
            llllllllllllllIIllIllIlllIlIIlII.write(Type.UUID, this.bossUUID);
            llllllllllllllIIllIllIlllIlIIlII.write(Type.VAR_INT, 0);
            llllllllllllllIIllIllIlllIlIIlII.write(Type.STRING, "{\"text\":\"  \"}");
            llllllllllllllIIllIllIlllIlIIlII.write(Type.FLOAT, llllllllllllllIIllIllIlllIlIIIlI);
            llllllllllllllIIllIllIlllIlIIlII.write(Type.VAR_INT, 0);
            llllllllllllllIIllIllIlllIlIIlII.write(Type.VAR_INT, 0);
            llllllllllllllIIllIllIlllIlIIlII.write(Type.UNSIGNED_BYTE, (Short)0);
        }
        else {
            llllllllllllllIIllIllIlllIlIIlII.write(Type.UUID, this.bossUUID);
            llllllllllllllIIllIllIlllIlIIlII.write(Type.VAR_INT, 2);
            llllllllllllllIIllIllIlllIlIIlII.write(Type.FLOAT, llllllllllllllIIllIllIlllIlIIIlI);
        }
        PacketUtil.sendPacket(llllllllllllllIIllIllIlllIlIIlII, Protocol1_8TO1_9.class, false, true);
    }
    
    private void sendActionBar(final String llllllllllllllIIllIllIllIllllIll) {
        final PacketWrapper llllllllllllllIIllIllIllIllllIlI = PacketWrapper.create(2, null, this.getUser());
        llllllllllllllIIllIllIllIllllIlI.write(Type.STRING, llllllllllllllIIllIllIllIllllIll);
        llllllllllllllIIllIllIllIllllIlI.write(Type.BYTE, (Byte)2);
        PacketUtil.sendPacket(llllllllllllllIIllIllIllIllllIlI, Protocol1_8TO1_9.class);
    }
    
    public void setAttackSpeed(final double llllllllllllllIIllIllIllIIlllIlI, final ArrayList<Pair<Byte, Double>> llllllllllllllIIllIllIllIIllIllI) {
        this.attackSpeed = llllllllllllllIIllIllIllIIlllIlI;
        for (int llllllllllllllIIllIllIllIIlllllI = 0; llllllllllllllIIllIllIllIIlllllI < llllllllllllllIIllIllIllIIllIllI.size(); ++llllllllllllllIIllIllIllIIlllllI) {
            if (llllllllllllllIIllIllIllIIllIllI.get(llllllllllllllIIllIllIllIIlllllI).getKey() == 0) {
                this.attackSpeed += llllllllllllllIIllIllIllIIllIllI.get(llllllllllllllIIllIllIllIIlllllI).getValue();
                llllllllllllllIIllIllIllIIllIllI.remove(llllllllllllllIIllIllIllIIlllllI--);
            }
        }
        for (int llllllllllllllIIllIllIllIIllllIl = 0; llllllllllllllIIllIllIllIIllllIl < llllllllllllllIIllIllIllIIllIllI.size(); ++llllllllllllllIIllIllIllIIllllIl) {
            if (llllllllllllllIIllIllIllIIllIllI.get(llllllllllllllIIllIllIllIIllllIl).getKey() == 1) {
                this.attackSpeed += llllllllllllllIIllIllIllIIlllIlI * llllllllllllllIIllIllIllIIllIllI.get(llllllllllllllIIllIllIllIIllllIl).getValue();
                llllllllllllllIIllIllIllIIllIllI.remove(llllllllllllllIIllIllIllIIllllIl--);
            }
        }
        for (int llllllllllllllIIllIllIllIIllllII = 0; llllllllllllllIIllIllIllIIllllII < llllllllllllllIIllIllIllIIllIllI.size(); ++llllllllllllllIIllIllIllIIllllII) {
            if (llllllllllllllIIllIllIllIIllIllI.get(llllllllllllllIIllIllIllIIllllII).getKey() == 2) {
                this.attackSpeed *= 1.0 + llllllllllllllIIllIllIllIIllIllI.get(llllllllllllllIIllIllIllIIllllII).getValue();
                llllllllllllllIIllIllIllIIllIllI.remove(llllllllllllllIIllIllIllIIllllII--);
            }
        }
    }
    
    private void showCooldown() {
        if (this.cooldownIndicator == ViaRewindConfig.CooldownIndicator.TITLE) {
            this.sendTitle("", this.getTitle(), 0, 2, 5);
        }
        else if (this.cooldownIndicator == ViaRewindConfig.CooldownIndicator.ACTION_BAR) {
            this.sendActionBar(this.getTitle());
        }
        else if (this.cooldownIndicator == ViaRewindConfig.CooldownIndicator.BOSS_BAR) {
            this.sendBossBar((float)this.getCooldown());
        }
    }
    
    private void hideBossBar() {
        if (this.bossUUID == null) {
            return;
        }
        final PacketWrapper llllllllllllllIIllIllIlllIlIllII = PacketWrapper.create(12, null, this.getUser());
        llllllllllllllIIllIllIlllIlIllII.write(Type.UUID, this.bossUUID);
        llllllllllllllIIllIllIlllIlIllII.write(Type.VAR_INT, 1);
        PacketUtil.sendPacket(llllllllllllllIIllIllIlllIlIllII, Protocol1_8TO1_9.class, false, true);
        this.bossUUID = null;
    }
    
    public double getCooldown() {
        final long llllllllllllllIIllIllIllIllIlIlI = System.currentTimeMillis() - this.lastHit;
        return this.restrain(llllllllllllllIIllIllIllIllIlIlI * this.attackSpeed / 1000.0, 0.0, 1.0);
    }
    
    private double restrain(final double llllllllllllllIIllIllIllIllIIIII, final double llllllllllllllIIllIllIllIllIIIlI, final double llllllllllllllIIllIllIllIlIllllI) {
        if (llllllllllllllIIllIllIllIllIIIII < llllllllllllllIIllIllIllIllIIIlI) {
            return llllllllllllllIIllIllIllIllIIIlI;
        }
        if (llllllllllllllIIllIllIllIllIIIII > llllllllllllllIIllIllIllIlIllllI) {
            return llllllllllllllIIllIllIllIlIllllI;
        }
        return llllllllllllllIIllIllIllIllIIIII;
    }
    
    public Cooldown(final UserConnection llllllllllllllIIllIllIllllIIIIIl) {
        super(llllllllllllllIIllIllIllllIIIIIl);
        this.attackSpeed = 4.0;
        this.lastHit = 0L;
        ViaRewindConfig.CooldownIndicator llllllllllllllIIllIllIllllIIIIII = null;
        try {
            final ViaRewindConfig.CooldownIndicator llllllllllllllIIllIllIllllIIIlII = ViaRewind.getConfig().getCooldownIndicator();
        }
        catch (IllegalArgumentException llllllllllllllIIllIllIllllIIIIll) {
            ViaRewind.getPlatform().getLogger().warning("Invalid cooldown-indicator setting");
            llllllllllllllIIllIllIllllIIIIII = ViaRewindConfig.CooldownIndicator.DISABLED;
        }
        this.cooldownIndicator = llllllllllllllIIllIllIllllIIIIII;
    }
    
    static {
        max = 10;
    }
    
    public boolean hasCooldown() {
        final long llllllllllllllIIllIllIllIlllIIlI = System.currentTimeMillis() - this.lastHit;
        final double llllllllllllllIIllIllIllIlllIIIl = this.restrain(llllllllllllllIIllIllIllIlllIIlI * this.attackSpeed / 1000.0, 0.0, 1.5);
        return llllllllllllllIIllIllIllIlllIIIl > 0.1 && llllllllllllllIIllIllIllIlllIIIl < 1.1;
    }
    
    public double getAttackSpeed() {
        return this.attackSpeed;
    }
    
    private void hideTitle() {
        final PacketWrapper llllllllllllllIIllIllIlllIIlllIl = PacketWrapper.create(69, null, this.getUser());
        llllllllllllllIIllIllIlllIIlllIl.write(Type.VAR_INT, 3);
        PacketUtil.sendPacket(llllllllllllllIIllIllIlllIIlllIl, Protocol1_8TO1_9.class);
    }
    
    private void sendTitle(final String llllllllllllllIIllIllIlllIIIIlll, final String llllllllllllllIIllIllIlllIIIllll, final int llllllllllllllIIllIllIlllIIIIlIl, final int llllllllllllllIIllIllIlllIIIIlII, final int llllllllllllllIIllIllIlllIIIllII) {
        final PacketWrapper llllllllllllllIIllIllIlllIIIlIll = PacketWrapper.create(69, null, this.getUser());
        llllllllllllllIIllIllIlllIIIlIll.write(Type.VAR_INT, 2);
        llllllllllllllIIllIllIlllIIIlIll.write(Type.INT, llllllllllllllIIllIllIlllIIIIlIl);
        llllllllllllllIIllIllIlllIIIlIll.write(Type.INT, llllllllllllllIIllIllIlllIIIIlII);
        llllllllllllllIIllIllIlllIIIlIll.write(Type.INT, llllllllllllllIIllIllIlllIIIllII);
        final PacketWrapper llllllllllllllIIllIllIlllIIIlIlI = PacketWrapper.create(69, null, this.getUser());
        llllllllllllllIIllIllIlllIIIlIlI.write(Type.VAR_INT, 0);
        llllllllllllllIIllIllIlllIIIlIlI.write(Type.STRING, llllllllllllllIIllIllIlllIIIIlll);
        final PacketWrapper llllllllllllllIIllIllIlllIIIlIIl = PacketWrapper.create(69, null, this.getUser());
        llllllllllllllIIllIllIlllIIIlIIl.write(Type.VAR_INT, 1);
        llllllllllllllIIllIllIlllIIIlIIl.write(Type.STRING, llllllllllllllIIllIllIlllIIIllll);
        PacketUtil.sendPacket(llllllllllllllIIllIllIlllIIIlIlI, Protocol1_8TO1_9.class);
        PacketUtil.sendPacket(llllllllllllllIIllIllIlllIIIlIIl, Protocol1_8TO1_9.class);
        PacketUtil.sendPacket(llllllllllllllIIllIllIlllIIIlIll, Protocol1_8TO1_9.class);
    }
    
    public void setLastHit(final long llllllllllllllIIllIllIllIIlIllII) {
        this.lastHit = llllllllllllllIIllIllIllIIlIllII;
    }
    
    private void hide() {
        if (this.cooldownIndicator == ViaRewindConfig.CooldownIndicator.ACTION_BAR) {
            this.sendActionBar("§r");
        }
        else if (this.cooldownIndicator == ViaRewindConfig.CooldownIndicator.TITLE) {
            this.hideTitle();
        }
        else if (this.cooldownIndicator == ViaRewindConfig.CooldownIndicator.BOSS_BAR) {
            this.hideBossBar();
        }
    }
    
    private String getTitle() {
        final String llllllllllllllIIllIllIllIlIlIllI = (this.cooldownIndicator == ViaRewindConfig.CooldownIndicator.ACTION_BAR) ? "\u25a0" : "\u02d9";
        final double llllllllllllllIIllIllIllIlIlIlIl = this.getCooldown();
        int llllllllllllllIIllIllIllIlIlIlII = (int)Math.floor(10.0 * llllllllllllllIIllIllIllIlIlIlIl);
        int llllllllllllllIIllIllIllIlIlIIll = 10 - llllllllllllllIIllIllIllIlIlIlII;
        final StringBuilder llllllllllllllIIllIllIllIlIlIIlI = new StringBuilder("§8");
        while (llllllllllllllIIllIllIllIlIlIlII-- > 0) {
            llllllllllllllIIllIllIllIlIlIIlI.append(llllllllllllllIIllIllIllIlIlIllI);
        }
        llllllllllllllIIllIllIllIlIlIIlI.append("§7");
        while (llllllllllllllIIllIllIllIlIlIIll-- > 0) {
            llllllllllllllIIllIllIllIlIlIIlI.append(llllllllllllllIIllIllIllIlIlIllI);
        }
        return String.valueOf(llllllllllllllIIllIllIllIlIlIIlI);
    }
    
    @Override
    public void tick() {
        if (!this.hasCooldown()) {
            if (this.lastSend) {
                this.hide();
                this.lastSend = false;
            }
            return;
        }
        final BlockPlaceDestroyTracker llllllllllllllIIllIllIlllIlllIII = this.getUser().get(BlockPlaceDestroyTracker.class);
        if (llllllllllllllIIllIllIlllIlllIII.isMining()) {
            this.lastHit = 0L;
            if (this.lastSend) {
                this.hide();
                this.lastSend = false;
            }
            return;
        }
        this.showCooldown();
        this.lastSend = true;
    }
    
    public void hit() {
        this.lastHit = System.currentTimeMillis();
    }
    
    public void setAttackSpeed(final double llllllllllllllIIllIllIllIlIIIIll) {
        this.attackSpeed = llllllllllllllIIllIllIllIlIIIIll;
    }
}
