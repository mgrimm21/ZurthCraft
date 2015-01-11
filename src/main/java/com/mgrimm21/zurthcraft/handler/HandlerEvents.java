package com.mgrimm21.zurthcraft.handler;

import java.util.ArrayList;
import java.util.ListIterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

import com.mgrimm21.zurthcraft.util.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

// This class will wait for all events from events bus, check if one of your methods suits one incoming event and call it if so
public class HandlerEvents{
	@SubscribeEvent
	public void onEntityConstruct(EntityEvent.EntityConstructing event){ 
		if (event.entity instanceof EntityPlayer) {
			
		}
	}
}
