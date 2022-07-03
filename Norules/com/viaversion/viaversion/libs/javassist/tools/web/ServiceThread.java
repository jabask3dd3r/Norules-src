package com.viaversion.viaversion.libs.javassist.tools.web;

import java.net.*;
import java.io.*;

class ServiceThread extends Thread
{
    /* synthetic */ Webserver web;
    /* synthetic */ Socket sock;
    
    @Override
    public void run() {
        try {
            this.web.process(this.sock);
        }
        catch (IOException ex) {}
    }
    
    public ServiceThread(final Webserver lllllllllllllIlllIlllIlIIIllIlIl, final Socket lllllllllllllIlllIlllIlIIIllIlll) {
        this.web = lllllllllllllIlllIlllIlIIIllIlIl;
        this.sock = lllllllllllllIlllIlllIlIIIllIlll;
    }
}
