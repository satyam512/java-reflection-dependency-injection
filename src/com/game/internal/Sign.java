package com.game.internal;

class Sign {
    private char symbol;

    public static Sign X = new Sign('X');
    public static Sign O = new Sign('O');
    public static Sign EMPTY = new Sign(' ');

    public Sign(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void print() {
        System.out.print(symbol);
    }
}
