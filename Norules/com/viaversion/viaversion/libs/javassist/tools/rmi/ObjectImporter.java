package com.viaversion.viaversion.libs.javassist.tools.rmi;

import java.applet.*;
import java.net.*;
import java.io.*;
import java.lang.reflect.*;

public class ObjectImporter implements Serializable
{
    private /* synthetic */ int orgPort;
    protected /* synthetic */ byte[] rmiCommand;
    private /* synthetic */ int port;
    private final /* synthetic */ byte[] endofline;
    protected /* synthetic */ byte[] lookupCommand;
    private static final /* synthetic */ Class<?>[] proxyConstructorParamTypes;
    private /* synthetic */ String orgServername;
    private /* synthetic */ String servername;
    
    public ObjectImporter(final Applet lllllllllllllIlIlIIllllIIllIIIII) {
        this.endofline = new byte[] { 13, 10 };
        this.lookupCommand = "POST /lookup HTTP/1.0".getBytes();
        this.rmiCommand = "POST /rmi HTTP/1.0".getBytes();
        final URL lllllllllllllIlIlIIllllIIlIlllll = lllllllllllllIlIlIIllllIIllIIIII.getCodeBase();
        final String host = lllllllllllllIlIlIIllllIIlIlllll.getHost();
        this.servername = host;
        this.orgServername = host;
        final int port = lllllllllllllIlIlIIllllIIlIlllll.getPort();
        this.port = port;
        this.orgPort = port;
    }
    
    public ObjectImporter(final String lllllllllllllIlIlIIllllIIlIlIlII, final int lllllllllllllIlIlIIllllIIlIlIllI) {
        this.endofline = new byte[] { 13, 10 };
        this.lookupCommand = "POST /lookup HTTP/1.0".getBytes();
        this.rmiCommand = "POST /rmi HTTP/1.0".getBytes();
        this.servername = lllllllllllllIlIlIIllllIIlIlIlII;
        this.orgServername = lllllllllllllIlIlIIllllIIlIlIlII;
        this.port = lllllllllllllIlIlIIllllIIlIlIllI;
        this.orgPort = lllllllllllllIlIlIIllllIIlIlIllI;
    }
    
    private void writeParameters(final ObjectOutputStream lllllllllllllIlIlIIlllIlllIlIIII, final Object[] lllllllllllllIlIlIIlllIlllIIllll) throws IOException {
        final int lllllllllllllIlIlIIlllIlllIIlllI = lllllllllllllIlIlIIlllIlllIIllll.length;
        lllllllllllllIlIlIIlllIlllIlIIII.writeInt(lllllllllllllIlIlIIlllIlllIIlllI);
        for (int lllllllllllllIlIlIIlllIlllIlIIlI = 0; lllllllllllllIlIlIIlllIlllIlIIlI < lllllllllllllIlIlIIlllIlllIIlllI; ++lllllllllllllIlIlIIlllIlllIlIIlI) {
            if (lllllllllllllIlIlIIlllIlllIIllll[lllllllllllllIlIlIIlllIlllIlIIlI] instanceof Proxy) {
                final Proxy lllllllllllllIlIlIIlllIlllIlIIll = (Proxy)lllllllllllllIlIlIIlllIlllIIllll[lllllllllllllIlIlIIlllIlllIlIIlI];
                lllllllllllllIlIlIIlllIlllIlIIII.writeObject(new RemoteRef(lllllllllllllIlIlIIlllIlllIlIIll._getObjectId()));
            }
            else {
                lllllllllllllIlIlIIlllIlllIlIIII.writeObject(lllllllllllllIlIlIIlllIlllIIllll[lllllllllllllIlIlIIlllIlllIlIIlI]);
            }
        }
    }
    
    public void setHttpProxy(final String lllllllllllllIlIlIIllllIIIlllllI, final int lllllllllllllIlIlIIllllIIIllllIl) {
        final String lllllllllllllIlIlIIllllIIlIIIIIl = String.valueOf(new StringBuilder().append("POST http://").append(this.orgServername).append(":").append(this.orgPort));
        String lllllllllllllIlIlIIllllIIlIIIIII = String.valueOf(new StringBuilder().append(lllllllllllllIlIlIIllllIIlIIIIIl).append("/lookup HTTP/1.0"));
        this.lookupCommand = lllllllllllllIlIlIIllllIIlIIIIII.getBytes();
        lllllllllllllIlIlIIllllIIlIIIIII = String.valueOf(new StringBuilder().append(lllllllllllllIlIlIIllllIIlIIIIIl).append("/rmi HTTP/1.0"));
        this.rmiCommand = lllllllllllllIlIlIIllllIIlIIIIII.getBytes();
        this.servername = lllllllllllllIlIlIIllllIIIlllllI;
        this.port = lllllllllllllIlIlIIllllIIIllllIl;
    }
    
    private void skipHeader(final InputStream lllllllllllllIlIlIIlllIlllIlllIl) throws IOException {
        int lllllllllllllIlIlIIlllIlllIlllII;
        do {
            lllllllllllllIlIlIIlllIlllIlllII = 0;
            int lllllllllllllIlIlIIlllIlllIlllll;
            while ((lllllllllllllIlIlIIlllIlllIlllll = lllllllllllllIlIlIIlllIlllIlllIl.read()) >= 0 && lllllllllllllIlIlIIlllIlllIlllll != 13) {
                ++lllllllllllllIlIlIIlllIlllIlllII;
            }
            lllllllllllllIlIlIIlllIlllIlllIl.read();
        } while (lllllllllllllIlIlIIlllIlllIlllII > 0);
    }
    
    public Object lookupObject(final String lllllllllllllIlIlIIllllIIIlIlIII) throws ObjectNotFoundException {
        try {
            final Socket lllllllllllllIlIlIIllllIIIllIIIl = new Socket(this.servername, this.port);
            final OutputStream lllllllllllllIlIlIIllllIIIllIIII = lllllllllllllIlIlIIllllIIIllIIIl.getOutputStream();
            lllllllllllllIlIlIIllllIIIllIIII.write(this.lookupCommand);
            lllllllllllllIlIlIIllllIIIllIIII.write(this.endofline);
            lllllllllllllIlIlIIllllIIIllIIII.write(this.endofline);
            final ObjectOutputStream lllllllllllllIlIlIIllllIIIlIllll = new ObjectOutputStream(lllllllllllllIlIlIIllllIIIllIIII);
            lllllllllllllIlIlIIllllIIIlIllll.writeUTF(lllllllllllllIlIlIIllllIIIlIlIII);
            lllllllllllllIlIlIIllllIIIlIllll.flush();
            final InputStream lllllllllllllIlIlIIllllIIIlIlllI = new BufferedInputStream(lllllllllllllIlIlIIllllIIIllIIIl.getInputStream());
            this.skipHeader(lllllllllllllIlIlIIllllIIIlIlllI);
            final ObjectInputStream lllllllllllllIlIlIIllllIIIlIllIl = new ObjectInputStream(lllllllllllllIlIlIIllllIIIlIlllI);
            final int lllllllllllllIlIlIIllllIIIlIllII = lllllllllllllIlIlIIllllIIIlIllIl.readInt();
            final String lllllllllllllIlIlIIllllIIIlIlIll = lllllllllllllIlIlIIllllIIIlIllIl.readUTF();
            lllllllllllllIlIlIIllllIIIlIllIl.close();
            lllllllllllllIlIlIIllllIIIlIllll.close();
            lllllllllllllIlIlIIllllIIIllIIIl.close();
            if (lllllllllllllIlIlIIllllIIIlIllII >= 0) {
                return this.createProxy(lllllllllllllIlIlIIllllIIIlIllII, lllllllllllllIlIlIIllllIIIlIlIll);
            }
        }
        catch (Exception lllllllllllllIlIlIIllllIIIlIlIlI) {
            lllllllllllllIlIlIIllllIIIlIlIlI.printStackTrace();
            throw new ObjectNotFoundException(lllllllllllllIlIlIIllllIIIlIlIII, lllllllllllllIlIlIIllllIIIlIlIlI);
        }
        throw new ObjectNotFoundException(lllllllllllllIlIlIIllllIIIlIlIII);
    }
    
    static {
        proxyConstructorParamTypes = new Class[] { ObjectImporter.class, Integer.TYPE };
    }
    
    public Object getObject(final String lllllllllllllIlIlIIllllIIlIIlIll) {
        try {
            return this.lookupObject(lllllllllllllIlIlIIllllIIlIIlIll);
        }
        catch (ObjectNotFoundException lllllllllllllIlIlIIllllIIlIIllll) {
            return null;
        }
    }
    
    private Object createProxy(final int lllllllllllllIlIlIIllllIIIIlIIll, final String lllllllllllllIlIlIIllllIIIIlIIlI) throws Exception {
        final Class<?> lllllllllllllIlIlIIllllIIIIlIllI = Class.forName(lllllllllllllIlIlIIllllIIIIlIIlI);
        final Constructor<?> lllllllllllllIlIlIIllllIIIIlIlIl = lllllllllllllIlIlIIllllIIIIlIllI.getConstructor(ObjectImporter.proxyConstructorParamTypes);
        return lllllllllllllIlIlIIllllIIIIlIlIl.newInstance(this, lllllllllllllIlIlIIllllIIIIlIIll);
    }
    
    public Object call(final int lllllllllllllIlIlIIlllIllllIlllI, final int lllllllllllllIlIlIIlllIlllllIlII, final Object[] lllllllllllllIlIlIIlllIlllllIIll) throws RemoteException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* lllllllllllllIlIlIIlllIlllllIllI */
        //     5: getfield        com/viaversion/viaversion/libs/javassist/tools/rmi/ObjectImporter.servername:Ljava/lang/String;
        //     8: aload_0         /* lllllllllllllIlIlIIlllIlllllIllI */
        //     9: getfield        com/viaversion/viaversion/libs/javassist/tools/rmi/ObjectImporter.port:I
        //    12: invokespecial   java/net/Socket.<init>:(Ljava/lang/String;I)V
        //    15: astore          lllllllllllllIlIlIIllllIIIIIIIIl
        //    17: new             Ljava/io/BufferedOutputStream;
        //    20: dup            
        //    21: aload           lllllllllllllIlIlIIllllIIIIIIIIl
        //    23: invokevirtual   java/net/Socket.getOutputStream:()Ljava/io/OutputStream;
        //    26: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    29: astore          lllllllllllllIlIlIIllllIIIIIIIII
        //    31: aload           lllllllllllllIlIlIIllllIIIIIIIII
        //    33: aload_0         /* lllllllllllllIlIlIIlllIlllllIllI */
        //    34: getfield        com/viaversion/viaversion/libs/javassist/tools/rmi/ObjectImporter.rmiCommand:[B
        //    37: invokevirtual   java/io/OutputStream.write:([B)V
        //    40: aload           lllllllllllllIlIlIIllllIIIIIIIII
        //    42: aload_0         /* lllllllllllllIlIlIIlllIlllllIllI */
        //    43: getfield        com/viaversion/viaversion/libs/javassist/tools/rmi/ObjectImporter.endofline:[B
        //    46: invokevirtual   java/io/OutputStream.write:([B)V
        //    49: aload           lllllllllllllIlIlIIllllIIIIIIIII
        //    51: aload_0         /* lllllllllllllIlIlIIlllIlllllIllI */
        //    52: getfield        com/viaversion/viaversion/libs/javassist/tools/rmi/ObjectImporter.endofline:[B
        //    55: invokevirtual   java/io/OutputStream.write:([B)V
        //    58: new             Ljava/io/ObjectOutputStream;
        //    61: dup            
        //    62: aload           lllllllllllllIlIlIIllllIIIIIIIII
        //    64: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    67: astore          lllllllllllllIlIlIIlllIlllllllll
        //    69: aload           lllllllllllllIlIlIIlllIlllllllll
        //    71: iload_1         /* lllllllllllllIlIlIIlllIlllllIlIl */
        //    72: invokevirtual   java/io/ObjectOutputStream.writeInt:(I)V
        //    75: aload           lllllllllllllIlIlIIlllIlllllllll
        //    77: iload_2         /* lllllllllllllIlIlIIlllIllllIllIl */
        //    78: invokevirtual   java/io/ObjectOutputStream.writeInt:(I)V
        //    81: aload_0         /* lllllllllllllIlIlIIlllIlllllIllI */
        //    82: aload           lllllllllllllIlIlIIlllIlllllllll
        //    84: aload_3         /* lllllllllllllIlIlIIlllIllllIllII */
        //    85: invokespecial   com/viaversion/viaversion/libs/javassist/tools/rmi/ObjectImporter.writeParameters:(Ljava/io/ObjectOutputStream;[Ljava/lang/Object;)V
        //    88: aload           lllllllllllllIlIlIIlllIlllllllll
        //    90: invokevirtual   java/io/ObjectOutputStream.flush:()V
        //    93: new             Ljava/io/BufferedInputStream;
        //    96: dup            
        //    97: aload           lllllllllllllIlIlIIllllIIIIIIIIl
        //    99: invokevirtual   java/net/Socket.getInputStream:()Ljava/io/InputStream;
        //   102: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //   105: astore          lllllllllllllIlIlIIlllIllllllllI
        //   107: aload_0         /* lllllllllllllIlIlIIlllIlllllIllI */
        //   108: aload           lllllllllllllIlIlIIlllIllllllllI
        //   110: invokespecial   com/viaversion/viaversion/libs/javassist/tools/rmi/ObjectImporter.skipHeader:(Ljava/io/InputStream;)V
        //   113: new             Ljava/io/ObjectInputStream;
        //   116: dup            
        //   117: aload           lllllllllllllIlIlIIlllIllllllllI
        //   119: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //   122: astore          lllllllllllllIlIlIIlllIlllllllIl
        //   124: aload           lllllllllllllIlIlIIlllIlllllllIl
        //   126: invokevirtual   java/io/ObjectInputStream.readBoolean:()Z
        //   129: istore          lllllllllllllIlIlIIlllIlllllllII
        //   131: aconst_null    
        //   132: astore          lllllllllllllIlIlIIlllIllllllIll
        //   134: aconst_null    
        //   135: astore          lllllllllllllIlIlIIlllIllllllIlI
        //   137: iload           lllllllllllllIlIlIIlllIlllllllII
        //   139: ifeq            152
        //   142: aload           lllllllllllllIlIlIIlllIlllllllIl
        //   144: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //   147: astore          lllllllllllllIlIlIIlllIllllllIll
        //   149: goto            159
        //   152: aload           lllllllllllllIlIlIIlllIlllllllIl
        //   154: invokevirtual   java/io/ObjectInputStream.readUTF:()Ljava/lang/String;
        //   157: astore          lllllllllllllIlIlIIlllIllllllIlI
        //   159: aload           lllllllllllllIlIlIIlllIlllllllIl
        //   161: invokevirtual   java/io/ObjectInputStream.close:()V
        //   164: aload           lllllllllllllIlIlIIlllIlllllllll
        //   166: invokevirtual   java/io/ObjectOutputStream.close:()V
        //   169: aload           lllllllllllllIlIlIIllllIIIIIIIIl
        //   171: invokevirtual   java/net/Socket.close:()V
        //   174: aload           lllllllllllllIlIlIIlllIllllllIll
        //   176: instanceof      Lcom/viaversion/viaversion/libs/javassist/tools/rmi/RemoteRef;
        //   179: ifeq            205
        //   182: aload           lllllllllllllIlIlIIlllIllllllIll
        //   184: checkcast       Lcom/viaversion/viaversion/libs/javassist/tools/rmi/RemoteRef;
        //   187: astore          lllllllllllllIlIlIIllllIIIIIIIlI
        //   189: aload_0         /* lllllllllllllIlIlIIlllIlllllIllI */
        //   190: aload           lllllllllllllIlIlIIllllIIIIIIIlI
        //   192: getfield        com/viaversion/viaversion/libs/javassist/tools/rmi/RemoteRef.oid:I
        //   195: aload           lllllllllllllIlIlIIllllIIIIIIIlI
        //   197: getfield        com/viaversion/viaversion/libs/javassist/tools/rmi/RemoteRef.classname:Ljava/lang/String;
        //   200: invokespecial   com/viaversion/viaversion/libs/javassist/tools/rmi/ObjectImporter.createProxy:(ILjava/lang/String;)Ljava/lang/Object;
        //   203: astore          lllllllllllllIlIlIIlllIllllllIll
        //   205: goto            244
        //   208: astore          lllllllllllllIlIlIIlllIllllllIIl
        //   210: new             Lcom/viaversion/viaversion/libs/javassist/tools/rmi/RemoteException;
        //   213: dup            
        //   214: aload           lllllllllllllIlIlIIlllIllllllIIl
        //   216: invokespecial   com/viaversion/viaversion/libs/javassist/tools/rmi/RemoteException.<init>:(Ljava/lang/Exception;)V
        //   219: athrow         
        //   220: astore          lllllllllllllIlIlIIlllIllllllIII
        //   222: new             Lcom/viaversion/viaversion/libs/javassist/tools/rmi/RemoteException;
        //   225: dup            
        //   226: aload           lllllllllllllIlIlIIlllIllllllIII
        //   228: invokespecial   com/viaversion/viaversion/libs/javassist/tools/rmi/RemoteException.<init>:(Ljava/lang/Exception;)V
        //   231: athrow         
        //   232: astore          lllllllllllllIlIlIIlllIlllllIlll
        //   234: new             Lcom/viaversion/viaversion/libs/javassist/tools/rmi/RemoteException;
        //   237: dup            
        //   238: aload           lllllllllllllIlIlIIlllIlllllIlll
        //   240: invokespecial   com/viaversion/viaversion/libs/javassist/tools/rmi/RemoteException.<init>:(Ljava/lang/Exception;)V
        //   243: athrow         
        //   244: iload           lllllllllllllIlIlIIlllIlllllIIlI
        //   246: ifeq            252
        //   249: aload           lllllllllllllIlIlIIlllIlllllIIIl
        //   251: areturn        
        //   252: new             Lcom/viaversion/viaversion/libs/javassist/tools/rmi/RemoteException;
        //   255: dup            
        //   256: aload           lllllllllllllIlIlIIlllIlllllIIII
        //   258: invokespecial   com/viaversion/viaversion/libs/javassist/tools/rmi/RemoteException.<init>:(Ljava/lang/String;)V
        //   261: athrow         
        //    Exceptions:
        //  throws com.viaversion.viaversion.libs.javassist.tools.rmi.RemoteException
        //    StackMapTable: 00 08 FF 00 98 00 0C 07 00 02 01 01 07 01 7D 01 05 05 07 00 B7 07 01 43 07 00 5E 07 00 CF 07 00 D9 00 00 FF 00 06 00 0C 07 00 02 01 01 07 01 7D 01 07 00 04 07 00 22 07 00 B7 07 01 43 07 00 5E 07 00 CF 07 00 D9 00 00 2D FF 00 02 00 04 07 00 02 01 01 07 01 7D 00 01 07 01 41 4B 07 00 5C 4B 07 00 B5 FF 00 0B 00 0C 07 00 02 01 01 07 01 7D 01 07 00 04 07 00 22 07 00 B7 07 01 43 07 00 5E 07 00 CF 07 00 D9 00 00 07
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  0      205    208    220    Ljava/lang/ClassNotFoundException;
        //  0      205    220    232    Ljava/io/IOException;
        //  0      205    232    244    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
