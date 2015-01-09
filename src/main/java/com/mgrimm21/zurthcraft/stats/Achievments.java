package com.mgrimm21.zurthcraft.stats;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.ZombieEvent;

import com.mgrimm21.zurthcraft.init.ModBlocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Achievments {

	public static Achievement NewComer;
	
	@SubscribeEvent
	public void onKilledMob(LivingDeathEvent event) {
		if (event.entityLiving instanceof EntityZombie) {
			EntityPlayer p = (EntityPlayer)event.source.getEntity();
			if (event.source.getSourceOfDamage() instanceof EntityPlayer) {
				p.addStat(NewComer, 1);
			}
		}
	}
	
	
	public static void init() {
		
		NewComer = new Achievement("NewComer,", "NewComer", 1, -2, ModBlocks.zurditeore, AchievementList.openInventory).registerStat();
		
		
	}
	
}
