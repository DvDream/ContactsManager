package com.spring.datajpa.repository;
import java.util.List;
import com.spring.datajpa.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	public List<Contact> findByNameContaining(String name);
		
		@Query(value = "SELECT * FROM contacts WHERE "
				+ "MATCH(surname,name,phone_number, address, geo_data, other_info)"
				+ "AGAINST(?1)",
				nativeQuery = true)
		public List<Contact> full_search(String keyword);
		
		@Query(value = "SELECT * FROM contacts WHERE phone_number = (?1)",
				nativeQuery = true)
		public List<Contact> number_search(String phone_num);
	
}


