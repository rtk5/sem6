class VegBurgerBuilder implements BurgerBuilder {

    private Burger burger = new Burger();

    public void buildBun() { burger.setBun("Whole Wheat Bun"); }
    public void buildMeat() { burger.setMeat("Veg Patty"); }
    public void buildCheese() { burger.setCheese("No Cheese"); }
    public void buildSalad() { burger.setSalad("Tomato & Lettuce"); }
    public void buildSauce() { burger.setSauce("Mint Sauce"); }

    public Burger getBurger() { return burger; }
}