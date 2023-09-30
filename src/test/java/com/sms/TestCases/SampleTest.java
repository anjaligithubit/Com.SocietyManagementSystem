package com.sms.TestCases;

import org.testng.annotations.Test;

public class SampleTest {
	@Test(groups="smoke")
	public void sample() {
		System.out.println("--- sample ----");
	}
	@Test
	public void sample1() {
		System.out.println("--- sample1 ---");
	}

}
