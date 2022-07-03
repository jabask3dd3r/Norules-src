package com.viaversion.viaversion.libs.javassist.tools.rmi;

import java.io.*;
import java.util.*;
import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.tools.web.*;

public class AppletServer extends Webserver
{
    private static final /* synthetic */ byte[] okHeader;
    private /* synthetic */ StubGenerator stubGen;
    private /* synthetic */ Map<String, ExportedObject> exportedNames;
    private /* synthetic */ List<ExportedObject> exportedObjects;
    
    static {
        okHeader = "HTTP/1.0 200 OK\r\n\r\n".getBytes();
    }
    
    public synchronized int exportObject(final String lllllllllllllIlIIlIIIIIllIIIIIll, final Object lllllllllllllIlIIlIIIIIlIlllllIl) throws CannotCompileException {
        final Class<?> lllllllllllllIlIIlIIIIIllIIIIIIl = lllllllllllllIlIIlIIIIIlIlllllIl.getClass();
        final ExportedObject lllllllllllllIlIIlIIIIIllIIIIIII = new ExportedObject();
        lllllllllllllIlIIlIIIIIllIIIIIII.object = lllllllllllllIlIIlIIIIIlIlllllIl;
        lllllllllllllIlIIlIIIIIllIIIIIII.methods = lllllllllllllIlIIlIIIIIllIIIIIIl.getMethods();
        this.exportedObjects.add(lllllllllllllIlIIlIIIIIllIIIIIII);
        lllllllllllllIlIIlIIIIIllIIIIIII.identifier = this.exportedObjects.size() - 1;
        if (lllllllllllllIlIIlIIIIIllIIIIIll != null) {
            this.exportedNames.put(lllllllllllllIlIIlIIIIIllIIIIIll, lllllllllllllIlIIlIIIIIllIIIIIII);
        }
        try {
            this.stubGen.makeProxyClass(lllllllllllllIlIIlIIIIIllIIIIIIl);
        }
        catch (NotFoundException lllllllllllllIlIIlIIIIIllIIIIlIl) {
            throw new CannotCompileException(lllllllllllllIlIIlIIIIIllIIIIlIl);
        }
        return lllllllllllllIlIIlIIIIIllIIIIIII.identifier;
    }
    
    private Object convertRvalue(final Object lllllllllllllIlIIlIIIIIlIIlIllll) throws CannotCompileException {
        if (lllllllllllllIlIIlIIIIIlIIlIllll == null) {
            return null;
        }
        final String lllllllllllllIlIIlIIIIIlIIlIlllI = lllllllllllllIlIIlIIIIIlIIlIllll.getClass().getName();
        if (this.stubGen.isProxyClass(lllllllllllllIlIIlIIIIIlIIlIlllI)) {
            return new RemoteRef(this.exportObject(null, lllllllllllllIlIIlIIIIIlIIlIllll), lllllllllllllIlIIlIIIIIlIIlIlllI);
        }
        return lllllllllllllIlIIlIIIIIlIIlIllll;
    }
    
    @Override
    public void run() {
        super.run();
    }
    
    private void processRMI(final InputStream lllllllllllllIlIIlIIIIIlIlIlIlII, final OutputStream lllllllllllllIlIIlIIIIIlIlIlllII) throws IOException {
        final ObjectInputStream lllllllllllllIlIIlIIIIIlIlIllIll = new ObjectInputStream(lllllllllllllIlIIlIIIIIlIlIlIlII);
        final int lllllllllllllIlIIlIIIIIlIlIllIlI = lllllllllllllIlIIlIIIIIlIlIllIll.readInt();
        final int lllllllllllllIlIIlIIIIIlIlIllIIl = lllllllllllllIlIIlIIIIIlIlIllIll.readInt();
        Exception lllllllllllllIlIIlIIIIIlIlIllIII = null;
        Object lllllllllllllIlIIlIIIIIlIlIlIlll = null;
        try {
            final ExportedObject lllllllllllllIlIIlIIIIIlIllIIIll = this.exportedObjects.get(lllllllllllllIlIIlIIIIIlIlIllIlI);
            final Object[] lllllllllllllIlIIlIIIIIlIllIIIlI = this.readParameters(lllllllllllllIlIIlIIIIIlIlIllIll);
            lllllllllllllIlIIlIIIIIlIlIlIlll = this.convertRvalue(lllllllllllllIlIIlIIIIIlIllIIIll.methods[lllllllllllllIlIIlIIIIIlIlIllIIl].invoke(lllllllllllllIlIIlIIIIIlIllIIIll.object, lllllllllllllIlIIlIIIIIlIllIIIlI));
        }
        catch (Exception lllllllllllllIlIIlIIIIIlIllIIIIl) {
            lllllllllllllIlIIlIIIIIlIlIllIII = lllllllllllllIlIIlIIIIIlIllIIIIl;
            this.logging2(lllllllllllllIlIIlIIIIIlIllIIIIl.toString());
        }
        lllllllllllllIlIIlIIIIIlIlIlllII.write(AppletServer.okHeader);
        final ObjectOutputStream lllllllllllllIlIIlIIIIIlIlIlIllI = new ObjectOutputStream(lllllllllllllIlIIlIIIIIlIlIlllII);
        if (lllllllllllllIlIIlIIIIIlIlIllIII != null) {
            lllllllllllllIlIIlIIIIIlIlIlIllI.writeBoolean(false);
            lllllllllllllIlIIlIIIIIlIlIlIllI.writeUTF(lllllllllllllIlIIlIIIIIlIlIllIII.toString());
        }
        else {
            try {
                lllllllllllllIlIIlIIIIIlIlIlIllI.writeBoolean(true);
                lllllllllllllIlIIlIIIIIlIlIlIllI.writeObject(lllllllllllllIlIIlIIIIIlIlIlIlll);
            }
            catch (NotSerializableException lllllllllllllIlIIlIIIIIlIllIIIII) {
                this.logging2(lllllllllllllIlIIlIIIIIlIllIIIII.toString());
            }
            catch (InvalidClassException lllllllllllllIlIIlIIIIIlIlIlllll) {
                this.logging2(lllllllllllllIlIIlIIIIIlIlIlllll.toString());
            }
        }
        lllllllllllllIlIIlIIIIIlIlIlIllI.flush();
        lllllllllllllIlIIlIIIIIlIlIlIllI.close();
        lllllllllllllIlIIlIIIIIlIlIllIll.close();
    }
    
    public AppletServer(final int lllllllllllllIlIIlIIIIIllIlIIlII) throws CannotCompileException, NotFoundException, IOException {
        this(ClassPool.getDefault(), new StubGenerator(), lllllllllllllIlIIlIIIIIllIlIIlII);
    }
    
    private void lookupName(final String lllllllllllllIlIIlIIIIIlIIlIIIlI, final InputStream lllllllllllllIlIIlIIIIIlIIlIIIIl, final OutputStream lllllllllllllIlIIlIIIIIlIIIllIIl) throws IOException {
        final ObjectInputStream lllllllllllllIlIIlIIIIIlIIIlllll = new ObjectInputStream(lllllllllllllIlIIlIIIIIlIIlIIIIl);
        final String lllllllllllllIlIIlIIIIIlIIIllllI = DataInputStream.readUTF(lllllllllllllIlIIlIIIIIlIIIlllll);
        final ExportedObject lllllllllllllIlIIlIIIIIlIIIlllIl = this.exportedNames.get(lllllllllllllIlIIlIIIIIlIIIllllI);
        lllllllllllllIlIIlIIIIIlIIIllIIl.write(AppletServer.okHeader);
        final ObjectOutputStream lllllllllllllIlIIlIIIIIlIIIlllII = new ObjectOutputStream(lllllllllllllIlIIlIIIIIlIIIllIIl);
        if (lllllllllllllIlIIlIIIIIlIIIlllIl == null) {
            this.logging2(String.valueOf(new StringBuilder().append(lllllllllllllIlIIlIIIIIlIIIllllI).append("not found.")));
            lllllllllllllIlIIlIIIIIlIIIlllII.writeInt(-1);
            lllllllllllllIlIIlIIIIIlIIIlllII.writeUTF("error");
        }
        else {
            this.logging2(lllllllllllllIlIIlIIIIIlIIIllllI);
            lllllllllllllIlIIlIIIIIlIIIlllII.writeInt(lllllllllllllIlIIlIIIIIlIIIlllIl.identifier);
            lllllllllllllIlIIlIIIIIlIIIlllII.writeUTF(lllllllllllllIlIIlIIIIIlIIIlllIl.object.getClass().getName());
        }
        lllllllllllllIlIIlIIIIIlIIIlllII.flush();
        lllllllllllllIlIIlIIIIIlIIIlllII.close();
        lllllllllllllIlIIlIIIIIlIIIlllll.close();
    }
    
    public AppletServer(final int lllllllllllllIlIIlIIIIIllIIlllll, final ClassPool lllllllllllllIlIIlIIIIIllIIllllI) throws IOException, CannotCompileException, NotFoundException {
        this(new ClassPool(lllllllllllllIlIIlIIIIIllIIllllI), new StubGenerator(), lllllllllllllIlIIlIIIIIllIIlllll);
    }
    
    private Object[] readParameters(final ObjectInputStream lllllllllllllIlIIlIIIIIlIIlllIlI) throws ClassNotFoundException, IOException {
        final int lllllllllllllIlIIlIIIIIlIIllllIl = lllllllllllllIlIIlIIIIIlIIlllIlI.readInt();
        final Object[] lllllllllllllIlIIlIIIIIlIIllllII = new Object[lllllllllllllIlIIlIIIIIlIIllllIl];
        for (int lllllllllllllIlIIlIIIIIlIlIIIIII = 0; lllllllllllllIlIIlIIIIIlIlIIIIII < lllllllllllllIlIIlIIIIIlIIllllIl; ++lllllllllllllIlIIlIIIIIlIlIIIIII) {
            Object lllllllllllllIlIIlIIIIIlIlIIIIIl = lllllllllllllIlIIlIIIIIlIIlllIlI.readObject();
            if (lllllllllllllIlIIlIIIIIlIlIIIIIl instanceof RemoteRef) {
                final RemoteRef lllllllllllllIlIIlIIIIIlIlIIIIll = (RemoteRef)lllllllllllllIlIIlIIIIIlIlIIIIIl;
                final ExportedObject lllllllllllllIlIIlIIIIIlIlIIIIlI = this.exportedObjects.get(lllllllllllllIlIIlIIIIIlIlIIIIll.oid);
                lllllllllllllIlIIlIIIIIlIlIIIIIl = lllllllllllllIlIIlIIIIIlIlIIIIlI.object;
            }
            lllllllllllllIlIIlIIIIIlIIllllII[lllllllllllllIlIIlIIIIIlIlIIIIII] = lllllllllllllIlIIlIIIIIlIlIIIIIl;
        }
        return lllllllllllllIlIIlIIIIIlIIllllII;
    }
    
    private AppletServer(final ClassPool lllllllllllllIlIIlIIIIIllIIlIlIl, final StubGenerator lllllllllllllIlIIlIIIIIllIIlIIII, final int lllllllllllllIlIIlIIIIIllIIIllll) throws IOException, NotFoundException, CannotCompileException {
        super(lllllllllllllIlIIlIIIIIllIIIllll);
        this.exportedNames = new Hashtable<String, ExportedObject>();
        this.exportedObjects = new Vector<ExportedObject>();
        this.stubGen = lllllllllllllIlIIlIIIIIllIIlIIII;
        this.addTranslator(lllllllllllllIlIIlIIIIIllIIlIlIl, lllllllllllllIlIIlIIIIIllIIlIIII);
    }
    
    public AppletServer(final String lllllllllllllIlIIlIIIIIllIlIllII) throws IOException, CannotCompileException, NotFoundException {
        this(Integer.parseInt(lllllllllllllIlIIlIIIIIllIlIllII));
    }
    
    @Override
    public void doReply(final InputStream lllllllllllllIlIIlIIIIIlIlllIIII, final OutputStream lllllllllllllIlIIlIIIIIlIlllIIll, final String lllllllllllllIlIIlIIIIIlIlllIIlI) throws BadHttpRequest, IOException {
        if (lllllllllllllIlIIlIIIIIlIlllIIlI.startsWith("POST /rmi ")) {
            this.processRMI(lllllllllllllIlIIlIIIIIlIlllIIII, lllllllllllllIlIIlIIIIIlIlllIIll);
        }
        else if (lllllllllllllIlIIlIIIIIlIlllIIlI.startsWith("POST /lookup ")) {
            this.lookupName(lllllllllllllIlIIlIIIIIlIlllIIlI, lllllllllllllIlIIlIIIIIlIlllIIII, lllllllllllllIlIIlIIIIIlIlllIIll);
        }
        else {
            super.doReply(lllllllllllllIlIIlIIIIIlIlllIIII, lllllllllllllIlIIlIIIIIlIlllIIll, lllllllllllllIlIIlIIIIIlIlllIIlI);
        }
    }
}
