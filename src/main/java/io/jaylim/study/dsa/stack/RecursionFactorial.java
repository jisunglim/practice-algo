package io.jaylim.study.dsa.stack;

public class RecursionFactorial {

  //Recursion
  public static long factRecur(int n) {
    assert 0 <= n && n <= 20 : "n out of range";
    if (n > 1)
      return factRecur(n - 1) * n;
    else
      return 1;
  }

  //Recursion with activation record
  public static long factRecurAct(int n) {
    assert 0 <= n && n <= 20 : "n out of range";
    if (n > 1) {
      System.out.println("Recursive Call : " + n);
      try {
        return factRecurAct(n - 1) * n;
      } catch (Exception E) {
        return 0L;
      } finally {
        System.out.println("Operation end : " + n);
      }
    } else {
      System.out.println("BaseCase : " + n);
      return 1;
    }
  }

  public static long factStack(int n) {
    //To fit n! in a long variable, require n < 21;
    assert 0 <= n && n <= 20 : "n out of range";

    //Make a io.jaylim.study.dsa.stack just big enough
    Stack<Integer> S = new ArrayStack<Integer>(n);
    while (n > 1) {
      S.push(n--);
    }
    long result = 1;
    while (S.length() > 0) {
      result = result * S.pop();
    }
    return result;
  }

  //Replacing recursion with a io.jaylim.study.dsa.stack.
  public static long factStackAct(int n) {
    //To fit n! in a long variable, require n < 21;
    assert 0 <= n && n <= 20 : "n out of range";

    //Make a io.jaylim.study.dsa.stack just big enough
    Stack<Integer> S = new ArrayStack<Integer>(n);
    while (n > 1) {
      S.push(n--);
      System.out.println("PUSH : " + S.topValue());
    }

    long result = 1;
    System.out.println("BaseCase : " + result);

    while (S.length() > 0) {
      System.out.println("POP : " + S.topValue());
      result = result * S.pop();
    }
    return result;
  }


  public static void main(String[] args) {
    System.out.println("<==========================< Recursion >==========================>");
    long frStart = System.currentTimeMillis();
    System.out.println(factRecur(20));
    long frEnd = System.currentTimeMillis();
    System.out.println(frStart);
    System.out.println(frEnd);

    System.out.println("<==============< Recursion With Activation Records >==============>");
    long fraStart = System.currentTimeMillis();
    System.out.println(factRecurAct(20));
    long fraEnd = System.currentTimeMillis();
    System.out.println(fraStart);
    System.out.println(fraEnd);

    System.out.println("<==============< Replacing Recursion  with a Stack >==============>");
    long fsStart = System.currentTimeMillis();
    System.out.println(factStack(20));
    long fsEnd = System.currentTimeMillis();
    System.out.println(fsStart);
    System.out.println(fsEnd);

    System.out.println("<==============< Replacing Recursion  with a Stack >==============>");
    long fsaStart = System.currentTimeMillis();
    System.out.println(factStackAct(20));
    long fsaEnd = System.currentTimeMillis();
    System.out.println(fsaStart);
    System.out.println(fsaEnd);

    long frTime = frEnd - frStart;
    long fraTime = fraEnd - fraStart;
    long fsTime = fsEnd - fsStart;
    long fsaTime = fsaEnd - fsaStart;

    System.out.println("+-------------+----------------------+");
    System.out.print("+FactRacur    |");
    System.out.printf("%16d (ms) |\n", frTime);
    System.out.println("+-------------+----------------------+");
    System.out.print("+FactRacurAct |");
    System.out.printf("%16d (ms) |\n", fraTime);
    System.out.println("+-------------+----------------------+");
    System.out.print("+FactStack    |");
    System.out.printf("%16d (ms) |\n", fsTime);
    System.out.println("+-------------+----------------------+");
    System.out.print("+FactStackAct |");
    System.out.printf("%16d (ms) |\n", fsaTime);
    System.out.println("+-------------+----------------------+");

  }
}
