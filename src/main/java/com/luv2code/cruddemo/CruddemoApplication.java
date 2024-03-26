package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return (abc)->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);

		};
	}



	private void deleteInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Deleting  Instructor id: " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 3;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("the associated instructorDetail only: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		/*Instructor instructor =
				new Instructor("Chad","Darby","darby@luv2code.com");
		//create the instructor detail
		InstructorDetail instructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 Code!!!");
		//associate the objects
		instructor.setInstructorDetail(instructorDetail);*/

		// create the instructor
		Instructor instructor =
				new Instructor("Keshav","Kumar","keshav@luv2code.com");
		//create the instructor detail
		InstructorDetail instructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","coding!!!");
		//associate the objects
		instructor.setInstructorDetail(instructorDetail);

		//save the instructor
		//NOTE: This will also save the instructor details object
		//because of CascadeType.ALL
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Done!");
	}

}
