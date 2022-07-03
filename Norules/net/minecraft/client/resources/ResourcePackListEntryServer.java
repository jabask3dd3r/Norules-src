package net.minecraft.client.resources;

import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.texture.*;
import java.io.*;
import net.minecraft.client.resources.data.*;
import com.google.gson.*;
import net.minecraft.util.text.*;
import org.apache.logging.log4j.*;

public class ResourcePackListEntryServer extends ResourcePackListEntry
{
    private final /* synthetic */ IResourcePack resourcePack;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ ResourceLocation resourcePackIcon;
    
    public ResourcePackListEntryServer(final GuiScreenResourcePacks lllllllllllllllIllIIIlIIIllIlllI, final IResourcePack lllllllllllllllIllIIIlIIIllIIlll) {
        super(lllllllllllllllIllIIIlIIIllIlllI);
        this.resourcePack = lllllllllllllllIllIIIlIIIllIIlll;
        DynamicTexture lllllllllllllllIllIIIlIIIllIlIll = null;
        try {
            final DynamicTexture lllllllllllllllIllIIIlIIIllIllII = new DynamicTexture(lllllllllllllllIllIIIlIIIllIIlll.getPackImage());
        }
        catch (IOException lllllllllllllllIllIIIlIIIllIlIlI) {
            lllllllllllllllIllIIIlIIIllIlIll = TextureUtil.MISSING_TEXTURE;
        }
        this.resourcePackIcon = this.mc.getTextureManager().getDynamicTextureLocation("texturepackicon", lllllllllllllllIllIIIlIIIllIlIll);
    }
    
    @Override
    protected boolean canMoveLeft() {
        return false;
    }
    
    @Override
    protected boolean canMoveDown() {
        return false;
    }
    
    @Override
    protected boolean canMoveUp() {
        return false;
    }
    
    @Override
    protected boolean showHoverOverlay() {
        return false;
    }
    
    @Override
    protected String getResourcePackDescription() {
        try {
            final PackMetadataSection lllllllllllllllIllIIIlIIIllIIIII = this.resourcePack.getPackMetadata(this.mc.getResourcePackRepository().rprMetadataSerializer, "pack");
            if (lllllllllllllllIllIIIlIIIllIIIII != null) {
                return lllllllllllllllIllIIIlIIIllIIIII.getPackDescription().getFormattedText();
            }
        }
        catch (JsonParseException lllllllllllllllIllIIIlIIIlIlllll) {
            ResourcePackListEntryServer.LOGGER.error("Couldn't load metadata info", (Throwable)lllllllllllllllIllIIIlIIIlIlllll);
        }
        catch (IOException lllllllllllllllIllIIIlIIIlIllllI) {
            ResourcePackListEntryServer.LOGGER.error("Couldn't load metadata info", (Throwable)lllllllllllllllIllIIIlIIIlIllllI);
        }
        return String.valueOf(new StringBuilder().append(TextFormatting.RED).append("Missing ").append("pack.mcmeta").append(" :("));
    }
    
    @Override
    protected int getResourcePackFormat() {
        return 3;
    }
    
    @Override
    protected boolean canMoveRight() {
        return false;
    }
    
    @Override
    protected void bindResourcePackIcon() {
        this.mc.getTextureManager().bindTexture(this.resourcePackIcon);
    }
    
    @Override
    protected String getResourcePackName() {
        return "Server";
    }
    
    @Override
    public boolean isServerPack() {
        return true;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
