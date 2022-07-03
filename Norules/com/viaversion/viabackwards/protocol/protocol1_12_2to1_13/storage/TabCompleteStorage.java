package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage;

import com.viaversion.viaversion.api.connection.*;
import java.util.*;

public class TabCompleteStorage implements StorableObject
{
    private /* synthetic */ int lastId;
    private final /* synthetic */ Map<UUID, String> usernames;
    private /* synthetic */ boolean lastAssumeCommand;
    private /* synthetic */ String lastRequest;
    private final /* synthetic */ Set<String> commands;
    
    public void setLastId(final int llllllllllllllIlIIllIIIlllIIIlII) {
        this.lastId = llllllllllllllIlIIllIIIlllIIIlII;
    }
    
    public void setLastAssumeCommand(final boolean llllllllllllllIlIIllIIIllIllIIlI) {
        this.lastAssumeCommand = llllllllllllllIlIIllIIIllIllIIlI;
    }
    
    public boolean isLastAssumeCommand() {
        return this.lastAssumeCommand;
    }
    
    public int lastId() {
        return this.lastId;
    }
    
    public TabCompleteStorage() {
        this.usernames = new HashMap<UUID, String>();
        this.commands = new HashSet<String>();
    }
    
    public Map<UUID, String> usernames() {
        return this.usernames;
    }
    
    public String lastRequest() {
        return this.lastRequest;
    }
    
    public void setLastRequest(final String llllllllllllllIlIIllIIIllIlllIIl) {
        this.lastRequest = llllllllllllllIlIIllIIIllIlllIIl;
    }
    
    public Set<String> commands() {
        return this.commands;
    }
}
