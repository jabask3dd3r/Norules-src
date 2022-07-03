package me.nrules.notifications;

import java.util.*;
import java.util.concurrent.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;
import java.awt.*;
import me.nrules.font.*;
import me.nrules.utils.render.*;
import net.minecraft.client.gui.*;

public final class NotificationPublisher
{
    private static final /* synthetic */ List<Notification> NOTIFICATIONS;
    
    static {
        NOTIFICATIONS = new CopyOnWriteArrayList<Notification>();
    }
    
    public static void prepareScissorBox(final float lllllllllllllIIllIlIIIIIIllIlIlI, final float lllllllllllllIIllIlIIIIIIllIIIll, final float lllllllllllllIIllIlIIIIIIllIIIlI, final float lllllllllllllIIllIlIIIIIIllIIlll) {
        final ScaledResolution lllllllllllllIIllIlIIIIIIllIIllI = new ScaledResolution(Minecraft.getMinecraft());
        final int lllllllllllllIIllIlIIIIIIllIIlIl = lllllllllllllIIllIlIIIIIIllIIllI.getScaleFactor();
        GL11.glScissor((int)(lllllllllllllIIllIlIIIIIIllIlIlI * lllllllllllllIIllIlIIIIIIllIIlIl), (int)((lllllllllllllIIllIlIIIIIIllIIllI.getScaledHeight() - lllllllllllllIIllIlIIIIIIllIIlll) * lllllllllllllIIllIlIIIIIIllIIlIl), (int)((lllllllllllllIIllIlIIIIIIllIIIlI - lllllllllllllIIllIlIIIIIIllIlIlI) * lllllllllllllIIllIlIIIIIIllIIlIl), (int)((lllllllllllllIIllIlIIIIIIllIIlll - lllllllllllllIIllIlIIIIIIllIIIll) * lllllllllllllIIllIlIIIIIIllIIlIl));
    }
    
    public static void publish(final ScaledResolution lllllllllllllIIllIlIIIIIlIIIIlll) {
        final int lllllllllllllIIllIlIIIIIlIIIIllI = lllllllllllllIIllIlIIIIIlIIIIlll.getScaledHeight();
        final int lllllllllllllIIllIlIIIIIlIIIIlIl = lllllllllllllIIllIlIIIIIlIIIIlll.getScaledWidth();
        int lllllllllllllIIllIlIIIIIlIIIIlII = lllllllllllllIIllIlIIIIIlIIIIllI - 60;
        for (final Notification lllllllllllllIIllIlIIIIIlIIIIIll : NotificationPublisher.NOTIFICATIONS) {
            final Shifting lllllllllllllIIllIlIIIIIlIIIIIlI = lllllllllllllIIllIlIIIIIlIIIIIll.getTranslate();
            final int lllllllllllllIIllIlIIIIIlIIIIIIl = lllllllllllllIIllIlIIIIIlIIIIIll.getWidth();
            if (!lllllllllllllIIllIlIIIIIlIIIIIll.getTimer().elapsed(lllllllllllllIIllIlIIIIIlIIIIIll.getTime())) {
                lllllllllllllIIllIlIIIIIlIIIIIll.scissorBoxWidth = AnimUtils.animate(lllllllllllllIIllIlIIIIIlIIIIIIl, lllllllllllllIIllIlIIIIIlIIIIIll.scissorBoxWidth, 0.05 * Minecraft.getSystemTime() / 2.0);
                lllllllllllllIIllIlIIIIIlIIIIIlI.interpolate(lllllllllllllIIllIlIIIIIlIIIIlIl - lllllllllllllIIllIlIIIIIlIIIIIIl, lllllllllllllIIllIlIIIIIlIIIIlII, 0.015);
            }
            else {
                lllllllllllllIIllIlIIIIIlIIIIIll.scissorBoxWidth = AnimUtils.animate(0.0, lllllllllllllIIllIlIIIIIlIIIIIll.scissorBoxWidth, 0.05 * Minecraft.getSystemTime() / 4.0);
                if (lllllllllllllIIllIlIIIIIlIIIIIll.scissorBoxWidth < 1.0) {
                    NotificationPublisher.NOTIFICATIONS.remove(lllllllllllllIIllIlIIIIIlIIIIIll);
                }
                lllllllllllllIIllIlIIIIIlIIIIlII += 30;
            }
            final float lllllllllllllIIllIlIIIIIlIIIIIII = (float)lllllllllllllIIllIlIIIIIlIIIIIlI.getX();
            final float lllllllllllllIIllIlIIIIIIlllllll = (float)lllllllllllllIIllIlIIIIIlIIIIIlI.getY();
            GL11.glPushMatrix();
            GL11.glEnable(3089);
            final int lllllllllllllIIllIlIIIIIIllllllI = 0;
            final int lllllllllllllIIllIlIIIIIIlllllIl = 0;
            prepareScissorBox((float)(lllllllllllllIIllIlIIIIIlIIIIlIl - lllllllllllllIIllIlIIIIIlIIIIIll.scissorBoxWidth), lllllllllllllIIllIlIIIIIIlllllll, (float)lllllllllllllIIllIlIIIIIlIIIIlIl, lllllllllllllIIllIlIIIIIIlllllll + 30.0f);
            RenderUtils.drawRoundedRect1(lllllllllllllIIllIlIIIIIlIIIIIII, lllllllllllllIIllIlIIIIIIlllllll, lllllllllllllIIllIlIIIIIlIIIIlIl - 5, lllllllllllllIIllIlIIIIIIlllllll + 28.0f, new Color(22, 22, 22, 175).getRGB(), new Color(22, 22, 22, 175).getRGB());
            RenderUtils.drawRect(lllllllllllllIIllIlIIIIIlIIIIIII, lllllllllllllIIllIlIIIIIIlllllll, (float)(lllllllllllllIIllIlIIIIIlIIIIlIl - 98), lllllllllllllIIllIlIIIIIIlllllll + 28.0f, ColorUtils.astolfoColors1(lllllllllllllIIllIlIIIIIIlllllll + 28.0f, 0.0f));
            Fonts.comfortaal20.drawStringWithShadow(lllllllllllllIIllIlIIIIIlIIIIIll.getTitle(), lllllllllllllIIllIlIIIIIlIIIIIII + 5.0f, lllllllllllllIIllIlIIIIIIlllllll + 5.0f, -1);
            Fonts.comfortaal16.drawStringWithShadow(lllllllllllllIIllIlIIIIIlIIIIIll.getContent(), lllllllllllllIIllIlIIIIIlIIIIIII + 6.0f, lllllllllllllIIllIlIIIIIIlllllll + 19.0f, -1);
            GL11.glDisable(3089);
            GL11.glPopMatrix();
            lllllllllllllIIllIlIIIIIlIIIIlII -= 33;
            lllllllllllllIIllIlIIIIIlIIIIlII -= 10;
        }
    }
    
    public static void queue(final String lllllllllllllIIllIlIIIIIIlIlIlII, final String lllllllllllllIIllIlIIIIIIlIlIIll, final NotificationType lllllllllllllIIllIlIIIIIIlIlIlll) {
        final Minecraft lllllllllllllIIllIlIIIIIIlIlIllI = Minecraft.getMinecraft();
        if (lllllllllllllIIllIlIIIIIIlIlIllI.world != null) {
            final FontRenderer lllllllllllllIIllIlIIIIIIlIlIlIl = lllllllllllllIIllIlIIIIIIlIlIllI.fontRendererObj;
            NotificationPublisher.NOTIFICATIONS.add(new Notification(lllllllllllllIIllIlIIIIIIlIlIlII, lllllllllllllIIllIlIIIIIIlIlIIll, lllllllllllllIIllIlIIIIIIlIlIlll, lllllllllllllIIllIlIIIIIIlIlIlIl));
        }
    }
}
