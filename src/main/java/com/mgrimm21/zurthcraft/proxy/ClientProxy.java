package com.mgrimm21.zurthcraft.proxy;

import com.mgrimm21.zurthcraft.handler.GuiHandler;
import com.mgrimm21.zurthcraft.mob.EntityZipp;
import com.mgrimm21.zurthcraft.mob.RenderZurthCraftMob;
import com.mgrimm21.zurthcraft.mob.ZurthCraftMob;
import com.mgrimm21.zurthcraft.tileentity.TileEntityAlloySmelter;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
	public static void registerRendering() {
		
		final GuiHandler myhandler = new GuiHandler();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityZipp.class, new RenderZurthCraftMob(new ZurthCraftMob(), 0));
	}

}
