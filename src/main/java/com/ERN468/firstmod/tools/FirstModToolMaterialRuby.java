package com.ERN468.firstmod.tools;

import com.ERN468.firstmod.main.FirstModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FirstModToolMaterialRuby implements ToolMaterial {
    @Override
    public int getDurability() {
        return 2500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }

    @Override
    public float getAttackDamage() { return 5.0f; }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 17;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(FirstModItems.RUBY);
    }
}
