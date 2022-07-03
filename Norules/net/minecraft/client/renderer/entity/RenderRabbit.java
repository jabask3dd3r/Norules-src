package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.text.*;

public class RenderRabbit extends RenderLiving<EntityRabbit>
{
    private static final /* synthetic */ ResourceLocation BLACK;
    private static final /* synthetic */ ResourceLocation CAERBANNOG;
    private static final /* synthetic */ ResourceLocation BROWN;
    private static final /* synthetic */ ResourceLocation WHITE_SPLOTCHED;
    private static final /* synthetic */ ResourceLocation GOLD;
    private static final /* synthetic */ ResourceLocation TOAST;
    private static final /* synthetic */ ResourceLocation WHITE;
    private static final /* synthetic */ ResourceLocation SALT;
    
    public RenderRabbit(final RenderManager llllllllllllllIIlIIIIlIIIIlllIlI) {
        super(llllllllllllllIIlIIIIlIIIIlllIlI, new ModelRabbit(), 0.3f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityRabbit llllllllllllllIIlIIIIlIIIIllIIlI) {
        final String llllllllllllllIIlIIIIlIIIIllIIll = TextFormatting.getTextWithoutFormattingCodes(llllllllllllllIIlIIIIlIIIIllIIlI.getName());
        if (llllllllllllllIIlIIIIlIIIIllIIll != null && "Toast".equals(llllllllllllllIIlIIIIlIIIIllIIll)) {
            return RenderRabbit.TOAST;
        }
        switch (llllllllllllllIIlIIIIlIIIIllIIlI.getRabbitType()) {
            default: {
                return RenderRabbit.BROWN;
            }
            case 1: {
                return RenderRabbit.WHITE;
            }
            case 2: {
                return RenderRabbit.BLACK;
            }
            case 3: {
                return RenderRabbit.WHITE_SPLOTCHED;
            }
            case 4: {
                return RenderRabbit.GOLD;
            }
            case 5: {
                return RenderRabbit.SALT;
            }
            case 99: {
                return RenderRabbit.CAERBANNOG;
            }
        }
    }
    
    static {
        BROWN = new ResourceLocation("textures/entity/rabbit/brown.png");
        WHITE = new ResourceLocation("textures/entity/rabbit/white.png");
        BLACK = new ResourceLocation("textures/entity/rabbit/black.png");
        GOLD = new ResourceLocation("textures/entity/rabbit/gold.png");
        SALT = new ResourceLocation("textures/entity/rabbit/salt.png");
        WHITE_SPLOTCHED = new ResourceLocation("textures/entity/rabbit/white_splotched.png");
        TOAST = new ResourceLocation("textures/entity/rabbit/toast.png");
        CAERBANNOG = new ResourceLocation("textures/entity/rabbit/caerbannog.png");
    }
}
