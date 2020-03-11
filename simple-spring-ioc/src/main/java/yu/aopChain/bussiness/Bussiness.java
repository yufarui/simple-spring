package yu.aopChain.bussiness;

import org.springframework.stereotype.Component;

@Component
public class Bussiness implements IBussiness{

	public void verfiy() {
		System.out.println("Bussiness verfiy");
	}
}
