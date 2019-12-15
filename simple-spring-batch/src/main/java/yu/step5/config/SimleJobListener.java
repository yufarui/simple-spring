package yu.step5.config;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class SimleJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("start my job");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("end my job");
    }
}
