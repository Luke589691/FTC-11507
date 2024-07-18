package org.firstinspires.ftc.teamcode.utility;

public class ExampleUtility {

    // these are member variables if they are here is the meaning of the following specifiers
    // private:     can be accessed only by this class and it's subclasses
    // protected:   can be accessed by this class, it's subclasses and the package it is in
    // public:      can be accessed by any piece of code in any project
    // static:      static member variables belongs to the class itself rather than specific instantiations
    //              this means that you can do things like keep track of the number of instantiated
    //              classes or share variables among the same class without declaring them outside
    // NB: ALWAYS give your member variable the lowest accessibility you can, it is BAD PRACTICE to
    //      make public member variables as it allows other programs to edit the internal state
    //      of a class without "asking"
    // NB: you should ALWAYS instantiate your member variables in the class constructor and NOT here
    //                                                                      (unless they are static)
    private static int numInstantiations = 0;
    private int myInt;
    private String name;


    /**
     * this is a getter function. it allows an outside function to get the value of a member variable
     * without obtaining a reference to it. this prevents it from changing the value of the variable
     * without "asking" to.
     */
    public static int getNumInstantiations() {return numInstantiations;}
    public int getInt() {return this.myInt;}
    public String getName() {return this.name;}


    /**
     * this is a default constructor. this function is called when you instantiate your class.
     * here you should instantiate your member variables and do any common setup that each
     * instantiation of this class will need.
     */
    public ExampleUtility() {
        // the "this" keyword is very important. it signifies that the variable you are about to name
        // is a member of the class and whose value is specific to each instantiation of that class
        // this helps avoid confusion between member and non member variables.
        // NB: "this" is not required to reference a member variable but it is GOOD PRACTICE to do so always
        //      static member variables are not specific to each instantiation and therefore
        //      should not have a this keyword before them.
        numInstantiations++;
        this.myInt = 0;
        this.name = "";
    }

    /**
     * this is a non-default constructor. this function is called when you instantiate your class.
     * here, you can pass literals or outside variables to the constructor and it should create an
     * instantiation of your class with those values
     */
    public ExampleUtility(int myInt, String name) {
        numInstantiations++;
        this.myInt = myInt;
        this.name = name;
    }



    /**
     * these functions can be accessed without creating an instance of the ExampleUtility class e.g.
     *      ExampleUtility.isThing(num)
     * this is thanks to the static access specifier (you cannot create private static methods)
     * note that functions that are static CANNOT use non-static member variables
     */
    public static boolean isThing(String string) {return true;}
    public static boolean isOtherThing(int i) {return true;}


    /**
     * these functions need to be used on an instantiated member of the class, but can be used in
     * outside programs. these functions CAN use non-static member variables. e.g
     *
     *      ExampleUtility exampUtil = new ExampleUtility();
     *      exampUtil.reverse(myString);
     *
     */
    public String reverse(String string) {return string;}


    /**
     * these functions are helper functions. They should be declared with the private access specifier
     * and should be used only to assist the above two function types.
     * if you expect that you will need to use a similar helper function across multiple classes,
     * consider creating another util class, make the functions public in there and include it here.
     */
    private int helper(int one, double two) {return 12345;}

}
