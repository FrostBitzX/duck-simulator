import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PoliteQuack implements Quackable{
    Quackable duck;

    public PoliteQuack(Quackable duck){
        this.duck = duck;
    }

    @Override
    public void quack() {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        duck.quack();

        System.out.flush();
        System.setOut(systemOut);

        String output = baos.toString().trim();
        System.out.println(output + " krub");
    }

    @Override
    public boolean isPolite() {
        return true;
    }
}
