package pl.mgorecki.storageapp.db;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.mgorecki.storageapp.domain.User;

@Repository
@RepositoryRestResource(collectionResourceRel = "userdata", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

   User findByEmail(@Param("email")String email);

}
