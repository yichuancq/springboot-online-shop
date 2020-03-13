package member.repository.account;

import member.domain.member.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 账户
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
