package com.gfl.prokhnov.example.patterns.decorator;

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}
