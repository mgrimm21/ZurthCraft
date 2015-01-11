package com.mgrimm21.zurthcraft.event;

import com.mgrimm21.zurthcraft.util.LogHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class SkillEvent implements IExtendedEntityProperties{

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(Entity entity, World world) {
		if (!(entity instanceof EntityPlayer)) return;
		LogHelper.info("You are a player, and not that kind either.");
	}
	
}
