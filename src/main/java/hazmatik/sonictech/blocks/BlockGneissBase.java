package hazmatik.sonictech.blocks;

import hazmatik.sonictech.SonicTech;
import hazmatik.sonictech.blocks.BlockChromititeBase.RockType;
import hazmatik.sonictech.blocks.item.ItemBlockVariants;
import hazmatik.sonictech.init.BlockInit;
import hazmatik.sonictech.init.ItemInit;
import hazmatik.sonictech.util.interfaces.IHasModel;
import hazmatik.sonictech.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class BlockGneissBase extends Block implements IHasModel, IMetaName
{
public static final PropertyEnum<RockType> VARIANT = PropertyEnum.create("type", RockType.class);
	
	private String name;
	
	public BlockGneissBase(String name, float hardness,  String toolClass, int level)
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(5.0F);
		setSoundType(SoundType.STONE);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, RockType.POLISHED));
		setHarvestLevel(toolClass, level);
		setCreativeTab(SonicTech.sonictechtab);
		
		this.name = name;
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		for(int i = 0; i < RockType.METADATA_LOOKUP.length; i++)
		{
			items.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, RockType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public String getSpecialName(ItemStack stack)
	{
		return RockType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < RockType.METADATA_LOOKUP.length; i++)
		{
			SonicTech.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "gneiss_" + RockType.values()[i].getName(), "inventory");
		}
	}
	
	public enum RockType implements IStringSerializable
	{
		POLISHED(0, "polished"),
		BRICK(1, "brick"),
		MOSSY(2, "brick_mossy"),
		CRACKED(3, "brick_cracked"),
		CARVED(4, "brick_carved");
		
		private static final RockType[] METADATA_LOOKUP = new RockType[values().length];
		private final int metadata;
		private final String name;
		
		RockType(int metadata, String name)
		{
			this.metadata = metadata;
			this.name = name;
		}
		
		public int getMetadata()
		{
			return this.metadata;
		}
		
		@Override
		public String getName() 
		{
			return this.name;
		}
		
		public static RockType byMetadata(int metadata)
		{
			if(metadata < 0 || metadata >= METADATA_LOOKUP.length)
			{
				metadata = 0;
			}
			return METADATA_LOOKUP[metadata];
		}
		
		static
		{
			for(RockType type: values())
			{
				METADATA_LOOKUP[type.getMetadata()] = type;
			}
		}
	}
}
