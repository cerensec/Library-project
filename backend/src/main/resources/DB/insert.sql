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

INSERT INTO `book_item` (`isbn`, `name`, `subject`, `publication_date`, `overview`, `publisher`, `barcode`, `tag`, `title`, `author_id`, `is_reference_only`, `langue_id`, `number_of_pages`, `format_id`, `borrowed`, `loan_period`, `due_date`, `is_overdue`,discriminator) VALUES ('libro1', 'dsqdqs', 'dqsdqsdsq', '2022-11-02', 'dqsdqsd', 'dqsdqsaedadadazdqs', '12345678', 'sc', 'eadsqdsqdqfq', 'Carlos', '1', '1', '100', '1', '2022-11-10', '10', '2022-11-30', '0','BookItem');

INSERT INTO catalog(book_item_id, library_id) VALUES("libro1", 1);