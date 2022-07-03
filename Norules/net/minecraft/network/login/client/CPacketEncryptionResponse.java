package net.minecraft.network.login.client;

import net.minecraft.network.login.*;
import java.io.*;
import javax.crypto.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import java.security.*;

public class CPacketEncryptionResponse implements Packet<INetHandlerLoginServer>
{
    private /* synthetic */ byte[] verifyTokenEncrypted;
    private /* synthetic */ byte[] secretKeyEncrypted;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIIIIlIlIIllIllll) throws IOException {
        this.secretKeyEncrypted = lllllllllllllllIIIIIlIlIIllIllll.readByteArray();
        this.verifyTokenEncrypted = lllllllllllllllIIIIIlIlIIllIllll.readByteArray();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIIIIlIlIIllIlIIl) throws IOException {
        lllllllllllllllIIIIIlIlIIllIlIIl.writeByteArray(this.secretKeyEncrypted);
        lllllllllllllllIIIIIlIlIIllIlIIl.writeByteArray(this.verifyTokenEncrypted);
    }
    
    public CPacketEncryptionResponse(final SecretKey lllllllllllllllIIIIIlIlIIlllIlIl, final PublicKey lllllllllllllllIIIIIlIlIIlllIlII, final byte[] lllllllllllllllIIIIIlIlIIlllIIll) {
        this.secretKeyEncrypted = new byte[0];
        this.verifyTokenEncrypted = new byte[0];
        this.secretKeyEncrypted = CryptManager.encryptData(lllllllllllllllIIIIIlIlIIlllIlII, lllllllllllllllIIIIIlIlIIlllIlIl.getEncoded());
        this.verifyTokenEncrypted = CryptManager.encryptData(lllllllllllllllIIIIIlIlIIlllIlII, lllllllllllllllIIIIIlIlIIlllIIll);
    }
    
    @Override
    public void processPacket(final INetHandlerLoginServer lllllllllllllllIIIIIlIlIIllIIIIl) {
        lllllllllllllllIIIIIlIlIIllIIIIl.processEncryptionResponse(this);
    }
    
    public SecretKey getSecretKey(final PrivateKey lllllllllllllllIIIIIlIlIIlIllIll) {
        return CryptManager.decryptSharedKey(lllllllllllllllIIIIIlIlIIlIllIll, this.secretKeyEncrypted);
    }
    
    public byte[] getVerifyToken(final PrivateKey lllllllllllllllIIIIIlIlIIlIlIlIl) {
        return (lllllllllllllllIIIIIlIlIIlIlIlIl == null) ? this.verifyTokenEncrypted : CryptManager.decryptData(lllllllllllllllIIIIIlIlIIlIlIlIl, this.verifyTokenEncrypted);
    }
    
    public CPacketEncryptionResponse() {
        this.secretKeyEncrypted = new byte[0];
        this.verifyTokenEncrypted = new byte[0];
    }
}
