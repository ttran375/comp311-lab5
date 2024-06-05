# COMP311 Static Code Analysis exercise

1. In the Checkstyle violations view, double-click the two violations
    noted in **step 10** to find the two occurrences of this problem.
    One occurs in class **UserPrompter** in method **getYesNoAnswer()**.
    Where does the other appear:

    1. Class `Ticket` Method `Ticket`

    2. How would you improve the code in the method you just named? The error message indicates that the value 1000000 is considered a "magic number," meaning it's a hard-coded number without context, making the code harder to understand and maintain. To fix this, we can define a constant for this value

    ```java
    package com.cc.airline.ticketing;

    import com.cc.airline.passengers.Passenger;

    public class Ticket {
     private Passenger passenger;
     private Seat seat;
     private double price;
     private long ticketNo;
     private static long count = 0;
     private static final long BASE_TICKET_NO = 1000000; // Define a constant for the magic number

     public Passenger getPassenger() {
      return passenger;
     }

     public void setPassenger(Passenger passenger) {
      this.passenger = passenger;
     }

     public double getPrice() {
      return price;
     }

     public Ticket(Passenger passenger, Seat seat, double price) {
      this.passenger = passenger;
      this.price = price;
      this.seat = seat;
      this.ticketNo = ++count + BASE_TICKET_NO; // Use the constant here
     }

     public void setPrice(double price) {
      this.price = price;
     }

     public Seat getSeat() {
      return seat;
     }

     public void setSeat(Seat seat) {
      this.seat = seat;
     }

     public long getTicketNo() {
      return ticketNo;
     }

     public void setTicketNo(long ticketNo) {
      this.ticketNo = ticketNo;
     }

     public String toString() {
      return ticketNo + " for seat " + seat.getRow() + seat.getLetter() +  " at $" + price;
     }
    }
    ```

2. What is the most common type of violation still reported by Checkstyle?

    - **FinalParameters**: 41
    - **LineLength**: 18
    - **RegexpSingleline**: 13
    - **FileTabCharacter**: 12
    - **ParenPad**: 12
    - **checkstyle] linter**: 11
    - **WhitespaceAround**: 4
    - **VisibilityModifier**: 4
    - **MethodParamPad**: 3
    - **MultipleVariableDeclarations**: 2
    - **NewlineAtEndOfFile**: 2
    - **NeedBraces**: 2
    - **RedundantModifier**: 1
    - **MagicNumber**: 1

    1. There are  `41` occurrences of `FinalParameters`

    2. Can you figure out how to disable checking for this violation? What module (Checkstyle category) \_ and specific check \_must you ignore? Disable <module name="FinalParameters"/> in `sun_checks.xml`

3. How did you change the code to remove the violation in step 13? Copy the improved line(s) of code here:

```java
public boolean getYesNoAnswer() {
 for (int i = 0; i < 3; i++) {
  String answer = getAnswer();
  if (answer == null) {
   return false;
  }
  char ans = answer.toUpperCase().charAt(0);
  if (ans == 'Y') {
   return true;
  }
  setPrompt(getPrompt() + ". Please answer Y or N: ");
 }
 return false;
}
```

4. There is one occurrence of an inline conditional.

    1. What operator is an inline conditional? \_ Hint: give the operator symbols

    2. Why is using the inline operator considered poor form? (Give and explanation or name the ISO 9126 quality characteristic it offends)

1. In the Checkstyle violations view, double-click the Cyclomatic
    complexity violation, to see the list of occurrences of this
    problem. Where does it occur?

    1. What is the class name  \_ and method name \_

    2. What is the cyclomatic number reported for this method? \_

    3. Does the reported cyclomatic number agree with the complexity calculated using the technique given in class? Circle: Yes or No. If no, what number did you calculate by manually  \_
