<script setup lang="ts">
import { computed, ComputedRef, onMounted, reactive, ref } from 'vue';
import { Book } from '../shared/interfaces';
import { useRoute } from 'vue-router';
import { getBook, getBooks } from '../shared/services';
import { useBooks } from '../shared/stores/bookStore';
import { router } from '../router';


const route = useRoute();
let book: Book | null = null
let bookId: number | null = null;
let loaded = false;

const bookStore = useBooks();

if(route.params.bookId) {
    bookId = parseInt(route.params.bookId as string);
    book = bookStore.getBook(bookId);
    loaded = true;
} else {
    loaded = true;
}

const title = ref(book ? book.title : '');
const author = ref(book ? book.author : '');
const language = ref(book ? book.language : '');
const numberOfPages = ref(book ? book.numberOfPages : '');
const format = ref(book ? book.format : '');


const submitForm = async () => {
    const newBook: Book = {id: bookStore.books.length +1, title: title.value, author: author.value, language: language.value, numberOfPages: parseInt(numberOfPages.value as string), format: format.value, resume: 'test' }
    bookStore.addBook(newBook);
    router.push('/manage');
}

</script>

<template>
    <div class="card flex flex-col w-1/3 m-auto relative">
        <router-link to="/manage" class="bg-gray-200 w-6 h-6 rounded-full text-center absolute right-5">
            <i class="fa-solid fa-xmark"></i>
        </router-link>
        <h1 v-if="!loaded" class="text-2xl mb-5">Chargement ...</h1>
        <div v-else class="mt-5">
            <h1 v-if="bookId" class="text-2xl mb-5">Editer un livre existant</h1>
            <h1 v-else class="text-2xl mb-5">Ajouter un nouveau livre</h1>
            <form @submit.prevent="submitForm" class="flex flex-col">
                <div class="flex flex-col">
                    <input required v-model="title" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600" type="text" placeholder="Titre">
                </div>
                <div class="flex flex-col">
                    <input required v-model="author"  class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600" type="text" placeholder="Auteur">
                </div>
                <div class="flex flex-col">
                    <select required id="language" v-model="language" class="rounded-lg outline outline-2 outline-gray-200 bg-white mb-5">
                        <option selected value="french">Français</option>
                        <option value="english">Anglais</option>
                        <option value="german">Allemands</option>
                        <option value="spanish">Espagnol</option>
                        <option value="italian">Italien</option>
                    </select>
                </div>
                <div class="flex flex-col">
                    <input required v-model="numberOfPages" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600" type="number" placeholder="Nombre de page">
                </div>
                <div class="flex flex-col">
                    <input required v-model="format" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600" type="text" placeholder="Format">
                </div>
                <button class="text-xl py-2 text-white rounded-lg bg-blue-600 hover:bg-blue-700">Valider</button>
            </form>
        </div>
    </div>
</template>


<style scoped>
    input, select{
        padding: 5px;
    }
</style>