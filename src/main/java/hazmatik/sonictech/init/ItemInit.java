package hazmatik.sonictech.init;

import java.util.ArrayList;
import java.util.List;

import hazmatik.sonictech.items.ItemDust;
import hazmatik.sonictech.items.ItemIngot;
import hazmatik.sonictech.items.ItemNugget;
import net.minecraft.item.Item;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item INGOT = new ItemIngot("ingot");
	public static final Item DUST = new ItemDust("dust");
	public static final Item NUGGET = new ItemNugget("nugget");
}
