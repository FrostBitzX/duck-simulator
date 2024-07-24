public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new PoliteCountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory){
        System.out.println("\nDuck Simulator: With Composite Flocks");

        Flock flockOfDucks = new Flock();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable mallardDuck2 = duckFactory.createMallardDuck();
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable mallardDuck4 = duckFactory.createMallardDuck();
        flockOfMallards.add(mallardDuck);
        flockOfMallards.add(mallardDuck2);
        flockOfMallards.add(mallardDuck3);
        flockOfMallards.add(mallardDuck4);

        //add mallard into duck flock
        flockOfDucks.add(flockOfMallards);

        simulate(flockOfDucks);
        simulate(flockOfMallards);

        System.out.println("The duck quacked " + QuackCounter.getQuacks() + " times");
        System.out.println("The duck polite quacked " + QuackCounter.getNumberOfPoliteDuck() + " times");
    }

    void simulate(Quackable duck){
        duck.quack();
    }
}
