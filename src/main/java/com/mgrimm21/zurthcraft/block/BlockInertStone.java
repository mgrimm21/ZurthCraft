package com.mgrimm21.zurthcraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.mgrimm21.zurthcraft.zurthcraft;
import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.Names;

public class BlockInertStone extends BlockZurthCraft{
	
	public BlockInertStone() {
		super(Material.rock);
		this.setBlockName(Names.INERTSTONE);
		this.setCreativeTab(ZCTabs.ZURTHCRAFT_MAGIC);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8,
			float par9) {
			if (player.getCurrentEquippedItem() == null) return false;
		if (player.getCurrentEquippedItem().getItem() != ModItems.zurditeNugget) return false;
		if (world.getCurrentMoonPhaseFactor() > 0.75F) world.setBlock(x, y, z, ModBlocks.activatedstone);
		if (world.getCurrentMoonPhaseFactor() > 0.75F && player.getCurrentEquippedItem().getItem() == ModItems.zurditeNugget && !player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(player.getCurrentEquippedItem().getItem());
		
		if (!world.isRemote) {
			EntityItem droppeditems = new EntityItem(world, x, y, z, new ItemStack(ModItems.zincammoniumchloride, 4));
			droppeditems.fireResistance = 1000;
		world.spawnEntityInWorld(droppeditems);
		}
		EntityLightningBolt lightning = new EntityLightningBolt(world, x + 5, y, z);
		world.setThunderStrength(10.0F);
	    world.spawnEntityInWorld(lightning);
	    lightning = new EntityLightningBolt(world, x + 5, y, z + 5);
		world.spawnEntityInWorld(lightning);
		lightning = new EntityLightningBolt(world, x, y, z + 5);
		world.spawnEntityInWorld(lightning);
		lightning = new EntityLightningBolt(world, x - 5, y, z);
		world.spawnEntityInWorld(lightning);
		lightning = new EntityLightningBolt(world, x + 5, y, z - 5);
		world.spawnEntityInWorld(lightning);
		lightning = new EntityLightningBolt(world, x, y, z - 5);
		world.spawnEntityInWorld(lightning);
		lightning = new EntityLightningBolt(world, x - 5, y, z - 5);
		world.spawnEntityInWorld(lightning);
		lightning = new EntityLightningBolt(world, x - 5, y, z + 5);
		world.spawnEntityInWorld(lightning);
		return true;
	}
}
