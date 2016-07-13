/*
 * Copyright (c) 2016. ESTsoft Futures - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Jisung Lim <jisunglim@estsoft.com>, June 2016
 */

package com.estsoft.practice_algo.stack;

/**
 * Created by Jisung on 6/9/2016.
 */
public class TohObj {
  private Operation operation;
  private int num;
  private Pole start;
  private Pole goal;
  private Pole temp;

  /**
   * Created by Jisung on 6/9/2016. Recursive Call Operation.
   */
  TohObj(Operation operation, int num, Pole start, Pole goal, Pole temp) {
    this.operation = operation;
    this.num = num;
    this.start = start;
    this.goal = goal;
    this.temp = temp;
  }

  /**
   * Created by Jisung on 6/9/2016. MOVE operation.
   */
  TohObj(Operation operation, Pole start, Pole goal) {
    this.operation = operation;
    this.start = start;
    this.goal = goal;
  }

  public Operation getOperation() {
    return operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public Pole getStart() {
    return start;
  }

  public void setStart(Pole start) {
    this.start = start;
  }

  public Pole getGoal() {
    return goal;
  }

  public void setGoal(Pole goal) {
    this.goal = goal;
  }

  public Pole getTemp() {
    return temp;
  }

  public void setTemp(Pole temp) {
    this.temp = temp;
  }
}
