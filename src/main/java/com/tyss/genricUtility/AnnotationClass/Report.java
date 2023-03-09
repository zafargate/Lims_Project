package com.tyss.genricUtility.AnnotationClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * This Annotation is used assign(),author(),catagry() with default regrassion
 * @author kishore
 * mallarapu
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
	public String[] assign();
	public String author();
	public String[] catagry() default {"regrassion"};

}
