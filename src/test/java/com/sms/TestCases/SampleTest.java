package com.sms.TestCases;

import org.testng.annotations.Test;

public class SampleTest {
	@Test(groups="smoke")
	public void sample1() {
		System.out.println("--- sample1 ----");
	}
	@Test
	public void sample2() {
		System.out.println("--- sample2 ---");
	}
	@Test
	public void sample3() {
		System.out.println("--- sample3 ----");
	}

}
