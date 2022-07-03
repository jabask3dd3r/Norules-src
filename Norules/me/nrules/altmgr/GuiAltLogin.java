package me.nrules.altmgr;

import java.security.*;
import me.nrules.utils.world.*;
import java.io.*;
import org.lwjgl.input.*;
import font.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import java.awt.*;
import me.nrules.utils.render.*;
import net.minecraft.util.text.*;

public final class GuiAltLogin extends GuiScreen
{
    private /* synthetic */ GuiTextField username;
    private final /* synthetic */ GuiScreen previousScreen;
    private static /* synthetic */ String alphabet;
    private /* synthetic */ PasswordField password;
    /* synthetic */ MinecraftFontRenderer font;
    private /* synthetic */ AltLoginThread thread;
    private static final /* synthetic */ SecureRandom secureRandom;
    private final /* synthetic */ long initTime;
    /* synthetic */ TimerHelper timerHelper;
    /* synthetic */ float scaling;
    
    @Override
    protected void keyTyped(final char lllllllllllllllIIIllIIlIllIIlIlI, final int lllllllllllllllIIIllIIlIllIIIllI) {
        try {
            super.keyTyped(lllllllllllllllIIIllIIlIllIIlIlI, lllllllllllllllIIIllIIlIllIIIllI);
        }
        catch (IOException ex) {}
        if (lllllllllllllllIIIllIIlIllIIlIlI == '\t') {
            if (!this.username.isFocused() && !this.password.isFocused()) {
                this.username.setFocused(true);
            }
            else {
                this.username.setFocused(this.password.isFocused());
                this.password.setFocused(!this.username.isFocused());
            }
        }
        if (lllllllllllllllIIIllIIlIllIIlIlI == '\r') {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(lllllllllllllllIIIllIIlIllIIlIlI, lllllllllllllllIIIllIIlIllIIIllI);
        this.password.textboxKeyTyped(lllllllllllllllIIIllIIlIllIIlIlI, lllllllllllllllIIIllIIlIllIIIllI);
    }
    
    @Override
    public void updateScreen() {
        this.username.updateCursorCounter();
        this.password.updateCursorCounter();
    }
    
    public static String randomString(final int lllllllllllllllIIIllIIlIllllIIll) {
        final StringBuilder lllllllllllllllIIIllIIlIllllIIlI = new StringBuilder(lllllllllllllllIIIllIIlIllllIIll);
        for (int lllllllllllllllIIIllIIlIllllIIIl = 0; lllllllllllllllIIIllIIlIllllIIIl < lllllllllllllllIIIllIIlIllllIIll; ++lllllllllllllllIIIllIIlIllllIIIl) {
            lllllllllllllllIIIllIIlIllllIIlI.append(GuiAltLogin.alphabet.charAt(GuiAltLogin.secureRandom.nextInt(GuiAltLogin.alphabet.length())));
        }
        return String.valueOf(lllllllllllllllIIIllIIlIllllIIlI);
    }
    
    @Override
    public void initGui() {
        final int lllllllllllllllIIIllIIlIllIlIIlI = this.height / 4 + 24;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50, lllllllllllllllIIIllIIlIllIlIIlI + 60, 90, 13, "login"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 50, lllllllllllllllIIIllIIlIllIlIIlI + 63 + 12, 90, 13, "random name"));
        this.username = new GuiTextField(lllllllllllllllIIIllIIlIllIlIIlI, this.mc.fontRendererObj, this.width / 2 - 55, lllllllllllllllIIIllIIlIllIlIIlI + 20, 100, 13);
        this.password = new PasswordField(this.mc.fontRendererObj, this.width / 2 - 55, lllllllllllllllIIIllIIlIllIlIIlI + 40, 100, 13);
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents(true);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIIIllIIlIlIlllllI, final int lllllllllllllllIIIllIIlIlIllllIl, final int lllllllllllllllIIIllIIlIlIllllII) {
        try {
            super.mouseClicked(lllllllllllllllIIIllIIlIlIlllllI, lllllllllllllllIIIllIIlIlIllllIl, lllllllllllllllIIIllIIlIlIllllII);
        }
        catch (IOException lllllllllllllllIIIllIIlIlIlllIll) {
            lllllllllllllllIIIllIIlIlIlllIll.printStackTrace();
        }
        this.username.mouseClicked(lllllllllllllllIIIllIIlIlIlllllI, lllllllllllllllIIIllIIlIlIllllIl, lllllllllllllllIIIllIIlIlIllllII);
        this.password.mouseClicked(lllllllllllllllIIIllIIlIlIlllllI, lllllllllllllllIIIllIIlIlIllllIl, lllllllllllllllIIIllIIlIlIllllII);
    }
    
    public GuiAltLogin(final GuiScreen lllllllllllllllIIIllIIlIllllIlll) {
        this.initTime = System.currentTimeMillis();
        this.font = FontLoader.INSTANCE.roboto_bold_12;
        this.timerHelper = new TimerHelper();
        this.previousScreen = lllllllllllllllIIIllIIlIllllIlll;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIIllIIlIlllIIIII, final int lllllllllllllllIIIllIIlIllIlllll, final float lllllllllllllllIIIllIIlIllIllIII) {
        final ScaledResolution lllllllllllllllIIIllIIlIllIlllIl = new ScaledResolution(this.mc);
        if (this.scaling <= 1.0f) {
            this.scaling += (float)0.2;
        }
        if (this.scaling > 1.0f) {
            this.scaling = 1.0f;
        }
        GL11.glPushMatrix();
        GL11.glTranslated((double)(this.width / 4), (double)(this.height / 2), (double)(this.width / 4));
        GL11.glScalef(this.scaling, this.scaling, this.scaling);
        GL11.glTranslated((double)(-this.width / 4), (double)(-this.height / 2), (double)(-this.width / 4));
        this.drawGradientRect(0.0, 0.0, this.width, this.height, 2114720, new Color(0, 0, 0, 18).getRGB());
        GL11.glPopMatrix();
        final int lllllllllllllllIIIllIIlIllIlllII = this.height / 4 + 24;
        RenderUtils.drawBorderedRect(this.width / 2 - 70, lllllllllllllllIIIllIIlIllIlllII - 21, this.width / 2 + 60, lllllllllllllllIIIllIIlIllIlllII + 110, 1.0, new Color(40, 40, 40, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), false);
        RenderUtils.drawBorderedRect(this.width / 2 - 66, lllllllllllllllIIIllIIlIllIlllII - 17, this.width / 2 + 56, lllllllllllllllIIIllIIlIllIlllII + 106, 1.0, new Color(22, 22, 22, 255).getRGB(), new Color(70, 70, 70, 255).getRGB(), false);
        this.username.drawTextBox();
        this.password.drawTextBox();
        this.font.drawCenteredString("Alt Manager", this.width / 2 - 3, lllllllllllllllIIIllIIlIllIlllII, -1);
        this.font.drawCenteredString((this.thread == null) ? String.valueOf(new StringBuilder().append(TextFormatting.GRAY)) : this.thread.getStatus(), this.width / 2 - 4, lllllllllllllllIIIllIIlIllIlllII + 98, -1);
        if (this.username.getText().isEmpty() && !this.username.isFocused()) {
            this.font.drawStringWithShadow("email", this.width / 2 - 52, lllllllllllllllIIIllIIlIllIlllII + 24, -7829368);
        }
        if (this.password.getText().isEmpty() && !this.password.isFocused()) {
            this.font.drawStringWithShadow("password", this.width / 2 - 53, lllllllllllllllIIIllIIlIllIlllII + 43, -7829368);
        }
        super.drawScreen(lllllllllllllllIIIllIIlIlllIIIII, lllllllllllllllIIIllIIlIllIlllll, lllllllllllllllIIIllIIlIllIllIII);
    }
    
    static {
        GuiAltLogin.alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        secureRandom = new SecureRandom();
        GuiAltLogin.alphabet = String.valueOf(new StringBuilder(String.valueOf(GuiAltLogin.alphabet)).append(GuiAltLogin.alphabet.toLowerCase()));
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIIllIIlIlllIlIII) {
        switch (lllllllllllllllIIIllIIlIlllIlIII.id) {
            case 2: {
                this.thread = new AltLoginThread(String.valueOf(new StringBuilder("NRFree").append(randomString(5))), "");
                this.thread.start();
                break;
            }
            case 0: {
                this.thread = new AltLoginThread(this.username.getText(), this.password.getText());
                this.thread.start();
                break;
            }
        }
    }
}
