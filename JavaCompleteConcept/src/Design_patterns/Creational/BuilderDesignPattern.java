package Design_patterns.Creational;

public class BuilderDesignPattern {
    private String burger;
    private String drink;
    private String side;

    private BuilderDesignPattern(Builder builder) {
        this.burger = builder.burger;
        this.drink = builder.drink;
        this.side = builder.side;
    }

    public String getBurger() {
        return burger;
    }

    public String getDrink() {
        return drink;
    }

    public String getSide() {
        return side;
    }

    public static class Builder {
        private String burger;
        private String drink;
        private String side;

        public Builder() {}

        public Builder burger(String burger) {
            this.burger = burger;
            return this;
        }

        public Builder drink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder side(String side) {
            this.side = side;
            return this;
        }

        public BuilderDesignPattern build() {
            return new BuilderDesignPattern(this);
        }
    }
}
    class Main {
    public static void main(String[] args) {
        BuilderDesignPattern meal = new BuilderDesignPattern.Builder()
                .burger("Cheeseburger")
                .drink("Cola")
                .side("Fries")
                .build();

        System.out.println("Burger: " + meal.getBurger());
        System.out.println("Drink: " + meal.getDrink());
        System.out.println("Side: " + meal.getSide());
    }
}
