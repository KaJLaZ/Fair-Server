package game.context;

import game.core.ObjectsWrapper;
import game.core.lobby.GameRoot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameRootContext {
    @Bean
    public GameRoot appleTheft() {
        String desc = "Прокинувшись до сходу сонця, ви поснідавши вирушили на роботу, так як дорога\n" +
                " до ярмарки не близька, а через свого босса розраховувати на обідню перерву не можна, було\n" +
                " б добре брати обід з собою. Але ви про це згадували тільки проходячи через \n" +
                " запашний яблучний сад свого босса";
        return new GameRoot(desc, GameRoot.Games.APPLE_THEFT);
    }

    @Bean
    public GameRoot secondRootAppleTheft() {
        String desc = "Цієї ночі ви погано спали, тому прокинулись раніше звичайного і вирішили на сніданок, і на обід" +
                " приготувати печені яблука, тому в сусідському саду вам потрібно було набрати вдоє більше";
        return new GameRoot(desc, GameRoot.Games.APPLE_THEFT);
    }

    @Bean
    public GameRoot chooseFate() {
        String desc = "Запізнення на роботу у вашого босса карється відсутністю оплати в цей день, тому ви зазвичай\n" +
                "приходите набагато раніше, і щоб убити час в той день ви вирішили заглянути на стовп ганьби\n";
        return new GameRoot(desc, GameRoot.Games.CHOOSE_FATE);
    }

    @Bean
    public GameRoot secondRootChooseFate() {
        String desc = "Через програш в вчорашньому алкоджеку ви не пам'ятали як дістались додому, і прокинулись " +
                "піздніше ніж зазвичай тому вам сьогодні було не до сусідських яблук, але щоб зайти на стовб ганьби" +
                "у вас час був";
        return new GameRoot(desc, GameRoot.Games.CHOOSE_FATE);
    }

    @Bean
    public GameRoot thirdRootChooseFate() {
        String desc = "На підході до роботи вас чекали шериф і ваш босс, якому також сьогодні не спалось і як ви\" +\n" +
                "перелазили огорожу його улюбленого саду";
        return new GameRoot(desc, GameRoot.Games.CHOOSE_FATE);
    }

    @Bean
    public GameRoot drawRuns() {
        String desc = "Робота у вас не складна, запаковути товари в ящики, а потім призначати їм категорію.\n" +
                "Це робиться для того щоб навіть при зговорі бандитів з персоналом мінімізувати втрати так як про те що\n" +
                "лежить в ящику достеменно знають тільки 2 людини ви і покупець. Тому якщо хоч один товар через вашу\n " +
                "помилку зіпсується, зарплати в цей день ви не бачити";
        return new GameRoot(desc, GameRoot.Games.DRAW_RUNS);
    }

    @Bean
    public GameRoot drinkers() {
        String desc = "Після тяжкого але успішного робочого дня, ви вирішили зайти в таверну, так як під час ярмарки в \n" +
                "село приїздило чимало народу ви завжди могли знайти кого можна визвати на алкоджек - народну гру регіону,\n" +
                "задача якої перепити свого суперника і залишитись в стоячому стані, програвший платив за все випите, тому\n" +
                "для таких місцевих як ви було ділом честі розкошелити приїзджих купців на випивку\n";
        return new GameRoot(desc, GameRoot.Games.DRINKERS);
    }

    @Bean
    public GameRoot secondRootDrinkers() {
        String desc = "Так як ви допомогли в'язню уникнути кари, він вирішив вам віддячити фінансово, +\n" +
                "і ви більше не були змушені йти на в цей день на роботу;";
        return new GameRoot(desc, GameRoot.Games.DRINKERS);
    }

    @Bean
    public GameRoot dream() {
        String desc = "Після тяжкого робочого дня, і відпочинку в таверні ви без задніг звалились на своє ліжко і " +
                "поринули в нічні сновидіння";
        return new GameRoot(desc, GameRoot.Games.SEQUENCE);
    }

    @Bean
    public GameRoot secondRootDream() {
        String desc = "Так як ви на роботі допустили помилку, в таверні вам немає за що чого святкувати кінець,\n" +
                "ще одного робочого дня";
        return new GameRoot(desc, GameRoot.Games.SEQUENCE);
    }

    @Bean
    public GameRoot endGame() {
        String desc = "Ось так я зустрів свою майбутню дружину і мати моїх дітей, яка змінила моє життя";
        return new GameRoot(desc, GameRoot.Games.END_GAME);
    }

    @Bean
    public ObjectsWrapper<GameRoot> firstDayFirstRoot(GameRoot appleTheft, GameRoot chooseFate, GameRoot drawRuns,
                                                      GameRoot drinkers, GameRoot dream) {

        return new ObjectsWrapper<>(appleTheft, chooseFate, drawRuns, drinkers, dream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> firstDaySecondRoot(GameRoot appleTheft, GameRoot chooseFate, GameRoot secondRootDrinkers,
                                                       GameRoot dream) {

        return new ObjectsWrapper<>(appleTheft, chooseFate, secondRootDrinkers, dream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> firstDayThirdRoot(GameRoot appleTheft, GameRoot chooseFate, GameRoot drawRuns,
                                                      GameRoot secondRootDream) {

        return new ObjectsWrapper<>(appleTheft, chooseFate, drawRuns, secondRootDream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> secondDayFirstRoot(GameRoot appleTheft, GameRoot chooseFate, GameRoot drawRuns,
                                                       GameRoot drinkers, GameRoot dream) {

        return new ObjectsWrapper<>(appleTheft, chooseFate, drawRuns, drinkers, dream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> secondDaySecondRoot(GameRoot secondRootChooseFate, GameRoot drawRuns,
                                                        GameRoot drinkers, GameRoot dream) {

        return new ObjectsWrapper<>(secondRootChooseFate, drawRuns, drinkers, dream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> secondDayThirdRoot(GameRoot appleTheft, GameRoot chooseFate,
                                                       GameRoot secondRootDrinkers, GameRoot dream) {

        return new ObjectsWrapper<>(appleTheft, chooseFate, secondRootDrinkers, dream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> secondDayFourthRoot(GameRoot appleTheft, GameRoot chooseFate, GameRoot drawRuns,
                                                         GameRoot secondRootDream) {

        return new ObjectsWrapper<>(appleTheft, chooseFate, drawRuns, secondRootDream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> secondDayFifthRoot(GameRoot secondRootChooseFate, GameRoot drawRuns,
                                                         GameRoot secondRootDream) {

        return new ObjectsWrapper<>(secondRootChooseFate, drawRuns, secondRootDream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> secondDaySixthRoot(GameRoot secondRootChooseFate,
                                                        GameRoot secondRootDrinkers, GameRoot dream) {

        return new ObjectsWrapper<>(secondRootChooseFate, secondRootDrinkers, dream);
    }

    @Bean
    public ObjectsWrapper<GameRoot> thirdDay(GameRoot secondRootAppleTheft, GameRoot thirdRootChooseFate, GameRoot endGame) {

        return new ObjectsWrapper<>(secondRootAppleTheft, thirdRootChooseFate, endGame);
    }
}
