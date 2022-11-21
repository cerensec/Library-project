export interface Book {
    id: number;
    title: string;
    resume: string;
    author: string;
    language: string;
    numberOfPages: number;
    format: string;
}

export interface BookForm extends Partial<Book> {}