package game.controllers;

import game.context.MapDb;
import game.core.drawRuns.Box;
import game.core.drawRuns.Symbol;
import game.core.lobby.Game;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class DrawRunsController {
    @RequestMapping(method = RequestMethod.GET, value = "/getNameGoods")
    public String getNameGoods(@ApiIgnore MapDb mapBase) {
        List allBoxes = Utilities.getAllBeanConcClass(Box.class);
        Box box = (Box)Utilities.getRandomObjectOfList(allBoxes);
        int amountSentBox = (Integer)mapBase.get(Integer.class, "sentBoxCounter");

        mapBase.replace(Integer.class, "sentBoxCounter", amountSentBox + 1);
        mapBase.replace(Box.class, "sentBox", box);
        return box.getNameGoods();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkSymbol")
    public void checkSymbol(MapDb mapBase, Symbol symbol ) {
        Box box = (Box)mapBase.get(Box.class, "sentBox");

        if(Symbol.isSymbolCorrect(symbol, box.getCorrectSymbols())) {
            int correctDrawSymbols = (int)mapBase.get(Integer.class, "correctDrawSymbols");
            mapBase.replace(Integer.class, "correctDrawSymbols", correctDrawSymbols + 1);
        }

        if((Integer)mapBase.get(Integer.class, "sentBoxCounter") == Game.AMOUNT_BOX_FOR_ONE_GAME){
            mapBase.replace(Boolean.class, "isHasMoney", true);
            mapBase.replace(Integer.class, "sentBoxCounter", 0);
        }

    }
}