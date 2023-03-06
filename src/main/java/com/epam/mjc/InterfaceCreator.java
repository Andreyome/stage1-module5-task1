package com.epam.mjc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return input -> {
            for (String i : input) {
                if (!((Character.isUpperCase(i.charAt(0))))) {
                    return false;
                }
            }
            return true;
        };
    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {

        return input -> {
            List<Integer> output = new LinkedList<>(input);
            for (Integer number : output) {
                if (number % 2 == 0) {
                    input.add(number);
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> output = new LinkedList<>(values);
            for (String str : output) {
                String[] tmp = str.split(" ");
                if (!(Character.isUpperCase(tmp[0].charAt(0)))) {
                        values.remove(str);
                }
                if (!(tmp[tmp.length - 1].endsWith("."))){
                    values.remove(str);
                }
                if (!(tmp.length >= 4)) {
                    values.remove(str);
                }
            }
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
return input -> {
    Map<String, Integer> output = new HashMap<>();
    for (String tmp : input){
        output.put(tmp,tmp.length());
    }
   return output;
};
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
    return (input1, input2) -> {
List <Integer> output = new LinkedList<>();
        output.addAll(input1);
        output.addAll(input2);
        return output;
    };
    }
}
