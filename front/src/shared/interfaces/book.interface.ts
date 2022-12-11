export interface Book {
    isbn: string;
    name: string; //! not in the form
    subject: string;
    overview: string;
    publisher: string;
    publicationDate: string;
    barcode: string; //! not in the form
    tag: string; //! not in the form
    title: string;
    langue: string;
    numberOfPages: number;
    format: string;
    borrowed: string; //! not in the form
    loanPeriod: number; //! not in the form
    dueDate: string; //! not in the form
    isOverdue: boolean; //! not in the form
    referenceOnly: boolean;
}

export interface BookForm extends Partial<Book> {}
