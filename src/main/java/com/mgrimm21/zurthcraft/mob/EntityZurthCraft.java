package com.mgrimm21.zurthcraft.mob;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.mgrimm21.zurthcraft.zurthcraft;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityZurthCraft {

	public static void init(){
		registerEntity();
	}
	
	public static void registerEntity() {
		
		createEntity(EntityZipp.class, "Zipp", 0x0004FF, 0xFF00E1);
		
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, zurthcraft.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.forest);
		
		createEgg(randomId, solidColor, spotColor);
	}
	
	private static void createEgg(int id, int solid, int spot) {
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, solid, spot));
	}
	
}
