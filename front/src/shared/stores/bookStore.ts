import { defineStore } from 'pinia';
import { Book, BookForm, Format, Language } from '../interfaces';
import {
    getBooks,
    deleteBook,
    editBook,
    createBook,
    getLangs,
    getBook,
    getFormats,
} from '../services';

interface BookState {
    books: Book[];
    search: string;
    isLoading: boolean;
    needRefresh: boolean;
}

export const useBooks = defineStore('books', {
    state: (): BookState => ({
        books: [],
        search: '',
        isLoading: true,
        needRefresh: false,
    }),
    getters: {
        filteredBooks(state): Book[] {
            return state.books.filter((book) =>
                book.title.toLowerCase().includes(state.search.toLowerCase())
            );
        },
    },
    actions: {
        async fetchBooks() {
            this.isLoading = true;
            this.books = await getBooks();
            this.isLoading = false;
            this.needRefresh = false;
        },

        async deleteBook(bookId: string) {
            const bookIndex = this.books.findIndex(
                (book) => book.isbn === bookId
            );
            if (bookIndex !== -1) {
                await deleteBook(bookId);
                this.books.splice(bookIndex, 1);
            }
            this.needRefresh = true;
        },

        async editBook(bookId: string, bookForm: BookForm) {
            const editedBook = await editBook(bookId, bookForm);
            if (editedBook) {
                this.needRefresh = true;
                const bookIndex = this.books.findIndex(
                    (book) => book.isbn === bookId
                );
                if (bookIndex !== -1) {
                    this.books[bookIndex] = editedBook;
                }
            }
        },

        async addBook(book: Book) {
            const newBook = await createBook(book);
            if (newBook) {
                // this.books.push(newBook);
                this.needRefresh = true;
            }
        },

        getBook(bookId: string): Book {
            return this.books[
                this.books.findIndex((book) => book.isbn === bookId)
            ];
        },

        getLang(lang: string): Language {
            return this.langs[this.langs.findIndex((l) => l.name === lang)];
        },

        getFormat(format: string): Format {
            return this.formats[
                this.formats.findIndex((f) => f.name === format)
            ];
        },
    },
});
