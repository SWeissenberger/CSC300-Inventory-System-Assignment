



# Inventory Tracker Assignment

For this assignment you will be building an inventory tracking program which
will be used to track the following information about a given set of items:

* Item name
* Quantity purchased
* Purchase price
* Quantity sold
* Selling price

## Input/Output

This inventory system will accept multiple commands that indicate when an item
was sold and how many were sold, when items were purchased and in what quantity,
and a current summary of the total sales vs purchases and what the current
profit is on each item in the inventory. Below are a full list of commands that
the program must respond to:

* `add` - Adds a new item to the inventory
* `sold` - Marks n number of items as sold
* `bought` - Marks n number of items as being purchased
* `stock` - prints out the current quantity in stock for a given item
* `inventory` - prints out the current inventory and total profits per item

These commands and their parameters will be provided via `stdin` or from a file
via `stdin` redirection. See the `main` function of `InventorySystem.java` for
details on how these commands are handled and how the information that is being
provided on `StdIn` is being parsed. An example of potential input has been
provided below and can also be found inside of the `input` directory.

```text
add bannanas 55 .99 1.99
add apples 100 .85 2.99
add hamburger 255 1.99 4.99
add ham 100 1.50 3.99
add rice 500 .25 .99
sold bannanas 10
sold hamburger 25
sold ric 100
sold apples 25
sold hamburger 40
inventory
```

Note that each line starts with the command that your program is supposed to
run. After the command you will see the parameters that are provided to that
specific command. The parameters will vary based on the command that is being
executed. You can determine how many and what types of parameters each command
expects by examining the `main` function found inside of `InventorySystem.java`.

Please see the `output` directory to see examples of the output that your
program needs to generate. The associated input files for each of the output
files has been provided in the `input` directory.

## Specifications

This assignment will require you to make use of multiple classes/data types. At
a minimum you should implement the following classes

- An `Item` class which groups together the metadata about a given item. This
meta data would include things like how many of that item have been purchased,
sold, and what the purchase and sale prices for those items were. This class
should be a private class inside of `InventorySystem.java`
- A `SymbolTable` which can be used to store instances of the `Item` class. You
can think of this table as the database of items that the Inventory System
class is using to store and retrieve information about the items that your
inventory system is currently tracking. Note that symbol tables can be
implemented in a few different ways but your `SymbolTable` class should use a
 `Binary Search Tree` for its implementation. This tree implementation does not
 need to be self balancing however it must be your own implementation and not
 from any other examples

This assignment is meant to showcase how one data type can leverage other data
types to implement a fairly complex data structure/application. In this case
the `InventorySystem` class will make use of both `Item` and `SymbolTable`
classes in order to implement its logic. As a result the `InventorySystem`
file will not actually have that much code, as with our previous examples it
will be leveraging the API provided by the other classes to implement it's logic.

Also keep in mind that the specific building blocks of the `InventorySystem`
class, specifically the `SymbolTable` should be able to stand on their own. The
`SymbolTable` that you implement should be able to stand on its own and not
have any dependencies on other code/logic from the `InventorySystem` or `Item`
classes. (Hint, if you do this correctly you'll be able to repurpose you symbol
table in later assignments).

## Expectations & Rules

* You are expected to correctly implement all required methods inside of
`InventorySystem.java` and `SymbolTable.java`. Your implementations should also
handle potential edge cases that could arise without crashing.

* Your symbol table implementation should be your own, written from scratch
implementation

* You may add additional class files to support your symbol table
implementation. If you add additional class files they should be placed in the
root assignment directory, not a subdirectory

* You cannot change the prototype of any existing `public` method in the
provided classes

* You cannot add any new `public` methods to existing classes

* You can add new `private` methods and instance variables which act as helper
functions

* Your method implementations should return in the correct manner, such that if
it is a `void` method,  nothing should be returned, if it is a `boolean` method
then a Boolean should always be returned, etc

* If a sample output file is provided, then your output format must match the
provided output _exactly_, including spaces, casing, etc.

* You should include some number of test cases in other `.java` files that show
the correctness of your program in both normal and edge case scenarios. Think
about strange situations your code could end up in and show that your
implementation is able to handle it correctly. See the rubric below for exact
counts

* Your program should build with no warnings

## Building and running your program

### Intellij
As always you are able to build your program in either Intellij or from the
command line. To build with Intellij, highlight the desired file and right
click, then select the `Recompile` option. Note, if the file you just tried to
build depends on any other classes inside of your directory then you must
ensure they are built first before building your file.
If any dependencies are not built you may receive an error like

```
Error:(63, 13) java: cannot find symbol
  symbol:   class SymbolTable
  location: class InventorySystem
```

In this case the compiler is telling me that it canot find the `SymbolTable`
class which my file depends on. To resolve this issue I must first build the
`SymbolTable` class. I can then recompile my first file and the issue should be
resolved.

After the program has built you can use Intellij to execute the program by
again right clicking on the file and selecting `Run with arguments`. A popup
will appear that you may just click Ok on. Your program will now be running in
a terminal window at the bottom of your screen waiting for input.

### Terminal
To build from the command line, use the included `javac-ds` script

```
./javac-ds MyClass.java
```

After it has been built you can run the program with the `java-ds` script

```
./java-ds MyClass
```

As always you can also redirect input to your program from a file instead of
manually typing things in after starting the program

```
./java-ds MyClass < input.txt
```

When building pay close attention to warning and error messages! Error messages
may seem opaque at first but they usually describe the error quite well.
They always indicate the line number that caused the error and what the issue
was. Read these carefully to diagnose.

The same applies for runtime errors. When these errors happen you will receive
a trace that tells you the series of events that led up to the crash, including
the line numbers that were executed. Follow these and pay close attention to
the message.

## Creating Test Cases

All test files should be located inside of the tests folder. If you create a
new test with the Intellij 'new class' wizard it may automatically place the
following line at the top of the file

`package tests;`

Delete or comment out that line, if you do not you get multiple errors when
trying to use either the algs4 library functions or the classes you needed to
implement for this assignment.

To create a new test case, create a new file called `Test<some test name>.java`.
Note that the file name **__must__** start with the word `Test`. Once you have
created the test you can create an instance of your data structure and perform
the necessary operations to show the success of the test. See the included Test
files for examples, in general each test should follow these guidelines

* The test file name must have the prefix `Test`

* If the test fails, a message should be printed saying that the test failed

* If the test fails, `System.exit(1);` should be called, you can ignore Intellij
warning squiggles after that line has been written

* If the test succeeds then a message should be printed out indicating that it
was successful

Examine the included tests and use them as a template for your tests.



To build and run all tests you can use the included shell script called
`run_tests.sh` This will find all test files in the `tests` folder, build them,
and run them. This can be invoked from a terminal that is open to the assignment
directory with:

```
./run_tests.sh
```

Note, since you are implementing multiple classes, you can(and should!)
implement test cases for each of the class types.

## Rubric

Your code will be graded based on the following rubric

| Category          |                                                              |                                                              |                                                              |                                                              |
| ----------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Readability       | 6 Points                                                     | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   | Code is clean, understandable, well-organized                | Minor issues such as inconsistent indentation, variable naming, general organization | At least one major issue that makes it difficult to read     | Several major issues that make it difficult to read.         |
| Unit Tests        | 6 Points                                                     | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   | At least 6 additional unit tests are provided(beyond the already provided ones) | At least 4 additional unit tests are provided(beyond the already provided ones) | At least 2 additional unit tests are provided(beyond the already provided ones) | No unit tests were provided                                  |
| Elegance          |                                                              | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   |                                                              | Code duplication is minimized by implementing the appropriate number of functions and loop statements. | Poor design choices were used in at least one place, for example duplicate code that could have been extracted into a function or put inside of a loop was not | Code contained multiple instances of poor design, such as not modularizing duplicate code or lack of data structure use to maintain and organize data |
| Correctness       | 30 Points                                                    | 25 Points                                                    | 15 Points                                                    | 0 Points                                                     |
|                   | All specifications are met and the program always functions as expected regardless of the input provided to it | Program meets most requirements but behaves abnormally when certain edge cases are provided | The program produces incorrect output with most input sets   | Program does not compile or does not function correctly even when provided with the sample input |
| Specifications    |                                                              | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   |                                                              | Program meets all specifications provided in the assignment description file | Minor specifications have been violated (incorrectly named files, program input) | Many specifications were not met                             |
| Memory Management |                                                              | 5 Points                                                     | 3 Points                                                     | 0 Points                                                     |
|                   |                                                              | Program allocates the correct amount of data without extraneous allocations | Program has a small number of extraneous allocations that are not required | Program has many extraneous allocations                      |
