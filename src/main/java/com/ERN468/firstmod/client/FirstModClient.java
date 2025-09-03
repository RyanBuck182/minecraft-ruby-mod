package com.ERN468.firstmod.client;

import com.ERN468.firstmod.main.FirstModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class FirstModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(FirstModBlocks.RUBY_CROP, RenderLayer.getCutout());
    }
}
