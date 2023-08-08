package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection;

import com.filipeabessa.SysGuardeiNoCorazonBackend.common.GenericRepository;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.OffenseEntity;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.OffenseRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.filipeabessa.SysGuardeiNoCorazonBackend.common.ConnectionManager.getCurrentConnection;

@Repository
public class DisaffectionRepository implements GenericRepository<DisaffectionEntity> {

    OffenseRepository offenseRepository;

    public DisaffectionRepository() {
        offenseRepository = new OffenseRepository();

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
        String sql = "UPDATE disaffections SET name = ?, description = ?, created_at = ?, updated_at = ?, witnesses = ?, involved_people = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setTimestamp(3, entity.getCreatedAt());
            preparedStatement.setTimestamp(4, entity.getUpdatedAt());
            preparedStatement.setString(5, entity.getWitnesses());
            preparedStatement.setString(6, entity.getInvolvedPeople());
            preparedStatement.setLong(7, entity.getId());
            preparedStatement.execute();
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        findById(id).ifPresentOrElse(entity -> {
            String sql = "DELETE FROM disaffections WHERE id = ?";

            try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, () -> {
            throw new RuntimeException("Disaffection not found");
        });
    }

    @Override
    public List<DisaffectionEntity> findAll() {
        String sql = "SELECT * FROM disaffections";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DisaffectionEntity> disaffectionEntities = new ArrayList<>();
            while (resultSet.next()) {
                disaffectionEntities.add(mapResultSetToEntity(resultSet));
            }
            return disaffectionEntities;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<DisaffectionEntity> findById(long id) {
        String sql = "SELECT * FROM disaffections WHERE id = ?";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                List<OffenseEntity> offenses = offenseRepository.findAllByDisaffectionId(id);
                DisaffectionEntity disaffection = mapResultSetToEntity(resultSet);
                disaffection.setOffenses(offenses);
                return Optional.of(disaffection);
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean existsById(long id) {
        String sql = "SELECT * FROM disaffections WHERE id = ?";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DisaffectionEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        DisaffectionEntity entity = new DisaffectionEntity();

        entity.setId(resultSet.getLong("id"));
        entity.setTitle(resultSet.getString("name"));
        entity.setDescription(resultSet.getString("description"));
        entity.setCreatedAt(resultSet.getTimestamp("created_at"));
        entity.setUpdatedAt(resultSet.getTimestamp("updated_at"));
        entity.setWitnesses(resultSet.getString("witnesses"));
        entity.setInvolvedPeople(resultSet.getString("involved_people"));
        return entity;
    }
}
