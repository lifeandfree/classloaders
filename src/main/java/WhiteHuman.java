/**
 * WhiteHuman.
 *
 * @author Ilya_Sukhachev
 */
public class WhiteHuman implements Human {
    @Override
    public void eat(String food, int count) {
        System.out.println("eat" + food + " count" + count);
    }

    @Override
    public void sleep(int time) {
        System.out.println("Hrrr " + time);
    }

    @Override
    public String saySome() {
        return "ohohohohhh";
    }
}
