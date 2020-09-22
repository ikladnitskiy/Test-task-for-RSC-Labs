package com.ikladnitskiy.testTask.rest;

import com.ikladnitskiy.testTask.dto.Pivot;
import com.ikladnitskiy.testTask.repository.DataRepositoryImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер действий со сводными таблицами.
 */
@RestController
@RequestMapping("")
public class PivotController {

  private DataRepositoryImpl repository;

  @Autowired
  public PivotController(DataRepositoryImpl repository) {
    this.repository = repository;
  }

  /**
   * Метод для получения сводной таблицы.
   *
   * @param row - наименование столбца базы данных для группировки таблицы по вертикали;
   * @param col - наименование столбца базы данных для группировки таблицы по горизонтали.
   */
  @GetMapping(value = "")
  public List<Pivot> getPivot(@RequestParam String row, @RequestParam String col) {
    return repository.getPivot(row, col);
  }
}
