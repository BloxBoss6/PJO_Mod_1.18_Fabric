package net.bloxboss6.pjomod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent BLUE_COOKIE = new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).alwaysEdible().build();
    public static final FoodComponent NECTAR_BOTTLE = new FoodComponent.Builder().hunger(6).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f).build();
    public static final FoodComponent AMBROSIA = new FoodComponent.Builder().hunger(6).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f).build();

}
