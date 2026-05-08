class Burger {
    private String bun;
    private String meat;
    private String cheese;
    private String salad;
    private String sauce;

    public void setBun(String bun) { this.bun = bun; }
    public void setMeat(String meat) { this.meat = meat; }
    public void setCheese(String cheese) { this.cheese = cheese; }
    public void setSalad(String salad) { this.salad = salad; }
    public void setSauce(String sauce) { this.sauce = sauce; }

    public void show() {
        System.out.println("Burger with: " + bun + ", " + meat + ", " +
                cheese + ", " + salad + ", " + sauce);
    }
}