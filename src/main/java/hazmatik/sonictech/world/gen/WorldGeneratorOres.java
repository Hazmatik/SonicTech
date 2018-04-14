package hazmatik.sonictech.world.gen;

import java.util.Random;

import hazmatik.sonictech.Config;
import hazmatik.sonictech.SonicTech;
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
		ore_aluminium = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.ALUMINIUM), Config.aluminiumSize);
		ore_antimony = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.ANTIMONY), Config.antimonySize, new AndesitePredicate());
		ore_chromite = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.CHROMITE), Config.chromiteSize, new ChromititePredicate());
		ore_copper = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.COPPER), Config.copperSize);
		ore_lead = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.LEAD), Config.leadSize);
		ore_magnesite = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.MAGNESITE), Config.magnesiteSize, new DioritePredicate());
		ore_molybdenum = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.MOLYBDENUM), Config.molybdenumSize, new GranitePredicate());
		ore_silver = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.SILVER), Config.silverSize);
		ore_tin = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.TIN), Config.tinSize);
		ore_zinc = new WorldGenMinable(BlockInit.ORE.getDefaultState().withProperty(BlockOreBase.VARIANT, Type.ZINC), Config.zincSize, new GneissPredicate());
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
				runGenerator(ore_chromite, world, random, chunkX, chunkZ, Config.chromiteNetherChance, 0, 256);
			}
			break;
		case 0:
			if(Config.chromititeOverworld)
			{
				runGenerator(ore_chromite, world, random, chunkX, chunkZ, Config.chromiteOWChance, 0, 256);
			}
			runGenerator(ore_aluminium, world, random, chunkX, chunkZ, Config.aluminiumChance, Config.aluminiumMinY, Config.aluminiumMaxY);
			runGenerator(ore_antimony, world, random, chunkX, chunkZ, Config.antimonyChance, Config.antimonyMinY, Config.antimonyMaxY);
			runGenerator(ore_copper, world, random, chunkX, chunkZ, Config.copperChance, Config.copperMinY, Config.copperMaxY);
			runGenerator(ore_lead, world, random, chunkX, chunkZ, Config.leadChance, Config.leadMinY, Config.leadMaxY);
			runGenerator(ore_magnesite, world, random, chunkX, chunkZ, Config.magnesiteChance, Config.magnesiteMinY, Config.magnesiteMaxY);
			runGenerator(ore_molybdenum, world, random, chunkX, chunkZ, Config.molybdenumChance, Config.molybdenumMinY, Config.molybdenumMaxY);
			runGenerator(ore_silver, world, random, chunkX, chunkZ, Config.silverChance, Config.silverMinY, Config.silverMaxY);
			runGenerator(ore_tin, world, random, chunkX, chunkZ, Config.tinChance, Config.tinMinY, Config.tinMaxY);
			runGenerator(ore_zinc, world, random, chunkX, chunkZ, Config.zincChance, Config.zincMinY, Config.zincMaxY);
			break;
		case 1:
			runGenerator(ore_chromite, world, random, chunkX, chunkZ, Config.chromiteEndChance, 0, 256);
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
