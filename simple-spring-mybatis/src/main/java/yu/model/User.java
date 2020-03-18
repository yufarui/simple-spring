package yu.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class User implements Serializable {
	private Integer id;
	private String name;
	private Integer age;
	private Date createTime;
}
