package com.hanrabong.web.pxy;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component@Lazy
public class Proxy {
public int integer(String param) {
	Function<String, Integer>f= Integer::parseInt;
	
	return f.apply(param);
}
public boolean equal(String Param,String param2) {

	BiPredicate<String, String>f=String ::equals;
	return f.test(Param, param2);
}
public void print(String param) {
	Consumer<String>f=System.out::print;
	f.accept(param);
}
}
