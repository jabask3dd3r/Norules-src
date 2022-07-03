package com.viaversion.viaversion.libs.javassist.util;

import java.io.*;
import java.util.*;
import com.sun.jdi.event.*;
import com.sun.jdi.request.*;
import com.sun.jdi.connect.*;
import com.sun.jdi.*;

public class HotSwapper
{
    private /* synthetic */ MethodEntryRequest request;
    private /* synthetic */ VirtualMachine jvm;
    private /* synthetic */ Map<ReferenceType, byte[]> newClassFiles;
    private /* synthetic */ Trigger trigger;
    private static final /* synthetic */ String TRIGGER_NAME;
    
    private void startDaemon() {
        new Thread() {
            @Override
            public void run() {
                EventSet lIIlllIlllIIlI = null;
                try {
                    lIIlllIlllIIlI = HotSwapper.this.waitEvent();
                    final EventIterator lIIlllIlllIllI = lIIlllIlllIIlI.eventIterator();
                    while (lIIlllIlllIllI.hasNext()) {
                        final Event lIIlllIlllIlll = lIIlllIlllIllI.nextEvent();
                        if (lIIlllIlllIlll instanceof MethodEntryEvent) {
                            HotSwapper.this.hotswap();
                            break;
                        }
                    }
                }
                catch (Throwable lIIlllIlllIlIl) {
                    this.errorMsg(lIIlllIlllIlIl);
                }
                try {
                    if (lIIlllIlllIIlI != null) {
                        lIIlllIlllIIlI.resume();
                    }
                }
                catch (Throwable lIIlllIlllIlII) {
                    this.errorMsg(lIIlllIlllIlII);
                }
            }
            
            private void errorMsg(final Throwable lIIlllIlllllII) {
                System.err.print("Exception in thread \"HotSwap\" ");
                lIIlllIlllllII.printStackTrace(System.err);
            }
        }.start();
    }
    
    public void reload(final String llllllllllllllIIIIIIllIIllIllllI, final byte[] llllllllllllllIIIIIIllIIllIlllIl) {
        final ReferenceType llllllllllllllIIIIIIllIIlllIIIIl = this.toRefType(llllllllllllllIIIIIIllIIllIllllI);
        final Map<ReferenceType, byte[]> llllllllllllllIIIIIIllIIlllIIIII = new HashMap<ReferenceType, byte[]>();
        llllllllllllllIIIIIIllIIlllIIIII.put(llllllllllllllIIIIIIllIIlllIIIIl, llllllllllllllIIIIIIllIIllIlllIl);
        this.reload2(llllllllllllllIIIIIIllIIlllIIIII, llllllllllllllIIIIIIllIIllIllllI);
    }
    
    static {
        HOST_NAME = "localhost";
        TRIGGER_NAME = Trigger.class.getName();
    }
    
    public HotSwapper(final int llllllllllllllIIIIIIllIlIIIlIlll) throws IOException, IllegalConnectorArgumentsException {
        this(Integer.toString(llllllllllllllIIIIIIllIlIIIlIlll));
    }
    
    private ReferenceType toRefType(final String llllllllllllllIIIIIIllIIllIIIlIl) {
        final List<ReferenceType> llllllllllllllIIIIIIllIIllIIIlII = (List<ReferenceType>)this.jvm.classesByName(llllllllllllllIIIIIIllIIllIIIlIl);
        if (llllllllllllllIIIIIIllIIllIIIlII == null || llllllllllllllIIIIIIllIIllIIIlII.isEmpty()) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("no such class: ").append(llllllllllllllIIIIIIllIIllIIIlIl)));
        }
        return llllllllllllllIIIIIIllIIllIIIlII.get(0);
    }
    
    private void reload2(final Map<ReferenceType, byte[]> llllllllllllllIIIIIIllIIlIlllIII, final String llllllllllllllIIIIIIllIIlIllIlll) {
        synchronized (this.trigger) {
            this.startDaemon();
            this.newClassFiles = llllllllllllllIIIIIIllIIlIlllIII;
            this.request.enable();
            this.trigger.doSwap();
            this.request.disable();
            final Map<ReferenceType, byte[]> llllllllllllllIIIIIIllIIlIlllIlI = this.newClassFiles;
            if (llllllllllllllIIIIIIllIIlIlllIlI != null) {
                this.newClassFiles = null;
                throw new RuntimeException(String.valueOf(new StringBuilder().append("failed to reload: ").append(llllllllllllllIIIIIIllIIlIllIlll)));
            }
        }
    }
    
    void hotswap() {
        final Map<ReferenceType, byte[]> llllllllllllllIIIIIIllIIlIlIIlII = this.newClassFiles;
        this.jvm.redefineClasses((Map)llllllllllllllIIIIIIllIIlIlIIlII);
        this.newClassFiles = null;
    }
    
    EventSet waitEvent() throws InterruptedException {
        final EventQueue llllllllllllllIIIIIIllIIlIlIlIlI = this.jvm.eventQueue();
        return llllllllllllllIIIIIIllIIlIlIlIlI.remove();
    }
    
    private void deleteEventRequest(final EventRequestManager llllllllllllllIIIIIIllIIlllIllIl, final MethodEntryRequest llllllllllllllIIIIIIllIIlllIllII) {
        llllllllllllllIIIIIIllIIlllIllIl.deleteEventRequest((EventRequest)llllllllllllllIIIIIIllIIlllIllII);
    }
    
    public HotSwapper(final String llllllllllllllIIIIIIllIlIIIIlIIl) throws IOException, IllegalConnectorArgumentsException {
        this.jvm = null;
        this.request = null;
        this.newClassFiles = null;
        this.trigger = new Trigger();
        final AttachingConnector llllllllllllllIIIIIIllIlIIIIllIl = (AttachingConnector)this.findConnector("com.sun.jdi.SocketAttach");
        final Map<String, Connector.Argument> llllllllllllllIIIIIIllIlIIIIllII = (Map<String, Connector.Argument>)llllllllllllllIIIIIIllIlIIIIllIl.defaultArguments();
        llllllllllllllIIIIIIllIlIIIIllII.get("hostname").setValue("localhost");
        llllllllllllllIIIIIIllIlIIIIllII.get("port").setValue(llllllllllllllIIIIIIllIlIIIIlIIl);
        this.jvm = llllllllllllllIIIIIIllIlIIIIllIl.attach((Map)llllllllllllllIIIIIIllIlIIIIllII);
        final EventRequestManager llllllllllllllIIIIIIllIlIIIIlIll = this.jvm.eventRequestManager();
        this.request = methodEntryRequests(llllllllllllllIIIIIIllIlIIIIlIll, HotSwapper.TRIGGER_NAME);
    }
    
    private Connector findConnector(final String llllllllllllllIIIIIIllIIllllllll) throws IOException {
        final List<Connector> llllllllllllllIIIIIIllIIlllllllI = (List<Connector>)Bootstrap.virtualMachineManager().allConnectors();
        for (final Connector llllllllllllllIIIIIIllIlIIIIIIIl : llllllllllllllIIIIIIllIIlllllllI) {
            if (llllllllllllllIIIIIIllIlIIIIIIIl.name().equals(llllllllllllllIIIIIIllIIllllllll)) {
                return llllllllllllllIIIIIIllIlIIIIIIIl;
            }
        }
        throw new IOException(String.valueOf(new StringBuilder().append("Not found: ").append(llllllllllllllIIIIIIllIIllllllll)));
    }
    
    public void reload(final Map<String, byte[]> llllllllllllllIIIIIIllIIllIlIIlI) {
        final Map<ReferenceType, byte[]> llllllllllllllIIIIIIllIIllIlIIIl = new HashMap<ReferenceType, byte[]>();
        String llllllllllllllIIIIIIllIIllIlIIII = null;
        for (final Map.Entry<String, byte[]> llllllllllllllIIIIIIllIIllIlIlII : llllllllllllllIIIIIIllIIllIlIIlI.entrySet()) {
            llllllllllllllIIIIIIllIIllIlIIII = llllllllllllllIIIIIIllIIllIlIlII.getKey();
            llllllllllllllIIIIIIllIIllIlIIIl.put(this.toRefType(llllllllllllllIIIIIIllIIllIlIIII), llllllllllllllIIIIIIllIIllIlIlII.getValue());
        }
        if (llllllllllllllIIIIIIllIIllIlIIII != null) {
            this.reload2(llllllllllllllIIIIIIllIIllIlIIIl, String.valueOf(new StringBuilder().append(llllllllllllllIIIIIIllIIllIlIIII).append(" etc.")));
        }
    }
    
    private static MethodEntryRequest methodEntryRequests(final EventRequestManager llllllllllllllIIIIIIllIIllllIIll, final String llllllllllllllIIIIIIllIIllllIIlI) {
        final MethodEntryRequest llllllllllllllIIIIIIllIIllllIlII = llllllllllllllIIIIIIllIIllllIIll.createMethodEntryRequest();
        llllllllllllllIIIIIIllIIllllIlII.addClassFilter(llllllllllllllIIIIIIllIIllllIIlI);
        llllllllllllllIIIIIIllIIllllIlII.setSuspendPolicy(1);
        return llllllllllllllIIIIIIllIIllllIlII;
    }
}
