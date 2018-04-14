package hazmatik.sonictech.world.gen;

import java.util.Random;

import hazmatik.sonictech.Config;
import hazmatik.sonictech.blocks.BlockSTStone;
import hazmatik.sonictech.blocks.BlockSTStone.StoneType;
import hazmatik.sonictech.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneratorStone implements IWorldGenerator
{
	private WorldGenerator stone_gneiss;
	private WorldGenerator stone_chromitite_end;
	private WorldGenerator stone_chromitite_ow;
	private WorldGenerator stone_chromitite_nether;
	
	public WorldGeneratorStone()
	{
		stone_chromitite_ow = new WorldGenMinable(BlockInit.STONE.getDefaultState().withProperty(BlockSTStone.VARIANT, StoneType.CHROMITITE), Config.chromititeOWSize);
		stone_chromitite_end = new WorldGenMinable(BlockInit.STONE.getDefaultState().withProperty(BlockSTStone.VARIANT, StoneType.CHROMITITE), Config.chromititeEndSize, BlockMatcher.forBlock(Blocks.END_STONE));
		stone_chromitite_nether = new WorldGenMinable(BlockInit.STONE.getDefaultState().withProperty(BlockSTStone.VARIANT, StoneType.CHROMITITE), Config.chromititeNetherSize, BlockMatcher.forBlock(Blocks.NETHERRACK));
		stone_gneiss = new WorldGenMinable(BlockInit.STONE.getDefaultState().withProperty(BlockSTStone.VARIANT, StoneType.GNEISS), Config.gneissSize);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case -1:
			if(Config.chromititeNether)
			{
				runGenerator(stone_chromitite_nether, world, random, chunkX, chunkZ, Config.chromititeNetherChance, Config.chromititeNetherMinY, Config.chromititeNetherMaxY);
			}
		case 0:
			if(Config.chromititeOverworld)
			{
				runGenerator(stone_chromitite_ow, world, random, chunkX, chunkZ, Config.chromititeOWChance, Config.chromititeOWMinY, Config.chromititeOWMaxY);
			}
			runGenerator(stone_gneiss, world, random, chunkX, chunkZ, Config.gneissChance, Config.gneissMinY, Config.gneissMaxY);
		case 1:
			runGenerator(stone_chromitite_end, world, random, chunkX, chunkZ, Config.chromititeEndChance, Config.chromititeEndMinY, Config.chromititeEndMaxY);
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minheight, int maxheight)
	{
		if(minheight > maxheight || minheight < 0 || maxheight > 256) throw new IllegalArgumentException("Stone generated out of bounds!");
		
		int heightDiff = maxheight - minheight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minheight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
