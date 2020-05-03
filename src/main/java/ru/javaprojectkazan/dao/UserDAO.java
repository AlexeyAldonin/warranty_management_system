package ru.javaprojectkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.javaprojectkazan.beans.User;
import ru.javaprojectkazan.enums.DBCommand;
import ru.javaprojectkazan.exceptions.DataSourceServiceException;
import ru.javaprojectkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class UserDAO  implements DAO{

    private DataSourceService dataSourceService= new DataSourceService();

    @Override
    public void insert(Object o) {
    }

    @Override
    public Object get(String firstParam) throws Exception {
        return null;
    }

    public User get(String login, String password) {

        try (PreparedStatement preparedStatement =dataSourceService.getPreparedStatement(DBCommand.SELECT_USER_BY_LOGIN_AND_PSSWD.getCommand())) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String dealer = resultSet.getString("dealer_code");
                String role = resultSet.getString("user_role");

                return new User(name, surname, dealer, role);
            } else {
                throw new DataSourceServiceException("Пользователь с указанными параметрами отсутствует");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных о пользователе с логином " + login, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + DBCommand.SELECT_USER_BY_LOGIN_AND_PSSWD, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public Object get(int firstParam) throws Exception {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public List getAll() {
        return null;
    }
}
