package cm4BookStore;

public class BookStore {

	public static void main(String[] args) {

		Book bookCat = new Book();
		bookCat.setId("B1");
		bookCat.setAuthor("Cam");
		bookCat.setISBN(123);
		bookCat.setName("Sach ve Meo");

		Book bookDog = new Book();
		bookDog.setId("B2");
		bookDog.setAuthor("Sam");
		bookDog.setISBN(234);
		bookDog.setName("Sach ve Cun");

		Book bookCow = new Book();
		bookCow.setId("B3");
		bookCow.setAuthor("Tin");
		bookCow.setISBN(345);
		bookCow.setName("Sach ve Bo");

		Book bookPig = new Book();
		bookPig.setId("B3");
		bookPig.setAuthor("Ton");
		bookPig.setISBN(456);
		bookPig.setName("Sach ve Heo");

		Book[] books = { bookCat, bookDog, bookCow, bookPig };

		Location location1 = new Location();
		location1.setName("Quan 1");
		location1.setId("L1");
		location1.setAddress("12 Vo Thi Sau");

		Location location2 = new Location();
		location2.setName("Quan 3");
		location2.setId("L1");
		location2.setAddress("7 Nam Ki Khoi Nghia");

		Location[] locations = { location1, location2 };

		Customer customer1 = new Customer();
		customer1.setId("C1");
		customer1.setName("Andrew");

		Customer customer2 = new Customer();
		customer2.setId("C2");
		customer2.setName("Georgia");

		Customer customer3 = new Customer();
		customer3.setId("C3");
		customer3.setName("Stephanie");

		Customer[] customers = { customer1, customer2, customer3 };

		BookType type1 = new BookType();
		type1.setId("T1");
		type1.setName("Horror");

		BookType type2 = new BookType();
		type2.setId("T2");
		type2.setName("Comedy");

		BookType type3 = new BookType();
		type3.setId("T4");
		type3.setName("Sci-fi");

		BookType type4 = new BookType();
		type4.setId("T5");
		type4.setName("Thrill");

		BookType[] types = { type1, type2, type3, type4 };

		BookDetail bookCatDetail = new BookDetail();
		bookCatDetail.book = bookCat;
		bookCatDetail.location = location1;
		bookCatDetail.bookType = new BookType[2];
		bookCatDetail.bookType[0] = type1;
		bookCatDetail.bookType[1] = type2;
		bookCatDetail.availableQuantity = 15;

		BookDetail bookDogDetail = new BookDetail();
		bookDogDetail.book = bookDog;
		bookDogDetail.location = location2;
		bookDogDetail.bookType = new BookType[2];
		bookDogDetail.bookType[0] = type3;
		bookDogDetail.bookType[1] = type4;
		bookDogDetail.availableQuantity = 37;

		BookDetail bookCowDetail = new BookDetail();
		bookCowDetail.book = bookCow;
		bookCowDetail.location = location1;
		bookCowDetail.bookType = new BookType[3];
		bookCowDetail.bookType[0] = type4;
		bookCowDetail.bookType[1] = type2;
		bookCowDetail.bookType[2] = type3;
		bookCowDetail.availableQuantity = 9;

		BookDetail bookPigDetail = new BookDetail();
		bookPigDetail.book = bookPig;
		bookPigDetail.location = location1;
		bookPigDetail.bookType = new BookType[3];
		bookPigDetail.bookType[0] = type1;
		bookPigDetail.bookType[1] = type3;
		bookPigDetail.bookType[2] = type4;
		bookPigDetail.availableQuantity = 8;

		BookDetail[] bookDetails = { bookCatDetail, bookDogDetail, bookCowDetail, bookPigDetail };

		BorrowReturnDetail detail1 = new BorrowReturnDetail(bookCat, customer1);
		detail1.setBorrowed(true);
		detail1.setBorrowDate("18-03-2023");
		detail1.setReturned(true);
		detail1.setReturnDate("20-03-2023");

		BorrowReturnDetail detail2 = new BorrowReturnDetail(bookCow, customer1);
		detail2.setBorrowed(true);
		detail2.setBorrowDate("18-03-2023");
		detail2.setReturned(true);
		detail2.setReturnDate("15-03-2023");

		BorrowReturnDetail detail3 = new BorrowReturnDetail(bookDog, customer1);
		detail3.setBorrowed(true);
		detail3.setBorrowDate("01-03-2023");
		detail3.setReturned(false);

		BorrowReturnDetail detail4 = new BorrowReturnDetail(bookDog, customer2);
		detail4.setBorrowed(true);
		detail4.setBorrowDate("15-02-2023");
		detail4.setReturned(true);
		detail4.setReturnDate("30-03-2023");

		BorrowReturnDetail detail5 = new BorrowReturnDetail(bookCow, customer3);
		detail5.setBorrowed(true);
		detail5.setBorrowDate("23-04-2023");
		detail5.setReturned(true);
		detail5.setReturnDate("30-04-2023");

		BorrowReturnDetail[] borrowReturnDetails = { detail1, detail2, detail3, detail4, detail5 };

		System.out.println("1. Borrow list");
		for (Customer customer : customers) {
			System.out.println("- " + customer.getName() + " :");

			for (BorrowReturnDetail borrowReturnDetail : borrowReturnDetails) {
				if (borrowReturnDetail.customer == customer) {

					System.out.println(borrowReturnDetail.book.getName() + " on " + borrowReturnDetail.getBorrowDate());
				}
			}
		}
		System.out.println("\n\n\n");

		System.out.println("2. Borrow and return status of a book: ");
		for (Book book : books) {
			System.out.println(book.getName());
			boolean hasDetails = false;
			for (BorrowReturnDetail detail : borrowReturnDetails) {
				if (detail.book == book) {
					hasDetails = true;
					if (detail.getReturnDate() == null) {
						System.out.println("- Borrowed by " + detail.customer.getName() + " on "
								+ detail.getBorrowDate() + " and hasn't been returned yet.");
					} else {
						System.out.println("- Borrowed by " + detail.customer.getName() + " on "
								+ detail.getBorrowDate() + " and returned on " + detail.getReturnDate() + ".");

					}

				}

			}
			if (!hasDetails) {
				System.out.println("No borrow/return record found for this book");

			}
			System.out.println("---");

		}
	}
}
