package me.nrules.utils.math;

import net.minecraft.client.*;
import java.util.concurrent.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import java.util.*;
import java.math.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class MiscUtils
{
    static /* synthetic */ Minecraft mc;
    
    public static double getDoubleRandom(final double lllllllllllllllIIIlIlIIIlIIlIIII, final double lllllllllllllllIIIlIlIIIlIIIllll) {
        return ThreadLocalRandom.current().nextDouble(lllllllllllllllIIIlIlIIIlIIlIIII, lllllllllllllllIIIlIlIIIlIIIllll);
    }
    
    public static boolean isTeams(final EntityPlayer lllllllllllllllIIIlIlIIIlIlIIIIl) {
        boolean lllllllllllllllIIIlIlIIIlIlIIIII = false;
        TextFormatting lllllllllllllllIIIlIlIIIlIIlllll = null;
        TextFormatting lllllllllllllllIIIlIlIIIlIIllllI = null;
        if (lllllllllllllllIIIlIlIIIlIlIIIIl != null) {
            final float lllllllllllllllIIIlIlIIIlIIlIlIl;
            final char lllllllllllllllIIIlIlIIIlIIlIllI = (char)((TextFormatting[])(Object)(lllllllllllllllIIIlIlIIIlIIlIlIl = (float)(Object)TextFormatting.values())).length;
            for (final TextFormatting lllllllllllllllIIIlIlIIIlIIlllIl : lllllllllllllllIIIlIlIIIlIIlIlIl) {
                if (lllllllllllllllIIIlIlIIIlIIlllIl != TextFormatting.RESET) {
                    if (MiscUtils.mc.player.getDisplayName().getFormattedText().contains(lllllllllllllllIIIlIlIIIlIIlllIl.toString()) && lllllllllllllllIIIlIlIIIlIIlllll == null) {
                        lllllllllllllllIIIlIlIIIlIIlllll = lllllllllllllllIIIlIlIIIlIIlllIl;
                    }
                    if (lllllllllllllllIIIlIlIIIlIlIIIIl.getDisplayName().getFormattedText().contains(lllllllllllllllIIIlIlIIIlIIlllIl.toString()) && lllllllllllllllIIIlIlIIIlIIllllI == null) {
                        lllllllllllllllIIIlIlIIIlIIllllI = lllllllllllllllIIIlIlIIIlIIlllIl;
                    }
                }
            }
            try {
                if (lllllllllllllllIIIlIlIIIlIIlllll != null && lllllllllllllllIIIlIlIIIlIIllllI != null) {
                    lllllllllllllllIIIlIlIIIlIlIIIII = (lllllllllllllllIIIlIlIIIlIIlllll != lllllllllllllllIIIlIlIIIlIIllllI);
                }
                else if (MiscUtils.mc.player.getTeam() != null) {
                    lllllllllllllllIIIlIlIIIlIlIIIII = !MiscUtils.mc.player.isOnSameTeam(lllllllllllllllIIIlIlIIIlIlIIIIl);
                }
                else if (MiscUtils.mc.player.inventory.armorInventory.get(3).getItem() instanceof ItemBlock) {
                    lllllllllllllllIIIlIlIIIlIlIIIII = !ItemStack.areItemStacksEqual(MiscUtils.mc.player.inventory.armorInventory.get(3), lllllllllllllllIIIlIlIIIlIlIIIIl.inventory.armorInventory.get(3));
                }
            }
            catch (Exception ex) {}
        }
        return lllllllllllllllIIIlIlIIIlIlIIIII;
    }
    
    public static double Random1(final double lllllllllllllllIIIlIlIIIIllllIII, final double lllllllllllllllIIIlIlIIIIlllIlll) {
        double lllllllllllllllIIIlIlIIIIlllIllI = new Random().nextDouble() * (lllllllllllllllIIIlIlIIIIlllIlll - lllllllllllllllIIIlIlIIIIllllIII);
        if (lllllllllllllllIIIlIlIIIIlllIllI > lllllllllllllllIIIlIlIIIIlllIlll) {
            lllllllllllllllIIIlIlIIIIlllIllI = lllllllllllllllIIIlIlIIIIlllIlll;
        }
        double lllllllllllllllIIIlIlIIIIlllIlIl = lllllllllllllllIIIlIlIIIIlllIllI + lllllllllllllllIIIlIlIIIIllllIII;
        if (lllllllllllllllIIIlIlIIIIlllIlIl > lllllllllllllllIIIlIlIIIIlllIlll) {
            lllllllllllllllIIIlIlIIIIlllIlIl = lllllllllllllllIIIlIlIIIIlllIlll;
        }
        return lllllllllllllllIIIlIlIIIIlllIlIl;
    }
    
    public static int randomNumber(final int lllllllllllllllIIIlIlIIIIllllllI, final int lllllllllllllllIIIlIlIIIIlllllll) {
        return Math.round(lllllllllllllllIIIlIlIIIIlllllll + (float)Math.random() * (lllllllllllllllIIIlIlIIIIllllllI - lllllllllllllllIIIlIlIIIIlllllll));
    }
    
    public static String randomString(final int lllllllllllllllIIIlIlIIIIlIllIlI) {
        return random(lllllllllllllllIIIlIlIIIIlIllIlI, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    }
    
    public static double round(final double lllllllllllllllIIIlIlIIIIlIIIIlI, final int lllllllllllllllIIIlIlIIIIlIIIIIl) {
        if (lllllllllllllllIIIlIlIIIIlIIIIIl < 0) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(lllllllllllllllIIIlIlIIIIlIIIIlI).setScale(lllllllllllllllIIIlIlIIIIlIIIIIl, RoundingMode.HALF_UP).doubleValue();
    }
    
    public static int random(final int lllllllllllllllIIIlIlIIIlIIIIllI, final int lllllllllllllllIIIlIlIIIlIIIIlIl) {
        final int lllllllllllllllIIIlIlIIIlIIIlIII = lllllllllllllllIIIlIlIIIlIIIIlIl - lllllllllllllllIIIlIlIIIlIIIIllI;
        final int lllllllllllllllIIIlIlIIIlIIIIlll = lllllllllllllllIIIlIlIIIlIIIIllI + new Random().nextInt(lllllllllllllllIIIlIlIIIlIIIlIII + 1);
        return lllllllllllllllIIIlIlIIIlIIIIlll;
    }
    
    static {
        MiscUtils.mc = Minecraft.getMinecraft();
    }
    
    public static String random(final int lllllllllllllllIIIlIlIIIIlIIlIlI, final char[] lllllllllllllllIIIlIlIIIIlIIllIl) {
        final StringBuilder lllllllllllllllIIIlIlIIIIlIIllII = new StringBuilder();
        for (int lllllllllllllllIIIlIlIIIIlIIlIll = 0; lllllllllllllllIIIlIlIIIIlIIlIll < lllllllllllllllIIIlIlIIIIlIIlIlI; ++lllllllllllllllIIIlIlIIIIlIIlIll) {
            lllllllllllllllIIIlIlIIIIlIIllII.append(lllllllllllllllIIIlIlIIIIlIIllIl[new Random().nextInt(lllllllllllllllIIIlIlIIIIlIIllIl.length)]);
        }
        return String.valueOf(lllllllllllllllIIIlIlIIIIlIIllII);
    }
    
    public static void showURL(final String lllllllllllllllIIIlIlIIIlIlIllIl) {
        try {
            Desktop.getDesktop().browse(new URI(lllllllllllllllIIIlIlIIIlIlIllIl));
        }
        catch (IOException | URISyntaxException ex2) {
            final Exception ex;
            final Exception lllllllllllllllIIIlIlIIIlIlIllII = ex;
            lllllllllllllllIIIlIlIIIlIlIllII.printStackTrace();
        }
    }
    
    public static String randomNumber(final int lllllllllllllllIIIlIlIIIIlIlllII) {
        return random(lllllllllllllllIIIlIlIIIIlIlllII, "123456789");
    }
    
    public static int Random2(final int lllllllllllllllIIIlIlIIIIllIllII, final int lllllllllllllllIIIlIlIIIIllIlIll) {
        return new Random().nextInt(lllllllllllllllIIIlIlIIIIllIlIll - lllllllllllllllIIIlIlIIIIllIllII + 1) + lllllllllllllllIIIlIlIIIIllIllII;
    }
    
    public static float Random3(final float lllllllllllllllIIIlIlIIIIllIIIlI, final float lllllllllllllllIIIlIlIIIIllIIIIl) {
        float lllllllllllllllIIIlIlIIIIllIIlII = new Random().nextFloat() * (lllllllllllllllIIIlIlIIIIllIIIIl - lllllllllllllllIIIlIlIIIIllIIIlI);
        if (lllllllllllllllIIIlIlIIIIllIIlII > lllllllllllllllIIIlIlIIIIllIIIIl) {
            lllllllllllllllIIIlIlIIIIllIIlII = lllllllllllllllIIIlIlIIIIllIIIIl;
        }
        float lllllllllllllllIIIlIlIIIIllIIIll = lllllllllllllllIIIlIlIIIIllIIlII + lllllllllllllllIIIlIlIIIIllIIIlI;
        if (lllllllllllllllIIIlIlIIIIllIIIll > lllllllllllllllIIIlIlIIIIllIIIIl) {
            lllllllllllllllIIIlIlIIIIllIIIll = lllllllllllllllIIIlIlIIIIllIIIIl;
        }
        return lllllllllllllllIIIlIlIIIIllIIIll;
    }
    
    public static String random(final int lllllllllllllllIIIlIlIIIIlIlIllI, final String lllllllllllllllIIIlIlIIIIlIlIlIl) {
        return random(lllllllllllllllIIIlIlIIIIlIlIllI, lllllllllllllllIIIlIlIIIIlIlIlIl.toCharArray());
    }
}
