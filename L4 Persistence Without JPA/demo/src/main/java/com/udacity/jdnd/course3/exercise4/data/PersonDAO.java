package com.udacity.jdnd.course3.exercise4.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SELECT_PERSON_BY_ID = "SELECT * FROM person WHERE id = :id";
    private static final String INSERT_PERSON = "INSERT INTO person (name, age, favorite_composer) VALUES(:name, :age, :favoriteComposer)";

    //<editor-fold desc="Implementation Methods">
    public PersonData getPersonById(Long id){
        return jdbcTemplate.queryForObject(
                SELECT_PERSON_BY_ID,
                new MapSqlParameterSource().addValue("id", id),
                new BeanPropertyRowMapper<>(PersonData.class));
    }

    public Long addPerson(PersonData personData) {
        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(
                INSERT_PERSON,
                new BeanPropertySqlParameterSource(personData),
                key);
        return key.getKey().longValue();
    }

    //does the same as the above addPerson method
    public Long addPersonInsert(PersonData personData) {
        SimpleJdbcInsert sji = new SimpleJdbcInsert(jdbcTemplate.getJdbcTemplate())
                .withTableName("person")
                .usingGeneratedKeyColumns("id");
        return sji.executeAndReturnKey(new BeanPropertySqlParameterSource(personData)).longValue();
    }
    //</editor-fold>

    //<editor-fold desc="Person With One Outfit">

    private static final String SELECT_PERSON_WITH_ONE_OUTFIT =
            "SELECT * FROM person p " +
                    "JOIN outfit o " +
                    "ON p.id = o.person_id " +
                    "WHERE p.id = :personId AND o.id = :outfitId";


    private static final BeanPropertyRowMapper<PersonWithOneOutfit> personWithOneOutfitRowMapper = new BeanPropertyRowMapper<>(PersonWithOneOutfit.class);
    private static final BeanPropertyRowMapper<OutfitData> outfitRowMapper = new BeanPropertyRowMapper<>(OutfitData.class);

    public PersonWithOneOutfit addOutfitForPerson(Long personId, OutfitData outfitData) {
        outfitData.setPersonId(personId);
        Long outfitId = addOutfit(personId, outfitData);

        return jdbcTemplate.queryForObject(SELECT_PERSON_WITH_ONE_OUTFIT,
                new MapSqlParameterSource()
                        .addValue("personId", personId)
                        .addValue("outfitId", outfitId),
                //anonymous row mapper lambda
                (resultSet, i) -> {
                    PersonWithOneOutfit person = personWithOneOutfitRowMapper.mapRow(resultSet, i);
                    person.setOutfit(outfitRowMapper.mapRow(resultSet, i));
                    return person;
                });
    }

    public Long addOutfit(Long personId, OutfitData outfitData) {
        SimpleJdbcInsert sji = new SimpleJdbcInsert(jdbcTemplate.getJdbcTemplate())
                .withTableName("outfit")
                .usingGeneratedKeyColumns("id");
        return sji.executeAndReturnKey(new BeanPropertySqlParameterSource(outfitData)).longValue();
    }
    //</editor-fold>

    //<editor-fold desc="OneToMany">

    private static final String SELECT_OUTFIT_BY_PERSON_ID = "SELECT * FROM outfit o WHERE o.person_id = :personId";

    public List<OutfitData> getOutfitsByPerson(Long personId){
        return jdbcTemplate.query(SELECT_OUTFIT_BY_PERSON_ID,
                new MapSqlParameterSource().addValue("personId", personId),
                new BeanPropertyRowMapper<>(OutfitData.class));
    }

    //the manual approach
    public PersonWithAllOutfits addOutfitForPersonReturnAll(Long personId, OutfitData outfitData) {
        //add the outfit to db
        outfitData.setPersonId(personId);
        addOutfit(personId, outfitData);

        //get the person object and outfits list
        PersonData pd = getPersonById(personId);
        List<OutfitData> outfits = getOutfitsByPerson(personId);

        //copy the data into a new wrapper object
        PersonWithAllOutfits person = new PersonWithAllOutfits();
        person.setAge(pd.getAge());
        person.setFavoriteComposer(pd.getFavoriteComposer());
        person.setName(pd.getName());
        person.setOutfits(outfits);
        return person;
    }
    //</editor-fold>

    //<editor-fold desc="OneToMany2">
    //the fancy approach
    private static final String SELECT_PERSON_WITH_ALL_OUTFITS =
            "SELECT * FROM person p " +
            "JOIN outfit o " +
            "ON p.id = o.person_id " +
            "WHERE p.id = :personId";

    private static final BeanPropertyRowMapper<PersonWithAllOutfits> personWithAllOutfitsRowMapper = new BeanPropertyRowMapper<>(PersonWithAllOutfits.class);
    public PersonWithAllOutfits addOutFitForPersonReturnAllFancy(Long personId, OutfitData outfitData) {
        //add the outfit to db
        outfitData.setPersonId(personId);
        addOutfit(personId, outfitData);

        //iterate over the result set to construct the outfit list
        return jdbcTemplate.query(
                SELECT_PERSON_WITH_ALL_OUTFITS,
                new MapSqlParameterSource().addValue("personId", personId),
                //anonymous ResultSetExtractor lambda
                resultSet -> {
                    PersonWithAllOutfits person = null;
                    List<OutfitData> outfits = new ArrayList<>();
                    int row = 0;
                    while(resultSet.next()) {
                        if(person == null){
                            person = personWithAllOutfitsRowMapper.mapRow(resultSet, row);
                        }
                        outfits.add(outfitRowMapper.mapRow(resultSet, row++));
                    }
                    if(person != null) {
                        person.setOutfits(outfits);
                    }
                    return person;
                });
    }
    //</editor-fold>

}
