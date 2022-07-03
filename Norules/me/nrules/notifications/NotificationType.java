package me.nrules.notifications;

import java.awt.*;

public enum NotificationType
{
    private final /* synthetic */ int color;
    
    SUCCESS("SUCCESS", 0, new Color(6348946).getRGB()), 
    WARNING("WARNING", 3, new Color(16752943).getRGB()), 
    INFO("INFO", 1, new Color(255, 255, 255).getRGB()), 
    DISABLE("DISABLE", 2, new Color(255, 0, 0).getRGB());
    
    public final int getColor() {
        return this.color;
    }
    
    private NotificationType(final String llllllllllllllIlIIIIlllIIIIIIIIl, final int llllllllllllllIlIIIIlllIIIIIIIII, final int llllllllllllllIlIIIIllIlllllllll) {
        this.color = llllllllllllllIlIIIIllIlllllllll;
    }
}
