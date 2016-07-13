package com.estsoft.practice_algo.stack;

public class TowerOfHanoi {
        /* 1. What is TOH?
	 * The Tower of Hanoi (also called the Tower of Brahma or Lucas' Tower, and
	 * sometimes pluralized) is a mathematical game or puzzle. It consists of 
	 * three rods, and a number of disks of different sizes which can slide onto 
	 * any rod. The puzzle starts with the disks in a neat stack in ascending 
	 * order of size on one rod, the smallest at the top, thus making a conical 
	 * shape.
	 * 
	 * The objective of the puzzle is to move the entire stack to another rod, 
	 * obeying the following simple rules:
	 * 
	 * 	- (1) Only one disk can be moved at a time.
	 * 	- (2) Each move consists of taking the upper disk from one of the stacks 
	 * 		  and placing it on top of another stack i.e. a disk can only be 
	 * 		  moved if it is the uppermost disk on a stack.
	 * 	- (3) No disk may be placed on top of a smaller disk.
	 */
	
	/* 2. Is nth Tower of Hanoi always solvable for nonnegative integer n? Yes.
	 * 	
	 * 		Pf. (by Induction)
	 * 		Step 1. Let p(n) be the predicate that nth Tower of Hanoi is solvable.
	 * 			
	 * 					p(n) ::= The n disks in a neat stack in ascending 
	 * 							 order of size on one pole can be moved to 
	 * 							 another pole.
	 * 		
	 * 		Step 2. When n = 1, p(1) implies that the only single ring can move to any 
	 * 				other pole. The only things we have to do is Moving the sole ring
	 * 				from one pole to another. Hence, p(1) is true.
	 * 
	 * 		Step 3. Let us define the proposition for inductive hypothesis as follows :
	 * 			
	 * 					Inductive Hypothesis : for n >= 1, If p(n) is true,
	 * 										   then p(n+1) is true.
	 * 
	 * 				Now, assume that p(n) is true for n>=1 and there exists the n+1 
	 * 				disks in order of size on start pole, then we can reduce the (n+1)th 
	 * 				problem, p(n+1), into two nth problem, p(n), and one 1st problem, p(1).
	 * 				The sequence is follows :
	 * 
	 * 					1) p(n) : start => temp
	 * 					2) p(1) : start => end
	 * 					3) p(n) : temp	=> end
	 * 
	 * 				Hence, p(n+1) is true. So it follows by induction that p(n) is true
	 * 				for all nonnegative n.
	 * 																				QED. 
	 */

  /* 3. How many times of movement it requires with repect to n? The minimum number of
   * 	  moves required to solve a Tower of Hanoi puzzle is 2**n - 1, where n is the
   * 	  number of disks.
   *
   * 		Pf. (By recursive function)
   * 		Step 1. We will define recursively the function of the number of movement
   * 				operation requires. Let f(n) is the function as follows :
   *
   * 					f(n) ::= the number of movement of a single ring
   * 							 from one pole to another.
   * 				And then, the base case of n = 1 is
   *
   * 					f(1) = 1
   *
   * 		Step 2. because there exists only one ring. Since, from the proof of solva
   * 				-bility, we know that f(n) can be reduced into two f(n-1) and one
   * 				f(1). Therefore, we can find the equation as follows :
   *
   * 					f(n) = 2*f(n-1) + f(1)
   *
   * 						 = (2**(n-1))*f(1) + SIGMA(i=1, n-1, 2**(i-1))
   *
   * 		Step 3. To replace it with an algebraic equation with the same value as the
   * 				summation.
   *
   * 					f(n) = (2**(n-1)) + (2**(n-1) - 1) / (2 - 1)
   *
   * 						 = 2**n - 1
   *
   *				Hence, the minimum number of moves required to solve a Tower of Hanoi
   *				puzzle is 2**n - 1, where n is the number of disks.
   * 																				QED.
   */
  public static void main(String[] args) {
    TOH(5, 1, 3, 2);
  }

  public static void TOH(int n, int start, int end, int temp) {
    System.out.println("[TOH with n = " + n + "] CALLED");
    if (n == 0) {
      System.out.println("[TOH BASE CASE ] FINISHED");
      return;
    }
    TOH(n - 1, start, temp, end);
    move(n, start, end);
    TOH(n - 1, temp, end, start);
    System.out.println("[TOH with n = " + n + "] FINISHED");
  }

  public static void move(int n, int start, int end) {
    System.out.println("\n[MOVE with n = " + n + "] MOVING" + " : " + "POLE " + start + " ==> " + "POLE " + end + "\n");
//		System.out.println(n + " : " + "POLE " + start + " ==> " + "POLE " + end);
  }
}
