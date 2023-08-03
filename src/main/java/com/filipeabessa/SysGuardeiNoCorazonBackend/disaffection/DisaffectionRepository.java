package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection;

import com.filipeabessa.SysGuardeiNoCorazonBackend.common.GenericRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.filipeabessa.SysGuardeiNoCorazonBackend.common.ConnectionManager.getCurrentConnection;

@Repository
public class DisaffectionRepository implements GenericRepository<DisaffectionEntity> {

    public DisaffectionRepository() {
        String sql = "CREATE TABLE IF NOT EXISTS disaffections (" +
                "id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "description VARCHAR(255) NOT NULL," +
                "created_at DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "updated_at DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "witnesses VARCHAR(255) NOT NULL," +
                "involved_people VARCHAR(255) NOT NULL" +
                ");";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public DisaffectionEntity create(DisaffectionEntity entity) throws SQLException {
        String sql = "INSERT INTO disaffections (name, description, created_at, updated_at, witnesses, involved_people) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setTimestamp(3, entity.getCreatedAt());
            preparedStatement.setTimestamp(4, entity.getUpdatedAt());
            preparedStatement.setString(5, entity.getWitnesses());
            preparedStatement.setString(6, entity.getInvolvedPeople());
            preparedStatement.execute();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
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
