package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import java.util.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import java.io.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public class RecipeData
{
    public static /* synthetic */ Map<String, Recipe> recipes;
    
    public static void init() {
        final InputStream lllllllllllllIIlIIIIIIIlIlIIIlIl = MappingData.class.getClassLoader().getResourceAsStream("assets/viaversion/data/itemrecipes1_12_2to1_13.json");
        final InputStreamReader lllllllllllllIIlIIIIIIIlIlIIIlII = new InputStreamReader(lllllllllllllIIlIIIIIIIlIlIIIlIl);
        try {
            RecipeData.recipes = GsonUtil.getGson().fromJson(lllllllllllllIIlIIIIIIIlIlIIIlII, new TypeToken<Map<String, Recipe>>() {}.getType());
        }
        finally {
            try {
                lllllllllllllIIlIIIIIIIlIlIIIlII.close();
            }
            catch (IOException ex) {}
        }
    }
    
    public static class Recipe
    {
        private /* synthetic */ DataItem result;
        private /* synthetic */ String group;
        private /* synthetic */ int width;
        private /* synthetic */ int cookingTime;
        private /* synthetic */ DataItem[] ingredient;
        private /* synthetic */ float experience;
        private /* synthetic */ DataItem[][] ingredients;
        private /* synthetic */ String type;
        private /* synthetic */ int height;
        
        public void setResult(final DataItem lllllllllllllllIIllIlllIlIllIIlI) {
            this.result = lllllllllllllllIIllIlllIlIllIIlI;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public String getGroup() {
            return this.group;
        }
        
        public int getWidth() {
            return this.width;
        }
        
        public int getCookingTime() {
            return this.cookingTime;
        }
        
        public void setHeight(final int lllllllllllllllIIllIlllIllIlllll) {
            this.height = lllllllllllllllIIllIlllIllIlllll;
        }
        
        public float getExperience() {
            return this.experience;
        }
        
        public String getType() {
            return this.type;
        }
        
        public void setWidth(final int lllllllllllllllIIllIlllIlllIlIII) {
            this.width = lllllllllllllllIIllIlllIlllIlIII;
        }
        
        public DataItem getResult() {
            return this.result;
        }
        
        public DataItem[] getIngredient() {
            return this.ingredient;
        }
        
        public void setGroup(final String lllllllllllllllIIllIlllIllllIIIl) {
            this.group = lllllllllllllllIIllIlllIllllIIIl;
        }
        
        public void setIngredient(final DataItem[] lllllllllllllllIIllIlllIllIIIIlI) {
            this.ingredient = lllllllllllllllIIllIlllIllIIIIlI;
        }
        
        public void setExperience(final float lllllllllllllllIIllIlllIllIlIllI) {
            this.experience = lllllllllllllllIIllIlllIllIlIllI;
        }
        
        public void setIngredients(final DataItem[][] lllllllllllllllIIllIlllIlIlllIIl) {
            this.ingredients = lllllllllllllllIIllIlllIlIlllIIl;
        }
        
        public void setType(final String lllllllllllllllIIllIlllIlllllIII) {
            this.type = lllllllllllllllIIllIlllIlllllIII;
        }
        
        public void setCookingTime(final int lllllllllllllllIIllIlllIllIIllIl) {
            this.cookingTime = lllllllllllllllIIllIlllIllIIllIl;
        }
        
        public DataItem[][] getIngredients() {
            return this.ingredients;
        }
    }
}
