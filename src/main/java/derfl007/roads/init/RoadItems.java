package derfl007.roads.init;

import derfl007.roads.Reference;
import derfl007.roads.common.items.ItemWrench;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.LinkedList;
import java.util.List;

public class RoadItems {

    public static Item wrench;
    public static void init() {
        wrench = new ItemWrench();
    }

    public static void register()
    {
        registerItem(wrench);
    }

    public static void registerItem(Item item)
    {
        RegistrationHandler.ITEMS.add(item);
    }

    public static void registerModels() {
        registerModel(wrench);
    }

    public static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getRegistryName(), "inventory"));
    }

    @Mod.EventBusSubscriber()
    public static class RegistrationHandler
    {
        public static final List<Item> ITEMS = new LinkedList<>();

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            RoadItems.init();
            RoadItems.register();
            ITEMS.stream().forEach(item -> event.getRegistry().register(item));
        }
    }
}