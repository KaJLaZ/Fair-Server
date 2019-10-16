package game.controllers;

import game.core.chooseFate.History;
import game.core.chooseFate.HitApple;
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
    private History history;
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
    public void checkHit(double x, double y) {

        if(HitApple.isHited(x, y)){
            mapBase.replace(String.class, "consequence", history.getPosSequence());
        } else{
            mapBase.replace(String.class, "consequence", history.getNegSequence());
        }
    }

    private boolean isPrisonerDonated(){
          return new Random().nextBoolean();
    }
}