package gov.nasa.robot.test.util;

import java.lang.reflect.Field;

public class TestUtil {

    public static void setPrivateField(Class<? extends Object> instanceFieldClass, Object instance, String fieldName, Object fieldValue) throws Exception {
        Field setId = instanceFieldClass.getDeclaredField(fieldName);
        setId.setAccessible(true);
        setId.set(instance, fieldValue);
    }
}
