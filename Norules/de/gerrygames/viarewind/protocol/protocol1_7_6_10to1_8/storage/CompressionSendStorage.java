package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.viaversion.viaversion.api.connection.*;

public class CompressionSendStorage extends StoredObject
{
    private /* synthetic */ boolean removeCompression;
    
    public boolean isRemoveCompression() {
        return this.removeCompression;
    }
    
    public CompressionSendStorage(final UserConnection llllllllllllIlllllIIllllIIllIlll) {
        super(llllllllllllIlllllIIllllIIllIlll);
        this.removeCompression = false;
    }
    
    public void setRemoveCompression(final boolean llllllllllllIlllllIIllllIIlIlllI) {
        this.removeCompression = llllllllllllIlllllIIllllIIlIlllI;
    }
}
