package yu.trans.service;


import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yu.trans.dao.AccountInfoDao;
import yu.trans.dao.ProductInfoDao;

import java.math.BigDecimal;


@Component
public class PayServiceImpl implements PayService {

	@Autowired
	private AccountInfoDao accountInfoDao;

	@Autowired
	private ProductInfoDao productInfoDao;

	@Transactional
	public void pay(String accountId, double money) {
		//查询余额
		double blance = accountInfoDao.qryBlanceByUserId(accountId);

		//余额不足正常逻辑
		if (new BigDecimal(blance).compareTo(new BigDecimal(money)) < 0) {
			throw new RuntimeException("余额不足");
		}

		//更新余额
		accountInfoDao.updateAccountBlance(accountId, money);

		try {
			((PayService) AopContext.currentProxy()).updateProductStoreWithError(1);
		} catch (IllegalStateException e) {

		}

	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void updateProductStore(Integer productId) {
		productInfoDao.updateProductInfo(productId);
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void updateProductStoreWithError(Integer productId) {
		((PayService) AopContext.currentProxy()).updateProductStore(1);
		try {
			productInfoDao.updateProductInfo(productId);

			System.out.println(1 / 0);
		} catch (Exception e) {
			throw new RuntimeException("内部异常", e);
		}
	}

	@Override
	public void query(String accountId) {
		System.out.println("账户余额: " + accountInfoDao.qryBlanceByUserId(accountId));
		System.out.println("产品数量: " + productInfoDao.qryStore(1));
	}

}
