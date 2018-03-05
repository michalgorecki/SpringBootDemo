package pl.mgorecki.storageapp.db;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.mgorecki.storageapp.domain.Role;

@Repository
@RepositoryRestResource
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findByName(String name);
}
