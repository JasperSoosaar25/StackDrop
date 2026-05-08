package com.jasper.stackdrop;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StackDropMod implements ModInitializer {

    public static final String MOD_ID = "stackdrop";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("StackDrop loaded — drops are now stacked!");
    }
}
