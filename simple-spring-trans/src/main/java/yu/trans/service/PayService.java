package yu.trans.service;

public interface PayService {

	void pay(String accountId, double money);

	void updateProductStore(Integer productId);

	void updateProductStoreWithError(Integer productId);

	void query(String accountId);
}
