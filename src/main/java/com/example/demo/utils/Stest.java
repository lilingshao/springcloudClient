package com.example.demo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new a();
//		new b();
//		new c();
	}

}
class a{
	static int i=0;
	int k=0;
}
class b extends a{
	public b() {
		super.i=1;
		super.k=1;
	}
}
class c extends a{
	public c() {
		System.out.println(super.i);
		System.out.println(super.k);
	}
}
