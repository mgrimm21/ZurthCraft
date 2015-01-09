package com.mgrimm21.zurthcraft.mob;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.Reference;

public class EntityZipp extends EntityAnimal{

	private static World ww;
	
	public EntityZipp(World world) {
		super(world);
		this.ww = world;
		this.setSize(1.0F, 0.9F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.7D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.2D, ModItems.sulfur, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	 /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
    	return Reference.MOD_ID + ":zipp-say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
    	return Reference.MOD_ID + ":zipp-hurt";
    }

    
    public void onDeath(DamageSource dmg) {
    	if (worldObj.isRemote) return;
    	Random rnd = new Random();
    	if (rnd.nextInt(4) != 1) {
    	int i = rnd.nextInt(4) + 1;
    	this.dropItem(ModItems.rawZippMeat, i);
    } else {
    	int ii = rnd.nextInt(5) + 1;
    	switch (ii){
    		case 1:
    			this.dropItem(ModItems.rawZippMeat, ii);
    			this.dropItem(ModItems.zincammoniumchloride, rnd.nextInt((ii * ii) + 10));
    		case 2:
    			this.dropItem(ModItems.rawZippMeat, ii);
    			this.dropItem(ModItems.zincammoniumchloride, rnd.nextInt((ii * ii) + 10));
    		case 3:
    			this.dropItem(ModItems.rawZippMeat, ii);
    			this.dropItem(ModItems.zincammoniumchloride, rnd.nextInt((ii * ii) + 10));
    		case 4:
    			this.dropItem(ModItems.rawZippMeat, ii);
    			this.dropItem(ModItems.zincammoniumchloride, rnd.nextInt((ii * ii) + 10));
    			this.dropItem(ModItems.zincingotshg, rnd.nextInt(ii));
    		case 5:
    			this.dropItem(ModItems.rawZippMeat, ii);
    			int da = rnd.nextInt((ii * ii) + 10) / 6;
    			if (da < 1) this.dropItem(ModItems.zincammoniumchloride, 1);
    			if (da > 1) this.dropItem(ModItems.zincammoniumchloride, da);
    			
    	}
    }
    	
    }

	/**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
    	 return Reference.MOD_ID + ":zipp-death";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }
	
	
	
	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ea) {
		return new EntityZipp(worldObj);
	}

	
	
}
