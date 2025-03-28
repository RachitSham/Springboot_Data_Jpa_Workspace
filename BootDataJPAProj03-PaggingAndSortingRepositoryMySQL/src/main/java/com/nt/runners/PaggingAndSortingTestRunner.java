package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Singer;
import com.nt.service.ISingerService;

@Component
public class PaggingAndSortingTestRunner implements CommandLineRunner {

	@Autowired
	private ISingerService service;

	@Override
	public void run(String... args) throws Exception {

		service.showSingerBySorting(true, "sname").forEach(System.out::println);

		System.out.println(" --------------------------------------------------------------------- ");

		service.showSingerBySorting(false, "fees", "sname").forEach(System.out::println);

		System.out.println("--------------------------FindAll(Pageable pageable)--------------------");
		try {
			Page<Singer> page = service.showSingerInfoByPageNo(3, 4, false, "sname");
			System.out.println("Pages Number::" + page.getNumber());
			System.out.println("Pages Count::" + page.getTotalPages());
			System.out.println("Is It First Page::" + page.isFirst());
			System.out.println("Is It Last Page::" + page.isLast());
			System.out.println("Page Size::" + page.getSize());
			System.out.println("Page Element Count::" + page.getNumberOfElements());

			if (!page.isEmpty()) {

				List<Singer> list = page.getContent();
				list.forEach(System.out::println);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
