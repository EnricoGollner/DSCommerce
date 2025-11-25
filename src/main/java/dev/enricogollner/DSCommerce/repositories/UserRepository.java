package dev.enricogollner.DSCommerce.repositories;

import dev.enricogollner.DSCommerce.entities.User;
import dev.enricogollner.DSCommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = """
            SELECT tu.email AS username, tu.password, tr.id AS roleId, tr.authority
            FROM tb_user tu
            INNER JOIN tb_user_role tur ON tu.id = tur.role_id
            INNER JOIN tr ON tr.id = tur.role.id
            WHERE tu.email = :email
            """)
    List<UserDetailsProjection> searchUserAndRolesByEmail(String email);

    Optional<User> findByEmail(String email);
}
