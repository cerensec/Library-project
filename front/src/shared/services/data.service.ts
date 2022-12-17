import { Format, Language, Author } from '../interfaces';

export async function getLangs(): Promise<Language[]> {
    return await (await fetch(`api/language/getAll`)).json();
}

export async function getFormats(): Promise<Format[]> {
    return await (await fetch('api/format/getAll')).json();
}

export async function getAuthors(): Promise<Author[]> {
    return await (await fetch('api/author/getAll')).json();
}
