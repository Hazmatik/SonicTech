package hazmatik.sonictech.items;

import hazmatik.sonictech.SonicTech;
import hazmatik.sonictech.init.ItemInit;
import hazmatik.sonictech.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SonicTech.sonictechtab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		SonicTech.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
