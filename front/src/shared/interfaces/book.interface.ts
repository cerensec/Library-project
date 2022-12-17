import { Author } from './author.interface';
import { Format, Language } from './data.interface';

export interface Book {
    isbn: string;
    name: string;
    subject: string;
    overview: string;
    publisher: string;
    publicationDate: string;
    barcode: string;
    tag: string;
    title: string;
    author: Author;
    langue: Language;
    numberOfPages: number;
    format: Format;
    borrowed: string;
    loanPeriod: number;
    dueDate: string;
    isOverdue: boolean;
    isReferenceOnly: boolean;
}

export interface BookForm extends Partial<Book> {}
