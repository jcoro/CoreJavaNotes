package sandbox;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class LambdaSandbox {

    /**
     * A Class used to try out some Lambda Expressions
     * Lambda Expressions are blocks of code that can be passed around so they can be executed later.
     *
     * As an object-oriented language, Java previously required creating an object of a class
     * which contained a method with the required code.
     *
     * We can use a Lambda Expression in Java 8 whenever a functional interface is expected.
     *
     * A functional interface is an interface with a single abstract method. Lambdas allow us to
     * write a block of code for, and pass parameters, to, this method.
     *
     * Lambda Expressions are an alternative to creating custom classes and anonymous inner classes
     * to implement things like listeners.
     */

    public static String PRED_TEST_STRING = "predicate test string";

    public static void main(String[] args){


        // We created a method that takes a BiFunction as the first parameter.
        // This gives us the apply() method which runs the method passed to the
        // Lambda with the given parameters, a & b.
        int biFunctioncalculator = biFunctionCalculator((a, b) -> (a * b), 3,  5);
        System.out.println("biFunctionCalculator" + biFunctioncalculator);

        /*
        We created a method that takes a {@code Predicate} as the first parameter.
        This {@code Predicate} is created with a Lambda and allows us to to call the test()
         method. The method we create in the Lambda will be executed in the test() method of the
         {@code Predicate}.
         */
        boolean lambdaBoolean = checkEqualityFromPredicate((s) ->
                s.equals(LambdaSandbox.PRED_TEST_STRING), "predicate test string");
        System.out.println( "lambdaBoolean: " + lambdaBoolean);

        /*
        We also created a class that implements the {@code Predicate} interface.
        This is how the same functionality would be achieved without Lambdas.
         */
        Predicate<String> nonLambdaPredicate = new NonLambdaPredicate<>();
        System.out.println("nonLambdaPredicate: " + nonLambdaPredicate.test("predicate test string"));

        // We can use our created class with our existing checkEqualityFromPredicate()
        boolean predBoolean = checkEqualityFromPredicate(new NonLambdaPredicate<>(), "predicate test string");
        System.out.println("predBoolean: " + predBoolean);

        // Without Lambdas, we can also create an anonymous Predicate object
        @SuppressWarnings("Convert2Lambda") boolean anonBoolean = checkEqualityFromPredicate(
                new Predicate<String>() {
                    @Override
                    public boolean test(String someString){
                        return someString.equals(LambdaSandbox.PRED_TEST_STRING);
                    }
                }, "some random string");
        System.out.println("anonBoolean:" + anonBoolean);

        // We can put METHOD REFERENCES in the same places we can put
        // Lambda Expressions (interfaces with single abstract methods)
        // (Press CMD + C to stop)

        // Timer t = new Timer(1000, event ->
        // System.out.println(event));
        // t.start();

        // is the same as:

        //Timer timer = new Timer(1000, System.out::println);
        //timer.start();

	    /*
	     * this is the same as
	     * event -> System.out.println(event);
	     * object::instanceMethod
	     * example: System.out::println
	     * System.out results in a PrintStream object, on which println() is a instance method
	     * this supplies the parameters to the method
	     *
	     * Class::staticMethod
	     * example: Math::pow
	     * this supplies the parameters to the method
	     * (x, y) -> Math.pow(x, y);
	     * This makes sense because no object exists for static methods.
	     *
	     * Class::instanceMethod
	     * example: String::compareToIgnoreCase
	     * In this example, the first parameter becomes the target of the method
	     * (x, y) -> x.compareToIgnoreCase(y)
	     * This makes sense because instance methods are called on objects.
	     *
	     *
	     * CONSTRUCTOR REFERENCES
	     * Just like method references, but the method name is: new
	     * int[]::new is the same as: x -> new int[x]
	     *
	     * ArrayList<String> names = ...;
	     * Stream<Person> stream = names.stream().map(Person::new);
	     * List<Person> people = stream.collect(Collectors.toList();
	     *
	     * the map() method calls the Person(String) constructor
	     *
	     */

    }

    /* A BiFunction<T, U, R> is a functional interface. What function does it serve?
     * Its first two type parameters signify the input types, and
     * its lone abstract method, apply(), returns an object of the third type parameter.
     * This means that it allows us to supply two objects, perform some action and return an object.
    */

    /**
     * * Creates a BiFunction object which takes parameter types:
     * 1. String
     * 2. String
     * and Returns:
     * 3. Integer
     *
     * Then calls BiFunctionObject.apply() passing in the strings
     *
     * @param one - the first string
     * @param two - the second string
     * @return an int indicating the londer string, or if they are equal length.
     */
    public static int biFunctionStringLength(String one, String two){

        BiFunction<String, String, Integer> bi = (first, second) ->
        {
            if(first.length() < second.length()) return -1;
            else if (first.length() > second.length()) return 1;
            else return 0;
        };
        return bi.apply(one, two);
    }

    /**
     * A Function which takes a {@code BiFunction} as the first parameter and returns the result
     * of calling apply() on it. The Lambda used to
     * @param bi - the BiFunction
     * @param i1 - the first BiFunction.apply() parameter
     * @param i2 - the second BiFunction.apply() parameter
     * @return - the result of the apply() function (Note third type parameter is an Integer).
     */
    public static int biFunctionCalculator(BiFunction<Integer, Integer, Integer> bi, Integer i1, Integer i2 ) {
        return bi.apply(i1, i2);
    }

    /* A Predicate is a functional interface. What function does it serve?
    * Its lone abstract method, test(), returns a boolean which means that it allows us to supply a
    * block of code which tests a condition.
    */


    /**
     * A method using a {@code Predicate<>} Interface to test if two strings are equal.
     * @param pred - A {@code Predicate<String>}
     * @param string2 - the parameter passed to the code we created in the Lambda Expression we
     *                created.
     * @return the test method runs the code we created in the Lambda Expression and uses string2
     * in place of the s parameter we used.
     */
    public static boolean checkEqualityFromPredicate(Predicate<String> pred, String string2 ){
        return pred.test(string2);
        // tests string2.equals(LambdaSandbox.PRED_TEST_STRING)
    }

}

/**
 * A class to illustrate what Lambda Expressions are doing "under the hood"
 * @author john
 *
 * @param <T> The type of the NonLambdaPredicate
 */
class NonLambdaPredicate<T> implements Predicate<T>{

    @Override
    public boolean test(T t) {
        return LambdaSandbox.PRED_TEST_STRING.equals(t);
    }
}

