package yu.step4.config;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class MyDecider implements JobExecutionDecider {

    private int count = 0;

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        count++;
        System.out.println("{当前count}" + count);
        if(count % 2 == 0) {
            return new FlowExecutionStatus("EVEN");
        }
        return new FlowExecutionStatus("ODD");
    }
}
