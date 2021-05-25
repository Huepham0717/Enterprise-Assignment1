# EEET2580 - Enterprise App Dev (2021A) Assignment by Group 8

Lecturer: Nguyen Ngoc Thanh PhD.

Group 8:
Phạm Huỳnh Ngọc Huệ		s3702554
Phạm Thành Đạt			s3678437
Park Anh Kiệt			s3681475
Hoàng Trần Tuấn Ngọc	s3681441

This application is a member-only online store. At time of submission, implemented functionalities include:
	- Responsive front-end layout that rearranges itself to fit on any screen size.
	- Product page front-end that auto-populate elements based on data from back-end. No redundant elements.
	- Account registration.
	- Account password encryption.
	- Account activation & ownership verification through email.
	- Account info modification.
	- Sign in & sign out.
	- Adding products to cart (only for users who are signed in).
	- Deleting products in cart.
	- Session awareness through sessionStorage to ensure users cannot access member-only pages until they sign in.
	- Automatically created databases to contain account data, product data and cart data. Product database is auto-populated and can be modified at runtime.
	- REST APIs and plain JavaScript logic to communicate between front-end and back-end. Allows front-end to trigger CRUD operations on back-end. Allows back-end to send data to front-end to serve to user.
	- User-friendly response messages.
	- User input validation.

Powering those features are these technologies:
	- Bootstrap 4 for front-end design.
	- Spring Boot for back-end application and request layers.
	- Spring Data JPA for interfacing between Spring Boot and database.
	- PostgreSQL for database.
	- Languages: Java, SQL, HTML, CSS, JavaScript.

## Prerequisites and Dependencies

In order to run this app, you will need to install:
	- Java Dev Kit 16
	- Apache Maven
	- PostgreSQL with pgAdmin 4
	- JetBrains IntelliJ IDEA
	- MailDev
	- Microsoft Visual Studio Code with LiveServer extension
	- Postman

## Usage

STEP 1:
	- Clone this repo.

STEP 2:
	- Open the "Enterprise-Assignment1" AS A FOLDER in Visual Studio Code.
	- Open the "Enterprise-Assignment1/backend" folder AS A PROJECT in IntelliJ IDEA.

STEP 3:
	- In IntelliJ IDEA, look for "pom.xml" in the project file. 
		- Right-click this file -> Maven -> Reload Project. 
		- Choose "Trust Project" if prompted. 
		- Then open src/main/resources/application.properties. Replace the password in "spring.datasource.password=password" with the password of your PostgreSQL databse. 
		- Then run src/main/java/com.example.demo/DemoApplication.java.
	- In Visual Studio Code, find and open "Home.html". Right click and choose "Open with LiveServer".
	
STEP 4:
	- A new browser tab should appear, showing you the homepage. If not, open a new browser tab and go to this link: http://127.0.0.1:5500/HTML/Register.html
	
STEP 5: 
	- Congratulations! You can now use this app. Please keep in mind that you will not be able to add products to cart until you sign in.

## Acknowledgements
"Spring Boot Tutorial | Full Course [2021] [NEW]"
https://youtu.be/9SGDpanrc8U

"Java Tutorial - Complete User Login and Registration Backend + Email Verification"
https://youtu.be/QwQuro7ekvc

"Spring Boot Shopping Cart Tutorial with MySQL Database, Thymeleaf, Bootstrap and jQuery"
https://youtu.be/rFSxmKen6aQ

"Build a Full Stack Reddit Clone with – Spring boot and Angular – Part 3"
https://programmingtechie.com/2019/11/08/build-a-full-stack-reddit-clone-with-spring-boot-and-angular-part-3/

"Bootstrap 4 Tutorial"
https://www.w3schools.com/bootstrap4/

"How to create product slider with bootstrap"
https://youtu.be/X4Ae4HBGzZw

"Hướng Dẫn Xây Dựng Trang Shopping Cart Bằng HTML, CSS Và Javascript"
https://www.thanhlongdev.com/huong-dan-xay-dung-mot-shopping-cart-bang-html-css-javascript/

"Carousel"
https://getbootstrap.com/docs/4.0/components/carousel/#with-controls

"JavaScript Tutorial"
https://www.w3schools.com/js/
