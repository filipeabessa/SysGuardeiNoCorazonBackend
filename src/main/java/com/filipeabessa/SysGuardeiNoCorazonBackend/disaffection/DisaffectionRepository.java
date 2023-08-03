package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection;

import com.filipeabessa.SysGuardeiNoCorazonBackend.common.GenericRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.filipeabessa.SysGuardeiNoCorazonBackend.common.ConnectionManager.getCurrentConnection;

public class DisaffectionRepository implements GenericRepository<DisaffectionEntity> {

    public DisaffectionRepository() {
//        String sql = "CREATE TABLE IF NOT EXISTS disaffections (" +
//                "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
//                "name VARCHAR(255) NOT NULL," +
//                "description VARCHAR(255) NOT NULL," +
//                "created_at DATETIME DEFAULT CURRENT_TIMESTAMP," +
//                "updated_at DATETIME DEFAULT CURRENT_TIMESTAMP" +
//                ");";
//        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    @Override
    public DisaffectionEntity create(DisaffectionEntity entity) throws SQLException {
        return null;
    }

    @Override
    public DisaffectionEntity update(DisaffectionEntity entity) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<DisaffectionEntity> findAll() {
        return null;
    }

    @Override
    public Optional<DisaffectionEntity> findById(long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(long id) {
        return false;
    }
}
