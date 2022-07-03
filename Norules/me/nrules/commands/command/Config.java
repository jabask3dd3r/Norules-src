package me.nrules.commands.command;

import me.nrules.commands.*;
import me.nrules.*;

public class Config extends Command
{
    @Override
    public String getSyntax() {
        return ".config load <NAME> | .config list | .config save <NAME> | .config del <NAME>";
    }
    
    @Override
    public String getAlias() {
        return "Config";
    }
    
    @Override
    public String getDescription() {
        return "";
    }
    
    @Override
    public void onCommand(final String lIlllllllIllllI, final String[] lIlllllllIlllIl) throws Exception {
        if (lIlllllllIlllIl[0].length() == 0) {
            Main.msg(this.getSyntax());
        }
        if (lIlllllllIlllIl[0].equalsIgnoreCase("load")) {
            if (Main.configManager.loadConfig(lIlllllllIlllIl[1])) {
                Main.msg(String.valueOf(new StringBuilder("Successfully loaded config: '").append(lIlllllllIlllIl[1]).append("'")));
            }
            else {
                Main.msg(String.valueOf(new StringBuilder("Failed to load config: '").append(lIlllllllIlllIl[1]).append("'")));
            }
        }
        else if (lIlllllllIlllIl[0].equalsIgnoreCase("list")) {
            for (final config.Config lIlllllllIlllII : Main.configManager.getContents()) {
                Main.msg(String.valueOf(new StringBuilder("Available Configs: ").append(lIlllllllIlllII.getName()).append(" ")));
            }
        }
        else if (lIlllllllIlllIl[0].equalsIgnoreCase("save")) {
            if (Main.configManager.saveConfig(lIlllllllIlllIl[1])) {
                Main.msg(String.valueOf(new StringBuilder("Successfully saved config: '").append(lIlllllllIlllIl[1]).append("'")));
            }
            else {
                Main.msg(String.valueOf(new StringBuilder("Failed to save config: '").append(lIlllllllIlllIl[1]).append("'")));
            }
        }
        else if (lIlllllllIlllIl[0].equalsIgnoreCase("del")) {
            if (Main.configManager.deleteConfig(lIlllllllIlllIl[1])) {
                Main.msg(String.valueOf(new StringBuilder("Successfully deleted config: '").append(lIlllllllIlllIl[1]).append("'")));
            }
            else {
                Main.msg(String.valueOf(new StringBuilder("Failed to delete config: '").append(lIlllllllIlllIl[1]).append("'")));
            }
        }
    }
}
