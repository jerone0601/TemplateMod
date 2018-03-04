package org.yggdrasil.wurmunlimited.mods.Items;

import com.wurmonline.server.items.NoSuchTemplateException;
import org.gotti.wurmunlimited.modloader.interfaces.*;
import org.yggdrasil.wurmunlimited.mods.Items.ItemDeclaration;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Jerone on 1/4/2018.
 */
public class ItemMod implements WurmServerMod, Configurable, PreInitable, Initable, ServerStartedListener, ItemTemplatesCreatedListener {
    private static final Logger logger = Logger.getLogger("ItemMod");

    public static void logException(String msg, Throwable e) {
        if (logger != null)
            logger.log(Level.SEVERE, msg, e);
    }

    public static void logWarning(String msg) {
        if (logger != null)
            logger.log(Level.WARNING, msg);
    }

    public static void logInfo(String msg) {
        if (logger != null)
            logger.log(Level.INFO, msg);
    }

    @Override
    public void configure(Properties properties) {
    }

    @Override
    public void init() {
    }

    @Override
    public void preInit() {

    }

    @Override
    public void onItemTemplatesCreated() {
        try {
            ItemDeclaration.createItems();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onServerStarted() {
        try {
            logger.info("Registering Item Mod creation entries.");
            ItemDeclaration.createItems();
            ItemDeclaration.initCreationEntries();
        } catch (IllegalArgumentException | ClassCastException e) {
            e.printStackTrace();
        }
    }
}