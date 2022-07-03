package de.gerrygames.viarewind.api;

public interface ViaRewindConfig
{
    CooldownIndicator getCooldownIndicator();
    
    boolean isReplaceAdventureMode();
    
    boolean isReplaceParticles();
    
    public enum CooldownIndicator
    {
        DISABLED, 
        TITLE, 
        ACTION_BAR, 
        BOSS_BAR;
    }
}
