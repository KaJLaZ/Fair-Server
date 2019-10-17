package game.controllers;

import game.core.dataBase.CorrectDrawSymbolsState;
import game.core.dataBase.HasMoneyState;
import game.core.dataBase.SentBoxCounterState;
import game.core.dataBase.SentBoxState;
import game.core.drawRuns.Box;
import game.core.drawRuns.Symbol;
import game.core.lobby.GameRoot;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class DrawRunsController extends Controller {
    @RequestMapping(method = RequestMethod.GET, value = "/getNameGoods")
    public String getNameGoods() {
        Object[] allBoxes = Utilities.getBean("boxes").getObjects();
        Box box = (Box) Utilities.getRandomObjectOfArray(allBoxes);
        int amountSentBox = (Integer) mapBase.get(SentBoxCounterState.class).get();

        mapBase.replace(SentBoxCounterState.class, new SentBoxCounterState(amountSentBox + 1));
        mapBase.replace(SentBoxState.class, new SentBoxState(box));
        return box.getNameGoods();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkSymbol")
    public void checkSymbol(String[] appearance) {
        Box box = (Box) mapBase.get(SentBoxState.class).get();

        Symbol symbol = new Symbol(Symbol.transformToAppearance(appearance));

        if (Symbol.isSymbolCorrect(symbol, box.getCorrectSymbols())) {

            int correctDrawSymbols = (int) mapBase.get(CorrectDrawSymbolsState.class).get();
            mapBase.replace(CorrectDrawSymbolsState.class, new CorrectDrawSymbolsState(correctDrawSymbols + 1));
        }

        if ((Integer) mapBase.get(SentBoxCounterState.class).get() == GameRoot.AMOUNT_BOX_FOR_ONE_GAME) {

            if ((Integer) mapBase.get(CorrectDrawSymbolsState.class).get() == GameRoot.AMOUNT_BOX_FOR_ONE_GAME)
                mapBase.replace(HasMoneyState.class, new HasMoneyState(true));

            mapBase.replace(SentBoxCounterState.class, new SentBoxCounterState(0));
            mapBase.replace(CorrectDrawSymbolsState.class, new CorrectDrawSymbolsState(0));
        }
    }
}