package net.minecraft.world;

import net.minecraft.nbt.*;
import java.util.*;

public class GameRules
{
    private final /* synthetic */ TreeMap<String, Value> theGameRules;
    
    public boolean hasRule(final String llllllllllllllIIllIIIlIIllIllllI) {
        return this.theGameRules.containsKey(llllllllllllllIIllIIIlIIllIllllI);
    }
    
    public void addGameRule(final String llllllllllllllIIllIIIlIlIIlIllII, final String llllllllllllllIIllIIIlIlIIlIlIll, final ValueType llllllllllllllIIllIIIlIlIIlIlIlI) {
        this.theGameRules.put(llllllllllllllIIllIIIlIlIIlIllII, new Value(llllllllllllllIIllIIIlIlIIlIlIll, llllllllllllllIIllIIIlIlIIlIlIlI));
    }
    
    public int getInt(final String llllllllllllllIIllIIIlIlIIIIIlll) {
        final Value llllllllllllllIIllIIIlIlIIIIIllI = this.theGameRules.get(llllllllllllllIIllIIIlIlIIIIIlll);
        return (llllllllllllllIIllIIIlIlIIIIIllI != null) ? llllllllllllllIIllIIIlIlIIIIIllI.getInt() : 0;
    }
    
    public void readFromNBT(final NBTTagCompound llllllllllllllIIllIIIlIIlllIllII) {
        for (final String llllllllllllllIIllIIIlIIlllIlllI : llllllllllllllIIllIIIlIIlllIllII.getKeySet()) {
            this.setOrCreateGameRule(llllllllllllllIIllIIIlIIlllIlllI, llllllllllllllIIllIIIlIIlllIllII.getString(llllllllllllllIIllIIIlIIlllIlllI));
        }
    }
    
    public void setOrCreateGameRule(final String llllllllllllllIIllIIIlIlIIlIIlII, final String llllllllllllllIIllIIIlIlIIlIIIll) {
        final Value llllllllllllllIIllIIIlIlIIlIIIlI = this.theGameRules.get(llllllllllllllIIllIIIlIlIIlIIlII);
        if (llllllllllllllIIllIIIlIlIIlIIIlI != null) {
            llllllllllllllIIllIIIlIlIIlIIIlI.setValue(llllllllllllllIIllIIIlIlIIlIIIll);
        }
        else {
            this.addGameRule(llllllllllllllIIllIIIlIlIIlIIlII, llllllllllllllIIllIIIlIlIIlIIIll, ValueType.ANY_VALUE);
        }
    }
    
    public boolean getBoolean(final String llllllllllllllIIllIIIlIlIIIIllIl) {
        final Value llllllllllllllIIllIIIlIlIIIIllll = this.theGameRules.get(llllllllllllllIIllIIIlIlIIIIllIl);
        return llllllllllllllIIllIIIlIlIIIIllll != null && llllllllllllllIIllIIIlIlIIIIllll.getBoolean();
    }
    
    public NBTTagCompound writeToNBT() {
        final NBTTagCompound llllllllllllllIIllIIIlIIllllllII = new NBTTagCompound();
        for (final String llllllllllllllIIllIIIlIIlllllIll : this.theGameRules.keySet()) {
            final Value llllllllllllllIIllIIIlIIlllllIlI = this.theGameRules.get(llllllllllllllIIllIIIlIIlllllIll);
            llllllllllllllIIllIIIlIIllllllII.setString(llllllllllllllIIllIIIlIIlllllIll, llllllllllllllIIllIIIlIIlllllIlI.getString());
        }
        return llllllllllllllIIllIIIlIIllllllII;
    }
    
    public GameRules() {
        this.theGameRules = new TreeMap<String, Value>();
        this.addGameRule("doFireTick", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("mobGriefing", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("keepInventory", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doMobSpawning", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doMobLoot", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doTileDrops", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doEntityDrops", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("commandBlockOutput", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("naturalRegeneration", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doDaylightCycle", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("logAdminCommands", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("showDeathMessages", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("randomTickSpeed", "3", ValueType.NUMERICAL_VALUE);
        this.addGameRule("sendCommandFeedback", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("reducedDebugInfo", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("spectatorsGenerateChunks", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("spawnRadius", "10", ValueType.NUMERICAL_VALUE);
        this.addGameRule("disableElytraMovementCheck", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("maxEntityCramming", "24", ValueType.NUMERICAL_VALUE);
        this.addGameRule("doWeatherCycle", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("doLimitedCrafting", "false", ValueType.BOOLEAN_VALUE);
        this.addGameRule("maxCommandChainLength", "65536", ValueType.NUMERICAL_VALUE);
        this.addGameRule("announceAdvancements", "true", ValueType.BOOLEAN_VALUE);
        this.addGameRule("gameLoopFunction", "-", ValueType.FUNCTION);
    }
    
    public boolean areSameType(final String llllllllllllllIIllIIIlIIllIlIlII, final ValueType llllllllllllllIIllIIIlIIllIlIlll) {
        final Value llllllllllllllIIllIIIlIIllIlIllI = this.theGameRules.get(llllllllllllllIIllIIIlIIllIlIlII);
        return llllllllllllllIIllIIIlIIllIlIllI != null && (llllllllllllllIIllIIIlIIllIlIllI.getType() == llllllllllllllIIllIIIlIIllIlIlll || llllllllllllllIIllIIIlIIllIlIlll == ValueType.ANY_VALUE);
    }
    
    public String getString(final String llllllllllllllIIllIIIlIlIIIllIIl) {
        final Value llllllllllllllIIllIIIlIlIIIllIII = this.theGameRules.get(llllllllllllllIIllIIIlIlIIIllIIl);
        return (llllllllllllllIIllIIIlIlIIIllIII != null) ? llllllllllllllIIllIIIlIlIIIllIII.getString() : "";
    }
    
    public String[] getRules() {
        final Set<String> llllllllllllllIIllIIIlIIlllIIllI = this.theGameRules.keySet();
        return llllllllllllllIIllIIIlIIlllIIllI.toArray(new String[llllllllllllllIIllIIIlIIlllIIllI.size()]);
    }
    
    public enum ValueType
    {
        NUMERICAL_VALUE("NUMERICAL_VALUE", 2), 
        ANY_VALUE("ANY_VALUE", 0), 
        FUNCTION("FUNCTION", 3), 
        BOOLEAN_VALUE("BOOLEAN_VALUE", 1);
        
        private ValueType(final String lllllllllllllllIIIIIlIlIIIIIlllI, final int lllllllllllllllIIIIIlIlIIIIIllIl) {
        }
    }
    
    static class Value
    {
        private /* synthetic */ String valueString;
        private /* synthetic */ boolean valueBoolean;
        private /* synthetic */ int valueInteger;
        private /* synthetic */ double valueDouble;
        private final /* synthetic */ ValueType type;
        
        public ValueType getType() {
            return this.type;
        }
        
        public String getString() {
            return this.valueString;
        }
        
        public void setValue(final String llllllllllllllllIIIlllIIIlllIIlI) {
            this.valueString = llllllllllllllllIIIlllIIIlllIIlI;
            if (llllllllllllllllIIIlllIIIlllIIlI != null) {
                if (llllllllllllllllIIIlllIIIlllIIlI.equals("false")) {
                    this.valueBoolean = false;
                    return;
                }
                if (llllllllllllllllIIIlllIIIlllIIlI.equals("true")) {
                    this.valueBoolean = true;
                    return;
                }
            }
            this.valueBoolean = Boolean.parseBoolean(llllllllllllllllIIIlllIIIlllIIlI);
            this.valueInteger = (this.valueBoolean ? 1 : 0);
            try {
                this.valueInteger = Integer.parseInt(llllllllllllllllIIIlllIIIlllIIlI);
            }
            catch (NumberFormatException ex) {}
            try {
                this.valueDouble = Double.parseDouble(llllllllllllllllIIIlllIIIlllIIlI);
            }
            catch (NumberFormatException ex2) {}
        }
        
        public int getInt() {
            return this.valueInteger;
        }
        
        public Value(final String llllllllllllllllIIIlllIIIllllIlI, final ValueType llllllllllllllllIIIlllIIIllllIIl) {
            this.type = llllllllllllllllIIIlllIIIllllIIl;
            this.setValue(llllllllllllllllIIIlllIIIllllIlI);
        }
        
        public boolean getBoolean() {
            return this.valueBoolean;
        }
    }
}
