package io.jaylim.study.dsa.stack;


public class RecursionToh {

  public static void main(String[] args) {
    toh(3, Pole.Start, Pole.Goal, Pole.Temp);
  }

  private static void toh(int cnt, Pole startPole, Pole goalPole, Pole tempPole) {
    Stack<TohObj> stack = new ArrayStack<>(2 * cnt + 1);
    stack.push(new TohObj(Operation.TOH, cnt, Pole.Start, Pole.Goal, Pole.Temp));

    while (stack.length() > 0) {
      TohObj it = stack.pop();
      if (it.getOperation() == Operation.MOVE) {
        move(it.getStart(), it.getGoal());
      } else if (it.getNum() > 0) {
        stack.push(new TohObj(
            Operation.TOH, (it.getNum() - 1), it.getTemp(), it.getGoal(), it.getStart()));
        stack.push(new TohObj(
            Operation.MOVE, it.getStart(), it.getGoal()));
        stack.push(new TohObj(
            Operation.TOH, (it.getNum() - 1), it.getStart(), it.getTemp(), it.getGoal()));
      }
    }
  }

  private static void move(Pole start, Pole end) {
    System.out.println("POLE " + start + " ==> " + "POLE " + end);
  }

}
