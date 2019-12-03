package yu.step3.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobParametersController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job myJobParametersDemoJob;

    @GetMapping("job3/{info}")
    public String runJob3(@PathVariable("info") String job3param)
            throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        System.out.println("Request to run job3 with param: " + job3param);
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("info", job3param)
                .toJobParameters();
        jobLauncher.run(myJobParametersDemoJob, jobParameters);
        return "Job3 success.";
    }
}
