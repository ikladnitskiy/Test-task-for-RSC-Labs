package com.ikladnitskiy.testTask.dto;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Транспортная сущность, представляющая собой результат агрегации данных по указанным столбцам
 * таблицы.
 */
public class Pivot {

  private String row;
  private String col;
  private BigInteger val;

  public Pivot() {
  }

  public Pivot(String row, String col, BigInteger val) {
    this.row = row;
    this.col = col;
    this.val = val;
  }

  public String getRow() {
    return row;
  }

  public void setRow(String row) {
    this.row = row;
  }

  public String getCol() {
    return col;
  }

  public void setCol(String col) {
    this.col = col;
  }

  public BigInteger getVal() {
    return val;
  }

  public void setVal(BigInteger val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pivot)) {
      return false;
    }
    Pivot pivot = (Pivot) o;
    return Objects.equals(row, pivot.row) &&
        Objects.equals(col, pivot.col) &&
        Objects.equals(val, pivot.val);
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, col, val);
  }
}
