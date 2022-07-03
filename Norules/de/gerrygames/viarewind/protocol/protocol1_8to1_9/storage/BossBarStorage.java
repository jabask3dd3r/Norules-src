package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import de.gerrygames.viarewind.protocol.protocol1_8to1_9.bossbar.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.*;

public class BossBarStorage extends StoredObject
{
    private /* synthetic */ Map<UUID, WitherBossBar> bossBars;
    
    public void updateHealth(final UUID lllllllllllllIlIIIllIlIIllIIIllI, final float lllllllllllllIlIIIllIlIIlIllllII) {
        final WitherBossBar lllllllllllllIlIIIllIlIIllIIIIlI = this.bossBars.get(lllllllllllllIlIIIllIlIIllIIIllI);
        if (lllllllllllllIlIIIllIlIIllIIIIlI == null) {
            return;
        }
        lllllllllllllIlIIIllIlIIllIIIIlI.setHealth(lllllllllllllIlIIIllIlIIlIllllII);
    }
    
    public void changeWorld() {
        this.bossBars.values().forEach(lllllllllllllIlIIIllIlIIlIIllllI -> {
            lllllllllllllIlIIIllIlIIlIIllllI.hide();
            lllllllllllllIlIIIllIlIIlIIllllI.show();
        });
    }
    
    public void updateTitle(final UUID lllllllllllllIlIIIllIlIIlIlIIIll, final String lllllllllllllIlIIIllIlIIlIlIIIlI) {
        final WitherBossBar lllllllllllllIlIIIllIlIIlIlIIlIl = this.bossBars.get(lllllllllllllIlIIIllIlIIlIlIIIll);
        if (lllllllllllllIlIIIllIlIIlIlIIlIl == null) {
            return;
        }
        lllllllllllllIlIIIllIlIIlIlIIlIl.setTitle(lllllllllllllIlIIIllIlIIlIlIIIlI);
    }
    
    public void add(final UUID lllllllllllllIlIIIllIlIIllllllII, final String lllllllllllllIlIIIllIlIIlllllIll, final float lllllllllllllIlIIIllIlIIlllllIIl) {
        final WitherBossBar lllllllllllllIlIIIllIlIIllllllll = new WitherBossBar(this.getUser(), lllllllllllllIlIIIllIlIIllllllII, lllllllllllllIlIIIllIlIIlllllIll, lllllllllllllIlIIIllIlIIlllllIIl);
        final PlayerPosition lllllllllllllIlIIIllIlIIlllllllI = this.getUser().get(PlayerPosition.class);
        lllllllllllllIlIIIllIlIIllllllll.setPlayerLocation(lllllllllllllIlIIIllIlIIlllllllI.getPosX(), lllllllllllllIlIIIllIlIIlllllllI.getPosY(), lllllllllllllIlIIIllIlIIlllllllI.getPosZ(), lllllllllllllIlIIIllIlIIlllllllI.getYaw(), lllllllllllllIlIIIllIlIIlllllllI.getPitch());
        lllllllllllllIlIIIllIlIIllllllll.show();
        this.bossBars.put(lllllllllllllIlIIIllIlIIllllllII, lllllllllllllIlIIIllIlIIllllllll);
    }
    
    public void remove(final UUID lllllllllllllIlIIIllIlIIllIlllll) {
        final WitherBossBar lllllllllllllIlIIIllIlIIlllIIIll = this.bossBars.remove(lllllllllllllIlIIIllIlIIllIlllll);
        if (lllllllllllllIlIIIllIlIIlllIIIll == null) {
            return;
        }
        lllllllllllllIlIIIllIlIIlllIIIll.hide();
    }
    
    public BossBarStorage(final UserConnection lllllllllllllIlIIIllIlIlIIIlIlIl) {
        super(lllllllllllllIlIIIllIlIlIIIlIlIl);
        this.bossBars = new HashMap<UUID, WitherBossBar>();
    }
    
    public void updateLocation() {
        final PlayerPosition lllllllllllllIlIIIllIlIIllIllIlI = this.getUser().get(PlayerPosition.class);
        final PlayerPosition playerPosition;
        this.bossBars.values().forEach(lllllllllllllIlIIIllIlIIlIIllIlI -> lllllllllllllIlIIIllIlIIlIIllIlI.setPlayerLocation(playerPosition.getPosX(), playerPosition.getPosY(), playerPosition.getPosZ(), playerPosition.getYaw(), playerPosition.getPitch()));
    }
}
