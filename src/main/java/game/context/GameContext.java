package game.context;

import game.controllers.AppleTheftController;
import game.core.lobby.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameContext {
    @Bean
    public Game appleTheft(){
        String desc = "Прокинувшись до сходу сонця, ви поснідавши вирушили на роботу, так як дорога\n" +
                " до ярмарки не близька, а через свого босса розраховувати на обідню перерву не можна, було\n" +
                " б добре брати обід з собою. Але ви про це згадували тільки проходячи через \n" +
                " запашний яблучний сад свого босса";
        return new Game(desc, Game.Games.APPLE_THEFT);
    }
    @Bean
    public Game chooseFate(){
        String desc = "Запізднення на роботу у вашого босса карється відсутністю оплати в цей день, тому ви зазвичай\n" +
                "приходите набагато раніше, і щоб убити час в той день ви вирішили заглянути на стовп ганьби\n";
        return new Game(desc, Game.Games.CHOOSE_FATE);
    }
    @Bean
    public Game drawRuns(){
        String desc = "Робота у вас не складна, запаковути товари в ящики, а потім призначати їм категорію.\n" +
                "Це робиться для того щоб навіть при зговорі бандитів з персоналом мінімізувати втрати так як про те що\n" +
                "лежить в ящику достеменно знають тільки 2 людини ви і покупець. Тому якщо хоч один товар через вашу\n " +
                "помилку зіпсується, зарплати в цей день ви не бачити";
        return new Game(desc, Game.Games.DRAW_RUNS);
    }
    @Bean
    public Game drinkers(){
        String desc = "Після тяжкого але успішного робочого дня, ви вирішили зайти в таверну, так як під час ярмарки в \n" +
                "село приїздило чимало народу ви завжди могли знайти кого можна визвати на алкоджек - народну гру регіону,\n" +
                "задача якої перепити свого суперника і залишитись в стоячому стані, програвший платив за все випите, тому\n" +
                "для таких місцевих як ви було ділом честі розкошелити приїзджих купців на випивку\n";
        return new Game(desc, Game.Games.DRINKERS);
    }
    @Bean
    public Game dream(){
        String desc = "Сон";
        return new Game(desc, Game.Games.SEQUENCE);
    }
}
