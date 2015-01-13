package com.mgrimm21.zurthcraft.handler;

import ibxm.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

// This class will wait for all events from events bus, check if one of your methods suits one incoming event and call it if so
public class HandlerEvents{
	@SubscribeEvent
	public void onEntityConstruct(EntityEvent.EntityConstructing event){ 
		if (event.entity instanceof EntityPlayer) {
			
		}
	}
}
