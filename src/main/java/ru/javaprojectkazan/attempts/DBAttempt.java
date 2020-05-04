package ru.javaprojectkazan.attempts;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.Vehicle;
import ru.javaprojectkazan.enums.DBCommand;
import ru.javaprojectkazan.exceptions.DataSourceServiceException;
import ru.javaprojectkazan.services.DataSourceService;

import java.sql.*;
import java.time.LocalDate;

@Slf4j
public class DBAttempt {
    public static void main(String[] args) {

        DataSourceService dataSourceService= new DataSourceService();

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.
                INSERT_INTO_REPAIRS_REPAIR_VALUES.getCommand())) {
            //preparedStatement.setInt(1, repair.getClaimNumber());
            preparedStatement.setString(1, "123456");
            preparedStatement.setInt(2, 100);
            preparedStatement.setDate(3, java.sql.Date.valueOf("2020-04-20"));
            preparedStatement.setInt(4, 1);
            preparedStatement.setString(5, "Bearing");
            preparedStatement.setInt(6, 2);
            preparedStatement.setDouble(7, 200);
            preparedStatement.setInt(8, 1);
            preparedStatement.setString(9, "repair");
            preparedStatement.setDouble(10, 2);
            preparedStatement.setDouble(11, 200);
            preparedStatement.setDouble(12, 400);
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ошибка подключения к БД при попытке вставки записи с данными ремонта", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными ремонта " +
                    DBCommand.INSERT_INTO_REPAIRS_REPAIR_VALUES.getCommand(), e);
        } finally {
            dataSourceService.closeConnection();
            System.out.println("Вставка завершена");
            Vehicle vehicle = new Vehicle();
            vehicle.getDispatchDate();
        }

    }
}
