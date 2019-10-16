package game.controllers;

import game.core.lobby.GameRoot;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class LobbyController extends Controller{
    @RequestMapping(method = RequestMethod.GET, value = "/getGame")
    public GameRoot getGame() {
        Object[] games = Utilities.getAllBeanConcClass("gameRoots").getObjects();

        int order = (int) mapBase.get(Integer.class, "gameCounter");
        mapBase.replace(Integer.class, "gameCounter", order + 1);

        if(order == GameRoot.Games.DRAW_RUNS.getNumberOfGame()){

            if((boolean)mapBase.get(Boolean.class, "isHasMoney")) {
                String desc = "Так як ви допомогли в'язню уникнути кари, він вирішив вам віддячити фінансово, " +
                        "і ви більше не були змушені йти на в цей день на роботу";

                mapBase.replace(Integer.class, "gameCounter", order + 2);

                return new GameRoot(desc,  GameRoot.Games.DRINKERS);
            }
        }

        else if(order == GameRoot.Games.DRINKERS.getNumberOfGame()){

            if(!(boolean)mapBase.get(Boolean.class, "isHasMoney")) {
                String desc = "Так як ви на роботі допустили помилку, в таверні вам немає за що чого святкувати кінець," +
                        "ще одного робочого дня";

                mapBase.replace(Integer.class, "gameCounter", order + 1);

                return new GameRoot(desc,  GameRoot.Games.SEQUENCE);
            }
        }
        return (GameRoot)games[order];
    }
}
