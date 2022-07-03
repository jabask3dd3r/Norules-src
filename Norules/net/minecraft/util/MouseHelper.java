package net.minecraft.util;

import org.lwjgl.opengl.*;
import org.lwjgl.input.*;

public class MouseHelper
{
    public /* synthetic */ int deltaY;
    public /* synthetic */ int deltaX;
    
    public void ungrabMouseCursor() {
        Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
        Mouse.setGrabbed(false);
    }
    
    public void grabMouseCursor() {
        Mouse.setGrabbed(true);
        this.deltaX = 0;
        this.deltaY = 0;
    }
    
    public void mouseXYChange() {
        this.deltaX = Mouse.getDX();
        this.deltaY = Mouse.getDY();
    }
}
