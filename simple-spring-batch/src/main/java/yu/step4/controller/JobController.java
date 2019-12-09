package yu.step4.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private BeanFactory beanFactory;

    @GetMapping("test/{jobName}")
    public String runJob1(@PathVariable("jobName") String jobName) throws Exception {
        Job job = beanFactory.getBean(jobName, Job.class);
        if (job == null) {
            return "job not exists";
        }

        // 观察数据库 batch_job_execution_params
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("info", "yutest")
                // 同一个jobinstance,是由 job + jobParameters构成
                // job和jobParameters相同 意味着同一个jobinstance
                // 观察数据库batch_job_instance
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
        return "Job success.";
    }
}
