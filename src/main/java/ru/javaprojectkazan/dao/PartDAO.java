package ru.javaprojectkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.Part;
import ru.javaprojectkazan.enums.DBCommand;
import ru.javaprojectkazan.enums.PartParameter;
import ru.javaprojectkazan.exceptions.DataSourceServiceException;
import ru.javaprojectkazan.exceptions.PropertyReaderException;
import ru.javaprojectkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class PartDAO implements DAO<Part> {

    private DataSourceService dataSourceService = new DataSourceService();

    public PartDAO() throws PropertyReaderException {
    }

    @Override
    public void insert(Part part) {

    }

    @Override
    public Part get(String firstParam) throws Exception {
        return null;
    }

    @Override
    public List<Part> getAll() {

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.SELECT_ALL_PARTS.getCommand())) {
            List<Part> allParts = new LinkedList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int partNumber = Integer.parseInt(resultSet.getString(PartParameter.PART_NUMBER.getName()));
                String partName = resultSet.getString(PartParameter.PART_NAME.getName());
                double partPrice = Double.parseDouble(resultSet.getString(PartParameter.PART_PRICE.getName()));
                allParts.add(new Part(partName, partNumber, partPrice));
            }
            return allParts;
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении списка деталей", e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + DBCommand.SELECT_ALL_PARTS, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public Part get(int catalogueNumber) {

        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(DBCommand.SELECT_PART_BY_NUMBER.getCommand())) {
            preparedStatement.setInt(1, catalogueNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("part_name");
                double price = resultSet.getDouble("part_price");
                return new Part(name, catalogueNumber, price);
            } else {
                throw new DataSourceServiceException("Деталь с номером " + catalogueNumber + " отсутсвует.");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных о детали с номером " + catalogueNumber, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + DBCommand.SELECT_PART_BY_NUMBER, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }

    }
}
