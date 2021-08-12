package com.lucas.transaction.adapter.repository.operationType;

import com.lucas.transaction.domain.ports.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcOperationTypeRepository implements OperationTypeRepository {
    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcOperationTypeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public boolean hasOperationType(int operationTypeId) throws Exception {
        var result =  jdbc.queryForObject(
                "select count(*) from operation_types where Operation_Type_ID = ?",
                Integer.class,
                operationTypeId
        );

        return result != null && result != 0;
    }
}
