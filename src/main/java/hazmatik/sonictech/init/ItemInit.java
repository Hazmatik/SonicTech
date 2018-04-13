package hazmatik.sonictech.init;

import java.util.ArrayList;
import java.util.List;

import hazmatik.sonictech.items.ItemIngot;
import net.minecraft.item.Item;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item INGOT = new ItemIngot("ingot");
}
