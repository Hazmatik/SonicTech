package hazmatik.sonictech;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SonicTechTab extends CreativeTabs 
{
	public SonicTechTab (String label)
	{
		super("SonicTech");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Items.DIAMOND);
	}

}
