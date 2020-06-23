package EffectiveJava.EnumsAndAnnotations;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * We want to associate data with an enum, create a hash table, with keys
 * being the enums and values being the stuff that you want to associate with
 * them. Don't use the ordinals of the enum (Duh!).
 * 
 * Instead, use an EnumMap, which associates objects with an enumeration.
 * Especially, notice how clean the printing is! The difference between the
 * EnumMap version and the stream version is that with the EnumMap, we get an
 * empty set for every key, whereas with Stream we get keys only for ones with
 * an actual objects.
 * 
 * The next example is map between two enums. The ordinal version (PhaseI) is of
 * course is not a good idea. We should rather create an EnumMap from keys of
 * one set, and then assign our values to it. It's very interesting that if we
 * add new values (new transitions), the remainder of the code remains
 * unchanged.
 */

class Plant {
    enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL
    }

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    private void associateToLiftCycleUsingOrdinalWRONG() {
        // Using ordinal() to index into an array - DON'T DO THIS!
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        Plant[] garden = { new Plant("a", LifeCycle.ANNUAL), new Plant("b", LifeCycle.ANNUAL) };
        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        // Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }

    }

    private void associateToLiftCycleUsingOrdinalRIGHT() {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());

        Plant[] garden = { new Plant("a", LifeCycle.ANNUAL), new Plant("b", LifeCycle.ANNUAL) };
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);

        System.out.println(plantsByLifeCycle);
    }

    private void associateToLiftCycleUsingOrdinalWithStreamRIGHT() {
        // Using a stream and an EnumMap to associate data with an enum
        Plant[] garden = { new Plant("a", LifeCycle.ANNUAL), new Plant("b", LifeCycle.ANNUAL) };
        System.out.println(Arrays.stream(garden).collect(
                Collectors.groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), Collectors.toSet())));
    }

    public static void main(String[] args) {
        new Plant("a", LifeCycle.ANNUAL).associateToLiftCycleUsingOrdinalRIGHT();
    }
}

enum PhaseI {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // Rows indexed by from-ordinal, cols by to-ordinal
        private static final Transition[][] TRANSITIONS = { { null, MELT, SUBLIME }, { FREEZE, null, BOIL },
                { DEPOSIT, CONDENSE, null } };

        // Returns the phase transition from one phase to another
        public static Transition from(PhaseI from, PhaseI to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}

enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID), SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // Initialize the phase transition map (this is very easy indeed).
        private static final Map<Phase, Map<Phase, Transition>> m = Stream.of(values())
                .collect(Collectors.groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class),
                        Collectors.toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase.class))));
        

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }
}

