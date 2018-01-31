package com.sapient.streams2;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class MaxSalary {

	public static void main(String[] args) {
		List<Emp> lst = new ArrayList<>();
		lst.add(new Emp(1007, "ram", 9000));
		lst.add(new Emp(1003, "tom", 59000));
		lst.add(new Emp(1005, "sam", 39000));
		lst.add(new Emp(1009, "peter", 69000));
		lst.add(new Emp(1002, "ravi", 29000));

		OptionalDouble opt = lst.stream().mapToDouble(e->e.getSal()).max();
		double max =opt.getAsDouble();
		
		Stream<Emp> s =lst.stream().filter(e->e.getSal()==max);
		s.forEach(MyUtil::display);

	}

}
