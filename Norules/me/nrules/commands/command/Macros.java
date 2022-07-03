package me.nrules.commands.command;

import me.nrules.commands.*;
import me.nrules.*;

public class Macros extends Command
{
    @Override
    public String getAlias() {
        return "Macros";
    }
    
    @Override
    public String getDescription() {
        return "";
    }
    
    @Override
    public String getSyntax() {
        return ".macros add [command] key";
    }
    
    @Override
    public void onCommand(final String lllllllllllllIlIIllIlIlIIIlllIIl, final String[] lllllllllllllIlIIllIlIlIIIllIlIl) throws Exception {
        if (lllllllllllllIlIIllIlIlIIIllIlIl[0].length() == 0) {
            Main.msg(this.getSyntax());
        }
        if (lllllllllllllIlIIllIlIlIIIllIlIl[0].equalsIgnoreCase("add") && lllllllllllllIlIIllIlIlIIIlllIIl == null) {
            Main.msg(this.getSyntax());
        }
    }
}
