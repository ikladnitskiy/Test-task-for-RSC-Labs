package com.ikladnitskiy.testTask.repository;

import com.ikladnitskiy.testTask.dto.Pivot;
import java.util.List;

/**
 * Интерфейс, описывающий методы работы с данными.
 */
public interface DataRepository {

  List<Pivot> getPivot(String row, String col);
}
