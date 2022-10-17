package com.udacity.jdnd.course3.exercise1.data;

import com.udacity.jdnd.course3.exercise1.entities.Humanoid;
import com.udacity.jdnd.course3.exercise1.entities.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HumanoidRepository extends JpaRepository<Humanoid, Long> {
    List<Humanoid> findAllByOutfitsHat(String hat);

    //<editor-fold desc="Example2">
    @Query("select h from Humanoid h where :outfit member of h.outfits ")
    List<Humanoid> findAllByOutfit(@Param("outfit") Outfit outfit);

    //does the same as above
    List<Humanoid> findAllByOutfitsContaining(Outfit outfit);

    //automatically uses query named Humanoid.findAllNamedQuery
    List<Humanoid> findAllNamedQuery(Outfit outfit);
    //</editor-fold>

}
