package yu.compentScanTest.service;

import org.springframework.stereotype.Service;

@Service
public class NonUseService {
    public NonUseService() {
        System.out.println("加载 NonUseService");
    }
}
