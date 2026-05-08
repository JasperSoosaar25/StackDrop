package com.jasper.stackdrop.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

/**
 * Intercepts the list of ItemStacks produced by any LootTable roll and
 * sets every stack's count to its maximum stack size (typically 64).
 *
 * This covers BOTH block-break drops and mob-kill drops because they
 * both ultimately go through LootTable#getRandomItems.
 */
@Mixin(LootTable.class)
public class LootTableMixin {

    /**
     * After the loot table has built its list of random items, we modify the
     * local variable (the returned list) so every stack is a full stack.
     */
    @ModifyVariable(
        method = "getRandomItems(Lnet/minecraft/world/level/storage/loot/LootContext;)Ljava/util/List;",
        at = @At("RETURN"),
        argsOnly = false
    )
    private List<ItemStack> stackdrop$makeFullStacks(List<ItemStack> items) {
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                stack.setCount(stack.getMaxStackSize());
            }
        }
        return items;
    }
}
