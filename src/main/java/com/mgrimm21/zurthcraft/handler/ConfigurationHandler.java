package com.mgrimm21.zurthcraft.handler;

import java.io.File;

import com.mgrimm21.zurthcraft.reference.ConfigValues;
import com.mgrimm21.zurthcraft.reference.Reference;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

	public static Configuration configuration;
	public static boolean testValue = false;
	public static int tempValue;
	
	
	public static void init(File configFile) {
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}

	private static void loadConfiguration() {
		testValue = configuration.getBoolean("configValue",
				Configuration.CATEGORY_GENERAL, false, "this is an example config value");
       ConfigValues.zurditelampdustdropped = configuration.getInt("zldd", 
    		   Configuration.CATEGORY_GENERAL, 7, 0, 7, "The number of dust the Zurdite Lamp drops on break");
       ConfigValues.minzurditedustonorebreak = configuration.getInt("zddoob", 
    		   Configuration.CATEGORY_GENERAL, 1, 1, 9, "The Min number of dust the Zurdite Ore drops on break");
       ConfigValues.maxzurditedustonorebreak = configuration.getInt("mzddoobtwo", 
    		   Configuration.CATEGORY_GENERAL, 4, ConfigValues.minzurditedustonorebreak, 
    		   9, "The Max number of dust the Zurdite Ore drops on break.");
       ConfigValues.zurditeingotspersmelt = configuration.getInt("zips", 
    		   Configuration.CATEGORY_GENERAL, 2, 1, 16, "The number of ingots you get from smelting Zurdite Ore");
       
       
       
		if (configuration.hasChanged()) {
			configuration.save();
		}
	}
	
}
