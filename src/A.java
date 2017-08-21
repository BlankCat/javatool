import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author  zjf
 * @date 创建时间：2017年6月28日 
 * @Description 
 */
public class A {

	public static void main(String[] args) {
		String string="|0,5|1,4|2,4|3,4|4,4|5,4|6,4|7,4|8,4|9,4|10,4|11,4|12,4|13,4|14,4|";
		String [] menus=string.split("\\|");
		Map<String, String> jsonResult = new LinkedHashMap<String, String>();
		for (int i = 0; i < menus.length; i++) {
			String menuStr=menus[i];
			if(!"".equals(menuStr)){
//				System.out.println(i+"=="+menuStr);
				String [] list=menuStr.split(",");
				jsonResult.put(list[0],list[1]);
			}
		}
		System.out.println(jsonResult.get("19"));
	}
}
