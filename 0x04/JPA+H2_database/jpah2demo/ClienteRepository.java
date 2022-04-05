import org.springframework.stereotype.Repository;

import com.example.jpah2demo.data.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
