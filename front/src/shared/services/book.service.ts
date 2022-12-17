import type { Book, BookForm, Format, Language } from '../interfaces';

const API_URL = '/api/catalog';

export async function getBooks(): Promise<Book[]> {
    return await (await fetch(`${API_URL}/getAll`)).json();
}

export async function getBook(bookId: string): Promise<Book> {
    const book = await (await fetch(`${API_URL}/getById/${bookId}`)).json();
    return book;
}

export async function createBook(book: Book): Promise<Book> {
    console.log(book.isbn);
    try {
        const response = await fetch(`${API_URL}/saveBook`, {
            method: 'POST',
            body: JSON.stringify(book),
            headers: {
                'Content-type': 'application/json',
            },
        });
        return response.json();
    } catch (error) {
        throw error;
    }
}

export async function editBook(bookId: string, book: BookForm): Promise<Book> {
    const updatedBook = await (
        await fetch(`${API_URL}/updateproduct/${bookId}`, {
            method: 'PATCH',
            body: JSON.stringify(book),
            headers: {
                'Content-type': 'application/json',
            },
        })
    ).json();
    return updatedBook;
}

export async function deleteBook(bookId: string): Promise<string> {
    await fetch(`${API_URL}/deleteproduct/${bookId}`, {
        method: 'DELETE',
    });
    return bookId;
}
