package hazmatik.sonictech.world.gen;

import java.util.Random;

import hazmatik.sonictech.blocks.BlockOreBase;
import hazmatik.sonictech.blocks.BlockOreBase.Type;
import hazmatik.sonictech.init.BlockInit;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneratorOres implements IWorldGenerator
{
	private WorldGenerator ore_aluminium;
	private WorldGenerator ore_antimony;
	private WorldGenerator ore_chromite;
	private WorldGenerator ore_copper;
	private WorldGenerator ore_lead;
	private WorldGenerator ore_magnesite;
	private WorldGenerator ore_molybdenum;
	private WorldGenerator ore_silver;
	private WorldGenerator ore_tin;
	private WorldGenerator ore_zinc;
	
	public WorldGeneratorOres()
	{
		ore_aluminium = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.ALUMINIUM), 10);
		ore_antimony = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.ANTIMONY), 6, new AndesitePredicate());
		ore_chromite = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.CHROMITE), 6, new ChromititePredicate());
		ore_copper = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.COPPER), 10);
		ore_lead = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.LEAD), 6);
		ore_magnesite = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.MAGNESITE), 6, new DioritePredicate());
		ore_molybdenum = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.MOLYBDENUM), 6, new GranitePredicate());
		ore_silver = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.SILVER), 6);
		ore_tin = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.TIN), 8);
		ore_zinc = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.ZINC), 6, new GneissPredicate());
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
			runGenerator(ore_antimony, world, random, chunkX, chunkZ, 50, 32, 100);
			runGenerator(ore_molybdenum, world, random, chunkX, chunkZ, 50, 32, 100);
			runGenerator(ore_magnesite, world, random, chunkX, chunkZ, 50, 32, 100);
			runGenerator(ore_zinc, world, random, chunkX, chunkZ, 50, 32, 100);
			break;
		case 1:
			runGenerator(ore_chromite, world, random, chunkX, chunkZ, 50, 0, 128);
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minheight, int maxheight)
	{
		if(minheight > maxheight || minheight < 0 || maxheight > 256) throw new IllegalArgumentException("Ore generated out of bounds!");
		
		int heightDiff = maxheight - minheight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(8);
			int y = minheight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(8);
			
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
