package me.nrules.commands.command;

import me.nrules.commands.*;
import me.nrules.*;
import org.lwjgl.input.*;
import me.nrules.module.*;
import com.mojang.realmsclient.gui.*;

public class Bind extends Command
{
    @Override
    public String getSyntax() {
        return ".bind key [MOD] [KEY] | .bind del [MOD] | .bind clear";
    }
    
    @Override
    public String getAlias() {
        return "bind";
    }
    
    @Override
    public void onCommand(final String lllllllllllllIIlIllIIlIIlIIIIlll, final String[] lllllllllllllIIlIllIIlIIlIIIIllI) throws Exception {
        if (lllllllllllllIIlIllIIlIIlIIIIllI[0].length() == 0) {
            Main.msg(this.getSyntax());
        }
        if (lllllllllllllIIlIllIIlIIlIIIIllI[0].equalsIgnoreCase("key")) {
            lllllllllllllIIlIllIIlIIlIIIIllI[2] = lllllllllllllIIlIllIIlIIlIIIIllI[2].toUpperCase();
            final int lllllllllllllIIlIllIIlIIlIIIIlIl = Keyboard.getKeyIndex(lllllllllllllIIlIllIIlIIlIIIIllI[2]);
            for (final Module lllllllllllllIIlIllIIlIIlIIIIlII : ModuleManager.getModules()) {
                if (lllllllllllllIIlIllIIlIIlIIIIllI[1].equalsIgnoreCase(lllllllllllllIIlIllIIlIIlIIIIlII.getName())) {
                    lllllllllllllIIlIllIIlIIlIIIIlII.setKey(lllllllllllllIIlIllIIlIIlIIIIlIl);
                    Main.msg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIllIIlIIlIIIIllI[1])).append(" has bind to ").append(lllllllllllllIIlIllIIlIIlIIIIllI[2]).append("!")));
                }
            }
        }
        else if (lllllllllllllIIlIllIIlIIlIIIIllI[0].equalsIgnoreCase("delete") || lllllllllllllIIlIllIIlIIlIIIIllI[0].equalsIgnoreCase("del")) {
            for (final Module lllllllllllllIIlIllIIlIIlIIIIIll : ModuleManager.getModules()) {
                if (lllllllllllllIIlIllIIlIIlIIIIIll.getName().equalsIgnoreCase(lllllllllllllIIlIllIIlIIlIIIIllI[1])) {
                    lllllllllllllIIlIllIIlIIlIIIIIll.setKey(0);
                    Main.msg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIllIIlIIlIIIIllI[1])).append(" has unbind!")));
                }
            }
        }
        else if (lllllllllllllIIlIllIIlIIlIIIIllI[0].equalsIgnoreCase("clear")) {
            for (final Module lllllllllllllIIlIllIIlIIlIIIIIlI : ModuleManager.getModules()) {
                lllllllllllllIIlIllIIlIIlIIIIIlI.setKey(0);
            }
            Main.msg(String.valueOf(new StringBuilder().append(ChatFormatting.GREEN).append("All keybinds cleared!")));
        }
    }
    
    @Override
    public String getDescription() {
        return "";
    }
}
