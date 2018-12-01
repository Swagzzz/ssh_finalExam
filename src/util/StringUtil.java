package util;

import net.sf.json.JSONArray;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class StringUtil {
    public static boolean isNotEmpty(String str) {
        if (null == str || "".equals(str)) {
            return false;
        } else return true;
    }

    /**
     * 返回的类型是字符串数组，该方法的用途是利用反射将对象的所有属性名取出来
     * @param o
     * @return
     */
    public String[] getFieldNames (Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String [] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i ++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 利用反射返回对应的属性名的值
     * @param name
     * @return
     */
    public Object getFieldValueByName (String name, Object o) {
        Object value = null;
        String firstLetter = name.substring(0, 1).toUpperCase(); //首字母
        String getter = "get".concat(firstLetter.toUpperCase()).concat(name.substring(1)); //getter方法的名字 比如说getName
        try {
            Method method = o.getClass().getMethod(getter, new Class[] {});
            value = method.invoke(o, new Object());
        }catch (Exception e) {
            e.printStackTrace();
            value = null;
        }
        return value;
    }

}
