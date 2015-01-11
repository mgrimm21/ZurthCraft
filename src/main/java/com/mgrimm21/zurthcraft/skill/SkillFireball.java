package com.mgrimm21.zurthcraft.skill;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class SkillFireball extends Skill{

	private EntityPlayer player;
	
	public SkillFireball(EntityPlayer player) {
		super();
		this.player = player;
		this.maxlevel = 4;
		this.isSkillKnow(player.getEntityData());
	}
	
	public boolean learnSkill(EntityPlayer player) {
		Entity ent;
		return false;
	}
	
	public boolean isSkillKnow(NBTTagCompound nbt) {
		
		
		return false;
	}
}
