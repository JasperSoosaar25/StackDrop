package com.jasper.stackdrop;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StackDropMod implements ModInitializer {

    public static final String MOD_ID = "stackdrop";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LootTableEvents.MODIFY_DROPS.register((entry, context, drops) -> {
            for (ItemStack stack : drops) {
                if (!stack.isEmpty()) {
                    stack.setCount(stack.getMaxStackSize());
                }
            }
        });

        LOGGER.info("StackDrop loaded — drops are now stacked!");
    }
}
