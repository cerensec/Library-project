use librarydb;

INSERT INTO langue(name) VALUES("English");
INSERT INTO langue(name) VALUES("French");
INSERT INTO langue(name) VALUES("German");
INSERT INTO langue(name) VALUES("Spanish");
INSERT INTO langue(name) VALUES("Italian");
INSERT INTO account_state(name) VALUES("Active");
INSERT INTO account_state(name) VALUES("Frozen");
INSERT INTO account_state(name) VALUES("Closed");

INSERT INTO format(name) VALUES("Paperback");
INSERT INTO format(name) VALUES("Hardcover");
INSERT INTO format(name) VALUES("Audiobook");
INSERT INTO format(name) VALUES("Audio CD");
INSERT INTO format(name) VALUES("MP3 CD");
INSERT INTO format(name) VALUES("PDF");

INSERT INTO library(name,address) VALUES("La Ceiba", "12 Avenue Doyen Louis Weil");

INSERT INTO author(name, biography, birth_date) VALUES("Carlos", "Extranjero que viene de El Salvador", "2001-07-28");
INSERT INTO author(name, biography, birth_date) VALUES("Nathan", "Franco-Français", "2001-02-11");

INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro1', 'Death of the Giant Ferret', 'Fantasy', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Death of the Giant Ferret', 'Carlos', '1', '3', '432', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro2', 'Point of Death', 'Crime', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Point of Death', 'Carlos', '1', '1', '123', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro3', 'The Oriental Paper', 'Mystery', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'The Oriental Paper', 'Carlos', '1', '1', '423', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro4', 'The Shadows in the Night', 'Fantasy', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'The Shadows in the Night', 'Carlos', '1', '1', '643', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro5', 'Death of the Chinese Shih Tzu', 'Mystery', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Death of the Chinese Shih Tzu', 'Carlos', '1', '1', '945', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro6', 'Temptation of the Knight', 'Romance', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Temptation of the Knight', 'Carlos', '1', '1', '34', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro7', 'Polar Twin', 'Sci-fi', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Polar Twin', 'Carlos', '1', '2', '100', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro8', 'The Beast in the Smoke', 'Crime', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'The Beast in the Smoke', 'Nathan', '1', '3', '145', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro9', 'Game of Poseidon', 'Fantasy', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Game of Poseidon', 'Nathan', '1', '3', '532', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro10', 'Death of the Shrieking Beast', 'Mystery', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Death of the Shrieking Beast', 'Nathan', '1', '1', '612', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro11', 'Buff Best', 'Romance', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Buff Best', 'Nathan', '1', '4', '234', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');
INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_name`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro12', 'Oceans of Mars', 'Sci-fi', '2022-11-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor. Cras elementum ultrices diam', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'Oceans of Mars', 'Nathan', '1', '1', '873', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');

INSERT INTO catalog(book_item_id, library_id) VALUES("libro1", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro2", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro3", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro4", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro5", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro6", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro7", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro8", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro9", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro10", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro11", 1);
INSERT INTO catalog(book_item_id, library_id) VALUES("libro12", 1);

INSERT INTO account(username, password, role, opened, state_id) VALUES("admin", "admin", "admin", "2022-12-09", 1);
INSERT INTO account(username, password, role, opened, state_id) VALUES("user", "user", "user", "2022-12-09", 1);

INSERT INTO author_books(author_name, books_isbn) VALUES("Carlos", "libro1");
INSERT INTO author_books(author_name, books_isbn) VALUES("Carlos", "libro2");
INSERT INTO author_books(author_name, books_isbn) VALUES("Carlos", "libro3");
INSERT INTO author_books(author_name, books_isbn) VALUES("Carlos", "libro4");
INSERT INTO author_books(author_name, books_isbn) VALUES("Carlos", "libro5");
INSERT INTO author_books(author_name, books_isbn) VALUES("Carlos", "libro6");
INSERT INTO author_books(author_name, books_isbn) VALUES("Carlos", "libro7");
INSERT INTO author_books(author_name, books_isbn) VALUES("Nathan", "libro8");
INSERT INTO author_books(author_name, books_isbn) VALUES("Nathan", "libro9");
INSERT INTO author_books(author_name, books_isbn) VALUES("Nathan", "libro10");
INSERT INTO author_books(author_name, books_isbn) VALUES("Nathan", "libro11");
INSERT INTO author_books(author_name, books_isbn) VALUES("Nathan", "libro12");