<script setup lang="ts">
import { computed, ComputedRef, onMounted, reactive, ref } from 'vue';
import { Book, BookForm } from '../shared/interfaces';
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

let date = new Date();
const defaultDate  = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDay();

const title = ref(book ? book.name : '');
const subject = ref(book ? book.subject : '');
const overview = ref(book ? book.overview : '');
const publisher = ref(book ? book.publisher : '');
const publicationDate = ref(book ? book.publicationDate : defaultDate);
const langue = ref(book ? book.langue : '');
const numberOfPages = ref(book ? book.numberOfPages : '');
const format = ref(book ? book.format : '');
const referenceOnly = ref(book ? book.referenceOnly : false);


const submitForm = async () => {
    const newBook: BookForm = {
        name: '',
        subject: subject.value,
        overview: overview.value,
        publisher: publisher.value,
        publicationDate: publicationDate.value,
        barcode: '',
        tag: '',
        title: title.value,
        langue: langue.value,
        numberOfPages: parseInt(numberOfPages.value as string),
        format: format.value,
        borrowed: false,
        loanPeriod: 0,
        dueDate: '',
        isOverdue: false,
        referenceOnly: referenceOnly.value
    }
    // const newBook: Book = {id: bookStore.books.length +1, title: title.value, author: author.value, language: language.value, numberOfPages: parseInt(numberOfPages.value as string), format: format.value, resume: 'test' }
    console.log('newBook', newBook);
    // bookStore.addBook(newBook);
    router.push('/manage');
}

</script>

<template>
    <div class="card flex flex-col w-1/3 m-auto relative">
        <router-link to="/manage" class="bg-gray-200 w-6 h-6 rounded-full text-center absolute right-5">
            <i class="fa-solid fa-xmark"></i>
        </router-link>
        <h1 v-if="!loaded" class="text-2xl mb-5">Loading ...</h1>
        <div v-else class="mt-5">
            <h1 v-if="bookId" class="text-2xl mb-5">Edit an existing book</h1>
            <h1 v-else class="text-2xl mb-5">Add a new book</h1>
            <form @submit.prevent="submitForm" class="flex flex-col">
                <div class="flex flex-col">
                    <input required v-model="title" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600" type="text" placeholder="Title">
                </div>
                <div class="flex flex-col">
                    <input required type="text" v-model="subject" placeholder="Subject" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600">
                </div>
                <!-- <div class="flex flex-col">
                    <input required v-model="author"  class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600" type="text" placeholder="Auteur">
                </div> -->
                <div class="flex flex-col">
                    <textarea placeholder="Résumé" type="textarea" v-model="overview" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600"/>
                </div>
                <div class="flex flex-col">
                    <input required type="date" v-model="publicationDate" placeholder="Publication date" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600">
                </div>
                <div class="flex flex-col">
                    <select required id="language" v-model="langue" class="rounded-lg outline outline-2 outline-gray-200 bg-white mb-5">
                        <option selected>Please select a language</option>
                        <option v-for="lang of bookStore.langs" :key="lang.id" :value="lang.name">{{lang.name}}</option>
                    </select>
                </div>
                <div class="flex flex-col">
                    <input required v-model="numberOfPages" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600" type="number" placeholder="Nombre de page">
                </div>
                <div class="flex flex-col">
                    <input required v-model="format" class="rounded-lg outline outline-2 outline-gray-200 mb-5 focus:outline-blue-600" type="text" placeholder="Format">
                </div>
                <div class="flex mb-5">
                    <label class="inline-flex relative items-center cursor-pointer">
                        <input v-model="referenceOnly" type="checkbox" value="" class="sr-only peer">
                        <div class="w-11 h-6 bg-gray-200 rounded-full peer peer-checked:after:translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all peer-checked:bg-blue-600"></div>
                        <span class="ml-3 text-sm font-medium">Reference only</span>
                    </label>
                </div>
                <button class="text-xl py-2 text-white rounded-lg bg-blue-600 hover:bg-blue-700">Valider</button>
            </form>
        </div>
    </div>
</template>


<style scoped>
    input, select, textarea {
        padding: 5px;
    }
</style>