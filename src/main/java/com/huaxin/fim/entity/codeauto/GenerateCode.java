package com.huaxin.fim.entity.codeauto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateCode {
	/*
	 * 清算平台项目
	 */
	private static final String project_name="iWin";// 项目名字
	
	private static ArrayList storage = new ArrayList();
	private static List fieldarr = null;
	private static Map classObj = null;
	private static String author = "";
	private static String currRootPath = "";

	private static String gclassname = "";
	private static String EntityProject = project_name+"Entity";
	private static String EntityFilepath = EntityProject + "/src/main/java/";
	private static String temlpatePath = EntityProject + "/src/main/java/com/quantdo/"+project_name+"/codeauto/";

	// api路径
	private static String apiProject = project_name+"Api";
	private static String apiPath = "com/quantdo/"+project_name+"/service";// 包路径
	private static String apiFilepath = apiProject + "/src/main/java/" + apiPath + "/";// 文件路径

	// Interface路径
	private static String InterfaceProject = project_name+"Service";// 项目
	private static String InterfacePath = "com/quantdo/"+project_name+"/service/impl";// 包路径
	private static String InterfaceFilepath = InterfaceProject + "/src/main/java/" + InterfacePath + "/";// 文件路径

	// 业务实现路径
	private static String RepositoryPath = "com/quantdo/"+project_name+"/repository";// 包路径
	private static String RepositoryFilepath = InterfaceProject + "/src/main/java/" + RepositoryPath + "/";// 文件路径
	
	// mapper路径
	private static String MapperPath = "com/quantdo/"+project_name+"/mapper";// 包路径
	private static String MapperFilepath = InterfaceProject + "/src/main/java/" + MapperPath + "/";// 文件路径

	// 页面路径
	// jsp根路径
	private static String pageFilePath = "Client/Web/pagesQuantdoFinally/pages/";
	private static String pageServiceFilePath = "Client/Web/service/";

	// java变量
	private static String pcondition = "";
	private static String vcondition = "";
	private static String jvcondition = "";
	private static String paracondition = "";
	private static String sqlcondition = "";
	private static String jspcondition = "";
	private static String srchcondition = "";
	private static String theadFields = "";
	private static String jTableFields = "";
	private static String tbodyFields = "";
	private static String bodyinputs = "";
	private static String setPristine = "";
	private static String fieldvalids = "";
	private static String setselects = "";
	private static String otherjss = "";
	private static String otherjsservices = "";
	private static String formtitle = "";
	private static String jTableCode = "";
	private static String entityKey = "";
	private static String headerKey = ""; 
	private static String styles = ""; 
	
	private static List apiImportList = null;// 接口import列表
	private static List relyObjClsList = null;// 依赖的实体类
	private static List apiList = null;// 接口列表
	private static Map<String,Object> paraMap = new HashMap<String,Object>();// 参数map
	private static List<String> fieldList = new ArrayList<String>();
	private static Set<String> fieldSet = new HashSet<String>();
	private static Map<String,Object> nameMap = new HashMap<String,Object>();

	public static String getFormtitle() {
		return formtitle;
	}

	public static void setFormtitle(String formtitle) {
		GenerateCode.formtitle = formtitle;
	}

	public static void getProjectPath() {
		currRootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		currRootPath = currRootPath.substring(1);
//		System.out.println(currRootPath);
		// 项目路径（每个人的路径不一样，需要修改成自己项目下的）
		currRootPath = "D:/iWin/";
		setDefaultParams();
	}

	// 首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	// 首字母转大写
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	private static String getFieldTypeString(String type) {
		if ("".equalsIgnoreCase(type))
			return "String";
		else if (type.indexOf("double") != -1)
			return "double";
		else if (type.indexOf("int") != -1)
			return "int";
		else if (type.indexOf("Long") != -1)
			return "Long";
		else if (type.indexOf("BigDecimal") != -1)
			return "BigDecimal";
		else
			return "String";
	}

	// 解析文件
	@SuppressWarnings("unchecked")
	public static void readJavaClassFile(String filepath) {
		File file = new File(filepath);
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read = null;
			try {
				read = new InputStreamReader(new FileInputStream(file), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} // 考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			try {
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (lineTxt.indexOf("public") == -1 && lineTxt.indexOf("this") == -1
							&& lineTxt.indexOf("return") == -1 && lineTxt.indexOf("{") == -1
							&& lineTxt.indexOf("}") == -1 && !"".equalsIgnoreCase(lineTxt.trim())) {
						storage.add(lineTxt.trim());
						if (lineTxt.indexOf("srchcolumns") != -1) {
							String srchcolumns = lineTxt.trim();
							srchcolumns = srchcolumns.replace("//", "").trim();
							srchcolumns = srchcolumns.replace("srchcolumns", "");
							srchcolumns = srchcolumns.replace(":", "");
							srchcolumns = srchcolumns.replace("：", "");
							classObj.put("srchcolumns", srchcolumns.trim());
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 获取实体类属性
	@SuppressWarnings("unchecked")
	public static void getClassAttributes(String classname) throws ClassNotFoundException {
		gclassname = classname;
		Map obj = null;
		Class forName = Class.forName(classname);
		classObj.put("flclsname", toLowerCaseFirstOne(forName.getSimpleName()));
		classObj.put("clsname", forName.getSimpleName());
		classObj.put("lclsname", forName.getSimpleName().toLowerCase());
		classObj.put("entity", classname);
		classObj.put("author", author);
		Field[] f = forName.getDeclaredFields();
		// 获取字段名
		for (int i = f.length - 1; i >= 0; i--) {
			obj = new HashMap();
			String fieldcode = f[i].getName();
			String fieldtype = getFieldTypeString(f[i].getType().getName());
			if (fieldcode.indexOf("serialVersionUID") != -1)
				continue;
			obj.put("fieldcode", fieldcode);
			obj.put("fieldtype", fieldtype);
			String isfind = "";
			for (int j = storage.size() - 1; j >= 0; j--) {
				String linetxt = (String) storage.get(j);
				if (linetxt.indexOf(";") != -1)
					linetxt = linetxt.substring(0, linetxt.indexOf(";"));
				linetxt = linetxt.trim();
				String[] lintxtarr = linetxt.split(" ");
				if (lintxtarr.length == 3) {
					if (fieldtype.equalsIgnoreCase(lintxtarr[1]) && fieldcode.equalsIgnoreCase(lintxtarr[2])) {
						isfind = "0";
						continue;
					}
				}
				if ("0".equalsIgnoreCase(isfind)) {
					// 非空
					if (linetxt.indexOf("@NotNull") != -1 || linetxt.indexOf("@NotBlank") != -1)
						obj.put("required", "y");

					// 长度
					if (linetxt.indexOf("@Length") != -1) {
						String maxlenstr = "";
						linetxt = linetxt.replaceAll(" ", "");
						int in = linetxt.indexOf("max=");
						if (in != -1)
							maxlenstr = linetxt.substring(in + 4);
						if (maxlenstr.indexOf(")") != -1)
							maxlenstr = maxlenstr.substring(0, maxlenstr.indexOf(")"));
						obj.put("fieldlen", maxlenstr);
					
					}
					// 备注格式//
					if (linetxt.indexOf("//") != -1 && linetxt.indexOf("select") == -1) {
						String fieldname = linetxt.substring(2);
						obj.put("fieldname", fieldname.trim());
					}
					// 备注格式
					/**
					 * 经纪公司代码
					 * 
					 * @author Administrator
					 */
					if (linetxt.indexOf("*") != -1 && linetxt.indexOf("@") == -1 && linetxt.indexOf("select") == -1) {
						linetxt = linetxt.replaceAll(" ", "");
						String fieldname = linetxt.substring(1);
						if (!"".equalsIgnoreCase(fieldname.trim()) && !"*".equalsIgnoreCase(fieldname.trim())
								&& !"**".equalsIgnoreCase(fieldname.trim()))
							obj.put("fieldname", fieldname.trim());
					}
					// select下拉
					if ((linetxt.indexOf("//") != -1 || linetxt.indexOf("*") != -1)
							&& linetxt.indexOf("select") != -1) {
						obj.put("isselect", "y");
						setselects = setselects + "    $scope." + fieldcode + " = clearConstant." + fieldcode + ";\r";
					}
					// 字段长度
					linetxt = linetxt.replaceAll(" ", "");
					if (linetxt.indexOf("@Column") != -1 && !obj.containsKey("fieldlen")) {
						String maxlenstr = "";
						int in = linetxt.indexOf("length=");
						if (in != -1)
							maxlenstr = linetxt.substring(in + 7);
						if (maxlenstr.indexOf(")") != -1)
							maxlenstr = maxlenstr.substring(0, maxlenstr.indexOf(")"));
						obj.put("fieldlen", maxlenstr);
					}
				}
				if (linetxt.indexOf("GeneratedValue") != -1 && "0".equalsIgnoreCase(isfind))
					obj.put("isgenkey", "y");
				if (linetxt.indexOf("private") != -1 && "0".equalsIgnoreCase(isfind))
					break;
			}
			if (!obj.containsKey("isgenkey"))
				fieldarr.add(obj);
		}
		classObj.put("fielddata", fieldarr);
	}

	// 获取java查询条件
	public static void getConditions() {
		String srch = "";
		if (classObj.containsKey("srchcolumns"))
			srch = classObj.get("srchcolumns").toString();
		String[] srcharr = srch.split(",");
		for (int i = 0; i < srcharr.length; i++) {
			String srchfield = srcharr[i];
			Map obj = null;
			for (int j = 0; j < fieldarr.size(); j++) {
				obj = new HashMap();
				obj = (Map) fieldarr.get(j);
				String fieldcode = obj.get("fieldcode").toString();
				String fieldname = "";
				if (obj.containsKey("fieldname"))
					fieldname = obj.get("fieldname").toString();
				if ("".equalsIgnoreCase(fieldname))
					fieldname = fieldcode;

				if (srchfield.equalsIgnoreCase(fieldcode)) {
					sqlcondition = sqlcondition + "(c." + fieldcode + " = :" + fieldcode + " or :" + fieldcode
							+ " is null) and ";
					paracondition = paracondition + "@Param(\"" + fieldcode + "\") " + obj.get("fieldtype").toString()
							+ " " + fieldcode + ",";
					pcondition = pcondition + obj.get("fieldtype").toString() + " " + fieldcode + ",";
					vcondition = vcondition + fieldcode + ",";
					jspcondition = jspcondition + "$scope.queryEntity." + fieldcode + ",";

					jvcondition = jvcondition + "PsUtil.convertToNull(" + fieldcode + "),";
					if (obj.containsKey("isselect")) {
						srchcondition = srchcondition + "            <div class=\"col-xs-3\">\r"
								+ "               <div class=\"form-group\">\r"
								+ "                  <label class=\"col-sm-5 control-label\">" + fieldname
								+ "</label>\r" + "                  <div class=\"col-sm-5\">\r"
								+ "                  <select ng-model=\"queryEntity." + fieldcode
								+ "\" class=\"select-style\">\r"
								+ "                      <option value=\"\">全部</option>\r"
								+ "                      <option ng-repeat=\"" + fieldcode.toLowerCase() + " in "
								+ fieldcode + "\" value=\"{{" + fieldcode.toLowerCase() + ".key}}\">{{"
								+ fieldcode.toLowerCase() + ".key}}_{{" + fieldcode.toLowerCase() + ".text}}</option>\r"
								+ "                  </select>\r" + "                  </div>\r"
								+ "               </div>\r" + "            </div>\r";
					} else {
						srchcondition = srchcondition + "            <div class=\"col-xs-3\">\r"
								+ "               <div class=\"form-group\">\r"
								+ "                  <label class=\"col-sm-5 control-label\">" + fieldname
								+ "</label>\r" + "                  <div class=\"col-sm-5\">\r"
								+ "                     <input type=\"text\" class=\"form-control\" ng-model=\"queryEntity."
								+ fieldcode + "\" name=\"" + fieldcode + "\"/>\r" + "                  </div>\r"
								+ "               </div>\r" + "            </div>\r";
					}
				}
			}
		}
		if (!"".equalsIgnoreCase(paracondition))
			paracondition = paracondition.substring(0, paracondition.length() - 1);
		if (!"".equalsIgnoreCase(pcondition))
			pcondition = pcondition.substring(0, pcondition.length() - 1);
		if (!"".equalsIgnoreCase(vcondition))
			vcondition = vcondition.substring(0, vcondition.length() - 1);
		if (!"".equalsIgnoreCase(jvcondition))
			jvcondition = jvcondition.substring(0, jvcondition.length() - 1);
		if (!"".equalsIgnoreCase(jspcondition))
			jspcondition = jspcondition.substring(0, jspcondition.length() - 1);
		if (!"".equalsIgnoreCase(vcondition))
			vcondition = ", " + vcondition;
		if (!"".equalsIgnoreCase(jspcondition))
			jspcondition = ", " + jspcondition;
		if (!"".equalsIgnoreCase(sqlcondition))
			sqlcondition = sqlcondition.substring(0, sqlcondition.length() - 5);
		if (!"".equalsIgnoreCase(sqlcondition))
			sqlcondition = "select c from " + classObj.get("clsname").toString() + " c where " + sqlcondition;
		else
			sqlcondition = "select c from " + classObj.get("clsname").toString() + " c";
	}

	
	public static void getFields() {
		Map obj = null;
		for (int i = fieldarr.size() - 1; i >= 0; i--) {
			obj = new HashMap();
			obj = (Map) fieldarr.get(i);
			String fieldcode = obj.get("fieldcode").toString();
			String fieldtype = obj.get("fieldtype").toString();
			String maxlength = "";
			String required = "";
			if (obj.containsKey("fieldlen")){
				maxlength = obj.get("fieldlen").toString();
				fieldList.add(fieldcode);
				paraMap.put(fieldcode, maxlength);
			}
			if (obj.containsKey("required"))
				required = obj.get("required").toString();
			String fieldname = "";
			if (obj.containsKey("fieldname")){
				fieldname = obj.get("fieldname").toString();
				nameMap.put(fieldcode, fieldname);
			}
			// 导出报表用
			entityKey += "\'"+fieldname+"\',";
			headerKey += "\'"+fieldcode+"\',";
			styles += "\'"+"plainText"+"\',";
			
			String cls = "";
			String forType = "";
			String spanred = "";
			if (fieldcode.toUpperCase().indexOf("DATE") != -1) {
				cls = "date-type ";
				forType = "    						         forType=\"date\"\r";
			}
			if ("y".equalsIgnoreCase(required)) {
				fieldvalids = fieldvalids + "myForm." + fieldcode + ".$invalid || ";
				setPristine = setPristine + "       $scope.myForm." + fieldcode + ".$setPristine();\r";
				required = " required";
				spanred = "<span style=\"color: red;\">*</span>";
			}
			if (!"".equalsIgnoreCase(maxlength)) {
				maxlength = "maxlength=\"" + maxlength + "\"";
			}
			theadFields = theadFields + "								<th>" + fieldname + "</th>\r";
			jTableFields = jTableFields + "								{ title: \""+fieldname+"\"},\r";
			jTableCode = jTableCode + "con[i]."+fieldcode+",";
			tbodyFields = tbodyFields + "								<td ng-bind=\"listEntity." + fieldcode
					+ "\"></td>\r";
			if (fieldcode.indexOf("operator") == -1)

				if (obj.containsKey("isselect")) {
					bodyinputs = bodyinputs + "						<div class=\"form-group\">\r"
							+ "     						<label for=\"settleDate\" class=\"col-sm-3 control-label\">"
							+ fieldname + spanred + "</label>\r"
							+ "     						<div class=\"col-sm-4\">\r"
							+ "						           <select class=\"select-style\" name=\"" + fieldcode
							+ "\" placeholder=\"请选择" + fieldname + "\"\r"
							+ "									       ng-model=\"modalEntity." + fieldcode + "\" "
							+ required + "\r"
							+ "									       onkeydown=\"myKeyup(event,this)\"\r"
							+ "									       ng-options=\"op.key as op.key+'_'+op.text for op in "
							+ fieldcode + "\">\r" + "						           </select>\r"
							+ "    						 </div>\r" + "						</div>\r";
					
				} else {
					bodyinputs = bodyinputs + "						<div class=\"form-group\">\r"
							+ "     						<label for=\"settleDate\" class=\"col-sm-3 control-label\">"
							+ fieldname + spanred + "</label>\r"
							+ "     						<div class=\"col-sm-4\">\r"
							+ "     						    <input type=\"text\" class=\"" + cls
							+ "input-style\" placeholder=\"请输入" + fieldname + "\"\r" + forType
							+ "    						         ng-model=\"modalEntity." + fieldcode + "\" name=\""
							+ fieldcode + "\" " + maxlength + " " + required + ">\r"
							+ "    						 </div>\r" + "						</div>\r";
					
				}
		
		}
		jTableFields = jTableFields.substring(0, jTableFields.length()-2);
		jTableCode = jTableCode.substring(0,jTableCode.length()-1);
		if (!"".equalsIgnoreCase(setPristine))
			setPristine = setPristine.substring(0, setPristine.length() - 1);
		if (!"".equalsIgnoreCase(fieldvalids))
			fieldvalids = fieldvalids.substring(0, fieldvalids.length() - 4);
	}
	
	public static void genJTableFile(String filePath, String Path, String clsType, String srcext, String tagext,int tableType){
		String filename = "";
		if (!"".equalsIgnoreCase(clsType))
			filename = currRootPath + filePath + classObj.get("clsname") + clsType + "." + srcext;
		else
			filename = currRootPath + filePath + clsType + "." + srcext;

		FileOutputStream fos = null;
		Writer out = null;
		
		
		
		try {
			fos = new FileOutputStream(filename);
			out = new OutputStreamWriter(fos, "UTF-8");

			// 读文件
			File tmplfile = null;
			if(tableType==1){
				tmplfile = new File(currRootPath + temlpatePath + "JTableTemplate" + clsType + "." + tagext);
			}
			if(tableType==2){
				tmplfile = new File(currRootPath + temlpatePath + "JTableTemplateBack" + clsType + "." + tagext);
			}
			
			InputStreamReader read = null;
			read = new InputStreamReader(new FileInputStream(tmplfile), "utf-8");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = "";

			while ((lineTxt = bufferedReader.readLine()) != null) {
				lineTxt = lineTxt.replaceAll("\\{packagepath\\}", Path.replaceAll("\\/", "."));
				lineTxt = lineTxt.replaceAll("\\{flclsname\\}", classObj.get("flclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{clsname\\}", classObj.get("clsname").toString());
				lineTxt = lineTxt.replaceAll("\\{lclsname\\}", classObj.get("lclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{entity\\}", classObj.get("entity").toString());
				
				lineTxt = lineTxt.replaceAll("\\{entityKey\\}", entityKey.substring(0,entityKey.length()-1));
				lineTxt = lineTxt.replaceAll("\\{headerKey\\}", headerKey.substring(0,headerKey.length()-1));
				lineTxt = lineTxt.replaceAll("\\{styles\\}", styles.substring(0,styles.length()-1));
				
				lineTxt = lineTxt.replaceAll("\\{pcondition\\}", pcondition);
				lineTxt = lineTxt.replaceAll("\\{vcondition\\}", vcondition);
				lineTxt = lineTxt.replaceAll("\\{jvcondition\\}", jvcondition);

				lineTxt = lineTxt.replaceAll("\\{paracondition\\}", paracondition);
				lineTxt = lineTxt.replaceAll("\\{projectName\\}", project_name);
				lineTxt = lineTxt.replace("{jspcondition}", jspcondition);
				lineTxt = lineTxt.replaceAll("\\{sqlcondition\\}", sqlcondition);
				lineTxt = lineTxt.replace("{srchcondition}", srchcondition);
				lineTxt = lineTxt.replace("{theadFields}", theadFields);
				lineTxt = lineTxt.replace("{jTableFields}",jTableFields);
				lineTxt = lineTxt.replace("{jTableCode}",jTableCode);
				lineTxt = lineTxt.replace("{tbodyFields}", tbodyFields);
				lineTxt = lineTxt.replace("{bodyinputs}", bodyinputs);
				lineTxt = lineTxt.replace("{setselect}", setselects);
				lineTxt = lineTxt.replace("{setPristine}", setPristine);
				lineTxt = lineTxt.replace("{fieldvalids}", fieldvalids);
				lineTxt = lineTxt.replace("{formtitle}", formtitle);

				lineTxt = lineTxt.replace("{otherjss}", otherjss);
				lineTxt = lineTxt.replace("{otherjsservices}", otherjsservices);

				out.write(lineTxt);
				out.write('\n');
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	// 生成java代码
	public static void genBusinClass(String filePath, String Path, String clsType, String srcext, String tagext,int tableType) {
		// 生成ServiceImpl接口
		String filename = "";
		if (!"".equalsIgnoreCase(clsType))
			filename = currRootPath + filePath + classObj.get("clsname") + clsType + "." + srcext;
		else
			filename = currRootPath + filePath + clsType + "." + srcext;

		FileOutputStream fos = null;
		Writer out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new OutputStreamWriter(fos, "UTF-8");

			// 读文件
			File tmplfile = null;
			if(tableType == 2 && clsType.equals("Service") && srcext.equals("java") ){
				 tmplfile = new File(currRootPath + temlpatePath + "BackTemplate" + clsType + "." + tagext);
			}else{
				tmplfile = new File(currRootPath + temlpatePath + "Template" + clsType + "." + tagext);
			}
			InputStreamReader read = null;
			read = new InputStreamReader(new FileInputStream(tmplfile), "utf-8");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = "";

			while ((lineTxt = bufferedReader.readLine()) != null) {
				lineTxt = lineTxt.replaceAll("\\{packagepath\\}", Path.replaceAll("\\/", "."));
				lineTxt = lineTxt.replaceAll("\\{flclsname\\}", classObj.get("flclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{clsname\\}", classObj.get("clsname").toString());
				lineTxt = lineTxt.replaceAll("\\{lclsname\\}", classObj.get("lclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{entity\\}", classObj.get("entity").toString());

				lineTxt = lineTxt.replaceAll("\\{entityKey\\}", entityKey.substring(0,entityKey.length()-1));
				lineTxt = lineTxt.replaceAll("\\{headerKey\\}", headerKey.substring(0,headerKey.length()-1));
				lineTxt = lineTxt.replaceAll("\\{styles\\}", styles.substring(0,styles.length()-1));
				
				lineTxt = lineTxt.replaceAll("\\{pcondition\\}", pcondition);
				lineTxt = lineTxt.replaceAll("\\{vcondition\\}", vcondition);
				lineTxt = lineTxt.replaceAll("\\{jvcondition\\}", jvcondition);

				lineTxt = lineTxt.replaceAll("\\{projectName\\}", project_name);
				lineTxt = lineTxt.replaceAll("\\{paracondition\\}", paracondition);
				lineTxt = lineTxt.replace("{jspcondition}", jspcondition);
				lineTxt = lineTxt.replaceAll("\\{sqlcondition\\}", sqlcondition);
				lineTxt = lineTxt.replace("{srchcondition}", srchcondition);
				lineTxt = lineTxt.replace("{theadFields}", theadFields);
				lineTxt = lineTxt.replace("{tbodyFields}", tbodyFields);
				lineTxt = lineTxt.replace("{bodyinputs}", bodyinputs);
				lineTxt = lineTxt.replace("{setselect}", setselects);
				lineTxt = lineTxt.replace("{setPristine}", setPristine);
				lineTxt = lineTxt.replace("{fieldvalids}", fieldvalids);
				lineTxt = lineTxt.replace("{formtitle}", formtitle);

				lineTxt = lineTxt.replace("{otherjss}", otherjss);
				lineTxt = lineTxt.replace("{otherjsservices}", otherjsservices);

				out.write(lineTxt);
				out.write('\n');
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void genBlankCls(String filename) {
		FileOutputStream fos = null;
		Writer out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new OutputStreamWriter(fos, "UTF-8");
			out.write("");
		} catch (Exception e) {

		} finally {
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void setDefaultParams() {
		storage.clear();

		fieldarr = null;
		classObj = null;
		fieldarr = new ArrayList();
		classObj = new HashMap();

		pcondition = "";
		vcondition = "";
		jvcondition = "";
		paracondition = "";
		sqlcondition = "";
		jspcondition = "";
		srchcondition = "";
		theadFields = "";
		jTableFields = "";
		tbodyFields = "";
		bodyinputs = "";
		setPristine = "";
		fieldvalids = "";
		setselects = "";
		otherjss = "";
		otherjsservices = "";
		
	}

	/**
	 * genAllCodeByDefault
	 * @param classname  实体类名
	 * @param vformtitle 页面的中文名称
	 * @param tableType  分页类型（默认0是angulartable,1是前台jtable分页,2是后台jtable分页）
	 * @param afterWhich 指定位置的前一个节点的中文名称
	 */
	public static void genAllCodeByDefault(String classname, String vformtitle,int tableType,String afterWhich) {
		formtitle = vformtitle;
		// 设置各路径
		getProjectPath();
		try {
			// 解析实体类
			readJavaClassFile(currRootPath + EntityFilepath + classname.replaceAll("\\.", "\\/") + ".java");
			
			getClassAttributes(classname);
			getConditions();
			getFields();
			// 生成接口
			
 			genBusinClass(apiFilepath, apiPath, "Service", "java", "txt",tableType);
			genBusinClass(InterfaceFilepath, InterfacePath, "ServiceImpl", "java", "txt",tableType);
			genBusinClass(RepositoryFilepath, RepositoryPath, "Repository", "java", "txt",tableType);

			readBussinApi(currRootPath + apiFilepath + "TemplateEntityService.java");
			genJavaService(tableType);
			File tmp = new File(currRootPath + pageFilePath + classObj.get("lclsname").toString() + "/");
			if (!tmp.exists()) {
				tmp.mkdir();
			}
			genBusinClass(
					pageFilePath + classObj.get("lclsname").toString() + "/" + classObj.get("flclsname").toString(), "",
					"", "js", "js",tableType);
			genBlankCls(currRootPath + pageFilePath + classObj.get("lclsname").toString() + "/"
					+ classObj.get("flclsname").toString() + ".css");
			genBusinClass(pageServiceFilePath, "", "Service", "js", "js",tableType);
			genBusinClass(
					pageFilePath + classObj.get("lclsname").toString() + "/" + classObj.get("flclsname").toString(), "",
					"", "html", "html",tableType);
			if(tableType ==1 ){// 前台jtable分页
				genJTableFile(
						pageFilePath + classObj.get("lclsname").toString() + "/" + classObj.get("flclsname").toString(), "",
						"", "html", "html",tableType);
				genJTableFile(
						pageFilePath + classObj.get("lclsname").toString() + "/" + classObj.get("flclsname").toString(), "",
						"", "js", "js",tableType);
			}if(tableType ==2){// 后台jtable分页
				genJTableFile(
						pageFilePath + classObj.get("lclsname").toString() + "/" + classObj.get("flclsname").toString(), "",
						"", "html", "html",1);
				genJTableFile(
						pageFilePath + classObj.get("lclsname").toString() + "/" + classObj.get("flclsname").toString(), "",
						"", "js", "js",tableType);
			}
			// 是否需要自动配置到index.json
			if(null != afterWhich && !"".equals(afterWhich)){
				//自动配置到index.json
				addToIndexJson(vformtitle,afterWhich);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	

	@SuppressWarnings("unchecked")
	public static void readBussinApi(String filepath) {
		// apiImportList
		apiImportList = null;
		apiList = null;
		relyObjClsList = null;
		apiImportList = new ArrayList();
		apiList = new ArrayList();
		relyObjClsList = new ArrayList();
		// 解析，去回车
		File file = new File(currRootPath + apiFilepath + classObj.get("clsname").toString() + "Service.java");
		if (file.isFile() && file.exists()) { // 判断文件是否存在
			InputStreamReader read = null;
			try {
				read = new InputStreamReader(new FileInputStream(file), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} // 考虑到编码格式
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			String funstr = "";
			String ishave = "";
			try {
				while ((lineTxt = bufferedReader.readLine()) != null) {
					lineTxt = lineTxt.trim();
					lineTxt = lineTxt.replace("@NotNull", "");
					lineTxt = lineTxt.replace(";", "");
					if (lineTxt.indexOf("*") != -1)
						continue;
					if (lineTxt.indexOf("entity") != -1) {
						apiImportList.add(lineTxt);
						relyObjClsList.add(lineTxt.substring(lineTxt.lastIndexOf(".") + 1));
					}
					if (lineTxt.indexOf("(") != -1) {
						ishave = "0";
					}
					if (lineTxt.indexOf(")") != -1) {
						ishave = "";
						funstr = funstr + lineTxt;
						apiList.add(funstr);
						funstr = "";
					}
					if ("".equalsIgnoreCase(ishave))
						continue;
					else
						funstr = funstr + lineTxt;

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (apiImportList.size() == 0) {
			apiImportList.add("import " + gclassname + "");
			relyObjClsList.add(gclassname.substring(gclassname.lastIndexOf(".") + 1));
		}
	}

	public static boolean genJavaService(int tableType) {
		
		// 引入的java类
		String imports = "";
		String repositoryimports = "";
		String Injects = "";
		for (int i = 0; i < apiImportList.size(); i++) {
			imports = imports + apiImportList.get(i) + ";\n";
			repositoryimports = repositoryimports + apiImportList.get(i) + ";\n";
		}
		for (int i = 0; i < relyObjClsList.size(); i++) {
			imports = imports + "import " + RepositoryPath.replace("/", ".") + "." + relyObjClsList.get(i)
					+ "Repository;\n";
			Injects = Injects + "	@Inject\n	" + relyObjClsList.get(i) + "Repository "
					+ toLowerCaseFirstOne(relyObjClsList.get(i).toString()) + "Repository;\n";
		}
		imports = imports + "import " + apiPath.replace("/", ".") + "." + classObj.get("clsname").toString()
				+ "Service;\n";
		// 方法列表
		String funclists = "";
		String repositoryfunclists = "";
		for (int i = 0; i < apiList.size(); i++) {
			String f1 = "";
			String f2 = "";
			String f3 = "";
			String tmp = (String) apiList.get(i);
			f1 = tmp.substring(0, tmp.indexOf("(")).trim();
			f2 = tmp.substring(tmp.indexOf("(") + 1, tmp.indexOf(")")).trim();
			f3 = tmp.substring(tmp.indexOf(")") + 1).trim();
			funclists = funclists + "	@Override\n" + "	" + apiList.get(i) + "{\n";
			if (tmp.indexOf(" add") != -1 || tmp.indexOf(" update") != -1) {// 新增,修改
				funclists = funclists + "		validate( " + classObj.get("flclsname").toString() + ");\n";
				funclists = funclists + "		return " + classObj.get("flclsname").toString() + "Repository.save("
						+ classObj.get("flclsname").toString() + ");\n";
			} else if (tmp.indexOf(" delete") != -1) {
				funclists = funclists + "		" + classObj.get("flclsname").toString() + "Repository.delete("
						+ f2.split(" ")[1] + ");\n";
			} else if (tmp.indexOf("validate") != -1){ // 回调
				funclists = funclists + "\t	Map<String,Object> returnMap = new HashMap<String,Object>();\n" ;
				funclists = funclists + "\n"+"		if("+classObj.get("flclsname").toString()+" == null ){\n" 	+ "	\t	returnMap.put("+"\""+"result"+"\""+","+"-1"+")" +";\n "+ "\t		returnMap.put("+"\""+"message"+"\""+","+"\""+"参数不能为空"+"\""+")" +";\n "+"\t		return returnMap;\n"+"		}";
				for(int j =0;j<fieldList.size();j++){
					Object message = "\"" + nameMap.get(fieldList.get(j).toString())+"不能为空且长度不能超过"+paraMap.get(fieldList.get(j).toString()) + "\"";
					funclists = funclists + "\n"+"		if("+classObj.get("flclsname").toString()+".get"+toUpperCaseFirstOne(fieldList.get(j).toString())+"() == null || "
							+classObj.get("flclsname").toString()+".get"+toUpperCaseFirstOne(fieldList.get(j).toString())+"().length() > "+paraMap.get(fieldList.get(j).toString())+"){\n"
							+ "	\t	returnMap.put("+"\""+"result"+"\""+",-1"+")" +";\n "+ "\t		returnMap.put("+"\""+"message"+"\""+","+ message+")" +";\n "+"\t		return returnMap;\n"+"		}";
					
				}
				funclists = funclists + "\n	 	returnMap.put("+"\""+"result"+"\""+","+"0"+")" +";\n" + "		return returnMap;\n ";
			
			} else if (tmp.indexOf("FrameworkPage") != -1){ // 回调
				funclists = funclists +"\t	List<"+classObj.get("clsname").toString()+"> returnList = new ArrayList<"+classObj.get("clsname").toString()+">();\n ";
				funclists = funclists +"\t\t 	returnList = "+classObj.get("flclsname").toString()+"Mapper.backPaging"+classObj.get("clsname").toString()+"("+classObj.get("flclsname").toString()+","
						+ "frameworkPageable,orderType,orderWay);\n\t";
				funclists = funclists +"\n\t	return FrameworkPage.getFrameworkPage(frameworkPageable, returnList); \t \n	"	;	
			}
			else {
				// 获取参数
				String[] pararr = f2.split(",");
				String paras = "";
				String repositoryparas = "";
				String repositoryparassql = "";
				String tmpjspara = "";
				String tmpsrchcolumns = "";
				for (int j = 0; j < pararr.length; j++) {
					if (!"".equalsIgnoreCase(pararr[j])
							&& !(pararr[j].split(" ")[0]).equalsIgnoreCase(classObj.get("clsname").toString())) {
						if ("string".equalsIgnoreCase(pararr[j].split(" ")[0]))
							paras = paras + "PsUtil.convertToNull(" + pararr[j].split(" ")[1] + "),";
						else
							paras = paras + pararr[j].split(" ")[1] + ",";

						tmpjspara = tmpjspara + ",entity." + pararr[j].split(" ")[1];
					} else if (!"".equalsIgnoreCase(pararr[j])
							&& (pararr[j].split(" ")[0]).equalsIgnoreCase(classObj.get("clsname").toString())) {
						paras = paras + pararr[j].split(" ")[1] + ",";
					}
					if (!"".equalsIgnoreCase(pararr[j])) {
						repositoryparas = repositoryparas + "@Param(\"" + pararr[j].split(" ")[1] + "\") " + pararr[j]
								+ ",";
						repositoryparassql = repositoryparassql + "(c." + pararr[j].split(" ")[1] + " like %:"
								+ pararr[j].split(" ")[1] + "% or :" + pararr[j].split(" ")[1] + " is null) and ";
						tmpsrchcolumns = tmpsrchcolumns + pararr[j].split(" ")[1] + ",";
					}
				}

				if (!"".equalsIgnoreCase(paras))
					paras = paras.substring(0, paras.length() - 1);
				if ((f1.split(" ")[1]).indexOf("List") != -1) {
					funclists = funclists + "		Iterator<" + classObj.get("clsname").toString() + "> iter = "
							+ classObj.get("flclsname").toString() + "Repository." + f1.split(" ")[2] + "(" + paras
							+ ").iterator();\n";
					funclists = funclists + "		return IteratorUtils.toArrayList(iter, 0);\n";
				} else if (tmp.indexOf("void") != -1){ // 回调
					funclists = funclists + "		" + classObj.get("flclsname").toString() + "Repository."
							+ f1.split(" ")[2] + "(" + paras + ");\n\n ";
				}
				else{
					funclists = funclists + "		return " + classObj.get("flclsname").toString() + "Repository."
							+ f1.split(" ")[2] + "(" + paras + ");\n";
				}
				if (!"".equalsIgnoreCase(repositoryparas))
					repositoryparas = repositoryparas.substring(0, repositoryparas.length() - 1);
				if (!"".equalsIgnoreCase(repositoryparassql)) {
					repositoryparassql = repositoryparassql.substring(0, repositoryparassql.length() - 4);
					repositoryparassql = "select c \"\n" + "          +\"  from " + classObj.get("clsname").toString()
							+ " c \"\n" + "          +\" where " + repositoryparassql;
				}
				if ("".equalsIgnoreCase(
						repositoryparassql)/*
											 * ||(f1.indexOf("find")==-1&&f1.
											 * indexOf("query")==-1)
											 */)
					repositoryfunclists = repositoryfunclists + "	" + f1 + "(" + repositoryparas + ");\n\n";
				else
					repositoryfunclists = repositoryfunclists + "	@Query(value =\"" + repositoryparassql + "\")\n	"
							+ f1 + "(" + repositoryparas + ");\n\n";

					if ("findByCondition".equalsIgnoreCase(f1.split(" ")[2])  )
						classObj.put("srchcolumns", tmpsrchcolumns.trim());
				
				

				// 其他方法
				if (!"findByCondition".equalsIgnoreCase(f1.split(" ")[2])
						&& !"findAll".equalsIgnoreCase(f1.split(" ")[2])) {
					if (tmp.indexOf("void") == -1) {// 回调
						otherjss = otherjss + "     $scope." + f1.split(" ")[2] + classObj.get("clsname").toString()
								+ " = function (entity) {\n" + "        var index = entity.recordIndex;\n" + "        "
								+ f1.split(" ")[2] + classObj.get("clsname").toString() + "(function(result){\n"
								+ "    			layer.msg(\"成功!\",{icon:1});\n" + "    			$(\"#my"
								+ classObj.get("flclsname").toString() + "Modal\").modal(\"hide\");\n"
								+ "    			$scope.find($scope.queryEntity);\n" + "    	},entity" + tmpjspara
								+ ");\n" + "        $(\"#my" + classObj.get("flclsname").toString()
								+ "Modal\").modal(\"hide\");\n" + "     }\n";
						otherjsservices = otherjsservices + "function " + f1.split(" ")[2]
								+ classObj.get("clsname").toString() + "(callback, entity"
								+ tmpjspara.replaceAll("entity.", "") + ") {\n" + "	cffex.service.request('"
								+ classObj.get("flclsname").toString() + "Service', '" + f1.split(" ")[2] + "'"
								+ tmpjspara.replaceAll("entity.", "") + ", function(\n"
								+ "			errCode, errMsg, result) {\n" + "		if (errCode > 0) {\n"
								+ "			alert(errCode + ': ' + errMsg + '\\n' + JSON.stringify(result));\n"
								+ "		}\n" + "		if (callback !== undefined || callback != null) {\n"
								+ "			callback(result);\n" + "		}\n" + "	});\n" + "}\n";
					} else {
						otherjsservices = otherjsservices + "function " + f1.split(" ")[2]
								+ classObj.get("clsname").toString() + "(callback, entity"
								+ tmpjspara.replaceAll("entity.", "") + ") {\n" + "	cffex.service.request('"
								+ classObj.get("flclsname").toString() + "Service', '" + f1.split(" ")[2] + "'"
								+ tmpjspara.replaceAll("entity.", "") + ", function(\n"
								+ "			errCode, errMsg, result) {\n" + "		if (errCode > 0) {\n"
								+ "			alert(errCode + ': ' + errMsg + '\\n' + JSON.stringify(result));\n"
								+ "		}\n" + "		if (callback !== undefined || callback != null) {\n"
								+ "			callback(result);\n" + "		}\n" + "	});\n" + "}\n";
						if (!"".equalsIgnoreCase(tmpjspara))
							tmpjspara = tmpjspara.substring(1);
						otherjss = otherjss + "     $scope." + f1.split(" ")[2] + classObj.get("clsname").toString()
								+ " = function (entity,index) {\n" + "    		" + f1.split(" ")[2]
								+ classObj.get("clsname").toString() + "(" + tmpjspara + ");\n"
								+ "            $scope.listEntitys.splice(index, 1);\n"
								+ "            layer.close(count);\n" + "            $scope.$apply();\n" + "     };\n";
					}
				}
			
			}
			funclists = funclists + "	}\n\n";
		}

		String filename = currRootPath + InterfaceFilepath + classObj.get("clsname").toString() + "ServiceImpl.java";
		FileOutputStream fos = null;
		Writer out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 读文件
			File tmplfile = null;
			if(tableType == 2){
				 tmplfile = new File(currRootPath + temlpatePath + "BackBlankServiceImpl.txt");
			}else{
				tmplfile = new File(currRootPath + temlpatePath + "TemplateBlankServiceImpl.txt");
			}
			InputStreamReader read = null;
			read = new InputStreamReader(new FileInputStream(tmplfile), "utf-8");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = "";
			while ((lineTxt = bufferedReader.readLine()) != null) {
				lineTxt = lineTxt.replaceAll("\\{imports\\}", imports);
				lineTxt = lineTxt.replaceAll("\\{Inject\\}", Injects);
				lineTxt = lineTxt.replaceAll("\\{funclist\\}", funclists);
				lineTxt = lineTxt.replaceAll("\\{flclsname\\}", classObj.get("flclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{clsname\\}", classObj.get("clsname").toString());
				lineTxt = lineTxt.replaceAll("\\{lclsname\\}", classObj.get("lclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{projectName\\}", project_name);
				out.write(lineTxt);
				out.write('\n');
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		filename = currRootPath + RepositoryFilepath + classObj.get("clsname").toString() + "Repository.java";
		try {
			fos = new FileOutputStream(filename);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 读文件
			File tmplfile = new File(currRootPath + temlpatePath + "TemplateBlankRepository.txt");
			InputStreamReader read = null;
			read = new InputStreamReader(new FileInputStream(tmplfile), "utf-8");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = "";
			while ((lineTxt = bufferedReader.readLine()) != null) {
				lineTxt = lineTxt.replaceAll("\\{repositoryimports\\}", repositoryimports);
				lineTxt = lineTxt.replaceAll("\\{Inject\\}", Injects);
				lineTxt = lineTxt.replaceAll("\\{repositoryfunclist\\}", repositoryfunclists);
				lineTxt = lineTxt.replaceAll("\\{flclsname\\}", classObj.get("flclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{clsname\\}", classObj.get("clsname").toString());
				lineTxt = lineTxt.replaceAll("\\{lclsname\\}", classObj.get("lclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{projectName\\}", project_name);
				out.write(lineTxt);
				out.write('\n');
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(tableType !=2){
			return true;
		}
		// 生成mapper.java
		filename = currRootPath + MapperFilepath + classObj.get("clsname").toString() + "Mapper.java";
		try {
			fos = new FileOutputStream(filename);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 读文件
			File tmplfile = new File(currRootPath + temlpatePath + "MapperJava.txt");
			InputStreamReader read = null;
			read = new InputStreamReader(new FileInputStream(tmplfile), "utf-8");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = "";
			while ((lineTxt = bufferedReader.readLine()) != null) {
				lineTxt = lineTxt.replaceAll("\\{imports\\}", imports);
				lineTxt = lineTxt.replaceAll("\\{Inject\\}", Injects);
				lineTxt = lineTxt.replaceAll("\\{flclsname\\}", classObj.get("flclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{clsname\\}", classObj.get("clsname").toString());
				lineTxt = lineTxt.replaceAll("\\{lclsname\\}", classObj.get("lclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{entity\\}", classObj.get("entity").toString());
				lineTxt = lineTxt.replaceAll("\\{projectName\\}", project_name);
				out.write(lineTxt);
				out.write('\n');
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 生成mapper.xml
		filename = currRootPath + MapperFilepath + classObj.get("clsname").toString() + "Mapper.xml";
		try {
			fos = new FileOutputStream(filename);
			out = new OutputStreamWriter(fos, "UTF-8");
			// 读文件
			File tmplfile = new File(currRootPath + temlpatePath + "MapperXml.txt");
			InputStreamReader read = null;
			read = new InputStreamReader(new FileInputStream(tmplfile), "utf-8");
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = "";
			while ((lineTxt = bufferedReader.readLine()) != null) {
				lineTxt = lineTxt.replaceAll("\\{imports\\}", imports);
				lineTxt = lineTxt.replaceAll("\\{Inject\\}", Injects);
				lineTxt = lineTxt.replaceAll("\\{flclsname\\}", classObj.get("flclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{clsname\\}", classObj.get("clsname").toString());
				lineTxt = lineTxt.replaceAll("\\{lclsname\\}", classObj.get("lclsname").toString());
				lineTxt = lineTxt.replaceAll("\\{entity\\}", classObj.get("entity").toString());
				lineTxt = lineTxt.replaceAll("\\{projectName\\}", project_name);
				out.write(lineTxt);
				out.write('\n');
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static void genAllCodeByApi(String classname, String vformtitle) {
		formtitle = vformtitle;
		// 设置各路径
		getProjectPath();
		try {
			// 解析实体类
			readJavaClassFile(currRootPath + EntityFilepath + classname.replaceAll("\\.", "\\/") + ".java");
			getClassAttributes(classname);
			//getFields();
			readBussinApi(currRootPath + apiFilepath + "TemplateEntityService.java");
			//genJavaService();
			getConditions();
			// 生成页面
			File tmp = new File(currRootPath + pageFilePath + classObj.get("lclsname").toString() + "/");
			if (!tmp.exists()) {
				tmp.mkdir();
			}
			genBusinClass(
					pageFilePath + classObj.get("lclsname").toString() + "/" + classObj.get("flclsname").toString(), "",
					"", "js", "js",1);

			genBlankCls(currRootPath + pageFilePath + classObj.get("lclsname").toString() + "/"
					+ classObj.get("flclsname").toString() + ".css");
			genBusinClass(pageServiceFilePath, "", "Service", "js", "js",1);
			genBusinClass(
					pageFilePath + classObj.get("lclsname").toString() + "/" + classObj.get("flclsname").toString(), "",
					"", "html", "html",1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//自动化将新增文件名的js，service.js添加到index.html页面中
	public static boolean addToIndex(){
		try {
	           File temp = new File(currRootPath + pageFilePath + "index.html");
	            
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(temp)));
	            StringBuilder stringBuilder = new StringBuilder();
	            String lineText;
	            while ((lineText = bufferedReader.readLine())!=null){
	                stringBuilder.append(lineText+"\n");
                }
	            int resultForJs = stringBuilder.lastIndexOf("</body>");
	            stringBuilder = stringBuilder.insert(resultForJs, "<script src=\""+classObj.get("lclsname").toString() + 
	            		"/" + classObj.get("flclsname").toString()+
	            		".js\"></script>\n<script src=\"../service/"+
	            		classObj.get("clsname").toString()+"Service.js\"></script>\n");
	            
	            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temp)),260000);
	            
	            bufferedWriter.write(stringBuilder.toString().replaceAll("\n","\r\n"));
	            bufferedWriter.flush();
	            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return true;
	}

	//自动化将新增文件名添加到index.json页面中
	//targetName 指定目标的中文名
	//afterWhich 目标位置的上一个节点的中文名
	public static boolean addToIndexJson(String targetName,String afterWhich){
		boolean isExists = false;
		try {
	           File temp = new File(currRootPath + pageFilePath + "index.json");
	            
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(temp)));
	            StringBuilder stringBuilder = new StringBuilder();
	            String lineText;
	            while ((lineText = bufferedReader.readLine())!=null){
	                stringBuilder.append(lineText+"\n");
                }
	            int result = stringBuilder.indexOf(afterWhich);
	            StringBuilder subTarget = new StringBuilder(stringBuilder.substring(result,result+500));
	            int result2 = subTarget.indexOf("}");
	             
	            int isExist = stringBuilder.indexOf(targetName);
	            if(isExist > 0){
	            	System.out.println("index.json中节点已存在！");
	            	return true;
	            }
	            stringBuilder = stringBuilder.insert(result+result2+1,",\n"
	            		+"     	{ \n"
	            		+"          \"title\":\""+targetName+"\",\n"
	            		+"          \"titleShort\":\""+"menu:customerInfos"+"\",\n"
	            		+"          \"controller\":\""+classObj.get("clsname").toString()+"Controller"+"\",\n"
	            		+"          \"url\":\""+classObj.get("lclsname").toString()+"/"+classObj.get("flclsname").toString()+"\",\n"
	            		+"          \"href\":\"#"+classObj.get("flclsname").toString()+"\"\n"
		                +"		}");
	                        
	            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temp)),260000);
	            
	            bufferedWriter.write(stringBuilder.toString().replaceAll("\n","\r\n"));
	            bufferedWriter.flush();
	            bufferedWriter.close();
	            boolean flag = addToIndex();
	            if(!flag){
	            	System.out.println("新增文件js，service.js添加到index.html页面失败，请手动添加！");
	            	return true;
	            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
	}
	
    /**
     * 默认的方法 增加：add 修改：update 删除：delete 查询：findByCondition
     */
    public static void main(String[] args) {
    	// 新增功能所叫的名字
		String vformtitle = "测试交易商info";
		// jquerytable
		int jqtable = 2;
		// 插入index.json，想要放到哪个下面的名字(若不需要自动添加到json中，可以定义成null)
		String afterWhich = "客户信息查询";
		// 实体名
		String classname = "com.quantdo.clearingCenter.entity.trader.TestTraderInfo";
		genAllCodeByDefault(classname,vformtitle,jqtable,afterWhich);
		System.out.println("ok!");
    }
}
