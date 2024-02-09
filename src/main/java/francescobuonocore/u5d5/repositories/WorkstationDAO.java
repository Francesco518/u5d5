package francescobuonocore.u5d5.repositories;

import francescobuonocore.u5d5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationDAO extends JpaRepository<Workstation, Long> {

}
