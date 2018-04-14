package hazmatik.sonictech.util.handlers;

import hazmatik.sonictech.init.BlockInit;
import hazmatik.sonictech.init.ItemInit;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler 
{
	public static void registerOreDictionary()
	{
	//Register Ores to OreDictionary
	OreDictionary.registerOre("oreCopper", new ItemStack(BlockInit.ORE, 1, 0));
	OreDictionary.registerOre("oreAluminium", new ItemStack(BlockInit.ORE, 1, 1));
	OreDictionary.registerOre("oreAluminum", new ItemStack(BlockInit.ORE, 1, 1));
	OreDictionary.registerOre("oreZinc", new ItemStack(BlockInit.ORE, 1, 2));
	OreDictionary.registerOre("oreTin", new ItemStack(BlockInit.ORE, 1, 3));
	OreDictionary.registerOre("oreAntimony", new ItemStack(BlockInit.ORE, 1, 4));
	OreDictionary.registerOre("oreMolybdenum", new ItemStack(BlockInit.ORE, 1, 5));
	OreDictionary.registerOre("oreLead", new ItemStack(BlockInit.ORE, 1, 6));
	OreDictionary.registerOre("oreSilver", new ItemStack(BlockInit.ORE, 1, 7));
	OreDictionary.registerOre("oreChromite", new ItemStack(BlockInit.ORE, 1, 8));
	OreDictionary.registerOre("oreChromium", new ItemStack(BlockInit.ORE, 1, 8));
	OreDictionary.registerOre("oreMagnesite", new ItemStack(BlockInit.ORE, 1, 9));
	OreDictionary.registerOre("oreMagnesium", new ItemStack(BlockInit.ORE, 1, 9));
	//Register Dusts to OreDictionary
	OreDictionary.registerOre("dustCopper", new ItemStack(ItemInit.DUST, 1, 0));
	OreDictionary.registerOre("dustAluminium", new ItemStack(ItemInit.DUST, 1, 1));
	OreDictionary.registerOre("dustAluminum", new ItemStack(ItemInit.DUST, 1, 1));
	OreDictionary.registerOre("dustZinc", new ItemStack(ItemInit.DUST, 1, 2));
	OreDictionary.registerOre("dustTin", new ItemStack(ItemInit.DUST, 1, 3));
	OreDictionary.registerOre("dustAntimony", new ItemStack(ItemInit.DUST, 1, 4));
	OreDictionary.registerOre("dustMolybdenum", new ItemStack(ItemInit.DUST, 1, 5));
	OreDictionary.registerOre("dustLead", new ItemStack(ItemInit.DUST, 1, 6));
	OreDictionary.registerOre("dustSilver", new ItemStack(ItemInit.DUST, 1, 7));
	OreDictionary.registerOre("dustChromium", new ItemStack(ItemInit.DUST, 1, 8));
	OreDictionary.registerOre("dustMagnesium", new ItemStack(ItemInit.DUST, 1, 9));
	OreDictionary.registerOre("dustIron", new ItemStack(ItemInit.DUST, 1, 10));
	OreDictionary.registerOre("dustGold", new ItemStack(ItemInit.DUST, 1, 11));
	//Register Nuggets to OreDictionary
	OreDictionary.registerOre("nuggetCopper", new ItemStack(ItemInit.NUGGET, 1, 0));
	OreDictionary.registerOre("nuggetAluminium", new ItemStack(ItemInit.NUGGET, 1, 1));
	OreDictionary.registerOre("nuggetAluminum", new ItemStack(ItemInit.NUGGET, 1, 1));
	OreDictionary.registerOre("nuggetZinc", new ItemStack(ItemInit.NUGGET, 1, 2));
	OreDictionary.registerOre("nuggetTin", new ItemStack(ItemInit.NUGGET, 1, 3));
	OreDictionary.registerOre("nuggetAntimony", new ItemStack(ItemInit.NUGGET, 1, 4));
	OreDictionary.registerOre("nuggetMolybdenum", new ItemStack(ItemInit.NUGGET, 1, 5));
	OreDictionary.registerOre("nuggetLead", new ItemStack(ItemInit.NUGGET, 1, 6));
	OreDictionary.registerOre("nuggetSilver", new ItemStack(ItemInit.NUGGET, 1, 7));
	OreDictionary.registerOre("nuggetChromium", new ItemStack(ItemInit.NUGGET, 1, 8));
	OreDictionary.registerOre("nuggetMagnesium", new ItemStack(ItemInit.NUGGET, 1, 9));
	
	//Register Ingots to OreDictionary
	OreDictionary.registerOre("ingotCopper", new ItemStack(ItemInit.INGOT, 1, 0));
	OreDictionary.registerOre("ingotAluminium", new ItemStack(ItemInit.INGOT, 1, 1));
	OreDictionary.registerOre("ingotAluminum", new ItemStack(ItemInit.INGOT, 1, 1));
	OreDictionary.registerOre("ingotZinc", new ItemStack(ItemInit.INGOT, 1, 2));
	OreDictionary.registerOre("ingotTin", new ItemStack(ItemInit.INGOT, 1, 3));
	OreDictionary.registerOre("ingotAntimony", new ItemStack(ItemInit.INGOT, 1, 4));
	OreDictionary.registerOre("ingotMolybdenum", new ItemStack(ItemInit.INGOT, 1, 5));
	OreDictionary.registerOre("ingotLead", new ItemStack(ItemInit.INGOT, 1, 6));
	OreDictionary.registerOre("ingotSilver", new ItemStack(ItemInit.INGOT, 1, 7));
	OreDictionary.registerOre("ingotChromium", new ItemStack(ItemInit.INGOT, 1, 8));
	OreDictionary.registerOre("ingotMagnesium", new ItemStack(ItemInit.INGOT, 1, 9));
	//Register Metal Blocks to OreDictionary
	OreDictionary.registerOre("blockCopper", new ItemStack(BlockInit.BLOCK_METAL, 1, 0));
	OreDictionary.registerOre("blockAluminium", new ItemStack(BlockInit.BLOCK_METAL, 1, 1));
	OreDictionary.registerOre("blockAluminum", new ItemStack(BlockInit.BLOCK_METAL, 1, 1));
	OreDictionary.registerOre("blockZinc", new ItemStack(BlockInit.BLOCK_METAL, 1, 2));
	OreDictionary.registerOre("blockTin", new ItemStack(BlockInit.BLOCK_METAL, 1, 3));
	OreDictionary.registerOre("blockAntimony", new ItemStack(BlockInit.BLOCK_METAL, 1, 4));
	OreDictionary.registerOre("blockMolybdenum", new ItemStack(BlockInit.BLOCK_METAL, 1, 5));
	OreDictionary.registerOre("blockLead", new ItemStack(BlockInit.BLOCK_METAL, 1, 6));
	OreDictionary.registerOre("blockSilver", new ItemStack(BlockInit.BLOCK_METAL, 1, 7));
	OreDictionary.registerOre("blockChromium", new ItemStack(BlockInit.BLOCK_METAL, 1, 8));
	OreDictionary.registerOre("blockMagnesium", new ItemStack(BlockInit.BLOCK_METAL, 1, 9));
	//Register New Stone Types to OreDictionary
	}
}
