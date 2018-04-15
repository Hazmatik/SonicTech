package hazmatik.sonictech.blocks;

import hazmatik.sonictech.SonicTech;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockSTPlank extends Block implements IHasModel, IMetaName
{
	public static final PropertyEnum<WoodType> VARIANT = PropertyEnum.create("type", WoodType.class);
	
	private String name;
	
	public BlockSTPlank(String name)
	{
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, WoodType.MAGNOLIA));
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
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(int i = 0; i < WoodType.METADATA_LOOKUP.length; i++)
		{
			items.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, WoodType.byMetadata(meta));
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
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public String getSpecialName(ItemStack stack)
	{
		return WoodType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < WoodType.METADATA_LOOKUP.length; i++)
		{
			SonicTech.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "planks_" + WoodType.values()[i].getName(), "inventory");
		}
	}
	
	public enum WoodType implements IStringSerializable
	{
		MAGNOLIA(0, "magnolia"),
		CEDAR(1, "cedar"),
		PINE(2, "pine"),
		HICKORY(3, "hickory"),
		SYCAMORE(4, "sycamore");
	
	
		private static final WoodType[] METADATA_LOOKUP = new WoodType[values().length];
		private final int metadata;
		private final String name;
		
		WoodType(int metadata, String name)
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
		
		public static WoodType byMetadata(int metadata)
		{
			if(metadata < 0 || metadata >= METADATA_LOOKUP.length)
			{
				metadata = 0;
			}
			return METADATA_LOOKUP[metadata];
		}
		
		static
		{
			for(WoodType type : values())
			{
				METADATA_LOOKUP[type.getMetadata()] = type;
			}
		}
	}
}
