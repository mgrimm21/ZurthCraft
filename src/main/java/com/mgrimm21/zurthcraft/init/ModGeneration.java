package com.mgrimm21.zurthcraft.init;

import com.mgrimm21.zurthcraft.world.ZurthCraftGeneration;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModGeneration {

	public static void init() {
		GameRegistry.registerWorldGenerator(new ZurthCraftGeneration(), 0);
	}
	
}
