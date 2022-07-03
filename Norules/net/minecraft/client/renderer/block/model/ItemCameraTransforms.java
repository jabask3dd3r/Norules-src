package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.*;
import org.lwjgl.util.vector.*;
import net.minecraft.util.math.*;
import java.lang.reflect.*;
import com.google.gson.*;

public class ItemCameraTransforms
{
    public static /* synthetic */ float offsetTranslateY;
    public static /* synthetic */ float offsetScaleZ;
    public static /* synthetic */ float offsetRotationZ;
    public final /* synthetic */ ItemTransformVec3f thirdperson_right;
    public final /* synthetic */ ItemTransformVec3f head;
    public final /* synthetic */ ItemTransformVec3f firstperson_right;
    public static /* synthetic */ float offsetTranslateX;
    public final /* synthetic */ ItemTransformVec3f firstperson_left;
    public final /* synthetic */ ItemTransformVec3f thirdperson_left;
    public static /* synthetic */ float offsetScaleY;
    public static /* synthetic */ float offsetRotationX;
    public final /* synthetic */ ItemTransformVec3f ground;
    public final /* synthetic */ ItemTransformVec3f fixed;
    public static /* synthetic */ float offsetScaleX;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType;
    public static /* synthetic */ float offsetTranslateZ;
    public final /* synthetic */ ItemTransformVec3f gui;
    public static /* synthetic */ float offsetRotationY;
    
    public ItemCameraTransforms(final ItemTransformVec3f llllllllllllllllIlllIIlIIlIIIlIl, final ItemTransformVec3f llllllllllllllllIlllIIlIIlIIIlII, final ItemTransformVec3f llllllllllllllllIlllIIlIIlIIIIll, final ItemTransformVec3f llllllllllllllllIlllIIlIIlIIlIll, final ItemTransformVec3f llllllllllllllllIlllIIlIIlIIlIlI, final ItemTransformVec3f llllllllllllllllIlllIIlIIlIIIIII, final ItemTransformVec3f llllllllllllllllIlllIIlIIlIIlIII, final ItemTransformVec3f llllllllllllllllIlllIIlIIlIIIlll) {
        this.thirdperson_left = llllllllllllllllIlllIIlIIlIIIlIl;
        this.thirdperson_right = llllllllllllllllIlllIIlIIlIIIlII;
        this.firstperson_left = llllllllllllllllIlllIIlIIlIIIIll;
        this.firstperson_right = llllllllllllllllIlllIIlIIlIIlIll;
        this.head = llllllllllllllllIlllIIlIIlIIlIlI;
        this.gui = llllllllllllllllIlllIIlIIlIIIIII;
        this.ground = llllllllllllllllIlllIIlIIlIIlIII;
        this.fixed = llllllllllllllllIlllIIlIIlIIIlll;
    }
    
    public ItemCameraTransforms(final ItemCameraTransforms llllllllllllllllIlllIIlIIlIllIIl) {
        this.thirdperson_left = llllllllllllllllIlllIIlIIlIllIIl.thirdperson_left;
        this.thirdperson_right = llllllllllllllllIlllIIlIIlIllIIl.thirdperson_right;
        this.firstperson_left = llllllllllllllllIlllIIlIIlIllIIl.firstperson_left;
        this.firstperson_right = llllllllllllllllIlllIIlIIlIllIIl.firstperson_right;
        this.head = llllllllllllllllIlllIIlIIlIllIIl.head;
        this.gui = llllllllllllllllIlllIIlIIlIllIIl.gui;
        this.ground = llllllllllllllllIlllIIlIIlIllIIl.ground;
        this.fixed = llllllllllllllllIlllIIlIIlIllIIl.fixed;
    }
    
    public boolean hasCustomTransform(final TransformType llllllllllllllllIlllIIIllllllIII) {
        return this.getTransform(llllllllllllllllIlllIIIllllllIII) != ItemTransformVec3f.DEFAULT;
    }
    
    static {
        DEFAULT = new ItemCameraTransforms();
    }
    
    public ItemTransformVec3f getTransform(final TransformType llllllllllllllllIlllIIIlllllllII) {
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType()[llllllllllllllllIlllIIIlllllllII.ordinal()]) {
            case 2: {
                return this.thirdperson_left;
            }
            case 3: {
                return this.thirdperson_right;
            }
            case 4: {
                return this.firstperson_left;
            }
            case 5: {
                return this.firstperson_right;
            }
            case 6: {
                return this.head;
            }
            case 7: {
                return this.gui;
            }
            case 8: {
                return this.ground;
            }
            case 9: {
                return this.fixed;
            }
            default: {
                return ItemTransformVec3f.DEFAULT;
            }
        }
    }
    
    public static void applyTransformSide(final ItemTransformVec3f llllllllllllllllIlllIIlIIIllIIIl, final boolean llllllllllllllllIlllIIlIIIlIlIlI) {
        if (llllllllllllllllIlllIIlIIIllIIIl != ItemTransformVec3f.DEFAULT) {
            final int llllllllllllllllIlllIIlIIIlIllll = llllllllllllllllIlllIIlIIIlIlIlI ? -1 : 1;
            GlStateManager.translate(llllllllllllllllIlllIIlIIIlIllll * (ItemCameraTransforms.offsetTranslateX + llllllllllllllllIlllIIlIIIllIIIl.translation.x), ItemCameraTransforms.offsetTranslateY + llllllllllllllllIlllIIlIIIllIIIl.translation.y, ItemCameraTransforms.offsetTranslateZ + llllllllllllllllIlllIIlIIIllIIIl.translation.z);
            final float llllllllllllllllIlllIIlIIIlIlllI = ItemCameraTransforms.offsetRotationX + llllllllllllllllIlllIIlIIIllIIIl.rotation.x;
            float llllllllllllllllIlllIIlIIIlIllIl = ItemCameraTransforms.offsetRotationY + llllllllllllllllIlllIIlIIIllIIIl.rotation.y;
            float llllllllllllllllIlllIIlIIIlIllII = ItemCameraTransforms.offsetRotationZ + llllllllllllllllIlllIIlIIIllIIIl.rotation.z;
            if (llllllllllllllllIlllIIlIIIlIlIlI) {
                llllllllllllllllIlllIIlIIIlIllIl = -llllllllllllllllIlllIIlIIIlIllIl;
                llllllllllllllllIlllIIlIIIlIllII = -llllllllllllllllIlllIIlIIIlIllII;
            }
            GlStateManager.rotate(makeQuaternion(llllllllllllllllIlllIIlIIIlIlllI, llllllllllllllllIlllIIlIIIlIllIl, llllllllllllllllIlllIIlIIIlIllII));
            GlStateManager.scale(ItemCameraTransforms.offsetScaleX + llllllllllllllllIlllIIlIIIllIIIl.scale.x, ItemCameraTransforms.offsetScaleY + llllllllllllllllIlllIIlIIIllIIIl.scale.y, ItemCameraTransforms.offsetScaleZ + llllllllllllllllIlllIIlIIIllIIIl.scale.z);
        }
    }
    
    public void applyTransform(final TransformType llllllllllllllllIlllIIlIIIlllIlI) {
        applyTransformSide(this.getTransform(llllllllllllllllIlllIIlIIIlllIlI), false);
    }
    
    private static Quaternion makeQuaternion(final float llllllllllllllllIlllIIlIIIIIllIl, final float llllllllllllllllIlllIIlIIIIllIII, final float llllllllllllllllIlllIIlIIIIlIlll) {
        final float llllllllllllllllIlllIIlIIIIlIllI = llllllllllllllllIlllIIlIIIIIllIl * 0.017453292f;
        final float llllllllllllllllIlllIIlIIIIlIlIl = llllllllllllllllIlllIIlIIIIllIII * 0.017453292f;
        final float llllllllllllllllIlllIIlIIIIlIlII = llllllllllllllllIlllIIlIIIIlIlll * 0.017453292f;
        final float llllllllllllllllIlllIIlIIIIlIIll = MathHelper.sin(0.5f * llllllllllllllllIlllIIlIIIIlIllI);
        final float llllllllllllllllIlllIIlIIIIlIIlI = MathHelper.cos(0.5f * llllllllllllllllIlllIIlIIIIlIllI);
        final float llllllllllllllllIlllIIlIIIIlIIIl = MathHelper.sin(0.5f * llllllllllllllllIlllIIlIIIIlIlIl);
        final float llllllllllllllllIlllIIlIIIIlIIII = MathHelper.cos(0.5f * llllllllllllllllIlllIIlIIIIlIlIl);
        final float llllllllllllllllIlllIIlIIIIIllll = MathHelper.sin(0.5f * llllllllllllllllIlllIIlIIIIlIlII);
        final float llllllllllllllllIlllIIlIIIIIlllI = MathHelper.cos(0.5f * llllllllllllllllIlllIIlIIIIlIlII);
        return new Quaternion(llllllllllllllllIlllIIlIIIIlIIll * llllllllllllllllIlllIIlIIIIlIIII * llllllllllllllllIlllIIlIIIIIlllI + llllllllllllllllIlllIIlIIIIlIIlI * llllllllllllllllIlllIIlIIIIlIIIl * llllllllllllllllIlllIIlIIIIIllll, llllllllllllllllIlllIIlIIIIlIIlI * llllllllllllllllIlllIIlIIIIlIIIl * llllllllllllllllIlllIIlIIIIIlllI - llllllllllllllllIlllIIlIIIIlIIll * llllllllllllllllIlllIIlIIIIlIIII * llllllllllllllllIlllIIlIIIIIllll, llllllllllllllllIlllIIlIIIIlIIll * llllllllllllllllIlllIIlIIIIlIIIl * llllllllllllllllIlllIIlIIIIIlllI + llllllllllllllllIlllIIlIIIIlIIlI * llllllllllllllllIlllIIlIIIIlIIII * llllllllllllllllIlllIIlIIIIIllll, llllllllllllllllIlllIIlIIIIlIIlI * llllllllllllllllIlllIIlIIIIlIIII * llllllllllllllllIlllIIlIIIIIlllI - llllllllllllllllIlllIIlIIIIlIIll * llllllllllllllllIlllIIlIIIIlIIIl * llllllllllllllllIlllIIlIIIIIllll);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType = ItemCameraTransforms.$SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType;
        if ($switch_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType != null) {
            return $switch_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType;
        }
        final int llllllllllllllllIlllIIIlllllIlII = (Object)new int[TransformType.values().length];
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.FIRST_PERSON_LEFT_HAND.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.FIRST_PERSON_RIGHT_HAND.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.FIXED.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.GROUND.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.GUI.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.HEAD.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.THIRD_PERSON_LEFT_HAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllllIlllIIIlllllIlII[TransformType.THIRD_PERSON_RIGHT_HAND.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        return ItemCameraTransforms.$SWITCH_TABLE$net$minecraft$client$renderer$block$model$ItemCameraTransforms$TransformType = (int[])(Object)llllllllllllllllIlllIIIlllllIlII;
    }
    
    private ItemCameraTransforms() {
        this(ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT, ItemTransformVec3f.DEFAULT);
    }
    
    static class Deserializer implements JsonDeserializer<ItemCameraTransforms>
    {
        private ItemTransformVec3f getTransform(final JsonDeserializationContext llIIIIlII, final JsonObject llIIIIIII, final String llIIIIIlI) {
            return (ItemTransformVec3f)(llIIIIIII.has(llIIIIIlI) ? llIIIIlII.deserialize(llIIIIIII.get(llIIIIIlI), (Type)ItemTransformVec3f.class) : ItemTransformVec3f.DEFAULT);
        }
        
        public ItemCameraTransforms deserialize(final JsonElement llIIlIIll, final Type llIIlllll, final JsonDeserializationContext llIIllllI) throws JsonParseException {
            final JsonObject llIIlllIl = llIIlIIll.getAsJsonObject();
            final ItemTransformVec3f llIIlllII = this.getTransform(llIIllllI, llIIlllIl, "thirdperson_righthand");
            ItemTransformVec3f llIIllIll = this.getTransform(llIIllllI, llIIlllIl, "thirdperson_lefthand");
            if (llIIllIll == ItemTransformVec3f.DEFAULT) {
                llIIllIll = llIIlllII;
            }
            final ItemTransformVec3f llIIllIlI = this.getTransform(llIIllllI, llIIlllIl, "firstperson_righthand");
            ItemTransformVec3f llIIllIIl = this.getTransform(llIIllllI, llIIlllIl, "firstperson_lefthand");
            if (llIIllIIl == ItemTransformVec3f.DEFAULT) {
                llIIllIIl = llIIllIlI;
            }
            final ItemTransformVec3f llIIllIII = this.getTransform(llIIllllI, llIIlllIl, "head");
            final ItemTransformVec3f llIIlIlll = this.getTransform(llIIllllI, llIIlllIl, "gui");
            final ItemTransformVec3f llIIlIllI = this.getTransform(llIIllllI, llIIlllIl, "ground");
            final ItemTransformVec3f llIIlIlIl = this.getTransform(llIIllllI, llIIlllIl, "fixed");
            return new ItemCameraTransforms(llIIllIll, llIIlllII, llIIllIIl, llIIllIlI, llIIllIII, llIIlIlll, llIIlIllI, llIIlIlIl);
        }
    }
    
    public enum TransformType
    {
        THIRD_PERSON_RIGHT_HAND("THIRD_PERSON_RIGHT_HAND", 2), 
        HEAD("HEAD", 5), 
        NONE("NONE", 0), 
        FIRST_PERSON_LEFT_HAND("FIRST_PERSON_LEFT_HAND", 3), 
        FIRST_PERSON_RIGHT_HAND("FIRST_PERSON_RIGHT_HAND", 4), 
        THIRD_PERSON_LEFT_HAND("THIRD_PERSON_LEFT_HAND", 1), 
        FIXED("FIXED", 8), 
        GUI("GUI", 6), 
        GROUND("GROUND", 7);
        
        private TransformType(final String lllllllllllllllIllIlIlIlIlllIlll, final int lllllllllllllllIllIlIlIlIlllIllI) {
        }
    }
}
