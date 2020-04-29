package ru.javaprojectkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.Part;
import ru.javaprojectkazan.beans.Vehicle;
import ru.javaprojectkazan.enums.DBCommand;
import ru.javaprojectkazan.enums.VehicleParameter;
import ru.javaprojectkazan.exceptions.DataSourceServiceException;
import ru.javaprojectkazan.exceptions.PropertyReaderException;
import ru.javaprojectkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Slf4j
public class VehicleDAO implements DAO<Vehicle>{

    private DataSourceService dataSourceService = new DataSourceService();

    @Override
    public void insert(Vehicle vehicle) {

    }

    @Override
    public Vehicle get(String vin) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.
                SELECT_VEHICLE_BY_VIN.getCommand())) {
            preparedStatement.setString(1, vin);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String model = resultSet.getString(VehicleParameter.MODEL.getName());
                Date dispatchDate = resultSet.getDate(VehicleParameter.DISPATCH_DATE.getName());
                Date soldDate = resultSet.getDate(VehicleParameter.DATE_OF_SALE.getName());
                Date warrantyExpireDate = resultSet.getDate(VehicleParameter.WARRANTY_EXPIRE_DATE.getName());
                int mileageAtLastClaim = resultSet.getInt(VehicleParameter.MILEAGE_AT_LAST_CLAIM.getName());
                return new Vehicle(vin, model, dispatchDate, soldDate, warrantyExpireDate, mileageAtLastClaim);
            } else {
                throw new DataSourceServiceException("Автомобиль с номером " + vin + " отсутсвует.");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных об автомобиле с номером " + vin, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + DBCommand.SELECT_VEHICLE_BY_VIN, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public Vehicle get(int firstParam) throws Exception {
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        return null;
    }
}
