package com.mgrimm21.zurthcraft.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.mgrimm21.zurthcraft.reference.Reference;

public class RenderZurthCraftMob extends RenderLiving{
	
	private static final ResourceLocation mobTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/MobZurthCraft.png");

	public RenderZurthCraftMob(ModelBase par1, float par2) {
		super(par1, par2);
	}

	protected ResourceLocation getEntityTexture(EntityZipp entity) {
		return mobTextures;
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityZipp)entity);
	}
	
}
