package me.nrules.altmgr;

import net.minecraft.client.*;
import net.minecraft.util.*;
import java.net.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.*;
import net.minecraft.util.text.*;
import com.mojang.realmsclient.gui.*;

public final class AltLoginThread extends Thread
{
    private final /* synthetic */ String password;
    private final /* synthetic */ String username;
    private /* synthetic */ String status;
    private final /* synthetic */ Minecraft mc;
    
    public String getStatus() {
        return this.status;
    }
    
    private Session createSession(final String lllllllllllllllllIlIlIlIllIllIll, final String lllllllllllllllllIlIlIlIllIllIlI) {
        final YggdrasilAuthenticationService lllllllllllllllllIlIlIlIllIllllI = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        final YggdrasilUserAuthentication lllllllllllllllllIlIlIlIllIlllIl = (YggdrasilUserAuthentication)lllllllllllllllllIlIlIlIllIllllI.createUserAuthentication(Agent.MINECRAFT);
        lllllllllllllllllIlIlIlIllIlllIl.setUsername(lllllllllllllllllIlIlIlIllIllIll);
        lllllllllllllllllIlIlIlIllIlllIl.setPassword(lllllllllllllllllIlIlIlIllIllIlI);
        try {
            lllllllllllllllllIlIlIlIllIlllIl.logIn();
            return new Session(lllllllllllllllllIlIlIlIllIlllIl.getSelectedProfile().getName(), lllllllllllllllllIlIlIlIllIlllIl.getSelectedProfile().getId().toString(), lllllllllllllllllIlIlIlIllIlllIl.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException lllllllllllllllllIlIlIlIllIlllII) {
            lllllllllllllllllIlIlIlIllIlllII.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void run() {
        if (this.password.equals("")) {
            this.mc.session = new Session(this.username, "", "", "mojang");
            final Session lllllllllllllllllIlIlIlIllIlIIII = this.createSession(this.username, this.password);
            this.status = String.valueOf(new StringBuilder().append(TextFormatting.GREEN).append("Your nickname - ").append(ChatFormatting.GRAY).append(this.username));
            return;
        }
        this.status = String.valueOf(new StringBuilder().append(TextFormatting.YELLOW).append("Logging in..."));
        final Session lllllllllllllllllIlIlIlIllIIllll = this.createSession(this.username, this.password);
        if (lllllllllllllllllIlIlIlIllIIllll == null) {
            this.status = String.valueOf(new StringBuilder().append(TextFormatting.RED).append("Login failed!"));
        }
        else {
            this.status = String.valueOf(new StringBuilder().append(TextFormatting.GREEN).append("Your nickname - ").append(ChatFormatting.GRAY).append(lllllllllllllllllIlIlIlIllIIllll.getUsername()));
            this.mc.session = lllllllllllllllllIlIlIlIllIIllll;
        }
    }
    
    public AltLoginThread(final String lllllllllllllllllIlIlIlIlllIlIII, final String lllllllllllllllllIlIlIlIlllIIlll) {
        super("Alt Login Thread");
        this.mc = Minecraft.getMinecraft();
        this.username = lllllllllllllllllIlIlIlIlllIlIII;
        this.password = lllllllllllllllllIlIlIlIlllIIlll;
        this.status = String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append("Waiting..."));
    }
    
    public void setStatus(final String lllllllllllllllllIlIlIlIllIIlIIl) {
        this.status = lllllllllllllllllIlIlIlIllIIlIIl;
    }
}
