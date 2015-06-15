package cg.group4.aquarium;

import cg.group4.data_structures.collection.collectibles.Collectible;
import cg.group4.view.AquariumScreen;
import com.badlogic.gdx.Game;

import java.util.Observable;
import java.util.Observer;

/**
 * The purpose of the Launcher is to launch the collection application.
 * This Launcher is a separate launcher from the Launcher in the core project.
 * This is because it does not require several pieces such as game logic.
 */
public class Aquarium extends Game {
    protected Connector cConnector;
    protected Configuration cAquariumConfig;
    protected AquariumScreen cAquariumScreen;

    public void init() {

        // todo
        cConnector = new Connector("my nice group");
        cAquariumConfig = new Configuration();

        System.out.println("Connecting to " + cAquariumConfig.getHost() + " : " + cAquariumConfig.getPort());

    }

    @Override
    public void create() {
        init();
        cAquariumScreen = new AquariumScreen(cConnector.getCollectionFromServer());
        setScreen(cAquariumScreen);
        System.out.println(cConnector.getCollectionFromServer());
    }

}
