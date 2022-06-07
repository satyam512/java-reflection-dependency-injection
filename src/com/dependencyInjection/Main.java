package com.dependencyInjection;

import com.game.Game;
import com.game.internal.TicTacToeGame;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("What took you so long ?");
        try {
            Game game = getObjectInstance(TicTacToeGame.class);
            game.startNewGame();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Kept you waiting, huh ?");
    }

    private static <T>T getObjectInstance(Class<T> inputClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> classConstructor = getFirstConstructor(inputClass);
        List<Object> constructorParams = new ArrayList<>();

        for (Class<?> clazz : classConstructor.getParameterTypes()) {
            Object paramObject = getObjectInstance(clazz);
            constructorParams.add(paramObject);
        }

        classConstructor.setAccessible(true);
        return (T) classConstructor.newInstance(constructorParams.toArray());
    }

    private static Constructor<?> getFirstConstructor(Class<?> inputClass) {
        Constructor<?>[] constructors = inputClass.getDeclaredConstructors();
        if (constructors.length == 0) {
            throw new IllegalStateException(String.format("No constructor has been found for class %s", inputClass.getName()));
        }
        return constructors[0];
    }
}
