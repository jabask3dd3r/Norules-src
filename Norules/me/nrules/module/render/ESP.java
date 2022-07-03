package me.nrules.module.render;

import me.nrules.notifications.*;
import me.nrules.event.events.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import me.nrules.utils.friend.*;
import java.awt.*;
import me.nrules.utils.render.*;
import me.nrules.event.*;
import me.nrules.module.*;

public class ESP extends Module
{
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    @EventTarget
    public void onRender2D(final EventRender3D llllllllllllIlllllIIIllIlIllIIII) {
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableDepth();
        for (final Entity llllllllllllIlllllIIIllIlIlIllll : ESP.mc.world.loadedEntityList) {
            if (llllllllllllIlllllIIIllIlIlIllll instanceof EntityPlayer && llllllllllllIlllllIIIllIlIlIllll != ESP.mc.getRenderViewEntity()) {
                if (FriendManager.isFriend(llllllllllllIlllllIIIllIlIlIllll.getName())) {
                    RenderUtils.renderEntityBoundingBox(llllllllllllIlllllIIIllIlIlIllll, new Color(231, 231, 231, 255), 200.0f);
                    RenderUtils.renderEntityFilledBoundingBox(llllllllllllIlllllIIIllIlIlIllll, new Color(77, 154, 106, 255), 200.0f);
                }
                else {
                    RenderUtils.renderEntityBoundingBox(llllllllllllIlllllIIIllIlIlIllll, new Color(255, 255, 255, 255), 200.0f);
                    RenderUtils.renderEntityFilledBoundingBox(llllllllllllIlllllIIIllIlIlIllll, new Color(255, 255, 255, 255), 200.0f);
                }
            }
        }
        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.popMatrix();
    }
    
    public ESP() {
        super("ESP", 0, Category.RENDER);
    }
}
