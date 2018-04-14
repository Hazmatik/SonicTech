package hazmatik.sonictech.world.gen;

import java.util.Random;

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
	private WorldGenerator stone_chromitite;
	
	public WorldGeneratorStone()
	{
		stone_chromitite = new WorldGenMinable(BlockInit.STONE.getDefaultState().withProperty(BlockSTStone.VARIANT, StoneType.CHROMITITE), 12, BlockMatcher.forBlock(Blocks.END_STONE));
		stone_gneiss = new WorldGenMinable(BlockInit.STONE.getDefaultState().withProperty(BlockSTStone.VARIANT, StoneType.GNEISS), 25);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case -1:
			break;
		case 0:
			runGenerator(stone_gneiss, world, random, chunkX, chunkZ, 25, 0, 128);
		case 1:
			runGenerator(stone_chromitite, world, random, chunkX, chunkZ, 15, 0, 128);
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
