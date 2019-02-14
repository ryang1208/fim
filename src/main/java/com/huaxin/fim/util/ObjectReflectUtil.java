package com.huaxin.fim.util;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//反射工具类
public class ObjectReflectUtil {
	
	public static JexlEngine jexl = new JexlBuilder().create();
	public static JexlContext jctxt = new MapContext();
	
	class condExpress {
		public String prefix;
		public String compare;
		public String suffix;
		public condExpress(String prefix, String compare, String suffix) {
			super();
			this.prefix = prefix;
			this.compare = compare;
			this.suffix = suffix;
		}
    }
	
	/** 
	 * 根据属性名获取属性值 
	 * */
	public static Object getFieldValueByName(Object model,String fieldName) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
		    String getter = "get" + firstLetter + fieldName.substring(1);
		    Method method = model.getClass().getMethod(getter, new Class[] {});
		    Object value = method.invoke(model, new Object[] {});
		    return value;
		} catch (Exception e) {
		    return null;
		}
	}
	
	//获取表达式
	public static String getExpressStr(Object model, String express)
	{
		String value = "";
		try {
			Field[] field = model.getClass().getDeclaredFields();//获取实体类的所有属性，返回Field数组
		    for(int j=0 ; j<field.length ; j++){//遍历所有属性
		    	String fieldname = field[j].getName();//获取属性的名
		    	if(express.indexOf("{"+fieldname+"}")==-1)continue;
		    	Object oval = getFieldValueByName(model,fieldname);
		    	if(oval!=null) express = express.replaceAll("\\$F\\{"+fieldname+"\\}", oval.toString());
		    	value = express;
		    }
		    return value;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	//解析表达式的值
	public static String getExpressValue(String express)
	{
		String val="";
		try {
			JexlExpression e = jexl.createExpression(express);
		    Object obj = e.evaluate(jctxt);
		    if(obj!=null) val = obj.toString();
		} catch (Exception e) {
		}
	    return val;
	}
	
	//计算表达式的值
	public static String calExpressValue(Object model, String express)
	{
		String value = getExpressValue(getExpressStr(model,express));
		return value;
	}
	
	public static BigDecimal formatdouble(String val)
	{
		if("".equals(val)) return BigDecimal.ZERO;
		else return new BigDecimal(val.trim()).setScale(4, BigDecimal.ROUND_HALF_UP);
	}
	
	public static double formatdouble4string(String val)
	{
		if(!"".equals(val)) return Double.parseDouble(val);
		else return 0;
	}
	
	//通用的根据指定字段的值过滤结果集
	public static List<Object> commListDataFilter(List<?> modelList,String fieldName,Hashtable<String, String> fieldvalueList) {
		List<Object> FilteredDataList=new ArrayList<Object>();
		try {
			 //遍历集合 
            for (Object object : modelList) {
                Class<? extends Object> clazz = object.getClass();// 获取集合中的对象类型 
                Field[] fds = clazz.getDeclaredFields();// 获取他的字段数组
                for (Field field : fds) {// 遍历该数组  
                    String fdname = field.getName();// 得到字段名，  
                    if("serialVersionUID".equals(fdname))continue;
                    String firstLetter = fdname.substring(0, 1).toUpperCase();
        		    String getter = "get" + firstLetter + fdname.substring(1);        		    
                    Method metd = clazz.getMethod(getter, null);// 根据字段名找到对应的get方法，null表示无参数 
                    if(fdname.equals(fieldName)){
                    	Object value = metd.invoke(object, null);// 调用该字段的get方法 
                    	if(fieldvalueList.containsKey(value.toString())){
                    		FilteredDataList.add(object);
                    		break;
                    	}
                    }
                }  
            }
		    return FilteredDataList;
		} catch (Exception e) {
		    return null;
		}
	}
	
    /**
     * 反射方法设置参数属性
     * @param paramName
     * @param o
     * @param paramValue
     */
    public static void setParam(String paramName, Object o, Object paramValue) {
        try {
            Method [] methods = o.getClass().getMethods();
            String firstLetter = paramName.substring(0, 1).toUpperCase();
            String methodName = "set" + firstLetter + paramName.substring(1);
            Class<?> type = null;
            
            for(Method m : methods){
                if(m.getName().equals(methodName)){
                    type = m.getParameters()[0].getType();
                }
            }
                
            Method m = o.getClass().getMethod(methodName, type);
            m.invoke(o, paramValue);
            
        } catch (NoSuchMethodException e) {
        } catch (Exception e) {
        }
    }
    
    public static  < S, D > D copyPropertys(S s, D d) {     // 不同对象相同属性进行复制，不同属性不操作
        if(s == null || d == null){
            return d;
        }
        Field[] sfields = s.getClass().getDeclaredFields();       // 获取源对象属性
        Field[] dfields = d.getClass().getDeclaredFields(); // 获取目标对象属性
        Class< ?> scls = s.getClass(); // 源对象类型
        Class< ?> dcls = d.getClass(); // 目标对象类型
        try {
            for (Field sfield : sfields) {
                String sName = sfield.getName(); // 源对象属性名称
                Class< ?> sType = sfield.getType(); // 源对象属性类型
                if(!sName.equals("serialVersionUID") && !sName.equals("id")){ // 源对象指定属性不复制
                	String sfieldName = sName.substring(0, 1).toUpperCase()
                        + sName.substring(1); // 构造源对象get方法
                Method sGetMethod = scls.getMethod("get" + sfieldName);
                Object value = sGetMethod.invoke(s); // 调用源对象get方法
                for (Field dfield : dfields) {
                    String dName = dfield.getName(); // 获取目标对象属性名称
                    Class< ?> dType = dfield.getType(); // 获取目标对象属性类型
                    // 源对象和目标对象属性方法名称和类型一致时，调用目标方法的set方法进行赋值
                    if (dName.equals(sName) && sType.toString().equals(dType.toString())) {
                        Method dSetMethod = dcls.getMethod("set" + sfieldName, sType);
                        dSetMethod.invoke(d, value);
                        break;
                    }
                }
            }
        }
    } catch (SecurityException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    }
    return d;
}
	
}
