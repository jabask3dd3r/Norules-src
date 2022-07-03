package com.viaversion.viaversion.libs.kyori.adventure.util;

import org.jetbrains.annotations.*;

public interface RGBLike
{
    @NotNull
    default HSVLike asHSV() {
        return HSVLike.fromRGB(this.red(), this.green(), this.blue());
    }
    
    int red();
    
    int blue();
    
    int green();
}
