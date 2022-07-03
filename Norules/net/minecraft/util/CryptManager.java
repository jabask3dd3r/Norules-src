package net.minecraft.util;

import org.apache.logging.log4j.*;
import javax.crypto.spec.*;
import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;

public class CryptManager
{
    private static final /* synthetic */ Logger LOGGER;
    
    public static SecretKey decryptSharedKey(final PrivateKey llllllllllllllIlIllIIIIlIllIIlll, final byte[] llllllllllllllIlIllIIIIlIllIIlIl) {
        return new SecretKeySpec(decryptData(llllllllllllllIlIllIIIIlIllIIlll, llllllllllllllIlIllIIIIlIllIIlIl), "AES");
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    private static byte[] cipherOperation(final int llllllllllllllIlIllIIIIlIlIIIlIl, final Key llllllllllllllIlIllIIIIlIlIIIlII, final byte[] llllllllllllllIlIllIIIIlIlIIIIlI) {
        try {
            return createTheCipherInstance(llllllllllllllIlIllIIIIlIlIIIlIl, llllllllllllllIlIllIIIIlIlIIIlII.getAlgorithm(), llllllllllllllIlIllIIIIlIlIIIlII).doFinal(llllllllllllllIlIllIIIIlIlIIIIlI);
        }
        catch (IllegalBlockSizeException llllllllllllllIlIllIIIIlIlIIIIIl) {
            llllllllllllllIlIllIIIIlIlIIIIIl.printStackTrace();
        }
        catch (BadPaddingException llllllllllllllIlIllIIIIlIIllllll) {
            llllllllllllllIlIllIIIIlIIllllll.printStackTrace();
        }
        CryptManager.LOGGER.error("Cipher data failed!");
        return null;
    }
    
    private static byte[] digestOperation(final String llllllllllllllIlIllIIIIllIIllIll, final byte[]... llllllllllllllIlIllIIIIllIIllIIl) {
        try {
            final MessageDigest llllllllllllllIlIllIIIIllIIlIlll = MessageDigest.getInstance(llllllllllllllIlIllIIIIllIIllIll);
            final Exception llllllllllllllIlIllIIIIllIIIlIll = (Object)llllllllllllllIlIllIIIIllIIllIIl;
            final char llllllllllllllIlIllIIIIllIIIllII = (char)llllllllllllllIlIllIIIIllIIllIIl.length;
            for (double llllllllllllllIlIllIIIIllIIIlllI = 0; llllllllllllllIlIllIIIIllIIIlllI < llllllllllllllIlIllIIIIllIIIllII; ++llllllllllllllIlIllIIIIllIIIlllI) {
                final byte[] llllllllllllllIlIllIIIIllIIlIllI = llllllllllllllIlIllIIIIllIIIlIll[llllllllllllllIlIllIIIIllIIIlllI];
                llllllllllllllIlIllIIIIllIIlIlll.update(llllllllllllllIlIllIIIIllIIlIllI);
            }
            return llllllllllllllIlIllIIIIllIIlIlll.digest();
        }
        catch (NoSuchAlgorithmException llllllllllllllIlIllIIIIllIIlIlIl) {
            llllllllllllllIlIllIIIIllIIlIlIl.printStackTrace();
            return null;
        }
    }
    
    public static Cipher createNetCipherInstance(final int llllllllllllllIlIllIIIIlIIIllIll, final Key llllllllllllllIlIllIIIIlIIIllIlI) {
        try {
            final Cipher llllllllllllllIlIllIIIIlIIIlllIl = Cipher.getInstance("AES/CFB8/NoPadding");
            llllllllllllllIlIllIIIIlIIIlllIl.init(llllllllllllllIlIllIIIIlIIIllIll, llllllllllllllIlIllIIIIlIIIllIlI, new IvParameterSpec(llllllllllllllIlIllIIIIlIIIllIlI.getEncoded()));
            return llllllllllllllIlIllIIIIlIIIlllIl;
        }
        catch (GeneralSecurityException llllllllllllllIlIllIIIIlIIIlllII) {
            throw new RuntimeException(llllllllllllllIlIllIIIIlIIIlllII);
        }
    }
    
    private static Cipher createTheCipherInstance(final int llllllllllllllIlIllIIIIlIIlIIllI, final String llllllllllllllIlIllIIIIlIIlIIlIl, final Key llllllllllllllIlIllIIIIlIIlIlIll) {
        try {
            final Cipher llllllllllllllIlIllIIIIlIIlIlIlI = Cipher.getInstance(llllllllllllllIlIllIIIIlIIlIIlIl);
            llllllllllllllIlIllIIIIlIIlIlIlI.init(llllllllllllllIlIllIIIIlIIlIIllI, llllllllllllllIlIllIIIIlIIlIlIll);
            return llllllllllllllIlIllIIIIlIIlIlIlI;
        }
        catch (InvalidKeyException llllllllllllllIlIllIIIIlIIlIlIIl) {
            llllllllllllllIlIllIIIIlIIlIlIIl.printStackTrace();
        }
        catch (NoSuchAlgorithmException llllllllllllllIlIllIIIIlIIlIlIII) {
            llllllllllllllIlIllIIIIlIIlIlIII.printStackTrace();
        }
        catch (NoSuchPaddingException llllllllllllllIlIllIIIIlIIlIIlll) {
            llllllllllllllIlIllIIIIlIIlIIlll.printStackTrace();
        }
        CryptManager.LOGGER.error("Cipher creation failed!");
        return null;
    }
    
    public static SecretKey createNewSharedKey() {
        try {
            final KeyGenerator llllllllllllllIlIllIIIIlllIlIllI = KeyGenerator.getInstance("AES");
            llllllllllllllIlIllIIIIlllIlIllI.init(128);
            return llllllllllllllIlIllIIIIlllIlIllI.generateKey();
        }
        catch (NoSuchAlgorithmException llllllllllllllIlIllIIIIlllIlIlII) {
            throw new Error(llllllllllllllIlIllIIIIlllIlIlII);
        }
    }
    
    public static KeyPair generateKeyPair() {
        try {
            final KeyPairGenerator llllllllllllllIlIllIIIIlllIIlIII = KeyPairGenerator.getInstance("RSA");
            llllllllllllllIlIllIIIIlllIIlIII.initialize(1024);
            return llllllllllllllIlIllIIIIlllIIlIII.generateKeyPair();
        }
        catch (NoSuchAlgorithmException llllllllllllllIlIllIIIIlllIIIllI) {
            llllllllllllllIlIllIIIIlllIIIllI.printStackTrace();
            CryptManager.LOGGER.error("Key pair generation failed!");
            return null;
        }
    }
    
    public static byte[] getServerIdHash(final String llllllllllllllIlIllIIIIllIlllIII, final PublicKey llllllllllllllIlIllIIIIllIllIIIl, final SecretKey llllllllllllllIlIllIIIIllIllIIII) {
        try {
            return digestOperation("SHA-1", new byte[][] { llllllllllllllIlIllIIIIllIlllIII.getBytes("ISO_8859_1"), llllllllllllllIlIllIIIIllIllIIII.getEncoded(), llllllllllllllIlIllIIIIllIllIIIl.getEncoded() });
        }
        catch (UnsupportedEncodingException llllllllllllllIlIllIIIIllIllIlII) {
            llllllllllllllIlIllIIIIllIllIlII.printStackTrace();
            return null;
        }
    }
    
    public static byte[] encryptData(final Key llllllllllllllIlIllIIIIlIlIlIlll, final byte[] llllllllllllllIlIllIIIIlIlIllIIl) {
        return cipherOperation(1, llllllllllllllIlIllIIIIlIlIlIlll, llllllllllllllIlIllIIIIlIlIllIIl);
    }
    
    public static PublicKey decodePublicKey(final byte[] llllllllllllllIlIllIIIIllIIIIIII) {
        try {
            final EncodedKeySpec llllllllllllllIlIllIIIIlIllllllI = new X509EncodedKeySpec(llllllllllllllIlIllIIIIllIIIIIII);
            final KeyFactory llllllllllllllIlIllIIIIlIlllllII = KeyFactory.getInstance("RSA");
            return llllllllllllllIlIllIIIIlIlllllII.generatePublic(llllllllllllllIlIllIIIIlIllllllI);
        }
        catch (NoSuchAlgorithmException llllllllllllllIlIllIIIIlIllllIII) {}
        catch (InvalidKeySpecException ex) {}
        CryptManager.LOGGER.error("Public key reconstitute failed!");
        return null;
    }
    
    public static byte[] decryptData(final Key llllllllllllllIlIllIIIIlIlIIllII, final byte[] llllllllllllllIlIllIIIIlIlIIlIlI) {
        return cipherOperation(2, llllllllllllllIlIllIIIIlIlIIllII, llllllllllllllIlIllIIIIlIlIIlIlI);
    }
}
