package com.mgrimm21.zurthcraft.proxy;

import com.mgrimm21.zurthcraft.zurthcraft;
import com.mgrimm21.zurthcraft.handler.GuiHandler;
import com.mgrimm21.zurthcraft.util.LogHelper;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy extends CommonProxy {
	
	public static void registerTileEntities() {
	}
	
	public static void registerNetworkStuff() {
		NetworkRegistry.INSTANCE.registerGuiHandler(zurthcraft.instance, new GuiHandler());
	}

}
