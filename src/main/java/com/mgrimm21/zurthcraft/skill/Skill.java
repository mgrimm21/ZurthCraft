package com.mgrimm21.zurthcraft.skill;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class Skill {

	private boolean isLearned;
	private EntityPlayer player;
	NBTTagCompound nbt = player.getEntityData();
	public Skill() {

	}
	
	
	private void writeToNBT() {
		
	}
	
	private void readFromNBT() {
		
	}
}
