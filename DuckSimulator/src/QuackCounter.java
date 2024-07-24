public class QuackCounter implements Quackable{
    Quackable duck;
    static int numberOfQuacks;
    static int numberOfPoliteDuck;

    public QuackCounter(Quackable duck){
        this.duck = duck;
    }
    @Override
    public void quack(){
        duck.quack();
        if(duck.isPolite()){
            numberOfPoliteDuck++;
        }else{
            numberOfQuacks++;
        }
    }

    @Override
    public boolean isPolite() {
        return false;
    }

    public static int getQuacks(){
        return numberOfQuacks;
    }

    public static int getNumberOfPoliteDuck(){
        return numberOfPoliteDuck;
    }
}
