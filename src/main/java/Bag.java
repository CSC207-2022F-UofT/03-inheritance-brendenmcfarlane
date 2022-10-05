/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

import java.lang.reflect.Array;

public abstract class Bag {
    private String color; //str named color
    private int numberOfContents; // int named numberOfContents
    private int capacity; // int named capacity
    private String[] contents; // array of strings named contents

    public Bag(String color, int capacity) {
        this.color = color;
        this.numberOfContents = 0;
        this.capacity = capacity;
        this.contents = new String[capacity];
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfContents() {
        return numberOfContents;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean addItem(String item){
        if (this.numberOfContents >= this.capacity){
            return false;
        } else {
            this.contents[this.numberOfContents] = item;
            this.numberOfContents++;

            return true;
        }
    }




    /**
     *
     *
     * If there are no items in this Bag, return null.
     *
     * @return
     */
    public String popItem(){
        if (this.numberOfContents == 0) {
            return null;
        } else {
            this.numberOfContents--;
            return this.contents[this.numberOfContents];
        }
    }

    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        this.capacity += n;
        String[] newBag = new String[this.capacity];

        for (int i = 0; i < (this.capacity - n); i++) {
        newBag[i] = this.contents[i];
        }
        this.contents = newBag;

    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}