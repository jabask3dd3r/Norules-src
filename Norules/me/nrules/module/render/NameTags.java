package me.nrules.module.render;

import java.util.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import me.nrules.event.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.enchantment.*;
import java.awt.*;
import net.minecraft.nbt.*;
import font.*;
import net.minecraft.util.text.*;
import me.nrules.utils.friend.*;
import net.minecraft.util.math.*;
import me.nrules.utils.render.*;
import me.nrules.event.events.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import me.nrules.module.*;
import me.nrules.*;
import clickui.settings.*;

public class NameTags extends Module
{
    private /* synthetic */ Setting atheistS;
    /* synthetic */ int counter1;
    private /* synthetic */ Setting colorBackground;
    private /* synthetic */ Setting ping;
    private /* synthetic */ Setting nameScale;
    private /* synthetic */ Setting items;
    /* synthetic */ int counter2;
    private /* synthetic */ Setting description;
    /* synthetic */ int color1;
    private /* synthetic */ HashMap<String, String> damageList;
    private /* synthetic */ HashMap<String, Integer> tagList;
    private /* synthetic */ Setting damageDisplayS;
    
    public float getNametagSize(final EntityLivingBase lllllllllllllIIllllIlIIlIlIlIlIl) {
        final ScaledResolution lllllllllllllIIllllIlIIlIlIllIIl = new ScaledResolution(NameTags.mc);
        final double lllllllllllllIIllllIlIIlIlIllIII = lllllllllllllIIllllIlIIlIlIllIIl.getScaleFactor() / Math.pow(lllllllllllllIIllllIlIIlIlIllIIl.getScaleFactor(), 2.0);
        final double lllllllllllllIIllllIlIIlIlIlIlll = this.nameScale.getValDouble();
        return (float)lllllllllllllIIllllIlIIlIlIlIlll * 6.0f * ((float)lllllllllllllIIllllIlIIlIlIllIII + (float)(lllllllllllllIIllllIlIIlIlIlIlIl.getDistance(NameTags.mc.getRenderViewEntity().posX, NameTags.mc.getRenderViewEntity().posY, NameTags.mc.getRenderViewEntity().posZ) / 10.5));
    }
    
    public static void drawGuiRect(final double lllllllllllllIIllllIlIIlIIIIIlII, final double lllllllllllllIIllllIlIIlIIIIllII, final double lllllllllllllIIllllIlIIlIIIIIIlI, final double lllllllllllllIIllllIlIIlIIIIlIlI, final int lllllllllllllIIllllIlIIlIIIIIIII) {
        final float lllllllllllllIIllllIlIIlIIIIlIII = (lllllllllllllIIllllIlIIlIIIIIIII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIIllllIlIIlIIIIIlll = (lllllllllllllIIllllIlIIlIIIIIIII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIllllIlIIlIIIIIllI = (lllllllllllllIIllllIlIIlIIIIIIII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIllllIlIIlIIIIIlIl = (lllllllllllllIIllllIlIIlIIIIIIII & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(lllllllllllllIIllllIlIIlIIIIIlll, lllllllllllllIIllllIlIIlIIIIIllI, lllllllllllllIIllllIlIIlIIIIIlIl, lllllllllllllIIllllIlIIlIIIIlIII);
        GL11.glBegin(7);
        GL11.glVertex2d(lllllllllllllIIllllIlIIlIIIIIIlI, lllllllllllllIIllllIlIIlIIIIllII);
        GL11.glVertex2d(lllllllllllllIIllllIlIIlIIIIIlII, lllllllllllllIIllllIlIIlIIIIllII);
        GL11.glVertex2d(lllllllllllllIIllllIlIIlIIIIIlII, lllllllllllllIIllllIlIIlIIIIlIlI);
        GL11.glVertex2d(lllllllllllllIIllllIlIIlIIIIIIlI, lllllllllllllIIllllIlIIlIIIIlIlI);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    @EventTarget
    public void onNickRemove(final EventNameTags lllllllllllllIIllllIlIIlllIlIllI) {
        lllllllllllllIIllllIlIIlllIlIllI.setCancelled(true);
    }
    
    public void renderEnchantText(final EntityPlayer lllllllllllllIIllllIlIIlIIlIllll, final ItemStack lllllllllllllIIllllIlIIlIIlIIIlI, final int lllllllllllllIIllllIlIIlIIlIIIIl, final int lllllllllllllIIllllIlIIlIIlIIIII) {
        int lllllllllllllIIllllIlIIlIIlIlIll = lllllllllllllIIllllIlIIlIIlIIIII - 18;
        int lllllllllllllIIllllIlIIlIIlIlIlI = lllllllllllllIIllllIlIIlIIlIlIll + 5;
        final NBTTagList lllllllllllllIIllllIlIIlIIlIlIIl = lllllllllllllIIllllIlIIlIIlIIIlI.getEnchantmentTagList();
        if (lllllllllllllIIllllIlIIlIIlIlIIl != null) {
            for (int lllllllllllllIIllllIlIIlIIlIlIII = 0; lllllllllllllIIllllIlIIlIIlIlIII < lllllllllllllIIllllIlIIlIIlIlIIl.tagCount(); ++lllllllllllllIIllllIlIIlIIlIlIII) {
                final short lllllllllllllIIllllIlIIlIIlIIlll = lllllllllllllIIllllIlIIlIIlIlIIl.getCompoundTagAt(lllllllllllllIIllllIlIIlIIlIlIII).getShort("id");
                final short lllllllllllllIIllllIlIIlIIlIIllI = lllllllllllllIIllllIlIIlIIlIlIIl.getCompoundTagAt(lllllllllllllIIllllIlIIlIIlIlIII).getShort("lvl");
                final Enchantment lllllllllllllIIllllIlIIlIIlIIlIl = Enchantment.getEnchantmentByID(lllllllllllllIIllllIlIIlIIlIIlll);
                if (lllllllllllllIIllllIlIIlIIlIIlIl != null) {
                    String lllllllllllllIIllllIlIIlIIlIIlII = lllllllllllllIIllllIlIIlIIlIIlIl.getTranslatedName(lllllllllllllIIllllIlIIlIIlIIllI).substring(0, 1).toLowerCase();
                    lllllllllllllIIllllIlIIlIIlIIlII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIllllIlIIlIIlIIlII)).append(lllllllllllllIIllllIlIIlIIlIIllI));
                    GL11.glPushMatrix();
                    GL11.glScalef(1.0f, 1.0f, 0.0f);
                    final MinecraftFontRenderer lllllllllllllIIllllIlIIlIIlIIIll = FontLoader.INSTANCE.futura_normal_20;
                    if (lllllllllllllIIllllIlIIlIIlIIllI == 1) {
                        lllllllllllllIIllllIlIIlIIlIIIll.drawStringWithShadow(lllllllllllllIIllllIlIIlIIlIIlII, lllllllllllllIIllllIlIIlIIlIIIIl * 2 + 10, lllllllllllllIIllllIlIIlIIlIlIlI, new Color(202, 202, 202, 255).getRGB());
                    }
                    else if (lllllllllllllIIllllIlIIlIIlIIllI == 2) {
                        lllllllllllllIIllllIlIIlIIlIIIll.drawStringWithShadow(lllllllllllllIIllllIlIIlIIlIIlII, lllllllllllllIIllllIlIIlIIlIIIIl * 2 + 10, lllllllllllllIIllllIlIIlIIlIlIlI, new Color(246, 218, 45, 255).getRGB());
                    }
                    else if (lllllllllllllIIllllIlIIlIIlIIllI == 3) {
                        lllllllllllllIIllllIlIIlIIlIIIll.drawStringWithShadow(lllllllllllllIIllllIlIIlIIlIIlII, lllllllllllllIIllllIlIIlIIlIIIIl * 2 + 10, lllllllllllllIIllllIlIIlIIlIlIlI, new Color(229, 128, 0, 255).getRGB());
                    }
                    else if (lllllllllllllIIllllIlIIlIIlIIllI == 4) {
                        lllllllllllllIIllllIlIIlIIlIIIll.drawStringWithShadow(lllllllllllllIIllllIlIIlIIlIIlII, lllllllllllllIIllllIlIIlIIlIIIIl * 2 + 10, lllllllllllllIIllllIlIIlIIlIlIlI, new Color(156, 59, 253, 255).getRGB());
                    }
                    else {
                        lllllllllllllIIllllIlIIlIIlIIIll.drawStringWithShadow(lllllllllllllIIllllIlIIlIIlIIlII, lllllllllllllIIllllIlIIlIIlIIIIl * 2 + 10, lllllllllllllIIllllIlIIlIIlIlIlI, new Color(239, 0, 0, 255).getRGB());
                    }
                    GL11.glScalef(1.0f, 1.0f, 1.0f);
                    GL11.glPopMatrix();
                    lllllllllllllIIllllIlIIlIIlIlIll += 8;
                    lllllllllllllIIllllIlIIlIIlIlIlI -= 10;
                }
            }
        }
    }
    
    public void renderNametag(final EntityPlayer lllllllllllllIIllllIlIIllIIlIlll, final double lllllllllllllIIllllIlIIllIIlIllI, final double lllllllllllllIIllllIlIIlIlllIlll, final double lllllllllllllIIllllIlIIllIIlIlII) {
        GL11.glPushMatrix();
        TextFormatting lllllllllllllIIllllIlIIllIIlIIll = TextFormatting.WHITE;
        TextFormatting lllllllllllllIIllllIlIIllIIlIIlI = TextFormatting.WHITE;
        String lllllllllllllIIllllIlIIllIIlIIIl = "";
        if (FriendManager.isFriend(lllllllllllllIIllllIlIIllIIlIlll.getName())) {
            lllllllllllllIIllllIlIIllIIlIIlI = TextFormatting.AQUA;
            final boolean lllllllllllllIIllllIlIIllIIlIIII = this.atheistS.getValBoolean();
            if (!lllllllllllllIIllllIlIIllIIlIIII) {
                lllllllllllllIIllllIlIIllIIlIIIl = "\u271d ";
            }
        }
        int lllllllllllllIIllllIlIIllIIIllll = -1;
        try {
            lllllllllllllIIllllIlIIllIIIllll = NameTags.mc.getConnection().getPlayerInfo(lllllllllllllIIllllIlIIllIIlIlll.getUniqueID()).getResponseTime();
        }
        catch (NullPointerException ex) {}
        String lllllllllllllIIllllIlIIllIIIlllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIllllIlIIllIIIllll)).append("ms  "));
        final boolean lllllllllllllIIllllIlIIllIIIllIl = this.ping.getValBoolean();
        if (!lllllllllllllIIllllIlIIllIIIllIl) {
            lllllllllllllIIllllIlIIllIIIlllI = "";
        }
        final int lllllllllllllIIllllIlIIllIIIllII = MathHelper.ceil(lllllllllllllIIllllIlIIllIIlIlll.getHealth() + lllllllllllllIIllllIlIIllIIlIlll.getAbsorptionAmount());
        final boolean lllllllllllllIIllllIlIIllIIIlIll = this.damageDisplayS.getValBoolean();
        if (lllllllllllllIIllllIlIIllIIIllII > 16) {
            lllllllllllllIIllllIlIIllIIlIIll = TextFormatting.GREEN;
        }
        else if (lllllllllllllIIllllIlIIllIIIllII > 12) {
            lllllllllllllIIllllIlIIllIIlIIll = TextFormatting.YELLOW;
        }
        else if (lllllllllllllIIllllIlIIllIIIllII > 8) {
            lllllllllllllIIllllIlIIllIIlIIll = TextFormatting.GOLD;
        }
        else if (lllllllllllllIIllllIlIIllIIIllII > 5) {
            lllllllllllllIIllllIlIIllIIlIIll = TextFormatting.RED;
        }
        else if (lllllllllllllIIllllIlIIllIIIllII <= 5) {
            lllllllllllllIIllllIlIIllIIlIIll = TextFormatting.DARK_RED;
        }
        final int lllllllllllllIIllllIlIIllIIIlIlI = this.tagList.get(lllllllllllllIIllllIlIIllIIlIlll.getName());
        if (lllllllllllllIIllllIlIIllIIlIlll != NameTags.mc.player && lllllllllllllIIllllIlIIllIIIlIll) {
            if (lllllllllllllIIllllIlIIllIIIlIlI > lllllllllllllIIllllIlIIllIIIllII) {
                this.damageList.put(lllllllllllllIIllllIlIIllIIlIlll.getName(), String.valueOf(new StringBuilder().append(TextFormatting.RED).append(" -").append(lllllllllllllIIllllIlIIllIIIlIlI - lllllllllllllIIllllIlIIllIIIllII)));
            }
            this.tagList.put(lllllllllllllIIllllIlIIllIIlIlll.getName(), lllllllllllllIIllllIlIIllIIIllII);
        }
        String lllllllllllllIIllllIlIIllIIIlIIl = "";
        if (lllllllllllllIIllllIlIIllIIIlIll) {
            lllllllllllllIIllllIlIIllIIIlIIl = this.damageList.get(lllllllllllllIIllllIlIIllIIlIlll.getName());
        }
        String lllllllllllllIIllllIlIIllIIIlIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIllllIlIIllIIlIIIl)).append(lllllllllllllIIllllIlIIllIIlIIlI).append(lllllllllllllIIllllIlIIllIIIlllI).append(lllllllllllllIIllllIlIIllIIlIlll.getName()).append(" ").append(lllllllllllllIIllllIlIIllIIlIIll).append(lllllllllllllIIllllIlIIllIIIllII).append(lllllllllllllIIllllIlIIllIIIlIIl));
        lllllllllllllIIllllIlIIllIIIlIII = lllllllllllllIIllllIlIIllIIIlIII.replace(".0", "");
        final float lllllllllllllIIllllIlIIllIIIIlll = 0.016666668f * this.getNametagSize(lllllllllllllIIllllIlIIllIIlIlll);
        GL11.glTranslated(lllllllllllllIIllllIlIIllIIlIllI, lllllllllllllIIllllIlIIlIlllIlll + 2.5 + lllllllllllllIIllllIlIIllIIIIlll * 10.0f, lllllllllllllIIllllIlIIllIIlIlII);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-NameTags.mc.getRenderManager().playerViewY, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(NameTags.mc.getRenderManager().playerViewX, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(-lllllllllllllIIllllIlIIllIIIIlll, -lllllllllllllIIllllIlIIllIIIIlll, lllllllllllllIIllllIlIIllIIIIlll);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(false);
        GL11.glDisable(2929);
        final MinecraftFontRenderer lllllllllllllIIllllIlIIllIIIIllI = FontLoader.INSTANCE.sfui_19;
        final int lllllllllllllIIllllIlIIllIIIIlIl = lllllllllllllIIllllIlIIllIIIIllI.getStringWidth(lllllllllllllIIllllIlIIllIIIlIII) / 2;
        final double lllllllllllllIIllllIlIIllIIIIlII = this.colorBackground.getValDouble();
        final int[] lllllllllllllIIllllIlIIllIIIIIll = { 1 };
        this.color1 = ModuleList.TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0 * (lllllllllllllIIllllIlIIllIIIIIll[0] * 2.55) / 60.0).getRGB();
        RenderUtils.drawSmoothRect((float)(-lllllllllllllIIllllIlIIllIIIIlIl - 3), 9.0f, (float)(lllllllllllllIIllllIlIIllIIIIlIl + 4), 23.0f, new Color(0, 0, 0, (int)lllllllllllllIIllllIlIIllIIIIlII).getRGB());
        final int[] array = lllllllllllllIIllllIlIIllIIIIIll;
        final int n = 0;
        ++array[n];
        lllllllllllllIIllllIlIIllIIIIllI.drawString(lllllllllllllIIllllIlIIllIIIlIII, -lllllllllllllIIllllIlIIllIIIIlIl, 10, Color.red.getRGB());
        final boolean lllllllllllllIIllllIlIIllIIIIIlI = this.items.getValBoolean();
        if (lllllllllllllIIllllIlIIllIIIIIlI) {
            int lllllllllllllIIllllIlIIllIIIIIIl = -8;
            for (final ItemStack lllllllllllllIIllllIlIIllIIIIIII : lllllllllllllIIllllIlIIllIIlIlll.inventory.armorInventory) {
                if (lllllllllllllIIllllIlIIllIIIIIII != null) {
                    lllllllllllllIIllllIlIIllIIIIIIl -= 8;
                }
            }
            if (lllllllllllllIIllllIlIIllIIlIlll.getHeldItemMainhand() != null) {
                lllllllllllllIIllllIlIIllIIIIIIl -= 8;
                final ItemStack lllllllllllllIIllllIlIIlIlllllll = lllllllllllllIIllllIlIIllIIlIlll.getHeldItemMainhand().copy();
                this.renderItem(lllllllllllllIIllllIlIIllIIlIlll, lllllllllllllIIllllIlIIlIlllllll, lllllllllllllIIllllIlIIllIIIIIIl, -10);
                lllllllllllllIIllllIlIIllIIIIIIl += 16;
            }
            for (int lllllllllllllIIllllIlIIlIllllllI = 3; lllllllllllllIIllllIlIIlIllllllI >= 0; --lllllllllllllIIllllIlIIlIllllllI) {
                final ItemStack lllllllllllllIIllllIlIIlIlllllIl = lllllllllllllIIllllIlIIllIIlIlll.inventory.armorInventory.get(lllllllllllllIIllllIlIIlIllllllI);
                if (lllllllllllllIIllllIlIIlIlllllIl != null) {
                    final ItemStack lllllllllllllIIllllIlIIlIlllllII = lllllllllllllIIllllIlIIlIlllllIl.copy();
                    this.renderItem(lllllllllllllIIllllIlIIllIIlIlll, lllllllllllllIIllllIlIIlIlllllII, lllllllllllllIIllllIlIIllIIIIIIl, -10);
                    lllllllllllllIIllllIlIIllIIIIIIl += 16;
                }
            }
            if (lllllllllllllIIllllIlIIllIIlIlll.getHeldItemOffhand() != null) {
                lllllllllllllIIllllIlIIllIIIIIIl += 0;
                final Object lllllllllllllIIllllIlIIlIllllIll = lllllllllllllIIllllIlIIllIIlIlll.getHeldItemOffhand().copy();
                this.renderItem(lllllllllllllIIllllIlIIllIIlIlll, (ItemStack)lllllllllllllIIllllIlIIlIllllIll, lllllllllllllIIllllIlIIllIIIIIIl, -10);
                lllllllllllllIIllllIlIIllIIIIIIl += 8;
            }
        }
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @EventTarget
    public void onUpdate(final Event3D lllllllllllllIIllllIlIIlllIIlIII) {
        for (final EntityPlayer lllllllllllllIIllllIlIIlllIIIlll : NameTags.mc.world.playerEntities) {
            if (lllllllllllllIIllllIlIIlllIIIlll != NameTags.mc.getRenderViewEntity() && lllllllllllllIIllllIlIIlllIIIlll.isEntityAlive()) {
                final boolean lllllllllllllIIllllIlIIlllIIIllI = this.damageDisplayS.getValBoolean();
                if (lllllllllllllIIllllIlIIlllIIIllI) {
                    if (!this.tagList.containsKey(lllllllllllllIIllllIlIIlllIIIlll.getName())) {
                        this.tagList.put(lllllllllllllIIllllIlIIlllIIIlll.getName(), (int)lllllllllllllIIllllIlIIlllIIIlll.getHealth());
                        this.damageList.put(lllllllllllllIIllllIlIIlllIIIlll.getName(), "");
                    }
                    if (lllllllllllllIIllllIlIIlllIIIlll.isDead || lllllllllllllIIllllIlIIlllIIIlll.getHealth() <= 0.0f) {
                        this.tagList.remove(lllllllllllllIIllllIlIIlllIIIlll.getName());
                        this.damageList.remove(lllllllllllllIIllllIlIIlllIIIlll.getName());
                    }
                }
                final double lllllllllllllIIllllIlIIlllIIIlIl = lllllllllllllIIllllIlIIlllIIIlll.lastTickPosX + (lllllllllllllIIllllIlIIlllIIIlll.posX - lllllllllllllIIllllIlIIlllIIIlll.lastTickPosX) * NameTags.mc.timer.renderPartialTicks;
                final double lllllllllllllIIllllIlIIlllIIIlII = lllllllllllllIIllllIlIIlllIIIlll.lastTickPosY + (lllllllllllllIIllllIlIIlllIIIlll.posY - lllllllllllllIIllllIlIIlllIIIlll.lastTickPosY) * NameTags.mc.timer.renderPartialTicks;
                final double lllllllllllllIIllllIlIIlllIIIIll = lllllllllllllIIllllIlIIlllIIIlll.lastTickPosZ + (lllllllllllllIIllllIlIIlllIIIlll.posZ - lllllllllllllIIllllIlIIlllIIIlll.lastTickPosZ) * NameTags.mc.timer.renderPartialTicks;
                Entity lllllllllllllIIllllIlIIlllIIIIlI = NameTags.mc.getRenderManager().renderViewEntity;
                if (lllllllllllllIIllllIlIIlllIIIIlI == null) {
                    lllllllllllllIIllllIlIIlllIIIIlI = NameTags.mc.player;
                }
                if (lllllllllllllIIllllIlIIlllIIIIlI == null) {
                    return;
                }
                final double lllllllllllllIIllllIlIIlllIIIIIl = lllllllllllllIIllllIlIIlllIIIIlI.lastTickPosX + (lllllllllllllIIllllIlIIlllIIIIlI.posX - lllllllllllllIIllllIlIIlllIIIIlI.lastTickPosX) * NameTags.mc.timer.renderPartialTicks;
                final double lllllllllllllIIllllIlIIlllIIIIII = lllllllllllllIIllllIlIIlllIIIIlI.lastTickPosY + (lllllllllllllIIllllIlIIlllIIIIlI.posY - lllllllllllllIIllllIlIIlllIIIIlI.lastTickPosY) * NameTags.mc.timer.renderPartialTicks;
                final double lllllllllllllIIllllIlIIllIllllll = lllllllllllllIIllllIlIIlllIIIIlI.lastTickPosZ + (lllllllllllllIIllllIlIIlllIIIIlI.posZ - lllllllllllllIIllllIlIIlllIIIIlI.lastTickPosZ) * NameTags.mc.timer.renderPartialTicks;
                this.renderNametag(lllllllllllllIIllllIlIIlllIIIlll, lllllllllllllIIllllIlIIlllIIIlIl - lllllllllllllIIllllIlIIlllIIIIIl, lllllllllllllIIllllIlIIlllIIIlII - lllllllllllllIIllllIlIIlllIIIIII, lllllllllllllIIllllIlIIlllIIIIll - lllllllllllllIIllllIlIIllIllllll);
            }
            final boolean lllllllllllllIIllllIlIIllIlllllI = this.damageDisplayS.getValBoolean();
            if (this.counter2 == 601 && lllllllllllllIIllllIlIIllIlllllI) {
                this.tagList.remove(lllllllllllllIIllllIlIIlllIIIlll.getName());
                this.damageList.remove(lllllllllllllIIllllIlIIlllIIIlll.getName());
            }
        }
        if (this.counter2 == 601) {
            this.counter2 = 0;
        }
        ++this.counter1;
        ++this.counter2;
    }
    
    public void renderItem(final EntityPlayer lllllllllllllIIllllIlIIlIlIIlIIl, final ItemStack lllllllllllllIIllllIlIIlIlIIIIIl, final int lllllllllllllIIllllIlIIlIlIIIlll, final int lllllllllllllIIllllIlIIlIlIIIllI) {
        GL11.glPushMatrix();
        GL11.glDepthMask(true);
        GlStateManager.clear(256);
        GlStateManager.disableDepth();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        NameTags.mc.getRenderItem().zLevel = -100.0f;
        GlStateManager.scale(1.0f, 1.0f, 0.01f);
        NameTags.mc.getRenderItem().renderItemAndEffectIntoGUI(lllllllllllllIIllllIlIIlIlIIIIIl, lllllllllllllIIllllIlIIlIlIIIlll, lllllllllllllIIllllIlIIlIlIIIllI / 2 - 12);
        final MinecraftFontRenderer lllllllllllllIIllllIlIIlIlIIIlIl = FontLoader.INSTANCE.consola_16;
        if (lllllllllllllIIllllIlIIlIlIIIIIl.getItem() == Items.GOLDEN_APPLE) {
            NameTags.mc.getRenderItem().renderItemOverlaysCustom(lllllllllllllIIllllIlIIlIlIIIlIl, lllllllllllllIIllllIlIIlIlIIIIIl, lllllllllllllIIllllIlIIlIlIIIlll - 5, lllllllllllllIIllllIlIIlIlIIIllI / 2 - 28);
        }
        else {
            NameTags.mc.getRenderItem().renderItemOverlaysCustom(lllllllllllllIIllllIlIIlIlIIIlIl, lllllllllllllIIllllIlIIlIlIIIIIl, lllllllllllllIIllllIlIIlIlIIIlll, lllllllllllllIIllllIlIIlIlIIIllI / 2 - 8);
        }
        NameTags.mc.getRenderItem().zLevel = 0.0f;
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.disableDepth();
        final boolean lllllllllllllIIllllIlIIlIlIIIlII = this.description.getValBoolean();
        if (lllllllllllllIIllllIlIIlIlIIIlII) {
            this.renderEnchantText(lllllllllllllIIllllIlIIlIlIIlIIl, lllllllllllllIIllllIlIIlIlIIIIIl, lllllllllllllIIllllIlIIlIlIIIlll, lllllllllllllIIllllIlIIlIlIIIllI - 18);
        }
        GlStateManager.enableDepth();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        GL11.glPopMatrix();
    }
    
    public NameTags() {
        super("NameTags", 0, Category.RENDER);
        this.counter1 = 0;
        this.counter2 = 0;
        this.color1 = 0;
        this.tagList = new HashMap<String, Integer>();
        this.damageList = new HashMap<String, String>();
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("NameScale", this, 0.1, 0.1, 0.3, false);
        this.nameScale = setting;
        settingsManager.Property(setting);
        final SM settingsManager2 = Main.settingsManager;
        final Setting setting2 = new Setting("ColorBackground", this, 128.0, 1.0, 255.0, true);
        this.colorBackground = setting2;
        settingsManager2.Property(setting2);
        final SM settingsManager3 = Main.settingsManager;
        final Setting setting3 = new Setting("DamageDisplay", this, true);
        this.damageDisplayS = setting3;
        settingsManager3.Property(setting3);
        final SM settingsManager4 = Main.settingsManager;
        final Setting setting4 = new Setting("Atheist", this, true);
        this.atheistS = setting4;
        settingsManager4.Property(setting4);
        final SM settingsManager5 = Main.settingsManager;
        final Setting setting5 = new Setting("Ping", this, true);
        this.ping = setting5;
        settingsManager5.Property(setting5);
        final SM settingsManager6 = Main.settingsManager;
        final Setting setting6 = new Setting("Items", this, true);
        this.items = setting6;
        settingsManager6.Property(setting6);
        final SM settingsManager7 = Main.settingsManager;
        final Setting setting7 = new Setting("Description", this, false);
        this.description = setting7;
        settingsManager7.Property(setting7);
    }
}
