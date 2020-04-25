package EffectiveJava.CreatingAndDestroyingObjects;

import java.util.HashSet;
import java.util.Set;

/**
 * When a class constructor has several parameters (more than 4) some of which
 * are optional, we could either use telescope constructors (where each
 * additional constructor gets a new parameter). But this is not user friendly.
 * Moreover, adding setter parameters for those optionals is not a good idea.
 * First, because the object becomes mutable. Second, because the user may
 * forget to assign parameters. Though this has the benefit of making parameter
 * setting more readable, yet very verbose.
 * 
 * 
 * To overcome this, it's beneficial to use a variation of the builder pattern.
 * Notice how each builder for optional parameters returns this. What does this
 * do? Well, ...., it allows for a very nice method chaining, which makes the
 * construction of the class possible in one line, like
 * 
 * NutritionFacts cocaCola = new NutritionFacts.Builder(240,
 * 8).calories(100).sodium(35).carbohydrate(27).build();
 * 
 * Keep reading below!
 */
class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}

/**
 * One interesting point here is that we can create a hierarchy of builders for
 * a hierarchy of class two, if we let the builder be an abstract class itself.
 * This is particularly usefull when a subclass wants to add it's own optional
 * parameters.
 * 
 * Note that we want the builder to return an instance of the derived class, not
 * the base class. This technique, wherein a subclass method is declared to
 * return a subtype of the return type declared in the super-class, is known as
 * covariant return typing. It allows clients to use these builders without the
 * need for casting
 * 
 */

abstract class Pizza {
    public enum Toppings {
        Mushroom, Onion
    };

    protected Set<Toppings> toppings;

    abstract static class Builder {
        private Set<Toppings> toppings = new HashSet<>();

        public Builder addTopping(Toppings topping) {
            toppings.add(topping);
            return this;
        }

        public abstract Pizza build();

    }

    public Pizza(Builder builder) {
        toppings = builder.toppings;
    }

}

class NYPizza extends Pizza {
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    public static class Builder extends Pizza.Builder {
        private final Size size;

        public Builder(Size size) {
            this.size = size;
        }

        @Override
        public NYPizza build() {
            return new NYPizza(this);
        }

    }

    public NYPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    // We are limited to the base class in this construction, and need to perform a
    // cast. Why is this the case? Because the build in our class returns a NYPizza
    // after all?
    // Notice that addTopping here returns a reference to the base class. Yet build
    // uses dynmaic method dispatching to go back to the last overridden method.
    // Which is
    // why at the end, we create a NYPizza, but because the signature of the base
    // method is Pizza
    // we still need an explicit cast.
    public static void main(String[] args) {
        Pizza pizza = new NYPizza.Builder(NYPizza.Size.LARGE).addTopping(Pizza.Toppings.Mushroom).build();
        System.out.println(pizza instanceof NYPizza);

        // This would not compile.
        // NYPizza pizza1 = new
        // NYPizza.Builder(NYPizza.Size.LARGE).addTopping(Pizza.Toppings.Mushroom).build();
    }
}

/**
 * To get rid of the need for the cast, we know that the build method must
 * return a generic type (to let it's type be variant). However, it this type
 * were to extend the base Pizza class, then the build classes would return
 * generics. Hence, for the derived class we would need an explicit cast, and we
 * cannot chain the methods properly as before.
 */

abstract class Pizza1 {
    public enum Toppings {
        Mushroom, Onion
    };

    protected Set<Toppings> toppings;

    abstract static class Builder<T extends Pizza1> {
        private Set<Toppings> toppings = new HashSet<>();

        public Builder<T> addTopping(Toppings topping) {
            toppings.add(topping);
            return this;
        }

        public abstract T build();

    }

    // We use the wildcard, only because we know that all subtypes have size.
    public Pizza1(Builder<?> builder) {
        toppings = builder.toppings;
    }

}

/**
 * This is why we opt for the third option. Thas is, to use recursive type param
 * generic.
 * 
 * The issue that we face here however is that we cannot return the current
 * instance of the builder. Hence, we opt for an auxiliary self method, which is
 * overridden by the derived class.
 * 
 * One thing I still don't like about this implementation is that we are
 * changing the return type of overridden methods, which is not nice!
 */
abstract class Pizza2 {
    public enum Toppings {
        Mushroom, Onion
    };

    protected Set<Toppings> toppings;

    abstract static class Builder<T extends Builder<T>> {
        private Set<Toppings> toppings = new HashSet<>();

        public T addTopping(Toppings topping) {
            toppings.add(topping);
            return self();
        }

        public abstract Pizza2 build();

        public abstract T self();

    }

    public Pizza2(Builder<?> builder) {
        toppings = builder.toppings;
    }

}

class NYPizza2 extends Pizza2 {
    public NYPizza2(NYPizza2.Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    static class Builder extends Pizza2.Builder<NYPizza2.Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = size;
        }

        public NYPizza2 build() {
            return new NYPizza2(this);
        };

        public NYPizza2.Builder self() {
            return this;
        };

    }

}