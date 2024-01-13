package com.gfl.prokhnov.example.patterns.decorator;

public class CoffeeShop {
    public static void main(String[] args) {

        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: " + simpleCoffee.getCost() + ", Description: " + simpleCoffee.getDescription());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: " + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription());

        Coffee sweetCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: " + sweetCoffee.getCost() + ", Description: " + sweetCoffee.getDescription());
    }
}
