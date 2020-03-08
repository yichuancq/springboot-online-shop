package member.service.account;

import member.domain.member.account.Account;

/**
 * 账户管理
 */
public interface AccountService {
    /**
     * 获取账户
     *
     * @return
     */
    Account getAccount();

    /**
     * 修改账户信息
     *
     * @param account
     * @return
     */
    Account modAccount(Account account);

}
