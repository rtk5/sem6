class Chef {

    private BurgerBuilder builder;

    public void setBuilder(BurgerBuilder builder) {
        this.builder = builder;
    }

    public void constructBurger() {
        builder.buildBun();
        builder.buildMeat();
        builder.buildCheese();
        builder.buildSalad();
        builder.buildSauce();
    }

    public Burger getBurger() {
        return builder.getBurger();
    }
}