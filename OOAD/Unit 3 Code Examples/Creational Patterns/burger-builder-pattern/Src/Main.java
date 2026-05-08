public class Main {
    public static void main(String[] args) {

        Chef chef = new Chef();

        BurgerBuilder cheeseBuilder = new CheeseBurgerBuilder();
        chef.setBuilder(cheeseBuilder);
        chef.constructBurger();
        Burger cheeseBurger = chef.getBurger();
        cheeseBurger.show();

        BurgerBuilder vegBuilder = new VegBurgerBuilder();
        chef.setBuilder(vegBuilder);
        chef.constructBurger();
        Burger vegBurger = chef.getBurger();
        vegBurger.show();
    }
}