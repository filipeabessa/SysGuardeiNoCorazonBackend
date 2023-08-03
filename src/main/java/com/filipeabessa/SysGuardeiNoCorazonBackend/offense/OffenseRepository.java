package com.filipeabessa.SysGuardeiNoCorazonBackend.offense;

import com.filipeabessa.SysGuardeiNoCorazonBackend.common.GenericRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.filipeabessa.SysGuardeiNoCorazonBackend.common.ConnectionManager.getCurrentConnection;

@Repository
public class OffenseRepository implements GenericRepository<OffenseEntity> {

    public OffenseRepository() {
        String sql = "CREATE TABLE IF NOT EXISTS offenses (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "disaffection_id BIGINT NOT NULL," +
                "title VARCHAR(50) NOT NULL," +
                "description VARCHAR(255) NOT NULL," +
                "cursed_family_member VARCHAR(20) NOT NULL," +
                "offending_person VARCHAR(255) NOT NULL," +
                "FOREIGN KEY (disaffection_id) REFERENCES disaffections(id)" +
                ");";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public OffenseEntity create(OffenseEntity offenseEntity) {
        String sql = "INSERT INTO offenses (disaffection_id, title, description, cursed_family_member, offending_person) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, offenseEntity.getDisaffectionId());
            preparedStatement.setString(2, offenseEntity.getTitle());
            preparedStatement.setString(3, offenseEntity.getDescription());
            preparedStatement.setString(4, offenseEntity.getCursedFamilyMember());
            preparedStatement.setString(5, offenseEntity.getOffendingPerson());
            preparedStatement.execute();
            return offenseEntity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public OffenseEntity update(OffenseEntity offenseEntity) {
        String sql = "UPDATE offenses SET disaffection_id = ?, title = ?, description = ?, cursed_family_member = ?, offending_person = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, offenseEntity.getDisaffectionId());
            preparedStatement.setString(2, offenseEntity.getTitle());
            preparedStatement.setString(3, offenseEntity.getDescription());
            preparedStatement.setString(4, offenseEntity.getCursedFamilyMember());
            preparedStatement.setString(5, offenseEntity.getOffendingPerson());
            preparedStatement.setLong(6, offenseEntity.getId());
            preparedStatement.execute();
            return offenseEntity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        findById(id).ifPresentOrElse(
                offenseEntity -> {
                    String sql = "DELETE FROM offenses WHERE id = ?";
                    try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
                        preparedStatement.setLong(1, id);
                        preparedStatement.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                },
                () -> {
                    throw new RuntimeException("Offense not found");
                }
        );

    }

    @Override
    public Optional<OffenseEntity> findById(long id) throws RuntimeException {
        String sql = "SELECT * FROM offenses WHERE id = ?";
        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapResultSetToOffenseEntity(resultSet));
            } else {
                throw new RuntimeException("Offense not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(long id) {
        String sql = "SELECT * FROM offenses WHERE id = ?";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement((sql))) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<OffenseEntity> findAll() {
        String sql = "SELECT * FROM offenses";

        try (PreparedStatement preparedStatement = getCurrentConnection().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<OffenseEntity> offenses = new ArrayList<>();
            while (resultSet.next()) {
                offenses.add(mapResultSetToOffenseEntity(resultSet));
            }
            return offenses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private OffenseEntity mapResultSetToOffenseEntity(ResultSet resultSet) throws SQLException {
        OffenseEntity offenseEntity = new OffenseEntity();
        offenseEntity.setId(resultSet.getLong("id"));
        offenseEntity.setDisaffectionId(resultSet.getLong("disaffection_id"));
        offenseEntity.setTitle(resultSet.getString("title"));
        offenseEntity.setDescription(resultSet.getString("description"));
        offenseEntity.setCursedFamilyMember(resultSet.getString("cursed_family_member"));
        offenseEntity.setOffendingPerson(resultSet.getString("offending_person"));
        return offenseEntity;
    }
}
