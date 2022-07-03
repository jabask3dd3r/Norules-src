package com.viaversion.viaversion.velocity.command;

import com.viaversion.viaversion.commands.*;
import com.velocitypowered.api.command.*;
import com.viaversion.viaversion.velocity.command.subs.*;
import com.viaversion.viaversion.api.command.*;
import java.util.*;

public class VelocityCommandHandler extends ViaCommandHandler implements SimpleCommand
{
    public void execute(final SimpleCommand.Invocation lllllllllllllIlIIIIllIIllIIlIIIl) {
        this.onCommand(new VelocityCommandSender(lllllllllllllIlIIIIllIIllIIlIIIl.source()), (String[])lllllllllllllIlIIIIllIIllIIlIIIl.arguments());
    }
    
    public VelocityCommandHandler() {
        try {
            this.registerSubCommand(new ProbeSubCmd());
        }
        catch (Exception lllllllllllllIlIIIIllIIllIIllIlI) {
            lllllllllllllIlIIIIllIIllIIllIlI.printStackTrace();
        }
    }
    
    public List<String> suggest(final SimpleCommand.Invocation lllllllllllllIlIIIIllIIllIIIlIll) {
        return this.onTabComplete(new VelocityCommandSender(lllllllllllllIlIIIIllIIllIIIlIll.source()), (String[])lllllllllllllIlIIIIllIIllIIIlIll.arguments());
    }
}
