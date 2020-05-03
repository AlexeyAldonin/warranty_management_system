package ru.javaprojectkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.Repair;
import ru.javaprojectkazan.enums.DBCommand;
import ru.javaprojectkazan.exceptions.DataSourceServiceException;
import ru.javaprojectkazan.services.DataSourceService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class RepairDAO implements DAO<Repair> {

    private DataSourceService dataSourceService = new DataSourceService();

    @Override
    public void insert(Repair repair) {

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.
                INSERT_INTO_REPAIRS_REPAIR_VALUES.getCommand())) {
            //preparedStatement.setInt(1, repair.getClaimNumber());
            preparedStatement.setString(1, repair.getVehicle().getVin());
            preparedStatement.setInt(2, repair.getVehicleMileage());
            preparedStatement.setDate(3, repair.getDateOfRepair());
            preparedStatement.setInt(4, repair.getCausalPart().getCatalogueNumber());
            preparedStatement.setString(5, repair.getCausalPart().getPartName());
            preparedStatement.setInt(6, repair.getPartQuantity());
            preparedStatement.setDouble(7, repair.getPartsTotalCost());
            preparedStatement.setInt(8, repair.getRepairOperation().getCode());
            preparedStatement.setString(9, repair.getRepairOperation().getName());
            preparedStatement.setDouble(10, repair.getRepairTime());
            preparedStatement.setDouble(11, repair.getRepairOperationsTotalCost());
            preparedStatement.setDouble(12, repair.getTotalRepairCost());
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
    public void update(Repair repair) {

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.UPDATE_VEHICLE_MILEAGE.getCommand())) {
            preparedStatement.setInt(1, repair.getVehicleMileage());
            preparedStatement.setString(2, repair.getVehicle().getVin());
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Сбой при подключении к БД при попытке обновлении пробега", e);
        } catch (SQLException e) {
            log.error("Ощибка при подключении к БД при попытке обновления пробега автомобиля", e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public List<Repair> getAll() {
        return null;
    }
}
