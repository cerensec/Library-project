import { defineStore } from 'pinia';
import { Author, Format, Language } from '../interfaces';
import { getFormats, getLangs, getAuthors } from '../services';

interface DataState {
    langs: Language[];
    formats: Format[];
    authors: Author[];
}

export const useData = defineStore('data', {
    state: (): DataState => ({
        langs: [],
        formats: [],
        authors: [],
    }),

    actions: {
        async fetchLangs() {
            this.langs = await getLangs();
        },

        async fetchFormat() {
            this.formats = await getFormats();
        },

        async fetchAuthors() {
            this.authors = await getAuthors();
        },

        getLang(lang: string): Language {
            return this.langs[this.langs.findIndex((l) => l.name === lang)];
        },

        getFormat(format: string): Format {
            return this.formats[
                this.formats.findIndex((f) => f.name === format)
            ];
        },

        getAuthor(author: string): Author {
            return this.authors[
                this.authors.findIndex((a) => a.name === author)
            ];
        },
    },
});
