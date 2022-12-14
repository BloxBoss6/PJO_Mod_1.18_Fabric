package net.bloxboss6.pjomod.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial
{
    CELESTIAL_BRONZE(MiningLevels.DIAMOND, 2500, 8.0f, 5.0f, 20, () -> Ingredient.ofItems(ModItems.CB_INGOT)),
    IMPERIAL_GOLD(MiningLevels.DIAMOND, 2500, 8.0f, 5.0f, 20, () -> Ingredient.ofItems(ModItems.IG_INGOT)),
    MIXED_ALLOY(MiningLevels.DIAMOND, 2500, 8.0f, 6.0f, 20, () -> Ingredient.ofItems(ModItems.MA_INGOT)),
    STYGIAN_IRON(MiningLevels.DIAMOND, 2500, 8.0f, 5.0f, 20, () -> Ingredient.ofItems(ModItems.SI_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

