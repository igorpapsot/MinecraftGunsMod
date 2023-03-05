package com.igorpapsot.mcmod.client.render;

import com.igorpapsot.mcmod.McModMain;
import com.igorpapsot.mcmod.entities.Bullet;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BulletRender extends ArrowRenderer<Bullet> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(McModMain.MODID, "textures/entity/bullet.png");

    public BulletRender(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public ResourceLocation getTextureLocation(Bullet arrow) {
        return TEXTURE;
    }
}
