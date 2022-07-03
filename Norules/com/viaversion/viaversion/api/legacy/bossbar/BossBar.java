package com.viaversion.viaversion.api.legacy.bossbar;

import com.viaversion.viaversion.api.connection.*;
import java.util.*;

public interface BossBar
{
    BossStyle getStyle();
    
    boolean isVisible();
    
    BossBar addConnection(final UserConnection p0);
    
    BossBar addPlayer(final UUID p0);
    
    BossBar removeFlag(final BossFlag p0);
    
    BossBar setStyle(final BossStyle p0);
    
    BossBar addFlag(final BossFlag p0);
    
    BossBar setTitle(final String p0);
    
    BossBar show();
    
    BossBar hide();
    
    BossColor getColor();
    
    BossBar removeConnection(final UserConnection p0);
    
    String getTitle();
    
    UUID getId();
    
    BossBar setHealth(final float p0);
    
    BossBar removePlayer(final UUID p0);
    
    float getHealth();
    
    BossBar setColor(final BossColor p0);
    
    Set<UserConnection> getConnections();
    
    boolean hasFlag(final BossFlag p0);
    
    Set<UUID> getPlayers();
}
