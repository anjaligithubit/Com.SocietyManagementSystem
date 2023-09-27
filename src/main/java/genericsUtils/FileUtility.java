package genericsUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**This class consists of methods to fetch common data from property files
 * @author Anjali
 */
public class FileUtility 
{
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.propertyFilePath);
		Properties properties=new Properties();
		properties.load(fis);
	String value=	 properties.get(key).toString();
		return value;
	}
	
	

}
