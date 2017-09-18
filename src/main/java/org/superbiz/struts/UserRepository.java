package org.superbiz.struts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 103209 on 18/09/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}