package com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage;

import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.connection.*;

public class ClientWorld extends StoredObject
{
    private /* synthetic */ Environment environment;
    
    public void setEnvironment(final int lllllllllllllllIlIIlIIlIIlIIllII) {
        this.environment = Environment.getEnvironmentById(lllllllllllllllIlIIlIIlIIlIIllII);
    }
    
    public ClientWorld(final UserConnection lllllllllllllllIlIIlIIlIIlIlIlIl) {
        super(lllllllllllllllIlIIlIIlIIlIlIlIl);
    }
    
    public Environment getEnvironment() {
        return this.environment;
    }
}
