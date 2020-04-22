package ru.javaprojectkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.Repair;
import ru.javaprojectkazan.enums.DBCommand;
import ru.javaprojectkazan.exceptions.DataSourceServiceException;
import ru.javaprojectkazan.exceptions.PropertyReaderException;
import ru.javaprojectkazan.services.DataSourceService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class RepairDAO implements DAO<Repair> {

    private DataSourceService dataSourceService = new DataSourceService();

    public RepairDAO() throws PropertyReaderException {
    }

    @Override
    public void insert(Repair repair) {

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.
                INSERT_INTO_REPAIRS_REPAIR_VALUES.getCommand())) {
            preparedStatement.setInt(1, repair.getClaimNumber());
            preparedStatement.setString(2, repair.getVehicle().getVin());
            preparedStatement.setInt(3, repair.getVehicleMileage());
            preparedStatement.setDate(4, (Date) repair.getDateOfRepair());
            preparedStatement.setInt(5, repair.getCausalPart().getCatalogueNumber());
            preparedStatement.setString(6, repair.getCausalPart().getPartName());
            preparedStatement.setInt(7, repair.getPartQuantity());
            preparedStatement.setDouble(8, repair.getPartsTotalCost());
            preparedStatement.setInt(9, repair.getRepairOperation().getCode());
            preparedStatement.setString(10, repair.getRepairOperation().getName());
            preparedStatement.setDouble(11, repair.getRepairTime());
            preparedStatement.setDouble(12, repair.getRepairOperationsTotalCost());
            preparedStatement.setDouble(13, repair.getTotalRepairCost());
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ошибка подключения к БД при попытке вставки записи с данными ремонта", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными ремонта " +
                    DBCommand.INSERT_INTO_REPAIRS_REPAIR_VALUES.getCommand(), e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public Repair get(String vin) throws Exception {
        return null;
    }

    @Override
    public Repair get(int firstParam) throws Exception {
        return null;
    }

    @Override
    public List<Repair> getAll() {
        return null;
    }
}
