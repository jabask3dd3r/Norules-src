package net.minecraft.network.login.server;

import net.minecraft.network.login.*;
import java.security.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.util.*;

public class SPacketEncryptionRequest implements Packet<INetHandlerLoginClient>
{
    private /* synthetic */ String hashedServerId;
    private /* synthetic */ PublicKey publicKey;
    private /* synthetic */ byte[] verifyToken;
    
    @Override
    public void processPacket(final INetHandlerLoginClient llllllllllllllllllIlllIllIllIlII) {
        llllllllllllllllllIlllIllIllIlII.handleEncryptionRequest(this);
    }
    
    public String getServerId() {
        return this.hashedServerId;
    }
    
    public PublicKey getPublicKey() {
        return this.publicKey;
    }
    
    public SPacketEncryptionRequest(final String llllllllllllllllllIlllIlllIIllII, final PublicKey llllllllllllllllllIlllIlllIIIlll, final byte[] llllllllllllllllllIlllIlllIIIllI) {
        this.hashedServerId = llllllllllllllllllIlllIlllIIllII;
        this.publicKey = llllllllllllllllllIlllIlllIIIlll;
        this.verifyToken = llllllllllllllllllIlllIlllIIIllI;
    }
    
    public SPacketEncryptionRequest() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllllllIlllIllIlllIlI) throws IOException {
        llllllllllllllllllIlllIllIlllIlI.writeString(this.hashedServerId);
        llllllllllllllllllIlllIllIlllIlI.writeByteArray(this.publicKey.getEncoded());
        llllllllllllllllllIlllIllIlllIlI.writeByteArray(this.verifyToken);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllllllIlllIlllIIIIlI) throws IOException {
        this.hashedServerId = llllllllllllllllllIlllIlllIIIIlI.readStringFromBuffer(20);
        this.publicKey = CryptManager.decodePublicKey(llllllllllllllllllIlllIlllIIIIlI.readByteArray());
        this.verifyToken = llllllllllllllllllIlllIlllIIIIlI.readByteArray();
    }
    
    public byte[] getVerifyToken() {
        return this.verifyToken;
    }
}
