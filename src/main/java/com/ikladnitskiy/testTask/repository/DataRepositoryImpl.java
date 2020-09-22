package com.ikladnitskiy.testTask.repository;

import com.ikladnitskiy.testTask.dto.Pivot;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Реализация интерфейса для работы с данными в БД.
 */
@Repository
public class DataRepositoryImpl implements DataRepository {

  private final String DB_URL = "jdbc:sqlite:./dataset/data.sqlite";
  private final String PIVOT_SQL = "SELECT %s AS row, %s AS col, sum(v) AS val FROM source_data GROUP BY 1, 2";

  /**
   * Метод возвращает новый Connection.
   */
  private Connection getConnection() throws SQLException, ClassNotFoundException {
    Connection conn;
    Class.forName("org.sqlite.JDBC");
    conn = DriverManager.getConnection(DB_URL);
    return conn;
  }

  /**
   * Метод возвращает записи двумерной сводной таблицы.
   */
  @Override
  public List<Pivot> getPivot(String row, String col) {
    List<Pivot> result = new ArrayList<>();
    try (Connection conn = getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(String.format(PIVOT_SQL, row, col));
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Pivot pivot = new Pivot();
        pivot.setRow(rs.getString("row"));
        pivot.setCol(rs.getString("col"));
        pivot.setVal(new BigInteger(rs.getString("val")));
        result.add(pivot);
      }
      rs.close();
      stmt.close();
    } catch (SQLException | ClassNotFoundException ex) {
//      log.error("Ошибка подключения к базе данных!");
    }
    return result;
  }
}
