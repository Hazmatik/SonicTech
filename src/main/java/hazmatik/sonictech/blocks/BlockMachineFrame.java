package hazmatik.sonictech.blocks;

import java.util.List;

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
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class BlockMachineFrame extends Block implements IHasModel, IMetaName
{	
	public static final PropertyEnum<MachineTier> TIER = PropertyEnum.create("type", MachineTier.class);
	
	private String name;
	
	public BlockMachineFrame(String name) 
	{
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(5.0F);
		setResistance(5.0F);
		setSoundType(SoundType.METAL);
		setDefaultState(this.blockState.getBaseState().withProperty(TIER, MachineTier.BASIC));
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(SonicTech.sonictechtab);
		
		this.name = name;
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) 
	{
		tooltip.add("Crafting Ingredient For Machines");
		tooltip.add("Can also be placed as a decorative vent");
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {TIER});
	}
	
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		for(int i = 0; i < MachineTier.METADATA_LOOKUP.length; i ++)
		{
			items.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(TIER, MachineTier.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return state.getValue(TIER).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return state.getValue(TIER).getMetadata();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return MachineTier.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < MachineTier.METADATA_LOOKUP.length; i++)
		{
			SonicTech.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "machine_frame_" + MachineTier.values()[i].getName(), "inventory");
		}
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	public enum MachineTier implements IStringSerializable
	{
		BASIC(0, "basic"),
		IMPROVED(1, "improved"),
		ADVANCED(2, "advanced"),
		PERFECTED(3, "perfected");
		
		private static final MachineTier[] METADATA_LOOKUP = new MachineTier[values().length];
		private final int metadata;
		private final String name;
		
		MachineTier(int metadata, String name)
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
		
		public static MachineTier byMetadata(int metadata)
		{
			if(metadata < 0 || metadata >= METADATA_LOOKUP.length)
			{
				metadata = 0;
			}
			return METADATA_LOOKUP[metadata];
		}
		
		static
		{
			for(MachineTier type : values())
			{
				METADATA_LOOKUP[type.getMetadata()] = type;
			}
		}
	}

}
