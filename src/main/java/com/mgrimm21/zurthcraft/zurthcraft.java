package com.mgrimm21.zurthcraft;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.mgrimm21.zurthcraft.handler.ConfigurationHandler;
import com.mgrimm21.zurthcraft.handler.RecipeAndSmeltingHandler;
import com.mgrimm21.zurthcraft.handler.HandlerEvents;
import com.mgrimm21.zurthcraft.init.ModBiomes;
import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.init.ModFluids;
import com.mgrimm21.zurthcraft.init.ModGeneration;
import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.mob.EntityZurthCraft;
import com.mgrimm21.zurthcraft.proxy.ClientProxy;
import com.mgrimm21.zurthcraft.proxy.IProxy;
import com.mgrimm21.zurthcraft.proxy.ServerProxy;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.stats.Achievments;
import com.mgrimm21.zurthcraft.util.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class zurthcraft {
	@Mod.Instance(Reference.MOD_ID)
	public static zurthcraft instance;
	
	@SidedProxy(clientSide = "com.mgrimm21.zurthcraft.proxy.ClientProxy", serverSide = "com.mgrimm21.zurthcraft.proxy.ServerProxy")
	public static IProxy proxy;

	public zurthcraft() {
		instance = this;
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Stopwatch preInit = Stopwatch.createStarted();
		// LOADS THE CONFIGURATION FILE AND GETS/SETS ALL VALUES 
		// NEEDED THROUGHOUT THE MOD AND SAVES THEM IN REFERENCE.CONFIGS
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		// Registering your event handler so that Forge knows that it should send events to it
		MinecraftForge.EVENT_BUS.register(new HandlerEvents());
		//REGISTERS CUSTOM ENTITY RENDERING
		ClientProxy.registerRendering();
		//REGISTERS ITEMS
		ModItems.init();
		//REGISTERS BLOCKS
		ModBlocks.init();
		//REGISTERS FLUIDS
		ModFluids.init();
		//REGISTERS GENERATION
		ModGeneration.init();
		//REGISTERS MOBS
		EntityZurthCraft.init();
		//REGISTERS BIOMES
		ModBiomes.init();
		//REGISTERS TILES ENTITIES
		ServerProxy.registerTileEntities();
		
		LogHelper.info("Pre Initialization Complete after" + preInit.elapsed(TimeUnit.MILLISECONDS) + "ms");
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {
		Stopwatch Init = Stopwatch.createStarted();
		// REGISTERS GUI HANDLER
		ServerProxy.registerNetworkStuff();
		// LOADS ALL RECIPES
		RecipeAndSmeltingHandler.init();
		LogHelper.info("Initialization Complete!");
		LogHelper.info("Pre Initialization Complete after" + Init.elapsed(TimeUnit.MILLISECONDS) + "ms");
	}
	
	@Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event) {
		Stopwatch postInit = Stopwatch.createStarted();
		Achievments.init();
		LogHelper.info("Post Initialization Complete!");
		LogHelper.info("Pre Initialization Complete after" + postInit.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }
}
