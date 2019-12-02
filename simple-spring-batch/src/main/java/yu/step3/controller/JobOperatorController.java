package yu.step3.controller;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobOperatorController {

    @Autowired
    private JobOperator jobOperator;

    @GetMapping("job2/{job2param}")
    public String runJob2(@PathVariable("job2param") String job2param)
            throws JobParametersInvalidException, JobInstanceAlreadyExistsException, NoSuchJobException {
        System.out.println("Request to run job2 with param: " + job2param);

        jobOperator.start("jobOperatorJob", job2param);

        return "Job2 success.";
    }
}
