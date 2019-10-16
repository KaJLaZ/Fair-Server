package game.controllers;

import game.core.drawRuns.*;
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
public class DrawRunsController extends Controller{
    @RequestMapping(method = RequestMethod.GET, value = "/getNameGoods")
    public String getNameGoods() {
        Object[] allBoxes = Utilities.getAllBeanConcClass("boxes").getObjects();
        Box box = (Box) Utilities.getRandomObjectOfArray(allBoxes);
        int amountSentBox = (Integer) mapBase.get(Integer.class, "sentBoxCounter");

        mapBase.replace(Integer.class, "sentBoxCounter", amountSentBox + 1);
        mapBase.replace(Box.class, "sentBox", box);
        return box.getNameGoods();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkSymbol")
    public void checkSymbol(String[] appearance) {
        Box box = (Box) mapBase.get(Box.class, "sentBox");

        Symbol symbol = new Symbol(transformAppearance(appearance));

        if(Symbol.isSymbolCorrect(symbol, box.getCorrectSymbols())) {
            int correctDrawSymbols = (int)mapBase.get(Integer.class, "correctDrawSymbols");
            mapBase.replace(Integer.class, "correctDrawSymbols", correctDrawSymbols + 1);
        }

        if ((Integer) mapBase.get(Integer.class, "correctDrawSymbols") == GameRoot.AMOUNT_BOX_FOR_ONE_GAME) {
            mapBase.replace(Boolean.class, "isHasMoney", true);
            mapBase.replace(Integer.class, "correctDrawSymbols", 0);
        }

    }

    private boolean[][] transformAppearance(String[] appearance) {
        int counter = 0;
        boolean[][] newAppearance = new boolean[Symbol.AMOUNT_ROWS][Symbol.AMOUNT_COLUMNS];

        for (int i = 0; i < appearance.length; i++) {
            appearance[i] = appearance[i].replace('"', ' ');
            appearance[i] = appearance[i].replace('[', ' ');
            appearance[i] = appearance[i].replace(']', ' ');
            appearance[i] = appearance[i].trim();
        }

        for (int i = 0; i < Symbol.AMOUNT_ROWS; i++) {
            for (int j = 0; j < Symbol.AMOUNT_COLUMNS; j++) {
                newAppearance[i][j] = Boolean.valueOf(appearance[counter++]);
            }
        }

        return newAppearance;
    }
}