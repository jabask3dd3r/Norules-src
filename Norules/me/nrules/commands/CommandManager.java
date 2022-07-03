package me.nrules.commands;

import java.util.*;
import com.mojang.realmsclient.gui.*;
import me.nrules.*;
import me.nrules.commands.command.*;

public class CommandManager
{
    private /* synthetic */ ArrayList<Command> commands;
    
    public void addCommand(final Command llllllllllllllIIIlllllIIIlIIllII) {
        this.commands.add(llllllllllllllIIIlllllIIIlIIllII);
    }
    
    public void callCommand(final String llllllllllllllIIIlllllIIIIllllll) {
        final String[] llllllllllllllIIIlllllIIIIlllllI = llllllllllllllIIIlllllIIIIllllll.split(" ");
        final String llllllllllllllIIIlllllIIIIllllIl = llllllllllllllIIIlllllIIIIlllllI[0];
        final String llllllllllllllIIIlllllIIIIllllII = llllllllllllllIIIlllllIIIIllllll.substring(llllllllllllllIIIlllllIIIIllllIl.length()).trim();
        for (final Command llllllllllllllIIIlllllIIIIlllIll : this.getCommands()) {
            if (llllllllllllllIIIlllllIIIIlllIll.getAlias().equalsIgnoreCase(llllllllllllllIIIlllllIIIIllllIl)) {
                try {
                    llllllllllllllIIIlllllIIIIlllIll.onCommand(llllllllllllllIIIlllllIIIIllllII, llllllllllllllIIIlllllIIIIllllII.split(" "));
                }
                catch (Exception llllllllllllllIIIlllllIIIIlllIlI) {
                    Main.msg(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("Invalid Command!")));
                    Main.msg(llllllllllllllIIIlllllIIIIlllIll.getSyntax());
                }
                return;
            }
        }
        Main.msg(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("Command not found!")));
    }
    
    public ArrayList<Command> getCommands() {
        return this.commands;
    }
    
    public CommandManager() {
        this.commands = new ArrayList<Command>();
        this.commands.add(new Bind());
        this.commands.add(new Clip());
        this.commands.add(new Macros());
        this.commands.add(new Config());
    }
}
