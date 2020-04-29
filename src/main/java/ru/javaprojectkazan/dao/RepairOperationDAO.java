package ru.javaprojectkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.RepairOperation;
import ru.javaprojectkazan.enums.DBCommand;
import ru.javaprojectkazan.enums.RepairOperationParameter;
import ru.javaprojectkazan.exceptions.DataSourceServiceException;
import ru.javaprojectkazan.exceptions.PropertyReaderException;
import ru.javaprojectkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class RepairOperationDAO implements DAO<RepairOperation>{

    private DataSourceService dataSourceService = new DataSourceService();

    @Override
    public void insert(RepairOperation repairOperation) {

    }

    @Override
    public RepairOperation get(String firstParam) throws Exception {
        return null;
    }

    @Override
    public List<RepairOperation> getAll() {
        return null;
    }

    @Override
    public RepairOperation get(int operationNumber) {

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.SELECT_OPERATION_BY_NUMBER.getCommand())) {
            preparedStatement.setInt(1, operationNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(RepairOperationParameter.OPERATION_NAME.getName());
                int price = resultSet.getInt(RepairOperationParameter.OPERATION_PRICE.getName());
                return new RepairOperation(operationNumber, name, price);
            } else {
                throw new DataSourceServiceException("Операция с номером " + operationNumber + " отсутсвует.");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных об операции с номером " + operationNumber, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + DBCommand.SELECT_OPERATION_BY_NUMBER, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
