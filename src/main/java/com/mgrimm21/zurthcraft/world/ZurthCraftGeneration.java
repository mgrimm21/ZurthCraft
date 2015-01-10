package com.mgrimm21.zurthcraft.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.mgrimm21.zurthcraft.block.BlockZurthCraft;
import com.mgrimm21.zurthcraft.init.ModBlocks;

import cpw.mods.fml.common.IWorldGenerator;

public class ZurthCraftGeneration implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch (world.provider.dimensionId){
		
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		}
		
	}
	
	public void generateNether(World world, Random random, int x, int z) {
		generateOre(ModBlocks.zurditeorenether, world, random, x, z, 4, 8, 5, 0, 100, Blocks.netherrack);
		generateOre(ModBlocks.bauxiteore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.netherrack);
		generateOre(ModBlocks.copperore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.netherrack);
		generateOre(ModBlocks.zincore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.netherrack);
	}
	
	public void generateOverworld(World world, Random random, int x, int z) {
		generateOre(ModBlocks.zurditeore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.stone);
		generateOre(ModBlocks.bauxiteore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.stone);
		generateOre(ModBlocks.copperore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.stone);
		generateOre(ModBlocks.zincore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.stone);
		generateOre(ModBlocks.inertstone, world, random, x, z, 4, 8, 5, 0, 20, Blocks.stone);
	}
	
	public void generateEnd(World world, Random random, int x, int z) {
		generateOre(ModBlocks.zurditeoreend, world, random, x, z, 4, 8, 5, 0, 100, Blocks.end_stone);
		generateOre(ModBlocks.bauxiteore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.end_stone);
		generateOre(ModBlocks.copperore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.end_stone);
		generateOre(ModBlocks.zincore, world, random, x, z, 4, 8, 5, 0, 100, Blocks.end_stone);
		generateOre(ModBlocks.inertstone, world, random, x, z, 4, 8, 5, 0, 100, Blocks.end_stone);
	}
	
	public void generateOre(BlockZurthCraft block, World world, Random random, 
			int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
		
		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, vienSize, generateIn);
		for(int i = 0; i < chance; i++){
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
	
	
	
	
	
	
	
	
}
