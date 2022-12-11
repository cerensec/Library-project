import { defineStore } from "pinia";
import { Book, BookForm } from "../interfaces";
import { getBooks, deleteBook, editBook, createBook, getLangs, getBook } from "../services";

interface BookState {
    books: Book[];
    search: string;
    isLoading: boolean;
    needRefresh: boolean;
    langs: string[];
}

export const useBooks = defineStore('books', {
    state: ():BookState  => ({
        books: [],
        search: '',
        isLoading: true,
        needRefresh: false,
        langs: []
    }),
    getters: {
        filteredBooks(state): Book[] {
            return state.books.filter(book => book.title.toLowerCase().includes(state.search.toLowerCase()));
        }
    },
    actions: {
        async fetchBooks() {
            this.isLoading = true;
            this.books = await getBooks();
            this.langs = await getLangs();
            this.isLoading = false;
            this.needRefresh = false;
        },

        async deleteBook(bookId: number) {
            const bookIndex = this.books.findIndex(book => book.id === bookId);
            if(bookIndex !== -1) {
               await deleteBook(bookId);
               this.books.splice(bookIndex, 1);
            }
            this.needRefresh = true;
        },

        async editBook(bookId: number, bookForm: BookForm) {
            const editedBook = await editBook(bookId, bookForm);
            if(editedBook) {
                this.needRefresh = true;
                const bookIndex = this.books.findIndex(book => book.id === bookId);
                if(bookIndex !== -1) {
                    this.books[bookIndex] = editedBook;
                }
            }
        },

        async addBook(book: Book) {
            const newBook = await createBook(book);
            if(newBook) {
                // this.books.push(newBook);
                this.needRefresh = true;
            }
        },

        getBook(bookId: string): Book {
            return this.books[this.books.findIndex(book => book.isbn === bookId)];
        }
    }
})