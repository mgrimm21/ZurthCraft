package net.row.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.EntityEvent;

// This class will wait for all events from events bus, check if one of your methods suits one incoming event and call it if so
public class HandlerEvents{
	@SubscribeEvent
	public void onEntityConstruct(EntityEvent.EntityConstructing event){ // Name of the method doesn't matter
		// run your code here
	}
}
