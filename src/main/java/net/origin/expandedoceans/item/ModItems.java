package net.origin.expandedoceans.item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.origin.expandedoceans.ExpandedOceans;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExpandedOceans.MOD_ID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
