package optifine;

import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import net.minecraft.world.*;

public class CustomSkyLayer
{
    private /* synthetic */ int blend;
    private /* synthetic */ RangeListInt days;
    private /* synthetic */ boolean weatherRain;
    private /* synthetic */ int startFadeOut;
    private /* synthetic */ int endFadeIn;
    private /* synthetic */ int startFadeIn;
    public /* synthetic */ int textureId;
    private /* synthetic */ boolean weatherClear;
    private /* synthetic */ int daysLoop;
    private /* synthetic */ boolean weatherThunder;
    private /* synthetic */ int endFadeOut;
    private /* synthetic */ float[] axis;
    public static final /* synthetic */ float[] DEFAULT_AXIS;
    public /* synthetic */ String source;
    private /* synthetic */ boolean rotate;
    private /* synthetic */ float speed;
    
    private void renderSide(final Tessellator lllllllllllllllIIIlIIlllIIllIIIl, final int lllllllllllllllIIIlIIlllIIlllIIl) {
        final BufferBuilder lllllllllllllllIIIlIIlllIIllIlll = lllllllllllllllIIIlIIlllIIllIIIl.getBuffer();
        final double lllllllllllllllIIIlIIlllIIllIlIl = lllllllllllllllIIIlIIlllIIlllIIl % 3 / 3.0;
        final double lllllllllllllllIIIlIIlllIIllIIll = lllllllllllllllIIIlIIlllIIlllIIl / 3 / 2.0;
        lllllllllllllllIIIlIIlllIIllIlll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllllIIIlIIlllIIllIlll.pos(-100.0, -100.0, -100.0).tex(lllllllllllllllIIIlIIlllIIllIlIl, lllllllllllllllIIIlIIlllIIllIIll).endVertex();
        lllllllllllllllIIIlIIlllIIllIlll.pos(-100.0, -100.0, 100.0).tex(lllllllllllllllIIIlIIlllIIllIlIl, lllllllllllllllIIIlIIlllIIllIIll + 0.5).endVertex();
        lllllllllllllllIIIlIIlllIIllIlll.pos(100.0, -100.0, 100.0).tex(lllllllllllllllIIIlIIlllIIllIlIl + 0.3333333333333333, lllllllllllllllIIIlIIlllIIllIIll + 0.5).endVertex();
        lllllllllllllllIIIlIIlllIIllIlll.pos(100.0, -100.0, -100.0).tex(lllllllllllllllIIIlIIlllIIllIlIl + 0.3333333333333333, lllllllllllllllIIIlIIlllIIllIIll).endVertex();
        lllllllllllllllIIIlIIlllIIllIIIl.draw();
    }
    
    public void render(final int lllllllllllllllIIIlIIlllIllllllI, final float lllllllllllllllIIIlIIlllIlllllIl, final float lllllllllllllllIIIlIIlllIlllIIlI, final float lllllllllllllllIIIlIIlllIllllIll) {
        final float lllllllllllllllIIIlIIlllIllllIlI = 1.0f - lllllllllllllllIIIlIIlllIlllIIlI;
        final float lllllllllllllllIIIlIIlllIllllIIl = lllllllllllllllIIIlIIlllIlllIIlI - lllllllllllllllIIIlIIlllIllllIll;
        float lllllllllllllllIIIlIIlllIllllIII = 0.0f;
        if (this.weatherClear) {
            lllllllllllllllIIIlIIlllIllllIII += lllllllllllllllIIIlIIlllIllllIlI;
        }
        if (this.weatherRain) {
            lllllllllllllllIIIlIIlllIllllIII += lllllllllllllllIIIlIIlllIllllIIl;
        }
        if (this.weatherThunder) {
            lllllllllllllllIIIlIIlllIllllIII += lllllllllllllllIIIlIIlllIllllIll;
        }
        lllllllllllllllIIIlIIlllIllllIII = Config.limit(lllllllllllllllIIIlIIlllIllllIII, 0.0f, 1.0f);
        float lllllllllllllllIIIlIIlllIlllIlll = lllllllllllllllIIIlIIlllIllllIII * this.getFadeBrightness(lllllllllllllllIIIlIIlllIllllllI);
        lllllllllllllllIIIlIIlllIlllIlll = Config.limit(lllllllllllllllIIIlIIlllIlllIlll, 0.0f, 1.0f);
        if (lllllllllllllllIIIlIIlllIlllIlll >= 1.0E-4f) {
            GlStateManager.bindTexture(this.textureId);
            Blender.setupBlend(this.blend, lllllllllllllllIIIlIIlllIlllIlll);
            GlStateManager.pushMatrix();
            if (this.rotate) {
                GlStateManager.rotate(lllllllllllllllIIIlIIlllIlllllIl * 360.0f * this.speed, this.axis[0], this.axis[1], this.axis[2]);
            }
            final Tessellator lllllllllllllllIIIlIIlllIlllIllI = Tessellator.getInstance();
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(lllllllllllllllIIIlIIlllIlllIllI, 4);
            GlStateManager.pushMatrix();
            GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
            this.renderSide(lllllllllllllllIIIlIIlllIlllIllI, 1);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
            this.renderSide(lllllllllllllllIIIlIIlllIlllIllI, 0);
            GlStateManager.popMatrix();
            GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(lllllllllllllllIIIlIIlllIlllIllI, 5);
            GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(lllllllllllllllIIIlIIlllIlllIllI, 2);
            GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
            this.renderSide(lllllllllllllllIIIlIIlllIlllIllI, 3);
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.source).append(", ").append(this.startFadeIn).append("-").append(this.endFadeIn).append(" ").append(this.startFadeOut).append("-").append(this.endFadeOut));
    }
    
    private boolean parseBoolean(final String lllllllllllllllIIIlIIlllllIIlIII, final boolean lllllllllllllllIIIlIIlllllIIIlll) {
        if (lllllllllllllllIIIlIIlllllIIlIII == null) {
            return lllllllllllllllIIIlIIlllllIIIlll;
        }
        if (lllllllllllllllIIIlIIlllllIIlIII.toLowerCase().equals("true")) {
            return true;
        }
        if (lllllllllllllllIIIlIIlllllIIlIII.toLowerCase().equals("false")) {
            return false;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown boolean: ").append(lllllllllllllllIIIlIIlllllIIlIII)));
        return lllllllllllllllIIIlIIlllllIIIlll;
    }
    
    private boolean timeBetween(final int lllllllllllllllIIIlIIlllIIIIlIlI, final int lllllllllllllllIIIlIIlllIIIIllII, final int lllllllllllllllIIIlIIlllIIIIlIll) {
        if (lllllllllllllllIIIlIIlllIIIIllII <= lllllllllllllllIIIlIIlllIIIIlIll) {
            return lllllllllllllllIIIlIIlllIIIIlIlI >= lllllllllllllllIIIlIIlllIIIIllII && lllllllllllllllIIIlIIlllIIIIlIlI <= lllllllllllllllIIIlIIlllIIIIlIll;
        }
        return lllllllllllllllIIIlIIlllIIIIlIlI >= lllllllllllllllIIIlIIlllIIIIllII || lllllllllllllllIIIlIIlllIIIIlIlI <= lllllllllllllllIIIlIIlllIIIIlIll;
    }
    
    private float[] parseAxis(final String lllllllllllllllIIIlIIllllIllIIll, final float[] lllllllllllllllIIIlIIllllIlIlIIl) {
        if (lllllllllllllllIIIlIIllllIllIIll == null) {
            return lllllllllllllllIIIlIIllllIlIlIIl;
        }
        final String[] lllllllllllllllIIIlIIllllIllIIIl = Config.tokenize(lllllllllllllllIIIlIIllllIllIIll, " ");
        if (lllllllllllllllIIIlIIllllIllIIIl.length != 3) {
            Config.warn(String.valueOf(new StringBuilder("Invalid axis: ").append(lllllllllllllllIIIlIIllllIllIIll)));
            return lllllllllllllllIIIlIIllllIlIlIIl;
        }
        final float[] lllllllllllllllIIIlIIllllIllIIII = new float[3];
        for (int lllllllllllllllIIIlIIllllIlIllll = 0; lllllllllllllllIIIlIIllllIlIllll < lllllllllllllllIIIlIIllllIllIIIl.length; ++lllllllllllllllIIIlIIllllIlIllll) {
            lllllllllllllllIIIlIIllllIllIIII[lllllllllllllllIIIlIIllllIlIllll] = Config.parseFloat(lllllllllllllllIIIlIIllllIllIIIl[lllllllllllllllIIIlIIllllIlIllll], Float.MIN_VALUE);
            if (lllllllllllllllIIIlIIllllIllIIII[lllllllllllllllIIIlIIllllIlIllll] == Float.MIN_VALUE) {
                Config.warn(String.valueOf(new StringBuilder("Invalid axis: ").append(lllllllllllllllIIIlIIllllIllIIll)));
                return lllllllllllllllIIIlIIllllIlIlIIl;
            }
            if (lllllllllllllllIIIlIIllllIllIIII[lllllllllllllllIIIlIIllllIlIllll] < -1.0f || lllllllllllllllIIIlIIllllIllIIII[lllllllllllllllIIIlIIllllIlIllll] > 1.0f) {
                Config.warn(String.valueOf(new StringBuilder("Invalid axis values: ").append(lllllllllllllllIIIlIIllllIllIIll)));
                return lllllllllllllllIIIlIIllllIlIlIIl;
            }
        }
        final float lllllllllllllllIIIlIIllllIlIlllI = lllllllllllllllIIIlIIllllIllIIII[0];
        final float lllllllllllllllIIIlIIllllIlIllIl = lllllllllllllllIIIlIIllllIllIIII[1];
        final float lllllllllllllllIIIlIIllllIlIllII = lllllllllllllllIIIlIIllllIllIIII[2];
        if (lllllllllllllllIIIlIIllllIlIlllI * lllllllllllllllIIIlIIllllIlIlllI + lllllllllllllllIIIlIIllllIlIllIl * lllllllllllllllIIIlIIllllIlIllIl + lllllllllllllllIIIlIIllllIlIllII * lllllllllllllllIIIlIIllllIlIllII < 1.0E-5f) {
            Config.warn(String.valueOf(new StringBuilder("Invalid axis values: ").append(lllllllllllllllIIIlIIllllIllIIll)));
            return lllllllllllllllIIIlIIllllIlIlIIl;
        }
        final float[] lllllllllllllllIIIlIIllllIlIlIll = { lllllllllllllllIIIlIIllllIlIllII, lllllllllllllllIIIlIIllllIlIllIl, -lllllllllllllllIIIlIIllllIlIlllI };
        return lllllllllllllllIIIlIIllllIlIlIll;
    }
    
    public CustomSkyLayer(final Properties lllllllllllllllIIIlIIllllllllIlI, final String lllllllllllllllIIIlIIllllllllllI) {
        this.source = null;
        this.startFadeIn = -1;
        this.endFadeIn = -1;
        this.startFadeOut = -1;
        this.endFadeOut = -1;
        this.blend = 1;
        this.rotate = false;
        this.speed = 1.0f;
        this.axis = CustomSkyLayer.DEFAULT_AXIS;
        this.days = null;
        this.daysLoop = 8;
        this.weatherClear = true;
        this.weatherRain = false;
        this.weatherThunder = false;
        this.textureId = -1;
        final ConnectedParser lllllllllllllllIIIlIIlllllllllIl = new ConnectedParser("CustomSky");
        this.source = lllllllllllllllIIIlIIllllllllIlI.getProperty("source", lllllllllllllllIIIlIIllllllllllI);
        this.startFadeIn = this.parseTime(lllllllllllllllIIIlIIllllllllIlI.getProperty("startFadeIn"));
        this.endFadeIn = this.parseTime(lllllllllllllllIIIlIIllllllllIlI.getProperty("endFadeIn"));
        this.startFadeOut = this.parseTime(lllllllllllllllIIIlIIllllllllIlI.getProperty("startFadeOut"));
        this.endFadeOut = this.parseTime(lllllllllllllllIIIlIIllllllllIlI.getProperty("endFadeOut"));
        this.blend = Blender.parseBlend(lllllllllllllllIIIlIIllllllllIlI.getProperty("blend"));
        this.rotate = this.parseBoolean(lllllllllllllllIIIlIIllllllllIlI.getProperty("rotate"), true);
        this.speed = this.parseFloat(lllllllllllllllIIIlIIllllllllIlI.getProperty("speed"), 1.0f);
        this.axis = this.parseAxis(lllllllllllllllIIIlIIllllllllIlI.getProperty("axis"), CustomSkyLayer.DEFAULT_AXIS);
        this.days = lllllllllllllllIIIlIIlllllllllIl.parseRangeListInt(lllllllllllllllIIIlIIllllllllIlI.getProperty("days"));
        this.daysLoop = lllllllllllllllIIIlIIlllllllllIl.parseInt(lllllllllllllllIIIlIIllllllllIlI.getProperty("daysLoop"), 8);
        final List<String> lllllllllllllllIIIlIIlllllllllII = this.parseWeatherList(lllllllllllllllIIIlIIllllllllIlI.getProperty("weather", "clear"));
        this.weatherClear = lllllllllllllllIIIlIIlllllllllII.contains("clear");
        this.weatherRain = lllllllllllllllIIIlIIlllllllllII.contains("rain");
        this.weatherThunder = lllllllllllllllIIIlIIlllllllllII.contains("thunder");
    }
    
    private List<String> parseWeatherList(final String lllllllllllllllIIIlIIllllllIllll) {
        final List<String> lllllllllllllllIIIlIIllllllIlllI = Arrays.asList("clear", "rain", "thunder");
        final List<String> lllllllllllllllIIIlIIllllllIllIl = new ArrayList<String>();
        final String[] lllllllllllllllIIIlIIllllllIllII = Config.tokenize(lllllllllllllllIIIlIIllllllIllll, " ");
        for (int lllllllllllllllIIIlIIllllllIlIll = 0; lllllllllllllllIIIlIIllllllIlIll < lllllllllllllllIIIlIIllllllIllII.length; ++lllllllllllllllIIIlIIllllllIlIll) {
            final String lllllllllllllllIIIlIIllllllIlIlI = lllllllllllllllIIIlIIllllllIllII[lllllllllllllllIIIlIIllllllIlIll];
            if (!lllllllllllllllIIIlIIllllllIlllI.contains(lllllllllllllllIIIlIIllllllIlIlI)) {
                Config.warn(String.valueOf(new StringBuilder("Unknown weather: ").append(lllllllllllllllIIIlIIllllllIlIlI)));
            }
            else {
                lllllllllllllllIIIlIIllllllIllIl.add(lllllllllllllllIIIlIIllllllIlIlI);
            }
        }
        return lllllllllllllllIIIlIIllllllIllIl;
    }
    
    private int parseTime(final String lllllllllllllllIIIlIIlllllIllIll) {
        if (lllllllllllllllIIIlIIlllllIllIll == null) {
            return -1;
        }
        final String[] lllllllllllllllIIIlIIlllllIllIlI = Config.tokenize(lllllllllllllllIIIlIIlllllIllIll, ":");
        if (lllllllllllllllIIIlIIlllllIllIlI.length != 2) {
            Config.warn(String.valueOf(new StringBuilder("Invalid time: ").append(lllllllllllllllIIIlIIlllllIllIll)));
            return -1;
        }
        final String lllllllllllllllIIIlIIlllllIllIIl = lllllllllllllllIIIlIIlllllIllIlI[0];
        final String lllllllllllllllIIIlIIlllllIllIII = lllllllllllllllIIIlIIlllllIllIlI[1];
        int lllllllllllllllIIIlIIlllllIlIlll = Config.parseInt(lllllllllllllllIIIlIIlllllIllIIl, -1);
        final int lllllllllllllllIIIlIIlllllIlIllI = Config.parseInt(lllllllllllllllIIIlIIlllllIllIII, -1);
        if (lllllllllllllllIIIlIIlllllIlIlll >= 0 && lllllllllllllllIIIlIIlllllIlIlll <= 23 && lllllllllllllllIIIlIIlllllIlIllI >= 0 && lllllllllllllllIIIlIIlllllIlIllI <= 59) {
            lllllllllllllllIIIlIIlllllIlIlll -= 6;
            if (lllllllllllllllIIIlIIlllllIlIlll < 0) {
                lllllllllllllllIIIlIIlllllIlIlll += 24;
            }
            final int lllllllllllllllIIIlIIlllllIlIlIl = lllllllllllllllIIIlIIlllllIlIlll * 1000 + (int)(lllllllllllllllIIIlIIlllllIlIllI / 60.0 * 1000.0);
            return lllllllllllllllIIIlIIlllllIlIlIl;
        }
        Config.warn(String.valueOf(new StringBuilder("Invalid time: ").append(lllllllllllllllIIIlIIlllllIllIll)));
        return -1;
    }
    
    private float getFadeBrightness(final int lllllllllllllllIIIlIIlllIlIlIlII) {
        if (this.timeBetween(lllllllllllllllIIIlIIlllIlIlIlII, this.startFadeIn, this.endFadeIn)) {
            final int lllllllllllllllIIIlIIlllIlIlllIl = this.normalizeTime(this.endFadeIn - this.startFadeIn);
            final int lllllllllllllllIIIlIIlllIlIlllII = this.normalizeTime(lllllllllllllllIIIlIIlllIlIlIlII - this.startFadeIn);
            return lllllllllllllllIIIlIIlllIlIlllII / (float)lllllllllllllllIIIlIIlllIlIlllIl;
        }
        if (this.timeBetween(lllllllllllllllIIIlIIlllIlIlIlII, this.endFadeIn, this.startFadeOut)) {
            return 1.0f;
        }
        if (this.timeBetween(lllllllllllllllIIIlIIlllIlIlIlII, this.startFadeOut, this.endFadeOut)) {
            final int lllllllllllllllIIIlIIlllIlIllIlI = this.normalizeTime(this.endFadeOut - this.startFadeOut);
            final int lllllllllllllllIIIlIIlllIlIllIII = this.normalizeTime(lllllllllllllllIIIlIIlllIlIlIlII - this.startFadeOut);
            return 1.0f - lllllllllllllllIIIlIIlllIlIllIII / (float)lllllllllllllllIIIlIIlllIlIllIlI;
        }
        return 0.0f;
    }
    
    public boolean isValid(final String lllllllllllllllIIIlIIllllIIlIIll) {
        if (this.source == null) {
            Config.warn(String.valueOf(new StringBuilder("No source texture: ").append(lllllllllllllllIIIlIIllllIIlIIll)));
            return false;
        }
        this.source = TextureUtils.fixResourcePath(this.source, TextureUtils.getBasePath(lllllllllllllllIIIlIIllllIIlIIll));
        if (this.startFadeIn < 0 || this.endFadeIn < 0 || this.endFadeOut < 0) {
            Config.warn("Invalid times, required are: startFadeIn, endFadeIn and endFadeOut.");
            return false;
        }
        final int lllllllllllllllIIIlIIllllIIllIIl = this.normalizeTime(this.endFadeIn - this.startFadeIn);
        if (this.startFadeOut < 0) {
            this.startFadeOut = this.normalizeTime(this.endFadeOut - lllllllllllllllIIIlIIllllIIllIIl);
            if (this.timeBetween(this.startFadeOut, this.startFadeIn, this.endFadeIn)) {
                this.startFadeOut = this.endFadeIn;
            }
        }
        final int lllllllllllllllIIIlIIllllIIllIII = this.normalizeTime(this.startFadeOut - this.endFadeIn);
        final int lllllllllllllllIIIlIIllllIIlIlll = this.normalizeTime(this.endFadeOut - this.startFadeOut);
        final int lllllllllllllllIIIlIIllllIIlIllI = this.normalizeTime(this.startFadeIn - this.endFadeOut);
        final int lllllllllllllllIIIlIIllllIIlIlIl = lllllllllllllllIIIlIIllllIIllIIl + lllllllllllllllIIIlIIllllIIllIII + lllllllllllllllIIIlIIllllIIlIlll + lllllllllllllllIIIlIIllllIIlIllI;
        if (lllllllllllllllIIIlIIllllIIlIlIl != 24000) {
            Config.warn(String.valueOf(new StringBuilder("Invalid fadeIn/fadeOut times, sum is not 24h: ").append(lllllllllllllllIIIlIIllllIIlIlIl)));
            return false;
        }
        if (this.speed < 0.0f) {
            Config.warn(String.valueOf(new StringBuilder("Invalid speed: ").append(this.speed)));
            return false;
        }
        if (this.daysLoop <= 0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid daysLoop: ").append(this.daysLoop)));
            return false;
        }
        return true;
    }
    
    static {
        WEATHER_CLEAR = "clear";
        WEATHER_THUNDER = "thunder";
        WEATHER_RAIN = "rain";
        DEFAULT_AXIS = new float[] { 1.0f, 0.0f, 0.0f };
    }
    
    public boolean isActive(final World lllllllllllllllIIIlIIlllIIIlIlll, final int lllllllllllllllIIIlIIlllIIIlIllI) {
        if (this.timeBetween(lllllllllllllllIIIlIIlllIIIlIllI, this.endFadeOut, this.startFadeIn)) {
            return false;
        }
        if (this.days != null) {
            final long lllllllllllllllIIIlIIlllIIIlllII = lllllllllllllllIIIlIIlllIIIlIlll.getWorldTime();
            long lllllllllllllllIIIlIIlllIIIllIll;
            for (lllllllllllllllIIIlIIlllIIIllIll = lllllllllllllllIIIlIIlllIIIlllII - this.startFadeIn; lllllllllllllllIIIlIIlllIIIllIll < 0L; lllllllllllllllIIIlIIlllIIIllIll += 24000 * this.daysLoop) {}
            final int lllllllllllllllIIIlIIlllIIIllIlI = (int)(lllllllllllllllIIIlIIlllIIIllIll / 24000L);
            final int lllllllllllllllIIIlIIlllIIIllIIl = lllllllllllllllIIIlIIlllIIIllIlI % this.daysLoop;
            if (!this.days.isInRange(lllllllllllllllIIIlIIlllIIIllIIl)) {
                return false;
            }
        }
        return true;
    }
    
    private float parseFloat(final String lllllllllllllllIIIlIIlllllIIIIlI, final float lllllllllllllllIIIlIIlllllIIIIIl) {
        if (lllllllllllllllIIIlIIlllllIIIIlI == null) {
            return lllllllllllllllIIIlIIlllllIIIIIl;
        }
        final float lllllllllllllllIIIlIIlllllIIIIII = Config.parseFloat(lllllllllllllllIIIlIIlllllIIIIlI, Float.MIN_VALUE);
        if (lllllllllllllllIIIlIIlllllIIIIII == Float.MIN_VALUE) {
            Config.warn(String.valueOf(new StringBuilder("Invalid value: ").append(lllllllllllllllIIIlIIlllllIIIIlI)));
            return lllllllllllllllIIIlIIlllllIIIIIl;
        }
        return lllllllllllllllIIIlIIlllllIIIIII;
    }
    
    private int normalizeTime(int lllllllllllllllIIIlIIllllIIIlIll) {
        while (lllllllllllllllIIIlIIllllIIIlIll >= 24000) {
            lllllllllllllllIIIlIIllllIIIlIll -= 24000;
        }
        while (lllllllllllllllIIIlIIllllIIIlIll < 0) {
            lllllllllllllllIIIlIIllllIIIlIll += 24000;
        }
        return lllllllllllllllIIIlIIllllIIIlIll;
    }
}
