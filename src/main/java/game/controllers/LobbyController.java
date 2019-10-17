package game.controllers;

import game.core.ObjectsWrapper;
import game.core.dataBase.CurrentRootState;
import game.core.lobby.GameRoot;
import game.core.lobby.RootChanger;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class LobbyController extends Controller {
    @RequestMapping(method = RequestMethod.GET, value = "/getGame")
    public GameRoot getGame() {
        ObjectsWrapper<GameRoot> objectsWrapper = (ObjectsWrapper) mapBase.get(CurrentRootState.class).get();
        GameRoot[] root = objectsWrapper.getObjects();

        int order = RootChanger.getRelevantRootNumber(root, mapBase);

        RootChanger rootChanger = new RootChanger(mapBase);

        return rootChanger.changeRoot(root, order)[order];
    }
}
