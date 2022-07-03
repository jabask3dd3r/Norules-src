package me.nrules.commands.command;

import me.nrules.commands.*;
import me.nrules.*;
import net.minecraft.client.*;

public class Clip extends Command
{
    @Override
    public void onCommand(final String lllllllllllllIIllIIIlIIllIIIIllI, final String[] lllllllllllllIIllIIIlIIllIIIIlIl) throws Exception {
        if (lllllllllllllIIllIIIlIIllIIIIlIl[0].length() == 0) {
            Main.msg(this.getSyntax());
        }
        if (lllllllllllllIIllIIIlIIllIIIIlIl[0].equalsIgnoreCase("y")) {
            final Minecraft lllllllllllllIIllIIIlIIllIIIIlII = Minecraft.getMinecraft();
            final double lllllllllllllIIllIIIlIIllIIIIIll = Double.parseDouble(lllllllllllllIIllIIIlIIllIIIIlIl[1]);
            Minecraft.getMinecraft().player.setPosition(lllllllllllllIIllIIIlIIllIIIIlII.player.posX, lllllllllllllIIllIIIlIIllIIIIlII.player.posY + lllllllllllllIIllIIIlIIllIIIIIll, lllllllllllllIIllIIIlIIllIIIIlII.player.posZ);
        }
    }
    
    @Override
    public String getSyntax() {
        return ".clip y [POS]";
    }
    
    @Override
    public String getDescription() {
        return "";
    }
    
    @Override
    public String getAlias() {
        return "Clip";
    }
}
