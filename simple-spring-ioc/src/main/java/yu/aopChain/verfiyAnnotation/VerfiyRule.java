package yu.aopChain.verfiyAnnotation;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface VerfiyRule {
	int order() default 0;
}
