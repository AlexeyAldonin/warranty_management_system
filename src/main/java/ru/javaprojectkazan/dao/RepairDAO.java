package ru.javaprojectkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.Part;
import ru.javaprojectkazan.beans.Repair;
import ru.javaprojectkazan.beans.RepairOperation;
import ru.javaprojectkazan.beans.Vehicle;
import ru.javaprojectkazan.enums.DBCommand;
import ru.javaprojectkazan.exceptions.DataSourceServiceException;
import ru.javaprojectkazan.services.DataSourceService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RepairDAO implements DAO<Repair> {

    private DataSourceService dataSourceService = new DataSourceService();

    @Override
    public void insert(Repair repair) {

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.
                INSERT_INTO_REPAIRS_REPAIR_VALUES.getCommand())) {
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
    public Repair get(String vin) {
        return null;
    }

    @Override
    public Repair get(int claimNumber) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(
                DBCommand.SELECT_REPAIR_BY_NUMBER.getCommand())) {

            Repair repair = null;
            preparedStatement.setInt(1, claimNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Date repairDate = resultSet.getDate("repair_date");
                    String vin = resultSet.getString("vehicle_vin");
                    int mileage = resultSet.getInt("vehicle_mileage");
                    int partNumber = resultSet.getInt("part_number");
                    String partName = resultSet.getString("part_name");
                    int partQuantity = resultSet.getInt("part_quantity");
                    double partsCost = resultSet.getDouble("parts_cost");
                    int repairOperationId = resultSet.getInt("repair_operation_id");
                    String repairOperationName = resultSet.getString("repair_operation_name");
                    double repairHours = resultSet.getDouble("repair_hours");
                    double repairOperationsCost = resultSet.getDouble("repair_operations_cost");
                    double repairTotalCost = resultSet.getDouble("repair_total_cost");

                    Vehicle vehicle = new VehicleDAO().get(vin);

                    Part part = new Part(partName, partNumber, partsCost / partQuantity);

                    RepairOperation repairOperation = new RepairOperation(
                            repairOperationId, repairOperationName, (int) (repairOperationsCost / repairHours));

                    repair = new Repair(claimNumber, repairDate, vehicle, mileage, part, partQuantity, partsCost,
                            repairOperation, repairHours, repairOperationsCost, repairTotalCost);
                }
            }
            return repair;
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при подключении к БД при запросе списка ремонтов", e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса на получение списка ремонтов", e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
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

    public List<Repair> getAll(String vin) {

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(
                DBCommand.SELECT_REPAIR_BY_VIN.getCommand())) {

            VehicleDAO vehicleDAO = new VehicleDAO();
            Vehicle vehicle = vehicleDAO.get(vin);

            List<Repair> repairs = new ArrayList<>();
            preparedStatement.setString(1, vin);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int claimNumber = resultSet.getInt("claim_number");
                    Date repairDate = resultSet.getDate("repair_date");
                    int mileage = resultSet.getInt("vehicle_mileage");
                    int partNumber = resultSet.getInt("part_number");
                    String partName = resultSet.getString("part_name");
                    int partQuantity = resultSet.getInt("part_quantity");
                    double partsCost = resultSet.getDouble("parts_cost");
                    int repairOperationId = resultSet.getInt("repair_operation_id");
                    String repairOperationName = resultSet.getString("repair_operation_name");
                    double repairHours = resultSet.getDouble("repair_hours");
                    double repairOperationsCost = resultSet.getDouble("repair_operations_cost");
                    double repairTotalCost = resultSet.getDouble("repair_total_cost");

                    Part part = new Part(partName, partNumber, partsCost / partQuantity);

                    RepairOperation repairOperation = new RepairOperation(
                            repairOperationId, repairOperationName, (int) (repairOperationsCost / repairHours));

                    Repair repair = new Repair(claimNumber, repairDate, vehicle, mileage, part, partQuantity, partsCost,
                            repairOperation, repairHours, repairOperationsCost, repairTotalCost);

                    repairs.add(repair);
                }
            }
            return repairs;
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при подключении к БД при запросе списка ремонтов", e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса на получение списка ремонтов", e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
