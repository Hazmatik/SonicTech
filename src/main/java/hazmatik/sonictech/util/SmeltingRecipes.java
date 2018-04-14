package hazmatik.sonictech.util;

import hazmatik.sonictech.init.BlockInit;
import hazmatik.sonictech.init.ItemInit;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes 
{	
	public static void init()
	{
		//Ore to Ingot
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 0), new ItemStack(ItemInit.INGOT, 1, 0), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 1), new ItemStack(ItemInit.INGOT, 1, 1), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 2), new ItemStack(ItemInit.INGOT, 1, 2), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 3), new ItemStack(ItemInit.INGOT, 1, 3), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 4), new ItemStack(ItemInit.INGOT, 1, 4), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 5), new ItemStack(ItemInit.INGOT, 1, 5), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 6), new ItemStack(ItemInit.INGOT, 1, 6), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 7), new ItemStack(ItemInit.INGOT, 1, 7), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 8), new ItemStack(ItemInit.INGOT, 1, 8), 0.7f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE, 1, 9), new ItemStack(ItemInit.INGOT, 1, 9), 0.7f);
		//Dust to Ingot
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 0), new ItemStack(ItemInit.INGOT, 1, 0), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 1), new ItemStack(ItemInit.INGOT, 1, 1), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 2), new ItemStack(ItemInit.INGOT, 1, 2), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 3), new ItemStack(ItemInit.INGOT, 1, 3), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 4), new ItemStack(ItemInit.INGOT, 1, 4), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 5), new ItemStack(ItemInit.INGOT, 1, 5), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 6), new ItemStack(ItemInit.INGOT, 1, 6), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 7), new ItemStack(ItemInit.INGOT, 1, 7), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 8), new ItemStack(ItemInit.INGOT, 1, 8), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 9), new ItemStack(ItemInit.INGOT, 1, 9), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 10), new ItemStack(Items.IRON_INGOT), 1.0f);
		GameRegistry.addSmelting(new ItemStack(ItemInit.DUST, 1, 11), new ItemStack(Items.GOLD_INGOT), 1.0f);
	}
}
