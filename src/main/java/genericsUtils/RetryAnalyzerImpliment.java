package genericsUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImpliment  implements IRetryAnalyzer{
	int count=0;
	int upperLimit=3;
	@Override
	public boolean retry(ITestResult arg0) {
		if(count<3) {
			count++;
			return true;
		}
		return false;
	}
	

}
