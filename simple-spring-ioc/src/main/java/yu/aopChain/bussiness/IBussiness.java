package yu.aopChain.bussiness;

import yu.aopChain.verfiyAnnotation.VerfiyRule1;
import yu.aopChain.verfiyAnnotation.VerfiyRule2;
import yu.aopChain.verfiyAnnotation.VerfiyRule3;

public interface IBussiness {

	@VerfiyRule1
	@VerfiyRule2
	@VerfiyRule3
	void verfiy();
}
