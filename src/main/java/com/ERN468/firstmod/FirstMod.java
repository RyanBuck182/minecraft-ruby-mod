package com.ERN468.firstmod;

import net.fabricmc.api.ModInitializer;
import com.ERN468.firstmod.main.*;

public class FirstMod implements ModInitializer {

    public static final String MOD_ID = "firstmod";

    @Override
    public void onInitialize() {
        FirstModItems.registerItems();
        FirstModBlocks.registerBlocks();
        FirstModOreGeneration.registerOreGeneration();
        FirstModLootTables.registerLootTables();
        FirstModItemGroups.registerItemGroups();
    }
}
