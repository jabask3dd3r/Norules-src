package me.nrules.notifications;

import me.nrules.utils.render.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public final class Notification
{
    private final /* synthetic */ Stopwatch timer;
    private final /* synthetic */ Shifting translate;
    private final /* synthetic */ FontRenderer fontRenderer;
    private final /* synthetic */ String title;
    private final /* synthetic */ int time;
    private final /* synthetic */ NotificationType type;
    private final /* synthetic */ String content;
    
    public final Shifting getTranslate() {
        return this.translate;
    }
    
    public final String getContent() {
        return this.content;
    }
    
    public Notification(final String lllllllllllllIlllIlllIlllIlIIllI, final String lllllllllllllIlllIlllIlllIlIIlIl, final NotificationType lllllllllllllIlllIlllIlllIlIIlII, final FontRenderer lllllllllllllIlllIlllIlllIlIlIIl) {
        this.title = lllllllllllllIlllIlllIlllIlIIllI;
        this.content = lllllllllllllIlllIlllIlllIlIIlIl;
        this.time = 1900;
        this.type = lllllllllllllIlllIlllIlllIlIIlII;
        this.timer = new Stopwatch();
        this.fontRenderer = lllllllllllllIlllIlllIlllIlIlIIl;
        final ScaledResolution lllllllllllllIlllIlllIlllIlIlIII = new ScaledResolution(Minecraft.getMinecraft());
        this.translate = new Shifting((float)(lllllllllllllIlllIlllIlllIlIlIII.getScaledWidth() - this.getWidth()), (float)(lllllllllllllIlllIlllIlllIlIlIII.getScaledHeight() - 30));
    }
    
    public final int getTime() {
        return this.time;
    }
    
    static {
        HEIGHT = 30;
    }
    
    public final NotificationType getType() {
        return this.type;
    }
    
    public final String getTitle() {
        return this.title;
    }
    
    public final Stopwatch getTimer() {
        return this.timer;
    }
    
    public final int getWidth() {
        return Math.max(100, Math.max(this.fontRenderer.getStringWidth(this.title), this.fontRenderer.getStringWidth(this.content)) + 10);
    }
}
