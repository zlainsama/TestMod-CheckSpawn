package me.lain.tmcs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("testmodcheckspawn")
public class TestMod
{

    Logger logger = LogManager.getLogger(TestMod.class);
    boolean fired = false;

    public TestMod()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void handleCheckSpawn(LivingSpawnEvent.CheckSpawn event)
    {
        if (!fired)
        {
            logger.info("me.lain.tmcs.TestMod.handleCheckSpawn fired");
            fired = true;
        }
        event.setResult(Result.DENY);
    }

    private void setup(FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.addListener(this::handleCheckSpawn);
    }

}
