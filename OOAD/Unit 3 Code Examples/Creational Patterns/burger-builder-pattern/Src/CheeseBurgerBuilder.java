class CheeseBurgerBuilder implements BurgerBuilder {

    private Burger burger = new Burger();

    public void buildBun() { burger.setBun("White Bun"); }
    public void buildMeat() { burger.setMeat("Beef Patty"); }
    public void buildCheese() { burger.setCheese("Cheddar Cheese"); }
    public void buildSalad() { burger.setSalad("Lettuce"); }
    public void buildSauce() { burger.setSauce("Mayo"); }

    public Burger getBurger() { return burger; }
}