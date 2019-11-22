package com.hanrabong.web.pxy;

import static org.junit.Assert.*;
import javax.servlet.ServletContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import  org.springframework.beans.factory.annotation.Autowired;

import com.hanrabong.web.cfg.RootConfig;
import com.hanrabong.web.cfg.ServletConfig;
import com.hanrabong.web.cfg.WebConfig;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {
@Autowired Calculator cal;
	@Test
	public void testSum() {
		assertThat(cal.sum(1,4),is(equalTo(5)));
	}

	@Ignore
	public void testSub() {
		//fail("Not yet implemented");
	}

	@Ignore
	public void testAbs() {
		//fail("Not yet implemented");
	}

}
