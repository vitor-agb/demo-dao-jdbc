package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1 - Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2 - Seller findByDepartmentId ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findbyDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
			
		System.out.println("\n=== Test 3 - Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		/*
		System.out.println("\n=== Test 4 - Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New ID = " + newSeller.getId());
		*/
		
		System.out.println("\n=== Test 5 - Seller Update ===");
		seller = sellerDao.findById(8);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
	}

	}
