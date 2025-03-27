package com.nt.Runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Singer;
import com.nt.service.ISingerService;

@Component
public class SingerRepoTestRunner implements CommandLineRunner {

	@Autowired
	private ISingerService service;

	@Override
	public void run(String... args) throws Exception {

		/*	Singer sing = new Singer();
			sing.setSname("Diljit Dosanjh");
			sing.setScategory("Pop, Love Songs");
			sing.setFees(300000.00);
			String singerMsg = service.registerSinger(sing);
			System.out.println(singerMsg);
			*/

		try {
			System.out.println("Singers Count:: " + service.showSingersCount());

		} catch (Exception e) {
			e.printStackTrace();
		}

		// calling the b.method from singerserviceImpl class to check singer
		// availability
		try {
			System.out.println("Singer is available or not ? " + service.checkSingerAvailability(2));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*Singer sing1 = new Singer();
		sing1.setSname("Ammy Virk");
		sing1.setScategory("Love and Mellody Songs");
		sing1.setFees(1700000.90);
		
		Singer sing2 = new Singer();
		sing2.setSname("Gurdas Maan");
		sing2.setScategory("Love, Romantic And Mellody Songs");
		sing2.setFees(2000000.90);
		
		Singer sing3 = new Singer();
		sing3.setSname("Surjit Bindrakhia");
		sing3.setScategory("Punjabi Pop and Folk Songs And Party Songs");
		sing3.setFees(2800000.90);
		
		List<Singer> list = List.of(sing1, sing2, sing3);
		try {
		
			String singMsg = service.registerSingerBatch(list);
			System.out.println(singMsg);
		} catch (Exception e) {
			e.printStackTrace();
		
		}*/

		try {

			Iterable<Singer> it = service.showAllSinger();
			it.forEach(sing -> {
				System.out.println(sing);
			});

			System.out.println("---------------------------------------------");
			it.forEach(sing -> System.out.println(sing));

			System.out.println("---------------------------------------------");
			Iterable<String> singer_Name = StreamSupport.stream(it.spliterator(), false).map(Singer::getSname)
					.collect(Collectors.toList());
			System.out.println(singer_Name);

			System.out.println("---------------------------------------------");
			Iterable<String> singer_Category = StreamSupport.stream(it.spliterator(), false).map(Singer::getScategory)
					.collect(Collectors.toList());
			System.out.println(singer_Category);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("---------------------------------------------");
		try {
			service.showAllSingerById(List.of(1, 2, 102, 152, 109)).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*System.out.println("---------------------------------------------");
		
		try {
			Singer sing = service.showSingerById(152);
			System.out.println(sing);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("---------------------------------------------");
		
		try {
			Singer sing = new Singer();
			sing.setSid(11);
			sing.setSname("Honey Singh");
			sing.setScategory("Rap And Party Songs");
			sing.setFees(2300000.80);
			System.out.println(service.registerOrUpdateSinger(sing));
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("---------------------------------------------");
		
		try {
			String singer_Msg = service.updateSingerFees(152, 2900000.80);
			System.out.println(singer_Msg);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("---------------------------------------------");
		try {
			System.out.println(service.deleteSingerById(102));
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/

		System.out.println("-----------------------------------------------");
		try {
			Singer sing = new Singer();
			sing.setSid(11);
			sing.setSname("Honey Singh");
			System.out.println(service.deleteSinger(sing));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
				System.out.println("-----------------------------------------------");
				try {
					System.out.println(service.removeAllDoctors());
				} catch (Exception e) {
					e.printStackTrace();
				}*/

		/*System.out.println("---------------------------------------------");
		try {
			System.out.println("Singer Count:: " + service.removeSingerAllByIds(Arrays.asList(452, 502)));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*	
			System.out.println("---------------------------------------------");
			try {
				System.out.println(service.removeSingerById(554));
			} catch (Exception e) {
				e.printStackTrace();
			}*/
	}

}
