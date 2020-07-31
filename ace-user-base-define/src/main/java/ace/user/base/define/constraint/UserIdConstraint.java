package ace.user.base.define.constraint;

import org.hibernate.validator.constraints.Length;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/7/26 13:27
 * @description
 */
@NotBlank(message = "请输入" + UserIdConstraint.FIELD_NAME)
@Length(min = 1, max = 36, message = "请输入正确的" + UserIdConstraint.FIELD_NAME)
@Documented
@Constraint(validatedBy = {})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface UserIdConstraint {
    String FIELD_NAME = "用户ID";

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
