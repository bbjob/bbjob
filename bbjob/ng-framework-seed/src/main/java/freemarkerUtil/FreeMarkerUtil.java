package freemarkerUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

public class FreeMarkerUtil {
	public Template getTemplate(String name) {
		try {
			// 通过Freemaker的Configuration读取相应的ftl
			// Version version = new Version(2 * 1000000 + 3 * 1000 + 26);
			Configuration cfg = new Configuration();

	        cfg.setDefaultEncoding("UTF-8");  
			// 设定去哪里读取相应的ftl模板文件
			cfg.setClassForTemplateLoading(this.getClass(), "../templates");
			// 在模板文件目录中找到名称为name的文件
			Template temp = cfg.getTemplate(name);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 输出到控制台
	 * 
	 */
	public void print(String name, Map<String, Object> root, PrintWriter out) {
		try {
			Template temp = this.getTemplate(name);
			temp.setEncoding("UTF-8");  
			temp.process(root, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
