import type { Book, BookForm } from '../interfaces';

const API_URL = '/api/catalog';

// const book: Book  = { title: "Titre", resume: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Amet repudiandae cumque provident, culpa veniam sit magnam nulla laboriosam perferendis nam, dolore debitis deleniti fuga. Sint corrupti distinctio libero cumque temporibus?", author: "Auteur", id: 1, language: "Français", numberOfPages: 100, format: "Broché" };

// let books: Book[] = [];
// for(let i = 1; i < 11; i++) {
//     const myBook = {title: book.title + i, resume: book.resume, author: book.author, id: i, language: book.language, numberOfPages: Math.random() * (999 - 1) + 1, format: book.format};
//     books.push(myBook);
// }

export async function getBooks(): Promise<Book[]> {
    // return books;
    return await(await fetch(`${API_URL}/getAll`)).json();
}

export async function getBook(bookId: string): Promise<Book> {
    const book = await(await fetch(`${API_URL}/getById/${bookId}`)).json();
    return book;

    // const res = books.find(book => book.id === bookId);
    // if (res) {
    //     return res;
    // } else {
    //     throw new Error('Book not found');
    // }
}

export async function createBook(book: Book) {
    try {
        const response = await fetch(`${API_URL}/savebook`, {
            method: 'POST',
            body: JSON.stringify(book),
            headers: {
                'Content-type': 'application/json'
            }
        });
        return response;
    } catch (error) {
        throw error;
    }
}

export async function editBook(bookId: number, book: BookForm): Promise<Book> {
    const updatedBook = await(await fetch(`${API_URL}/updateproduct/${bookId}`, {
        method: 'PATCH',
        body: JSON.stringify(book),
        headers: {
            'Content-type': 'application/json'
        }
    })).json();
    return updatedBook;
    // const bookIndex = books.findIndex(book => book.id === bookId);
    // if(bookIndex !== -1) {
    //     books[bookIndex] = { ...books[bookIndex], ...book };
    //     return books[bookIndex];
    // } else {
    //     throw new Error('Book not found');
    // }
}

export async function deleteBook(bookId: number): Promise<number> {
    await fetch(`${API_URL}/deleteproduct/${bookId}`, {
        method: 'DELETE'
    })
    return bookId;
    // const index = books.findIndex(book => book.id === bookId);
    // if (index !== -1) {
    //     books.splice(index, 1);
    //     return bookId;
    // } else {
    //     throw new Error('Book not found');
    // }
}

export async function getLangs(): Promise<string[]> {
    return await(await fetch(`api/language/getAll`)).json();
}