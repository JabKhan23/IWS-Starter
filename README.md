
# IMS - Starter - Jab


This project hosts a system where the user can create and view orders. They will be able to create a profile as well.
=======
This project hosts an Inventory Management System where the user can create and view orders. The application will be tested and will have a coverage of at least 80.

## Getting Started

1. Clone the repo to your local machine
2. Running the jar file that comes with the repo

You might need to check if you have admin access to command prompt. It should run fine without it.

### Prerequisites

The following software will need to be installed to get the program running succesfully
=======


```
Version Control System - Git
Source Code Management - GitHub
Kanban Board - Jira
Database - MySQL Server 5.7+ (local or cloud hosted)
Back-end Programming Language - Java
Build Tool - Maven
Unit Testing - JUnit
```

The project should run independently from using these tools. At the very least, please have the latest version of mySQL installed.

### Installing

A step by step series of examples that tell you how to get a development env running


```
In order to get things running, you will need to have Eclispe or similar to access the development area. You can then see the IMS project and look at how I developed it. Most of the methods are self-explanatory but there will be comments around.  
```

```
There is also a jar file in target that can be ran in CMD. However if running to test the package. It might be worth updating the database if not already.
```

This is the Runner Script as an example
```
public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		IMS ims = new IMS();
		ims.imsSystem();
		LOGGER.info("Thank you for using this service. Goodbye");
	}

}

```

## Running the tests

The tests can be ran from the development area. These tests check if the software can function independently or with a database

### Unit Tests 

Unit tests checks if the system runs and the code can be read. 

A brief example can be found below for the Customer class.

```
	@Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott";
		final Customer created = new Customer(F_NAME, L_NAME);
		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
```

### Integration Tests 
These test if the database is working with the application so it sends dummy results to a test schema within SQL. A brief example can be found below

```

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Customer(3L, "jordan", "harrison"));
		assertEquals(expected, DAO.readAll());
	}
```

### And coding style tests

Coding styles test how your code is implemented and if there could be any improvements. 

```
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
```

## Deployment


This has been built with Maven in mind and tested to over 80% coverage.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Jira link

The Jira link can be found here [Jira](https://jabkhan.atlassian.net/jira/software/projects/SCFPJ/boards/2/roadmap?selectedIssue=SCFPJ-14).

## Documentation

The Documentation should be all added to the main branch - pictures, excel and powerpoing documents are located there.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Jabaran Khan** - *Updated framework* - [JabKhan23](https://github.com/JabKhan23)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Help from QA, StackOverflow, w3Schools for providing the framework to get the code functioning
* Thanks
# IWS-Starter


