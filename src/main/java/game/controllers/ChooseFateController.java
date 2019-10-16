package game.controllers;

import game.core.chooseFate.History;
import game.core.chooseFate.Litigation;
import game.core.lobby.GameRoot;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class ChooseFateController extends Controller{
    History history;
    @RequestMapping(method = RequestMethod.GET, value = "/getLigation")
        public Litigation getLigation() {
        Object[] allHistories = Utilities.getAllBeanConcClass("histories").getObjects();

        history = (History) Utilities.getRandomObjectOfArray(allHistories);

        return history.getLitigation();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/forgivePrisoner")
    public void forgivePrisoner()
    {
        mapBase.replace(String.class, "consequence", history.getNegSequence());

        if(isPrisonerDonated())
            mapBase.replace(Boolean.class, "isHasMoney", true);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/hasApple")
    public boolean hasApple() {
        return (boolean)mapBase.get(Boolean.class, "isStolenApples");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkHit")
    public boolean checkHit(double x, double y) {
        double x1 = x;
        double y1 = y;

        boolean isBelongByX = x >= (GameRoot.CENTER_OF_SQUARE_X - GameRoot.LENGTH_OF_HALF_SIDE)
                &&( x <= GameRoot.CENTER_OF_SQUARE_X + GameRoot.LENGTH_OF_HALF_SIDE);
        boolean isBelongByY = (y >= (GameRoot.CENTER_OF_SQUARE_Y - GameRoot.LENGTH_OF_HALF_SIDE)
                && y <= GameRoot.CENTER_OF_SQUARE_Y + GameRoot.LENGTH_OF_HALF_SIDE );

        if(isBelongByX && isBelongByY){
            mapBase.replace(String.class, "consequence", history.getPosSequence());
            return true;
        }

        else{
            mapBase.replace(String.class, "consequence", history.getNegSequence());
            return false;
        }
    }

    public boolean isPrisonerDonated(){
          return new Random().nextBoolean();
    }
}