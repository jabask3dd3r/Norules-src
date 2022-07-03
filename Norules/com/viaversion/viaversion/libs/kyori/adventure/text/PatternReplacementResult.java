package com.viaversion.viaversion.libs.kyori.adventure.text;

public enum PatternReplacementResult
{
    CONTINUE, 
    REPLACE, 
    STOP;
    
    private static /* synthetic */ PatternReplacementResult[] $values() {
        return new PatternReplacementResult[] { PatternReplacementResult.REPLACE, PatternReplacementResult.CONTINUE, PatternReplacementResult.STOP };
    }
    
    static {
        $VALUES = $values();
    }
}
