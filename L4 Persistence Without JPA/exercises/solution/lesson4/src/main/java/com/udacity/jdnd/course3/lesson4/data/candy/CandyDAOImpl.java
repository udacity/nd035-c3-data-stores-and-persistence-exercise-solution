package com.udacity.jdnd.course3.lesson4.data.candy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    //we can avoid some typo-based errors by using string constants
    private static final String CANDY_ID = "candyId";
    private static final String DELIVERY_ID = "deliveryId";

    private static final String SELECT_ALL_CANDY =
            "SELECT * FROM candy";

    private static final String INSERT_DELIVERY =
            "INSERT INTO candy_delivery (candy_id, delivery_id) " +
            "VALUES (:" + CANDY_ID + ", :" + DELIVERY_ID + ")";

    private static final String FIND_CANDY_BY_DELIVERY =
            "SELECT c.* FROM candy_delivery AS cd " +
            "JOIN candy AS c on c.id = cd.candy_id " +
            "WHERE cd.delivery_id = :" + DELIVERY_ID;

    private static final RowMapper<CandyData> candyDataRowMapper =
            new BeanPropertyRowMapper<>(CandyData.class);

    @Override
    public List<CandyData> list() {
        //no parameters, so we can use a version of .query that only takes two arguments
        return jdbcTemplate.query(SELECT_ALL_CANDY, candyDataRowMapper);
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryid) {
        //we don't have an object of the right type to use SimpleJdbcInsert, so we'll just do a normal .update
        jdbcTemplate.update(INSERT_DELIVERY,
                new MapSqlParameterSource()
                        .addValue(CANDY_ID, candyId)
                        .addValue(DELIVERY_ID, deliveryid));
    }

    @Override
    public List<CandyData> findByDelivery(Long deliveryId) {
        return jdbcTemplate.query(FIND_CANDY_BY_DELIVERY,
                new MapSqlParameterSource(DELIVERY_ID, deliveryId),
                candyDataRowMapper);
    }
}
