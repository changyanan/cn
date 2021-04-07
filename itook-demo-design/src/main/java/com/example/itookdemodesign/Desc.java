package com.example.itookdemodesign;

import java.lang.annotation.*;

/**
 * @author changyanan1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Desc {
    /**
     * 描述
     *
     * @return 描述信息
     */
    String value() default "";
}
